<#switch mapping>
    <#case "users">
    <button onclick="deleteUser(${user.userId})"><@spring.message code="user.delete"/></button>
    <button onclick="gotoUser(${user.userId})"><@spring.message code="user.change"/></button>
    <#break>
    <#case "usertab">
        <button onclick="deleteFriend(${user.userId})"><@spring.message code="friend.delete"/></button>
        <button onclick="gotoUser(${user.userId})"><@spring.message code="user.get"/></button>
    <#break>
    <#case "nofriends">
        <button onclick="addFriend(${user.userId})"><@spring.message code="friend.add"/></button>
        <button onclick="gotoUser(${user.userId})"><@spring.message code="user.get"/></button>
    <#break>
</#switch>