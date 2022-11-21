package org.example;

import java.util.ArrayList;
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
    public List<List<String>> histogram() {
        //get the content of every pixel in the image
        List<String> imageContent = new ArrayList<>();
        for(Pixel p:PixelList) {imageContent.add(p.getPixelContent());}
        //get the unique content of every pixel in the image
        List<String> uniqueContent = imageContent.stream().distinct().collect(Collectors.toList());
        //histogram builder
        List<List<String>> histogram = new ArrayList<>();
        for(String s:uniqueContent) {
            List<String> subList = new ArrayList<>();
            subList.add(s);
            subList.add(String.valueOf(imageContent.stream().filter(s::equals).count()));
            histogram.add(subList);
        }
        //sort the histogram by the number of occurrences
        histogram.sort(
            (o1, o2) -> Integer.parseInt(o2.get(1).toString()) - Integer.parseInt(o1.get(1).toString()));
        //return the histogram
        return histogram;
    }

    public void rotate90(){
        PixelList.forEach(Pixel::rotate90);
    }

    @Override
    public ImageCompressed compress(){
        int largoImage = getLargo();
        int altoImage = getAlto();
        //histogram
        List<List<String>> histogram = histogram();
        //get the most repeated pixel
        String mostRepeatedPixel = histogram.get(0).get(0);
        //get the number of elements that are repeated
        int elementsRepeated = Integer.parseInt(histogram.get(0).get(1));
        ImageCompressed imageCompressed = 
        new ImageCompressed(largoImage, altoImage, PixelList, mostRepeatedPixel, elementsRepeated);
        return imageCompressed;
    }

    public void changePixel(Pixel pixel){
        int PosX = pixel.getPosX();
        int PosY = pixel.getPosY();
        PixelList.forEach(p -> {
            if(p.getPosX() == PosX && p.getPosY() == PosY){
                p.setPixelContent(pixel.getPixelContent());
            }
        });
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
