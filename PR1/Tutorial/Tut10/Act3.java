package PR1Tutorial.Tut10;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

class Act3 {
    public static void main(String[] args) throws Exception {
        ArrayList strOutput = new ArrayList<String>();
        File f = new File("data.bin");
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        strOutput = (ArrayList<String>) ois.readObject();
        ois.close();
        for (int i = 0; i < strOutput.size(); i++) {
            System.out.println("The string " + (i+1) + " is: " + strOutput.get(i));
        }
    }
}