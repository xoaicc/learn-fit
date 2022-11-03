package a1_1901040070;

import java.util.Arrays;
import utils.TextIO;

/**
 * @overview A program that performs the coffee tin game on a
 *    tin of beans and display result on the standard output.
 *
 */
public class CoffeeTinGame {
    /** constant value for the green bean*/
    private static final char GREEN = 'G';
    /** constant value for the blue bean*/
    private static final char BLUE = 'B';
    /** constant for removed beans */
    private static final char REMOVED = '-';
    /** constant for the null character */
    private static final char NULL = '\u0000';
    /** constant for the bean array */
    private static final char[] BeansBag = new char[66];

    static {
        Arrays.fill(BeansBag, 0, 22, BLUE);
        Arrays.fill(BeansBag, 23, 44, GREEN);
        Arrays.fill(BeansBag, 45, 66, REMOVED);
    }

    /**
     * the main procedure
     * @effects
     *    initialise a coffee tin
     *    {@link TextIO#putf(String, Object...)}: print the tin content
     *    {@link @tinGame(char[])}: perform the coffee tin game on tin
     *    {@link TextIO#putf(String, Object...)}: print the tin content again
     *    if last bean is correct
     *      {@link TextIO#putf(String, Object...)}: print its colour
     *    else
     *      {@link TextIO#putf(String, Object...)}: print an error message
     */
    public static void main(String[] args) {
        // initialise some beans
        char[][] tins = {
                {BLUE, BLUE, BLUE, GREEN, GREEN},
                {BLUE, BLUE, BLUE, GREEN, GREEN, GREEN},
                {GREEN},
                {BLUE},
                {BLUE, GREEN}
        };

        for (char[] tin : tins) {
            // expected last bean
            // p0 = green parity /\
            // (p0=1 -> last=GREEN) /\ (p0=0 -> last=BLUE)
            // count number of greens
            int greens = 0;
            for (char bean : tin) {
                if (bean == GREEN)
                    greens++;
            }
            final char last = (greens % 2 == 1) ? GREEN : BLUE;

            // print the content of tin before the game
            System.out.printf("%nTIN (%d Gs): %s %n", greens, Arrays.toString(tin));

            // perform the game
            char lastBean = tinGame(tin);
            // lastBean = last \/ lastBean != last

            // print the content of tin and last bean
            System.out.printf("tin after: %s %n", Arrays.toString(tin));

            // check if last bean as expected and print
            if (lastBean == last) {
                System.out.printf("last bean: %c%n", lastBean);
            } else {
                System.out.printf("Oops, wrong last bean: %c (expected: %c)%n", lastBean, last);
            }
        }
    }

    /**
     * Performs the coffee tin game to determine the colour of the last bean
     *
     * @requires tin is not null /\ tin.length > 0
     * @modifies tin
     * @effects <pre>
     *   take out two beans from tin
     *   update tin with 2 beans are taken
     *   </pre>
     */
    public static char tinGame(char[] tin) {
        while (hasAtLeastTwoBeans(tin)) {
            // take 2 beans from tin
            char[] twoBeans = takeTwo(tin);
            updateTin(tin, twoBeans);
        }
        return anyBean(tin);
    }

    /**
     * @effects
     *  if tin has at least two beans
     *    return true
     *  else
     *    return false
     */
    private static boolean hasAtLeastTwoBeans(char[] tin) {
        int count = 0;
        for (char bean : tin) {
            if (bean != REMOVED) {
                count++;
            }

            if (count >= 2) // enough beans
                return true;
        }

        // not enough beans
        return false;
    }

    /**
     * @requires tin has at least 2 beans left
     * @modifies tin
     * @effects
     *  remove any two beans from tin and return them
     */
    private static char[] takeTwo(char[] tin) {
        char first = takeOne(tin);
        char second = takeOne(tin);

        return new char[]{first, second};
    }

    /**
     * @requires tin has at least one bean
     * @modifies tin
     * @effects
     *   remove any bean from tin and return it
     */
    public static char takeOne(char[] tin) {
        int num = 0;

        for (char bean : tin) {
            if (bean != REMOVED) {
                num++;
            }
        }

        char bean;

        if (num >= 1) {
            do {
                int i = randInt(tin.length);
                bean = tin[i];
                if (bean != REMOVED) {
                    tin[i] = REMOVED;
                    return bean;
                }
            } while (true);
        }
        return NULL;
    }

    /**
     * @effects
     *   if ranBean == beanType & ranBean != REMOVED
     *   	return ranBean
     */
    public static char getBean(char[] beansBag, char beanType) {
        if (anyBean(beansBag) != NULL) {
            char bean;
            int i;

            do {
                i = randInt(beansBag.length);
                bean = beansBag[i];
            } while (bean == REMOVED || bean != beanType);

            beansBag[i] = REMOVED;
            return bean;
        }
        return NULL;
    }

    /**
     * Update tin according to the game moves.
     *
     * @requires <tt>tin != null /\
     *  twoBeans != null /\ twoBeans.length=2 /\
     * twoBeans[0], twoBeans[1] in { BLUE, GREEN } </tt>
     * @modifies <tt>tin</tt>
     * @effects <tt>let b1 = twoBeans[0], b2 = twoBeans[1]
     *    if b1 = b2
     *      throw both away
     *      put a blue bean back
     *    else
     *      throw away the blue bean
     *      put the green one back
     *  </tt>
     */
    public static void updateTin(char[] tin, char[] twoBeans) {
        char b1 = twoBeans[0], b2 = twoBeans[1];

        if (b1 == b2) {
            if (b1 != BLUE) {
                getBean(BeansBag, BLUE);
            }
            putIn(tin, BLUE);
        } else {
            putIn(tin, GREEN);
        }
    }

    /**
     * @requires tin has vacant positions for new beans
     * @modifies tin
     * @effects
     *   place bean into any vacant position in tin
     */
    private static void putIn(char[] tin, char bean) {
        for (int i = 0; i < tin.length; i++) {
            if (tin[i] == REMOVED) {
                tin[i] = bean;
                break;
            }
        }
    }

    /**
     * @effects
     *   return random number in range (0, n)
     */
    public static int randInt(int n) {
        int ranNum = (int) (Math.random() * n);
        return ranNum;
    }

    /**
     * @effects
     *  if there are beans in tin
     *    return any such bean
     *  else
     *    return '\u0000' (null character)
     */
    private static char anyBean(char[] tin) {
        for (char bean : tin) {
            if (bean != REMOVED) return bean;
        }
        return NULL;
    }
}
