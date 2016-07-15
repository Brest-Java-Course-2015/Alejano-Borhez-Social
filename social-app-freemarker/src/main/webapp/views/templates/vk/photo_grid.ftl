<#if dto.user.images?size gt 0>
<#assign imageSize = dto.user.images?size>

    <#if dto.user.images?size gt 4>
        <#assign imageSize = 4>
    </#if>
<#list dto.user.images[0..(imageSize-1)] as image>
    <a href="photo?id=${dto.user.userId}" class="page_post_thumb_wrap  page_post_thumb_last_row fl_l" id="image_${image.imageId}" style="max-height: 80px">
        <script>
            $.cloudinary.config({ cloud_name: 'simple-social', api_key: '543582919166178'});
            $("#image_${image.imageId}").append($.cloudinary.image('${(image.url81)!"url"}'));
        </script>

    </a>
</#list>

</#if>