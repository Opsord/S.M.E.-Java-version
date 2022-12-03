package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class with specific methods and elements for a functional menu
 *
 * @author Andres Zelaya Droguett
 */
public class Menu {

    /**
     * Image that is selected for manipulation
     */
    private Image selectedImage;

    /**
     * List of all available images for manipulation
     */
    private final List<Image> availableImages;

    /**
     * List of available compressed images
     */
    private final List<ImageCompressed> compressedImages;

    //constructor
    public Menu(List<Image> availableImages, List<ImageCompressed> compressedImages) {
        this.availableImages = availableImages;
        this.compressedImages = compressedImages;
    }

    //menu utility methods
    /**
     * Method to set as selectedImage a determined image from availableImages list
     * @param index Position of the image in the list
     */
    public void selectImageFromList(int index) {
        this.selectedImage = availableImages.get(index);
    }

    /**
     * Method that adds a given image to the list of available images
     * @param image Image that will be added to the list
     */
    public void addImageToList(Image image) {
        this.availableImages.add(image);
    }

    /**
     * Method that updates an image on the list with the selected image
     * @param selectedImage Image that will replace the old
     * @param OldImage Old image
     */
    public void modifyImageInList(Image selectedImage, Image OldImage) {
        for(Image image : availableImages) {
            if(image == OldImage) {
                image = selectedImage;
                break;
            }
        }
    }

    /**
     * Method that prints a list with the available images
     */
    public void listAvailableImages() {
        int i = 0;
        System.out.println("Available images:");
        System.out.println("------------------------------------------------------------");
        while(i < availableImages.size()) {
            System.out.println((i+1) + ". " + availableImages.get(i).toString());
            System.out.println("------------------------------------------------------------");
            i++;
        }
    }

    /**
     * Method that prints a list with the available compressed images
     */
    public void listAvailableCompressedImages(){
        int k = 0;
        System.out.println("Available images:");
        System.out.println("-------------------------------------------------------------");
        while(k < compressedImages.size()) {
            System.out.println((k+1) + ". " + compressedImages.get(k).toString());
            System.out.println("-------------------------------------------------------------");
            k++;
        }
    }

    /**
     * Method that displays as image the selected image
     */
    public void printSelectedImage() {
        System.out.println("\nSelected image:");
        System.out.println("----------------------------------------");
        System.out.println(selectedImage.imageToString());
        System.out.println("----------------------------------------");
    }

    /**
     * Method that allows the user to create a custom image with custom colors in any format
     * @return New image
     */
    public Image createImageFromScratch() {
        Scanner imageCreatorScanner = new Scanner(System.in);
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
        System.out.println("\nThis will accept any color format, but they need to be all of the same type");
        System.out.println("Now please enter the image's pixels one by one: ");

        while (i < largo) {
            k = 0;
            while (k < alto) {
                System.out.println("\nCurrently at pixel: " + i + ", " + k);
                System.out.print("Please enter the pixel's color/content: ");
                pixelContent = imageCreatorScanner.next();
                System.out.print("Please enter the pixel's depth: ");
                depth = imageCreatorScanner.nextInt();

                Pixel pixel = new Pixel(i, k, depth, pixelContent);
                pixelList.add(pixel);
                k++;
            }
            i++;
        }
        return new Image(largo, alto, pixelList);
    }
    

    //specific menu printing methods

    /**
     * Method that displays the header of the program
     */
    public static void printHeader() {
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|                  Welcome to the Image Creator                  |");
        System.out.println("|                  and Manipulator project(IMC)                  |");
        System.out.println("|                  (programed by Andres Zelaya)                  |");
        System.out.println("+----------------------------------------------------------------+");
    }

    /**
     * Method that displays the principal menu options
     */
    public static void printPrincipalMenu() {
        System.out.println("\nWhat do you want to do?");
        System.out.println("1. List available images");
        System.out.println("2. Select an image");
        System.out.println("3. Create a new image from scratch");
        System.out.println("4. Manipulate an image");
        System.out.println("5. Image utilities");
        System.out.println("0. Exit");
    }

