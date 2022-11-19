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
}