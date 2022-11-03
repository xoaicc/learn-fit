package SE1Tutorial.Tut02;

import java.util.ArrayList;

public class MaxMinIntList extends ArrayList {
    public MaxMinIntList() {
        super();
    }

    public boolean validateInput (Object e) {
        return e instanceof Integer;
    }

    @Override
    public boolean add(Object o) {
        if(validateInput(o) == true) {
            return super.add(o);
        }
        System.out.println(o.toString() + " is an invalid type");
        return false;
    }

    public Integer min() {
        int minVal = (int)this.get(0); 
        int curVal;
        for(int i = 0; i < this.size(); ++i) {
            curVal=(int)this.get(i);
            if(minVal > curVal) minVal = curVal;
        }
        return minVal;
    }

    public Integer max() {
        int maxVal = (int)this.get(0); 
        int curVal;
        for(int i = 0; i < this.size(); ++i) {
            curVal = (int)this.get(i);
            if(maxVal < curVal) maxVal = curVal;
        }
        return maxVal;
    }
   
    public String repOK() {
        return this.toString() + " is a accurately an IntList";
    }
}