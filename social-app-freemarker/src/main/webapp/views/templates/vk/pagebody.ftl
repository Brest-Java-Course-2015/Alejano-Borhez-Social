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
                                    <div class="owner_photo_bubble_delete_wrap" onclick="deletePhoto()" onmouseover="showTooltip(this, {text: &quot;Удалить фотографию&quot;, black: 1, shift: [11, 1, 6]});">
                                        <div class="owner_photo_bubble_delete"></div>
                                </div>
                            </div>
                        </div>
                        <div id="page_avatar">
                            <a id="profile_photo_link">
                                <img src="${dto.user.images[0].url}">
                            </a>
                        </div>
                        <div id="owner_photo_bubble_wrap">
                            <div id="owner_photo_bubble">
                                <div class="owner_photo_bubble_action owner_photo_bubble_action_update" onclick="alert(Функция ещё не реализована!)">
                                    <span class="owner_photo_bubble_action_in">Загрузить новую фотографию</span>
                                </div>
                            </div>
                        </div>
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
                        <div class="people_row">
                           <#list dto.users as user>
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


                    </div>
                </div>
            </div>

                <div class="wide_column fl_r" id="profile_wide">
                    <div id="profile_info">
                        <h4 class="simple page_top clear_fix ta_r">
                            <div class="page_name fl_l ta_l" dir="auto">Александр Alejano Borhez Борохов</div>
                            <div class="profile_grad fl_r"></div>
                            <div class="fl_l ta_l clear"><div class="clear" id="page_current_info"><div onclick="Page.infoEdit()"><span id="current_info"><span class="my_current_info"><span class="current_text">Люблю жену))) и свою уже не такую маленькую дочь!!!</span></span></span></div><div style="display: none"><span class="my_current_info"><span class="current_text">Люблю жену))) и свою уже не такую маленькую дочь!!!</span></span></div><div class="clear" onclick="cancelEvent(event)">
                                <table id="currinfo_editor" cellpadding="0" cellspacing="0">
                                    <tbody><tr>
                                        <td class="sidesh" rowspan="2"><div></div></td>
                                        <td><div class="editor">
                                            <input class="text" maxlength="140" id="currinfo_input" onkeydown="Page.infoCheckSave(event)" onkeyup="Page.infoCheck(this)">
                                            <button class="flat_button fl_r" id="currinfo_save">Сохранить</button>
                                            <div class="fl_l checkbox" id="currinfo_audio" onclick="checkbox(this); Page.audioStatusUpdate('96a57ce87fbc619c1d');"><div></div>Транслировать в статус играющую музыку</div>
                                            <div class="fl_l checkbox on unshown" id="currinfo_app" onclick="checkbox(this); Profile.appStatusUpdate('96a57ce87fbc619c1d')"><div></div>Показывать это приложение, когда я играю</div>
                                            <div class="clear"></div>
                                        </div></td>
                                        <td class="sidesh" rowspan="2"><div></div></td>
                                    </tr>
                                    <tr><td class="bottomsh1"><div></div></td></tr>
                                    <tr><td class="bottomsh2" colspan="3"><div></div></td></tr>
                                    </tbody></table>
                            </div></div></div>
                        </h4>
                        <div id="profile_short">
                            <div class="profile_info"><div class="clear_fix ">
                                <div class="label fl_l">День рождения:</div>
                                <div class="labeled fl_l"><a href="/search?c[section]=people&amp;c[bday]=15&amp;c[bmonth]=2">15 февраля</a></div>
                            </div><div class="clear_fix miniblock">
                                <div class="label fl_l">Родной город:</div>
                                <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[hometown]=%D0%91%D1%80%D0%B5%D1%81%D1%82">Брест</a></div>
                            </div><div class="clear_fix miniblock">
                                <div class="label fl_l">Семейное положение:</div>
                                <div class="labeled fl_l">женат на <a class="mem_link" href="/juli_kasper">Юлии Бороховой</a></div>
                            </div><div class="clear_fix miniblock">
                                <div class="label fl_l">Место работы:</div>
                                <div class="labeled fl_l"><a mention="" mention_id="club718901" onmouseover="mentionOver(this);" href="/epam_club">EPAM Systems (Belarus)</a></div>
                            </div><div class="clear_fix miniblock">
                                <div class="label fl_l">Языки:</div>
                                <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[lang]=-1">Русский</a></div>
                            </div><div class="clear_fix miniblock">
                                <div class="label fl_l">Мать:</div>
                                <div class="labeled fl_l"><a class="mem_link" href="/id94282169">Алла Борохова</a></div>
                            </div><div class="clear_fix miniblock">
                                <div class="label fl_l">Братья, сестры:</div>
                                <div class="labeled fl_l"><a class="mem_link" href="/id81838959">Ольга Крашенинникова</a>, <a class="mem_link" href="/dj_daew">Валентин Демчук</a>, <a class="mem_link" href="/bratchuk1986">Екатерина Минькова</a>, <a class="mem_link" href="/id138863342">Яна Сушко</a>, Леня Борохов</div>
                            </div><div class="clear_fix miniblock">
                                <div class="label fl_l">Дети:</div>
                                <div class="labeled fl_l">Даша, 2 года 10 месяцев</div>
                            </div></div><a class="profile_info_link noselect" onclick="Profile.showFull(1964550, 'ru', 0)">Показать подробную информацию</a>
                        </div>
                    </div>
                    <div id="profile_full_info_wrap"><div id="profile_full_info" style="display: none">
                        <h4>
                            <a class="fl_r" href="/edit?act=contacts">Редактировать</a>
                            <b>Контактная информация</b>
                        </h4>
                        <div class="profile_info">
                            <div class="clear_fix ">
                                <div class="label fl_l">Город:</div>
                                <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[country]=3&amp;c[city]=281">Брест</a></div>
                            </div><div class="clear_fix miniblock">
                            <div class="label fl_l">Моб. телефон:</div>
                            <div class="labeled fl_l">+375295281711</div>
                        </div><div class="clear_fix miniblock">
                            <div class="label fl_l">Skype:</div>
                            <div class="labeled fl_l"><a href="skype:alexander.borohov17?call">alexander.borohov17</a></div>
                        </div><div class="clear_fix miniblock">
                            <div class="label fl_l">Facebook:</div>
                            <div class="labeled fl_l"><a href="http://facebook.com/profile.php?id=100000402792016" target="_blank">Александр Борохов</a></div>
                        </div><div class="clear_fix miniblock">
                            <div class="label fl_l">Дом:</div>
                            <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[addr_country]=3&amp;c[addr_city]=281">Брест</a>, <a href="/search?c[name]=0&amp;c[section]=people&amp;c[addr_country]=3&amp;c[addr_city]=281&amp;c[addr_street]=11238463">Малая ул.</a>, <a href="/search?c[name]=0&amp;c[section]=people&amp;c[addr_country]=3&amp;c[addr_city]=281&amp;c[addr_street]=11238463&amp;c[addr_house]=1892365">1</a><br>c 2009 г.</div>
                        </div>
                        </div>
                        <h4>
                            <a class="fl_r" href="/edit?act=education">Редактировать</a>
                            <b>Образование</b>
                        </h4>
                        <div class="profile_info">
                            <div class="clear_fix ">
                                <div class="label fl_l">Вуз:</div>
                                <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[uni_country]=3&amp;c[uni_city]=392&amp;c[university]=44641">Белорусский Госудаственный Университет Транспорта</a><a href="/search?c[name]=0&amp;c[section]=people&amp;c[uni_country]=3&amp;c[uni_city]=392&amp;c[university]=44641&amp;c[uni_year]=2008"> '08</a></div>
                            </div><div class="clear_fix miniblock">
                            <div class="label fl_l">Факультет:</div>
                            <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[uni_country]=3&amp;c[uni_city]=392&amp;c[university]=44641&amp;c[faculty]=2099">Управление процессами перевозок</a></div>
                        </div><div class="clear_fix miniblock">
                            <div class="label fl_l">Кафедра:</div>
                            <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[uni_country]=3&amp;c[uni_city]=392&amp;c[university]=44641&amp;c[faculty]=2099&amp;c[chair]=83089">ОТП</a></div>
                        </div><div class="clear_fix miniblock">
                            <div class="label fl_l">Форма обучения:</div>
                            <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[uni_country]=3&amp;c[uni_city]=392&amp;c[university]=44641&amp;c[edu_form]=1">Дневное отделение</a></div>
                        </div><div class="clear_fix miniblock">
                            <div class="label fl_l">Статус:</div>
                            <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[uni_country]=3&amp;c[uni_city]=392&amp;c[university]=44641&amp;c[edu_status]=3">Студент (бакалавр)</a></div>
                        </div><div class="clear_fix block">
                            <div class="label fl_l">Школа:</div>
                            <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[school_country]=3&amp;c[school_city]=281&amp;c[school]=12536">Школа №15</a><br>Брест, 1992–1996 <a href="/search?c[name]=0&amp;c[section]=people&amp;c[school_country]=3&amp;c[school_city]=281&amp;c[school]=12536&amp;c[school_class]=01">(а)</a></div>
                        </div><div class="clear_fix block">
                            <div class="label fl_l">Школа:</div>
                            <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[school_country]=3&amp;c[school_city]=281&amp;c[school]=7428">Гимназия №1</a><a href="/search?c[name]=0&amp;c[section]=people&amp;c[school_country]=3&amp;c[school_city]=281&amp;c[school]=7428&amp;c[school_year]=2003"> '03</a><br>Брест, 1996–2003 <a href="/search?c[name]=0&amp;c[section]=people&amp;c[school_country]=3&amp;c[school_city]=281&amp;c[school]=7428&amp;c[school_year]=2003&amp;c[school_class]=01">(а)</a><br><a href="/search?c[name]=0&amp;c[section]=people&amp;c[school_country]=3&amp;c[school_city]=281&amp;c[school]=7428&amp;c[school_spec]=%D1%84%D0%B8%D0%B7.-%D0%BC%D0%B0%D1%82">физ.-мат</a></div>
                        </div>
                        </div>
                        <h4>
                            <a class="fl_r" href="/edit?act=personal">Редактировать</a>
                            <b>Жизненная позиция</b>
                        </h4>
                        <div class="profile_info">
                            <div class="clear_fix ">
                                <div class="label fl_l">Полит. предпочтения:</div>
                                <div class="labeled fl_l">Умеренные</div>
                            </div><div class="clear_fix miniblock">
                            <div class="label fl_l">Мировоззрение:</div>
                            <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[religion]=Православие">Православие</a></div>
                        </div><div class="clear_fix miniblock">
                            <div class="label fl_l">Главное в жизни:</div>
                            <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[personal_priority]=1">Семья и дети</a></div>
                        </div><div class="clear_fix miniblock">
                            <div class="label fl_l">Главное в людях:</div>
                            <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[people_priority]=2">Доброта и честность</a></div>
                        </div><div class="clear_fix miniblock">
                            <div class="label fl_l">Отн. к курению:</div>
                            <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[smoking]=2">Негативное</a></div>
                        </div><div class="clear_fix miniblock">
                            <div class="label fl_l">Отн. к алкоголю:</div>
                            <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[alcohol]=3">Компромиссное</a></div>
                        </div><div class="clear_fix miniblock">
                            <div class="label fl_l">Вдохновляют:</div>
                            <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[q]=%D0%96%D0%B5%D0%BD%D0%B0%20%3A%29">Жена :)</a></div>
                        </div>
                        </div>
                        <h4>
                            <a class="fl_r" href="/edit?act=interests">Редактировать</a>
                            <b>Личная информация</b>
                        </h4>
                        <div class="profile_info">
                            <div class="clear_fix ">
                                <div class="label fl_l">Деятельность:</div>
                                <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[q]=%D0%90%D0%B2%D1%82%D0%BE">Авто</a>, <a href="/search?c[name]=0&amp;c[section]=people&amp;c[q]=%D1%88%D0%B8%D0%BD%D1%8B">шины</a>, <a href="/search?c[name]=0&amp;c[section]=people&amp;c[q]=%D0%B4%D0%B8%D1%81%D0%BA%D0%B8">диски</a>, <a href="/search?c[name]=0&amp;c[section]=people&amp;c[q]=%D0%B0%D0%B2%D1%82%D0%BE%D1%81%D0%BF%D0%BE%D1%80%D1%82">автоспорт</a>, <a href="/search?c[name]=0&amp;c[section]=people&amp;c[q]=%D0%B4%D1%80%D0%B8%D1%84%D1%82">дрифт</a>, <a href="/search?c[name]=0&amp;c[section]=people&amp;c[q]=%D0%BC%D0%BE%D1%82%D0%BE%D1%80%D1%88%D0%BE%D1%83">моторшоу</a></div>
                            </div><div class="clear_fix miniblock">
                            <div class="label fl_l">Интересы:</div>
                            <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[q]=%D0%90%D0%B2%D1%82%D0%BE%D1%81%D0%BF%D0%BE%D1%80%D1%82">Автоспорт</a>, <a href="/search?c[name]=0&amp;c[section]=people&amp;c[q]=%D1%88%D0%B8%D0%BD%D1%8B">шины</a>, <a href="/search?c[name]=0&amp;c[section]=people&amp;c[q]=Porsche">Porsche</a></div>
                        </div><div class="clear_fix miniblock">
                            <div class="label fl_l"><a href="/groups?id=1964550" class="profile_label_link" onclick="return nav.go(this, event, {noback: false})">Группы:</a></div>
                            <div class="labeled fl_l"><a href="/mozgoboj_bre">МозгоБойня в Бресте</a>, <a href="/epam_club">EPAM Systems Belarus</a>, <a href="/profighter_brest">Клуб Профессионал Рукопашный бой ММА Брест</a>, <a href="/tutby">Белорусский портал TUT.BY</a>, <a href="/weddingvideoinprage">Свадебное видео в праге</a>, <a href="/event122417182">10.06 TrockenSaft CITY CLUB Space Music</a>, <a href="/racingby">RACING.BY motorsports first</a>, <a href="/club121703876">Дударев Евгений Творчество</a>, <a href="/myabwby">ABW.BY всё для авто</a>, <a href="/vodi_la">Авто мото Беларуси Водила</a>, <a href="/navi_band">Naviband группа navi</a>, <a href="/activelifevideoru">Activelifevideo Репортажи о путешествиях</a>, <a href="/sunday_grodno">АвтоФест SunDay AutoGrodno.by 2016 23 июля</a>, <a href="/shibudojo">Будзинкан ниндзюцу 武神館 忍法 Нинпо Беларусь</a>, <a href="/johnny_noble_sports1">Johnny Noble Sports</a></div>
                        </div><a class="noselect" id="profile_groups_link" href="/groups?id=1964550" onmouseover="ajax.post('al_profile.php', {act: 'groups', id: cur.oid}, {cache: 1})" onclick="return Profile.showGroups(event)">
                            показать полный список
                        </a>
                            <div class="clear_fix miniblock" style="display: none">
                                <div class="label fl_l">&nbsp;</div>
                                <div class="labeled fl_l" id="profile_all_groups"></div>
                            </div>
                        </div>
                        <h4>
                            <a class="fl_r" href="/edit?act=military">Редактировать</a>
                            <b>Военная служба</b>
                        </h4>
                        <div class="profile_info">
                            <div class="clear_fix ">
                                <div class="label fl_l">Войсковая часть:</div>
                                <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[mil_country]=3&amp;c[mil_unit]=32321">1259 Сморгонь</a><br>Беларусь, 2008–2009</div>
                            </div><div class="clear_fix ">
                            <div class="label fl_l">Войсковая часть:</div>
                            <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[mil_country]=3&amp;c[mil_unit]=645559">2187 Погранзастава им.И.П.Беляева</a><br>Беларусь, 2008–2009</div>
                        </div>
                        </div>
                        <h4>
                            <a class="fl_r" href="/edit?act=career">Редактировать</a>
                            <b>Карьера</b>
                        </h4>
                        <div class="profile_info">
                            <div class="clear_fix profile_career_row">
                                <div class="label fl_l">Место работы:</div>
                                <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[company]=%22%D0%93%D0%9E%D0%90-%D0%9B%D0%BE%D0%B3%D0%B8%D1%81%D1%82%D0%B8%D0%BA%22">"ГОА-Логистик"</a><br>Брест, 2008–2013<br><a href="/search?c[name]=0&amp;c[section]=people&amp;c[position]=%D1%8D%D0%BA%D1%81%D0%BF%D0%B5%D0%B4%D0%B8%D1%82%D0%BE%D1%80">экспедитор</a></div>
                            </div><div class="clear_fix profile_career_row block">
                            <div class="label fl_l">Место работы:</div>
                            <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[company]=%D0%A1%D0%9E%D0%9E%D0%9E%20%22%D0%90%D0%B2%D1%82%D0%BE%D1%81%D0%B5%D1%82%D1%8C%22">СООО "Автосеть"</a><br>Брест, с 2013 г.<br><a href="/search?c[name]=0&amp;c[section]=people&amp;c[position]=%D0%A1%D0%BF%D0%B5%D1%86%D0%B8%D0%B0%D0%BB%D0%B8%D1%81%D1%82%20%D0%BF%D0%BE%20%D0%BC%D0%B0%D1%80%D0%BA%D0%B5%D1%82%D0%B8%D0%BD%D0%B3%D1%83">Специалист по маркетингу</a></div>
                        </div><div class="clear_fix profile_career_row block">
                            <div class="label fl_l">Место работы:</div>
                            <div class="labeled fl_l"><a href="/search?c[name]=0&amp;c[section]=people&amp;c[company]=%D0%A1%D0%9E%D0%9E%D0%9E%20%22%D0%90%D0%B2%D1%82%D0%BE%D1%81%D0%B5%D1%82%D1%8C%22">СООО "Автосеть"</a><br>Брест, 2015–2016<br><a href="/search?c[name]=0&amp;c[section]=people&amp;c[position]=%D0%A0%D1%83%D0%BA%D0%BE%D0%B2%D0%BE%D0%B4%D0%B8%D1%82%D0%B5%D0%BB%D1%8C%20%D1%81%D0%B5%D0%BA%D1%82%D0%BE%D1%80%D0%B0%20%D0%BC%D0%B0%D1%80%D0%BA%D0%B5%D1%82%D0%B8%D0%BD%D0%B3%D0%B0%20%D0%B8%20%D1%80%D0%B5%D0%BA%D0%BB%D0%B0%D0%BC%D1%8B">Руководитель сектора маркетинга и рекламы</a></div>
                        </div><div class="clear_fix profile_career_row block">
                            <div class="label fl_l">Место работы:</div>
                            <div class="labeled fl_l"><a class="fl_r profile_career_group" mention="" mention_id="club718901" onmouseover="mentionOver(this, {shift: [46, 14, 9]});" href="/epam_club"><img src="https://pp.vk.me/c622922/v622922150/32706/unrRNdBWW8U.jpg" height="50" width="50"></a><a href="/epam_club" class="group_link">EPAM Systems (Belarus)</a><br>Брест, с 2016 г.<br><a href="/search?c[name]=0&amp;c[section]=people&amp;c[position]=Software%20developer">Software developer</a></div>
                        </div>
                        </div>
                        <div id="profile_map"></div>
                    </div></div><div class="module clear photos_module" id="profile_photos_module">
                    <a href="/albums1964550?profile=1" onclick="return nav.change({z: 'albums1964550'}, event)" class="module_header">
                        <div class="header_top clear_fix">
                            <div class="fl_r" style="position: relative; color: #99ADC2;">
                                <div id="profile_photo_uploader" onclick="cancelEvent(event); return false;" style="position: absolute; height: 100%; width: 100%; cursor: pointer;"><div class="lite_upload" id="lite_upload0" style="z-index:10000; width: 100%; height: 100%; cursor: pointer;"><embed type="application/x-shockwave-flash" id="uploader_lite0" name="uploader_lite0" preventhide="true" quality="high" flashvars="act=do_add&amp;aid=-7&amp;file_name=photo&amp;file_size_limit=5242880&amp;file_types=*.jpg%3B*.JPG%3B*.jpeg%3B*.JPEG%3B*.png%3B*.PNG%3B*.gif%3B*.GIF&amp;file_types_description=Image%20files%20(*.jpg%2C%20*.jpeg%2C%20*.png%2C%20*.gif)&amp;from_host=vk.com&amp;gid=0&amp;hash=1e535f4adc4397d78af30443539f52ca&amp;keep_meta=1&amp;mid=1964550&amp;onDebug=Upload.callbacks.onDebug0&amp;onMouseDown=Upload.callbacks.onMouseDown0&amp;onMouseOut=Upload.callbacks.onMouseOut0&amp;onMouseOver=Upload.callbacks.onMouseOver0&amp;onMouseUp=Upload.callbacks.onMouseUp0&amp;onSelectClick=Upload.callbacks.onSelectClick0&amp;onUploadComplete=Upload.callbacks.onUploadComplete0&amp;onUploadError=Upload.callbacks.onUploadError0&amp;onUploadProgress=Upload.callbacks.onUploadProgress0&amp;onUploadStart=Upload.callbacks.onUploadStart0&amp;onUploadSuccess=Upload.callbacks.onUploadSuccess0&amp;post_data=act%253Ddo_add%2526aid%253D-7%2526gid%253D0%2526mid%253D1964550%2526hash%253D1e535f4adc4397d78af30443539f52ca%2526rhash%253Da269f4327a031893f244ea6824eb599b%2526vk%253D1%2526from_host%253Dvk.com%2526keep_meta%253D1%2526ajx%253D1&amp;rhash=a269f4327a031893f244ea6824eb599b&amp;upload_url=https%3A%2F%2Fpu.vk.com%2Fc630720%2Fupload.php&amp;vk=1" swliveconnect="true" allowscriptaccess="always" wmode="transparent" src="/swf/photo_uploader_lite.swf?_stV=17" height="100%" width="100%"></div></div><div id="profile_photos_extra_link" class="right_link fl_r" onmouseover="this.parentNode.parentNode.parentNode.href='/album1964550_00?act=add'" onmouseout="this.parentNode.parentNode.parentNode.href='/albums1964550'" onclick="cancelEvent(event); return nav.go(this.parentNode.parentNode.parentNode, event);">добавить фотографии</div>
                            </div>
                            428 фотографий
                        </div>
                    </a>
                    <div id="profile_photos" class="clear_fix">
                        <div class="page_post_sized_thumbs clear_fix profile_sized_photos" style="width: 397px; height: 81px;"><a href="/photo1964550_404402598?all=1" onclick="return showPhoto('1964550_404402598', 'photos1964550', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c608816/v608816550/&quot;,&quot;x_&quot;:[&quot;b9eb/4-dI7Ia0BpQ&quot;,604,604],&quot;y_&quot;:[&quot;b9ec/7ekw1yUAhBQ&quot;,640,640]}}, event)" style="width: 81px; height: 81px;" class="page_post_thumb_wrap  page_post_thumb_last_row fl_l"><div class="profile_photo_hide_wrap" onmouseover="Profile.photoRemoveTip(this)" onclick="return Profile.photoRemove(this, 404402598, event)"><div class="profile_photo_hide"></div></div><img src="https://pp.vk.me/c608816/v608816550/b9ea/p80H61hBhSs.jpg" style="margin-left: 0px;" class="page_post_thumb_sized_photo" height="81" width="81"></a><a href="/photo1964550_388917722?all=1" onclick="return showPhoto('1964550_388917722', 'photos1964550', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c629105/v629105550/&quot;,&quot;x_&quot;:[&quot;1bf21/2UFwRWtnYSs&quot;,604,604],&quot;y_&quot;:[&quot;1bf22/xDvA-3XJJIs&quot;,807,807],&quot;z_&quot;:[&quot;1bf23/QxcnPeWje24&quot;,1080,1080]}}, event)" style="width: 81px; height: 81px;" class="page_post_thumb_wrap  page_post_thumb_last_row fl_l"><div class="profile_photo_hide_wrap" onmouseover="Profile.photoRemoveTip(this)" onclick="return Profile.photoRemove(this, 388917722, event)"><div class="profile_photo_hide"></div></div><img src="https://pp.vk.me/c629105/v629105550/1bf20/ANQbOWTtW6o.jpg" style="margin-left: 0px;" class="page_post_thumb_sized_photo" height="81" width="81"></a><a href="/photo1964550_387661682?all=1" onclick="return showPhoto('1964550_387661682', 'photos1964550', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c628431/v628431550/&quot;,&quot;x_&quot;:[&quot;1e5eb/jk96QYwdyus&quot;,604,403],&quot;y_&quot;:[&quot;1e5ec/9Bw6cmLW8U0&quot;,807,538],&quot;z_&quot;:[&quot;1e5ed/-s3UTvKas5k&quot;,1280,853]}}, event)" style="width: 81px; height: 81px;" class="page_post_thumb_wrap  page_post_thumb_last_row fl_l"><div class="profile_photo_hide_wrap" onmouseover="Profile.photoRemoveTip(this)" onclick="return Profile.photoRemove(this, 387661682, event)"><div class="profile_photo_hide"></div></div><img src="https://pp.vk.me/c628431/v628431550/1e5ea/3pT-9awTL7E.jpg" style="margin-left: -13px;" class="page_post_thumb_sized_photo" height="81" width="121"></a><a href="/photo1964550_385782072?all=1" onclick="return showPhoto('1964550_385782072', 'photos1964550', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c629519/v629519550/&quot;,&quot;x_&quot;:[&quot;1a563/2E_5VgFSlmg&quot;,453,604],&quot;y_&quot;:[&quot;1a564/ZIAxA9tQRrM&quot;,605,807],&quot;z_&quot;:[&quot;1a565/ton4CZwpBNA&quot;,768,1024]}}, event)" style="width: 60px; height: 81px;" class="page_post_thumb_wrap  page_post_thumb_last_row fl_l"><div class="profile_photo_hide_wrap" onmouseover="Profile.photoRemoveTip(this)" onclick="return Profile.photoRemove(this, 385782072, event)"><div class="profile_photo_hide"></div></div><img src="https://pp.vk.me/c629519/v629519550/1a562/-imqu71QFec.jpg" style="margin-left: 0px;" class="page_post_thumb_sized_photo" height="81" width="60"></a><a href="/photo1964550_383637300?all=1" onclick="return showPhoto('1964550_383637300', 'photos1964550', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c623628/v623628550/&quot;,&quot;x_&quot;:[&quot;55279/tg35rRDemxk&quot;,604,604],&quot;y_&quot;:[&quot;5527a/RdCfVssXf40&quot;,807,807],&quot;z_&quot;:[&quot;5527b/H-dIaZCQgUw&quot;,1024,1024]}}, event)" style="width: 82px; height: 81px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row fl_l"><div class="profile_photo_hide_wrap" onmouseover="Profile.photoRemoveTip(this)" onclick="return Profile.photoRemove(this, 383637300, event)"><div class="profile_photo_hide"></div></div><img src="https://pp.vk.me/c623628/v623628550/55278/vst0srTSpX8.jpg" style="margin-top: 0px;" class="page_post_thumb_sized_photo" height="82" width="82"></a></div><div class="page_post_sized_thumbs clear_fix profile_sized_photos profile_wide_sized_photos" style="width: 607px; height: 122px;"><a href="/photo1964550_404402598?all=1" onclick="return showPhoto('1964550_404402598', 'photos1964550', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c608816/v608816550/&quot;,&quot;x_&quot;:[&quot;b9eb/4-dI7Ia0BpQ&quot;,604,604],&quot;y_&quot;:[&quot;b9ec/7ekw1yUAhBQ&quot;,640,640]}}, event)" style="width: 122px; height: 122px;" class="page_post_thumb_wrap  page_post_thumb_last_row fl_l"><div class="profile_photo_hide_wrap" onmouseover="Profile.photoRemoveTip(this)" onclick="return Profile.photoRemove(this, 404402598, event)"><div class="profile_photo_hide"></div></div><img src="https://pp.vk.me/c608816/v608816550/b9ea/p80H61hBhSs.jpg" style="margin-left: 0px;" class="page_post_thumb_sized_photo" height="122" width="122"></a><a href="/photo1964550_388917722?all=1" onclick="return showPhoto('1964550_388917722', 'photos1964550', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c629105/v629105550/&quot;,&quot;x_&quot;:[&quot;1bf21/2UFwRWtnYSs&quot;,604,604],&quot;y_&quot;:[&quot;1bf22/xDvA-3XJJIs&quot;,807,807],&quot;z_&quot;:[&quot;1bf23/QxcnPeWje24&quot;,1080,1080]}}, event)" style="width: 122px; height: 122px;" class="page_post_thumb_wrap  page_post_thumb_last_row fl_l"><div class="profile_photo_hide_wrap" onmouseover="Profile.photoRemoveTip(this)" onclick="return Profile.photoRemove(this, 388917722, event)"><div class="profile_photo_hide"></div></div><img src="https://pp.vk.me/c629105/v629105550/1bf20/ANQbOWTtW6o.jpg" style="margin-left: 0px;" class="page_post_thumb_sized_photo" height="122" width="122"></a><a href="/photo1964550_387661682?all=1" onclick="return showPhoto('1964550_387661682', 'photos1964550', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c628431/v628431550/&quot;,&quot;x_&quot;:[&quot;1e5eb/jk96QYwdyus&quot;,604,403],&quot;y_&quot;:[&quot;1e5ec/9Bw6cmLW8U0&quot;,807,538],&quot;z_&quot;:[&quot;1e5ed/-s3UTvKas5k&quot;,1280,853]}}, event)" style="width: 122px; height: 122px;" class="page_post_thumb_wrap  page_post_thumb_last_row fl_l"><div class="profile_photo_hide_wrap" onmouseover="Profile.photoRemoveTip(this)" onclick="return Profile.photoRemove(this, 387661682, event)"><div class="profile_photo_hide"></div></div><img src="https://pp.vk.me/c628431/v628431550/1e5f0/lVR1XPbacVE.jpg" style="margin-left: -20px;" class="page_post_thumb_sized_photo" height="122" width="184"></a><a href="/photo1964550_385782072?all=1" onclick="return showPhoto('1964550_385782072', 'photos1964550', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c629519/v629519550/&quot;,&quot;x_&quot;:[&quot;1a563/2E_5VgFSlmg&quot;,453,604],&quot;y_&quot;:[&quot;1a564/ZIAxA9tQRrM&quot;,605,807],&quot;z_&quot;:[&quot;1a565/ton4CZwpBNA&quot;,768,1024]}}, event)" style="width: 92px; height: 122px;" class="page_post_thumb_wrap  page_post_thumb_last_row fl_l"><div class="profile_photo_hide_wrap" onmouseover="Profile.photoRemoveTip(this)" onclick="return Profile.photoRemove(this, 385782072, event)"><div class="profile_photo_hide"></div></div><img src="https://pp.vk.me/c629519/v629519550/1a562/-imqu71QFec.jpg" style="margin-top: 0px;" class="page_post_thumb_sized_photo" height="123" width="92"></a><a href="/photo1964550_383637300?all=1" onclick="return showPhoto('1964550_383637300', 'photos1964550', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c623628/v623628550/&quot;,&quot;x_&quot;:[&quot;55279/tg35rRDemxk&quot;,604,604],&quot;y_&quot;:[&quot;5527a/RdCfVssXf40&quot;,807,807],&quot;z_&quot;:[&quot;5527b/H-dIaZCQgUw&quot;,1024,1024]}}, event)" style="width: 82px; height: 122px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row fl_l"><div class="profile_photo_hide_wrap" onmouseover="Profile.photoRemoveTip(this)" onclick="return Profile.photoRemove(this, 383637300, event)"><div class="profile_photo_hide"></div></div><img src="https://pp.vk.me/c623628/v623628550/55278/vst0srTSpX8.jpg" style="margin-left: -13px;" class="page_post_thumb_sized_photo" height="122" width="122"></a></div>
                    </div>
                </div><div class="wall_module" id="profile_wall">
                    <div class="module_header wall_header">
                        <a href="/wall1964550" id="page_wall_header" class="header_top clear_fix">
                            <span class="right_link fl_r" id="page_wall_switch" onclick="if (checkEvent(event)) return true; return wall.switchWall(event);">к записям Александра</span>
                            <b id="page_wall_posts_count">692 записи</b>
                        </a>
                    </div>
                    <div id="submit_post_box" class="clear_fix" onclick="event.cancelBubble=true;">
                        <div id="submit_post_error" class="error"></div>
                        <div class="clear_fix">
                            <div class="input_back_wrap no_select"><div style="padding-top: 7px; padding-bottom: 6px; padding-left: 6px;" class="input_back"><div class="input_back_content" style="width: 361px;">Что у Вас нового?</div></div></div><textarea id="post_field" class="fl_l" onkeyup="Wall.postChanged()" onkeydown="onCtrlEnter(event, Wall.sendPost)" onfocus="Wall.showEditPost()"></textarea>
                        </div>
                        <div id="post_warn"></div>
                        <div id="submit_post" onclick="event.cancelBubble=true;">
                            <div id="media_preview" class="clear_fix multi_media_preview"><div id="page_pics_preview1" class="page_pics_preview media_preview clear_fix"></div><div id="page_dpics_preview1" class="page_pics_preview page_media_sortable media_preview clear_fix"></div><div id="page_docs_preview1" class="page_docs_preview page_media_sortable media_preview clear_fix"></div><div id="page_pdocs_preview1" class="page_docs_preview media_preview clear_fix"></div><div id="page_ldocs_preview1" class="page_docs_preview media_preview clear_fix"></div><div id="page_mpics_preview1" class="page_pics_preview media_preview clear_fix"></div><div id="page_ppdocs_preview1" class="page_docs_preview media_preview clear_fix"></div><div id="page_progress_preview1" class="page_progress_preview media_preview clear_fix"></div></div>
                            <button class="flat_button fl_l" id="send_post" onclick="wall.sendPost()">Отправить</button>
                            <div class="checkbox_pic on fl_l" id="facebook_export" onclick="checkbox(this)" onmouseover="showTooltip(this, {text: 'экспорт в Facebook', black: 1, shift: [13,4,0]});"><div></div></div>
                            <div id="page_add_media" class="fl_r"><span class="add_media_lnk">Прикрепить</span></div>
                            <div class="progress fl_r" id="page_post_progress"></div>
                        </div>
                    </div><div id="wall_postponed" style="display: none"></div>

                </div>
                </div>

            </div>
                <br class="clear">

            </div>

            </div>
        </div>
     </div>
    </div>
</div>