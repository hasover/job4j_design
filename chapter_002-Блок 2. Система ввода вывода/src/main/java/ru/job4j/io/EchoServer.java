package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());
    public static void main(String[] args)  {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String message = "";
                    while (!(str = in.readLine()).isEmpty()) {
                        if (str.contains("/?msg=")) {
                            message = str.split(" ")[1].split("=")[1];
                        }
                        System.out.println(str);
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    if (message.equals("Hello")) {
                        out.write("Hello, dear friend.".getBytes());
                    } else if (message.equals("Exit")) {
                        break;
                    } else {
                        out.write(message.getBytes());
                    }
                }
            }
        } catch (IOException e) {
            LOG.debug("exception in Echoserver", e);
        }
    }
}

