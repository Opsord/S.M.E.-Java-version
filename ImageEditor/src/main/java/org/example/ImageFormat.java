package org.example;

import java.util.List;

public abstract class ImageFormat {

    //Image elements
    int Largo;

    int Alto;

    List<Pixel> PixelList;

    //method to check if the image is compressed
    public boolean isCompressed() {
        if (Alto * Largo == PixelList.size()) {
            return false;
        }
        return true;
    }
}
