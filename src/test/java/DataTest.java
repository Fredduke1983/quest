import model.Data;
import model.Question;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DataTest {

    private Map<Integer, Question> questions;

    @BeforeEach
    void init() {
        questions = Data.getQuestions("ІГОР");
    }

    @Test
    public void testQuestionsAreGenerated() {
        assertNotNull(questions);
        assertTrue(questions.containsKey(1));
        assertTrue(questions.containsKey(6));
        assertTrue(questions.containsKey(10));
    }

    @Test
    public void testKeyQuestionContainsText() {
        Question q10 = questions.get(10);
        assertTrue(q10.getText().contains("ключ"), "Там лежав якийсь старий ключ.");
    }

    @Test
    public void testInitialQuestionOptions() {
        Question q1 = questions.get(1);
        Map<String, Integer> options = q1.getOptions();

        assertEquals(2, options.size());
        assertTrue(options.containsKey("Праворуч"));
        assertEquals(2, options.get("Праворуч"));
    }
}
