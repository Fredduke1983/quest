<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Text Quest</title>
</head>
<body>
<div id="game-container" style="background-image: url('images/Intro.png')">
    <form id="intro" action="start" method="post">
            <label for="username">Введіть своє ім’я:</label>
            <input type="text" id="username" name="username" required>
        <button type="submit">Почати гру</button>
    </form>
</div>
</body>
</html>
