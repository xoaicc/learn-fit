package a1_1901040247;

public class Match implements Comparable<Match> {
    Doc doc;
    Word word;
    int frNum;
    int fiIndex;

    /**
     * @note A constructor to initialize a Match object with the document,
     *       the word, the frequency of the word in the document
     *       and the first position of the word in the document
     * @param d
     * @param w
     * @param freq
     * @param firstIndex
     */
    public Match(Doc d, Word w, int freq, int firstIndex) {
        this.doc = d;
        this.word = w;
        this.frNum = freq;
        this.fiIndex = firstIndex;
    }

    /**
     * @return this.word
     */
    public Word getWord() {
        return this.word;
    }

    /**
     * @note Returns the frequency of the match (as explained above)
     * @return this.frNum
     */
    public int getFreq() {
        return this.frNum;
    }

    /**
     * @note Returns the first index of the match (as explained above)
     * @return this.fiIndex
     */
    public int getFirstIndex() {
        return this.fiIndex;
    }

    /**
     * @note Compare this with another Match object by the first index
     * @return Difference between fiIndex1 - fiIndex2
     */
    public int compareTo(Match o) {
        return this.fiIndex - o.getFirstIndex();
    }
}