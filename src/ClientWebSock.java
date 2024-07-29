import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONObject;
import java.net.URI;

public class ClientWebSock extends WebSocketClient{
    private double totalVolume;
    private int messageCount;

    public ClientWebSock(URI link){
        super(link);
    }

    public void onOpen(ServerHandshake handshake) {
        System.out.println("Connected to server");
        send("uid=124567865");
        send("subscribe=QO.FADGI.ADX");
    }

    public void onClose(int code, String reason, boolean m){
        System.out.println("Connection closed");
    }

    public void onMessage(String message){
        System.out.println("Received: " + message);
        processMessage(message);
    }

    public void onError(Exception ex){
        System.out.println("Error: " + ex);
        ex.printStackTrace();
    }

    private void processMessage(String message){
        JSONObject m= new JSONObject(message);
        int volume=0;
        if(m.has("volume"))
            volume = m.getInt("volume");
        totalVolume+=volume;
        messageCount+=1;
        if(messageCount %5 == 0) {
            System.out.println("Average Volume of the last 5 messages: " + totalVolume / 5);
            totalVolume = 0;
        }
    }
  }

