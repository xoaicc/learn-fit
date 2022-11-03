package NPRTutorial.Tut01;

import java.net.*;
import java.io.*;
public class URLConnectionReader2 {
public static void main(String[] args) {
    URL url = null;
    BufferedReader in = null;
    try {
        url = new URL("https://xcc.one");
    } catch(MalformedURLException e) {
        System.out.println("Cannot find webpage " + url); System.exit(-1);
    }
    try {
        URLConnection aConnection = url.openConnection();
        in = new BufferedReader(
        new InputStreamReader(aConnection.getInputStream()));
    }
    catch (IOException e) {
        System.out.println("Cannot connect to webpage " + url); System.exit(-1);
    }
    try {
    // Now read the webpage file
        String lineOfWebPage;
        while ((lineOfWebPage = in.readLine()) != null) System.out.println(lineOfWebPage);
        in.close(); // Close the connection to the net
    } catch(IOException e) {
        System.out.println("Cannot read from webpage " + url);
    }
    }
}