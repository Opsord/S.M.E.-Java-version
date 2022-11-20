package org.example;

import java.io.PipedInputStream;
import java.util.List;
import java.util.stream.Collectors;

public class Image extends ImageFormat implements ImageOperations {

    //constructor
    public Image(int largo, int alto, List<Pixel> pixelList) {
        Largo = largo;
        Alto = alto;
        PixelList = pixelList;
    }

    //getters and setters
    public int getLargo() {
        return this.Largo;
    }

    public void setLargo(int largo) {
        this.Largo = largo;
    }

    public int getAlto() {
        return this.Alto;
    }

    public void setAlto(int alto) {
        this.Alto = alto;
    }

    public List<Pixel> getPixelList() {
        return this.PixelList;
    }

    public void setPixelList(List<Pixel> pixelList) {
        this.PixelList = pixelList;
    }

    //Verification BIT type
    @Override
    public boolean isBitMap() {
        PixelList.forEach(Pixel::isPixBIT);
        return true;
    }

    //Verification RGB type
    @Override
    public boolean isPixMap() {
        PixelList.forEach(Pixel::isPixRGB);
        return true;
    }

    //Verification HEX type
    @Override
    public boolean isHexMap() {
        PixelList.forEach(Pixel::isPixHEX);
        return true;
    }

    //Flip Horizontal
   @Override
    public void flipH() {
        int largoImage = getLargo();
        for(Pixel p:PixelList) {p.flipH(largoImage);}
    }

    //Flip Vertical
    @Override
    public void flipV () {
        int altoImage = getAlto();
        for(Pixel p:PixelList) {p.flipV(altoImage);}
    }

    @Override
    public void crop(int x1, int y1, int x2, int y2) {
        //filter the pixels that are inside the crop area
        List<Pixel> cropList = PixelList.stream()
                .filter(p -> p.getPosX() >= x1 && p.getPosX() <= x2 && p.getPosY() >= y1 && p.getPosY() <= y2)
                .collect(Collectors.toList());

        //set the new pixel list
        setPixelList(cropList);
    }

    @Override
    public void imgRGBToHex() {
        PixelList.forEach(Pixel::pixRGBToHex);
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
