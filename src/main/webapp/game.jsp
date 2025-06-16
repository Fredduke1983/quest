<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.*, javax.servlet.*" %>
<%@ page import="model.Question, model.Data" %>
<%@ page import="java.util.Map" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Квест — Крок</title>
</head>
<body>
<%
    Integer step = (Integer) session.getAttribute("step");
    if (step == null) step = 1;
    String backgroundUrl = "images/room" + step + ".jpg";
%>
<div id="game-container" style="background-image: url('<%= backgroundUrl %>');">
    <%
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("index.jsp");
            return;
        }
        Map<Integer, Question> questions = Data.getQuestions(session.getAttribute("username"));
        Question current = questions.get(step);
    %>

    <div class="user-info">
        <span>Інфо, <%= session.getAttribute("username") != null ? session.getAttribute("username") : "Гравець" %>:</span>
        <p>
            <span>🗝️</span>:
            <%
                Boolean hasKey = (Boolean) session.getAttribute("hasKey");
                if (hasKey != null && hasKey) {
            %>
            <span>1</span>
            <%
            } else {
            %>
            <span>0</span>
            <%
                }
            %>
        </p>
    </div>

    <div class="quest">
        <div class="text-container">
            <p class="game-text"><%= current.getText() %>
            </p>
        </div>

        <% if (!current.getOptions().isEmpty()) { %>
        <form action="game" method="post">
            <% for (Map.Entry<String, Integer> entry : current.getOptions().entrySet()) { %>
            <button type="submit" name="answer" value="<%= entry.getKey() %>">
                <%= entry.getKey() %>
            </button>
            <br/>
            <% } %>
        </form>
        <% } else { %>
        <div class="end-text">
            <p>Кінець гри!</p>
        </div>
        <p><a href="/">Почати заново</a></p>
        <% } %>
    </div>
</div>
</body>
</html>
