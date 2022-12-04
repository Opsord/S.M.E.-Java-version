package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Testing image 1
        Pixel pixBIT01 = new Pixel(0,0,10,"1");
        Pixel pixBIT02 = new Pixel(0,1,10,"0");
        Pixel pixBIT03 = new Pixel(0,2,10,"1");
        Pixel pixBIT04 = new Pixel(1,0,10,"0");
        Pixel pixBIT05 = new Pixel(1,1,10,"1");
        Pixel pixBIT06 = new Pixel(1,2,10,"0");
        Pixel pixBIT07 = new Pixel(2,0,10,"0");
        Pixel pixBIT08 = new Pixel(2,1,10,"0");
        Pixel pixBIT09 = new Pixel(2,2,10,"1");
        //definition of bitmap01
        List<Pixel> bitmap01 = new ArrayList<>();
        bitmap01.add(pixBIT01);
        bitmap01.add(pixBIT02);
        bitmap01.add(pixBIT03);
        bitmap01.add(pixBIT04);
        bitmap01.add(pixBIT05);
        bitmap01.add(pixBIT06);
        bitmap01.add(pixBIT07);
        bitmap01.add(pixBIT08);
        bitmap01.add(pixBIT09);
        //definition of imageBIT01
        Image_200958322_ZelayaDroguett image200958322ZelayaDroguettBIT01 = new Image_200958322_ZelayaDroguett(3,3,bitmap01);

        //create menu
        List<Image_200958322_ZelayaDroguett> availableImage200958322ZelayaDroguetts = new ArrayList<>();
        List<ImageCompressed_200958322_ZelayaDroguett> availableCompressedImages = new ArrayList<>();
        Menu_200958322_ZelayaDroguett menu200958322ZelayaDroguett = new Menu_200958322_ZelayaDroguett(availableImage200958322ZelayaDroguetts, availableCompressedImages);
        //add imageBIT01 to menu
        availableImage200958322ZelayaDroguetts.add(image200958322ZelayaDroguettBIT01);

        boolean exit = false;
        int option = -1;
        

        //create scanner
        try (Scanner principalScanner = new Scanner(System.in)) {
            while (!exit) {
                Menu_200958322_ZelayaDroguett.printHeader();
                Menu_200958322_ZelayaDroguett.printPrincipalMenu();

                System.out.print("\nPlease select an option: ");
                if(principalScanner.hasNext()){
                    option = principalScanner.nextInt();
                } 
                //principalMenu(option);
                switch(option) {
                    case 0:
                        exit = true;
                        System.out.println("Thank you for using the program <3");
                        break;
                    case 1:
                        menu200958322ZelayaDroguett.listAvailableImages();
                        break;    
                    case 2:
                        menu200958322ZelayaDroguett.listAvailableImages();
                        System.out.println("Now you can select an image: ");
                        option = principalScanner.nextInt();
                        menu200958322ZelayaDroguett.selectImageFromList(option);
                        menu200958322ZelayaDroguett.printSelectedImage();
                        break;   
                    case 3:
                        Image_200958322_ZelayaDroguett newImage200958322ZelayaDroguett;
                        System.out.println("You will now create a new image from scratch");
                        newImage200958322ZelayaDroguett = menu200958322ZelayaDroguett.createImageFromScratch();
                        menu200958322ZelayaDroguett.addImageToList(newImage200958322ZelayaDroguett);
                        System.out.println("\nImage created successfully");
                        break;
                    case 4:
                        //image selection
                        System.out.println("You will now manipulate an image");
                        menu200958322ZelayaDroguett.listAvailableImages();
                        System.out.print("\nPlease select an image: ");
                        int imageToManipulate = principalScanner.nextInt();
                        menu200958322ZelayaDroguett.selectImageFromList(imageToManipulate-1);
                        System.out.println("Image selected successfully");
                        menu200958322ZelayaDroguett.printSelectedImage();
                        //image manipulation
                        Menu_200958322_ZelayaDroguett.printEditingMenu();
                        System.out.print("\nPlease select what do you want to do with the image: ");
                        option = principalScanner.nextInt();
                        menu200958322ZelayaDroguett.editingMenu(option);
                        break;                
                    case 5:

                        Menu_200958322_ZelayaDroguett.printImageUtilitiesMenu();
                        System.out.print("\nPlease select what do you want to do with the image: ");
                        option = principalScanner.nextInt();
                        menu200958322ZelayaDroguett.imageUtilitiesMenu(option);
                        break;
                    default: 
                        System.out.println("Invalid option");
                        break;
                }
            }
        }
        catch (InputMismatchException e) {
            System.out.println("+---------------------------------------------------------------------------+");
            System.out.println("|     Oh no! Something went wrong, please try again with a valid option     |");
            System.out.println("+---------------------------------------------------------------------------+");
        }
    }
}
