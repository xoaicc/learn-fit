package SE1Tutorial.Tut04;

import java.util.*;

public class RandomNums implements Iterator<Integer> {
	private ArrayList<Integer> randomNums;

	public RandomNums() {
		this.randomNums = new ArrayList<>();
	}
  	
	/*
   	* @effects
   	* 		while (true) generate a new random integer
   	* 			return random number
   	*/
	private int generateRandom() {
		while (true) {
			Random random = new Random();	
			return random.nextInt(100) + 1;
		}

	}
	
	/*
 	* @effects 
 	* 		return randomNums.size()<10
 	*/
	@Override
	public boolean hasNext() {
		return randomNums.size() < 10;
	}

	/*
	 * @effects <pre>
	 * 		if (!hasNext)
	 * 			throw new NoSuchElementException();
	 * 		else 
	 * 			add random numbers in ArrayList randomNums;
	 * 			return randomNumber;
	 * </pre>
	 */
	@Override
	public Integer next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		} else {
			int randomNumber = generateRandom();
			this.randomNums.add(randomNumber);
			return randomNumber;
		}
	}

	/*
	 * return randomNums
	 */
	private ArrayList<Integer> getElement() {
		return randomNums;
	}
	public static void main(String[] args) {
		RandomNums aNums = new RandomNums();
		while (aNums.hasNext()) {
			aNums.next();
		}
		System.out.println(aNums.getElement());	
	}
}