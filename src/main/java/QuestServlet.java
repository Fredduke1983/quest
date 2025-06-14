import model.Data;
import model.Question;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/game")
public class QuestServlet extends HttpServlet {
    private Map<Integer, Question> questions;

    @Override
    public void init() {
        questions = Data.getQuestions();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();

        Integer step = (Integer) session.getAttribute("step");
        String answer = req.getParameter("answer");

        if (answer != null && questions.get(step) != null) {
            Integer nextStep = questions.get(step).getOptions().get(answer);
            if (nextStep != null) step = nextStep;
        }
        session.setAttribute("step", step);

        res.sendRedirect("game.jsp");
    }
}
