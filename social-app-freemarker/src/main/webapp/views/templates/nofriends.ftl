<#ftl output_format="HTML">

<!doctype html>

<#include "/header.ftl"/>

<body>

<h1> <@spring.message code="user.addfriends"/> ${dto.user.firstName?cap_first} ${dto.user.lastName?cap_first}</h1>

   <!-- <h2> <@spring.message code="user.user" /> </h2> -->

    <#include "/breadcrumbs.ftl"/>

   <!-- <h2> <@spring.message code="user.friends" /> </h2> -->

    <#include "/table.ftl"/>

    <#include "/addfriendbutton.ftl"/>

</body>

<#include "/footer.ftl"/>

    <script type="text/javascript" src="<@spring.url "/resources/js/websocket.js"/>"></script>


</html>