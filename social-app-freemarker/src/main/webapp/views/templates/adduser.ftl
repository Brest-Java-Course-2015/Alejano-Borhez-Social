<#ftl output_format="HTML">

<!doctype html>

<#include "/header.ftl"/>

<body>

<h1><@spring.message code="user.create"/></h1>

<form id="userForm">
    <div class="mainArea">

        <label>Login:</label><br>
        <input type="text" id="login" name="login" required>
        <br>
        <label>Password:</label><br>
        <input type="password" id="password" name="password" required>
        <br>
        <label>FirstName:</label><br>
        <input type="text" id="firstName" name="firstName" required>
        <br>
        <label>LastName:</label><br>
        <input type="text" id="lastName" name="lastName" required>
        <br>
        <label>Age:</label><br>
        <input type="number" id="age" name="age" required>
        <br>
        <#include "/adduserbutton.ftl"/>

    </div>
</form>


</body>

<#include "/footer.ftl"/>

</html>








