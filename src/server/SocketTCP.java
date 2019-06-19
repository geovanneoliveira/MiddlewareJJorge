package server;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP extends Thread {

    public static int PORTSERVER;

    @Override
    public void run() {

        try {

            ServerSocket servidor = new ServerSocket(9001);
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
