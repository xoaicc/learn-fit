package SE1Tutorial.Tut06.ArraysTest;

/**
 * @overview
 *    a program that implements solutions for a number of problems
 *    involving the use of the array construct
 * @author dmle
 */
public class Arrays {

  /**
   * @requires
   *  a != null
   * @effects 
   *  return the number of elements of a that are negative
   */
  public static int countNegative(int[] a) {
    int count = 0;
    for (int x : a) {
      if (x < 0)
        count++;
    }
    
    return count;
  }
  
  /**
   * @requires
   *  a != null  /\ a.length > 0
   * @effects 
   * return the minimum element of a
   */
  public static int min(int[] a) {
    int min = a[0];
    for (int x: a) {
      if (x < min) {
        min = x;
      }
    }
    
    return min;
  }
  
  /**
   * Determine whether an array of integers is in ascending order
   * 
   * @requires
   *  a != null 
   * @effects
   *  if a is sorted in ascending order
   *    return true
   *  else
   *    return false
   */
  public static boolean isAscSorted(int[] a) {
    // loop through the array comparing the current element with the 
    // next one (if available): a is sorted in ASC order iff 
    // all comparisons result in one element is <= to the next element
    int len = a.length;
    for (int i = 0; i < len; i++) {
      if (i < len-1 && a[i] > a[i+1]) // return immediately
        return false;
    }
    
    return true;
  }
  
  /**
   * Return the length of a array of CHARS (d) on the understanding that if
   * it contains the character NUL (the character '\u0000' in Java),
   * assumed predefined as a constant, then that and any characters after it
   * are not to be counted. In other words, NUL is understood as a
   * terminator
   * 
   * @requires 
   *  a != null
   * @effects 
   *  if a.length = 0
   *    return 0
   *  else 
   *    return the number of characters from the start position of a that are not NUL
   *    (i.e. character '\u0000')
   */

  public static int length(char[] a) {
    final char NUL = '\u0000';
    
    int len = 0;
    for (char c : a) {
      if (c != NUL) {
        len++;
      } else {
        break;
      }
    }
    
    return len;
  }
  
  /**
   * Return the median of an array of reals, that is the array value closest
   * to the middle in the sense that as many array elements are smaller than it
   * as are greater than it.
   * 
   * @requries 
   *  a != null /\ a's elements are distinct
   * @effects 
   *  if a.length = 0
   *    return 0
   *  else
   *    return the median element of a, i.e. the element that has as many elements smaller than it 
   *    as elements greater than it
   */
  public static double median(double[] a) {
    
    // loop through a and find an element that has exactly (a.length+1)/2 
    // smaller than or equal to it.
    final int half = (a.length+1)/2;
    int count;
    
    double median=0D;
    
    for (double x : a) {
      count = 0;
      for (double y : a) {
        if (y <= x) { 
          count++;
        }
      }
      
      if (count == half) {
        median = x; //return x;
      }
    }
    
    return median; 
  }
  
  
 /** 
  * Given two arbitrary arrays of reals, a and b, determine if a sub-set b, a super-set b, a intersects with b, or a = b
  * 
  * @requires
  *   a != null /\ b != null
  * @effects
  *   if a is disjoint with b 
  *     return -2
  *   else if a is a sub-set of b 
  *     return -1, 
  *   else if a is equal to b
  *     return 0
  *   else if a is a super-set of b 
  *     return 1
  *   else // a intersects with b
  *    return 2
  */ 
    
