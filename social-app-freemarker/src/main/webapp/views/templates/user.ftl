<#ftl output_format="HTML">

<!doctype html>

<#include "/header.ftl"/>

<body>

<h1> <@spring.message code="user.get"/> ${dto.user.firstName?cap_first} ${dto.user.lastName?cap_first}</h1>

    <h2> <@spring.message code="user.user" /> </h2>

    <#include "/breadcrumbs.ftl"/>

    <div class="row">
        <div class="col-md-4">
            <div id="user" class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Характеристика</th>
                        <th>Значение</th>
                        <th>Действия</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Логин</td>
                        <td id="login"><span>${dto.user.login}</span></td>
                        <td>
                                <button id="change_login" onclick="changeLogin()"><@spring.message code="user.change"/></button>
                        </td>
                    </tr>
                    <tr>
                    <td>Пароль</td>
                    <td id="password"><span>*******</span></td>
                    <td>
                            <button id="change_password" onclick="changePassword()"><@spring.message code="user.change"/></button>
                    </td>
                </tr>
                <tr>
                    <td>Имя</td>
                    <td id="firstname"><span>${dto.user.firstName}</span></td>
                    <td>
                            <button id="change_firstname" onclick="changeFirstName()"><@spring.message code="user.change"/></button>
                    </td>
                </tr>
                <tr>
                    <td>Фамилия</td>
                    <td id="lastname"><span>${dto.user.lastName}</span></td>
                    <td>
                            <button id="change_lastname" onclick="changeLastName()"><@spring.message code="user.change"/></button>
                    </td>
                </tr>
                <tr>
                    <td>Возраст</td>
                    <td id="age"><span>${dto.user.age}</span></td>
                    <td><span></span></td>
                </tr>
                <tr>
                    <td>Дата создания</td>
                    <td id="createdDate">${dto.user.createdDate?string('dd.MM.YYYY')}</td>
                    <td></td>
                </tr>
                <tr>
                    <td>Дата изменения</td>
                    <td id="updatedDate">${dto.user.updatedDate?string('dd.MM.YYYY')}</td>
                    <td></td>
                </tr>
                </tbody>
                </table>
            </div>
        </div>
        <div class="col-md-4">
            <img class="img-responsive" src="http://localhost:8080/images/1-1.jpg">

            <form method="POST" action="upload" enctype="multipart/form-data">
                Фото для загрузки <input type="file" name="file">
                <input type="submit" value="Upload"> Нажмите для добавления фото
            </form>

        </div>
    </div>

    <h2> <@spring.message code="user.friends" /> </h2>

    <#include "/table.ftl"/>

    <#include "/gotoadduserbutton.ftl"/>

</body>

<#include "/footer.ftl"/>

    <script type="text/javascript" src="<@spring.url "/resources/js/websocket.js"/>"></script>


</html>