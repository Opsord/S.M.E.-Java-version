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

    public int getPosX() {
        return PosX;
    }

    public void setPosX(int posX) {
        PosX = posX;
    }

    public int getPosY() {
        return PosY;
    }

    public void setPosY(int posY) {
        PosY = posY;
    }

    public int getDepth() {
        return Depth;
    }

    public void setDepth(int depth) {
        Depth = depth;
    }

    public String getPixelContent() {
        return PixelContent;
    }

    public void setPixelContent(String pixelContent) {
        PixelContent = pixelContent;
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
