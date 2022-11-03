package a1_1901040247;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.InvalidPathException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Word {
    String word;
    char[] validPref = {'\'', '\"', '<', '«', '[', '(', '{'};

    public static Set<String> stopWords = new HashSet<String>();

    /**
     * @param word
     */
    public Word(String word) {
        this.word = word;
    }

    /**
     * @note Construct and return a complete Word object from raw text
     * @param rawText
     * @return Word object
     */
    public static Word createWord(String rawText) {
        return new Word(rawText);
    }

    /**
     * @note Returns true if the word is a keyword
     * @effects If word is not empty, not contains space,
     *          not is stop word, not contains number,
     *          and contains valid prefix, then the word is keyword
     */
    boolean isKeyword() {
        if (this.word.isEmpty()) return false;
        if (this.word.contains(" ")) return false;
        if (stopWords.contains(this.word.toLowerCase())) return false;

        int c = (int)this.word.toLowerCase().charAt(0);

        for (char n : this.word.toCharArray()) {
            if ((int)n > 48 && (int)n < 58) return false;
        }

        if (c > 96 && c < 127) return true;
        else {
            for (char p : validPref) {
                if (p == (char)c) return true;
            }

            return false;
        }
    }

    /**
     * @note Returns the prefix part of the word
     * @effecrs If word is not keyword and is not a exception case,
     *          then return empty string
     *          else return sub string from 0 to first character
     */
    public String getPrefix() {
        if (!isKeyword() && !this.word.contains("\'s")) return "";

        char[] chars = this.word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int c = (int)Character.toLowerCase(chars[i]);

            if (c > 96 && c < 127) return this.word.substring(0, i);
        }

        return null;
    }

    /**
     * @note Returns the suffix part of the word
     * @effects If word is not keyword and is not a exception case,
     *          then return empty string
     *          else if word contains "'s" return from "'s"
     *          else return sub string from last character
     */
    public String getSuffix() {
        if (!isKeyword() && !this.word.contains("\'s")) return "";
        if (this.word.contains("\'s")) return this.word.substring(this.word.indexOf("\'s"));
        
        char[] chars = this.word.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            int c = (int)Character.toLowerCase(chars[i]);
            
            if (c > 96 && c < 127) return this.word.substring(i + 1);
        }

        return null;
    }

    /**
     * @note Returns the text part of the word
     * @effects If word is not keyword and is not a exception case,
     *          then return raw text
     *          else return sub string from first character to last character
     */
    public String getText() {
        if (!isKeyword() && !this.word.contains("\'s")) return this.word;

        char[] chars = this.word.toCharArray();
        int i, j;

        for (i = 0; i < chars.length; i++) {
            int c = (int)Character.toLowerCase(chars[i]);
            if (c > 96 && c < 127) break;
        }

        if (this.word.contains("\'s")) j = this.word.indexOf("\'s") - 1;
        else {
            for (j = chars.length - 1; j >= 0; j--) {
                int c = (int)Character.toLowerCase(chars[j]);
                if (c > 96 && c < 127) break;
            }
        }

        return this.word.substring(i, j + 1);
    }

    /**
     * @note Two words are considered equal if their text parts are equal
     * @effects Compare two strings
     */
    public boolean equals(Object o) {
        Word w = (Word)o;      

        String w1 = getText().toLowerCase();
        String w2 = w.getText().toLowerCase();

        return w1.equals(w2);
    }

    /**
     * @note Returns the raw text of the word
     * @return word
     */
    public String toString() {
        return this.word;
    }

    /**
     * @note Load stop words into the set Word.stopWords from the text file
     * @param fileName
     * @effects Load file from input string
     */
    public static boolean loadStopWords(String fileName) {
        try {
            File f = new File(fileName);
            Scanner fileIn = new Scanner(f);

            while (fileIn.hasNextLine()) {
                stopWords.add(fileIn.nextLine());
            }

            fileIn.close();
            
            return true;
        } catch (InvalidPathException e1) {
            return false;
        } catch (FileNotFoundException e2) {
            return false;
        }
    }
}