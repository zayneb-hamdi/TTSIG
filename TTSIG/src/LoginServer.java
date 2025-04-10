import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3000);
            System.out.println("Server started on port 3000");

            while (true) {
                
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                String credentials = reader.readLine();
                String[] parts = credentials.split(":");
                String username = parts[0];
                String password = parts[1];

                
                if ( password.equals("tunisie telecom sidibouzid")) {
                    writer.println("success");
                } else {
                    writer.println("fail");
                }

                clientSocket.close();
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
