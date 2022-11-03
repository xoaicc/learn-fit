package SE1Tutorial.Tut04;

import java.util.*;

public class IntegerLinkedList extends LinkedList<Integer> {
	public Iterator<Integer> evenIterator() {
		return new EvenIterator();
	}

	private class EvenIterator implements Iterator<Integer> {
		private int currentIndex = -1;
		
		/**
		 * @effects <pre>
		 *     if elements still have even elements
		 *    		return true
		 *     else
		 *       	return false
		 * </pre>
		 */
		@Override
		public boolean hasNext() {
			List<Integer> elements = IntegerLinkedList.this;
			int size = elements.size();
			if (currentIndex > size ) {
				return false;
			}
			for (int i = currentIndex + 1; i < size; i++) {
				if (isEven(elements.get(i))) {
					return true;
				}
			}
			return false;
		}

		private boolean isEven(int number) {
			if (number % 2 == 0) {
				return true;
			} else
				return false;
		}

		/**
		 * @effects
		 * 
		 *          <pre>
		 *     if no more elements
		 *       throw NoSuchElementException
		 *     else
		 *       increment currentIndex until elements[currentIndex] is even
		 *       return elements[currentIndex]
		 *          </pre>
		 */
		@Override
		public Integer next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			List<Integer> elements = IntegerLinkedList.this;
			do {
				currentIndex++;
			} while (!isEven(elements.get(currentIndex)));
			return elements.get(currentIndex);
		}
	}
	public static void main(String[] args) {
		IntegerLinkedList eventLinkedList = new IntegerLinkedList();
		eventLinkedList.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		Iterator<Integer >evenIterator = eventLinkedList.evenIterator();
		while (evenIterator.hasNext()) {
			int next = evenIterator.next();
			System.out.println(next);
		}
	}
}