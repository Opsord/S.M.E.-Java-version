package org.example;

import java.util.ArrayList;
import java.util.List;

public class ImageCompressed extends ImageFormat implements ImageCompressedOp{

    private String CompressedContent;

    private int ElementsCompressed;
    
    //constructor
    public ImageCompressed(int largo, int alto, List<Pixel> pixelList, String compressedContent, int elementsCompressed) {
        this.largo = largo;
        this.alto = alto;
        this.pixelList = pixelList;
        CompressedContent = compressedContent;
        ElementsCompressed = elementsCompressed;
    }

    //getters

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

    //method to check if the image is compressed
    @Override
    public boolean isCompressed(){
        int largoImage = getLargo();
        int altoImage = getAlto();
        int areaImg = largoImage * altoImage;
        int pixelListSize = getPixelList().size();
        if(pixelListSize == areaImg) {return true;}
        else {return false;}
    }
    //method to decompress the image
    @Override
    public Image decompress() {
        int largo = getLargo();
        int alto = getAlto();
        int defaultDepth = 0;
        String compressedContent = getCompressedContent();
        List<List<Integer>> missingPixelCoords = findMissingPixels();
        List<Pixel> missingPixels = new ArrayList<>();
        for(List<Integer> coord : missingPixelCoords) {
            Pixel missingPixel = new Pixel(coord.get(0), coord.get(1), defaultDepth, compressedContent);
            missingPixels.add(missingPixel);
        }
        List<Pixel> pixelList = getPixelList();
        pixelList.addAll(missingPixels);
        return new Image(largo, alto, pixelList);
    }

    //toString
    @Override
    public String toString() {
        return "{" +
            " Largo='" + getLargo() + "'" +
            ", Alto='" + getAlto() + "'" +
            ", PixelList='" + getPixelList() + "'" +
            ", CompressedContent='" + getCompressedContent() + "'" +
            ", ElementsCompressed='" + getElementsCompressed() + "'" +
            "}";
    }
}