package minutosrestantes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;

public class TiempoHastaFinDeSemana {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int minutosPorDia = 24 * 60; // Total de minutos en un día

        // Días de la semana válidos
        String[] diasValidos = {"lunes", "martes", "miércoles", "jueves", "viernes"};

        // Solicitar al usuario un día de la semana
        String dia;
        do {
            System.out.print("Introduce un día de la semana (lunes a viernes): ");
            dia = sc.nextLine().toLowerCase();
        } while (!esDiaValido(dia, diasValidos));

        // Solicitar al usuario una hora y minutos
        int horas, minutos;
        do {
            System.out.print("Introduce una hora (0-23): ");
            horas = sc.nextInt();
            System.out.print("Introduce minutos (0-59): ");
            minutos = sc.nextInt();
        } while (!esHoraValida(horas) || !esMinutosValidos(minutos));

        sc.close();

        // Calcular minutos hasta el fin de semana (viernes a las 15:00 hrs)
        int minutosHastaFinDeSemana = calcularMinutosHastaFinDeSemana(dia, horas, minutos);
        
        if (minutosHastaFinDeSemana < 0) {
            System.out.println("El fin de semana ya ha comenzado.");
        } else {
            System.out.println("Faltan " + minutosHastaFinDeSemana + " minutos para el fin de semana.");
        }
    }

    // Función para verificar si el día es válido
    public static boolean esDiaValido(String dia, String[] diasValidos) {
        for (String diaValido : diasValidos) {
            if (diaValido.equals(dia)) {
                return true;
            }
        }
        System.out.println("Día de la semana no válido. Por favor, ingresa un día válido.");
        return false;
    }

    // Función para verificar si la hora es válida
    public static boolean esHoraValida(int horas) {
        if (horas >= 0 && horas <= 23) {
            return true;
        }
        System.out.println("Hora no válida. Por favor, ingresa una hora válida (0-23).");
        return false;
    }

    // Función para verificar si los minutos son válidos
    public static boolean esMinutosValidos(int minutos) {
        if (minutos >= 0 && minutos <= 59) {
            return true;
        }
        System.out.println("Minutos no válidos. Por favor, ingresa minutos válidos (0-59).");
        return false;
    }

    // Función para calcular los minutos hasta el fin de semana
    public static int calcularMinutosHastaFinDeSemana(String dia, int horas, int minutos) {
        int minutosHastaFinDeSemana = 0;

        if (dia.equals("viernes")) {
            minutosHastaFinDeSemana = (15 * 60) - (horas * 60 + minutos);
        } else {
            int minutosPorDia = 0;
            minutosHastaFinDeSemana = ((4 - obtenerDiaSemana(dia)) * minutosPorDia) - (horas * 60 + minutos) + (15 * 60);
        }

        return minutosHastaFinDeSemana;
    }

    // Función para obtener el día de la semana en base al nombre
    public static int obtenerDiaSemana(String dia) {
        String[] diasDeLaSemana = {"lunes", "martes", "miércoles", "jueves", "viernes"};
        for (int i = 0; i < diasDeLaSemana.length; i++) {
            if (dia.equals(diasDeLaSemana[i])) {
                return i;
            }
        }
        return -1;
    }
}
