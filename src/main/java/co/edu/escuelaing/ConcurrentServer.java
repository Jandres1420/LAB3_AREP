package co.edu.escuelaing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;

public class ConcurrentServer implements Runnable{

    private Socket clientSocket;
    private String path;
    @Override
    public void run() {
        try {
            writing();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public ConcurrentServer(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    private void writing() throws IOException, URISyntaxException {
        System.out.println("Numero de hilo :" + Thread.currentThread());
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;
        String path = "";
        Boolean primeraLinea = true;
        while ((inputLine = in.readLine()) != null) {
            if (primeraLinea) {
                path = inputLine.split(" ")[1];
                URI resourse = new URI(path);
                System.out.println("Path : " + resourse.getPath());
                primeraLinea = false;
            }
            System.out.println("Received: " + inputLine);
            if (!in.ready()) {
                break;
            }
        }
        this.path = path;
        HttpServerController httpServerController = new HttpServerController();
        httpServerController.writingFile(clientSocket, path);
        in.close();
        clientSocket.close();
    }

    public String getPath() {
        return path;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }
}
