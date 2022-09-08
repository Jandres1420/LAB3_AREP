package co.edu.escuelaing;

import java.net.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Cuarto ejercicio donde se prueba la lectura de archivos puestos desde el navegador
 * tipos aceptados .html, .js,.css,.png,.jpg
 */
public class HttpServer {
    private static HttpServer _instance = new HttpServer();

    public static HttpServer get_instance() {
        return _instance;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        ServerSocket serverSocket = null;
        ExecutorService numeroDeHilos = Executors.newFixedThreadPool(20);
        try {
            serverSocket = new ServerSocket(getPort());
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        boolean flags = true;

        while (flags) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            ConcurrentServer concurrentServer = new ConcurrentServer(clientSocket);
            numeroDeHilos.execute(concurrentServer);
        }
        serverSocket.close();
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) return Integer.parseInt(System.getenv("PORT"));
        return 35000;
    }
}