  public static int compare(double[] a, double[] b) {
    int al = a.length;
    int bl = b.length;

    if (al == 0 || bl == 0) // both empty -> equal
      return 0;

    // arrange a and b s.t smaller array is first
    double[] a1, a2;
    if (al >= bl) {
      a1 = b;
      a2 = a;
    } else {
      a1 = a;
      a2 = b;
    }

    int countShared = 0;
    for (int i = 0; i < a1.length; i++) {
      for (int j = 0; j < a2.length; j++) {
        if (a1[i] == a2[j]) {
          countShared++;
          break;
        }
      }
    }

    // determine the output
    if (countShared == 0) { // disjoint
      return -2;
    } else {
      if (countShared == al) {   
        if (al == bl)       // equal
          return 0;
        else                // sub-set
          return -1;
      } else if (countShared == bl) {
        if (al == bl)       // equal
          return 0;
        else                // superset
          return 1;
      } else {    // intersects with
        return 2;
      }
    }
  }
  
  /**
   * 
   * Compute the frequencies of each element of an array of reals.
   * 
   * @requires 
   *    a != null
   * @effects 
   *  return an array containing the frequencies of each element of a
   */
  // 
  public static int[] freq(double[] a) {
    int[] freq = new int[a.length];
    java.util.Arrays.fill(freq, 1);
  
    /**
     * <pre>
     *  loop through the array, counting the number of each element
     *  and updating the corresponding elements in freq such that
     *     the first element has the freq number, the subsequent 
     *     elements have the position of the first element * -1
     *  if found an element whose freq value is negative number, update it using 
     *  the value of the position in freq set by this number
     */
    double e;
    for (int i = 0; i < a.length; i++) {
      e = a[i];
      if (freq[i] < 0) {
        // already counted, update only
        freq[i] = freq[(-1 * freq[i]) - 1];
        continue;
      }
  
      for (int j = 0; j < a.length; j++) {
        if (j <= i) //no need to search before i
          continue;
        
        if (a[j] == e) {
          // update frequency
          freq[i]++;
          // record as counted
          freq[j] = -1 * (i + 1);
        }
      }
    }
  
    return freq;
  }
  
  // the run method
  public static void main(String[] args) {
    // countNegative()
    int[] a = {-1, 0, 1, -2, 2};
    int c = countNegative(a);
    int ct = 2;
    System.out.printf("countNegative(%s) = %d (expecting %d)%n",java.util.Arrays.toString(a), c, ct);
    assert(c == ct);
    
    // min()
    int m = min(a);
    int mt = -2;
    System.out.printf("min(%s) = %d (expecting %d)%n", java.util.Arrays.toString(a), m, mt);
    assert(m == mt);
    
    // isAscSorted
    //a = new int[] {-2, -1, 0, 1, 2};
    boolean b = isAscSorted(a);
    boolean bt = false;
    System.out.printf("isAscSorted(%s) = %b (expecting %b)%n", java.util.Arrays.toString(a), b, bt);
    assert(b == bt);
    
    // length
    char[] arr = {'h', 'e', 'l', 'l', 'o', '\u0000', 'w'};
    int l = length(arr);
    int lt = 5;
    System.out.printf("length(%s) = %d (expecting %d)%n", java.util.Arrays.toString(a), l, lt);
    assert(l == lt);

    // median
    double[][] darrs = {
        {1d}, //
        {2d, 1d}, //
        {1d, 3d, 2d}, // 
        {4d, 1d, 2d, 3d}, // 
        {100d, 5d, 11d, 1d}, // 
        {5d, 1d, 3d, 2d, 4d}, // 
    };
    
    double[] mts = {
        1d, 1d, 2d, 2d, 5d, 3d
    };
    
    int index=0;
    double e,et;
    for (double[] darr : darrs) {
      e = median(darr);
      et = mts[index++];
      System.out.printf("median(%s) = %f (expecting %f)%n", java.util.Arrays.toString(darr), e, et);
      assert(e == et);
    }
    
    double[] a1 = {-1,-2,3};
    double[] a2 = {1,2,4};
    int p = compare(a1,a2);
    int pt = -2;
    System.out.printf("compare(%s,%s) = %d (expecting %d)%n", java.util.Arrays.toString(a1), 
        java.util.Arrays.toString(a2), p, pt);
    assert(p == pt);    
   }
  
}
