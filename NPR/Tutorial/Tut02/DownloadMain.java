package NPRTutorial.Tut02;
import java.io.*; 
import java.net.*; 
import java.util.*; 

public class DownloadMain { 
    public static void main(String[] args) { 
        Scanner console = new Scanner(System.in); 
        System.out.print("URL to download? "); 
        String urlString = console.nextLine(); 
        Downloader down = null;   // create a downloader; 
        while (down == null) {    // re-prompt the user if this fails 
            try { 
                down = new Downloader(urlString); 
            } catch (MalformedURLException e) { 
                System.out.print("Bad URL! Try again: "); 
                urlString = console.nextLine(); 
            } 
        }
        System.out.print("Target file name: "); 
        String targetFileName = console.nextLine(); 

        try {   // download bytes to file (print error if it fails) 
            down.download(targetFileName); 
            System.out.println("Downloaded successfully") ; 
        } catch (IOException e) { 
            System.out.println("I/O error: " + e.getMessage()); 
        }
    } 
} 