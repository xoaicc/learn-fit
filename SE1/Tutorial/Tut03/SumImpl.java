package SE1Tutorial.Tut03;

public class SumImpl {
    public static class Sum1 {
        /**
         * @requires a is not null /\ a is not empty
         * @effects <pre>
         *      if a is empty
         *          return 0
         *      else
         *          return S s.t. S = a[1] + ... + a[n] where n is length of a
         * </pre>
         */
        public static int sum(int[] a) {
            return 0;
        }
    }
    public static class Sum2 {
        /**
         * @requires a is not null /\ a is not empty
         * @effects <pre>
         *      if a is empty
         *          throw EmptyArrayException
         *      else
         *          return S s.t. S = a[1] + ... + a[n] where n is length of a
         * </pre>
         */
        public static int sum(int[] a) {
            return 0;
        }
    }
}