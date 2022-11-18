package org.example;

public class Pixel {

    private int PosX;

    private int PosY;

    private int Depth;

    private String PixelContent;

    public Pixel(int posX, int posY, int depth, String pixelContent) {
        PosX = posX;
        PosY = posY;
        Depth = depth;
        PixelContent = pixelContent;
    }

    public int getPosX(Pixel pixel) {
        return PosX;
    }

    public void setPosX(int posX) {
        PosX = posX;
    }

    public int getPosY(Pixel pixel) {
        return PosY;
    }

    public void setPosY(int posY) {
        PosY = posY;
    }

    public int getDepth(Pixel pixel) {
        return Depth;
    }

    public void setDepth(int depth) {
        Depth = depth;
    }

    public String getPixelContent(Pixel pixel) {
        return PixelContent;
    }

    public void setPixelContent(String pixelContent) {
        PixelContent = pixelContent;
    }

    public boolean isPixBIT(){
        if (getPixelContent(this) == "1" || getPixelContent(this) == "0") {
            return true;
        }
        return false;
    }

    public boolean isPixRGB(){
        //convert PixelContent to list
        String[] rgb = getPixelContent(this).split(",");
        //check if list is long 3 and each element is between 0 and 255
        if (rgb.length == 3 &&
                Integer.parseInt(rgb[0]) >= 0 &&
                Integer.parseInt(rgb[0]) <= 255 &&
                Integer.parseInt(rgb[1]) >= 0 &&
                Integer.parseInt(rgb[1]) <= 255 &&
                Integer.parseInt(rgb[2]) >= 0 &&
                Integer.parseInt(rgb[2]) <= 255) {
            return true;
        }
        return false;
    }

    public boolean isPixHEX() {
        String hex = getPixelContent(this);
        //check if string is a valid hex color
        if (hex.matches("^#([A-Fa-f0-9]{6})$")) {
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "Pixel{" +
                "PosX=" + PosX +
                ", PosY=" + PosY +
                ", Depth=" + Depth +
                ", PixelContent='" + PixelContent + '\'' +
                '}';

    }
}