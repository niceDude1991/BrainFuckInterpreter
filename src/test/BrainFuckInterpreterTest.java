

import interpreter.BrainFuckInterpreter;
import interpreter.Interpreter;
import junit.framework.TestCase;
import org.junit.Test;


public class BrainFuckInterpreterTest {

    private Interpreter brainFuck = new BrainFuckInterpreter();
    @Test
    public void printAlphabet() {
        String testCase = "++++++[>++++++++++>++++<<-]>+++++>++[-<.+>]";
        TestCase.assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",  brainFuck.execute(testCase));
    }
    @Test
    public void printHello() {
        String testCase = "+++++++++++++++++++++++++++++++++++++++++++++\n" +
                " +++++++++++++++++++++++++++.+++++++++++++++++\n" +
                " ++++++++++++.+++++++..+++.-------------------\n" +
                " ---------------------------------------------\n" +
                " ---------------.+++++++++++++++++++++++++++++\n" +
                " ++++++++++++++++++++++++++.++++++++++++++++++\n" +
                " ++++++.+++.------.--------.------------------\n" +
                " ---------------------------------------------\n" +
                " ----.-----------------------";
        TestCase.assertEquals("Hello World!", brainFuck.execute(testCase));
    }
    @Test
    public void printHelloWithLoop() {
        String testCase = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++\n" +
                " .>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.\n" +
                " ------.--------.>+.>";
        TestCase.assertEquals("Hello World!", brainFuck.execute(testCase));
    }



}