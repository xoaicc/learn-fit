package a1_1901040247;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        boolean canLoadStopWords = Word.loadStopWords("stopwords2.txt");
        if (canLoadStopWords) {
            System.out.println("Word.loadStopWords(): incorrect return value (expected: false)");
        }
        canLoadStopWords = Word.loadStopWords("stopwords.txt");
        if (!canLoadStopWords) {
            System.out.println("Word.loadStopWords(): incorrect return value (expected: true)");
        }
        if (Word.stopWords.size() != 174) {
            System.out.println("Word.loadStopWords(): incorrect number of stopWords loaded (expected: 174)");
        }
        Engine e = new Engine();
        // docs folder contains: 1.txt, 2.txt... 10.txt
        int loadedDocs = e.loadDocs("docs"); // takes folder name as input
        if (loadedDocs != 10) System.out.println("Word.loadDocs(): incorrect return value (expected: 10)");

        if (Word.createWord("").isKeyword())
            System.out.println("Word.createWord(): empty string ('') should be an invalid word (not a keyword)");
        if (Word.createWord("123456").isKeyword())
            System.out.println("Word.createWord(): '123456' should be an invalid word (not a keyword)");
        if (Word.createWord("!@#$%^").isKeyword())
            System.out.println("Word.createWord(): '!@#$%^' should be an invalid word (not a keyword)");
        if (Word.createWord("se2021").isKeyword())
            System.out.println("Word.createWord(): 'se2021' should be an invalid word (not a keyword)");
        if (Word.createWord(" and").isKeyword())
            System.out.println("Word.createWord(): ' and' should be treated as an invalid word (not a keyword because it contains a space)");
        if (Word.createWord(",se2021.").isKeyword())
            System.out.println("Word.createWord(): ',se2021.' should be an invalid word");
        if (Word.createWord("the").isKeyword())
            System.out.println("Word.isKeyword(): 'the' is a stop word (not a keyword)");
        if (Word.createWord("of").isKeyword())
            System.out.println("Word.isKeyword(): 'of' is a stop word (not a keyword)");
        if (!Word.createWord("context").isKeyword())
            System.out.println("Word.isKeyword(): 'context' should be a keyword");
        if (!Word.createWord("design").isKeyword())
            System.out.println("Word.isKeyword(): 'design' should be a keyword");
        if (!Word.createWord(",se2021.").getText().equals(",se2021."))
            System.out.println("Word.createWord(): the text part of ',se2021.' should be ',se2021.'");
        if (!Word.createWord(",se2021.").getPrefix().equals(""))
            System.out.println("Word.createWord(): the prefix of ',se2021.' should be empty");
        if (!Word.createWord(",se2021.").getSuffix().equals(""))
            System.out.println("Word.createWord(): the suffix of ',se2021.' should be empty");
        if (!Word.createWord("word,").getText().equals("word"))
            System.out.println("Word.createWord(): the text part of 'word,' should be 'word'");
        if (!Word.createWord("word,").getPrefix().equals(""))
            System.out.println("Word.createWord(): the prefix of 'word,' should be empty");
        if (!Word.createWord("word,").getSuffix().equals(","))
            System.out.println("Word.createWord(): the suffix of 'word,' should be ','");
        if (!Word.createWord("«word»").getText().equals("word"))
            System.out.println("Word.createWord(): the text part of '«word»' should be 'word'");
        if (!Word.createWord("«WORD»").getPrefix().equals("«"))
            System.out.println("Word.createWord(): the prefix of '«WORD»' should be '«'");
        if (!Word.createWord("«Word»").getSuffix().equals("»"))
            System.out.println("Word.createWord(): the suffix of '«Word»' should be '»'");
        if (!Word.createWord("apple").equals(Word.createWord("apple")))
            System.out.println("Word.equals() failed with case 'apple'");
        if (!Word.createWord("apple").equals(Word.createWord("Apple")))
            System.out.println("Word.equals() should be case-insensitive, so 'apple' should be equal to 'Apple'");
        if (!Word.createWord("content").equals(Word.createWord("\"content\".")))
            System.out.println("Word.equals() should compare the text part only, so 'content' should be equal to '\"content\".'");

        Doc d = new Doc("Object-oriented \"design\": with UML's diagrams\n" +
                "Definition: An object-oriented system's context made up of (interacting) objects.");
        Query q = new Query("the <context> of observer: design");
        // Testing Doc & Query
        Object[] tests = {d.getTitle(), d.getBody(), q.getKeywords()};
        int[] listSizes = {5, 10, 3};
        String[] methods = {"Doc.getTitle()", "Doc.getBody()", "Query.getKeywords()"};
        Object[] wordTexts = new Object[3];
        wordTexts[0] = new String[]{"Object-oriented", "design", "with", "UML", "diagrams"};
        wordTexts[1] = new String[]{"Definition", "An", "object-oriented", "system", "context", "made", "up", "of", "interacting", "objects"};
        wordTexts[2] = new String[]{"context", "observer", "design"};
        Object[] wordPrefixes = new Object[3];
        wordPrefixes[0] = new String[]{"", "\"", "", "", ""};
        wordPrefixes[1] = new String[]{"", "", "", "", "", "", "", "", "(", ""};
        wordPrefixes[2] = new String[]{"<", "", ""};
        Object[] wordSuffixes = new Object[3];
        wordSuffixes[0] = new String[]{"", "\":", "", "'s", ""};
        wordSuffixes[1] = new String[]{":", "", "", "'s", "", "", "", "", ")", "."};
        wordSuffixes[2] = new String[]{">", ":", ""};
        Object[] wordTypes = new Object[3]; // if a word is keyword or not
        wordTypes[0] = new boolean[]{true, true, false, true, true};
        wordTypes[1] = new boolean[]{true, false, true, true, true, true, false, false, true, true};
        wordTypes[2] = new boolean[]{true, true, true};
        for (int x = 0; x < tests.length; x++) {
            List<Word> tmp = (List<Word>) tests[x];
            String[] wtxt = (String[]) wordTexts[x];
            String[] wpf = (String[]) wordPrefixes[x];
            String[] wsf = (String[]) wordSuffixes[x];
            boolean[] wtp = (boolean[]) wordTypes[x];
            if (tmp.size() != listSizes[x]) {
                System.out.println(methods[x] + ": unexpected list length");
            } else {
                for (int i = 0; i < tmp.size(); i++) {
                    if (!wtxt[i].equals(tmp.get(i).getText()))
                        System.out.println(methods[x] + ": incorrect word text '" + tmp.get(i).getText() + "' (expected '" + wtxt[i] + "')");
                    if (!wpf[i].equals(tmp.get(i).getPrefix()))
                        System.out.println(methods[x] + ": incorrect word prefix '" + tmp.get(i).getPrefix() + "' (expected '" + wpf[i] + "')");
                    if (!wsf[i].equals(tmp.get(i).getSuffix()))
                        System.out.println(methods[x] + ": incorrect word suffix '" + tmp.get(i).getSuffix() + "' (expected '" + wsf[i] + "')");
                    if (wtp[i] != tmp.get(i).isKeyword())
                        System.out.println(methods[x] + ": incorrect isKeyword for '" + tmp.get(i).toString() + "' (expected: " + wtp[i] + ")");
                }
            }
        }
        // Testing Query & Match
        List<Match> matches = q.matchAgainst(d);
        String[] matchedWords = {"design", "context"};
        if (matches.size() != 2) {
            System.out.println(matches.size() + "Query.matchAgainst(): incorrect matches count (expected: 2)");
        }
        for (int i = 0; i < matches.size(); i++) {
            if (!matches.get(i).getWord().getText().equals(matchedWords[i])) {
                System.out.println("Query.matchAgainst(): incorrect word '" + matches.get(i).getWord().getText() + " (expected: '" + matchedWords[i] + "')");
            }
        }
        // Testing Result
        List<Result> results = e.search(q);
        if (results.size() != 8) System.out.println("Engine.search(): incorrect results count");

        int[] matchCounts = {2, 1, 1, 1, 1, 1, 1, 1};
        for (int i = 0; i < results.size(); i++) {
            int x = results.get(i).getMatches().size();
            if (x != matchCounts[i]) {
                System.out.println("Engine.search(): incorrect match count (actual: " + x + ", expected: " + matchCounts[i]+ ")");
            }
        }
        String tmpTitle = results.get(0).getDoc().getTitle().toString();
        if (!tmpTitle.equals("[System, context, and, interactions]")) {
            System.out.println("Engine.search(): incorrect first result '" + tmpTitle + "' (expected '[System, context, and, interactions])'");
        }
        tmpTitle = results.get(1).getDoc().getTitle().toString();
        if (!tmpTitle.equals("[Design, patterns]")) {
            System.out.println("Engine.search(): incorrect second result '" + tmpTitle + "' (expected '[Design, patterns])'");
        }
        // Testing HTML highlights
        Scanner sc = new Scanner(new File("testCases.html"));
        String firstResultHTML = sc.nextLine();
        if (!firstResultHTML.equals(results.get(0).htmlHighlight().trim())) {
            System.out.println("Result.htmlHighlight(): incorrect output for first result");
        }
        String secondResultHTML = sc.nextLine();
        if (!secondResultHTML.equals(results.get(1).htmlHighlight().trim())) {
            System.out.println("Result.htmlHighlight(): incorrect output for second result");
        }
        String html = e.htmlResult(results).trim(); // ranked result in simple HTML format
        String expectedHTML = sc.nextLine();
        if (!html.equals(expectedHTML)) {
            System.out.println("Engine.htmlResult(): incorrect output");
        }
    }
}