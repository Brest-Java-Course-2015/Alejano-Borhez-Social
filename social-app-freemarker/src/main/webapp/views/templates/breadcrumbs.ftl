<div id="breadcrumbs">
    <span id="bc_header">
        <a href="users">
            <@spring.message code="users.list"/>
        </a>
        >>
    </span>
    <span id="bc_username_href">
            <a href ="user?id=${dto.user.userId}">
                ${dto.user.lastName}, ${dto.user.firstName}
            </a>
    </span>
    <span id="bc_delimiter">
        >>
    </span>
    <span id="bc_subheader">
        <#switch mapping>
            <#case "friends">
                <@spring.message code="user.friends"/>
            <#break>
            <#case "usertab">
                <@spring.message code="user.get"/>
            <#break>
            <#case "nofriends">
                <@spring.message code="user.addfriends"/>
            <#break>

        </#switch>

    </span>
    <span id="bc_username">
        ${dto.user.firstName} ${dto.user.lastName}
    </span>
</div>