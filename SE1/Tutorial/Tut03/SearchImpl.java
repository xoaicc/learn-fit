package SE1Tutorial.Tut03;

import javax.naming.NameNotFoundException;

public class SearchImpl {
    public static class Search1 {
        /**
         * @require a is sorted
         * @effects <pre>
         *      if a is null
         *          throw NullPointerException
         *      else if x not in a
         *          throw NotFoundException
         *      else
         *          return i s.t. a[i] = x
         * </pre>
         */
        public static int Search(int[] a, int x)
        throws NullPointerException, NotFoundException {
            if (a == null) {
                throw new NullPointerException("Array is null");
            }
            for (int i = 0; i < a.length; i++) {
                if (a[i] == x) {
                    return i;
                }
            }
            throw new NotFoundException("Item " + x + " not found!");
        }
    }

    public static class Search2 {
        /**
         * @require a is sorted
         * @effects <pre>
         *      if a is null
         *          throw NullPointerException
         *      else if x not in a
         *          throw NotFoundException
         *      else
         *          return i s.t. a[i] = x
         * </pre>
         */
        public static int Search(int[] a, int x)
        throws NullPointerException, NotFoundException {
            int i = 0;

            if (a == null) {
                throw new NullPointerException("Array is null");
            }
            
            while (true) {
                try {
                    if (a[i] == x) {
                        return i;
                    }
                    i++;
                } catch (ArrayIndexOutOfBoundsException ex) {
                    break;
                }
            }
            throw new NotFoundException("Item " + x + " not found!");
        }
    }

    public static class NotFoundException extends RuntimeException {
        public NotFoundException(String message) { super(message);}
    }
}