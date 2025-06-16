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

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();

        Object username = session.getAttribute("username");

        Integer step = (Integer) session.getAttribute("step");
        String answer = req.getParameter("answer");

        questions = Data.getQuestions(username);

        if (answer != null && questions.get(step) != null) {
            Integer nextStep = questions.get(step).getOptions().get(answer);
            if (nextStep != null) step = nextStep;
        }

        if ("Відчинити".equals(answer) && step == 13) {
            Boolean hasKey = (Boolean) session.getAttribute("hasKey");
            if (hasKey == null || !hasKey) {
                session.setAttribute("step", 8);
                res.sendRedirect("game.jsp");
                return;
            } else {
                session.setAttribute("step", 7);
                res.sendRedirect("game.jsp");
                return;
            }
        }

        if (step == 10) {
            session.setAttribute("hasKey", true);
        }
        session.setAttribute("step", step);

        res.sendRedirect("game.jsp");
    }
}
