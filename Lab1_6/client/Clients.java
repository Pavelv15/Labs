package client;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Clients {
    public static final  int CONNECTIONS = 100;
    public static void main(String[] args) throws IOException {
        Runnable task = () -> {
            try {
                Socket cs = new Socket("localhost", 1111);
                OutputStreamWriter writer = new OutputStreamWriter(cs.getOutputStream(), Charset.forName("UTF-8"));
                writer.write("test: " + String.valueOf(Thread.currentThread().threadId()) + "\n" );
                writer.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(cs.getInputStream(), Charset.forName("UTF-8")));
                System.out.println(reader.readLine());

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        };
        ExecutorService p = Executors.newFixedThreadPool(CONNECTIONS);
        for (int i=0; i<CONNECTIONS; i++)
            p.submit(task);

        p.shutdown();

    }
}
