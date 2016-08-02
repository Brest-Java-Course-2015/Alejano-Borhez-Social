<#ftl output_format="HTML">

<!doctype html>

<#include "build_modules/head.ftl"/>
<body>
<#if dto??>


<div class="container-fluid-full">
    <div class="row-fluid">
            <#include "build_modules/header.ftl"/>
    </div>

    <div class="row-fluid" style="padding-top: 44px; padding-bottom: 44px;" >
            <#include "build_modules/menu.ftl"/>
<!-- start: Content -->
    <div id="content" class="span6">
            <h1>Страница пользователя <small> ${(dto.user.firstName)!""} ${(dto.user.lastName)!""} </small></h1>
        <div class = "row-fluid well" style="padding-right:5px;">
            <div class="span2" ontablet="span6" ondesktop="span3">
                    <!-- User's avatar -->
                    <img class="grayscale" src="${(dto.user.images[0].url)!"#"}"></img>
            </div>
                    <!-- User's credentials -->
            <div class="span3">
                    <strong>Name:</strong> <a href="#" title="<@spring.message code="user.change"/>" onclick="changeFirstName()">${(dto.user.firstName)!"#"}</a> <a href="#" title="<@spring.message code="user.change"/>" onclick="changeLastName()">${(dto.user.lastName)!"#"}</a><br>
                    <strong>Since:</strong> ${(dto.user.createdDate?string('dd.MMMM'))!""} <br>
            </div>

        </div>

        <div class="row-fluid sortable">

            <#include "build_modules/content.ftl"/>

            <div class="span6 well" id="user_gallery">
                        <ul class="dashboard-list">
                            <h2> Галерея пользователя: <a href="photo" title="Добавить фотографии"> <i class="icon-plus"></i></a> </h2>


                                <#list dto.user.images as image>
                                        <div id="image-${image.imageId}" class="masonry-thumb">
                                            <a title="Click to delete" href="#" onclick="deleteImage(${dto.user.userId}, ${image.imageId})">
                                                <img class="grayscale" src="${image.url}" alt="Image ${image.imageId}">
                                            </a>
                                        </div>
                                    <#else>
                                        <div>
                                        Gallery is Empty
                                        </div>

                                </#list>
                            <h2> Всего фото: ${(dto.user.images?size)!0} </h2>
                        </ul>
            </div>
        </div>
    </div>

<!-- end: Content -->
    </div>


</div>


<#else>
<div>
 Sorry, your
</div>

</#if>



</body>

<#include "build_modules/footer.ftl"/>

</html>