<#ftl output_format="HTML">

<!doctype html>

<#include "build_modules/head.ftl"/>

<body>


<div class="container-fluid-full">
    <div class="row-fluid">
            <#include "build_modules/header.ftl"/>
    </div>

    <div class="row-fluid" style="padding-top: 44px">
            <#include "build_modules/menu.ftl"/>
<!-- start: Content -->
    <div id="content" class="span6">
            <h1> <@spring.message code="users.all"/>: </h1>
        <div class="row-fluid sortable">

        <div class="span3" id="friends_list">
            <ul class="dashboard-list">
                <#include "/app_modules/user_cell.ftl"/>
                <h2> <@spring.message code="users.total"/>: ${dto.totalUsers} </h2>
            </ul>

            <button type="button" class="btn btn-default" onclick="gotoadduser()"> <@spring.message code="user.create"/> </button>

        </div>

        </div>
    </div>

<!-- end: Content -->
    </div>
    </div>


</div>


</body>

<#include "build_modules/footer.ftl"/>



</html>