package com.libiao.customer.util.file;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.renderer.DrawContext;
import com.itextpdf.layout.renderer.IRenderer;
import com.itextpdf.layout.renderer.TableRenderer;

// 将图片显示在表格上方
public class OverlappingImageTableRenderer extends TableRenderer {

    private ImageData image;

    public OverlappingImageTableRenderer(Table modelElement, Table.RowRange rowRange, ImageData img) {
        super(modelElement, rowRange);
        this.image = img;
    }

    public OverlappingImageTableRenderer(Table modelElement, ImageData img){
        super(modelElement);
        this.image = img;
    }

    @Override
    public void drawChildren(DrawContext drawContext){
        Rectangle rect = rows.get(0)[3].getOccupiedAreaBBox();
        super.drawChildren(drawContext);
        drawContext.getCanvas().addImageAt(image, rect.getLeft() +  35, rect.getTop() - image.getHeight() + 28, false);
    }

    @Override
    public IRenderer getNextRenderer(){
        return new OverlappingImageTableRenderer((Table) modelElement, image);
    }

}
