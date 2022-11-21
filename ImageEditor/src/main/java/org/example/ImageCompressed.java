package org.example;

import java.util.List;

public class ImageCompressed extends ImageFormat implements ImageCompressedOp{

    private String CompressedContent;

    private int ElementsCompressed;
    
    //constructor
    public ImageCompressed(int largo, int alto, List<Pixel> pixelList, String compressedContent, int elementsCompressed) {
        Largo = largo;
        Alto = alto;
        PixelList = pixelList;
        CompressedContent = compressedContent;
        ElementsCompressed = elementsCompressed;
    }

    //getters
    public int getLargoCompressed() {
        return this.Largo;
    }

    public int getAltoCompressed() {
        return this.Alto;
    }

    public List<Pixel> getPixelListCompressed() {
        return this.PixelList;
    }

    public String getCompressedContent() {
        return this.CompressedContent;
    }

    public int getElementsCompressed() {
        return this.ElementsCompressed;
    }

    //setters
    public void setCompressedContent(String compressedContent) {
        this.CompressedContent = compressedContent;
    }

    public void setElementsCompressed(int elementsCompressed) {
        this.ElementsCompressed = elementsCompressed;
    }

    //toString
    @Override
    public String toString() {
        return "{" +
            " Largo='" + getLargoCompressed() + "'" +
            ", Alto='" + getAltoCompressed() + "'" +
            ", PixelList='" + getPixelListCompressed() + "'" +
            ", CompressedContent='" + getCompressedContent() + "'" +
            ", ElementsCompressed='" + getElementsCompressed() + "'" +
            "}";
    }
}