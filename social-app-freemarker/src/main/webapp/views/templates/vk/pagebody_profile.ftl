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
                                    <img src="${(dto.user.images[0].url)!"images/Matt-Damon-as-Jason-Bourne.jpg"}">
                                </a>
                            </div>

                            <div id="owner_photo_bubble_wrap">
                                <div id="owner_photo_bubble"><div class="owner_photo_bubble_action owner_photo_bubble_action_update" onclick="uploadPhoto">
                              <span class="owner_photo_bubble_action_in">Загрузить новую фотографию</span>
                            </div><div class="owner_photo_bubble_action owner_photo_bubble_action_crop" onclick="Page.ownerCrop()">
                              <span class="owner_photo_bubble_action_in">Изменить миниатюру</span>
                            </div></div>
                              </div>

                        <div id="profile_actions">
                            <a id="profile_edit_act" href="edit">Редактировать страницу</a>
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
                          <#if dto.users??>
                          <#assign size = dto.users?size>
                            <#if size < 4 >
                            <div class="people_row">
                               <#list dto.users[0..(size-1)] as user>
                                <div class="fl_l people_cell">
                                    <a class="ava" href="user?id=${user.userId}">
                                        <img src="${(user.images[0].url)!"nourl"}" width="50" height="50">
                                    </a>
                                    <div class="name_field">
                                        <a href="user?id=${user.userId}">
                                            ${user.firstName}<br>
                                            <small>${user.lastName}</small>
                                        </a>
                                    </div>
                                </div>
                               </#list>
                            </div>
                            <#elseif size<7 >
                            <div class="people_row">
                               <#list dto.users[0..2] as user>
                                <div class="fl_l people_cell">
                                    <a class="ava" href="user?id=${user.userId}">
                                        <img src="${(user.images[0].url)!"nourl"}" width="50" height="50">
                                    </a>
                                    <div class="name_field">
                                        <a href="user?id=${user.userId}">
                                            ${user.firstName}<br>
                                            <small>${user.lastName}</small>
                                        </a>
                                    </div>
                                </div>
                               </#list>
                               <#list dto.users[3..(size-1)] as user>
                                   <div class="fl_l people_cell">
                                       <a class="ava" href="user?id=${user.userId}">
                                           <img src="${(user.images[0].url)!"nourl"}" width="50" height="50">
                                       </a>
                                       <div class="name_field">
                                           <a href="user?id=${user.userId}">
                                               ${user.firstName}<br>
                                               <small>${user.lastName}</small>
                                           </a>
                                       </div>
                                   </div>
                               </#list>
                               <#else>
                               <#list dto.users[0..2] as user>
                               <div class="fl_l people_cell">
                                   <a class="ava" href="user?id=${user.userId}">
                                       <img src="${(user.images[0].url)!"nourl"}" width="50" height="50">
                                   </a>
                                   <div class="name_field">
                                       <a href="user?id=${user.userId}">
                                           ${user.firstName}<br>
                                           <small>${user.lastName}</small>
                                       </a>
                                   </div>
                               </div>
                              </#list>
                              <#list dto.users[3..5] as user>
                                  <div class="fl_l people_cell">
                                      <a class="ava" href="user?id=${user.userId}">
                                          <img src="${(user.images[0].url)!"nourl"}" width="50" height="50">
                                      </a>
                                      <div class="name_field">
                                          <a href="user?id=${user.userId}">
                                              ${user.firstName}<br>
                                              <small>${user.lastName}</small>
                                          </a>
                                      </div>
                                  </div>
                              </#list>

                            </#if>
                            </div>
                          <#else>
                            У вас пока нет друзей
                          </#if>


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
                                        <#list dto.user.images as image>
                                            <a href="photo?id=${dto.user.userId}" style="width: 81px; height: 81px;" class="page_post_thumb_wrap  page_post_thumb_last_row fl_l">
                                                <img src="${image.url}" style="margin-left: 0px;" class="page_post_thumb_sized_photo" height="81" width="81">
                                            </a>
                                        </#list>
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