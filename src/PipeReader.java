import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeReader {

    private PipedOutputStream salida = new PipedOutputStream();
    private PipedInputStream entrada  = new PipedInputStream(salida);

    public PipeReader(PipedOutputStream salida, PipedInputStream entrada) throws IOException {
        this.salida = salida;
        this.entrada = entrada;
    }

    public void escribir(String text){
        new Thread(() -> {
            try {
                salida.write(text.getBytes());
            } catch (IOException e) {
                System.err.println("Error al escribir en el pipe");
            }
        }).start();
    }

    public void leer(){
       new Thread(){
              @Override
              public void run() {
                try {
                     int unByte = entrada.read();
                     while(unByte!= -1){
                          System.out.print((char) unByte);
                          unByte = entrada.read();
                     }
                } catch (IOException e) {
                     System.err.println("Error al leer del pipe");
                }
              }
         }.start();
       }

}
