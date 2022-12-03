package org.example;

import java.util.List;

public interface ImageOperations {

    boolean isBitMap();

    boolean isPixMap();

    boolean isHexMap();

    boolean isCompressed();

    void flipH();

    void flipV();

    void crop(int x1, int y1, int x2, int y2);

    void imgRGBToHex();

    List<List<String>> histogram();

    void rotate90();

    ImageCompressed_200958322_ZelayaDroguett200958322ZelayaDroguett compress();

    void changePixelContent(int posX, int posY, String newContent);

    void changePixelDepth(int posX, int posY, int newDepth);

    void invertColorBit();

    void invertColorRGB();

    String imageToString();

    void fillImage();

    List<Image_200958322_ZelayaDroguett200958322ZelayaDroguett> separateByDepth();

}
