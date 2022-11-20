package org.example;

import java.util.List;

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
    public boolean isBitMap (){
        PixelList.forEach(Pixel::isPixBIT);
        return true;
    }

    //Verification RGB type
    @Override
    public boolean isPixMap (){
        PixelList.forEach(Pixel::isPixRGB);
        return true;
    }

    //Verification HEX type
    @Override
    public boolean isHexMap (){
        PixelList.forEach(Pixel::isPixHEX);
        return true;
    }

    //Flip Horizontal
   @Override
    public void flipH (){
        int largoImage = getLargo();
        for(Pixel p:PixelList) {p.flipH(largoImage);}
    }

    //Flip Vertical
    @Override
    public void flipV (){
        int altoImage = getAlto();
        for(Pixel p:PixelList) {p.flipV(altoImage);}
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
