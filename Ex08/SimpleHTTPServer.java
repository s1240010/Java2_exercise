import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.file.*;


public class SimpleHTTPServer {

  private final int port;

  public SimpleHTTPServer(int port)
  {
    this.port = port;
  }

  public void start(){
    // TODO
    // Start a ServerSocker
    // wait for connection
    // then send the corresponding socket to an instance of Handler
    // and let it handle the request
    ServerSocket serverSocket;
    try{
    //サーバー用ソケットを作成
      serverSocket = new ServerSocket(port);

    //クライアントからの接続を待ち、接続がきたら、
    //そのクライアントと通信するソケットを取得
      Socket clientSocket =  serverSocket.accept();
      serverSocket.close();
      Handler h = new Handler(clientSocket);
      h.start();
    }catch(IOException e){
      System.out.println(e.toString());
    }
  }

  private class Handler {
    private final Socket connection;

    Handler(Socket connection) {
      this.connection = connection;
    }

    public void start() throws IOException{
      // Get InputStream and OutputStream from the socket.
      //
      // 1. read the request from the client.
      // 2. if it is not starting by "GET" then ignore
      // 3. otherwise, extract the file name from the request.
      // It will look like: "GET /filename.html HTTP/1.1"
      // You can split the string by whitespaces.
      // 4. open the file and reads its content
      // 5. create an HTTP header
      // 6. send the header then the content via the OutputStream
      InputStream is = connection.getInputStream();
      OutputStream os = connection.getOutputStream();
      BufferedReader input;
      String url=null;
      input = new BufferedReader(new InputStreamReader(is));
      String[] inputLine = input.readLine().split(" ");
      System.out.println(inputLine[0]);
      if(inputLine[0].equals("GET")){
          try{
                if(inputLine[1].equals("/index.html")){
                    url = "/Users/koheisato/Desktop/Java2/Ex08"+inputLine[1];
                }
                    File file = new File(url);
                    byte[] content;
                    content = Files.readAllBytes(file.toPath());

                    String headerStr = "HTTP/1.0 200 OK\r\n"
                    + "Server: SimpleHTTPServer\r\n"
                    + "Content-length: " + content.length + "\r\n"
                    + "Content-type: text/html"
                    + "; charset=utf-8" + "\r\n\r\n";
                    byte[] header = headerStr.getBytes(Charset.forName("UTF-8"));
                    os.write(header);
                    os.write(content);
                    os.flush();
                    os.close();
            }catch(NullPointerException e){
                    url = "/Users/koheisato/Desktop/Java2/Ex08/404notFound.html";
                    File file = new File(url);
                    byte[] content;
                    content = Files.readAllBytes(file.toPath());

                    String headerStr = "HTTP/1.0 200 OK\r\n"
                    + "Server: SimpleHTTPServer\r\n"
                    + "Content-length: " + content.length + "\r\n"
                    + "Content-type: text/html"
                    + "; charset=utf-8" + "\r\n\r\n";
                    byte[] header = headerStr.getBytes(Charset.forName("UTF-8"));
                    os.write(header);
                    os.write(content);
                    os.flush();
                    os.close();
            }
      return;
    }
  }
  }


  public static void main(String[] args) {
    int port;
    try {
      port = Integer.parseInt(args[0]);
      if (port < 1024 || port > 65535) port = 8080;
    } catch (RuntimeException ex) {
      port = 8080;
    }

    try {
      SimpleHTTPServer server = new SimpleHTTPServer(port);
      server.start();

    } catch (ArrayIndexOutOfBoundsException ex) {
      System.out.println("Usage: java SimpleHTTPServer [port]");
    }
  }

}
