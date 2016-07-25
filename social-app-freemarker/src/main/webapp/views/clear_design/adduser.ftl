<#ftl output_format="HTML">

<!doctype html>

<#include "build_modules/head.ftl"/>

<style type="text/css">
    body { background: url(img/bg-login.jpg) !important; }
</style>

<body>
<div class="container-fluid-full">
<div class="row-fluid">
    <div class="row-fluid">
        <div class="login-box">
            <h2>Create your account</h2>
            <form class="form-horizontal" name="user" action="addusersubmit" method="post">
                <fieldset>
                    <div class="input-prepend" title="Login">
                        <span class="add-on"><i class="halflings-icon user"></i></span>
                        <input class="input-large span10" name="login" id="login" type="text" placeholder="type login" required="true"/>
                    </div>

                    <div class="clearfix"></div>

                    <div class="input-prepend" title="Password">
                        <span class="add-on"><i class="halflings-icon lock"></i></span>
                        <input class="input-large span10" name="password" id="password" type="password" placeholder="type password" required="true"/>
                    </div>

                    <div class="clearfix"></div>

                    <div class="input-prepend" title="Firstname">
                        <span class="add-on"><i class="halflings-icon user"></i></span>
                        <input class="input-large span10" name="firstName" id="firstName" type="text" placeholder="type firstname" required="true"/>
                    </div>

                    <div class="input-prepend" title="Lastname">
                        <span class="add-on"><i class="halflings-icon user"></i></span>
                        <input class="input-large span10" name="lastName" id="lastName" type="text" placeholder="type lastname" required="true"/>
                    </div>

                    <div class="input-prepend" title="Age">
                        <span class="add-on"><i class="halflings-icon user"></i></span>
                        <input class="input-large span10" name="age" id="age" type="number" required="true"/>
                    </div>

                    <div class="button-login">
                        <button type="submit" class="btn btn-primary">Create account</button>
                    </div>

                    <div class="clearfix"></div>
            </form>
            <hr>
        </div>
    </div>
</div>
</div>

</body>
<#include "build_modules/footer.ftl"/>
</html>
