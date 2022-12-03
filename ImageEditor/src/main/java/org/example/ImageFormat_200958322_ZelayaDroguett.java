package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the regular format of an image, normal or compressed
 *
 * @author Andres Zelaya Droguett
 */
public abstract class ImageFormat_200958322_ZelayaDroguett {

    /**
     * Long of the image
     */
    int largo;

    /**
     * High of the image
     */
    int alto;

    /**
     * List of pixels that compose the image
     */
    List<Pixel> pixelList;

    /**
     * Method that gets how long in terms of pixels the image is
     * @return Long of the image
     */
    public int getLargo() {
        return this.largo;
    }

    /**
     * Methods that gets how high in terms of pixels the image is
     * @return High of the image
     */
    public int getAlto() {
        return this.alto;
    }

    /**
     * Method to change the long dimension of an image
     * @param largo New long
     */
    public void setLargo(int largo) {
        this.largo = largo;
    }

    /**
     * Method to change the high dimension of an image
     * @param alto New high
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }

    /**
     * Method that gets the list of pixels that compose the image
     * @return List of pixels
     */
    public List<Pixel> getPixelList() {
        return this.pixelList;
    }

    /**
     * Methods that checks if the image is compressed
     * @return Boolean of the consult
     */
    public abstract boolean isCompressed();

    /**
     * Methods that gets the coordinates of missing pixels of an image
     * @return List of coordinates
     */
    public List<List<Integer>> findMissingPixels(){
        int largoImage = getLargo();
        int altoImage = getAlto();
        //get the list of pixels
        List<Pixel> pixelList = getPixelList();
        //create a list to store the missing pixels
        List<List<Integer>> missingPixels = new ArrayList<>();
        for(int i = 0; i < altoImage; i++){
            int posX = i;
            for(int j = 0; j < largoImage; j++){
                int posY = j;
                //create a list to store the coordinates of the missing pixel
                List<Integer> missingPixel = new ArrayList<>();
                //check if exist a pixel with the same coordinates
                boolean exist = pixelList.stream().anyMatch(pixel -> pixel.getPosX() == posX && pixel.getPosY() == posY);
                if(!exist){
                    missingPixel.add(posX);
                    missingPixel.add(posY);
                    missingPixels.add(missingPixel);
                }
            }
        }
        return missingPixels;
    }
}
