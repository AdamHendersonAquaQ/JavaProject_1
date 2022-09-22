import com.aquaq.training.Main;
import com.aquaq.training.StringEvaluation;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MainTest {

    private static ByteArrayOutputStream out;
    private static final PrintStream originalOut = System.out;
    private static final InputStream originalIn = System.in;

    @BeforeEach
    public void setStreams() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    public void restoreOriginalStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void getAnswerTest(){
        String input = "test";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        assertEquals(Main.getAnswer(scanner, "Enter answer"),input);
    }

    @Test
    public void printMenuTest()
    {
        Main.printMenu();
        assertTrue(out.toString().replaceAll("\\s+","")
                .endsWith("ProblemMenu:" +
                "1:FindthemaxoccurringcharinString"+
                "2:Check2Stringareanagramsofeachother"+
                "3:ReverseenteredString"+
                "4:CheckifStringisapalindrome"+
                "5:Exit"));
    }

    @Test
    public void question1Test(){
        Main.question1("test");
        assertTrue(out.toString().replaceAll("\\s+","").endsWith("Result:t"));
    }

    @Test
    public void question2Test(){
        Main.question2("test","tset");
        assertTrue(out.toString().replaceAll("\\s+","").endsWith("testandtsetareanagrams"));
    }

    @Test
    public void question3Test(){
        Main.question3("test");
        assertTrue(out.toString().replaceAll("\\s+","").endsWith("Result:tset"));
    }

    @Test
    public void question4Test(){
        Main.question4("test");
        assertTrue(out.toString().replaceAll("\\s+","").endsWith("testisnotaPalindrome"));
    }

    @Test
    public void mainQuitTest(){
        String input = "5";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Main.main(new String[0]);
        assertTrue(out.toString().replaceAll("\\s+","").endsWith("Exitinggame."));
    }
    @Test
    public void mainLoopTest(){
        String input = "A\n5";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Main.main(new String[0]);
        assertTrue(out.toString().replaceAll("\\s+","")
                .endsWith("Thisisnotavalidoption,pleasetryagain"+
                        "ProblemMenu:"+
                        "1:FindthemaxoccurringcharinString"+
                        "2:Check2Stringareanagramsofeachother"+
                        "3:ReverseenteredString"+
                        "4:CheckifStringisapalindrome"+
                        "5:Exit"+
                        "Exitinggame."));
    }

    @Test
    public void endToEndTest(){
        String input = "1\ntest\n2\ntest\notherTest\n3\ntest\n4\ntest\n5\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        StringEvaluation mockStringEvaluation = mock(StringEvaluation.class);
        when(mockStringEvaluation.isAnagram(anyString(),anyString())).thenReturn(true);
        when(mockStringEvaluation.maxChar(anyString())).thenReturn('t');
        when(mockStringEvaluation.reverseString(anyString())).thenReturn("tset");
        when(mockStringEvaluation.isPalindrome(anyString())).thenReturn(false);

        Main.stringEvaluation=mockStringEvaluation;
        Main.main(new String[0]);
        assertTrue(out.toString().replaceAll("\\s+","")
                .endsWith("WelcometoStringExerciseMenu,pleaseselectanoption:"+
                "ProblemMenu:"+
                "1:FindthemaxoccurringcharinString"+
                "2:Check2Stringareanagramsofeachother"+
                "3:ReverseenteredString"+
                "4:CheckifStringisapalindrome"+
                "5:Exit"+
                "Enterastring"+
                "Result:t"+
                "ProblemMenu:"+
                "1:FindthemaxoccurringcharinString"+
                "2:Check2Stringareanagramsofeachother"+
                "3:ReverseenteredString"+
                "4:CheckifStringisapalindrome"+
                "5:Exit"+
                "Enterastring"+
                "Enteranotherstring"+
                "testandotherTestareanagrams"+
                "ProblemMenu:"+
                "1:FindthemaxoccurringcharinString"+
                "2:Check2Stringareanagramsofeachother"+
                "3:ReverseenteredString"+
                "4:CheckifStringisapalindrome"+
                "5:Exit"+
                "Enterastring"+
                "Result:tset"+
                "ProblemMenu:"+
                "1:FindthemaxoccurringcharinString"+
                "2:Check2Stringareanagramsofeachother"+
                "3:ReverseenteredString"+
                "4:CheckifStringisapalindrome"+
                "5:Exit"+
                "Enterastring"+
                "testisnotaPalindrome"+
                "ProblemMenu:"+
                "1:FindthemaxoccurringcharinString"+
                "2:Check2Stringareanagramsofeachother"+
                "3:ReverseenteredString"+
                "4:CheckifStringisapalindrome"+
                "5:Exit"+
                "Exitinggame."));
    }
}
