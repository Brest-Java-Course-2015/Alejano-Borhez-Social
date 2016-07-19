<#switch mapping>
    <#case "users">
    <button type="button" class="btn btn-primary btn-block align-center" onclick="deleteUser(${user.userId})"><@spring.message code="user.delete"/></button>
    <button type="button" class="btn btn-default btn-block" onclick="gotoUser(${user.userId})"><@spring.message code="user.change"/></button>
    <#break>
    <#case "usertab">
        <button type="button" class="btn btn-primary btn-block align-center" onclick="deleteFriend(${user.userId})"><@spring.message code="friend.delete"/></button>
        <button type="button" class="btn btn-default btn-block" onclick="gotoUser(${user.userId})"><@spring.message code="user.get"/></button>
    <#break>
    <#case "nofriends">
        <button type="button" class="btn btn-primary btn-block align-center" onclick="addFriend(${user.userId})"><@spring.message code="friend.add"/></button>
        <button type="button" class="btn btn-default btn-block" onclick="gotoUser(${user.userId})"><@spring.message code="user.get"/></button>
    <#break>
    <#case "friends">
        <button type="button" class="btn btn-primary btn-block align-center" onclick="deleteFriend(${user.userId})"><@spring.message code="friend.delete"/></button>
        <button type="button" class="btn btn-default btn-block" onclick="gotoUser(${user.userId})"><@spring.message code="user.get"/></button>
    <#break>


</#switch>