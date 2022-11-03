package NPRTutorial.Tut02;
import java.io.*; 
import java.net.*; 

public class Downloader { 
    private URL url; 
    // Constructs downloader to read from the given URL. 
    public Downloader(String urlString) throws MalformedURLException { 
        url = new URL(urlString);
    } 

    // Reads downloader's URL and writes contents to the given file. 
    public void download(String targetFileName) throws IOException { 
        InputStream in = url.openStream(); 
        FileOutputStream out = new FileOutputStream(targetFileName); 
        while (true) { 
            int n = in.read(); 
            if (n == -1) {      // -1 means end-of-file 
                break; 
            } 
            out.write(n); 
        } 
        in.close(); 
        out.close(); 
    } 
} 