    /**
     * Method that displays the editing menu
     */
    public static void printEditingMenu() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Flip image");                                  //-> flipOptions() MENU
        System.out.println("2. Crop image");                                  //-> cropO() METHOD
        System.out.println("3. Rotate image");                                //-> rotateOPTIONS() MENU
        System.out.println("4. Change a pixel");                               //-> changePixel METHOD
        System.out.println("5. Color inversion");                             //-> colorInversionOptions MENU
        System.out.println("0. Return to main menu");
    }

    /**
     * Method that displays the flip options
     */
    public static void printFlipOptions() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Flip image vertically");                       //-> flipVertically METHOD
        System.out.println("2. Flip image horizontally");                     //-> flipHorizontally METHOD   
        System.out.println("0. Return to main menu");
    }

    /**
     * Method that displays the rotation options
     */
    public static void printRotationOptions() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Rotate image 90 degrees clockwise");           //-> rotate90 METHOD
        System.out.println("2. Rotate image 90 degrees counterclockwise");    //-> rotate90 x3 METHOD
        System.out.println("3. Rotate image 180 degrees");                    //-> rotate90 x2 METHOD
        System.out.println("0. Return to main menu");
    }

    /**
     * Method that displays the options to change a pixel
     */
    public static void printChangePixelOptions() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Change a pixel's color");                      //-> changePixelContent METHOD
        System.out.println("2. Change a pixel's depth");                      //-> changePixelDepth METHOD
        System.out.println("0. Return to main menu");
    }

    /**
     * Method to display the utilities menu
     */
    public static void printImageUtilitiesMenu() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Display an image");
        System.out.println("2. Verify an image's type");
        System.out.println("3. Compress an image");
        System.out.println("4. Show compressed images");
        System.out.println("5. Decompress an image");
        System.out.println("6. Make an histogram of an image");
        System.out.println("7. Separate by depth layers");
        System.out.println("0. Return to main menu");
    }

    /**
     * Method that allows image manipulation given a certain option
     * @param option Statement used
     */
    public void editingMenu(int option){
        //generate a new scanner
        Scanner editingScanner = new Scanner(System.in);
        switch (option) {
            case 0:
                System.out.println("Back to the menu");
                break;
            case 1:
                System.out.println("You will flip the selected image");
                printFlipOptions();
                System.out.print("Please choose the type of flip: ");
                option = editingScanner.nextInt();
                flipMenu(option);
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
                printRotationOptions();
                option = editingScanner.nextInt();
                rotationMenu(option);
                break;
            case 4:
                printChangePixelOptions();
                option = editingScanner.nextInt();
                changePixelMenu(option);
                break;
            case 5:
                Image oldImage =  selectedImage;
                System.out.println("Select the image which will have it´s colors inverted");
                System.out.println("(Only for BIT and RGB images)");
                listAvailableImages();
                System.out.print("Your selection: ");
                option = editingScanner.nextInt();
                selectImageFromList(option-1);
                if(selectedImage.isBitMap()){
                    selectedImage.invertColorBit();
                } else if (selectedImage.isPixMap()) {
                    selectedImage.invertColorRGB();
                }
                modifyImageInList(selectedImage, oldImage);
                System.out.println("Colors inverted successfully");
                printSelectedImage();
                break;
            default:
                System.out.println("You have entered an invalid input");
                break;
        }
    }

    /**
     * Method that performs a flip type action to the image
     * @param option Flip action performed
     */
    public void flipMenu(int option){
        switch (option){
            case 0:
                System.out.println("Back to the menu");
                break;
            case 1:
                Image oldImageH = selectedImage;
                selectedImage.flipH();
                modifyImageInList(selectedImage, oldImageH);
                System.out.println("Flipped successfully");
                printSelectedImage();
                break;
            case 2:
                Image oldImageV = selectedImage;
                selectedImage.flipV();
                modifyImageInList(selectedImage, oldImageV);
                System.out.println("Flipped successfully");
                printSelectedImage();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    /**
     * Method that performs a rotation type action to the image
     * @param option Rotation type used
     */
    public void rotationMenu(int option){
        switch (option){
            case 0:
                System.out.println("Back to the menu");
                break;
            case 1:
                Image oldImage90 = selectedImage;
                selectedImage.rotate90();
                modifyImageInList(selectedImage, oldImage90);
                System.out.println("Rotated successfully");
                printSelectedImage();
                break;
            case 2:
                Image oldImage270 = selectedImage;
                selectedImage.rotate90();
                selectedImage.rotate90();
                selectedImage.rotate90();
                modifyImageInList(selectedImage, oldImage270);
                System.out.println("Rotated successfully");
                printSelectedImage();
                break;
            case 3:
                Image oldImage180 = selectedImage;
                selectedImage.rotate90();
                selectedImage.rotate90();
                modifyImageInList(selectedImage, oldImage180);
                System.out.println("Rotated successfully");
                printSelectedImage();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    /**
     * Method that performs specific pixel changes to the image
     * @param option Type of pixel change
     */
    public void changePixelMenu(int option){
        Scanner pixelScanner = new Scanner(System.in);
        int posX;
        int posY;
        System.out.println("Choose the coordinates of the target pixel");
        System.out.print("X: ");
        posX = pixelScanner.nextInt();
        System.out.print("Y: ");
        posY = pixelScanner.nextInt();
        switch (option){
            case 0:
                System.out.println("Back to the menu");
                break;
            case 1:
                String color;
                Image oldImageColor = selectedImage;
                System.out.println("Choose the new color/content of the pixel");
                System.out.print("Color: ");
                color = pixelScanner.next();
                selectedImage.changePixelContent(posX, posY, color);
                modifyImageInList(selectedImage, oldImageColor);
                System.out.println("Color changed successfully");
                printSelectedImage();
                break;
            case 2:
                int depth;
                Image oldImageDepth = selectedImage;
                System.out.println("Choose the new depth of the pixel");
                System.out.print("Depth: ");
                depth = pixelScanner.nextInt();
                selectedImage.changePixelDepth(posX, posY, depth);
                modifyImageInList(selectedImage, oldImageDepth);
                System.out.println("Depth changed successfully");
                printSelectedImage();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    /**
     * Method that performs the utility actions from the menu
     * @param option Action that will be performed
     */
    public void imageUtilitiesMenu(int option) {
        Scanner utilitiesMenu = new Scanner(System.in);
        switch (option) {
            case 0:
                System.out.println("Back to menu");
                break;
            case 1:
                System.out.println("Select the image that you want to display");
                listAvailableImages();
                System.out.print("\nYour choice: ");
                option = utilitiesMenu.nextInt();
                selectImageFromList(option - 1);
                printSelectedImage();
                break;
            case 2:
                System.out.println("Select the image that you want to verify");
                listAvailableImages();
                System.out.print("\nYour choice: ");
                option = utilitiesMenu.nextInt();
                selectImageFromList(option - 1);
                if (selectedImage.isPixMap()) {
                    System.out.println("The image is BIT type");
                } else if (selectedImage.isPixMap()) {
                    System.out.println("The image is RGB type");
                } else if (selectedImage.isHexMap()) {
                    System.out.println("The image is hexadecimal type");
                }
                break;
            case 3:
                ImageCompressed imageCompressed;
                System.out.println("Select the image that you want to compress");
                listAvailableImages();
                System.out.print("\nYour choice: ");
                option = utilitiesMenu.nextInt();
                selectImageFromList(option - 1);
                imageCompressed = selectedImage.compress();
                compressedImages.add(imageCompressed);
                System.out.println("Image compressed successfully");
                break;
            case 4:
                listAvailableCompressedImages();
                break;
            case 5:
                System.out.println("Select the image that you want to decompress");
                listAvailableCompressedImages();
                System.out.print("\nYour choice: ");
                option = utilitiesMenu.nextInt();
                selectedImage = compressedImages.get(option - 1).decompress();
                availableImages.add(selectedImage);
                System.out.println("Image decompressed successfully");
                printSelectedImage();
                break;
            case 6:
                System.out.println("Select the image that you want to sue for the histogram");
                listAvailableImages();
                System.out.print("\nYour choice: ");
                option = utilitiesMenu.nextInt();
                selectImageFromList(option - 1);
                System.out.println("This is the histogram: ");
                System.out.println(selectedImage.histogram());
                break;
            case 7:
                List<Image> separatedImages;
                System.out.println("Select the image that you want to separate by depth");
                listAvailableCompressedImages();
                System.out.print("\nYour choice: ");
                option = utilitiesMenu.nextInt();
                selectImageFromList(option - 1);
                separatedImages = selectedImage.separateByDepth();
                availableImages.addAll(separatedImages);
                System.out.println("Image separated, check on available list");
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }
}