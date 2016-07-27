<#ftl output_format="HTML">

<!doctype html>

<#include "build_modules/head.ftl"/>

<style type="text/css">
    body { background: url(<@spring.url "/img/bg-login.jpg"/>) !important; }
</style>

<body>
<div class="container-fluid-full">
    <div class="row-fluid">
        <div class="login-box">
        <div class="row-fluid">
                <h1>Congratulations! You created an account in our system.</h1>
        </div>

        <div class="row-fluid">
                <h2>Check your email box ${email!"INVALID@MAIL"} for approving your account during next 24 hours</h2>
        </div>

        <div class="row-fluid">
                <h2> You will be redirected in <span id="timeLeft">10</span> seconds </h2>
        </div>
        </div>


    </div>
</div>
</div>
<script type="text/javascript" src="<@spring.url "/resources/js/redirection.js"/>"></script>

</body>
<#include "build_modules/footer.ftl"/>
</html>
