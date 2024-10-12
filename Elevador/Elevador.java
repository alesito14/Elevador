import java.util.*;

public class Elevador {
    private int pisoActual;
    private final int pisoMaximo;
    private final int pisoMinimo;

    public Elevador(int pisoMinimo, int pisoMaximo) {
        this.pisoActual = pisoMinimo; // Suponemos que el elevador comienza en el piso mínimo
        this.pisoMaximo = pisoMaximo;
        this.pisoMinimo = pisoMinimo;
    }

    public void subir(int pisoDestino) {
        if (pisoDestino > pisoActual && pisoDestino <= pisoMaximo) {
            System.out.println("Subiendo del piso " + pisoActual + " al piso " + pisoDestino);
            pisoActual = pisoDestino;
            System.out.println("Has llegado al piso " + pisoActual);
        } else if (pisoDestino > pisoMaximo) {
            System.out.println("El piso " + pisoDestino + " excede el límite superior.");
        } else {
            System.out.println("Ya estás en un piso superior o en el mismo piso.");
        }
    }

    public void bajar(int pisoDestino) {
        if (pisoDestino < pisoActual && pisoDestino >= pisoMinimo) {
            System.out.println("Bajando del piso " + pisoActual + " al piso " + pisoDestino);
            pisoActual = pisoDestino;
            System.out.println("Has llegado al piso " + pisoActual);
        } else if (pisoDestino < pisoMinimo) {
            System.out.println("El piso " + pisoDestino + " está en el sótano, ya no hay más piso abajo.");
        } else {
            System.out.println("Ya estás en un piso inferior o en el mismo piso.");
        }
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Elevador elevador = new Elevador(1, 10); // El elevador tiene un mínimo de piso 1 y un máximo de 10

        while (true) {
            System.out.println("Estás en el piso: " + elevador.getPisoActual());
            System.out.print("Ingresa el piso al que deseas ir o 's' para salir: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("s")) {
                System.out.println("Saliendo del elevador...");
                break;
            }

            try {
                int pisoDestino = Integer.parseInt(input);

                // Verificar si el pisoDestino está fuera de los límites
                if (pisoDestino < elevador.pisoMinimo || pisoDestino > elevador.pisoMaximo) {
                    System.out.println("El piso " + pisoDestino + " está fuera de los límites permitidos (" + elevador.pisoMinimo + " - " + elevador.pisoMaximo + "). Saliendo...");
                    break; // Detener el programa
                }

                if (pisoDestino > elevador.getPisoActual()) {
                    elevador.subir(pisoDestino);
                } else if (pisoDestino < elevador.getPisoActual()) {
                    elevador.bajar(pisoDestino);
                } else {
                    System.out.println("Ya estás en el piso " + pisoDestino);
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor ingresa un número de piso válido.");
            }
        }

        scanner.close(); // Cerrar el scanner al finalizar
    }
}
