package org.example;

import java.util.List;

public class Image {

    private int Largo;

    private int Alto;

    private List<Pixel> PixelList;

    //constructor
    public Image(int largo, int alto, List<Pixel> pixelList) {
        Largo = largo;
        Alto = alto;
        PixelList = pixelList;
    }

    //getters and setters
    public int getLargo(Image image) {
        return Largo;
    }

    public void setLargo(int largo) {
        Largo = largo;
    }

    public int getAlto(Image image) {
        return Alto;
    }

    public void setAlto(int alto) {
        Alto = alto;
    }

    public List<Pixel> getPixelList(Image image) {
        return PixelList;
    }

    public void setPixelList(List<Pixel> pixelList) {
        PixelList = pixelList;
    }






    
    @Override
    public String toString() {
        return "Image{" +
                "Largo=" + Largo +
                ", Alto=" + Alto +
                ", PixelList=" + PixelList +
                '}';
    }
}
