import java.io.*;
import java.net.*;

class URLDemo {
  public static void main(String args[]) {
    try {

      // Obtain URL
      URL url = new URL(args[0]);

      // Obtain input stream
      InputStream is = url.openStream(); 

      // Read and display data from URL
      byte buffer[] = new byte[1024];
      int i;
      while((i = is.read(buffer)) != -1) {
        System.out.write(buffer, 0, i);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
