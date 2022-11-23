package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Definition of BIT image
        Pixel pixBIT01 = new Pixel(0, 0, 10, "1");
        Pixel pixBIT02 = new Pixel(0, 1, 10, "0");
        Pixel pixBIT03 = new Pixel(0, 2, 20, "0");
        Pixel pixBIT04 = new Pixel(0, 3, 20, "0");
        Pixel pixBIT05 = new Pixel(1, 0, 10, "0");
        Pixel pixBIT06 = new Pixel(1, 1, 10, "1");
        Pixel pixBIT07 = new Pixel(1, 2, 20, "0");
        Pixel pixBIT08 = new Pixel(1, 3, 20, "1");
        Pixel pixBIT09 = new Pixel(2, 0, 10, "1");
        Pixel pixBIT10 = new Pixel(2, 1, 10, "0");
        Pixel pixBIT11 = new Pixel(2, 2, 20, "0");
        Pixel pixBIT12 = new Pixel(2, 3, 20, "0");
        List<Pixel> bitMap01 = Arrays.asList(pixBIT01, pixBIT02, pixBIT03, pixBIT04, pixBIT05, pixBIT06, pixBIT07, pixBIT08, pixBIT09, pixBIT10, pixBIT11, pixBIT12);
        Image imgBIT01 = new Image(4, 3, bitMap01);
        //System.out.println(imgBIT01.isBitMap());

        //Definition of RGB image
        Pixel pixRGB01 = new Pixel(0, 0, 10, "255,100,10");
        Pixel pixRGB02 = new Pixel(0, 1, 10, "255,150,20");
        Pixel pixRGB03 = new Pixel(1, 0, 20, "255,150,20");
        Pixel pixRGB04 = new Pixel(1, 1, 10, "255,250,40");
        List<Pixel> pixMap01 = Arrays.asList(pixRGB01, pixRGB02, pixRGB03, pixRGB04);
        Image imgRGB01 = new Image(2, 2, pixMap01);
        //System.out.println(imgRGB01.isPixMap());

        //Definition of HEX image
        Pixel pixHEX01 = new Pixel(0, 0, 10, "FFFFFF");
        Pixel pixHEX02 = new Pixel(0, 1, 10, "FFAFFF");
        Pixel pixHEX03 = new Pixel(1, 0, 10, "FFAFFF");
        Pixel pixHEX04 = new Pixel(1, 1, 10, "FFFF00");
        List<Pixel> hexMap01 = Arrays.asList(pixHEX01, pixHEX02, pixHEX03, pixHEX04);
        Image imgHEX01 = new Image(2, 2, hexMap01);
        //System.out.println(imgHEX01.isHexMap());

        System.out.println("-----------------------------");
        System.out.println(imgBIT01.imageToString());
        System.out.println("-----------------------------");
        //depth reduction
        List<Image> imgBIT01DepthReduced = imgBIT01.separateByDepth();
        System.out.println("Reduced: ");
        for (Image img : imgBIT01DepthReduced) {
            System.out.println(img.imageToString());
            System.out.println("-----------------------------");
        }

        System.out.println(imgRGB01.imageToString());
        System.out.println("-----------------------------");
        //depth reduction
        List<Image> imgRGB01DepthReduced = imgRGB01.separateByDepth();
        System.out.println("Reduced: ");
        for (Image img : imgRGB01DepthReduced) {
            System.out.println(img.imageToString());
            System.out.println("-----------------------------");
        }
    }
}