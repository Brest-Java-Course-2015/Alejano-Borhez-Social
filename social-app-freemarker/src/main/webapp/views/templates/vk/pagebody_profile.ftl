<div id="page_body" class="fl_r" style="width: 631px;">
    <div id="header_wrap2">
        <div id="header_wrap1">
            <div id="header" style="">
                <h1 id="title">${dto.user.firstName} ${dto.user.lastName}</h1>
            </div>
        </div>
    </div>

    <div id="wrap_between"></div>
    <div id="wrap3">
        <div id="wrap2">
            <div id="wrap1">
                <div id="content">
                    <div id="profile">
                        <div class="narrow_column fl_l" id="profile_narrow">
                            <div id="owner_photo_wrap">
                                <div id="owner_photo_top_bubble_wrap">
                                    <div id="owner_photo_top_bubble">
                                        <div class="owner_photo_bubble_delete_wrap" onclick="deletePhoto(${dto.user.userId}, ${(dto.user.images[0].imageId)!"0"})">
                                            <div class="owner_photo_bubble_delete"></div>
                                    </div>
                                </div>
                            </div>
                            <div id="page_avatar">
                                <a id="profile_photo_link">
                                    <script>
                                        $.cloudinary.config({ cloud_name: 'simple-social', api_key: '543582919166178'});
                                        $("#profile_photo_link").append($.cloudinary.image('${(dto.user.images[0].url)!"url"}', { width: 200, crop: 'fill' }));
                                    </script>
                                </a>
                            </div>

                            <div id="owner_photo_bubble_wrap">
                                <div id="owner_photo_bubble"><div class="owner_photo_bubble_action owner_photo_bubble_action_update" onclick="uploadPhoto">
                              <span class="owner_photo_bubble_action_in">Загрузить новую фотографию</span>
                            </div><div class="owner_photo_bubble_action owner_photo_bubble_action_crop" onclick="Page.ownerCrop()">
                              <span class="owner_photo_bubble_action_in">Изменить миниатюру</span>
                            </div></div>
                              </div>
                              </div>

                        <div id="profile_actions">
                            <a id="profile_edit_act" href="user?id=${dto.user.userId}">Редактировать страницу</a>
                        </div>

                        <div class="profile_top_sep"></div>

                        <div id="profile_counts" class="counts_module">
                            <div>
                                <a class="photos" href="photo?id=${dto.user.userId}">
                                    <span class="fl_r thumb"></span>
                                    <span class="fl_r">${dto.totalUsers}</span>
                                    Фотографии со мной</a>
                            </div>

                            <div>
                                <a class="videos" href="video?id=${dto.user.userId}">
                                    <span class="fl_r thumb"></span>
                                    <span class="fl_r">${dto.totalUsers}</span>
                                    Видеозаписи со мной</a>
                            </div>

                        </div>

                            <div class="rate_empty_line"></div>

                            <div class="module clear people_module" id="profile_friends">
                                <a href="friends?id=${dto.user.userId}" class="module_header">
                                    <div class="header_top clear_fix">
                                        Друзья
                                    </div>
                                    <div class="p_header_bottom">
                                        <span class="fl_r"></span>
                                        ${dto.totalUsers} друзей
                                    </div>
                                </a>

                        <div class="module_body clear_fix">

                          <#include "friendslist.ftl"/>


                        </div>
                    </div>
                </div>
                    </div>
                        <div class="wide_column fl_r" id="profile_wide">
                            <div id="profile_info">
                        <h4 class="simple page_top clear_fix ta_r">
                            <div class="page_name fl_l ta_l" dir="auto">${dto.user.firstName} ${dto.user.login} ${dto.user.lastName}</div>
                        </h4>

                        <div id="profile_short">
                            <div class="profile_info">
                            <div class="clear_fix ">
                                <div class="label fl_l">День рождения:</div>
                                <div class="labeled fl_l">${dto.user.createdDate?string('dd MMMM')}</div>
                            </div>
                            <div class="clear_fix miniblock"></div>
                            </div>

                            <div class="profile_info"><div class="clear_fix ">
                                <div class="label fl_l">Логин:</div>
                                <div class="labeled fl_l"><a onclick="changeLogin()">${dto.user.login}</a></div>
                            </div><div class="clear_fix miniblock">
                            </div></div>

                            <div class="profile_info"><div class="clear_fix ">
                                <div class="label fl_l">Имя:</div>
                                <div class="labeled fl_l"><a onclick="changeFirstName()">${dto.user.firstName}</a></div>
                            </div><div class="clear_fix miniblock">
                            </div></div>

                            <div class="profile_info"><div class="clear_fix ">
                                <div class="label fl_l">Фамилия:</div>
                                <div class="labeled fl_l"><a onclick="changeLastName()">${dto.user.lastName}</a></div>
                            </div><div class="clear_fix miniblock">
                            </div></div>
                        </div>
                    </div>
                              <div class="module clear photos_module" id="profile_photos_module">
                                <a href="photo?id=${dto.user.userId}" class="module_header">
                                    <div class="header_top clear_fix">
                                        ${dto.user.images?size} фотографий
                                    </div>
                                </a>

                                <div id="profile_photos" class="clear_fix">
                                    <div class="page_post_sized_thumbs clear_fix profile_sized_photos" style="width: 397px; height: 81px;">
                                        <#include "photo_grid.ftl"/>
                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>
                <br class="clear">


                </div>

            </div>
        </div>
     </div>
    </div>