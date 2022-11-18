package org.example;

public class Main {
    public static void main(String[] args) {

        Pixel pixelBIT01 = new Pixel(0, 0, 10, "1");
        Pixel pixelBIT02 = new Pixel(0, 1, 10, "0");
        Pixel pixelBIT03 = new Pixel(1, 0, 10, "1");
        Pixel pixelBIT04 = new Pixel(1, 1, 10, "0");

        Pixel pixelRGB01 = new Pixel(0, 0, 10, "255,0,0");
        Pixel pixelRGB02 = new Pixel(0, 1, 10, "0,255,0");
        Pixel pixelRGB03 = new Pixel(1, 0, 10, "0,0,255");
        Pixel pixelRGB04 = new Pixel(1, 1, 10, "255,255,255");

        Pixel pixelHEX01 = new Pixel(0, 0, 10, "#8E44AD");
        Pixel pixelHEX02 = new Pixel(0, 1, 10, "#F1C40F");
        Pixel pixelHEX03 = new Pixel(1, 0, 10, "#E67E22");
        Pixel pixelHEX04 = new Pixel(1, 1, 10, "#2ECC71");

        //print all pixels
        System.out.println(pixelBIT01);
        System.out.println(pixelBIT02);
        System.out.println(pixelBIT03);
        System.out.println(pixelBIT04);
        System.out.println(pixelRGB01);
        System.out.println(pixelRGB02);
        System.out.println(pixelRGB03);
        System.out.println(pixelRGB04);
        System.out.println(pixelHEX01);
        System.out.println(pixelHEX02);
        System.out.println(pixelHEX03);
        System.out.println(pixelHEX04);
        
        //pixel type check
        System.out.println(pixelBIT01.isPixBIT());
        System.out.println(pixelRGB04.isPixRGB());
        System.out.println(pixelHEX02.isPixHEX());
    }
}