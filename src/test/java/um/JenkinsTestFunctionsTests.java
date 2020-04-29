package um;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class JenkinsTestFunctionsTests {

    @Test
    public void timesTwoReturnsCorrectAnswer() {
        JenkinsTestFunctions func = new JenkinsTestFunctions();
        assertEquals(2, func.timesTwo(1));
    }

    @Test
    public void timesThreeReturnsCorrectAnswer() {
        JenkinsTestFunctions func = new JenkinsTestFunctions();
        assertEquals(3, func.timesThree(1));
    }

    @Test
    public void timesFourReturnsCorrectAnswer() {
        JenkinsTestFunctions func = new JenkinsTestFunctions();
        assertEquals(4, func.timesFour(1));
    }
}
