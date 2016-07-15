<#ftl output_format="HTML">

<!doctype html>

<#include "/header.ftl"/>

<body>

    <div class="container-fluid">

        <h1> <@spring.message code="users.list"/> </h1>

            <div class="row"/>
                <div class="col-xs-2">
                    <ul>
                        <li> <@spring.message code="users.all"/> </li>
                        <li> Все фотографии </li>
                    </ul>
                </div>

                <div class="col-xs-3">
                    <#include "/datepicker.ftl"/>
                    <#include "/table.ftl"/>
                    <#include "/gotoadduserbutton.ftl"/>
                </div>

                <div class="col-xs-7">

                </div>

            </div>

    </div>
</body>

<#include "/footer.ftl"/>



</html>