package org.example;

import java.util.List;

public interface ImageOperations {

    public boolean isBitMap();

    public boolean isPixMap();

    public boolean isHexMap();

    public boolean isCompressed();

    public void flipH();

    public void flipV();

    public void crop(int x1, int y1, int x2, int y2);

    public void imgRGBToHex();

    public List<List<String>> histogram();

    public void rotate90();

    public ImageCompressed compress();

    public void changePixel(Pixel pixel);

    public void invertColorBit();

    public void invertColorRGB();

}
