<#include "base.ftlh"/>
<#macro content>

    <head>
        <title>Sign in</title>
    </head>



    <br /><br />
    <div class="mt-7">
        <h1 class="mb-lg-5"><img src="/photo/key_icon.png">&nbsp;&nbsp;Sign In</h1>
    </div>
    <br />
    <form  method="post">
        <div class="container">
            <div class="row" id="inputInformation">
                <div class="col-2">
                    <label for="email">Email</label>
                    <br /><br /><br />
                    <label for="password">Password</label>
                </div>
                <div class="col-6">
                    <input class="form-control" type="text" name="email" id="email" size="50%" placeholder="email"/>

                    <br /><br />
                    <input class="form-control" type="password" name="password" id="password" size="50%" placeholder="password"/>

                </div>
            </div>
        </div>
        <br /><br />
        <div class="container">
            <div class="row">
                <div class="col-6" align="right">
                    <input type="checkbox" name="rememberMe">rememberMe</input>
                    <a class="btn btn-primary border-black mx-4 btn-lg px-15 mt-4"
                       style="background-color: rgba(59,72,148,0.91)"
                       href="/signUp" role="button">&nbsp;&nbsp;&nbsp;Sign up&nbsp;&nbsp;&nbsp;</a>
                </div>
                <form action="/signIn" method="post">
                <div class="col-5" align="left">
                    <input type="submit" id="submit" name = "submit" value="sign in" class="btn btn-primary border-black mx-4 btn-lg px-15 mt-4" style="background-color: rgba(58,49,148,0.91)"></input>
                </div>
            </div>
        </div>
    </form>

    <script src="C:\BitBucket\Abramsky\web\Frontend\js\bootstrap.min.js"></script>
    <script src="C:\BitBucket\Abramsky\web\Frontend\js\jquery-3.4.1.min.js"></script>
    <script src="C:\BitBucket\Abramsky\web\Frontend\js\bootstrap.bundle.js"></script>
    <script src="C:\BitBucket\Abramsky\web\Frontend\js\myJs.js"></script>

</body>

</html>
</#macro>

<@display_page />






