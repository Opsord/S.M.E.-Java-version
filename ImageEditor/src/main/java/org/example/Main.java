package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //create menu
        List<Image> availableImages = new ArrayList<>();
        List<ImageCompressed> availableCompressedImages = new ArrayList<>();
        Menu menu = new Menu(availableImages, availableCompressedImages);

        boolean exit = false;
        int option = -1;
        

        //create scanner
        try (Scanner principalScanner = new Scanner(System.in)) {
            while (!exit) {
                Menu.printHeader();
                Menu.printPrincipalMenu();

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
                        menu.listAvailableImages();
                        break;    
                    case 2:
                        menu.listAvailableImages();
                        System.out.println("Now you can select an image: ");
                        option = principalScanner.nextInt();
                        menu.selectImageFromList(option);
                        menu.printSelectedImage();
                        break;   
                    case 3:
                        Image newImage;
                        System.out.println("You will now create a new image from scratch");
                        newImage = menu.createImageFromScratch();
                        menu.addImageToList(newImage);
                        System.out.println("\nImage created successfully");
                        break;
                    case 4:
                        //image selection
                        System.out.println("You will now manipulate an image");
                        menu.listAvailableImages();
                        System.out.print("\nPlease select an image: ");
                        int imageToManipulate = principalScanner.nextInt();
                        menu.selectImageFromList(imageToManipulate-1);
                        System.out.println("Image selected successfully");
                        menu.printSelectedImage();
                        //image manipulation
                        Menu.printEditingMenu();
                        System.out.print("\nPlease select what do you want to do with the image: ");
                        option = principalScanner.nextInt();
                        menu.editingMenu(option);
                        break;                
                    case 5:

                        Menu.printImageUtilitiesMenu();
                        System.out.print("\nPlease select what do you want to do with the image: ");
                        option = principalScanner.nextInt();
                        menu.imageUtilitiesMenu(option);
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
