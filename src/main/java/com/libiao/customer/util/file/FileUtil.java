package com.libiao.customer.util.file;

import com.alibaba.fastjson.JSONObject;
import com.aspose.cells.PdfSaveOptions;
import com.aspose.cells.Workbook;
import com.aspose.words.Document;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.VerticalAlignment;
import com.libiao.customer.dal.model.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

//import javafx.util.Pair;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;



public class FileUtil {

    private static final String[] WORD = {"doc", "docx"}; // word转pdf

    private static final String[] EXCEL = {"xls", "xlsx"}; // excel转pdf, 暂时只支持xlsx类型的excel表

    private static final String[] PDF = {"pdf"};

    private static final String TYPE_WORD = "TYPE_WORD"; // 文档

    private static final String TYPE_EXCEL = "TYPE_EXCEL"; // excel

    private static final String TYPE_PDF = "TYPE_PDF"; // pdf

    private static final String TYPE_OTHER = "TYPE_OTHER"; // 其他类型

    private static final String BASE_FILE_PATH = "/home/lbfile/certification/";

    public static String buildFilePath(MultipartFile file){
        String fileName = file.getOriginalFilename();
        String path = BASE_FILE_PATH + fileName;
        return path;
    }

    public static String buildFilePath(String fileName){
        String path = BASE_FILE_PATH + fileName;
        return path;
    }

    /**
     *  获取文件类型
     */

    public static String getFileType(String fileName){
        if(judge(WORD, fileName)){
            return TYPE_WORD;
        }
        if(judge(EXCEL, fileName)){
            return TYPE_EXCEL;
        }
        if(judge(PDF, fileName)){
            return TYPE_PDF;
        }
        return TYPE_OTHER;

    }


    /**
     * 判断类型是否包含
     * @param fileTypes
     * @param fileName
     * @return
     */
    public static boolean judge(String[] fileTypes, String fileName){
        for(String type: fileTypes){
            if(fileName.endsWith(type)){
                return true;
            }
        }
        return false;
    }


