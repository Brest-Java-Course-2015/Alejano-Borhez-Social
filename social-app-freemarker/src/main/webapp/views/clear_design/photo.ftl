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
            <h1> Gallery of a user: ${dto.user.firstName} ${dto.user.lastName} </h1>

            <#include "app_modules/gallery.ftl"/>
    </div>

<!-- end: Content -->
    </div>
    </div>


</div>


</body>

<#include "build_modules/footer.ftl"/>



</html>