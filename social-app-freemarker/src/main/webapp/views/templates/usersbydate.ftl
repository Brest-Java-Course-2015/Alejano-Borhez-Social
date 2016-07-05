<#ftl output_format="HTML">

<!doctype html>

<#include "/header.ftl"/>

<body>

<h1>
 <a href=".">
  <@spring.message code="users.list"/>
 </a>
</h1>

    <h2> <@spring.message code = "users.bydate"/> </h2>

    <#include "/table.ftl"/>

    <#include "/gotoadduserbutton.ftl"/>

</body>

<#include "/footer.ftl"/>

<script type="text/javascript" src="<@spring.url "/resources/js/websocket.js"/>"></script>


</html>