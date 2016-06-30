<#ftl output_format="HTML">

<!doctype html>

<#include "/header.ftl"/>

<body>

<h1> <@spring.message code="user.friends"/> ${dto.user.firstName} ${dto.user.lastName} </h1>

    <#include "/breadcrumbs.ftl"/>


    <#include "/table.ftl"/>

    <#include "/adduserbutton.ftl"/>


</body>

<#include "/footer.ftl"/>

    <script type="text/javascript" src="<@spring.url "/resources/js/websocket.js"/>"></script>


</html>