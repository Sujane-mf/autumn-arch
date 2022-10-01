import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static RequestHandler requestHandler;
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server started!");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                new Thread(() -> {
                    requestHandler.handleRequest(socket);
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
