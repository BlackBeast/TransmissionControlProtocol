import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{
        String clientText;
        String textToUpperCase;
        ServerSocket recieveClientSocket = new ServerSocket(8888);

        while(true){
            Socket connectionSocket = recieveClientSocket.accept();

            BufferedReader recieveInputFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            DataOutputStream provideOutputToClient = new DataOutputStream(connectionSocket.getOutputStream());

            clientText = recieveInputFromClient.readLine();

            textToUpperCase = clientText.toUpperCase()+'\n';

            provideOutputToClient.writeBytes(textToUpperCase);
        }
    }
}
