package NPRTutorial.Tut02;
import java.io.*; 
import java.net.*; 
import java.util.*; 

public class TallyDownloader extends Downloader { 
    public TallyDownloader(String url) throws MalformedURLException { 
        super(url);   // call Downloader constructor 
    } 

    // Reads from URL and prints file contents and tally of each char. 
    public void download(String targetFileName) throws IOException { 
        super.download(targetFileName); 
        Map<Character, Integer> counts = new TreeMap<Character, Integer>(); 
        FileInputStream in = new FileInputStream(targetFileName); 
        while (true) { 
            int n = in.read(); 
            if (n == -1) { 
                break; 
            } 
            char ch = (char) n; 
            if (counts.containsKey(ch)) { 
                counts.put(ch, counts.get(ch) + 1); 
            } else { 
                counts.put(ch, 1); 
            } 
            System.out.print(ch); 
        } 
        in.close(); 
        System.out.println(counts);   // print map of char -> int	  
    } 
} 