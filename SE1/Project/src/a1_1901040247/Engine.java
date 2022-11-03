package a1_1901040247;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Engine {
    String[] files;
    String dirname;

    /**
     * @note Loads the documents from the folder specified by dirname
     * @param dirname
     * @return files.length
     */
    public int loadDocs(String dirname) {
        this.dirname = dirname;
        File path = new File(this.dirname);
        files = path.list();

        return files.length;
    }

    /**
     * @note Returns an array of documents in the original order
     * @return docs
     */
    public Doc[] getDocs() {
        Doc[] docs = new Doc[files.length];
        
        for (int i = 0; i < docs.length; i++) {
            File file = new File(this.dirname + "/" + files[i]);
            Scanner fileIn;
            
            try {
                fileIn = new Scanner(file);
                String content = fileIn.nextLine() + "\n" + fileIn.nextLine();
                Doc doc = new Doc(content);
                docs[i] = doc;
                fileIn.close();
            } catch (FileNotFoundException e) {}
        }
        
        return docs;
    }

    /**
     * @note Returns a list of sorted search results
     * @param q
     * @return (ArrayList<Result>) results
     */
    public List<Result> search(Query q) {
        List<Result> results = new ArrayList<Result>();
        Result result;

        for (Doc doc : getDocs()) {
            List<Match> matches = q.matchAgainst(doc);

            if (matches.size() > 0) {
                result = new Result(doc, matches);
                results.add(result);
            }
        }

        for (int i = 0; i < results.size() - 1; i++) {
            for (int j = i + 1; j < results.size(); j++) {
                int point = results.get(i).compareTo(results.get(j));
                
                if (point == -1) {
                    result = results.get(i);
                    results.set(i, results.get(j));
                    results.set(j, result);
                }
            }
        }
        
        return results;
    }

    /**
     * @note Converts a list of search results into HTML format
     * @param results
     * @return resultHtml
     */
    public String htmlResult(List<Result> results) {
        String resultHtml = "";

        for (Result result : results) {
            resultHtml += result.htmlHighlight();
        }
        
        return resultHtml;
    }
}