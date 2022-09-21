import com.aquaq.training.StringEvaluation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringEvaluationTest {
    
    @Test
    public void cleanStringTest()
    {
        String testString = "This is a Test?";
        assertEquals(StringEvaluation.cleanString(testString),"thisisatest");
    }

    @Test
    public void reverseTest()
    {
        String testString = "Test this in reverse";
        assertEquals(StringEvaluation.reverseString(testString),"esrever ni siht tseT");
    }

    @Test
    public void isPalindromeTrueTest()
    {
        String testString = "racecar";
        assertTrue(StringEvaluation.isPalindrome(testString));
    }

    @Test
    public void isPalindromeFalseTest()
    {
        String testString = "test string";
        assertFalse(StringEvaluation.isPalindrome(testString));
    }

    @Test
    public void countCharTest()
    {
        String testString = "This is a test string";
        char testChar = 't';
        assertEquals(StringEvaluation.countChar(testString,testChar),4);
    }

    @Test
    public void maxCharTest()
    {
        String testString = "This is a test string";
        assertEquals(StringEvaluation.maxChar(testString),'t');
    }

    @Test
    public void getSortedLetters()
    {
        String testString = "Test";
        assertEquals(StringEvaluation.getSortedLetters(testString),"estt");
    }

    @Test
    public void isAnagramTrue()
    {
        String testString1 = "inch";
        String testString2 = "chin";

        assertTrue(StringEvaluation.isAnagram(testString1,testString2));
    }

    @Test
    public void isAnagramFalse()
    {
        String testString1 = "inch";
        String testString2 = "centimetre";

        assertFalse(StringEvaluation.isAnagram(testString1,testString2));
    }


    
}
