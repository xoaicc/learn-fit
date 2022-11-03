package PR1Tutorial.Tut06;

public class FactorGenerator {
    int num;
    
    /**
     * 
     * @param numberToFactor
     */
    public FactorGenerator(int numberToFactor) {
        this.num = numberToFactor;
    }

    /**
     * @modifies num
     * @effects Take a factor of num and return num after modifying
     *          Return -1 if it's impossible
     */
    public int nextFactor() {
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                num /= i;
                return i;
            }
        }
        return -1;
    }

    /**
     * @effects Check num is last factor
     */
    public boolean hasMoreFactors() {
        return (num != 1);
    }
}