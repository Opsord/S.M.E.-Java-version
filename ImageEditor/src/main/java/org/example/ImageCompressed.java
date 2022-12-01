package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Specific class for only compressed images
 *
 * @author Andres Zelaya Droguett
 */
public class ImageCompressed extends ImageFormat implements ImageCompressedOp{

    /**
     * Element/color that was compressed
     */
    private final String compressedContent;

    /**
     * Times that the element/color was eliminated from the image
     */
    private final int elementsCompressed;
    
    //constructor
    public ImageCompressed(int largo, int alto, List<Pixel> pixelList, String compressedContent, int elementsCompressed) {
        this.largo = largo;
        this.alto = alto;
        this.pixelList = pixelList;
        this.compressedContent = compressedContent;
        this.elementsCompressed = elementsCompressed;
    }

    /**
     * Method that gets the element that was compressed
     * @return Color/content
     */
    public String getCompressedContent() {
        return this.compressedContent;
    }

    /**
     * Method that gets the times that a determined element/color was deleted from the image
     * @return Times that an element/color was deleted
     */
    public int getElementsCompressed() {
        return this.elementsCompressed;
    }

    /**
     * Since the class is for compressed images, the consult will be always be true
     * @return true
     */
    @Override
    public boolean isCompressed(){
        return true;
    }

    /**
     * Reconstruct a compressed image using finding missing pixels and the compressed element
     * @return Normal image
     */
    @Override
    public Image decompress() {
        int largo = getLargo();
        int alto = getAlto();
        int defaultDepth = 0;
        String compressedContent = getCompressedContent();
        List<List<Integer>> missingPixelCoords = findMissingPixels();
        List<Pixel> missingPixels = new ArrayList<>();
        for(List<Integer> coordinate : missingPixelCoords) {
            Pixel missingPixel = new Pixel(coordinate.get(0), coordinate.get(1), defaultDepth, compressedContent);
            missingPixels.add(missingPixel);
        }
        List<Pixel> pixelList = getPixelList();
        pixelList.addAll(missingPixels);
        return new Image(largo, alto, pixelList);
    }

    /**
     * Method to display the information if a compressed image as a string
     * @return String
     */
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