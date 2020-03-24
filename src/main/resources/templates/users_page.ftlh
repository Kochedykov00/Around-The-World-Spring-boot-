<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<div>
    <table>
        <tr>
            <th>Имя</th>
            <th>email</th>
        </tr>
        <#list users as user>
            <tr>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td><a href="/users/${user.id}">Посмотреть</a></td>
            </tr>
        </#list>
    </table>




    <p><label for="name"></label><input id="name" oninput="f()"/></p>

    <div id="res"></div>

    <script type="application/javascript">

        function f() {
            if ($("#name").val().length >= 1) {
                $.ajax({
                    url: "/users/search",
                    data: {"name": $("#name").val()},
                    dataType: "json",
                    success: function (name) {

                        if (name.length > 0) {

                            $("#res").html("");
                            $("#res").append("<h3>Найдено " + name.length + " пользователя(ей)</h3>");
                            for (var i = 0; i < name.length; i++) {
                                $("#res").append("<h3>" + name[i].name + "</h3>");
                            }
                        } else {
                            $("#res").html("Пользователи не найдены");
                        }
                    }
                })
            }
            else {
                $("#res").html(" ");
            }
        }
    </script>



</div>
</body>
</html>
