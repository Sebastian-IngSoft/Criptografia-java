/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vigenerecipher;

/**
 *
 * @author sebas
 */
public class VigenereCipher {
    
    // Método para cifrar el texto utilizando el cifrado Vigenère
    public static String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();
        int keyLength = key.length();
        
        // Recorre cada carácter del texto plano
        for (int i = 0; i < plaintext.length(); i++) {
            char plainChar = plaintext.charAt(i);
            char keyChar = key.charAt(i % keyLength);
            
            // Verifica si el carácter es una letra
            if (Character.isLetter(plainChar)) {
                char base = Character.isUpperCase(plainChar) ? 'A' : 'a';
                
                // Realiza el cifrado Vigenère
                char encryptedChar = (char) (((plainChar - base + keyChar - base) % 26) + base);
                ciphertext.append(encryptedChar);
            } else {
                // Si no es una letra, se añade tal como está
                ciphertext.append(plainChar);
            }
        }
        return ciphertext.toString();
    }
    
    // Método para descifrar el texto cifrado
    public static String decrypt(String ciphertext, String key) {
        StringBuilder plaintext = new StringBuilder();
        int keyLength = key.length();
        
        // Recorre cada carácter del texto cifrado
        for (int i = 0; i < ciphertext.length(); i++) {
            char cipherChar = ciphertext.charAt(i);
            char keyChar = key.charAt(i % keyLength);
            
            // Verifica si el carácter es una letra
            if (Character.isLetter(cipherChar)) {
                char base = Character.isUpperCase(cipherChar) ? 'A' : 'a';
                
                // Realiza el descifrado Vigenère
                char decryptedChar = (char) (((cipherChar - base - keyChar + base + 26) % 26) + base);
                plaintext.append(decryptedChar);
            } else {
                // Si no es una letra, se añade tal como está
                plaintext.append(cipherChar);
            }
        }
        return plaintext.toString();
    }
    
    public static void main(String[] args) {
        String plaintext = "Prueba S3bastian";
        String key = "clave";
        
        // Ejemplo de cifrado
        String encryptedText = encrypt(plaintext, key);
        System.out.println("Texto cifrado: " + encryptedText);
        
        // Ejemplo de descifrado
        String decryptedText = decrypt(encryptedText, key);
        System.out.println("Texto descifrado: " + decryptedText);
    }
}
