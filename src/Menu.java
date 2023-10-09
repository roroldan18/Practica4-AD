import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Scanner;

public class Menu {
    private int option;
    private Scanner scanner = new Scanner(System.in);
    private PipedOutputStream salida = new PipedOutputStream();
    private PipedInputStream entrada = new PipedInputStream(salida);
    private PipeReader pipe = new PipeReader(salida, entrada);

    public Menu() throws IOException {
    }

    // Menu Simple para escribir y leer datos en el mismo proceso.
    public void start() throws IOException {
        do{
            System.out.println("1. Escribir");
            System.out.println("2. Leer");
            System.out.println("3. Salir");
            System.out.print("Opcion: ");
            String input = scanner.nextLine();
            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                option = 0;
            }

            switch (option){
                case 1:
                    System.out.print("Escriba un texto: ");
                    String text = scanner.nextLine();
                    pipe.escribir(text);
                    break;
                case 2:
                    pipe.leer();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while(option!=3);

    }
}
