/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estadisticasletras;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EstadisticasLetras {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese una oración:");
        String oracion = scanner.nextLine();

        // Llama a la función para calcular las estadísticas de letras
        Map<Character, Integer> estadisticas = calcularEstadisticas(oracion);

        // Ordena las estadísticas de mayor a menor puntuación
        Map<Character, Integer> estadisticasOrdenadas = ordenarEstadisticas(estadisticas);

        // Imprime las estadísticas ordenadas
        System.out.println("Estadísticas ordenadas de mayor a menor:");
        for (Map.Entry<Character, Integer> entrada : estadisticasOrdenadas.entrySet()) {
            char letra = entrada.getKey();
            int frecuencia = entrada.getValue();
            System.out.println("'" + letra + "': " + frecuencia + " veces");
        }
    }

    public static Map<Character, Integer> calcularEstadisticas(String oracion) {
        Map<Character, Integer> estadisticas = new HashMap<>();

        // Convierte la oración a minúsculas y elimina espacios y puntuaciones
        oracion = oracion.toLowerCase().replaceAll("[^a-z]", "");

        // Recorre la oración y cuenta las ocurrencias de cada letra
        for (int i = 0; i < oracion.length(); i++) {
            char caracter = oracion.charAt(i);
            estadisticas.put(caracter, estadisticas.getOrDefault(caracter, 0) + 1);
        }

        return estadisticas;
    }

    public static Map<Character, Integer> ordenarEstadisticas(Map<Character, Integer> estadisticas) {
        // Ordena las estadísticas de mayor a menor puntuación usando Java Streams
        return estadisticas.entrySet()
                .stream()
                .sorted((entrada1, entrada2) -> entrada2.getValue().compareTo(entrada1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}







