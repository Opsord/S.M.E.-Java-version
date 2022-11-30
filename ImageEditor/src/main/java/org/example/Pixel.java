package org.example;

import java.util.Objects;

/**
 * This is the pixel class, which is part of an Image.
 * @author Andres Zelaya Droguett
 */
public class Pixel {

    /**
     * Every pixel must have an X coordinate to work with.
     */
    private int posX;

    /**
     * Also, it must have an Y coordinate.
     */
    private int posY;

    /**
     * Pixels have a "depth" attribute to work with 3D images
     */
    private int depth;

    /**
     * Pixels also have a color, this can be a BIT, RGB or Hexadecimal number
     */
    private String pixelContent;

    public Pixel(int posX, int posY, int depth, String pixelContent) {
        this.posX = posX;
        this.posY = posY;
        this.depth = depth;
        this.pixelContent = pixelContent;
    }

    /**
     * Method that returns the X coordinate of a pixel
     * @return X coordinate of the pixel
     */
    public int getPosX() {
        return this.posX;
    }

    /**
     * Method to change the X coordinate of a pixel to a given value
     * @param posX X coordinate of the pixel
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * Method that returns the Y coordinate of a pixel
     * @return Y coordinate of the pixel
     */
    public int getPosY() {
        return this.posY;
    }

    /**
     * Method to change the Y coordinate of a pixel to a given value
     * @param posY Y coordinate of the pixel
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * Method that returns the depth value of the pixel
     * @return Depth value of pixel
     */
    public int getDepth() {
        return this.depth;
    }

    /**
     * Method to change the depth value of a pixel
     * @param depth Depth of the pixel
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * Method that returns the content/color of a pixel
     * @return Pixel´s content/color
     */
    public String getPixelContent() {
        return this.pixelContent;
    }

    /**
     * Method to change the color/content of a pixel to a given value
     * @param pixelContent Pixel´s content
     */
    public void setPixelContent(String pixelContent) {
        this.pixelContent = pixelContent;
    }

    /**
     * Method to do a translation of a pixel in the Y axis
     * @param yTranslation Value of the translation
     */
    public void translatePosY(int yTranslation) {
        this.posY += yTranslation;
    }

    /**
     * Method that verifies if a pixel has a BIT color/content
     * @return Boolean of the consult
     */
    public boolean isPixBIT() {
        return Objects.equals(getPixelContent(), "1") || Objects.equals(getPixelContent(), "0");
    }

    /**
     * Method that verifies if a pixel has RGB color/content
     * @return Boolean of the consult
     */
    public boolean isPixRGB() {
        //convert PixelContent to list
        String[] rgb = getPixelContent().split(",");
        //check if list is long 3 and each element is between 0 and 255
        return rgb.length == 3 &&
                Integer.parseInt(rgb[0]) >= 0 &&
                Integer.parseInt(rgb[0]) <= 255 &&
                Integer.parseInt(rgb[1]) >= 0 &&
                Integer.parseInt(rgb[1]) <= 255 &&
                Integer.parseInt(rgb[2]) >= 0 &&
                Integer.parseInt(rgb[2]) <= 255;
    }

    /**
     * Method that verifies if a pixel has hexadecimal content
     * @return Boolean of the consult
     */
    public boolean isPixHEX() {
        String hex = getPixelContent();
        //check if string is a valid hex color
        return hex.matches("^#([A-Fa-f0-9]{6})$");
    }

    /**
     * Method to flip a pixel horizontally given a value
     * @param arg Max X value of the image
     */
    public void flipH(int arg) {
        setPosX(arg - getPosX());
    }

    /**
     * Method to flip a pixel vertically given a value
     * @param arg Max Y value of the image
     */
    public void flipV(int arg) {
        setPosY(arg - getPosY());
    }

    /**
     * Method to change the pixel content from RGB to hexadecimal
     */
    public void pixRGBToHex() {
        String[] rgb = getPixelContent().split(",");
        int r = Integer.parseInt(rgb[0]);
        int g = Integer.parseInt(rgb[1]);
        int b = Integer.parseInt(rgb[2]);
        String hex = String.format("#%02x%02x%02x", r, g, b);
        setPixelContent(hex);
    }

    /**
     * Method to rotate a pixel 90 degrees clock-wise
     */
    public void rotate90() {
        int x = getPosX();
        setPosX(getPosY());
        setPosY(-x);
    }

    /**
     * Method to invert the color/content of a BIT pixel
     */
    public void invertColorBIT() {
        if (Objects.equals(getPixelContent(), "1")) {
            setPixelContent("0");
        } else {
            setPixelContent("1");
        }
    }

    /**
     * Method to invert the color/content of an RGB pixel
     */
    public void invertColorRGB() {
        String[] rgb = getPixelContent().split(",");
        int r = Integer.parseInt(rgb[0]);
        int g = Integer.parseInt(rgb[1]);
        int b = Integer.parseInt(rgb[2]);
        r = 255 - r;
        g = 255 - g;
        b = 255 - b;
        String newRGB = r + "," + g + "," + b;
        setPixelContent(newRGB);
    }

    /**
     * Method to transform a pixel into a string with the pixel´s information
     * @return String with the pixel´s information
     */
    @Override
    public String toString() {
        return "Pixel{" +
                "PosX=" + posX +
                ", PosY=" + posY +
                ", Depth=" + depth +
                ", PixelContent='" + pixelContent + '\'' +
                '}';

    }
}