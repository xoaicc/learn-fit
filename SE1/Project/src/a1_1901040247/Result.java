package a1_1901040247;

import java.util.List;

public class Result implements Comparable<Result> {
    Doc doc;
    List<Match> matches;

    /**
     * @note A constructor to initialize a Result object 
     *       with the related document and the list of matches
     * @param d
     * @param matches
     */
    public Result(Doc d, List<Match> matches) {
        this.doc = d;
        this.matches = matches;
    }

    /**
     * @return this.doc
     */
    public Doc getDoc() {
        return this.doc;
    }

    /**
     * @return this.matches
     */
    public List<Match> getMatches() {
        return this.matches;
    }

    /**
     * @return total
     */
    public int getTotalFrequency() {
        int total = 0;

        for (Match match : this.matches) {
            total += match.getFreq();
        }
        
        return total;
    }
    
    /**
     * @effects Sum of first indexes then divide the number of matches
     * @return avarage
     */
    public double getAverageFirstIndex() {
        double total = 0.0;

        for (Match match : this.matches) {
            total += match.getFirstIndex();
        }

        return total / (double) this.matches.size();
    }
    
    /**
     * @note Highlight the matched words in the document using HTML markups
     * @effects Find keyword, then:
     *          if word in title, then add marks <u></u> around the keyword
     *          else add marks <b></b> around the keyword
     * @return Both of title and body after config
     */
    public String htmlHighlight() {
        String newTitle = "", newBody = "";

        for (Word word : doc.getTitle()) {
            String wordHl = word.getText();

            for (Match match : matches) {
                if (wordHl.toLowerCase().equals(match.getWord().getText().toLowerCase())) {
                    wordHl = "<u>" + wordHl + "</u>";
                    break;
                }
            }

            newTitle += word.getPrefix() + wordHl + word.getSuffix() + " ";
        }

        for (Word word : doc.getBody()) {
            String wordHl = word.getText();

            for (Match match : matches) {
                if (wordHl.toLowerCase().equals(match.getWord().getText().toLowerCase())) {
                    wordHl = "<b>" + wordHl + "</b>";
                    break;
                }
            }
            
            newBody += word.getPrefix() + wordHl + word.getSuffix() + " ";
        }

        return "<h3>" + newTitle.trim() + "</h3><p>" + newBody.trim() + "</p>";
    }
    
    /**
     * @note These are criteria to determine if Result A is greater than Result B
     * @effects If A greater than B then point = 1
     *          else if A = B than point = 0
     *          else point = -1
     */
    public int compareTo(Result o) {
        int mPoint1 = this.matches.size();
        int mPoint2 = o.matches.size();
        int tPoint1 = this.getTotalFrequency();
        int tPoint2 = o.getTotalFrequency();
        double aPoint1 = this.getAverageFirstIndex();
        double aPoint2 = o.getAverageFirstIndex();

        if (mPoint1 > mPoint2) return 1;
        else if (mPoint1 < mPoint2) return -1;

        if (tPoint1 > tPoint2) return 1;
        else if (tPoint1 < tPoint2) return -1;

        if (aPoint1 < aPoint2) return 1;
        else if (aPoint1 > aPoint2) return -1;

        return 0;
    }
}