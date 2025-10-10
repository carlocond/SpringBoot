import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer {
    public static void main(String[] args) throws Exception {

        //Crea un server socket che resta in ascolto sulla porta 8080 del computer.
        final ServerSocket server = new ServerSocket(8080);
        System.out.println("Connecting on port 8080 ...");
        while (true){
            final Socket client = server.accept();
            //Legge la richiesta HTTP dal client socket
            //Configura la risposta HTTP
            //Invia la risposta al client
            //Il socket si chiude
            InputStreamReader isr = new InputStreamReader(client.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            String line = reader.readLine();
            while (!line.isEmpty()){
                System.out.println(line);
                line = reader.readLine();
            }
        }

    }
}
