import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;

public class ClientWebSock extends WebSocketClient {
    public ClientWebSock(URI link){
        super(link);
    }
    public void onOpen(ServerHandshake serverHandshake) {
            System.out.println("Connected to Server!");
    }

    public void onMessage(String message){
            System.out.println ("Received: " + message);
            processMessage(message);
    }

    public void onClose(int x, String y, boolean z){
        System.out.println("Connection Closed");
    }

    public void onError(Exception e){
        System.out.println("Exception: " + e);
    }

    private void processMessage(String message){

    }


}
