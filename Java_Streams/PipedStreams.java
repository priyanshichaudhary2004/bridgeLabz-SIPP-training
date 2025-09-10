import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreams {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        try {
            // Create piped input and output streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos); 

            // Create writer and reader threads
            Thread writerThread = new Thread(new Writer(pos));
            Thread readerThread = new Thread(new Reader(pis));

            // Start both threads
            writerThread.start();
            readerThread.start();

        } catch (IOException e) {
            System.out.println("Error setting up piped streams : " + e.getMessage());
        }
    }
}

// Writer thread writes data into the pipe
class Writer implements Runnable {
    private PipedOutputStream pos;

    Writer(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            String[] messages = {
                "Hello from Writer Thread!",
                "This is a message through pipe.",
                "Java Piped Streams are cool!",
                "End"
            };

            for (String msg : messages) {
                pos.write(msg.getBytes());
                pos.write('\n'); 
                Thread.sleep(500);
            }

            pos.close(); // signal end of data
        } catch (IOException | InterruptedException e) {
            System.out.println("Writer error : " + e.getMessage());
        }
    }
}

// Reader thread reads data from the pipe
class Reader implements Runnable {
    private PipedInputStream pis;

    Reader(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(pis))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Reader received : " + line);
            }
        } catch (IOException e) {
            System.out.println("Reader error : " + e.getMessage());
        }
    }
}
