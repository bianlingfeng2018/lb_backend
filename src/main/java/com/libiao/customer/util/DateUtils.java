package com.libiao.customer.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private static final DateTimeFormatter default_format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter date_format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter time_format = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final DateTimeFormatter yyyyMMddHHmmss = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public static final DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static final DateTimeFormatter yyyyMM = DateTimeFormatter.ofPattern("yyyyMM");
    public static final DateTimeFormatter yyyyMMddHHmmssSSS = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

    /**
     * 获取当前时间，格式为(2001-09-06 19:21:21)
     */
    public static String getCurrentTime() {
        return LocalDateTime.now().format(default_format);
    }

    /**
     * 获取当前时间，格式为(2001-09-06)
     */
    public static String getCurrentDate() {
        return LocalDate.now().format(date_format);
    }

    public static String getCurrentTimeNoDate() {
        return LocalTime.now().format(time_format);
    }

    /**
     * 获取当前时间，格式为(2001-09-06 19:21:21)
     */
    public static String getCurrentTime(String partten) {
        DateTimeFormatter formmat = DateTimeFormatter.ofPattern(partten);
        return LocalDateTime.now().format(formmat);
    }

    /**
     * 获取当前时间，格式为formmat
     */
    public static String getCurrentTime(DateTimeFormatter formmat) {
        return LocalDateTime.now().format(formmat);
    }


    /**
     * DATE1大于DATE2返回true
     * @param DATE1
     * @param DATE2
     * @param partten
     * @return
     */
    public static boolean compare_date(String DATE1, String DATE2, String partten) {
        DateTimeFormatter formmat = DateTimeFormatter.ofPattern(partten);
        LocalDateTime date1 = LocalDateTime.parse(DATE1, formmat);
        LocalDateTime date2 = LocalDateTime.parse(DATE2, formmat);
        return date1.compareTo(date2) > 0;

    }

    /**
      * 取得当前时间戳（精确到秒）
      * @return
      */
    public static String timeStamp(){
       long time = System.currentTimeMillis();
       String t = String.valueOf(time/1000);
       return t;
    }


    /**
     	* 日期格式字符串转换成时间戳
    	* @param date_str 字符串日期
    	* @param format 如：yyyy-MM-dd HH:mm:ss
    	* @return
    	*/
    public static String dateTwoTimeStamp(String date_str,String format){
    	try {
    		SimpleDateFormat sdf = new SimpleDateFormat(format);
    		return String.valueOf(sdf.parse(date_str).getTime()/1000);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        return "";
    }

    public static synchronized String formatDate(String strDate, String newPattern, String oldPattern){
        String test1;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(oldPattern);
            Date test = formatter.parse(strDate);
            SimpleDateFormat formatter1 = new SimpleDateFormat(newPattern);
            test1 = formatter1.format(test);
            return test1;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

    public static synchronized String formatDate8(String strDate){
        String test1;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            Date test = formatter.parse(strDate);
            SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
            test1 = formatter1.format(test);
            return test1;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }


    public static boolean isToday(String inventoryTime) {
        String now = getCurrentDate();
        return inventoryTime.startsWith(now);
    }

    public static String getFirstDayOfPreMonth(DateTimeFormatter formatter) {
        LocalDate today = LocalDate.now();
        final LocalDate preMonth = today.plus(-1, ChronoUnit.MONTHS);
        final LocalDate first = preMonth.with(TemporalAdjusters.firstDayOfMonth());
        return first.format(formatter);
    }

    public static String getLastDayOfPreMonth(DateTimeFormatter formatter) {
        LocalDate today = LocalDate.now();
        final LocalDate preMonth = today.plus(-1, ChronoUnit.MONTHS);
        final LocalDate last = preMonth.with(TemporalAdjusters.lastDayOfMonth());
        return last.format(formatter);
    }

    public static String convertFormat(String dateStr, String oriFormat, String newFormat) {
        LocalDateTime tmp = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(oriFormat));
        return tmp.format(DateTimeFormatter.ofPattern(newFormat));
    }

    private static final String OFFSET_ID = "+08:00";

    public static String convertUseZone(String dateStr, String oriFormat, String newFormat) {
        LocalDateTime tmp = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(oriFormat));
        ZoneOffset set = ZoneOffset.of(OFFSET_ID);
        //2021-10-01T00:00:00+0800
        //2021-10-01T00:00:00+0800
        final OffsetDateTime offsetDateTime = tmp.atOffset(set);
        return offsetDateTime.format(DateTimeFormatter.ofPattern(newFormat));
    }

    public static String getYesterday() {
        LocalDate localDate = LocalDate.now();
        final LocalDate yesterday = localDate.plusDays(-1);
        return yesterday.format(yyyyMMdd);
    }

    /**
     * 跳转指定日期
     * @param numDay
     * @param pattern
     * @return
     */
    public static Date getAppointDay(long numDay, ChronoUnit pattern) {
        final LocalDateTime plus = LocalDateTime.now().plus(numDay, pattern);
        return localDateTimeToDate(plus);
    }

    /**
     * LocalDateTime转Date
     * @param dateTime
     * @return
     */
    public static Date localDateTimeToDate(LocalDateTime dateTime) {
        Date date = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        return date;
    }

    /**
     * String转Date
     * @param dateTime
     * @param pattern
     * @return
     */
    public static Date stringToDate(String dateTime, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = sdf.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static  String[] getFirstTimeAndLastTime(int year,int month,String pattern){
        String[] arr =new String[2];
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        Date lastDate = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        arr[1] = sdf.format(lastDate);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDate = cal.getTime();
        arr[0] = sdf.format(firstDate);
        return arr;
    }
    /**
     * 获取当年的第一天
     * @param year
     * @return
     */
    public static String getCurrYearFirst(){
        Calendar currCal=Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }
    /**
     * 获取某年最后一天日期
     * @param year 年份
     * @return Date
     */
    public static String getYearLast(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return  sdf.format(currYearLast);
    }
    /**
     * 获取当年的最后一天
     * @param year
     * @return
     */
    public static String getCurrYearLast(){
        Calendar currCal=Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }
    /**
     * 获取某年第一天日期
     * @param year 年份
     * @return Date
     */
    public static String getYearFirst(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return  sdf.format(currYearFirst);
    }
    /**
     * 返回指定年季的季的第一天 sjj
     *
     * @param year
     * @param quarter
     * @return
     */
    public static String getFirstDayOfQuarter(Integer year, Integer quarter,String pattern) {
        Calendar calendar = Calendar.getInstance();
        int month = 0;
        if (quarter == 1) {
        } else if (quarter == 2) {
            month = 4 - 1;
        } else if (quarter == 3) {
            month = 7 - 1;
        } else if (quarter == 4) {
            month = 10 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        return  sdf.format(getFirstDayOfMonth(year, month));
    }
    /**
     * 返回指定年月的月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        return calendar.getTime();
    }

    /**
     * 返回指定年季的季的最后一天 sjj
     *
     * @param year
     * @param quarter
     * @return
     */
    public static String getLastDayOfQuarter(Integer year, Integer quarter,String pattern) {
        Calendar calendar = Calendar.getInstance();
        int month = 0;
        if (quarter == 1) {
            month = 3 - 1;
        } else if (quarter == 2) {
            month = 6 - 1;
        } else if (quarter == 3) {
            month = 9 - 1;
        } else if (quarter == 4) {
            month = 12 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        return  sdf.format(getLastDayOfMonth(year, month));
    }
    /**
     * 返回指定年月的月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    public static void main(String[] args) {
        System.out.println(getYesterday());
        /*final LocalDateTime plus = LocalDateTime.now().plus(2, ChronoUnit.DAYS);
        Date date = Date.from(plus.atZone( ZoneId.systemDefault()).toInstant());
        System.out.println(date);
        LocalDate today = LocalDate.now();
        System.out.println(today);
        final LocalDate plus = today.plus(-1, ChronoUnit.MONTHS);
        System.out.println(plus);
        final LocalDate with = plus.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(with);
        final LocalDate last = plus.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(last);*/
        System.out.println(convertUseZone("2021-10-01 00:00:00", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ssZ"));
    }


    public static String getDateStr(String dateStr,String old_pattern ,String new_pattern){
        if(org.apache.commons.lang3.StringUtils.isBlank(dateStr)){
            return  "";
        }
        String sDate="";
        try {
            sDate=getDate(getDate(dateStr, old_pattern), new_pattern);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(sDate==null){
            return  "";
        }
        return  sDate;
    }
    public static Date getDate(String dateStr, String patten)
            throws ParseException {
        if (dateStr == null)
            return null;
        SimpleDateFormat sf = new SimpleDateFormat(patten);
        return sf.parse(dateStr);
    }
    public static String getDate(Date date, String patten) {
	    if(date!=null){
            SimpleDateFormat sf = new SimpleDateFormat(patten);
            return sf.format(date);
        }
        return "";
    }

    public static String getDate(String patten) {
        SimpleDateFormat sf = new SimpleDateFormat(patten,java.util.Locale.US);
        return sf.format(new Date());
    }


}
