package Controller;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeReader {

    final PipedOutputStream salida = new PipedOutputStream();
    final PipedInputStream entrada  = new PipedInputStream(salida);

    public PipeReader() throws IOException {
    }

    public void escribir(String text){
        try {
            salida.write(text.getBytes());
        } catch (IOException e) {
        }
    }

    public void leer(){
        try {
            int unByte = entrada.read();
            while(unByte!= -1){
                System.out.print((char) unByte);
                unByte = entrada.read();
            }
        } catch (IOException e) {
        }
    }
}
