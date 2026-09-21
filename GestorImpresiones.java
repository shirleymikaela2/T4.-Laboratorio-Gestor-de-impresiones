import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class GestorImpresiones {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Cola de documentos pendientes
        Deque<String> pendientes = new ArrayDeque<>();

        // Pila de documentos impresos
        Deque<String> historial = new ArrayDeque<>();

        int opcion;

        do {

            System.out.println("\n===== GESTOR DE IMPRESIONES =====");
            System.out.println("1. Registrar documento");
            System.out.println("2. Imprimir siguiente");
            System.out.println("3. Recuperar última impresión");
            System.out.println("4. Mostrar estructuras");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre del documento: ");
                    String nombre = scanner.nextLine();

                    pendientes.offerLast(nombre);

                    System.out.println("Documento registrado: " + nombre);
                    break;

                case 2:

                    // Validación antes de retirar
                    if (pendientes.isEmpty()) {
                        System.out.println(
                            "No hay documentos pendientes para imprimir."
                        );
                    } else {

                        String documento = pendientes.pollFirst();

                        historial.push(documento);

                        System.out.println(
                            "Documento impreso: " + documento
                        );
                    }

                    break;

                case 3:

                    // Validación antes de retirar
                    if (historial.isEmpty()) {
                        System.out.println(
                            "No hay documentos en el historial."
                        );
                    } else {

                        String recuperado = historial.pop();

                        pendientes.addFirst(recuperado);

                        System.out.println(
                            "Documento recuperado: " + recuperado
                        );
                    }

                    break;

                case 4:

                    System.out.println(
                        "Pendientes: " + pendientes
                    );

                    System.out.println(
                        "Historial: " + historial
                    );

                    break;

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}