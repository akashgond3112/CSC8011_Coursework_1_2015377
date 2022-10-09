import csc8011.MuseumIO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");



        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name of the museum");
//        String museumName = sc.nextLine();
        MuseumIO museumIO =new MuseumIO("museumName");
        museumIO.readCsv();


    }
}