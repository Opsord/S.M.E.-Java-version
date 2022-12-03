package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is probably the most used class in this program, an image is basically an array of
 * pixels that can be manipulated
 *
 * @author Andres Zelaya Droguett
 */
public class Image extends ImageFormat implements ImageOperations {
    //constructor
    public Image(int largo, int alto, List<Pixel> pixelList) {
        this.largo = largo;
        this.alto = alto;
        this.pixelList = pixelList;
    }

    /**
     * Method to change the list of pixels of the image to another
     * @param pixelList List of pixels of the image
     */
    public void setPixelList(List<Pixel> pixelList) {
        this.pixelList = pixelList;
    }

    /**
     * Method to verify if every pixel of the image is BIT type
     * @return Boolean of the consult
     */
    @Override
    public boolean isBitMap() {
        pixelList.forEach(Pixel::isPixBIT);
        return true;
    }

    /**
     * Method to verify if every pixel of the image is RGB type
     * @return Boolean of the consult
     */
    @Override
    public boolean isPixMap() {
        pixelList.forEach(Pixel::isPixRGB);
        return true;
    }

    /**
     * Method to verify if every pixel of the image is hexadecimal type
     * @return Boolean of the consult
     */
    @Override
    public boolean isHexMap() {
        pixelList.forEach(Pixel::isPixHEX);
        return true;
    }

    /**
     * Since this is an image class, it will never be compressed,
     * Compressed images has their own class
     * @return Boolean of the consult
     */
    @Override
    public boolean isCompressed(){
        return false;
    }

    /**
     * Method that flips the image horizontally
     * changing the position of every pixel
     */
    @Override
    public void flipH() {
        int largoImage = getLargo();
        for(Pixel p: pixelList) {p.flipH(largoImage);}
    }

    /**
     * Method that flips the image vertically
     * changing the position of every pixel
     */
    @Override
    public void flipV () {
        int altoImage = getAlto();
        for(Pixel p: pixelList) {p.flipV(altoImage);}
    }

    /**
     * Obtain a certain area of the image, this area
     * can be a square or a rectangle
     * @param x1 First X coordinate of the quadrant
     * @param y1 First Y coordinate of the quadrant
     * @param x2 Second X coordinate of the quadrant
     * @param y2 Second Y coordinate of the quadrant
     */
    @Override
    public void crop(int x1, int y1, int x2, int y2) {
        //filter the pixels that are inside the crop area
        List<Pixel> cropList = this.pixelList.stream()
                .filter(p ->
                        (p.getPosX() >= x1 && p.getPosX() <= x2 && p.getPosY() >= y1 && p.getPosY() <= y2))
                .collect(Collectors.toList());
        //get the new size of the image
        int newLargo = x2 - x1 + 1;
        int newAlto = y2 - y1 + 1;
        //set the new size of the image
        setLargo(newLargo);
        setAlto(newAlto);
        //set the new pixel list
        setPixelList(cropList);
    }

    /**
     * Method that changes pixel by pixel from RGB to hexadecimal type
     */
    @Override
    public void imgRGBToHex() {
        pixelList.forEach(Pixel::pixRGBToHex);
    }

