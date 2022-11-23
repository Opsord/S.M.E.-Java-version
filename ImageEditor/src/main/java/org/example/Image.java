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

    public void setLargo(int largo) {
        this.Largo = largo;
    }

    public void setAlto(int alto) {
        this.Alto = alto;
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

    @Override
    public boolean isCompressed(){
        int largoImage = getLargo();
        int altoImage = getAlto();
        int areaImg = largoImage * altoImage;
        int pixelListSize = getPixelList().size();
        if(pixelListSize == areaImg) {return true;}
        else {return false;}
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

    @Override
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
        //make a new pixel list without the most repeated pixel
        List<Pixel> newPixelList = PixelList.stream()
                .filter(p -> !p.getPixelContent().equals(mostRepeatedPixel))
                .collect(Collectors.toList());
        //get the number of elements that are repeated
        int elementsRepeated = Integer.parseInt(histogram.get(0).get(1));
        ImageCompressed imageCompressed = 
        new ImageCompressed(largoImage, altoImage, newPixelList, mostRepeatedPixel, elementsRepeated);
        return imageCompressed;
    }

    @Override
    public void changePixel(Pixel pixel){
        int PosX = pixel.getPosX();
        int PosY = pixel.getPosY();
        PixelList.forEach(p -> {
            if(p.getPosX() == PosX && p.getPosY() == PosY){
                p.setPixelContent(pixel.getPixelContent());
            }
        });
    }

    //invert the color of every BIT pixel
    @Override
    public void invertColorBit(){
        PixelList.forEach(Pixel::invertColorBIT);
    }

    //invert the color of every RGB pixel
    @Override
    public void invertColorRGB(){
        PixelList.forEach(Pixel::invertColorRGB);
    }

    //print the image as a matrix
    @Override
    public String imageToString() {
        String imageString = "";
        int largoImage = getLargo();
        List<Pixel> pixelList = getPixelList();
        //sort the pixel list by x and y
        pixelList.sort(
            (o1, o2) -> {
                if(o1.getPosX() == o2.getPosX()) {
                    return o1.getPosY() - o2.getPosY();
                }
                else {
                    return o1.getPosX() - o2.getPosX();
                }
            });
        int acc = 0;
        for(Pixel p:pixelList) {
            if(acc == largoImage) {
                imageString += "\n";
                acc = 0;
            }
            imageString += p.getPixelContent() + "\t";
            acc++;
        }
        return imageString;
    }

    /*
    //separate the image by depth layers
    public List separateByDepth(){
        int largoImage = getLargo();
        int altoImage = getAlto();
        int areaImg = largoImage * altoImage;
        //define a white pixel depending on the type of image
        String whitePixel = "";
        if(isBitMap()) {whitePixel = "0";}
        else if(isPixMap()) {whitePixel = "255,255,255";}
        else if(isHexMap()) {whitePixel = "#FFFFFF";}
        
        List<Pixel> pixelList = getPixelList();   
        //get a list of the unique depths
        List<Integer> uniqueDepths = PixelList.stream().map(Pixel::getDepth).distinct().collect(Collectors.toList());
        //get a pixel list for each depth
        List<List<Pixel>> pixelListByDepth = new ArrayList<>();
        for(Integer i:uniqueDepths) {
            List<Pixel> subList = new ArrayList<>();
            for(Pixel p:pixelList) {
                if(p.getDepth() == i) {
                    subList.add(p);
                }
            }
            pixelListByDepth.add(subList);
        }
        }
        */
    

    @Override
    public String toString() {
        return "Image{" +
                "Largo=" + Largo +
                ", Alto=" + Alto +
                ", PixelList=" + PixelList +
                '}';
    }
}
