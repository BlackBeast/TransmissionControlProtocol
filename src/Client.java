import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{
        String text;
        String modifiedText;

        BufferedReader provideInputToServer = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket ("localhost",8888);

        DataOutputStream provideOutputToServer = new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader recieveInputFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        text = provideInputToServer.readLine();

        provideOutputToServer.writeBytes(text+'\n');

        modifiedText = recieveInputFromServer.readLine();

        System.out.println("Output from Server:"+modifiedText);

        clientSocket.close();
    }
}
