import java.net.URI;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            URI link = new URI("wss://eu-adx.live.tickerchart.net/streamhubws/");
            ClientWebSock client = new ClientWebSock(link);
            client.connect();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
