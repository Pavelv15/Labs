package client;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;

public class Client {
    public static void main(String[] args) throws IOException {
        try(Socket cs = new Socket("localhost",1111)) {
            OutputStreamWriter writer = new OutputStreamWriter(cs.getOutputStream(), Charset.forName("UTF-8"));
            writer.write("test\n");
            writer.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(cs.getInputStream(),Charset.forName("UTF-8")));
            System.out.println(reader.readLine());

        }
    }
}
