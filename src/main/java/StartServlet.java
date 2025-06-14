import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/start")
public class StartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String username = req.getParameter("username");

        if (username != null && session.getAttribute("step") == null || ((Integer) session.getAttribute("step") > 1)) {
            session.setAttribute("step", 1);
            session.setAttribute("username", username);
            session.setAttribute("hasKey", false);
        }

        res.sendRedirect("game.jsp");
    }

}
