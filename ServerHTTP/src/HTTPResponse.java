import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/*
Classe che crea una semplice risposta HTTP per la dimostrazione del funzionamento del
Server socket e della classe socket.
 */
public class HTTPResponse {
    public static void main(String[] args )throws IOException {
        //Crea un server socket che resta in ascolto sulla porta 8080 del computer.
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Connecting on port 8080 ...");
        while (true){
            //Metodo che blocca l'esecuzione fino alla connessione di un client
            try(Socket socket = server.accept()){ //Quando la avviene la connessione accept restituisce l'oggetto Socket
                //Oggetto Date che contiene data e orario attuale
                Date date = new Date();
                //Creazione della risposta HTTP
                String httpResponse = "HTTP/1.1 200 OK \r\n\r\n" + date;
                //Scrittura dei byte nella stringa e invio come risposta http al browser
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
                //Chiusura del socket
            }
        }
    }
}
