<#list dto.users as user>
<div class="row-fluid id="friend_cell_${user.userId}">
    <div class="span2" ontablet="span6" ondesktop="span3">
        <!-- Friend's avatar -->
        <img class="grayscale" src="${(user.images[0].url)!"nourl"}"></img>
    </div>
        <!-- Friends's credentials -->
    <div class="span3">
        <strong>Name:</strong> <a href="user?id=${user.userId}">${user.firstName} ${user.lastName}</a><br>
        <strong>Since:</strong> ${user.createdDate?string('dd.MMMM')} <br>
    </div>
</div>
<#else>
У вас пока нет друзей
</#list>

