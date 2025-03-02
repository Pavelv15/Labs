package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket ss = new ServerSocket(1111);
        ExecutorService p = Executors.newCachedThreadPool();
        AtomicInteger req = new AtomicInteger();

        while (true) {
            final  Socket cs = ss.accept();
            Runnable task = () -> {
                try {


                    System.out.printf("Соединение установлено c адреса %s\n", cs.getInetAddress().toString());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(cs.getInputStream(), Charset.forName("UTF-8")));
                    String s = reader.readLine();
                    System.out.printf("%s . %d\n", s,req.incrementAndGet());
                    OutputStreamWriter writer = new OutputStreamWriter(cs.getOutputStream(), Charset.forName("UTF-8"));
                    writer.write(s.toUpperCase() + "\n");
                    writer.flush();
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            };

            p.submit(task);


        }
    }
}
