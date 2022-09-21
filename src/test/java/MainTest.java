import com.aquaq.training.Main;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    public void getAnswerTest(){
        String input = "test";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(Main.getAnswer("Enter answer"),input);
    }

    private static ByteArrayOutputStream out;
    private static final PrintStream originalOut = System.out;
    private static final InputStream originalIn = System.in;


    @BeforeAll
    public static void setStreams() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterAll
    public static void restoreOriginalStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void printMenuTest()
    {
        Main.printMenu();
        assertTrue(out.toString().endsWith("\nProblem Menu:\n" +
                "1: Find the max occurring char in String\n" +
                "2: Check 2 String are anagrams of each other\n" +
                "3: Reverse entered String\n" +
                "4: Check if String is a palindrome\n" +
                "5: Exit\n"));
    }

    @Test
    public void question1Test(){
        Main.question1("test");
        assertTrue(out.toString().endsWith("Result: t\n"));
    }

    @Test
    public void question2Test(){
        Main.question2("test","tset");
        assertTrue(out.toString().endsWith("test and tset are anagrams\n"));
    }

    @Test
    public void question3Test(){
        Main.question3("test");
        assertTrue(out.toString().endsWith("Result: tset\n"));
    }

    @Test
    public void question4Test(){
        Main.question4("test");
        assertTrue(out.toString().endsWith("test is not a Palindrome\n"));
    }

    @Test
    public void mainQuitTest(){
        String input = "5";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Main.main(new String[0]);
        assertTrue(out.toString().endsWith("Exiting game.\n"));
    }
    @Test
    public void mainLoopTest(){
        String input = "A\n5";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Main.main(new String[0]);
        assertTrue(out.toString().endsWith("This is not a valid option, please try again\n" +
                "\n" +
                "Problem Menu:\n" +
                "1: Find the max occurring char in String\n" +
                "2: Check 2 String are anagrams of each other\n" +
                "3: Reverse entered String\n" +
                "4: Check if String is a palindrome\n" +
                "5: Exit\n" +
                "Exiting game.\n"));
    }
}
