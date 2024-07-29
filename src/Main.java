import java.net.URI;

public class Main {
    public static void main(String[] args)  {
        try {
            ClientWebSock client = new ClientWebSock(new URI("wss://eu-adx.live.tickerchart.net/streamhubws/"));
            client.connect();
        } catch(Exception e){
            System.out.println("Error: " + e);
        }

    }
}
