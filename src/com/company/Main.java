package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;

        String name = "";
        String ReadyZprava = "";
        int Count = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("messages"));
            String nextLine = br.readLine();
            while (nextLine != null) {
                ReadyZprava += nextLine + "\n";
                nextLine = br.readLine();
                Count++;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Bohužel se nepovedlo program načíst, zkuste to znovu později.");
        }
        String zprava;
        System.out.println("Zadej jméno:");
        name = sc.nextLine();
        System.out.println("----------------");
        if (Count == 0)
            System.out.println(name + " nemáš tu žádné zprávy");
        if (Count == 1) {
            System.out.println(name + " máš tu " + Count + " zprávu:");
        }
        if (Count == 2) {
            System.out.println(name + " máš tu " + Count + " zprávy:");
        }
        if (Count == 3) {
            System.out.println(name + " máš tu " + Count + " zprávy:");
        }
        if (Count == 4) {
            System.out.println(name + " máš tu " + Count + " zprávy:");
        }
        if (Count >= 5) {
            System.out.println(name + " máš tu " + Count + " zpráv:");
        }
        System.out.println(ReadyZprava);
        System.out.println("----------------");
        System.out.println("Zadej zprávu:");
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