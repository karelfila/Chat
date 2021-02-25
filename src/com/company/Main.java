package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;
        String ReadyZprava = "";
        String name = "";


        try {
                BufferedReader br = new BufferedReader(new FileReader("messages"));
                ReadyZprava = br.readLine();
            } catch (IOException e) {
            System.out.println("Bohužel se nepovedlo program načíst, zkuste to znovu později.");
        }


        String zprava;
        System.out.println("Zadej jméno:");
        name = sc.nextLine();
        System.out.println("----------------");
        System.out.println(name + " máš tu zprávu: ");
        System.out.println(ReadyZprava);
        System.out.println("----------------");
        while (a == 0) {
            zprava = sc.nextLine();
            if (zprava.equals("!konec")) {
                break;
            }
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("messages", true));

                bw.write(name + ": " + zprava);
                bw.newLine();
                bw.close();

            } catch (IOException e) {
                System.out.println("Bohužel se nepovedlo vaši zprávu nahrát.");
            }
        }
    }
}