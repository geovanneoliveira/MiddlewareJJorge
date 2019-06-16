package client;

import server.Connection;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP extends Thread {

    public static InetAddress IPCLIENT;

    public static int PORTCLIENT;

    @Override
    public void run() {

        try {

            ServerSocket servidor = new ServerSocket(8001);
            IPCLIENT = servidor.getInetAddress();
            PORTCLIENT = servidor.getLocalPort();

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
