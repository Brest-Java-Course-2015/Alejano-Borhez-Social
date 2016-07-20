<#ftl output_format="HTML">

<!doctype html>

<#include "build_modules/head.ftl"/>

<body>


<div class="container-fluid-full">

<h1> ${hello!"Hello"}, ${(dto.user.login)!""} </h1>

<h2> ${header!"header"}, ${uid!""} </h2>

<a href="hello"> Click here to go to Hello </a> <br>

<a href="hello2"> Click here to go to Hello2 </a>


</div>



</body>

<#include "build_modules/footer.ftl"/>



</html>