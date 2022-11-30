package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private Image selectedImage;

    private List<Image> availableImages;

    private List<ImageCompressed> compressedImages;

    //constructor
    public Menu(List<Image> availableImages, List<ImageCompressed> compressedImages) {
        this.availableImages = availableImages;
        this.compressedImages = compressedImages;
    }

    

    //getters
    public Image getSelectedImage() {
        return selectedImage;
    }

    public List<Image> getAvailableImages() {
        return availableImages;
    }

    public List<ImageCompressed> getAvailableCompressedImages() {
        return compressedImages;
    }



    //setters
    public void setSelectedImage(Image selectedImage) {
        this.selectedImage = selectedImage;
    }

    public void setAvailableImages(List<Image> availableImages) {
        AvailableImages = availableImages;
    }

    public void setAvailableCompressedImages(List<ImageCompressed> availableCompressedImages) {
        this.CompressedImages = availableCompressedImages;
    }



    //menu utility methods
    public void selectImageFromList(int index) {
        selectedImage = AvailableImages.get(index);
    }

    public void addImageToList(Image image) {
        AvailableImages.add(image);
    }

    public void addCompressedImageToList(ImageCompressed image) {
        CompressedImages.add(image);
    }

    public void modifyImageInList(Image selectedImage, Image OldImage) {
        for(Image image : AvailableImages) {
            if(image == OldImage) {
                image = selectedImage;
            }
        }
    }

    public void listAvailableImages() {
        int i = 0;
        System.out.println("Available images:");
        System.out.println("------------------------------------------------------------");
        while(i < AvailableImages.size()) {
            System.out.println((i+1) + ". " + AvailableImages.get(i).toString());
            System.out.println("------------------------------------------------------------");
            i++;
        }
    }

    public void printSelectedImage() {
        System.out.println("\nSelected image:");
        System.out.println("----------------------------------------");
        System.out.println(selectedImage.imageToString());
        System.out.println("----------------------------------------");
    }

    public Image createImageFromScratch() {
        try (Scanner imageCreatorScanner = new Scanner(System.in)) {
            int largo;
            int alto;
            int depth;
            int i = 0;
            int k;
            String pixelContent;
            List<Pixel> pixelList = new ArrayList<>();
           
            //receive inputs from user to create a new image
            System.out.print("\nPlease enter the image's long: ");
            largo = imageCreatorScanner.nextInt();
            System.out.print("\nPlease enter the image's height: ");
            alto = imageCreatorScanner.nextInt();
            System.out.println("\nNow please enter the image's pixels one by one: ");
            
            while (i < largo) {
                k = 0;
                while (k < alto) {
                    System.out.println("Currently at pixel: " + i + ", " + k);
                    System.out.print("\nPlease enter the pixel's color/content: ");
                    pixelContent = imageCreatorScanner.nextLine();

                    System.out.print("\nPlease enter the pixel's depth: ");
                    depth = imageCreatorScanner.nextInt();

                    Pixel pixel = new Pixel(i, k, depth, pixelContent);
                    pixelList.add(pixel);
                    k++;
                }
                i++;
            }
            
        //imageCreatorScanner.close();
        Image newImage = new Image(largo, alto, pixelList);
        return newImage;
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input, please try again.");
            return null;
        }
    }

    

    //specific menu printing methods
    public static void printHeader() {
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|                  Welcome to the Image Creator                  |");
        System.out.println("|                  and Manipulator project(IMC)                  |");
        System.out.println("|                  (programed by Andres Zelaya)                  |");
        System.out.println("+----------------------------------------------------------------+");
    }

    public static void printPrincipalMenu() {
        System.out.println("\nWhat do you want to do?");
        System.out.println("1. Display available images");
        System.out.println("2. Select an image");
        System.out.println("3. Create a new image from scratch");
        System.out.println("4. Manipulate an image");
        System.out.println("5. Image utilities");
        System.out.println("0. Exit");
    }

    public static void printEditingMenu() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Flip image");                                  //-> flipOptions() MENU
        System.out.println("2. Crop image");                                  //-> cropO() METHOD
        System.out.println("3. Rotate image");                                //-> rotateOPTIONS() MENU
        System.out.println("4. Change pixels");                               //-> changePixel METHOD
        System.out.println("5. Color inversion");                             //-> colorInversionOptions MENU
        System.out.println("0. Return to main menu");
    }

    public static void printFlipOptions() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Flip image vertically");                       //-> flipVertically METHOD
        System.out.println("2. Flip image horizontally");                     //-> flipHorizontally METHOD   
        System.out.println("0. Return to main menu");
    }

    public static void printRotationOptions() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Rotate image 90 degrees clockwise");           //-> rotate90 METHOD
        System.out.println("2. Rotate image 90 degrees counterclockwise");    //-> rotate90 x3 METHOD
        System.out.println("3. Rotate image 180 degrees");                    //-> rotate90 x2 METHOD
        System.out.println("0. Return to main menu");
    }

    public static void printChangePixelOptions() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Change a pixel's color");                      //-> changePixelContent METHOD
        System.out.println("2. Change a pixel's depth");                      //-> changePixelDepth METHOD
        System.out.println("0. Return to main menu");
    }
    
    public static void printColorInversionOptions() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Invert a BIT image");                          //-> invertColorBit METHOD
        System.out.println("2. Invert a RGB image");                          //-> invertColorRGB METHOD
        System.out.println("0. Return to main menu");
    }

    public static void printImageUtilitiesMenu() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Display an image");
        System.out.println("2. Delete an image");
        System.out.println("3. Verify an image's type");
        System.out.println("4. Compress an image");
        System.out.println("5. Decompress an image");
        System.out.println("6. Make an histogram of an image");
        System.out.println("0. Return to main menu");
    }

    public static void printImageTypeMenu() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Verify if an image is a BIT image");
        System.out.println("2. Verify if an image is a RGB image");
        System.out.println("0. Return to main menu");
    }




    //specific menu methods
    public void editingMenu(int option){
        //generate a new scanner
        try (Scanner editingScanner = new Scanner(System.in)) {
            switch (option) {
                case 1:
                    System.out.println("You will flip the selected image");
                    printFlipOptions();
                    System.out.print("Please choose the type of flip: ");
                    //int newOption = editingScanner.nextInt();
                    //flipMenu(newOption);
                    break;
                case 2:
                    //crop method
                    int posX1;
                    int posY1;
                    int posX2;
                    int posY2;
                    Image newImage;
                    System.out.println("You will crop an area of the selected image");
                    System.out.println("Please enter the coordinates of the first corner of the area you want to crop");
                    System.out.print("X: ");
                    posX1 = editingScanner.nextInt();
                    System.out.print("Y: ");
                    posY1 = editingScanner.nextInt();
                    System.out.println("Please enter the coordinates of the second corner of the area you want to crop");
                    System.out.print("X: ");
                    posX2 = editingScanner.nextInt();
                    System.out.print("Y: ");
                    posY2 = editingScanner.nextInt();
                    newImage = selectedImage;
                    newImage.crop(posX1, posY1, posX2, posY2);
                    modifyImageInList(newImage, selectedImage);
                    printSelectedImage();
                    break;
                case 3:
                    //rotateOptions();
                    break;
                case 4:
                    //changePixelOptions();
                    break;
                case 5:
                    //colorInversionOptions();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("You have entered an invalid input");
                    break;
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Oh Oh! Unknown error");
        }
    }
}