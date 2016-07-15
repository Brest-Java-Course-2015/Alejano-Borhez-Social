<div class="table-responsive">
    <table class="table-hover table-striped" style="width:80%">
        <thead>
        <tr>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Возраст</th>
            <th>Друзья</th>
            <th>Действия</th>
        </tr>
        </thead>
        <tbody id="userList">
            <#list dto.users as user>
                <tr class="bg-info">
                    <td><a href="user?id=${user.userId}">${user.firstName}</a></td>
                    <td><a href="user?id=${user.userId}">${user.lastName}</a></td>
                    <td>${user.age}</td>
                    <td><a href="friends?id=${user.userId}">${user.totalFriends}</a></td>
                    <td><#include "/actions.ftl"/></td>
                </tr>
            </#list>
        </tbody>

    </table>

</div>

<div id="userTotal">
    <h3><@spring.message code="users.total"/>: ${dto.totalUsers}</h3>
</div>