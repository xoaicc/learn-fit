package a1_1901040247;

import java.util.ArrayList;
import java.util.List;

public class Query {
    List<Word> keyWords;
    
    /**
     * @note A constructor which receives the raw search phrase from user,
     *       then extract only keywords from it
     * @effects If word in words array from search phrase is keyword,
     *          then add to keyWords list
     * @param searchPhrase
     */
    public Query(String searchPhrase) {
        keyWords = new ArrayList<Word>();

        for (String word : searchPhrase.split(" ")) {
            if (Word.createWord(word).isKeyword())
                this.keyWords.add(Word.createWord(word));
        }
    }

    /**
     * @note Returns a list of the query’s keywords in the same order
     *       as they appear in the raw search phrase
     * @return keyWords
     */
    public List<Word> getKeywords() {
        return this.keyWords;
    }

    /**
     * @note Returns a list of matches against the input document.
     *       Sort matches by position where the keyword first appears
     *       in the document
     * @effects If title of d contains each keyword, then find frequency
     *          and first index appears in the document, then add to
     *          matches list
     * 
     *          Sort keyword by the first index position:
     *              Set max difference and it's position as default
     *              If any difference more than max difference,
     *                  then set max difference and it's position again
     *              Add the match in matches which has largest difference 
     *                  by it's position and set new match at now position
     * @param d
     * @return (ArrayList<Match>) matchesSort
     */
    public List<Match> matchAgainst(Doc d) {
        List<Match> matches = new ArrayList<Match>();
        Match match;
        String content = "";

        content = d.title + " " + d.body;
        
        for (Word key : this.keyWords) {
            int freq = 0, fiIndex = -1, index = -1;

            if (content.toLowerCase().contains(key.getText().toLowerCase())) {
                for (String word : content.split(" ")) {
                    index++;
                    if (key.getText().toLowerCase().equals(Word.createWord(word).getText().toLowerCase())) {
                        if (fiIndex == -1) fiIndex = index;
                        freq++;
                    }
                }

                match = new Match(d, key, freq, fiIndex);
                matches.add(match);
            }
        }

        for (int i = 0; i < matches.size() - 1; i++) {
            int maxCom = 0, posCom = i;

            for (int j = i + 1; j < matches.size(); j++) {
                int nowCom = matches.get(i).compareTo(matches.get(j));
                
                if (nowCom > maxCom) {
                    maxCom = nowCom;
                    posCom = j;
                }
            }
            
            if (posCom != i) {
                match = matches.get(i);
                matches.set(i, matches.get(posCom));
                matches.set(posCom, match);
            }
        }

        return matches;
    }
}