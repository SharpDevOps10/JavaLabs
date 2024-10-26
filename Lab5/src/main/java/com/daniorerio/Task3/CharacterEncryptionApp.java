package com.daniorerio.Task3;

import java.io.*;
import java.util.Scanner;

public class CharacterEncryptionApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть шлях до вхідного файлу: ");
        String inputFilePath = scanner.nextLine();
        System.out.print("Введіть шлях до файлу для збереження зашифрованих даних: ");
        String encryptedFilePath = scanner.nextLine();
        System.out.print("Введіть шлях до файлу для збереження розшифрованих даних: ");
        String decryptedFilePath = scanner.nextLine();
        System.out.print("Введіть ключовий символ для шифрування: ");
        char keyChar = scanner.next().charAt(0);

        try (
                FileInputStream inputFileStream = new FileInputStream(inputFilePath);
                FileOutputStream encryptedFileStream = new FileOutputStream(encryptedFilePath);
                FileOutputStream decryptedFileStream = new FileOutputStream(decryptedFilePath)
        ) {
            try (Encryptor encryptor = new Encryptor(encryptedFileStream, keyChar)) {
                int data;
                while ((data = inputFileStream.read()) != -1) {
                    encryptor.write(data);
                }
            }

            try (Decryptor decryptor = new Decryptor(new FileInputStream(encryptedFilePath), keyChar)) {
                int data;
                while ((data = decryptor.read()) != -1) {
                    ((OutputStream) decryptedFileStream).write(data);
                }
            }

            System.out.println("Файл зашифровано і розшифровано успішно.");

        } catch (IOException e) {
            System.out.println("Помилка при обробці файлу: " + e.getMessage());
        }
    }
}