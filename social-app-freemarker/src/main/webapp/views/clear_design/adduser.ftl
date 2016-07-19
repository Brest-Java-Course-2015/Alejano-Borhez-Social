<#ftl output_format="HTML">

<!doctype html>

<#include "build_modules/head.ftl"/>

<body>


<div class="container-fluid-full">
    <div class="row-fluid">
            <#include "build_modules/header.ftl"/>
    </div>

    <div class="row-fluid" style="padding-top: 44px; padding-bottom: 44px;" >

    <#include "build_modules/menu.ftl"/>

    <div id="content" class="span6">

        <h1> <@spring.message code="user.create"/> </h1>

        <div class = "row-fluid">

        <form class="form" name="user" id="userForm" role="form" method="post" action="addusersubmit">
             <div class="form-group">
                 <label>Login:</label>
                 <input type="text" id="login" name="login" required="true" class="form-control">
             </div>
             <div class="form-group">
                 <label>Password:</label>
                 <input type="password" id="password" name="password" required="true" class="form-control">
             </div>
             <div class="form-group">
                 <label>FirstName:</label>
                 <input type="text" id="firstName" name="firstName" required="true" class="form-control">
             </div>
             <div class="form-group">
                 <label>LastName:</label>
                 <input type="text" id="lastName" name="lastName" required="true" class="form-control">
             </div>
             <div class="form-group">
                 <label>Age:</label>
                 <input type="number" id="age" name="age" required="true" class="form-control">
             </div>

             <button type="submit" class="btn btn-default"> Add user </button>

         </form>

        </div>
    </div>
</div>

    </div>


</body>

<#include "build_modules/footer.ftl"/>








