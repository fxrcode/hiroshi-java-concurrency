package learn;

import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Excep {
    final static Logger logger = Logger.getLogger(Excep.class.getSimpleName());

    @Test
    public void meth1() {
        try {
            int i = 1;
            System.out.println("Level a");
            var ret = meth2(i);
            System.out.println(ret);
        } catch (Exception e) {
//            logger.error("an exception was thrown", e);
            logger.log(Level.SEVERE, e.toString(), e);
        } finally {
            System.out.println("This is finally");
        }
    }

    private int meth2(int i) {
        int ret = 0;
        try {
            ret = meth3(i+1);
        } catch (Exception e) {
//            throw new RuntimeException(e);
        }
//        return meth3(i + 1);
        return ret;
    }

    private int meth3(int i) {
        return 100 / (i - 2);
    }
}