    /**
     * 判断证书
     * @return
     */
    public static boolean judgeLicense(String fileType){
        boolean result = false;
        try{
            InputStream is = FileUtil.class.getClassLoader().getResourceAsStream("license.xml");
            if(fileType.equals(TYPE_WORD)){
                com.aspose.words.License license = new com.aspose.words.License();
                license.setLicense(is);
                result = true;
            }
            if(fileType.equals(TYPE_EXCEL)){
                com.aspose.cells.License license = new com.aspose.cells.License();
                license.setLicense(is);
                result = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 将文件转为pdf
     * @param filePath
     * @return 返回文件的路径
     */
    public static String toPdf(String filePath) throws Exception {
        File file = new File(filePath);
        if(file.exists() == false){
            throw new FileNotFoundException(); // 抛出文件没找到的异常
        }
        String fileType = getFileType(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        String[] split= filePath.split("\\.");
        String destFilePath = filePath.substring(0, filePath.length() - split[split.length - 1].length()) + "pdf";
        if(fileType.equals(TYPE_WORD)){
            wordToPdfStream(fileInputStream, new File(destFilePath));
            return destFilePath;
        }else if(fileType.equals(TYPE_EXCEL)){
            excelToPdfStream(fileInputStream, new File(destFilePath));
            return destFilePath;
        }else if(fileType.equals(TYPE_PDF)){
            return destFilePath;
        }else{
            return null;
        }
    }

    /**
     * word到pdf流
     * @param in
     * @return
     * @throws Exception
     */
    private static void wordToPdfStream(InputStream in, File destFile) throws Exception {
        if(judgeLicense(TYPE_WORD) == false) return;
        Document doc = new Document(in);
        FileOutputStream fileOutputStream = new FileOutputStream(destFile);
        doc.save(fileOutputStream, com.aspose.words.SaveFormat.PDF);
        in.close();
        fileOutputStream.close();
    }

    /**
     * excel到pdf流
     * @param in
     * @return
     * @throws Exception
     */
    private static void excelToPdfStream(InputStream in, File destFile) throws Exception {
        if(judgeLicense(TYPE_EXCEL) == false) return;
        Workbook excel = new Workbook(in);
        FileOutputStream fileOutputStream = new FileOutputStream(destFile);
        PdfSaveOptions pdfSaveOptions = new PdfSaveOptions();
        pdfSaveOptions.setOnePagePerSheet(true);
        excel.save(fileOutputStream, pdfSaveOptions);
        in.close();
        fileOutputStream.close();

    }


    /**
     * 将报价单生成pdf
     * @param testQuotation
     *
     */
    /*public static File exportTestQuotation(TestQuotation testQuotation, String outpath) throws IOException {

        PdfWriter writer = new PdfWriter(outpath);
        com.itextpdf.kernel.pdf.PdfDocument pdfDocument = new com.itextpdf.kernel.pdf.PdfDocument(writer);
        com.itextpdf.layout.Document document = new com.itextpdf.layout.Document(pdfDocument, PageSize.A4);
        document.setMargins(28, 28, 15, 28);



        Image libiaoLogo = new Image(ImageDataFactory.create("src/main/resources/img/libiao.png"));
        libiaoLogo.setHeight(UnitValue.createPointValue(48));
        libiaoLogo.setHeight(UnitValue.createPointValue(48));
        libiaoLogo.setFixedPosition(1, 30, 765); // 第一页固定位置
        document.add(libiaoLogo);

        PdfFont companyTitleFont = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H");
        Style companyTitleFontStyle = new Style();
        companyTitleFontStyle.setFont(companyTitleFont).setBold().setFontSize(15);

        PdfFont quotationTitleFont = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H");
        Style quotationTitleFontStyle = new Style();
        quotationTitleFontStyle.setFont(quotationTitleFont).setBold().setFontSize(14);

        com.itextpdf.layout.element.Paragraph companyCNPG = new com.itextpdf.layout.element.Paragraph("立标检测认证（宁波）有限公司");
        companyCNPG.addStyle(companyTitleFontStyle); // 加粗，15号
        companyCNPG.setHorizontalAlignment(HorizontalAlignment.CENTER);

        com.itextpdf.layout.element.Paragraph companyENPG = new com.itextpdf.layout.element.Paragraph("LTI  Testing  &  Certification  NingBo  Co.,  Ltd");
        companyENPG.addStyle(companyTitleFontStyle);
        companyENPG.setHorizontalAlignment(HorizontalAlignment.CENTER);

        com.itextpdf.layout.element.Paragraph quotationTitlePG = new  com.itextpdf.layout.element.Paragraph("测试报价单（Quotation）");
        quotationTitlePG.addStyle(quotationTitleFontStyle);
        quotationTitlePG.setHorizontalAlignment(HorizontalAlignment.CENTER);

        Table titleTable = new Table(1);
        Cell titleCell = new Cell();
        titleCell.setBorderTop(new SolidBorder(1.4f));
        titleCell.setBorderLeft(new SolidBorder(1.4f));
        titleCell.setBorderRight(new SolidBorder(1.4f));
        titleCell.add(companyCNPG);
        titleCell.add(companyENPG);
        titleCell.add(quotationTitlePG);
        titleCell.setTextAlignment(TextAlignment.CENTER); // 文字居中
        titleCell.setPaddingBottom(10); // 设置测试报价单离表格距离

        titleTable.addCell(titleCell);
        titleTable.setWidth(UnitValue.createPercentValue(100)); // 撑开
        document.add(titleTable);

        PdfFont contentFont = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H");
        Style contentFontStyle = new Style();
        contentFontStyle.setFont(contentFont).setFontSize(11);

        // pdf table
        Table table1 = new Table(UnitValue.createPercentArray(new float[]{6.0f, 9.0f, 4.0f, 9.0f}));
        table1.setWidth(UnitValue.createPercentValue(100));
        table1.setFixedLayout();

        table1.setBorderBottom(Border.NO_BORDER);
        document.add(table1);

        Table table2 = new Table(UnitValue.createPercentArray(new float[]{2.0f, 4.0f, 3.0f, 3.0f, 3.0f, 4.0f, 3.0f, 3.0f, 3.0f}));
        table2.setWidth(UnitValue.createPercentValue(100));
        table2.setFixedLayout();
        java.util.List<String> testQuotationItems = getTestQuotationItems(testQuotation);
        for(String item : testQuotationItems){
            Paragraph itemPG = new Paragraph(item);
            itemPG.addStyle(contentFontStyle);
            Cell itemCell = new Cell();
            itemCell.add(itemPG);
            itemCell.setTextAlignment(TextAlignment.CENTER);
            itemCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
            itemCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
            table2.addCell(itemCell);
        }
        table2.setBorderLeft(new SolidBorder(1.4f));
        table2.setBorderRight(new SolidBorder(1.4f));
        table2.setBorderBottom(Border.NO_BORDER);
        document.add(table2);

        Table table3 = new Table(UnitValue.createPercentArray(new float[] {2f,20f,3f,3f}));
        table3.setWidth(UnitValue.createPercentValue(100));
        table3.addCell(new Cell().add(new Paragraph("备注").addStyle(contentFontStyle)));
        table3.addCell(new Cell().add(new Paragraph(testQuotation.getRemark()).addStyle(contentFontStyle)));
        table3.addCell(new Cell().add(new Paragraph("总费用").addStyle(contentFontStyle)));
        table3.addCell(new Cell().add(new Paragraph(String.valueOf(testQuotation.getTotalCost())).addStyle(contentFontStyle)));
        table3.setBorderTop(Border.NO_BORDER);
        table3.setBorderLeft(new SolidBorder(1.4f));
        table3.setBorderRight(new SolidBorder(1.4f));
        table3.setBorderBottom(Border.NO_BORDER);
        document.add(table3);


        Table table4 = new Table(1);
        table4.setWidth(UnitValue.createPercentValue(100));

        PdfFont remarkFont = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H");
        Style remarkFontStyle = new Style();
        remarkFontStyle.setFont(remarkFont).setFontSize(10);

        PdfFont remarkBoldFont = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H");
        Style remarkBoldFontStyle = new Style();
        remarkBoldFontStyle.setFont(remarkBoldFont).setFontSize(10).setBold();

        Cell remarkCell = new Cell();

        Paragraph p0 = new Paragraph("注意 Remark：").addStyle(remarkBoldFontStyle);
        Paragraph p1 = new Paragraph("1. 在我方按照经客户确认过的信息颁发报告后。如客户有修改要求，我方将按照RMB 50 元/次的标准收取报告修改费。").addStyle(remarkFontStyle);
        Paragraph p2 = new Paragraph("2. 样品开案之前需 100% 全款到帐，以收到付款凭证为准。如有延迟，我方将顺期延迟发送检测报告！").addStyle(remarkFontStyle);
        Text p31 = new Text("3. 开案必备条件").addStyle(remarkFontStyle);
        Text p32 = new Text("（特别提醒：因提交以下资料滞后而影响测试周期的，责任由客户自己承担）").addStyle(remarkBoldFontStyle);
        Text p33 = new Text("。").addStyle(remarkFontStyle);
        Paragraph p3 = new Paragraph();
        p3.add(p31);
        p3.add(p32);
        p3.add(p33);
        Paragraph pa = new Paragraph("    a. 送样要求：样品量应满足测试所需。").addStyle(remarkFontStyle);
        Paragraph pb = new Paragraph("    b. 回签确认该报价单。").addStyle(remarkFontStyle);
        Paragraph pc = new Paragraph("    c. 提交确认、签字了的测试申请表。").addStyle(remarkFontStyle);
        Paragraph p4 = new Paragraph("4. 该报价自生效之日起一个月内有效，一个月后未开始测试的或未被申请退回的样品会被自动处理掉。").addStyle(remarkFontStyle);
        Paragraph p5 = new Paragraph("5. 当仅依据产品图片或测试相关资料进行报价的，报价和测试周期仅供参考，最终需以实际收到样品后确定的报价及测试周期为准。").addStyle(remarkFontStyle);
        Paragraph p6 = new Paragraph("6. 上述部分项目可能会分包至我们的分包实验室进行测试。").addStyle(remarkFontStyle);
        Paragraph p7 = new Paragraph("7. 本公司对测试报告只承担被证实的过失责任，并且赔偿金额不超过测试费用的 5 倍。").addStyle(remarkFontStyle);
        Paragraph p8 = new Paragraph("8. 报告语言：如需出具英文报告，请提供相关的英文信息（如公司抬头，地址，样品及其零部件的名称），若在确认报价单前未能提供，我司将默认为自行翻译。届时若因翻译问题而需修改报告，我司将须收取报告修改费用。").addStyle(remarkFontStyle);
        Paragraph p9 = new Paragraph("9. 报告方式：如需提供纸质报告，我方将收取RMB 100元/份的纸质报告费。").addStyle(remarkFontStyle);


        remarkCell.add(p0);
        remarkCell.add(p1);
        remarkCell.add(p2);
        remarkCell.add(p3);
        remarkCell.add(pa);
        remarkCell.add(pb);
        remarkCell.add(pc);
        remarkCell.add(p4);
        remarkCell.add(p5);
        remarkCell.add(p6);
        remarkCell.add(p7);
        remarkCell.add(p8);
        remarkCell.add(p9);

        table4.addCell(remarkCell);
        document.add(table4);

        PdfFont signatureFont = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H");
        Style signatureFontStyle = new Style();
        signatureFontStyle.setFont(signatureFont).setFontSize(12);

        Table table5 = new Table(1);
        table5.setWidth(UnitValue.createPercentValue(100));
        Cell cell5 = new Cell();
        cell5.add(new Paragraph("请将总款付款汇入以下账户").addStyle(contentFontStyle));
        cell5.add(new Paragraph("户          名：" + testQuotation.getBankAccountName()).addStyle(contentFontStyle));
        cell5.add(new Paragraph("账          号：" + testQuotation.getBankAccount()).addStyle(contentFontStyle));
        cell5.add(new Paragraph("银行名称：" + testQuotation.getBankName()).addStyle(contentFontStyle));

        cell5.add(new Paragraph(new Text("\n")));
        cell5.setPaddingLeft(30.0f);
        cell5.setBorderBottom(Border.NO_BORDER);
        table5.setBorderBottom(Border.NO_BORDER);
        table5.addCell(cell5);
        document.add(table5);


        Table table6 = new Table(UnitValue.createPercentArray(new float[]{3.0f, 7.0f, 3.0f, 7.0f}));
        table6.setWidth(UnitValue.createPercentValue(100));
        table6.setFixedLayout();

        String[] table6Keys = new String[]{"申请公司签名\nSignature：", "立标代表签名\nSignature：", "盖        章  \n    Chop：",
                "审核人员签名\nAudit：", "日        期  \n    Date：", "日        期  \n    Date："};
        for(int x = 0; x < table6Keys.length; x++){
            Cell keyCell = new Cell().add(new Paragraph(table6Keys[x]).addStyle(contentFontStyle));
            keyCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
            keyCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
            if(x % 2 == 0){
                keyCell.setPaddingLeft(20.0f);
                keyCell.setBorderTop(Border.NO_BORDER);
                keyCell.setBorderRight(Border.NO_BORDER);
                keyCell.setBorderBottom(Border.NO_BORDER);
            }else{

                keyCell.setBorderLeft(Border.NO_BORDER);
                keyCell.setBorderRight(Border.NO_BORDER);
                keyCell.setBorderTop(Border.NO_BORDER);
                keyCell.setBorderBottom(Border.NO_BORDER);
            }
            table6.addCell(keyCell);



            Text underLineChunk = new Text("\u00a0 \u00a0  \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0");
            underLineChunk.setUnderline(0.5f, 0f);
            Cell underLineCell = new Cell();

            underLineCell.add(new Paragraph(underLineChunk));
            underLineCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
            underLineCell.setHorizontalAlignment(HorizontalAlignment.CENTER);

            if(x % 2 ==0){
                underLineCell.setBorderLeft(Border.NO_BORDER);
                underLineCell.setBorderRight(Border.NO_BORDER);
                underLineCell.setBorderTop(Border.NO_BORDER);
                underLineCell.setBorderBottom(Border.NO_BORDER);
            }else{
                underLineCell.setBorderLeft(Border.NO_BORDER);
                underLineCell.setBorderTop(Border.NO_BORDER);
                underLineCell.setBorderBottom(Border.NO_BORDER);
            }

            table6.addCell(underLineCell);
        }

        // ---------------------------------------------  以下是为了显示空白   ---------------------------------------------

        Cell footer1 = new Cell().add(new Paragraph(new Text("\n")));
        footer1.setHeight(UnitValue.createPointValue(12.0f));
        footer1.setBorderTop(Border.NO_BORDER);
        footer1.setBorderRight(Border.NO_BORDER);

        Cell footer2 = new Cell().add(new Paragraph(new Text("\n")));
        footer2.setHeight(UnitValue.createPointValue(12.0f));
        footer2.setBorderTop(Border.NO_BORDER);
        footer2.setBorderLeft(Border.NO_BORDER);
        footer2.setBorderRight(Border.NO_BORDER);

        Cell footer3 = new Cell().add(new Paragraph(new Text("\n")));
        footer3.setHeight(UnitValue.createPointValue(12.0f));
        footer3.setBorderTop(Border.NO_BORDER);
        footer3.setBorderLeft(Border.NO_BORDER);
        footer3.setBorderRight(Border.NO_BORDER);

        Cell footer4 = new Cell().add(new Paragraph(new Text("\n")));
        footer4.setHeight(UnitValue.createPointValue(12.0f));
        footer4.setBorderTop(Border.NO_BORDER);
        footer4.setBorderLeft(Border.NO_BORDER);

        table6.addCell(footer1);
        table6.addCell(footer2);
        table6.addCell(footer3);
        table6.addCell(footer4);
        table6.setBorderTop(Border.NO_BORDER);

        // 印章
        ImageData sealImageData = ImageDataFactory.create("src/main/resources/img/lb60.png");
        OverlappingImageTableRenderer overlappingImageTableRenderer = new OverlappingImageTableRenderer(table6, sealImageData);
        table6.setNextRenderer(overlappingImageTableRenderer);

        document.add(table6);
        // ---------------------------------------------  以啥是为了显示空白   ---------------------------------------------

        document.close();
        writer.close();
        return new File(outpath);
    }*/

//    private static List<Pair<String, String>> getTestQuotationAttrs(TestQuotation testQuotation){
//        List<Pair<String, String>> result = new ArrayList<Pair<String, String>>();
//        result.add( new Pair<String, String>("客户 Client",  testQuotation.getClient()));
//        result.add(new Pair<String, String>("报价单编号\nQuotation", testQuotation.getQuotationNum()));
//        result.add(new Pair<String, String>("联络人 Attn", testQuotation.getAttn()));
//        result.add(new Pair<String, String>("公司 From", testQuotation.getFromCom()));
//        result.add(new Pair<String, String>("电话 Tel", testQuotation.getTelClient()));
//        result.add(new Pair<String, String>("电话 Tel", testQuotation.getTelCom()));
//        result.add(new Pair<String, String>("传真Fax", testQuotation.getFaxClient()));
//        result.add(new Pair<String, String>("传真 Fax", testQuotation.getFaxCom()));
//        result.add(new Pair<String, String>("电邮 E-mail", testQuotation.getEmail()));
//        result.add(new Pair<String, String>("报价日期Date", new SimpleDateFormat("yyyy/MM/dd").format(testQuotation.getGmtCreate())));
//        result.add(new Pair<String, String>("发票抬头\nInvocie Title", testQuotation.getInvoiceTitle()));
//        result.add(new Pair<String, String>("报告类型\nReport Type", testQuotation.getReportType()));
//        result.add(new Pair<String, String>("报告邮寄地址\nRe.delivery to", testQuotation.getDeliveryAddress()));
//        result.add(new Pair<String, String>("测试周期", testQuotation.getTestPeroid()));
//        return result;
//    }


    /*private static java.util.List<String> getTestQuotationItems(TestQuotation testQuotation){
        String[] headers = new String[]{
                "序号\nNo.",
                "报告编号\nReport No.",
                "产品名称\nProduct Description",
                "型号\nStyle/Item No.",
                "材质/颜色\nMaterial/Color",
                "测试项目\nTest Item",
                "单价\nUnit Price",
                "测试点数\nQty",
                "测试金额\nAmount(RMB)"
        };
        java.util.List<String> items = new ArrayList<String>(Arrays.asList(headers));
        java.util.List<TestQuotationItem> quotationItems = testQuotation.getTestQuotationItemList();
        int i = 1;
        for(TestQuotationItem testQuotationItem: quotationItems){
            items.add(String.valueOf(i));
            items.add(testQuotationItem.getReportNum());
            items.add(testQuotationItem.getProductDes());
            items.add(testQuotationItem.getStyle());
            items.add(testQuotationItem.getMaterialColor());
            items.add(testQuotationItem.getTestItem());
            items.add(testQuotationItem.getUnitPrice());
            items.add(testQuotationItem.getQty());
            items.add(testQuotationItem.getAmountRmb());
            i += 1;
        }
        String[] feeArr = new String[]{
                "报告费",
                testQuotation.getReportFee(),
                "",
                "快递费",
                testQuotation.getCourierFee(),
                "税费",
                testQuotation.getTaxFee(),
                "折扣",
                testQuotation.getDiscount()
        };
        items.addAll(Arrays.asList(feeArr));
        return items;



    }*/

    public static File exportTestReport(TestReport testReport, String outpath) throws IOException {
        PdfFont coverFont = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H"); // 封面

        PdfFont contentFont = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H"); // 内容
//        Style contentFontStyle = new Style();
//        contentFontStyle.setFont(contentFont).setFontSize(4);

        PdfDocument pdfDoc = new PdfDocument(new PdfReader("检测报告模板.pdf"), new PdfWriter(outpath));
        com.itextpdf.layout.Document document = new com.itextpdf.layout.Document(pdfDoc);

        Map<String, String> map = new HashMap<>();
        JSONObject testReportJSON = (JSONObject) JSONObject.toJSON(testReport); // 转成json对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String testPeriod = sdf.format(testReport.getTestStartDate()) + "-" + sdf.format(testReport.getTestEndDate());
        testReportJSON.put("testPeriod", testPeriod);
        testReportJSON.put("receivingDate", sdf.format(testReport.getReceivingDate()));

        PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);
        Map<String, PdfFormField> fields = form.getFormFields();
        for(String key: testReportJSON.keySet()){
            if(fields.getOrDefault(key, null) != null){
                fields.get(key).setValue(testReportJSON.getString(key));
                fields.get(key).setFontAndSize(contentFont, 10);
            }
        }
        // 设置封面的字体
        fields.get("reportNumCover").setValue(testReportJSON.getString("reportNum")).setFontAndSize(coverFont, 14);
        fields.get("sampleNameCover").setValue(testReportJSON.getString("sampleName")).setFontAndSize(coverFont, 14);
        fields.get("clientCover").setValue(testReportJSON.getString("client")).setFontAndSize(coverFont, 14);

        // 显示动态表格
        form.flattenFields();
        pdfDoc.close();
        document.close();
        return new File(outpath);
    }

    /**
     * 检测报告,这里采用测试报告模板
     * @param testReport
     * @param outpath
     * @return
     * @throws IOException
     * @throws DocumentException
     */
//    public static File exportTestReport(TestReport testReport, String outpath) throws IOException, IllegalAccessException {
//        BaseFont bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
//        Font contentFont = new Font(bfChinese);
//        contentFont.setSize(10);
//
//        Map<String, String> map = new HashMap<>();
//        JSONObject testReportJSON = (JSONObject) JSONObject.toJSON(testReport); // 转成json对象
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
//        String testPeriod = sdf.format(testReport.getTestStartDate()) + "-" + sdf.format(testReport.getTestEndDate());
//        testReportJSON.put("testPeriod", testPeriod);
//        testReportJSON.put("receivingDate", sdf.format(testReport.getReceivingDate()));
//
//        InputStream inputStream = new FileInputStream("检测报告模板.pdf"); // 检测报告模板
//        PdfReader reader = new PdfReader(inputStream);
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        PdfStamper stamper = new PdfStamper(reader, bos);
//
//        stamper.setFormFlattening(true); // 让pdf不可再编辑
//
//        AcroFields form = stamper.getAcroFields();
//        for(String key : testReportJSON.keySet()){
//            form.setField(key, testReportJSON.getString(key));
//        }
//        stamper.close();
//
//        /** 重新读取最后一页，然后将生成的结果保存到最后一页 **/
//        reader = new PdfReader(bos.toByteArray());
//        Rectangle pageSize = reader.getPageSize(1); // 获取页面的大小
//        com.itextpdf.text.Document extraDoc = new com.itextpdf.text.Document(pageSize);
////        ByteArrayOutputStream extraBos = new ByteArrayOutputStream();
//        FileOutputStream fileOutputStream = new FileOutputStream(outpath);
//        PdfWriter writer = PdfWriter.getInstance(extraDoc, fileOutputStream);
//        extraDoc.open();
//        PdfContentByte cbUnder = writer.getDirectContentUnder();
//        PdfImportedPage pageTemplate1 = writer.getImportedPage(reader, 1);
//        PdfImportedPage pageTemplate2 = writer.getImportedPage(reader, 2);
//        extraDoc.newPage();
//        cbUnder.addTemplate(pageTemplate1, 0, 0);
//        extraDoc.newPage();
//        cbUnder.addTemplate(pageTemplate2, 0, 0);
//        extraDoc.newPage();
//
//        // 添加样品描述
//        PdfPTable desTable = new PdfPTable(3);
//        float[] desTableColWidth = {1f, 3f, 3f};
//        desTable.setWidths(desTableColWidth);
//        JSONArray desArray=testReportJSON.getJSONArray("sampleDesc");
//        for(int i = -1; i < desArray.size(); i++){
//            if(i == -1){
//                desTable.addCell(new PdfPCell(new Paragraph("样品编号", contentFont)));
//                desTable.addCell(new PdfPCell(new Paragraph("样品描述", contentFont)));
//                desTable.addCell(new PdfPCell(new Paragraph("取样部位", contentFont)));
//            }else{
//                JSONObject descItem = desArray.getJSONObject(i);;
//                desTable.addCell(new PdfPCell(new Paragraph(descItem.getString("sampleNum"), contentFont)));
//                desTable.addCell(new PdfPCell(new Paragraph(descItem.getString("sampleDes"), contentFont)));
//                desTable.addCell(new PdfPCell(new Paragraph(descItem.getString("sampleLocation"), contentFont)));
//            }
//        }
//        extraDoc.add(new Paragraph("样品描述:\n", contentFont));
//        extraDoc.add(desTable);
//        extraDoc.add( Chunk.NEWLINE );
//
//        // 添加样品检测结果
//        extraDoc.add(new Paragraph("检测结果", contentFont));
//        for(int i = 0; i < testReportJSON.getJSONArray("testExperiment").size(); i++){
//            JSONObject exp = testReportJSON.getJSONArray("testExperiment").getJSONObject(i);
//            extraDoc.add(new Paragraph(String.valueOf(i+1) + "." + exp.getString("title"), contentFont));
//            extraDoc.add(new Paragraph("检测方法：" + exp.getString("method"), contentFont));
//            for(int j = 0; j < exp.getJSONArray("result").size(); j ++){
//                JSONObject result = exp.getJSONArray("result").getJSONObject(j);
//                extraDoc.add(new Paragraph(result.getString("resultDetail"), contentFont));
//                extraDoc.add( Chunk.NEWLINE );
//                PdfPTable resultTable = new PdfPTable(result.getJSONArray("attrs").size());
//                List<String> attrList = new ArrayList<>();
//                for(int k = 0; k < result.getJSONArray("attrs").size(); k ++){
//                    resultTable.addCell(new PdfPCell(new Paragraph(result.getJSONArray("attrs").getJSONObject(k).getString("desc"), contentFont)));
//                    attrList.add(result.getJSONArray("attrs").getJSONObject(k).getString("name"));
//                }
//                for(int l = 0; l < result.getJSONArray("testItems").size(); l ++){
//                    JSONObject testItem = result.getJSONArray("testItems").getJSONObject(l);
//                    for(String attr: attrList){
//                        resultTable.addCell(new PdfPCell(new Paragraph(testItem.getString(attr), contentFont)));
//                    }
//                }
//                extraDoc.add(resultTable);
//                extraDoc.add( Chunk.NEWLINE );
//            }
//        }
//
//
//        extraDoc.add( Chunk.NEWLINE );
//        // 添加样品备注
//        PdfPTable remarkTable = new PdfPTable(2);
//        float[] remarkTableColWidth = {1f, 10f};
//        remarkTable.setWidths(remarkTableColWidth);
//        remarkTable.addCell(new PdfPCell(new Paragraph("备注", contentFont)));
//        remarkTable.addCell(new PdfPCell(new Paragraph(testReportJSON.getJSONObject("testRemark").getString("test"), contentFont)));
//        extraDoc.add(remarkTable);
//
//        /** 重新读取最后一页，然后将生成的结果保存到最后一页 **/
//        extraDoc.close();
//        fileOutputStream.close();
//
//
//        return new File(outpath);
//    }

    /**
     * 生成检测报告二维码图片
     * @return
     */
    private static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }


    /**
     * 生成二维码，返回字节流
     * @param text
     * @param width
     * @param height
     * @return
     * @throws WriterException
     * @throws IOException
     */
    private static byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix,  "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }

    /**
     * 导出申请表
     * @param testApplicationForm
     * @param outPath
     * @return
     */
    public static File exportTestApplicationForm(TestApplicationForm testApplicationForm, String outPath) throws IOException {
//        BaseFont bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
//        InputStream inputStream = new FileInputStream("测试申请表模板new.pdf");
//        PdfReader reader = new PdfReader(inputStream);
//        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(outPath));
//        stamper.setFormFlattening(true);
//
//        AcroFields form = stamper.getAcroFields();
//        JSONObject testApplicationFormJSON = (JSONObject) JSONObject.toJSON(testApplicationForm);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
//        if (testApplicationForm.getReportDate() != null) {
//            testApplicationFormJSON.put("reportDate",
//                sdf.format(testApplicationForm.getReportDate()));
//        }
//        if (testApplicationForm.getRecDate() != null) {
//            testApplicationFormJSON.put("recDate", sdf.format(testApplicationForm.getRecDate()));
//        }
//
//        for(String key: testApplicationFormJSON.keySet()){
//            form.setField(key, testApplicationFormJSON.getString(key));
//        }
//
//        int pageNo = form.getFieldPositions("applicationItems").get(0).page;
//        PdfContentByte pcb = stamper.getOverContent(pageNo);
//        Rectangle signRect = form.getFieldPositions("applicationItems").get(0).position;
//        int column = 8;
//        int row = testApplicationForm.getTestApplicationItemList().size();
//
//        PdfPTable table = new PdfPTable(column);
//        float totalWidth = signRect.getRight() - signRect.getLeft() - 1;
//        float width[] = new float[column];
//        for(int i=0; i<column; i++){
//            if(i == 0){
//                width[i] = 60f;
//            }else{
//                width[i] = (totalWidth - 60) / (column - 1);
//            }
//        }
//        table.setTotalWidth(width);
//        table.setLockedWidth(true);
//        table.setKeepTogether(true);
//        table.setSplitLate(false);
//        table.setSplitRows(true);
//
//        for(int i = 0; i <= row; i++){
//            String[] tempArr = null;
//            if(i == 0){
//                tempArr = new String[]{
//                        "编号\nNo.",
//                        "样品（部位）名称\n(Part Of)Sample Name",
//                        "样品型号\nSample Model",
//                        "材质\n(Sample Description)",
//                        "样品描述\n(Sample Description)",
//                        "测试项目\n(Testing Items)",
//                        "判定依据\nAccording to",
//                        "备注\nRemark"
//                };
//            }else{
//                TestApplicationItem applicationItem = testApplicationForm.getTestApplicationItemList().get(i-1);
//                tempArr = new String[]{
//                        String.valueOf(i+1),
//                        applicationItem.getSampleName(),
//                        applicationItem.getSampleModel(),
//                        applicationItem.getSampleMaterial(),
//                        applicationItem.getSampleDescription(),
//                        applicationItem.getTestingItem(),
//                        applicationItem.getAccordingTo(),
//                        applicationItem.getRemark()
//                };
//            }
//            Font cnFont = new Font(bfChinese);
//            cnFont.setSize(10);
//            Font boldFont = new Font(bfChinese);
//            boldFont.setStyle(Font.BOLD);
//            for(int j = 0; j<column; j++){
//                Paragraph paragraph = new Paragraph(tempArr[j], i ==0 ? boldFont : cnFont);
//                PdfPCell cell = new PdfPCell(paragraph);
//                cell.setBorderWidth(1);
//                cell.setVerticalAlignment(Element.ALIGN_CENTER);
//                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                cell.setLeading(0, (float)1.4);
//                table.addCell(cell);
//            }
//        }
//        table.writeSelectedRows(0, -1, signRect.getLeft(), signRect.getTop(), pcb);
//
//        stamper.close();
//        reader.close();
        return new File(outPath);
    }

    public static File exportTestWorkOrder(TestWorkOrder testWorkOrder, String outPath) throws IOException {
//        BaseFont bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
//        InputStream inputStream = new FileInputStream("C:\\projects\\libiaotest\\工作单模板new.pdf");
//        PdfReader reader = new PdfReader(inputStream);
//        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(outPath));
//        stamper.setFormFlattening(true);
//
//        AcroFields form = stamper.getAcroFields();
//        JSONObject workOrderJSON = (JSONObject) JSONObject.toJSON(testWorkOrder);
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
//
//        workOrderJSON.put("gmtCreate", sdf.format(testWorkOrder.getGmtCreate()));
//        workOrderJSON.put("gmtOutput", sdf.format(testWorkOrder.getGmtOutput()));
//        for(String key : workOrderJSON.keySet()){
//            if(key.equals("busyStatus")){
//                if(workOrderJSON.get(key).toString().equals("100%加急")){
//                    form.setField("busyTotal", "On", true);
//                }
//                if(workOrderJSON.get(key).toString().equals("50%加急")){
//                    form.setField("busyHalf", "On", true);
//                }
//            }
//            form.setField(key, workOrderJSON.get(key).toString());
//        }
//
//        int pageNo = form.getFieldPositions("workOrderItems").get(0).page;
//        PdfContentByte pcb = stamper.getOverContent(pageNo);
//        Rectangle signRect = form.getFieldPositions("workOrderItems").get(0).position;
//        int column = 5;
//        int row = testWorkOrder.getTestWorkOrderItemList().size();
//
//        PdfPTable table = new PdfPTable(column);
//        float totalWidth = signRect.getRight() - signRect.getLeft() - 1;
//        float width[] = new float[column];
//        for(int i=0; i<column; i++){
//            if(i == 0){
//                width[i] = 60f;
//            }else{
//                width[i] = (totalWidth - 60) / (column - 1);
//            }
//        }
//        table.setTotalWidth(width);
//        table.setLockedWidth(true);
//        table.setKeepTogether(true);
//        table.setSplitLate(false);
//        table.setSplitRows(true);
//
//        for(int i = 0; i <= row; i++){
//            String[] tempArr = null;
//            if(i == 0){
//                tempArr = new String[]{
//                        "样品编号",
//                        "样品描述",
//                        "取样部位（位置）",
//                        "测试项目及测试方法",
//                        "备注"
//                };
//            }else{
//                TestWorkOrderItem workOrderItem = testWorkOrder.getTestWorkOrderItemList().get(i-1);
//                tempArr = new String[]{
//                        String.valueOf(i+1),
//                        workOrderItem.getSampleDesc(),
//                        workOrderItem.getSampleLocation(),
//                        workOrderItem.getTestItemsMethod(),
//                        workOrderItem.getRemark()
//                };
//            }
//            Font cnFont = new Font(bfChinese);
//            cnFont.setSize(10);
//            Font boldFont = new Font(bfChinese);
//            boldFont.setStyle(Font.BOLD);
//            for(int j = 0; j<column; j++){
//                Paragraph paragraph = new Paragraph(tempArr[j], i ==0 ? boldFont : cnFont);
//                PdfPCell cell = new PdfPCell(paragraph);
//                cell.setBorderWidth(1);
//                cell.setVerticalAlignment(Element.ALIGN_CENTER);
//                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                cell.setLeading(0, (float)1.4);
//                table.addCell(cell);
//            }
//        }
//        table.writeSelectedRows(0, -1, signRect.getLeft(), signRect.getTop(), pcb);
//
//
//        stamper.close();
//        reader.close();
    return null;
    }
}
