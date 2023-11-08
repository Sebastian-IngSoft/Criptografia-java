/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gfg;

/**
 *
 * @author sebas
 */
// Java Program to Perform Cryptography adaptado por Luis Rivera
// using Transposition Technique
 // Importing all classes from
// java.util package
// Importing input output classes
import java.io.*;
import java.util.*;
 // Class
// For transposition cipher
public class GFG {
    // Member variables of this class
    public static String selectedKey;
    public static char sortedKey[];
    public static int sortedKeyPos[];
    // Constructor 1 of this class
    // Default constructor defining the default key
    public GFG()
    {
        selectedKey = "megabuck";
        sortedKeyPos = new int[selectedKey.length()];
        sortedKey = selectedKey.toCharArray();
    }
    // Constructor 2 of this class
    // Parameterized constructor defining the custom key
    public GFG(String GeeksForGeeks)
    {
        selectedKey = GeeksForGeeks;
        sortedKeyPos = new int[selectedKey.length()];
        sortedKey = selectedKey.toCharArray();
    }

    // Method 1 - doProcessOnKey()
    // To reorder data do the sorting on selected key
    public static void doProcessOnKey(){
        // encontrar la posicion para cada caracter
        // y ordenado alfabeticamenete
        char[] originalKey = selectedKey.toCharArray();
        char[] sortedKey = Arrays.copyOf(originalKey, originalKey.length);

        // Step 1: ordenar el array
        Arrays.sort(sortedKey);

        // Step 2: llenando la de acuerdo al orden alfabetico
        for (int i = 0; i < selectedKey.length(); i++) {
            char currentChar = originalKey[i];
            int position = Arrays.binarySearch(sortedKey, currentChar);
            sortedKeyPos[i] = position;
        }
    }
    // Method 2 - doEncryption()
    // To encrypt the targeted string
    
    public static String doEncryption(String plainText) {
    doProcessOnKey(); // Llamar a la función para procesar la clave
    
        int numRows = (int) Math.ceil((double) plainText.length() / selectedKey.length());
        char[][] matrix = new char[numRows][selectedKey.length()];

        // Llenar la matriz con el texto plano y caracteres de relleno
        int textIndex = 0;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < selectedKey.length(); col++) {
                if (textIndex < plainText.length()) {
                    matrix[row][col] = plainText.charAt(textIndex++);
                } else {
                    matrix[row][col] = '-';
                }
            }
        }

        // Construir el mensaje encriptado a partir de la matriz
        char[] encryptedMessage = new char[plainText.length()];
        int encryptedIndex = 0;

        for (int i = 0; i < selectedKey.length(); i++) {
            int columnIndex = sortedKeyPos[i];
            for (int j = 0; j < numRows; j++) {
                encryptedMessage[encryptedIndex++] = matrix[j][columnIndex];
            }
        }

        return new String(encryptedMessage);
    }

    
    // Method 3 - doEncryption()
    // To decrypt the targeted string
    
    
    public static String doDecryption(String s) {
        doProcessOnKey(); // Llamar a la función para procesar la clave

        char[] encryptedMessage = s.toCharArray();
        int numRows = s.length() / selectedKey.length();
        char[][] matrix = new char[numRows][selectedKey.length()];

        int tempcnt = -1;

        // Reconstruir la matriz a partir del mensaje encriptado
        for (int i = 0; i < selectedKey.length(); i++) {
            int columnIndex = sortedKeyPos[i];
            for (int j = 0; j < numRows; j++) {
                tempcnt++;
                matrix[j][columnIndex] = encryptedMessage[tempcnt];
            }
        }

        // Reconstruir el mensaje plano a partir de la matriz
        StringBuilder plainTextBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < selectedKey.length(); j++) {
                if (matrix[i][j] != '-') {
                    plainTextBuilder.append(matrix[i][j]);
                }
            }
        }

        return plainTextBuilder.toString();
    }

    @SuppressWarnings("static-access")
    // Method 4 - main()
    // Main driver method
    
    public static void main(String[] args)
    {
        // Creating object of class in main method
        GFG tc = new GFG();
        String cifrar = "Prueba S3bastian";
        System.out.println("Texto:"+cifrar);
        System.out.println("Texto cifrado:"+ tc.doEncryption(cifrar));
        System.out.println("Texto descifrado:"+ tc.doDecryption(tc.doEncryption(cifrar)));
    }
}

