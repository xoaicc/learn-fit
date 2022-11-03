package SE1Tutorial.Tut02;

/**
 * @attributes
 *      time Integer
 * @Object A typical Counter increase the time
 *      AF(c) =
 * @rep_invariant
 *      time instanceof Integer
 */
public class Counter {

    /**
     * @effects Makes this contain 0
     */
    public Counter() {
    }

    /**
     *
     * @effects Returns the value of this
     */
    public int get() {
        return 0;
    }

    /**
     * @modifies this
     * @effects Increments the value of this
     */
    public void incr() {
    }

}
