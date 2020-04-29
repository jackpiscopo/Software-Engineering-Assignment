package um;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class JenkinsTestFunctionsTests {

    @Test
    public void timesTwoReturnsCorrectAnswerForOne() {
        JenkinsTestFunctions func = new JenkinsTestFunctions();
        assertEquals(2, func.timesTwo(1));
    }

    @Test
    public void timesTwoReturnsCorrectAnswerForTwo() {
        JenkinsTestFunctions func = new JenkinsTestFunctions();
        assertEquals(4, func.timesTwo(2));
    }

    @Test
    public void timesThreeReturnsCorrectAnswerForOne() {
        JenkinsTestFunctions func = new JenkinsTestFunctions();
        assertEquals(3, func.timesThree(1));
    }

    @Test
    public void timesThreeReturnsCorrectAnswerForTwo() {
        JenkinsTestFunctions func = new JenkinsTestFunctions();
        assertEquals(6, func.timesThree(2));
    }

    @Test
    public void timesFourReturnsCorrectAnswerForOne() {
        JenkinsTestFunctions func = new JenkinsTestFunctions();
        assertEquals(4, func.timesFour(1));
    }

    @Test
    public void timesFourReturnsCorrectAnswerForTwo() {
        JenkinsTestFunctions func = new JenkinsTestFunctions();
        assertEquals(8, func.timesFour(2));
    }

    @Test
    public void timesFiveReturnsCorrectAnswerForOne() {
        JenkinsTestFunctions func = new JenkinsTestFunctions();
        assertEquals(5, func.timesFive(1));
    }

    @Test
    public void timesFiveReturnsCorrectAnswerForTwo() {
        JenkinsTestFunctions func = new JenkinsTestFunctions();
        assertEquals(10, func.timesFive(2));
    }

    @Test
    public void timesSixReturnsCorrectAnswerForOne() {
        JenkinsTestFunctions func = new JenkinsTestFunctions();
        assertEquals(6, func.timesSix(1));
    }

    @Test
    public void timesSixReturnsCorrectAnswerForTwo() {
        JenkinsTestFunctions func = new JenkinsTestFunctions();
        assertEquals(12, func.timesSix(2));
    }

    @Test
    public void timesSevenReturnsCorrectAnswerForOne() {
        JenkinsTestFunctions func = new JenkinsTestFunctions();
        assertEquals(7, func.timesSeven(1));
    }

    @Test
    public void timesSevenReturnsCorrectAnswerForTwo() {
        JenkinsTestFunctions func = new JenkinsTestFunctions();
        assertEquals(14, func.timesSeven(2));
    }
}
