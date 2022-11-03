package SE1Tutorial.Tut04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class OddAlphabetList implements Iterator<Integer> {
		private int start = 64;
		private final int end = 89;
		private ArrayList<Integer> numberList;

		public OddAlphabetList() {
			this.numberList = new ArrayList<Integer>(30);
		}

		/*
		 * @effects <pre> 
		 * 		while 
		 * 			start is not the odd => start++ return the
		 * 			start (odd number) 
		 * </pre>
		 */
		private int extendOddList() {
			do {
				this.start++;
			} while (!isOdd(this.start));
			return this.start;
		}

		/*
		 * @effects <pre> 
		 * 		return start %2!=0;
		 */
		private boolean isOdd(int num) {
			return this.start % 2 != 0;
		}
		
		/*
		 * @effects <pre> 
		 * 		return start < end
		 * </pre>
		 */

		@Override
		public boolean hasNext() {
			return start < end;
		}

		/*
		 * @effects <pre> 
		 * 		if (!hasNext()) => throw new NoSuchElementException; 
		 * 		add oddNumber = extendOddList() to the numberList; 
		 * 		return oddNumber;
		 */
		@Override
		public Integer next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			int oddNumber = extendOddList();
			numberList.add(oddNumber);
			return oddNumber;
		}

		/*
		 * @effects return numberList;
		 */
		private ArrayList<Integer> getElement() {
			return numberList;
		}
	public static void main(String[] args) {
		OddAlphabetList oddAlphabetList = new OddAlphabetList();
		while (oddAlphabetList.hasNext()) {
			oddAlphabetList.next();
		}
		ArrayList<Character> characters = new ArrayList<>();
		for (int i = 0; i < oddAlphabetList.getElement().size(); i++) {
			int a = oddAlphabetList.getElement().get(i);
			char b = (char) a;
			characters.add(b);
		}
		System.out.println(characters);
	}
}
