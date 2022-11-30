package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class ImageFormat {

    //Image elements
    int largo;

    int alto;

    List<Pixel> pixelList;

    //getter
    public int getLargo() {
        return this.largo;
    }

    public int getAlto() {
        return this.alto;
    }

    public List<Pixel> getPixelList() {
        return this.pixelList;
    }

    //method to check if the image is compressed
    public abstract boolean isCompressed();

    //method to find missing pixel coordinates on a list
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
