import java.io.*;

public class PipedStreamDemo {
    public static void main(String[] args) throws IOException {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);

        Thread writerThread = new Thread(() -> {
            try {
                String message = "Hello from writer thread";
                pos.write(message.getBytes());
                pos.close();
            } catch (IOException e) {
                System.out.println("Writer error: " + e.getMessage());
            }
        });

        Thread readerThread = new Thread(() -> {
            try {
                int data;
                while ((data = pis.read()) != -1) {
                    System.out.print((char) data);
                }
                pis.close();
            } catch (IOException e) {
                System.out.println("Reader error: " + e.getMessage());
            }
        });

        writerThread.start();
        readerThread.start();
    }
}
