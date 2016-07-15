<#list dto.users as user>
<li>
    <a href="photo?id=${user.userId}">
        <img class="avatar" alt="${user.firstName} ${user.lastName}" src="${(user.images[0].url)!"nourl"}">
    </a>
    <strong>Name:</strong> <a href="user?id=${user.userId}">${user.firstName} ${user.lastName}</a><br>
    <strong>Since:</strong> ${user.createdDate?string('dd.MMMM')} <br>
    <strong>Friends:</strong> ${user.totalFriends} <br>
</li>
<#else>
<li>
    <strong> No users yet </strong>
</li>
</#list>