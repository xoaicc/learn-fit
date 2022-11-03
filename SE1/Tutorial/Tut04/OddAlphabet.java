package SE1Tutorial.Tut04;

import java.util.*;
import java.util.Iterator;

public class OddAlphabet implements Iterator<Character> {
    private int current = 65;
	private final int MAX = 91;
	private ArrayList<Character> alphabetList;

	public OddAlphabet() {
		this.alphabetList = new ArrayList<> ();
	}

	@Override
	public boolean hasNext() {
		return current < MAX;
	}

	@Override
	public Character next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		char abc = (char) current++;
		alphabetList.add(abc);
		return abc;
	}

	private ArrayList<Character> getCharacter() {
		return alphabetList;
	}

	private Iterator<Character> iterator() {
		return null;
	}

	public static void main(String[] args) {
		OddAlphabet alphabetEnglish = new OddAlphabet();
		while (alphabetEnglish.hasNext()) {
			alphabetEnglish.next();
		}
		System.out.println(alphabetEnglish.getCharacter());
		ArrayList<Character> oddList = alphabetEnglish.getCharacter();
		Iterator<Character> oddCharacters = oddList.iterator();
		ArrayList<Character> oddNew = new ArrayList<>();
		while (oddCharacters.hasNext()) {
			char a = oddCharacters.next();
			if ((int) a % 2 != 0) {
				oddNew.add(a);
			}
		}
		System.out.println(oddNew);
	}
}