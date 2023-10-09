import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        menu.start();
    }
}