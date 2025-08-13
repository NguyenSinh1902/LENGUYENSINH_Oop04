package org.example;

import java.util.Scanner;

public class PersonalInfo {
    public static void main(String[] args) {
        String name;
        int age;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        name = scanner.nextLine();

        System.out.print("Enter your age: ");
        age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your index: ");
        String index = scanner.nextLine();

        //output
        System.out.println("Your name is " + name + "you are is" + age);
    }
}
