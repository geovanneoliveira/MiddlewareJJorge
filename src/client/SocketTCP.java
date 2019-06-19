package client;

import java.net.*;
import java.util.Enumeration;

public class SocketTCP extends Thread {


    public static int PORTCLIENT;

    @Override
    public void run() {

        try {

            ServerSocket servidor = new ServerSocket(8001);
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
