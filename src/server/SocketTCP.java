package server;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.PublicKey;

public class SocketTCP extends Thread {

    public static InetAddress IPSERVER;

    public static int PORTSERVER;

    @Override
    public void run() {

        try {

            ServerSocket servidor = new ServerSocket(9001);
            IPSERVER = servidor.getInetAddress();
            PORTSERVER = servidor.getLocalPort();

            System.out.println("Servidor socket iniciado...");

            while(true) {
                System.out.println("Esperando conexao...");

                Socket conexao = servidor.accept();

                System.out.println("Recebeu conexao...");

                new Connection(conexao).start();

            }

        } catch (Exception e) {
            System.out.println("Error SocketTCP::class");
            e.printStackTrace();
        }
    }
}
