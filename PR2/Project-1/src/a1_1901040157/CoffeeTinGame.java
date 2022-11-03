package a1_1901040157;
import java.util.Arrays;
import java.util.Random;
import utils.TextIO;
/**
 * @overview A program that performs the coffee tin game on a 
 *    tin of beans and display result on the standard output.
 * 
 * @author Ngan Thi Phuc
 */
public class CoffeeTinGame {
  /** constant value for the green bean*/
  private static final char GREEN = 'G';
  /** constant value for the blue bean*/
  private static final char BLUE = 'B';
  /** constant for removed beans */
  private static final char REMOVED = '-';
  /** the null character*/
  private static final char NULL = '\u0000';

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
 // initialise some beans
    char[][] tins = {
        { BLUE, BLUE, BLUE, GREEN, GREEN},
      { BLUE, BLUE, BLUE, GREEN, GREEN, GREEN},
      {GREEN},
      {BLUE},
      {BLUE,GREEN}
    };

    for (int i = 0; i < tins.length; i++) {
      char[] tin = tins[i];

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
        System.out.printf("Oops, wrong last bean: %c (expected: %c)%n",lastBean,last);
      }
    }
  }

 /**
  * 
  * @param tin
  * @return
  */
  public static char tinGame(char[] tin) {    
	    int bean1, bean2;
	    int be1, be2;
	    int count = tin.length;
	    bean1 = 0;
	    //
	    // Loop invariant: 
	    //  p = p0 /\ count >= 1
	    // Loop variant:   
	    //  P(count) = false  if count >= 2
	    //             true   if count = 1      
	    //
	    // n=no of greens /\ m=no of blues /\ n+m=count /\ 
	    // (M1.2a: for all j=bean1 to tin.length-1. tin[j]!=REMOVED) /\ 
	    // (M1.2b: 1<=count<=tin.length) /\ 
	    // (M1.2c: bean1+count=tin.length /\ p=p0) 
	    while (count >= 2) {
	      // (M2.2: M1.2a /\ (M2.2a: 2<=count<=tin.length) /\ M1.2c /\ 
	      //  n=n /\ m=m /\ count=n+m)      
	      // remove be1, be2 from tin
	      be1 = tin[bean1];          // M2.2
	      bean2 = bean1+1;            // M2.2 /\ bean2=bean1+1
	      be2 = tin[bean2];          // M2.2 /\ bean2=bean1+1
	      tin[bean1] = REMOVED; 
	      tin[bean2] = REMOVED;     
	      if (be1 == BLUE && be2 == BLUE) { 
	         // put B in bin
	        tin[bean2] = BLUE;      // n=n /\ m=m-1 /\ count=n+m+1 /\ p=p0 /\ 
	        // bean2=bean1+1 /\ for all j=bean2 -> tin.length-1. tin[j]!=REMOVED
	      } else if (be1 == GREEN && be2 == GREEN) { 
	        // put B in bin
	        tin[bean2] = BLUE;      // n=n-2 /\ m=m+1 /\ count=n+m+1 /\ p=p0 /\
	        // bean2=bean1+1 /\ for all j=bean2 -> tin.length-1. tin[j]!=REMOVED
	      } else { // BG, GB    
	        // put G in bin
	        tin[bean2] = GREEN;     // n=n /\ m=m-1 /\ count=n+m+1 /\ p=p0 /\ 
	        // bi2=bi1+1 /\ for all j=bean2 -> tin.length-1. tin[j]!=REMOVED
	      }
	      // count=n+m+1 /\ p=p0 /\ bean2=bean1+1 /\ 
	      // for all j=bean2 -> tin.length-1. tin[j]!=REMOVED
	      count = count-1;
	      bean1 = bean1+1;          
	      // M1.2a /\ M1.2b /\ M1.2c
	    }
	    
	    // count=1 /\ M1.2c /\ tin[bean1]!=REMOVED
	    return tin[bean1];
	  }
  /**
   * 
   * @param n
   * @return
   */
  public static int randInt(int n) {
		Random rand = new Random(); // chose random from 0 to n
		return rand.nextInt(n);
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
    char first  = takeOne(tin);
    char second = takeOne(tin);
   
    return new char[] {first, second};
  }

  /**
   * @requires tin has at least one bean
   * @modifies tin
   * @effects 
   *   take a random bean in the tin 
   *   remove any bean from tin and return it
   */
  public static char takeOne(char[] tin) {
	    int rand = randInt(tin.length); 
	    char bean = tin[rand];// take a random bean in the tin 
	    if (bean != REMOVED) {  // found one
	        tin[rand] = REMOVED; // removed that bean 
	        return bean; // also return the bean as well 
	      }
	
	    
	    // no beans left
	    return NULL;
	  }
  /**
   * @requires BeansBag can hold up to 100 beans
   * @modifies BeansBag
   * @effects
   * 	chose a beans randomly
   *   if belongs to 50 lower that blue , others are green 
   */
  public static final char[]BeansBag = new char[100];
  static {
	 	for(int pos1 = 1; pos1 < 100 ;pos1++) {
	 		if(pos1 < 50) {
	 			pos1 = BLUE; // return blue bean
	 		}else if (pos1 > 50) {
	 			 pos1 = GREEN; // return green bean
	 		}
	 	}
	  
	 }
  /**
   * 
   * @param BeansBag
   * @param BeanType
   * @return
   */
  public static char getBean(char[]BeansBag ,char BeanType) {
	int bean = randInt(BeansBag.length); // chose a random bean in BeansBag
	if(BeansBag[bean] == BeanType) {
		BeansBag[bean]=REMOVED; // remove that bean
		return BeansBag[bean]; // return the bean value
	}else {
		return NULL; // not match the BeanType
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
	      if (tin[i] == REMOVED) { // vacant position
	        tin[i] = bean;
	        break;
	      }
	    }
	  }
	  /**
	   * 
	   * @param tin
	   */
	  public static void updateTin(char[] tin) {    
		    while (hasAtLeastTwoBeans(tin)) {
		      // take two beans from tin
		      char[] twoBeans = takeTwo(tin);
		      // process beans to update tin 
		      char b1 = twoBeans[0];
		      char b2 = twoBeans[1];
		      // process beans to update tin 
		      if (b1 == b2) { 
		        // put B in bin
		        putIn(tin, getBean(BeansBag, BLUE));  // initialize the blue beans
		      } else { // BG, GB    
		        // put G in bin
		        putIn(tin, getBean(BeansBag, GREEN));    
		      }
		    }
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
	      if (bean != REMOVED) {
	        return bean;
	      }
	    }
	    
	    // no beans left
	    return NULL;
	  }
	}

