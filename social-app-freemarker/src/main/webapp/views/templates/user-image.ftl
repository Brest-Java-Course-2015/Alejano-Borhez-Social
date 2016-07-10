<#ftl output_format="HTML">

<!doctype html>

<#include "/header.ftl"/>

<body>

<h1> Uploaded file </h1>

    <h2> <@spring.message code="user.user" /> </h2>

    <img class="img-responsive" src="${imageURL}">

</body>

<#include "/footer.ftl"/>

</html>