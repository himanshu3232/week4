package org.capgemini.piped_stream;

import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                String message = "Message " + i;
                pos.write(message.getBytes());
                pos.write('\n');
                System.out.println("Written: " + message);
                Thread.sleep(500);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("WriterThread error: " + e.getMessage());
        } finally {
            try {
                pos.close();
            } catch (IOException e) {
                System.err.println("Error closing PipedOutputStream: " + e.getMessage());
            }
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(pis))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Read: " + line);
            }
        } catch (IOException e) {
            System.err.println("ReaderThread error: " + e.getMessage());
        }
    }
}

public class PipedStreamCommunication {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);

            writer.start();
            reader.start();
        } catch (IOException e) {
            System.err.println("Error setting up piped streams: " + e.getMessage());
        }
    }
}
