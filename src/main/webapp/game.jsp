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
    String backgroundUrl = "images/room" + step + ".png";
%>
<div id="game-container" style="background-image: url('<%= backgroundUrl %>');">
<%
    if (session == null || session.getAttribute("username") == null) {
        response.sendRedirect("index.jsp");
        return;
    }


    Map<Integer, Question> questions = Data.getQuestions();
    Question current = questions.get(step);
%>

<h2>Привіт, <%= session.getAttribute("username") %>!</h2>
<p><%= current.getText() %>
</p>

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
<p><strong>Кінець гри!</strong></p>
<p><a href="/">Почати заново</a></p>
<% } %>
</div>
</body>
</html>
