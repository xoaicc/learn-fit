package SE1Tutorial.Tut04;

import java.util.*;

public class First10Primes implements Iterator<Integer> {
    private final ArrayList<Integer> elements;
    private int current = 0;
    public First10Primes() {
        this.elements = new ArrayList<>();
    }
        
    /**
     * @effects <pre>
     *      if this list has less than 10 elements
     *          return true
     *      else
     *          return false
     * </pre>
     */
    @Override
    public boolean hasNext() {
        return elements.size() < 10;
    }

    /**
     * @effects
     * 
     */
    private boolean isPrime(int num) {
        if (num <= 1) {
			return false;
		}
		else {
			for (int i = 2; i < num; i++) {
				if (num % i == 0) {
					return false;
				}
			}
			return true;
		}
    }
    /**
     * @effects <pre>
     *      while this.current is not prime
     *          increment this.current by 1
     *      if this.current is prime
     *          return this.current
     * </pre>
     * @modifies this.current
     */
    private int nextPrime() {
        do {
            this.current++;
        } while (!isPrime(this.current));
        return this.current;
    }

    /**
     * @effects <pre>
     *      if no more elements
     *          throw NoSuchElementException
     *      else
     *          generate the next prime
     *          add it to elements
     *          return it
     * </pre>
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            int next = nextPrime();
            this.elements.add(next);
            return next;
        }
    }
    public ArrayList<Integer> getElements() {
        return elements;
    }
    public static void main(String[] args) {
        First10Primes generator = new First10Primes();
        while (generator.hasNext()) {
            generator.next();
        }
        System.out.println(generator.getElements());
    }
}