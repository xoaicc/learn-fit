package SE1Tutorial.Tut03;

import java.io.*;

public class CompressWhitespaces {
    static String path = "/whitespaces.txt";

    /**
     * @effcets <pre>
     *      open the read buffer to path
     *      make output path to the path with .txt replaced with _compressed.txt
     *      open the writer to output path
     *      for each line read from reader
     *          compress the line
     *          use writer to write the line
     *      flush the writer
     * </pre>
     */
    public static void readAndCompWhites(String path) 
    throws IOException {
        // List<String> lines = new ArrayList<>();
        String outputPath = path.replace(".txt", "_compressed.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));
        //read
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        while(true) {
            line = reader.readLine();
            if(line == null) {
                break;
            }
            //compress
            String compressedLine = line.replace(" ", "");
            writer.write(compressedLine);
            writer.newLine();
        }
        writer.flush();
    }

    public static void main(String[] args) {
        try {
            readAndCompWhites(path);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}