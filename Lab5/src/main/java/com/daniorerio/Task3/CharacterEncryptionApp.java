package com.daniorerio.Task3;

import java.io.*;
import java.util.Scanner;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class CharacterEncryptionApp {
    private static final Logger logger = LogManager.getLogger(CharacterEncryptionApp.class);

    public static void main(String[] args) {
        Configurator.setRootLevel(Level.INFO);
        try (Scanner scanner = new Scanner(System.in)) {
            logger.info("Запуск програми шифрування/розшифрування.");

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
                logger.info("Шифрування файлу: {}", inputFilePath);
                try (Encryptor encryptor = new Encryptor(encryptedFileStream, keyChar)) {
                    int data;
                    while ((data = inputFileStream.read()) != -1) {
                        encryptor.write(data);
                    }
                }
                logger.info("Шифрування завершено, збережено в {}", encryptedFilePath);

                logger.info("Розшифрування файлу: {}", encryptedFilePath);
                try (Decryptor decryptor = new Decryptor(new FileInputStream(encryptedFilePath), keyChar)) {
                    int data;
                    while ((data = decryptor.read()) != -1) {
                         decryptedFileStream.write(data);
                    }
                }
                logger.info("Розшифрування завершено, збережено в {}", decryptedFilePath);

                logger.info("Файл зашифровано і розшифровано успішно.");

            } catch (IOException e) {
                logger.fatal("Помилка при обробці файлу: {}", e.getMessage());
            }
        }
    }
}