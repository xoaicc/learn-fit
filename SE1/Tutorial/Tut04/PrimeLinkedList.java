package SE1Tutorial.Tut04;

import java.util.*;

public class PrimeLinkedList extends LinkedList<Integer> {
	private Iterator<Integer> primeIterator() {
		return new PrimeIterator();
	}

	private class PrimeIterator implements Iterator<Integer> {
		private int currentIndex = -1;
		
		/*
 		 * @effects <pre>
 		 *  if(num<=1)
		 *  return false;
		 *  for loop from i=2 to (num-1)
		 *  if (num % 1 ==0) return false;
 		 *  return true;
		 * </pre>
		 */
		private boolean isPrime(int num) {
			if (num <= 1) {
				return false;
			}
			for (int i = 2; i < num; i++) {
				if (num % i == 0) {
					return false;
				}
			}
			return true;
		}
		
		/*
		 * @effects  <pre>
		 * if(PrimeLinkedList has more prime
		 * return true
		 * else return false;
		 * </pre>
		 */
		@Override
		public boolean hasNext() {
			for (int i = 0; i < PrimeLinkedList.this.size(); i++) {
				if (isPrime(PrimeLinkedList.this.get(i))) {
					return true;
				}
			}
			return false;
		}

       	/*
         * @effects   <pre>
         *      if(!hasNext)  throw new NoSuchElementException();
         *      	do {
		 *			currentIndex++;
		 *			} while (!isPrime(PrimeLinkedList.this.get(currentIndex)));
		 *				return PrimeLinkedList.this.get(currentIndex);
		 * </pre>
        */
		@Override
		public Integer next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			do {
				currentIndex++;
			} while (!isPrime(PrimeLinkedList.this.get(currentIndex)));
			return PrimeLinkedList.this.get(currentIndex);
		}
	}
	public static void main(String[] args) {
		PrimeLinkedList primeLinkedList = new PrimeLinkedList();
		primeLinkedList.addAll(Arrays.asList(1, 2, 5, 7, 9, 12, 14, 16, 22, 25, 27, 88));
		Iterator<Integer> primeIterator = primeLinkedList.primeIterator();
		while (primeIterator.hasNext()) {
			int next = primeIterator.next();
			System.out.println(next);
		}
	}
}
