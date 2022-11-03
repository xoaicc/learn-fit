package a1_1901040247;

import java.util.ArrayList;
import java.util.List;

public class Doc {
    String[] inContent;
    String title;
    String body;
    
    /**
     * @note A constructor which receives the raw text of a document 
     *       and extracts the title and body parts from that
     * @param content
     */
    public Doc(String content) {
        this.inContent = content.split("\n");
        this.title = inContent[0];
        this.body = inContent[1];
    }

    /**
     * @note Returns the document’s title as a list of Word objects
     * @return titleWords
     */
    public List<Word> getTitle() {
        List<Word> titleWords = new ArrayList<Word>();

        for (String word : this.title.split(" ")) {
            titleWords.add(Word.createWord(word));
        }

        return titleWords;
    }

    /**
     * @note Returns the document’s body as a list of Word objects
     * @return bodyWords
     */
    public List<Word> getBody() {
        List<Word> bodyWords = new ArrayList<Word>();

        for (String word : this.body.split(" ")) {
            bodyWords.add(Word.createWord(word));
        }

        return bodyWords;
    }
    
    /**
     * @note Two Doc objects are equal if their titles 
     *       and bodies contain the same words in the same order
     * @effects If both of title1 and body1 equals title2 and body2
     *          return true
     *          else return false
     */
    public boolean equals(Object o) {
        String title1 = this.title;
        String body1 = this.body;
        
        Doc doc2 = (Doc) o;
        String title2 = doc2.title;
        String body2 = doc2.body;

        if (title1.equals(title2) && body1.equals(body2)) return true;
        else return false;
    }
}