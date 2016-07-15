<#if dto.users?? && dto.users?size gt 0>
<#assign size = dto.users?size>
    <#if size gt 0 && size lt 4 >
    <div class="people_row">
       <#list dto.users[0..(size-1)] as user>
        <#include "people_cell.ftl"/>
       </#list>
    </div>
    <#elseif size gt 3 && size lt 7 >
    <div class="people_row">
       <#list dto.users[0..2] as user>
        <#include "people_cell.ftl"/>
       </#list>
       <#list dto.users[3..(size-1)] as user>
           <#include "people_cell.ftl"/>
       </#list>
    <#elseif size gt 6 >
       <#list dto.users[0..2] as user>
       <#include "people_cell.ftl"/>
      </#list>
      <#list dto.users[3..5] as user>
          <#include "people_cell.ftl"/>
      </#list>

    </#if>
  </div>
<#else>
У вас пока нет друзей
</#if>