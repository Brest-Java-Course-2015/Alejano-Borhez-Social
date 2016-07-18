
        <div class="span3" id="friends_list">
            <ul class="dashboard-list">
                <h2> <@spring.message code = "user.friends"/>:</h2>
                <#include "/app_modules/user_cell.ftl"/>
                <h2> <@spring.message code="friends.total"/>: ${dto.totalUsers} </h2>
            </ul>
        </div>






