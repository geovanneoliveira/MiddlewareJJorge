package server;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP extends Thread {

    @Override
    public void run() {

        try {

            ServerSocket servidor = new ServerSocket(9001);

            System.out.println("Servidor socket iniciado...");

            while(true) {
                System.out.println("Esperando conexao...");

                Socket conexao = servidor.accept();

                System.out.println("Recebeu conexao...");

                new Connection(conexao).start();

            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
