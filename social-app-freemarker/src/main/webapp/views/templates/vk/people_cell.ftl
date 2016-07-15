<div class="fl_l people_cell">
            <a class="ava" href="user?id=${user.userId}" id="user_${user.userId}">
                <script>
                    $.cloudinary.config({ cloud_name: 'simple-social', api_key: '543582919166178'});
                    $("#user_${user.userId}").append($.cloudinary.image('${(user.images[0].url50)!"url"}'));
                </script>

            </a>
            <div class="name_field">
                <a href="user?id=${user.userId}">
                    ${user.firstName}<br>
                    <small>${user.lastName}</small>
                </a>
            </div>
</div>