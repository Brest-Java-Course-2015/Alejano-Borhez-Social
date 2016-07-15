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
            <h1>Страница пользователя <small> ${dto.user.firstName} ${dto.user.lastName} </small></h1>
            <div class="span3" ontablet="span6" ondesktop="span3">
                <img class="grayscale" src="${(dto.user.images[0].url)!"nourl"}"></img>
            </div>
            <#include "build_modules/content.ftl"/>
    </div>

<!-- end: Content -->
    </div>


</div>


</body>

<#include "build_modules/footer.ftl"/>



</html>