package NPRTutorial.Tut01;

import java.net.* ;
public class ParseURL {
    public static void main(String[]args) throws MalformedURLException {
    URL url = new URL("http://java.sun.com:80/docs/books/tutorial/intro.html#DOWNLOADING") ;
    System.out.println("Protocol = "+url.getProtocol()) ;
    System.out.println("Host = "+url.getHost()) ;
    System.out.println("FileName = "+url.getFile()) ;
    System.out.println("Port = "+url.getPort()) ;
    System.out.println("Reference= "+url.getRef()) ;
    }
}