    /**
     * Method that gets how many times each pixel color/content appears in the image
     * @return Histogram of colors/content
     */
    @Override
    public List<List<String>> histogram() {
        //get the content of every pixel in the image
        List<String> imageContent = new ArrayList<>();
        for(Pixel p: pixelList) {imageContent.add(p.getPixelContent());}
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
            (o1, o2) -> Integer.parseInt(o2.get(1)) - Integer.parseInt(o1.get(1)));
        //return the histogram
        return histogram;
    }

    /**
     * Method that rotates the image 90° clock-wise
     */
    @Override
    public void rotate90(){
        pixelList.forEach(Pixel::rotate90);
        //get the min value of the Y axis
        int minPosY = pixelList.stream().mapToInt(Pixel::getPosY).min().getAsInt();
        //translation to the origin
        for(Pixel p: pixelList) {p.translatePosY(-minPosY);}
    }

    /**
     * Get an alternative version of the image where the most repeated color/content is deleted but can be restored
     * @return Compressed Image
     */
    @Override
    public ImageCompressed compress(){
        int largoImage = getLargo();
        int altoImage = getAlto();
        //histogram
        List<List<String>> histogram = histogram();
        //get the most repeated pixel
        String mostRepeatedPixel = histogram.get(0).get(0);
        //make a new pixel list without the most repeated pixel
        List<Pixel> newPixelList = pixelList.stream()
                .filter(p -> !p.getPixelContent().equals(mostRepeatedPixel))
                .collect(Collectors.toList());
        //get the number of elements that are repeated
        int elementsRepeated = Integer.parseInt(histogram.get(0).get(1));
        return new ImageCompressed(largoImage, altoImage, newPixelList, mostRepeatedPixel, elementsRepeated);
    }

    /**
     * Method that changes the color/content of a determined pixel
     * @param posX X coordinate of the target pixel
     * @param posY Y coordinate of the target pixel
     * @param newContent New color/content
     */
    @Override
    public void changePixelContent(int posX, int posY, String newContent) {
        //get the pixel that is going to be changed
        Pixel pixelToChange = pixelList.stream()
                .filter(p -> p.getPosX() == posX && p.getPosY() == posY)
                .findFirst()
                .orElse(null);
        //change the content of the pixel
        assert pixelToChange != null;
        pixelToChange.setPixelContent(newContent);
    }

    /**
     * Method that changes the depth value of a determined pixel
     * @param posX X coordinate of the target pixel
     * @param posY Y coordinate of the target pixel
     * @param newDepth New depth value
     */
    @Override
    public void changePixelDepth(int posX, int posY, int newDepth) {
        //get the pixel that is going to be changed
        Pixel pixelToChange = pixelList.stream()
                .filter(p -> p.getPosX() == posX && p.getPosY() == posY)
                .findFirst()
                .orElse(null);
        //change the depth of the pixel
        assert pixelToChange != null;
        pixelToChange.setDepth(newDepth);
    }

    /**
     * Method that inverts the color of every BIT pixel type on an image
     */
    @Override
    public void invertColorBit(){
        pixelList.forEach(Pixel::invertColorBIT);
    }

    /**
     * Method that inverts the color of every RGB pixel type on an image
     */
    @Override
    public void invertColorRGB(){
        pixelList.forEach(Pixel::invertColorRGB);
    }

    /**
     * Method that sorts and transforms an image int oa string that can
     * be displayed on console
     * @return String with format
     */
    @Override
    public String imageToString() {
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
        //string creation with \n and \t
        StringBuilder imageString = new StringBuilder();
        for(int i = 0; i < pixelList.size(); i++) {
            if(i % largoImage == 0) {
                imageString.append("\n");
            }
            imageString.append(pixelList.get(i).getPixelContent()).append("\t");
        }
        return imageString.toString();
    }

    /**
     * Method that assumes that all the pixels of the image have the same depth
     * and takes the first pixel´s depth and uses it to generate new white pixels if
     * the image is not completed
     */
    @Override
    public void fillImage() {
        //get the depth of the first pixel
        int depth = pixelList.get(0).getDepth();
        //define a white pixel depending on the type of image
        String whitePixel = "";
        if(pixelList.get(0).isPixBIT()) {whitePixel = "0";}
        if(pixelList.get(0).isPixRGB()) {whitePixel = "255,255,255";}
        if(pixelList.get(0).isPixHEX()) {whitePixel = "FFFFFF";}
        //fill the image with white pixels
        List<List<Integer>> cordsToFill = findMissingPixels();
        for(List<Integer> cords:cordsToFill) {
            Pixel p = new Pixel(cords.get(0), cords.get(1), depth, whitePixel);
            pixelList.add(p);
            }
        }

    /**
     * Method that generates a new image for every different depth value on
     * the pixels
     * @return List of images
     */
    @Override
    public List<Image> separateByDepth(){
        List<Image> imageList = new ArrayList<>();
        int largoImage = getLargo();
        int altoImage = getAlto();
        
        List<Pixel> pixelList = getPixelList();   
        //get a list of the unique depths
        List<Integer> uniqueDepths = this.pixelList.stream().map(Pixel::getDepth).distinct().collect(Collectors.toList());
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
        //create a new image for each depth
        for(List<Pixel> p:pixelListByDepth) {
            Image image = new Image(largoImage, altoImage, p);
            imageList.add(image);
        }
        //fill the images with white pixels
        imageList.forEach(Image::fillImage);
        return imageList;
    }

    /**
     * Method that converts the image into a string with the image´s information
     * @return String
     */
    @Override
    public String toString() {
        return "Image{" +
                "Largo=" + largo +
                ", Alto=" + alto +
                ", PixelList=" + pixelList +
                '}';
    }
}
