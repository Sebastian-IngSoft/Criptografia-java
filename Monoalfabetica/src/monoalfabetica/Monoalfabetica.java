/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package monoalfabetica;

/**
 *
 * @author sebas
 */
public class Monoalfabetica {
    public static void main(String[] args) {
        
        String mensajeOriginal = "Prueba S3bastian";
        String mensajeCifrado = cifrarMensaje(mensajeOriginal);
        String mensajeDescifrado = descifrarMensaje(mensajeCifrado);
        
        System.out.println("Mensaje original: " + mensajeOriginal);
        System.out.println("Mensaje cifrado: " + mensajeCifrado);
        System.out.println("Mensaje descifrado: " + mensajeDescifrado);
    }
    
    // Método para cifrar un mensaje utilizando una clave de sustitución
    public static String cifrarMensaje(String mensaje) {
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String clave = "QWERTYUIOPASDFGHJKLZXCVBNM"; // Cambia esto por tu clave de sustitución
        
        mensaje = mensaje.toUpperCase(); // Convertir el mensaje a mayúsculas para que sea insensible a mayúsculas/minúsculas
        
        StringBuilder mensajeCifrado = new StringBuilder();
        
        for (int i = 0; i < mensaje.length(); i++) {
            char caracter = mensaje.charAt(i);
            
            if (Character.isLetter(caracter)) {
                int indiceOriginal = alfabeto.indexOf(caracter);
                
                if (indiceOriginal != -1) {
                    char caracterCifrado = clave.charAt(indiceOriginal);
                    mensajeCifrado.append(caracterCifrado);
                }
            } else {
                mensajeCifrado.append(caracter);
            }
        }
        
        return mensajeCifrado.toString();
    }

    // Método para descifrar un mensaje cifrado con una clave de sustitución
    public static String descifrarMensaje(String mensajeCifrado) {
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String clave = "QWERTYUIOPASDFGHJKLZXCVBNM"; // La misma clave que usaste para cifrar
        
        StringBuilder mensajeDescifrado = new StringBuilder();
        
        for (int i = 0; i < mensajeCifrado.length(); i++) {
            char caracter = mensajeCifrado.charAt(i);
            
            if (Character.isLetter(caracter)) {
                int indiceCifrado = clave.indexOf(caracter);
                
                if (indiceCifrado != -1) {
                    char caracterOriginal = alfabeto.charAt(indiceCifrado);
                    mensajeDescifrado.append(caracterOriginal);
                }
            } else {
                mensajeDescifrado.append(caracter);
            }
        }
        
        return mensajeDescifrado.toString();
    }
}

