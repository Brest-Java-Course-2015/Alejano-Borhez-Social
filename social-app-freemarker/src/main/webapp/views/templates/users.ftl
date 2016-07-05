<#ftl output_format="HTML">

<!doctype html>

<#include "/header.ftl"/>

<body>

<h1> <@spring.message code="users.list"/> </h1>

    <#include "/datepicker.ftl"/>

    <#include "/table.ftl"/>

    <#include "/gotoadduserbutton.ftl"/>


</body>

<#include "/footer.ftl"/>

    <script type="text/javascript" src="<@spring.url "/resources/js/websocket.js"/>"></script>


</html>