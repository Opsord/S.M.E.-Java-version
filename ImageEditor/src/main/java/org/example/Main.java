package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Definition of BIT image
        Pixel pixBIT01 = new Pixel(0, 0, 10, "1");
        Pixel pixBIT02 = new Pixel(0, 1, 10, "0");
        Pixel pixBIT03 = new Pixel(0, 2, 10, "1");
        Pixel pixBIT04 = new Pixel(1, 0, 10, "0");
        Pixel pixBIT05 = new Pixel(1, 1, 10, "0");
        Pixel pixBIT06 = new Pixel(1, 2, 10, "0");
        List<Pixel> bitMap01 = Arrays.asList(pixBIT01, pixBIT02, pixBIT03, pixBIT04, pixBIT05, pixBIT06);
        Image imgBIT01 = new Image(3, 2, bitMap01);
        //System.out.println(imgBIT01.isBitMap());

        //Definition of RGB image
        Pixel pixRGB01 = new Pixel(0, 0, 10, "255,100,10");
        Pixel pixRGB02 = new Pixel(0, 1, 10, "255,150,20");
        Pixel pixRGB03 = new Pixel(1, 0, 10, "255,150,20");
        Pixel pixRGB04 = new Pixel(1, 1, 10, "255,250,40");
        List<Pixel> pixMap01 = Arrays.asList(pixRGB01, pixRGB02, pixRGB03, pixRGB04);
        Image imgRGB01 = new Image(2, 2, pixMap01);
        //System.out.println(imgRTB01.isPixMap());

        //Definition of HEX image
        Pixel pixHEX01 = new Pixel(0, 0, 10, "FFFFFF");
        Pixel pixHEX02 = new Pixel(0, 1, 10, "FFAFFF");
        Pixel pixHEX03 = new Pixel(1, 0, 10, "FFAFFF");
        Pixel pixHEX04 = new Pixel(1, 1, 10, "FFFFF");
        List<Pixel> hexMap01 = Arrays.asList(pixHEX01, pixHEX02, pixHEX03, pixHEX04);
        Image imgHEX01 = new Image(2, 2, hexMap01);
        //System.out.println(imgHEX01.isHexMap());

        /*
        //print imgBIT01
        System.out.println(imgBIT01);
        //print imgRTB01
        System.out.println(imgRGB01);
        //print imgHEX01
        System.out.println(imgHEX01);
        */

        /*
        //isCompressed examples
        //check if imgBIT01 is compressed
        System.out.println(imgBIT01.isCompressed());
        //check if imgRTB01 is compressed
        System.out.println(imgRGB01.isCompressed());
        //check if imgHEX01 is compressed
        System.out.println(imgHEX01.isCompressed());
        */

        /*
        //Horizontal flips examples
        //imgBIT01
        System.out.println(imgBIT01);
        imgBIT01.flipH();
        System.out.println(imgBIT01);
        //imgRTB01
        System.out.println(imgRGB01);
        imgRGB01.flipH();
        System.out.println(imgRGB01);
        //imgHEX01
        System.out.println(imgHEX01);
        imgHEX01.flipH();
        System.out.println(imgHEX01);
        */

        /*
        //Vertical flips examples
        //imgBIT01
        System.out.println(imgBIT01);
        imgBIT01.flipV();
        System.out.println(imgBIT01);
        //imgRTB01
        System.out.println(imgRGB01);
        imgRGB01.flipV();
        System.out.println(imgRGB01);
        //imgHEX01
        System.out.println(imgHEX01);
        imgHEX01.flipV();
        System.out.println(imgHEX01);
        */

        /*
        //crop examples
        //imgBIT01
        System.out.println(imgBIT01);
        imgBIT01.crop(0,0, 1, 1);
        System.out.println(imgBIT01);
        //imgRTB01
        System.out.println(imgRGB01);
        imgRGB01.crop(0,0, 0, 0);
        System.out.println(imgRGB01);
        //imgHEX01
        System.out.println(imgHEX01);
        imgHEX01.crop(1,1, 1, 1);
        System.out.println(imgHEX01);
        */

        /*
        //ImgRGBToHex examples
        imgRGB01.imgRGBToHex();
        System.out.println(imgRGB01);
        */

        /*
        //Histogram examples
        //imgBIT01
        System.out.println("------------------------------------------------------------");
        System.out.println(imgBIT01.histogram());
        System.out.println("------------------------------------------------------------");
        System.out.println(imgRGB01.histogram());
        System.out.println("------------------------------------------------------------");
        System.out.println(imgHEX01.histogram());
        System.out.println("------------------------------------------------------------");
        */

        /*
        //rotate90 examples
        //imgBIT01
        System.out.println("------------------------------------------------------------");
        System.out.println(imgBIT01);
        System.out.println("------------------------------------------------------------");
        imgBIT01.rotate90();
        System.out.println(imgBIT01);
        System.out.println("------------------------------------------------------------");
        //imgRTB01
        System.out.println(imgRGB01);
        System.out.println("------------------------------------------------------------");
        imgRGB01.rotate90();
        System.out.println(imgRGB01);
        System.out.println("------------------------------------------------------------");
        //imgHEX01
        System.out.println(imgHEX01);
        System.out.println("------------------------------------------------------------");
        imgHEX01.rotate90();
        System.out.println(imgHEX01);
        System.out.println("------------------------------------------------------------");
        */

    }
}