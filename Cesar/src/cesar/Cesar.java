/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cesar;

import java.util.Scanner;

public class Cesar{

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("Ingrese una frase:");
        String frase = sn.next().toUpperCase(); // Convertir la frase a mayúsculas
        int desplazamiento = 3; // Puedes cambiar este valor para modificar el desplazamiento
        String textoCodificado = codificar(letras, frase, desplazamiento);
        System.out.println("Texto codificado: " + textoCodificado);
        String textoDecodificado = decodificar(letras, textoCodificado, desplazamiento);
        System.out.println("Texto decodificado: " + textoDecodificado);
    }

    private static String codificar(String letras, String frase, int desplazamiento) {
        StringBuilder textoCodificado = new StringBuilder();
        for (int i = 0; i < frase.length(); i++) {
            char caracter = frase.charAt(i);
            if (Character.isLetter(caracter)) {
                int indiceOriginal = letras.indexOf(caracter);
                if (indiceOriginal != -1) {
                    int indiceCodificado = (indiceOriginal + desplazamiento) % letras.length();
                    char caracterCodificado = letras.charAt(indiceCodificado);
                    textoCodificado.append(caracterCodificado);
                }
            } else {
                textoCodificado.append(caracter);
            }
        }
        return textoCodificado.toString();
    }

    private static String decodificar(String letras, String texto, int desplazamiento) {
        StringBuilder textoDecodificado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (Character.isLetter(caracter)) {
                int indiceCodificado = letras.indexOf(caracter);
                if (indiceCodificado != -1) {
                    int indiceOriginal = (indiceCodificado - desplazamiento + letras.length()) % letras.length();
                    char caracterOriginal = letras.charAt(indiceOriginal);
                    textoDecodificado.append(caracterOriginal);
                }
            } else {
                textoDecodificado.append(caracter);
            }
        }
        return textoDecodificado.toString();
    }
}

