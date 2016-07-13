<#ftl output_format="HTML">

<!doctype html>

<#include "/header.ftl"/>

<body>

<h1> <@spring.message code="user.friends"/> ${dto.user.firstName} ${dto.user.lastName} </h1>

    <#include "/breadcrumbs.ftl"/>


    <#include "/table.ftl"/>

    <#include "/addfriendbutton.ftl"/>


</body>

<#include "/footer.ftl"/>



</html>