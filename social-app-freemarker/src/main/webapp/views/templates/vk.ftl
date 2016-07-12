<div class="scroll_fix_wrap" id="page_wrap">
<div><div style="width: 1604px;" class="scroll_fix">
  <div id="page_layout" style="width: 791px;">
    <div id="page_header" class="p_head p_head_l0">
      <div class="back"></div>
      <div class="left"></div>
      <div class="right"></div>
      <div class="content">
        <div id="top_nav" class="head_nav">
  <table id="top_links" cellpadding="0" cellspacing="0">
    <tbody><tr>
      <td class="top_home_link_td">
        <div class="" id="top_logo_down"></div>
        <a class="top_home_link" href="/feed" onmousedown="addClass('top_logo_down','tld_d');" onclick="return nav.go(this, event);"></a>
      </td>
      <td class="top_back_link_td">
        <a style="max-width: 212px; display: none;" class="top_nav_link fl_l" href="/albums1964550" id="top_back_link" onclick="if (nav.go(this, event, {back: true}) === false) { showBackLink(); return false; }" onmousedown="tnActive(this)">Все фотографии</a>
      </td>
      <td style=""><nobr>
        <a class="top_nav_link" id="head_people" href="/search?c[section]=people" onclick="return nav.go(this, event, {search: true, noframe: true});" onmousedown="tnActive(this)">люди</a>
      </nobr></td>
      <td style=""><nobr>
        <a class="top_nav_link" id="head_communities" href="/search?c[section]=communities" onclick="return nav.go(this, event, {search: true, noframe: true});" onmousedown="tnActive(this)">сообщества</a>
      </nobr></td>
      <td style=""><nobr>
        <a class="top_nav_link" id="head_games" href="/apps" onclick="return nav.go(this, event, {noback: true});" onmousedown="tnActive(this)">игры</a>
      </nobr></td>
      <td style=""><nobr>
        <a class="top_nav_link" id="head_music" href="/audios1964550?act=popular" onclick="return Pads.show('mus', event);" onmousedown="tnActive(this)">
          <span id="head_music_text">музыка</span>
          <div id="head_play_btn" onmouseover="addClass(this, 'over');" onmouseout="removeClass(this, 'over'); removeClass(this, 'down')" onmousedown="addClass(this, 'down'); addClass(ge('head_music'), 'head_play_down');" onmouseup="removeClass(this, 'down')" onclick="headPlayPause(event); return Pads.show('mus', event);"></div>
        </a>
      </nobr></td>
      <td id="support_link_td" style=""><nobr>
        <a class="top_nav_link" id="top_support_link" href="/support?act=home" onclick="return nav.go(this, event, {noback: true});" onmousedown="tnActive(this)">помощь</a>
      </nobr></td>
      <td id="logout_link_td"><nobr>
        <a class="top_nav_link" id="logout_link" href="https://login.vk.com/?act=logout&amp;hash=ce08d6c7537779bc56&amp;_origin=https://vk.com" onclick="if (checkEvent(event) === false) { window.Notifier &amp;&amp; Notifier.lcSend('logged_off'); location.href = this.href; return cancelEvent(event); }" onmousedown="tnActive(this)">выйти</a>
      </nobr></td>
    </tr>
  </tbody></table>
  <div style="opacity: 1; display: block;" id="ts_wrap" class="clear_fix">
    <div id="ts_input_wrap" class="ts_input_wrap fl_r" onmouseover="TopSearch.highlightInput(true); TopSearch.initFriendsList();" onmouseout="TopSearch.highlightInput(false)">
      <div class="ts" onmousedown="event.cancelBubble = true;">
        <div class="ts_input_wrap2"><div>
          <div class="input_back_wrap no_select"><div style="margin: 1px; padding: 3px 41px 6px 20px;" class="input_back"><div class="input_back_content" style="width: 145px;">Поиск</div></div></div><input style="padding: 4px 41px 5px 20px;" onmousedown="event.cancelBubble = true;" ontouchstart="event.cancelBubble = true;" class="text" id="ts_input" autocomplete="off" type="text">
        </div></div>
      </div>
    </div>
  </div>
  <span style="display: none" id="top_new_msg"></span>
</div>
<div style="display: none;" id="ts_cont_wrap" ontouchstart="event.cancelBubble = true;" onmousedown="event.cancelBubble = true;"></div>
      </div>
    </div>

    <div id="side_bar" class="fl_l" style="">
      <ol>
  <li>
  <table id="myprofile_table" cellpadding="0" cellspacing="0"><tbody><tr>
    <td id="myprofile_wrap">
      <a href="/borxezz" onclick="return nav.go(this, event, {noback: true})" id="myprofile" class="left_row"><span class="left_label inl_bl">Моя Страница</span></a>
    </td>
    <td id="myprofile_edit_wrap">
      <a href="/edit" id="myprofile_edit" class="left_row"><span class="left_label inl_bl">ред.</span></a>
    </td>
  </tr></tbody></table>
</li><li id="l_fr"><a href="/friends" onclick="return nav.go(this, event, {noback: true, params: {_ref: 'left_nav'}});" class="left_row"><span class="left_fixer"><span class="left_count_pad" onmouseover="Pads.preload('fr')" onmousedown="return Pads.show('fr', event)" onclick="return (checkEvent(event) || browser.msie6) ? true : cancelEvent(event)"><span style="opacity: 1; display: block;" class="left_count_wrap  left_void fl_r"><span class="inl_bl left_count">+</span></span></span><span class="left_label inl_bl">Мои Друзья</span></span></a></li><li id="l_ph"><a href="/albums1964550" onclick="return nav.go(this, event, {noback: true, params: {_ref: 'left_nav'}});" class="left_row"><span class="left_fixer"><span class="left_count_pad" onmouseover="Pads.preload('ph')" onmousedown="return Pads.show('ph', event)" onclick="return (checkEvent(event) || browser.msie6) ? true : cancelEvent(event)"><span style="opacity: 1; display: block;" class="left_count_wrap  left_void fl_r"><span class="inl_bl left_count">+</span></span></span><span class="left_label inl_bl">Мои Фотографии</span></span></a></li><li id="l_vid"><a href="/video" onclick="return nav.go(this, event, {noback: true, params: {_ref: 'left_nav'}});" class="left_row"><span class="left_fixer"><span class="left_count_pad" onmouseover="Pads.preload('vid')" onmousedown="return Pads.show('vid', event)" onclick="return (checkEvent(event) || browser.msie6) ? true : cancelEvent(event)"><span style="opacity: 1; display: block;" class="left_count_wrap  left_void fl_r"><span class="inl_bl left_count">+</span></span></span><span class="left_label inl_bl">Мои Видеозаписи</span></span></a></li><li><a href="/audios1964550" onclick="return nav.go(this, event, {noback: true, params: {_ref: 'left_nav'}});" class="left_row"><span class="left_fixer"><span class="left_count_wrap  left_void fl_r"><span class="inl_bl left_plus">+</span></span><span class="left_label inl_bl">Мои Аудиозаписи</span></span></a></li><li id="l_msg"><a href="/im" onclick="return nav.go(this, event, {noback: true, params: {_ref: 'left_nav'}});" class="left_row"><span class="left_fixer"><span class="left_count_pad left_count_persist" onmouseover="Pads.preload('msg')" onmousedown="return Pads.show('msg', event)" onclick="return (checkEvent(event) || browser.msie6) ? true : cancelEvent(event)"><span style="opacity: 1; display: block;" class="left_count_wrap  left_void fl_r"><span class="inl_bl left_count">+</span></span></span><span class="left_label inl_bl">Мои Сообщения</span></span></a></li><li style="display: none" id="l_nts"><a href="/notes" onclick="return nav.go(this, event, {noback: true, params: {_ref: 'left_nav'}});" class="left_row"><span class="left_fixer"><span style="opacity: 1; display: block;" class="left_count_wrap  left_void fl_r"><span class="inl_bl left_count">+</span></span><span class="left_label inl_bl">Мои Заметки</span></span></a></li><li id="l_gr"><a href="/groups" onclick="return nav.go(this, event, {noback: true, params: {_ref: 'left_nav'}});" class="left_row"><span class="left_fixer"><span class="left_count_pad" onmouseover="Pads.preload('gr')" onmousedown="return Pads.show('gr', event)" onclick="return (checkEvent(event) || browser.msie6) ? true : cancelEvent(event)"><span style="opacity: 1; display: block;" class="left_count_wrap  left_void fl_r"><span class="inl_bl left_count">+</span></span></span><span class="left_label inl_bl">Мои Группы</span></span></a></li><li style="display: none" id="l_ev"><a href="/events" onclick="return nav.go(this, event, {noback: true, params: {_ref: 'left_nav'}});" class="left_row"><span class="left_fixer"><span style="opacity: 1; display: block;" class="left_count_wrap  left_void fl_r"><span class="inl_bl left_count">+</span></span><span class="left_label inl_bl">Мои Встречи</span></span></a></li><li id="l_nwsf"><a href="/feed" onclick="return nav.go(this, event, {noback: true, params: {_ref: 'left_nav'}});" class="left_row"><span class="left_fixer"><span class="left_count_wrap  left_void fl_r"><span class="inl_bl left_plus">+</span></span><span class="left_label inl_bl">Мои Новости</span></span></a></li><li id="l_nws"><a href="/feed?section=notifications" onclick="return nav.go(this, event, {noback: true, params: {_ref: 'left_nav'}});" class="left_row"><span class="left_fixer"><span class="left_count_pad left_count_persist" onmouseover="Pads.preload('nws')" onmousedown="return Pads.show('nws', event)" onclick="return (checkEvent(event) || browser.msie6) ? true : cancelEvent(event)"><span style="opacity: 1; display: block;" class="left_count_wrap  left_void fl_r"><span class="inl_bl left_count">+</span></span></span><span class="left_label inl_bl">Мои Ответы</span></span></a></li><li id="l_set"><a href="/settings" onclick="return nav.go(this, event, {noback: true, params: {_ref: 'left_nav'}});" class="left_row"><span class="left_fixer"><span class="left_count_wrap  left_void fl_r"><span class="inl_bl left_plus">+</span></span><span class="left_label inl_bl">Мои Настройки</span></span></a></li><div class="more_div"></div><li id="l_ap"><a href="/apps" onclick="return nav.go(this, event, {noback: true, params: {_ref: 'left_nav'}});" class="left_row"><span class="left_fixer"><span class="left_count_pad left_count_persist" onmouseover="Pads.preload('ap')" onmousedown="return Pads.show('ap', event)" onclick="return (checkEvent(event) || browser.msie6) ? true : cancelEvent(event)"><span class="left_count_wrap  fl_r"><span class="inl_bl left_count">+1</span></span></span><span class="left_label inl_bl">Приложения</span></span></a></li><li><a href="/docs" onclick="return nav.go(this, event, {noback: true, params: {_ref: 'left_nav'}});" class="left_row"><span class="left_fixer"><span class="left_count_wrap  left_void fl_r"><span class="inl_bl left_plus">+</span></span><span class="left_label inl_bl">Документы</span></span></a></li><li id="l_ads"><a href="/ads?act=office&amp;last=1" onclick="return nav.go(this, event, {noback: true, params: {_ref: 'left_nav'}});" class="left_row"><span class="left_fixer"><span style="opacity: 1; display: block;" class="left_count_wrap  left_void fl_r"><span class="inl_bl left_count">+</span></span><span class="left_label inl_bl">Реклама</span></span></a></li><li style="display: none" id="l_spr"><a href="/support" onclick="return nav.go(this, event, {noback: true, params: {_ref: 'left_nav'}});" class="left_row"><span class="left_fixer"><span class="left_count_wrap  left_void fl_r"><span class="inl_bl left_plus">+</span></span><span class="left_label inl_bl">Поддержка</span></span></a></li>
</ol>
<div id="left_blocks"><div id="left_block3_0" onmouseover="leftBlockOver('3_0')" onmouseout="leftBlockOut('3_0')">
  <div style="opacity: 0;" id="left_hide3_0" class="left_hide" onmouseover="leftBlockOver(this)" onmouseout="leftBlockOut(this)" onclick="leftBlockHide('3_0', '9cac9261082570699d')"></div>
  <div class="left_box attention">
    <h4>Напоминание</h4>
    <div>
       <a href="/friends?w=calendar" onclick="return nav.change({w: 'calendar'})">Завтра</a> день рождения <a href="/a.beresten" onclick="return nav.go(this, event)">Алеси Берестень</a>, <a href="/slavik_borovitsky" onclick="return nav.go(this, event)">Славика Боровицкого</a>.
    </div>
  </div>
</div></div><div style="overflow: visible; display: block;" id="ads_left"><div style="display: block ! important; position: static; left: 0px; top: 0px; opacity: 1;"><div class="ads_ads_box ver repeat_ver size_site" style="visibility: visible !important;display:table !important;"><div class="ads_ads_box2 ver repeat_ver size_site" style="visibility: visible !important;display:table-cell !important;"><div class="ads_ads_box3 ver repeat_ver size_site" style="visibility: visible !important;display:inline-block !important;"><div class="ads_ads_box4 ver repeat_ver size_site" style="visibility: visible !important;display:table !important;"><div class="ads_ad_box ver repeat_ver size_site first" id="ads_ad_box_ad_e40731bdf3bceb47"><div style="opacity: 0;" id="left_hidead_e40731bdf3bceb47" class="left_hide_button" onmouseover="leftBlockOver(this);" onmouseout="leftBlockOut(this);" onclick="leftAdBlockClose('ad_e40731bdf3bceb47', '/away.php?to=QhscGkJxD1NzagpURSNQURBdWEJHcAYcQABlSUlabx8*OVILMnJeZUAsAjMBaAw2LxsBakleWlxFI0ZkKDN/QH9bKkIWNEByGHR1X18PTlECbgw2WHEwf14lC0JaE35EMQs8A3BDGVwZFGQpCh1oXSEkFCYyNnAvJHoEeRcIaQAJc11KUikmNXsnMXVYK2gPMA5jGSgbaiQVCXwtCzoMBlEEVQlJFQpkCCAzHlkLDXwVIUdyOk8ff0FuCzAiHBcOWCc1Sl4uBgEAMmJpIDs*Fk5aKkslOVMrRGZcAkkIVEooEwpTBDQWC34cbkUXeVpWUlg3BVk*b3pBAWd3RHBVAAR0YR8SEgo6XRAgYFdeESszEn4TTFYXHmEmaX8TD1wkHmNZW0USXiQWFEACAXMQWRcJTBE5BGNNIAoYKEc8EWk/KwZ6Kw5CWyYjWgE0aGs0KHANQEUmZAspOXAWASkYMGkVMXctfWsgGnZpVDYYei0Wd3cxJ3cXQW9dfxg1cwZwSw8iSX0gC1QaGBt1Qn1WDzMsCjAyHQw6IQ8/VVwVWRclJxxPFxs5MGYaEXokBl8UR0R1UAhxAw0YDXlSXxMKShEgSiAGC0tOMBsUKE1bY18RGWIlImFdAF9uf1EiK0kTGDBXaR8ARkEnFXpmUjgBM2g7Y1UUORs1J010QTICYi4sKlQNJSoLX1xdDzooLAQSEktjFWUBY34dHl06QnNLVQ--'); return cancelEvent(event);"></div><div class="ads_ad_close_info" id="ads_ad_close_info_ad_e40731bdf3bceb47"><div class="ads_ad_box_border repeat_ver first"></div><div class="ads_ad_close_info2"><div class="ads_ad_close_info3"><div class="ads_ad_close_info4"><div class="ads_ad_close_text">Данное объявление больше не будет Вам показываться.</div><div class="ads_ad_close_complain"><span class="ads_ad_close_complain_info">Если объявление содержит нарушения или ошибку, </span><span class="ads_ad_close_complain_link" onclick="reportAd(20463227, this);">сообщите нам.</span></div></div></div></div></div><div class="ads_ad_box_border repeat_ver first"></div><a class="ads_ad_box2 ver repeat_ver size_site first" id="ads_ad_box2_ad_e40731bdf3bceb47" target="_blank" onmouseover="leftBlockOver('ad_e40731bdf3bceb47');" onmouseout="leftBlockOut('ad_e40731bdf3bceb47');" href="/away.php?to=QxscGkJxD1NzagpURXsHBBJbBxBCcgEVHQdjQk5VbR8*OVILMnJeZUAsAjMBaAw2LxsBakleWlxFI0ZkKDN/QH9bKkIWNEByGHR1X18PTlECbgw2WHEwf14lC0JaE35EMQs8A3BDGVwZFGQpCh1oXSEkFCYyNnAvJHoEeRcIaQAJc11KUikmNXsnMXVYK2gPMA5jGSgbaiQVCXwtCzoMBlEEVQlJFQpkCCAzHlkLDXwVIUdyOk8ff0FuCzAiHBcOWCc1Sl4uBgEAMmJpIDs*Fk5aKkslOVMrRGZcAkkIVEooEwpTBDQWC34cbkUXeVpWUlg3BVk*b3pBAWd3RHBVAAR0YR8SEgo6XRAgYFdeESszEn4TTFYXHmEmaX8TD1wkHmNZW0USXiQWFEACAXMQWRcJTBE5BGNNIAoYKEc8EWk/KwZ6Kw5CWyYjWgE0aGs0KHANQEUmZAspOXAWASkYMGkVMXctfWsgGnZpVDYYei0Wd3cxJ3cXQW9dfxg1cwZwSw8iSX0gC1QaGBt1Qn1WDzMsCjAyHQw6IQ8/VVwVWRclJxxPFxs5MGYaEXokBl8UR0R1UAhxAw0YDXlSXxMKShEgSiAGC0tOMBsUKE1bY18RGWIlImFdAF9uf1EiK0kTGDBXaR8ARkEnFXpmUjgBM2g7Y1UUORs1J010QTICYi4sKlQNJSoLX1xdDzooLAQSEktjFWUBY34dHl06QnNLVQ--" href_join="/away.php?to=QRscGkJxD1NzagpURXsHBBJbBxBCcgEVHQdjQk5VbR8*OVILMnJeZUAsAjMBaAw2LxsBakleWlxFI0ZkKDN/QH9bKkIWNEByGHR1X18PTlECbgw2WHEwf14lC0JaE35EMQs8A3BDGVwZFGQpCh1oXSEkFCYyNnAvJHoEeRcIaQAJc11KUikmNXsnMXVYK2gPMA5jGSgbaiQVCXwtCzoMBlEEVQlJFQpkCCAzHlkLDXwVIUdyOk8ff0FuCzAiHBcOWCc1Sl4uBgEAMmJpIDs*Fk5aKkslOVMrRGZcAkkIVEooEwpTBDQWC34cbkUXeVpWUlg3BVk*b3pBAWd3RHBVAAR0YR8SEgo6XRAgYFdeESszEn4TTFYXHmEmaX8TD1wkHmNZW0USXiQWFEACAXMQWRcJTBE5BGNNIAoYKEc8EWk/KwZ6Kw5CWyYjWgE0aGs0KHANQEUmZAspOXAWASkYMGkVMXctfWsgGnZpVDYYei0Wd3cxJ3cXQW9dfxg1cwZwSw8iSX0gC1QaGBt1Qn1WDzMsCjAyHQw6IQ8/VVwVWRclJxxPFxs5MGYaEXokBl8UR0R1UAhxAw0YDXlSXxMKShEgSiAGC0tOMBsUKE1bY18RGWIlImFdAF9uf1EiK0kTGDBXaR8ARkEnFXpmUjgBM2g7Y1UUORs1J010QTICYi4sKlQNJSoLX1xdDzooLAQSEktjFWUBY34dHl06QnNLVQ--"><div class="ads_ad_box3 ver"><div class="ads_ad_box4 ver"><div class="ads_ad_box5 ver repeat_ver"><div class="ads_ad_box5_spacer ver repeat_ver size_site"></div><div class="ads_ad_box6 ver"><div class="ads_ad_text_box ver repeat_ver size_site"><div class="ads_ad_title_box ver repeat_ver"><div class="ads_ad_title_spacer1 ver repeat_ver"><div class="ads_ad_title_spacer2 ver repeat_ver"></div></div><div class="ads_ad_title ver repeat_ver">База предприятий</div></div><div class="ads_ad_domain ver">1<span class="num_delim"> </span>400 участников</div><div class="ads_ad_photo_box ver promotion"><img class="ads_ad_photo ver" src="https://pp.vk.me/c623824/v623824994/2dbe2/k1Okps_lzZw.jpg"><div class="ads_ad_play ver unshown empty"></div><div class="ads_ad_play_app">Играть</div><div class="ads_ad_disclaimers_photo"></div></div><div class="ads_ad_description ver" style="display: none;"></div><div class="ads_ad_community_join" onmouseover="var linkElem=this; while(linkElem.nodeName!=='A')linkElem=linkElem.parentNode; this.setAttribute('href_old',linkElem.href); linkElem.href=linkElem.getAttribute('href_join');" onmouseout="var linkElem=this; while(linkElem.nodeName!=='A')linkElem=linkElem.parentNode; linkElem.href=this.getAttribute('href_old');">Вступить</div><div class="ads_ad_disclaimers_bottom"></div></div></div></div></div></div></a></div><div class="ads_ad_box ver repeat_ver size_site" id="ads_ad_box_ad_607c5eaecf5ce96d"><div id="left_hidead_607c5eaecf5ce96d" class="left_hide_button" onmouseover="leftBlockOver(this);" onmouseout="leftBlockOut(this);" onclick="leftAdBlockClose('ad_607c5eaecf5ce96d', '/away.php?to=QhscGkJyA1Vzbw9URSYCC0VaCEISdVcQHVFoRRwPbx8nAEcMJVRoRkl2WlIrIVBTDQUFelc1SycAIFFVFxQlJ3AlPgATL3Y5JnV/Wl8DSTc1blUZMBtXe2xUVxEhGQBqF1cKQWU6cEkPJH8FHX11ZEB5cCMkM3dRJSsJW0AmERopM1sXME4dOF1UDkEHKkt6MmBOdQJ3ag4ZPHAQCxAeAk8oVDEhc2tTLzFoRGMGAFUNL3QOJ291dxhrXCQuLlorEzpeUhc7CzwWM0RsMTs1NWhfMlFPdQMxJVJETygpAzJ4H1QbMCg/QlcCS0IUNmRfTzMDSBIUCkYTD3QVSkQDBigEYQE0PWA2EQVJVB8ZSBEyKXV1UiMiGFoNIHcTO0MZI01*QQIvQQoHHHAZBQ8JcFVaWik*L1J/EBgWQXpdHHIDf3cGGWEYBh4RagYODWo6DXUVehcDeStEMnRQCzU2BX0jYlQ1NWsRS3J5YBEACxAYAkECLS03UkcOZyQWAwBBIBlgFEsHYkU*e3csXENrVDQSUh0vP1E5WygLS0kUWUcEJ2V2ADM5FUslMngRKUAsQWFbUThycVVqOloKGRVUdmpcaUMfJkIRExIeAQBaOGUEGGsmBAVmQTEpfB00aUwLXAQzREIVdCoWclBOSQgVN0UidQo*N3cVFGdeBicXelYpCnVVCjgxC14pCwlFN3kUShBmIXlDPQAVD3ZyFQ9tQw--'); return cancelEvent(event);"></div><div class="ads_ad_close_info" id="ads_ad_close_info_ad_607c5eaecf5ce96d"><div class="ads_ad_box_border repeat_ver"></div><div class="ads_ad_close_info2"><div class="ads_ad_close_info3"><div class="ads_ad_close_info4"><div class="ads_ad_close_text">Данное объявление больше не будет Вам показываться.</div><div class="ads_ad_close_complain"><span class="ads_ad_close_complain_info">Если объявление содержит нарушения или ошибку, </span><span class="ads_ad_close_complain_link" onclick="reportAd(23803777, this);">сообщите нам.</span></div></div></div></div></div><div class="ads_ad_box_border repeat_ver"></div><a class="ads_ad_box2 ver repeat_ver size_site" id="ads_ad_box2_ad_607c5eaecf5ce96d" target="_blank" onmouseover="leftBlockOver('ad_607c5eaecf5ce96d');" onmouseout="leftBlockOut('ad_607c5eaecf5ce96d');" href="/away.php?to=QxscGkJyA1Vzbw9URXBQABdcX0pAdFFGSVZjFR9Ubx8nAEcMJVRoRkl2WlIrIVBTDQUFelc1SycAIFFVFxQlJ3AlPgATL3Y5JnV/Wl8DSTc1blUZMBtXe2xUVxEhGQBqF1cKQWU6cEkPJH8FHX11ZEB5cCMkM3dRJSsJW0AmERopM1sXME4dOF1UDkEHKkt6MmBOdQJ3ag4ZPHAQCxAeAk8oVDEhc2tTLzFoRGMGAFUNL3QOJ291dxhrXCQuLlorEzpeUhc7CzwWM0RsMTs1NWhfMlFPdQMxJVJETygpAzJ4H1QbMCg/QlcCS0IUNmRfTzMDSBIUCkYTD3QVSkQDBigEYQE0PWA2EQVJVB8ZSBEyKXV1UiMiGFoNIHcTO0MZI01*QQIvQQoHHHAZBQ8JcFVaWik*L1J/EBgWQXpdHHIDf3cGGWEYBh4RagYODWo6DXUVehcDeStEMnRQCzU2BX0jYlQ1NWsRS3J5YBEACxAYAkECLS03UkcOZyQWAwBBIBlgFEsHYkU*e3csXENrVDQSUh0vP1E5WygLS0kUWUcEJ2V2ADM5FUslMngRKUAsQWFbUThycVVqOloKGRVUdmpcaUMfJkIRExIeAQBaOGUEGGsmBAVmQTEpfB00aUwLXAQzREIVdCoWclBOSQgVN0UidQo*N3cVFGdeBicXelYpCnVVCjgxC14pCwlFN3kUShBmIXlDPQAVD3ZyFQ9tQw--" href_join="/away.php?to=QRscGkJyA1Vzbw9URXBQABdcX0pAdFFGSVZjFR9Ubx8nAEcMJVRoRkl2WlIrIVBTDQUFelc1SycAIFFVFxQlJ3AlPgATL3Y5JnV/Wl8DSTc1blUZMBtXe2xUVxEhGQBqF1cKQWU6cEkPJH8FHX11ZEB5cCMkM3dRJSsJW0AmERopM1sXME4dOF1UDkEHKkt6MmBOdQJ3ag4ZPHAQCxAeAk8oVDEhc2tTLzFoRGMGAFUNL3QOJ291dxhrXCQuLlorEzpeUhc7CzwWM0RsMTs1NWhfMlFPdQMxJVJETygpAzJ4H1QbMCg/QlcCS0IUNmRfTzMDSBIUCkYTD3QVSkQDBigEYQE0PWA2EQVJVB8ZSBEyKXV1UiMiGFoNIHcTO0MZI01*QQIvQQoHHHAZBQ8JcFVaWik*L1J/EBgWQXpdHHIDf3cGGWEYBh4RagYODWo6DXUVehcDeStEMnRQCzU2BX0jYlQ1NWsRS3J5YBEACxAYAkECLS03UkcOZyQWAwBBIBlgFEsHYkU*e3csXENrVDQSUh0vP1E5WygLS0kUWUcEJ2V2ADM5FUslMngRKUAsQWFbUThycVVqOloKGRVUdmpcaUMfJkIRExIeAQBaOGUEGGsmBAVmQTEpfB00aUwLXAQzREIVdCoWclBOSQgVN0UidQo*N3cVFGdeBicXelYpCnVVCjgxC14pCwlFN3kUShBmIXlDPQAVD3ZyFQ9tQw--"><div class="ads_ad_box3 ver"><div class="ads_ad_box4 ver"><div class="ads_ad_box5 ver repeat_ver"><div class="ads_ad_box5_spacer ver repeat_ver size_site"></div><div class="ads_ad_box6 ver"><div class="ads_ad_text_box ver repeat_ver size_site"><div class="ads_ad_title_box ver repeat_ver"><div class="ads_ad_title_spacer1 ver repeat_ver"><div class="ads_ad_title_spacer2 ver repeat_ver"></div></div><div class="ads_ad_title ver repeat_ver">Акции и скидки Беларуси</div></div><div class="ads_ad_domain ver">6<span class="num_delim"> </span>700 участников</div><div class="ads_ad_photo_box ver promotion"><img class="ads_ad_photo ver" src="https://pp.vk.me/c622229/v622229295/37a8f/-AhQBPvmd9k.jpg"><div class="ads_ad_play ver unshown empty"></div><div class="ads_ad_play_app">Играть</div><div class="ads_ad_disclaimers_photo"></div></div><div class="ads_ad_description ver" style="display: none;"></div><div class="ads_ad_community_join" onmouseover="var linkElem=this; while(linkElem.nodeName!=='A')linkElem=linkElem.parentNode; this.setAttribute('href_old',linkElem.href); linkElem.href=linkElem.getAttribute('href_join');" onmouseout="var linkElem=this; while(linkElem.nodeName!=='A')linkElem=linkElem.parentNode; linkElem.href=this.getAttribute('href_old');">Вступить</div><div class="ads_ad_disclaimers_bottom"></div></div></div></div></div></div></a></div><div class="ads_ad_box ver repeat_ver size_site last" id="ads_ad_box_ad_620f1cccf9d1f80d"><div id="left_hidead_620f1cccf9d1f80d" class="left_hide_button" onmouseover="leftBlockOver(this);" onmouseout="leftBlockOut(this);" onclick="leftAdBlockClose('ad_620f1cccf9d1f80d', '/away.php?to=QhscGkJ5ClN5aQhURSBVCxRdWBJDcwMTSQVmRxteYx82JF4nJUMGVBZ1T0oOYFwsXg8tWlxfUB4lIHl2DghmOFM9OHQcenYgG0VdAUc2UCwJNVA0KxE0ckAXBwIlNgQdTywDGXwUDlw8PnQvKW9LBggHFAR0NUBJIQVeQgkudiQKeGFyQAoIKEs*MUUaFWkAGV1aZhwIYTxwbhIPJyogfhVffxA2N1BzICJmIUcWHVxEF3YSOnRBbiUoDiIwEH4RKgFUUR4uXQsYKEB9DQchSHoiClZCN1kQCUIcXSMteU86D0FJXQcUSW47XDoeIHUUDwwnHBI8F1QvCkglJAJHbBoAUgN1bVwBPAQHYBMichIBbkBDLQoZMGIDHEIxJVQKRFp4ABQ7TiE6MxIKBDIKfn4Mej8ZC19fNhYUEGhdDUokKgBzKwJIBT00DhUzCFQTKDo1QBUFbSEdCwRsVzQAAAUWanICL1oKIGBOBR14XRMOEHsLHBQ8a2o*XR4eJVJyMygWXk06EgMRFXktOmFPAB0qbQsyYFIICC8EQxQvX0dCCUAWSVk8OEwFElwnFFUTBAFdXBJ4XAgIGkwZUBUIZHwrDCIEAkIUDDRgBRg4AHxddV0hOW18AR5zSS95HnUaJRJWS1w1aAYad3xrLxZlH38VNl4OI1gvA1xHejsKTSQtCHAqCBcRQm45TzQ2KX9qGw44FW8FC34eKFcbKwNtBQ--'); return cancelEvent(event);"></div><div class="ads_ad_close_info" id="ads_ad_close_info_ad_620f1cccf9d1f80d"><div class="ads_ad_box_border repeat_ver last"></div><div class="ads_ad_close_info2"><div class="ads_ad_close_info3"><div class="ads_ad_close_info4"><div class="ads_ad_close_text">Данное объявление больше не будет Вам показываться.</div><div class="ads_ad_close_complain"><span class="ads_ad_close_complain_info">Если объявление содержит нарушения или ошибку, </span><span class="ads_ad_close_complain_link" onclick="reportAd(28169107, this);">сообщите нам.</span></div></div></div></div></div><div class="ads_ad_box_border repeat_ver last"></div><a class="ads_ad_box2 ver repeat_ver size_site last" id="ads_ad_box2_ad_620f1cccf9d1f80d" target="_blank" onmouseover="leftBlockOver('ad_620f1cccf9d1f80d');" onmouseout="leftBlockOut('ad_620f1cccf9d1f80d');" href="/away.php?to=QxscGkJ5ClN5aQhURScFURdUCRJCIgIcS1ZgRUxYOR82JF4nJUMGVBZ1T0oOYFwsXg8tWlxfUB4lIHl2DghmOFM9OHQcenYgG0VdAUc2UCwJNVA0KxE0ckAXBwIlNgQdTywDGXwUDlw8PnQvKW9LBggHFAR0NUBJIQVeQgkudiQKeGFyQAoIKEs*MUUaFWkAGV1aZhwIYTxwbhIPJyogfhVffxA2N1BzICJmIUcWHVxEF3YSOnRBbiUoDiIwEH4RKgFUUR4uXQsYKEB9DQchSHoiClZCN1kQCUIcXSMteU86D0FJXQcUSW47XDoeIHUUDwwnHBI8F1QvCkglJAJHbBoAUgN1bVwBPAQHYBMichIBbkBDLQoZMGIDHEIxJVQKRFp4ABQ7TiE6MxIKBDIKfn4Mej8ZC19fNhYUEGhdDUokKgBzKwJIBT00DhUzCFQTKDo1QBUFbSEdCwRsVzQAAAUWanICL1oKIGBOBR14XRMOEHsLHBQ8a2o*XR4eJVJyMygWXk06EgMRFXktOmFPAB0qbQsyYFIICC8EQxQvX0dCCUAWSVk8OEwFElwnFFUTBAFdXBJ4XAgIGkwZUBUIZHwrDCIEAkIUDDRgBRg4AHxddV0hOW18AR5zSS95HnUaJRJWS1w1aAYad3xrLxZlH38VNl4OI1gvA1xHejsKTSQtCHAqCBcRQm45TzQ2KX9qGw44FW8FC34eKFcbKwNtBQ--"><div class="ads_ad_box3 ver"><div class="ads_ad_box4 ver"><div class="ads_ad_box5 ver repeat_ver"><div class="ads_ad_box5_spacer ver repeat_ver size_site"></div><div class="ads_ad_box6 ver"><div class="ads_ad_text_box ver repeat_ver size_site"><div class="ads_ad_title_box ver repeat_ver"><div class="ads_ad_title_spacer1 ver repeat_ver"><div class="ads_ad_title_spacer2 ver repeat_ver"></div></div><div class="ads_ad_title ver repeat_ver">Делать деньги</div></div><div class="ads_ad_domain ver">Страница</div><div class="ads_ad_photo_box ver"><img class="ads_ad_photo ver" src="https://pp.vk.me/c626519/v626519169/d3ac/_ADCK1JeDyk.jpg"><div class="ads_ad_play ver unshown empty"></div><div class="ads_ad_play_app">Играть</div><div class="ads_ad_disclaimers_photo"></div></div><div class="ads_ad_description ver" style="display: none;"></div><div class="ads_ad_community_join" style="display: none;"></div><div class="ads_ad_disclaimers_bottom"></div><div class="ads_ad_age_restriction ">18+</div></div></div></div></div></div></a></div></div><div class="ads_ads_create_ad"><a class="ads_ads_create_ad_link" href="/ads?act=create_in_last_office">Создать объявление</a></div></div></div></div></div></div>
    </div>

    <div id="page_body" class="fl_r" style="width: 631px;">
      <div id="header_wrap2">
        <div id="header_wrap1">
          <div id="header" style="">
            <h1 id="title"><b id="profile_online_lv" class="fl_r">Online<b class="mob_onl profile_mob_onl unshown" id="profile_mobile_online" onmouseover="mobileOnlineTip(this, {mid: cur.oid, right: 1})" onclick="mobilePromo(); "></b></b> Александр Борохов</h1>
          </div>
        </div>
      </div>
      <div id="wrap_between"></div>
      <div id="wrap3"><div id="wrap2">
  <div id="wrap1">
    <div id="content"><div id="profile">

  <div class="narrow_column fl_l" id="profile_narrow">
    <div id="owner_photo_wrap">
  <div id="owner_photo_top_bubble_wrap">
  <div id="owner_photo_top_bubble">
    <div class="owner_photo_bubble_delete_wrap" onclick="Profile.deletePhoto()" onmouseover="showTooltip(this, {text: &quot;Удалить фотографию&quot;, black: 1, shift: [11, 1, 6]});">
      <div class="owner_photo_bubble_delete"></div>
    </div>
  </div>
</div>
  <div id="page_avatar"><a id="profile_photo_link" href="/photo1964550_387661682" onclick="return showPhoto('1964550_387661682', 'album1964550_0/rev', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c628431/v628431550/&quot;,&quot;x_&quot;:[&quot;1e5eb/jk96QYwdyus&quot;,604,403],&quot;y_&quot;:[&quot;1e5ec/9Bw6cmLW8U0&quot;,807,538],&quot;z_&quot;:[&quot;1e5ed/-s3UTvKas5k&quot;,1280,853]}, jumpTo: {z: 'albums1964550'}}, event)"><img src="https://pp.vk.me/c628431/v628431550/402b9/fquPPMamBtE.jpg" alt="Александр Alejano Borhez Борохов" height="269" width="200"></a></div>
  <div id="owner_photo_bubble_wrap">
    <div id="owner_photo_bubble"><div class="owner_photo_bubble_action owner_photo_bubble_action_update" onclick="Page.ownerPhoto()">
  <span class="owner_photo_bubble_action_in">Загрузить новую фотографию</span>
</div><div class="owner_photo_bubble_action owner_photo_bubble_action_crop" onclick="Page.ownerCrop()">
  <span class="owner_photo_bubble_action_in">Изменить миниатюру</span>
</div></div>
  </div>
</div>
  <div id="profile_actions"><a id="profile_edit_act" href="edit">Редактировать страницу</a></div><div class="profile_top_sep"></div><div id="profile_counts" class="counts_module"><div><a class="photos" onclick="return showPhotoTags(1964550, {noHistory: true}, event);" href="/tag1964550"><span class="fl_r thumb"></span><span class="fl_r">67</span>Фотографии со мной</a></div><div><a class="videos" onclick="return nav.change({z: 'video_tag1964550'}, event)" href="/video?section=tagged&amp;id=1964550"><span class="fl_r thumb"></span><span class="fl_r">11</span>Видеозаписи со мной</a></div><div><a class="fans" onclick="return Profile.fansBox(1964550, event);" "=""><span class="fl_r thumb"></span><span class="fl_r">225</span>Мои подписчики</a></div><div><a class="gifts" onclick="return Profile.giftsBox(1964550, event);" href="/gifts1964550"><span class="fl_r thumb"></span><span class="fl_r">3</span>Мои подарки</a></div></div><div class="rate_empty_line"></div><div class="module clear people_module" id="profile_friends">
  <a href="/friends?id=1964550&amp;section=all" onclick="return nav.go(this, event, {noback: false})" class="module_header">
  <div class="header_top clear_fix">
    <span class="right_link fl_r" onmouseover="this.parentNode.parentNode.href='/feed?section=updates'" onmouseout="this.parentNode.parentNode.href='/friends?id=1964550&amp;section=all'">обновления</span>
    Друзья
  </div>
  <div class="p_header_bottom">
    <span class="fl_r"></span>
    611 друзей
  </div>
</a>
  <div class="module_body clear_fix">
    <div class="people_row">
<div class="fl_l people_cell">
  <a class="ava" href="/id4759338" onclick="return nav.go(this, event, {cl_id: 4759338})">
    <img src="https://pp.vk.me/c413720/v413720338/641/kUwBP2QbQVw.jpg" height="50" width="50">
  </a>
  <div class="name_field">
    <a href="/id4759338">
      Илья<br>
      <small>Лахмицкий</small>
    </a>
  </div>
</div><div class="fl_l people_cell">
  <a class="ava" href="/id22807011" onclick="return nav.go(this, event, {cl_id: 22807011})">
    <img src="https://pp.vk.me/c618819/v618819011/20ba1/iT4mS9yameQ.jpg" height="50" width="50">
  </a>
  <div class="name_field">
    <a href="/id22807011">
      Constantine<br>
      <small>Kovalchuk</small>
    </a>
  </div>
</div><div class="fl_l people_cell">
  <a class="ava" href="/boogaband" onclick="return nav.go(this, event, {cl_id: 109615447})">
    <img src="https://pp.vk.me/c630826/v630826447/3c3e2/CO8cLhvboyI.jpg" height="50" width="50">
  </a>
  <div class="name_field">
    <a href="/boogaband">
      Александр<br>
      <small>Буга</small>
    </a>
  </div>
</div>
</div><div class="people_row">
<div class="fl_l people_cell">
  <a class="ava" href="/dimon_romanuk" onclick="return nav.go(this, event, {cl_id: 18327434})">
    <img src="https://pp.vk.me/c629229/v629229434/3d819/WWtJuFQufgk.jpg" height="50" width="50">
  </a>
  <div class="name_field">
    <a href="/dimon_romanuk">
      Дмитрий<br>
      <small>Романюк</small>
    </a>
  </div>
</div><div class="fl_l people_cell">
  <a class="ava" href="/sozzz" onclick="return nav.go(this, event, {cl_id: 16127000})">
    <img src="https://pp.vk.me/c11354/u16127000/e_0599bede.jpg" height="50" width="50">
  </a>
  <div class="name_field">
    <a href="/sozzz">
      Дмитрий<br>
      <small>Созанович</small>
    </a>
  </div>
</div><div class="fl_l people_cell">
  <a class="ava" href="/id237531064" onclick="return nav.go(this, event, {cl_id: 237531064})">
    <img src="https://pp.vk.me/c636319/v636319064/53f9/jGTluMzdmPc.jpg" height="50" width="50">
  </a>
  <div class="name_field">
    <a href="/id237531064">
      Андрей<br>
      <small>Мазин</small>
    </a>
  </div>
</div>
</div><a href="/friends?id=1964550&amp;section=list28" class="p_header_bottom p_sub_header">
  5 лучших друзей
</a><div class="people_row">
<div class="fl_l people_cell">
  <a class="ava" href="/id10402125" onclick="return nav.go(this, event, {cl_id: 0})">
    <img src="https://pp.vk.me/c636227/v636227125/be48/z6fIHHBx-b4.jpg" height="50" width="50">
  </a>
  <div class="name_field">
    <a href="/id10402125">
      Кристина<br>
      <small></small>
    </a>
  </div>
</div><div class="fl_l people_cell">
  <a class="ava" href="/prikol1985" onclick="return nav.go(this, event, {cl_id: 0})">
    <img src="https://pp.vk.me/c636530/v636530236/4796/eawdC_M-7GI.jpg" height="50" width="50">
  </a>
  <div class="name_field">
    <a href="/prikol1985">
      Сергей<br>
      <small></small>
    </a>
  </div>
</div><div class="fl_l people_cell">
  <a class="ava" href="/juli_kasper" onclick="return nav.go(this, event, {cl_id: 0})">
    <img src="https://pp.vk.me/c315427/v315427882/ddcd/C-V3m3msgDQ.jpg" height="50" width="50">
  </a>
  <div class="name_field">
    <a href="/juli_kasper">
      Юлия<br>
      <small></small>
    </a>
  </div>
</div>
</div><a href="/friends?id=1964550&amp;section=list29" class="p_header_bottom p_sub_header">
  9 родственников
</a><div class="people_row">
<div class="fl_l people_cell">
  <a class="ava" href="/dj_daew" onclick="return nav.go(this, event, {cl_id: 0})">
    <img src="https://pp.vk.me/c629225/v629225041/714e2/PJANumuotQY.jpg" height="50" width="50">
  </a>
  <div class="name_field">
    <a href="/dj_daew">
      Валентин<br>
      <small></small>
    </a>
  </div>
</div><div class="fl_l people_cell">
  <a class="ava" href="/id94282169" onclick="return nav.go(this, event, {cl_id: 0})">
    <img src="https://pp.vk.me/c313718/v313718169/649b/sqsqGzAsRmw.jpg" height="50" width="50">
  </a>
  <div class="name_field">
    <a href="/id94282169">
      Алла<br>
      <small></small>
    </a>
  </div>
</div><div class="fl_l people_cell">
  <a class="ava" href="/id131738995" onclick="return nav.go(this, event, {cl_id: 0})">
    <img src="https://pp.vk.me/c9530/u131738995/e_d3f7f443.jpg" height="50" width="50">
  </a>
  <div class="name_field">
    <a href="/id131738995">
      Леня<br>
      <small></small>
    </a>
  </div>
</div>
</div>
  </div>
</div><div class="module clear people_module" id="profile_friends">
  <a href="/friends?id=1964550&amp;section=online" onclick="return nav.go(this, event, {noback: false})" class="module_header">
  <div class="header_top clear_fix">
    <span class="right_link fl_r" onmouseover="this.parentNode.parentNode.href=''" onmouseout="this.parentNode.parentNode.href='/friends?id=1964550&amp;section=online'"></span>
    Друзья онлайн
  </div>
  <div class="p_header_bottom">
    <span class="fl_r"></span>
    71 друг
  </div>
</a>
  <div class="module_body clear_fix">
    <div class="people_row">
<div class="fl_l people_cell">
  <a class="ava" href="/icywelcome" onclick="return nav.go(this, event, {cl_id: 0})">
    <img src="https://pp.vk.me/c633629/v633629329/2eddc/p4vMj1Rh1cI.jpg" height="50" width="50">
  </a>
  <div class="name_field">
    <a href="/icywelcome">
      Галина<br>
      <small>Мороз</small>
    </a>
  </div>
</div><div class="fl_l people_cell">
  <a class="ava" href="/slavik_borovitsky" onclick="return nav.go(this, event, {cl_id: 0})">
    <img src="https://pp.vk.me/c619216/v619216089/1f7a1/uDGN1yRgNjY.jpg" height="50" width="50">
  </a>
  <div class="name_field">
    <a href="/slavik_borovitsky">
      Славик<br>
      <small>Боровицкий</small>
    </a>
  </div>
</div><div class="fl_l people_cell">
  <a class="ava" href="/blonda_83" onclick="return nav.go(this, event, {cl_id: 0})">
    <img src="https://pp.vk.me/c636917/v636917388/17c0b/0VpqOEo5Urc.jpg" height="50" width="50">
  </a>
  <div class="name_field">
    <a href="/blonda_83">
      Валерия<br>
      <small>Самарская</small>
    </a>
  </div>
</div>
</div><div class="people_row">
<div class="fl_l people_cell">
  <a class="ava" href="/id20798250" onclick="return nav.go(this, event, {cl_id: 0})">
    <img src="https://pp.vk.me/c11343/v11343250/29c7/TO41xwNCJmo.jpg" height="50" width="50">
  </a>
  <div class="name_field">
    <a href="/id20798250">
      Юрий<br>
      <small>Беляев</small>
    </a>
  </div>
</div><div class="fl_l people_cell">
  <a class="ava" href="/id142775112" onclick="return nav.go(this, event, {cl_id: 0})">
    <img src="https://pp.vk.me/c626216/v626216112/11878/dN1HcrTzjlU.jpg" height="50" width="50">
  </a>
  <div class="name_field">
    <a href="/id142775112">
      Оля<br>
      <small>Козинец</small>
    </a>
  </div>
</div><div class="fl_l people_cell">
  <a class="ava" href="/id8768599" onclick="return nav.go(this, event, {cl_id: 0})">
    <img src="https://pp.vk.me/c627617/v627617599/392e4/q7tXZLlh62U.jpg" height="50" width="50">
  </a>
  <div class="name_field">
    <a href="/id8768599">
      Лена<br>
      <small>Савенок</small>
    </a>
  </div>
</div>
</div>
  </div>
</div><div class="module clear page_list_module" id="profile_idols">
  <a href="" onclick="return Profile.idolsBox(1964550, event);" class="module_header">
  <div class="header_top clear_fix">
    <span class="right_link fl_r" onmouseover="this.parentNode.parentNode.href=''" onmouseout="this.parentNode.parentNode.href=''"></span>
    Интересные страницы
  </div>
  <div class="p_header_bottom">
    <span class="fl_r"></span>
    71 страница
  </div>
</a>
  <div class="module_body clear_fix">
    <div class="line_cell clear_fix">
  <div class="fl_l thumb">
    <a href="/teanews" onclick="return nav.go(this, event)"><img src="https://pp.vk.me/c622623/v622623004/758f/CaUj1iXHgzc.jpg"></a>
  </div>
  <div class="fl_l desc_info">
    <div class="group_name"><a href="/teanews" onclick="return nav.go(this, event)">Чай з малинавым варэннем</a></div>
    <div class="group_desc">Новости Беларуси</div>
  </div>
</div><div class="line_cell clear_fix">
  <div class="fl_l thumb">
    <a href="/coolmoments" onclick="return nav.go(this, event)"><img src="https://pp.vk.me/c633919/v633919953/23fb9/LgHZvZKG2Lw.jpg"></a>
  </div>
  <div class="fl_l desc_info">
    <div class="group_name"><a href="/coolmoments" onclick="return nav.go(this, event)">Лучший момент</a></div>
    <div class="group_desc">Герои кинолент.</div>
  </div>
</div><div class="line_cell clear_fix">
  <div class="fl_l thumb">
    <a href="/bestad" onclick="return nav.go(this, event)"><img src="https://pp.vk.me/c631724/v631724715/34e04/ebfOyDWJX-Y.jpg"></a>
  </div>
  <div class="fl_l desc_info">
    <div class="group_name"><a href="/bestad" onclick="return nav.go(this, event)">Шедевры рекламы</a></div>
    <div class="group_desc">like &amp; share</div>
  </div>
</div><div class="line_cell clear_fix">
  <div class="fl_l thumb">
    <a href="/dingo_motors" onclick="return nav.go(this, event)"><img src="https://pp.vk.me/c631523/v631523910/351ba/dMQsADiksNI.jpg"></a>
  </div>
  <div class="fl_l desc_info">
    <div class="group_name"><a href="/dingo_motors" onclick="return nav.go(this, event)">Динго Моторс | Контрактные двигатели</a></div>
    <div class="group_desc">Самый крупный и честный поставщик контрактных двигателей в Москве</div>
  </div>
</div><div class="line_cell clear_fix">
  <div class="fl_l thumb">
    <a href="/adme" onclick="return nav.go(this, event)"><img src="https://pp.vk.me/c633926/v633926108/ee2f/sAz8cHGENGk.jpg"></a>
  </div>
  <div class="fl_l desc_info">
    <div class="group_name"><a href="/adme" onclick="return nav.go(this, event)">AdMe.ru</a></div>
    <div class="group_desc">Вдохновение. Творчество. Позитив.</div>
  </div>
</div>
  </div>
</div><div class="module clear album_module" id="profile_albums">
  <a href="/albums1964550" onclick="return nav.go(this, event)" class="module_header">
  <div class="header_top clear_fix">
    <span class="right_link fl_r" onmouseover="this.parentNode.parentNode.href=''" onmouseout="this.parentNode.parentNode.href='/albums1964550'"></span>
    Фотоальбомы
  </div>
  <div class="p_header_bottom">
    <span class="fl_r"></span>
    7 альбомов
  </div>
</a>
  <div class="module_body clear_fix">
    <div class="fl_l clear_fix clear page_album_row" onmouseover="Page.albumOver(this, '1964550_171418045');" onmouseout="Page.albumOut(this, '1964550_171418045', true);">
  <a href="/album1964550_171418045" onclick="return nav.change({z: 'album1964550_171418045'}, event)" class="img_link">
    <img class="page_photo_thumb_big" src="https://pp.vk.me/c402627/v402627550/78c4/YluljdSrYuE.jpg">
    <div class="page_album_title_wrap">
      <div class="clear_fix" style="margin: 0px">
        <div class="page_album_title fl_l" title="Учительница первая моя">Учительница первая моя</div>
        <div class="page_album_camera">2</div>
      </div>
      <div class="page_album_description">в гостях на 70-летие</div>
    </div>
  </a>
  <a class="bg"></a>
</div><div class="fl_l clear_fix clear page_album_row" onmouseover="Page.albumOver(this, '1964550_95218353');" onmouseout="Page.albumOut(this, '1964550_95218353', true);">
  <a href="/album1964550_95218353" onclick="return nav.change({z: 'album1964550_95218353'}, event)" class="img_link">
    <img class="page_photo_thumb_big" src="https://pp.vk.me/c309518/v309518550/13c1/BG9atNPBQhk.jpg">
    <div class="page_album_title_wrap">
      <div class="clear_fix" style="margin: 0px">
        <div class="page_album_title fl_l" title="Д.М.Б.">Д.М.Б.</div>
        <div class="page_album_camera">9</div>
      </div>
      <div class="page_album_description">а он-то всё-таки неизбежен!!!</div>
    </div>
  </a>
  <a class="bg"></a>
</div>
  </div>
</div><div class="module clear video_module" id="profile_videos">
  <a href="/videos1964550?section=all" class="module_header">
  <div class="header_top clear_fix">
    <span class="right_link fl_r" onmouseover="this.parentNode.parentNode.href=''" onmouseout="this.parentNode.parentNode.href='/videos1964550?section=all'"></span>
    Видеозаписи
  </div>
  <div class="p_header_bottom">
    <span class="fl_r"></span>
    43 видеозаписи
  </div>
</a>
  <div class="module_body clear_fix">
    <div class="video_row fl_l">
<a class="video fl_l" href="video-460389_456239026" onclick="return showVideo('-460389_456239026', 'videos1964550', {autoplay: 1, module: 'profile_video_block', playlistId: '1964550_-2'}, event);">
  <div><span class="bg fl_r">3:44</span></div><div><span class="fl_r">3:44</span></div>
  <div class="page_video_play_icon"></div>
  <span class="page_video_thumb" style="background-image: url('https://pp.vk.me/c628321/v628321389/2e3a6/bdrpyD3GafI.jpg')"></span>
</a>
<div class="info clear"><a href="video-460389_456239026">Как выглядела схема?</a></div>
<div class="info"><small>4 мар в 9:29<span class="divide">|</span><a href="video-460389_456239026">312 комментариев</a></small></div>
</div><div class="video_row fl_l">
<a class="video fl_l" href="video-460389_456239024" onclick="return showVideo('-460389_456239024', 'videos1964550', {autoplay: 1, module: 'profile_video_block', playlistId: '1964550_-2'}, event);">
  <div><span class="bg fl_r">3:19</span></div><div><span class="fl_r">3:19</span></div>
  <div class="page_video_play_icon"></div>
  <span class="page_video_thumb" style="background-image: url('https://pp.vk.me/c633316/v633316389/1b790/9zmZIrxydLA.jpg')"></span>
</a>
<div class="info clear"><a href="video-460389_456239024">Vladimir Putin - Putin, Putout</a></div>
<div class="info"><small>4 мар в 9:29<span class="divide">|</span><a href="video-460389_456239024">365 комментариев</a></small></div>
</div>
  </div>
</div><div class="module clear audios_module own_audios" id="profile_audios">
  <a href="/audios1964550" onclick="return nav.go(this, event);" class="module_header">
  <div class="header_top clear_fix">
    <span class="right_link fl_r" onmouseover="this.parentNode.parentNode.href=''" onmouseout="this.parentNode.parentNode.href='/audios1964550'"></span>
    Аудиозаписи
  </div>
  <div class="p_header_bottom">
    <span class="fl_r"></span>
    27 аудиозаписей
  </div>
</a>
  <div class="module_body clear_fix">
    <div class="audio" id="audio1964550_437690392" onmouseover="addClass(this, 'over');" onmouseout="removeClass(this, 'over');">
  <a name="1964550_437690392"></a>
  <div class="area clear_fix" onclick="if (cur.cancelClick){ cur.cancelClick = false; return;} playAudioNew('1964550_437690392')">
    <table width="100%" cellpadding="0" cellspacing="0">
      <tbody><tr>
        <td>
          <div class="play_btn_wrap"><div class="play_new" id="play1964550_437690392"></div></div>
          <input id="audio_info1964550_437690392" value="https://cs9-10v4.vk.me/p17/5e8077d20018ef.mp3?extra=c3bYzv15Zau5k5NjaNz5UaW7hjRfAOCv5hnhcdB4oWVcOMr1TCHnK09kEKD__0SzLTjRhOqxXwuBITUQy8TqyC0Hz_w6OM90nfyaF486gWBlDOW0dpCg97Dt-TGFQ2cU_qGgi53I2ps,247" type="hidden">

        </td>
        <td class="info">
          <div class="title_wrap fl_l" onmouseover="setTitle(this)"><b onclick="event.cancelBubble = true;"><a href="/search?c[section]=audio&amp;c[q]=The%20Killers&amp;c[performer]=1" onclick="return nav.go(this, event);">The Killers</a></b> – <span class="title" id="title1964550_437690392">Human </span><span class="user" onclick="event.cancelBubble = true;"></span></div>
          <div class="actions" onclick="event.cancelBubble = true;">
            <div class="audio_add_wrap unshown fl_r" onmouseover="showTooltip(this, {text: 'Добавить в Мои Аудиозаписи', showdt: 0, black: 1, shift: [9, 4, 0]});" onclick="addAudio({el: this, from_wall: 1, aid: 437690392, oid: 1964550, hash: ''}); return cancelEvent(event);">
              <div class="audio_add"></div>
            </div>

          </div>
          <div class="duration fl_r" onmousedown="if (window.audioPlayer) audioPlayer.switchTimeFormat('1964550_437690392', event);" onclick="cancelEvent(event)">4:07</div>
        </td>
      </tr>
    </tbody></table>
    <div id="player1964550_437690392" class="player" ondragstart="return false;" onselectstart="return false;" onclick="event.cancelBubble = true;">
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tbody><tr>
          <td style="width: 100%;">
            <div id="audio_pr1964550_437690392" class="audio_pr" onmouseover="addClass(this, 'over'); if (cur.hideTipTO) clearTimeout(cur.hideTipTO);" onmouseout="removeClass(this, 'over'); cur.hideTipTO = setTimeout(hide.pbind('audio_tip_wrap'), 100);" onmousedown="addClass(this, 'down'); audioPlayer.prClick(event);" onmouseup="removeClass(this, 'down')">
              <div id="audio_white_line1964550_437690392" class="audio_white_line" onmousedown="audioPlayer.prClick(event);"></div>
              <div id="audio_back_line1964550_437690392" class="audio_back_line" onmousedown="audioPlayer.prClick(event);"><!-- --></div>
              <div id="audio_load_line1964550_437690392" class="audio_load_line" onmousedown="audioPlayer.prClick(event);"><!-- --></div>
              <div id="audio_pr_line1964550_437690392" class="audio_progress_line" onmousedown="audioPlayer.prClick(event);">
                <div id="audio_pr_slider1964550_437690392" class="audio_slider"><!-- --></div>
              </div>
            </div>
          </td>
          <td>
            <div id="audio_vol1964550_437690392" class="audio_vol" onmouseover="addClass(this, 'over')" onmouseout="removeClass(this, 'over'); removeClass(this, 'down')" onmousedown="addClass(this, 'down'); audioPlayer.volClick(event)" onmouseup="removeClass(this, 'down')">
              <div id="audio_vol_white_line1964550_437690392" class="audio_vol_white_line" onmousedown="audioPlayer.volClick(event);"><!-- --></div>
              <div id="audio_vol_back_line1964550_437690392" class="audio_load_line" onmousedown="audioPlayer.volClick(event);"><!-- --></div>
              <div id="audio_vol_line1964550_437690392" class="audio_progress_line" onmousedown="audioPlayer.volClick(event);">
                <div id="audio_vol_slider1964550_437690392" class="audio_slider" onmousedown="audioPlayer.volClick(event);"><!-- --></div>
              </div>
            </div>
          </td>
        </tr>
      </tbody></table>
    </div>
  </div>
</div><div class="audio" id="audio1964550_438583269" onmouseover="addClass(this, 'over');" onmouseout="removeClass(this, 'over');">
  <a name="1964550_438583269"></a>
  <div class="area clear_fix" onclick="if (cur.cancelClick){ cur.cancelClick = false; return;} playAudioNew('1964550_438583269')">
    <table width="100%" cellpadding="0" cellspacing="0">
      <tbody><tr>
        <td>
          <div class="play_btn_wrap"><div class="play_new" id="play1964550_438583269"></div></div>
          <input id="audio_info1964550_438583269" value="https://psv4.vk.me/c6160/u99956365/audios/ce15e8e360f4.mp3?extra=3B_sojieOPFAtBNc6S7k1OXUXHTXXNzG_q3dr27ACHxJg9SLztuRCFbZioQvJ1_Ijf1Kq1BttanZbI6DrJHx4nnNmh12_7hX5aH7dCjrRLGjyUa3zXZigzwBD1kMeCaZEgbptytnZAo,4365" type="hidden">

        </td>
        <td class="info">
          <div class="title_wrap fl_l" onmouseover="setTitle(this)"><b onclick="event.cancelBubble = true;"><a href="/search?c[section]=audio&amp;c[q]=Zodiak%20Nice&amp;c[performer]=1" onclick="return nav.go(this, event);">Zodiak Nice</a></b> – <span class="title" id="title1964550_438583269">Telekollegen Podcast #13 </span><span class="user" onclick="event.cancelBubble = true;"></span></div>
          <div class="actions" onclick="event.cancelBubble = true;">
            <div class="audio_add_wrap unshown fl_r" onmouseover="showTooltip(this, {text: 'Добавить в Мои Аудиозаписи', showdt: 0, black: 1, shift: [9, 4, 0]});" onclick="addAudio({el: this, from_wall: 1, aid: 438583269, oid: 1964550, hash: ''}); return cancelEvent(event);">
              <div class="audio_add"></div>
            </div>

          </div>
          <div class="duration fl_r" onmousedown="if (window.audioPlayer) audioPlayer.switchTimeFormat('1964550_438583269', event);" onclick="cancelEvent(event)">1:12:45</div>
        </td>
      </tr>
    </tbody></table>
    <div id="player1964550_438583269" class="player" ondragstart="return false;" onselectstart="return false;" onclick="event.cancelBubble = true;">
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tbody><tr>
          <td style="width: 100%;">
            <div id="audio_pr1964550_438583269" class="audio_pr" onmouseover="addClass(this, 'over'); if (cur.hideTipTO) clearTimeout(cur.hideTipTO);" onmouseout="removeClass(this, 'over'); cur.hideTipTO = setTimeout(hide.pbind('audio_tip_wrap'), 100);" onmousedown="addClass(this, 'down'); audioPlayer.prClick(event);" onmouseup="removeClass(this, 'down')">
              <div id="audio_white_line1964550_438583269" class="audio_white_line" onmousedown="audioPlayer.prClick(event);"></div>
              <div id="audio_back_line1964550_438583269" class="audio_back_line" onmousedown="audioPlayer.prClick(event);"><!-- --></div>
              <div id="audio_load_line1964550_438583269" class="audio_load_line" onmousedown="audioPlayer.prClick(event);"><!-- --></div>
              <div id="audio_pr_line1964550_438583269" class="audio_progress_line" onmousedown="audioPlayer.prClick(event);">
                <div id="audio_pr_slider1964550_438583269" class="audio_slider"><!-- --></div>
              </div>
            </div>
          </td>
          <td>
            <div id="audio_vol1964550_438583269" class="audio_vol" onmouseover="addClass(this, 'over')" onmouseout="removeClass(this, 'over'); removeClass(this, 'down')" onmousedown="addClass(this, 'down'); audioPlayer.volClick(event)" onmouseup="removeClass(this, 'down')">
              <div id="audio_vol_white_line1964550_438583269" class="audio_vol_white_line" onmousedown="audioPlayer.volClick(event);"><!-- --></div>
              <div id="audio_vol_back_line1964550_438583269" class="audio_load_line" onmousedown="audioPlayer.volClick(event);"><!-- --></div>
              <div id="audio_vol_line1964550_438583269" class="audio_progress_line" onmousedown="audioPlayer.volClick(event);">
                <div id="audio_vol_slider1964550_438583269" class="audio_slider" onmousedown="audioPlayer.volClick(event);"><!-- --></div>
              </div>
            </div>
          </td>
        </tr>
      </tbody></table>
    </div>
  </div>
</div><div class="audio" id="audio1964550_434629344" onmouseover="addClass(this, 'over');" onmouseout="removeClass(this, 'over');">
  <a name="1964550_434629344"></a>
  <div class="area clear_fix" onclick="if (cur.cancelClick){ cur.cancelClick = false; return;} playAudioNew('1964550_434629344')">
    <table width="100%" cellpadding="0" cellspacing="0">
      <tbody><tr>
        <td>
          <div class="play_btn_wrap"><div class="play_new" id="play1964550_434629344"></div></div>
          <input id="audio_info1964550_434629344" value="https://cs9-12v4.vk.me/p21/3a492c658698e6.mp3?extra=te7iJDdMur4xvd86AYxbz5SQEGgqCaLFel9Tf9KE6-t-z8QqXeiNOJMKerjATndNkhLEWIz67F3We4XJdXU0UKbxJLPmPRFbFEasXgx6DN3QH4hy6bLeIZXaovRr3R8COzugaWp_1zo,229" type="hidden">

        </td>
        <td class="info">
          <div class="title_wrap fl_l" onmouseover="setTitle(this)"><b onclick="event.cancelBubble = true;"><a href="/search?c[section]=audio&amp;c[q]=Zodiak&amp;c[performer]=1" onclick="return nav.go(this, event);">Zodiak</a></b> – <span class="title" id="title1964550_434629344">В свете Сатурна  (1980)  </span><span class="user" onclick="event.cancelBubble = true;"></span></div>
          <div class="actions" onclick="event.cancelBubble = true;">
            <div class="audio_add_wrap unshown fl_r" onmouseover="showTooltip(this, {text: 'Добавить в Мои Аудиозаписи', showdt: 0, black: 1, shift: [9, 4, 0]});" onclick="addAudio({el: this, from_wall: 1, aid: 434629344, oid: 1964550, hash: ''}); return cancelEvent(event);">
              <div class="audio_add"></div>
            </div>

          </div>
          <div class="duration fl_r" onmousedown="if (window.audioPlayer) audioPlayer.switchTimeFormat('1964550_434629344', event);" onclick="cancelEvent(event)">3:49</div>
        </td>
      </tr>
    </tbody></table>
    <div id="player1964550_434629344" class="player" ondragstart="return false;" onselectstart="return false;" onclick="event.cancelBubble = true;">
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tbody><tr>
          <td style="width: 100%;">
            <div id="audio_pr1964550_434629344" class="audio_pr" onmouseover="addClass(this, 'over'); if (cur.hideTipTO) clearTimeout(cur.hideTipTO);" onmouseout="removeClass(this, 'over'); cur.hideTipTO = setTimeout(hide.pbind('audio_tip_wrap'), 100);" onmousedown="addClass(this, 'down'); audioPlayer.prClick(event);" onmouseup="removeClass(this, 'down')">
              <div id="audio_white_line1964550_434629344" class="audio_white_line" onmousedown="audioPlayer.prClick(event);"></div>
              <div id="audio_back_line1964550_434629344" class="audio_back_line" onmousedown="audioPlayer.prClick(event);"><!-- --></div>
              <div id="audio_load_line1964550_434629344" class="audio_load_line" onmousedown="audioPlayer.prClick(event);"><!-- --></div>
              <div id="audio_pr_line1964550_434629344" class="audio_progress_line" onmousedown="audioPlayer.prClick(event);">
                <div id="audio_pr_slider1964550_434629344" class="audio_slider"><!-- --></div>
              </div>
            </div>
          </td>
          <td>
            <div id="audio_vol1964550_434629344" class="audio_vol" onmouseover="addClass(this, 'over')" onmouseout="removeClass(this, 'over'); removeClass(this, 'down')" onmousedown="addClass(this, 'down'); audioPlayer.volClick(event)" onmouseup="removeClass(this, 'down')">
              <div id="audio_vol_white_line1964550_434629344" class="audio_vol_white_line" onmousedown="audioPlayer.volClick(event);"><!-- --></div>
              <div id="audio_vol_back_line1964550_434629344" class="audio_load_line" onmousedown="audioPlayer.volClick(event);"><!-- --></div>
              <div id="audio_vol_line1964550_434629344" class="audio_progress_line" onmousedown="audioPlayer.volClick(event);">
                <div id="audio_vol_slider1964550_434629344" class="audio_slider" onmousedown="audioPlayer.volClick(event);"><!-- --></div>
              </div>
            </div>
          </td>
        </tr>
      </tbody></table>
    </div>
  </div>
</div>
  </div>
</div><div class="module clear"><div class="module_body"><div id="profile_bottom_actions"><a href="/stats?mid=1964550" style="padding: 0; width: auto;"><div style="padding: 4px 6px;">Статистика страницы</div></a></div></div></div></div>
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
  <div class="clear_fix"><div id="page_wall_posts" class="wall_posts all"><input id="page_wall_count_all" value="692" type="hidden"><input id="page_wall_count_own" value="415" type="hidden"><div id="post1964550_2102" class="post all own post_copy post_online" onmouseover="wall.postOver('1964550_2102');" onmouseout="wall.postOut('1964550_2102');" onclick="wall.postClick('1964550_2102', event);" data-copy="-80011805_0">
  <div class="post_table">
    <div class="post_image">
      <a class="post_image" href="/borxezz"><img src="https://pp.vk.me/c628431/v628431550/402bd/2wBeRVUFE9U.jpg" data-post-id="1964550_2102" height="50" width="50"></a>
      <span class="online">Online</span>
    </div>
    <div class="post_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="post_delete1964550_2102" class="post_delete_button fl_r" onclick="wall.deletePost('1964550_2102', 'ff28d4add2916bb4b0');" onmouseover="wall.activeDeletePost('1964550_2102', 'Удалить запись', 'post_delete')" onmouseout="wall.deactiveDeletePost('1964550_2102', 'post_delete')"></div></div></div>
      <div class="wall_text"><div class="wall_text_name"><a class="author" href="/borxezz" data-from-id="1964550" data-post-id="1964550_2102">Александр Борохов</a></div> <div id="wpt1964550_2102"><div class="published_comment"><div class="wall_post_text">Наконец снова на пьедестале)) но жаль, что до кубка в этом сезоне не дотянули... Игра была потрясающая по накалу эмоций. Спасибо всем друзьям и по совместительству членам команды за игру!</div></div></div><div class="published_by_quote"><table class="published_by_wrap" cellpadding="0" cellspacing="0">
  <tbody><tr>
    <td>
      <a class="published_by_photo" href="/mozgoboj_bre"><img src="https://pp.vk.me/c633616/v633616661/f22b/f7XfQ2Ei2ss.jpg" height="30" width="30"></a>
    </td>
    <td>
      <div class="published_by_title"><a class="published_by" href="/mozgoboj_bre">МозгоБойня в Бресте</a> </div>
      <div class="published_by_date sm"><a class="published_by_date sm" href="/photo-80011805_415414525">фотография</a></div>
    </td>
  </tr>
</tbody></table><div class="page_post_queue_wide"><div class="page_post_sized_thumbs  clear_fix" style="width: 504px; height: 334px;"><a href="/photo-80011805_415414525" onclick="return showPhoto('-80011805_415414525', 'wall1964550_2102', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c626729/v626729370/&quot;,&quot;x_&quot;:[&quot;dafe/7oFZYg4dzj8&quot;,604,400],&quot;y_&quot;:[&quot;daff/_KQUnLdQdhI&quot;,807,534],&quot;z_&quot;:[&quot;db00/C0-SdB73O-8&quot;,1200,794]},queue:1}, event)" style="width: 504px; height: 334px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c626729/v626729370/dafe/7oFZYg4dzj8.jpg" style="" class="page_post_thumb_sized_photo" height="334" width="504"></a></div></div>
<div class="page_post_queue_narrow"><div class="page_post_sized_thumbs  clear_fix" style="width: 327px; height: 216px;"><a href="/photo-80011805_415414525" onclick="return showPhoto('-80011805_415414525', 'wall1964550_2102', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c626729/v626729370/&quot;,&quot;x_&quot;:[&quot;dafe/7oFZYg4dzj8&quot;,604,400],&quot;y_&quot;:[&quot;daff/_KQUnLdQdhI&quot;,807,534],&quot;z_&quot;:[&quot;db00/C0-SdB73O-8&quot;,1200,794]},queue:1}, event)" style="width: 327px; height: 216px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c626729/v626729370/dafe/7oFZYg4dzj8.jpg" style="" class="page_post_thumb_sized_photo" height="216" width="327"></a></div></div></div></div>
      <div class="post_full_like_wrap sm fl_r">
  <div class="post_full_like">
    <div class="post_like fl_r" onmouseover="wall.postLikeOver('1964550_2102')" onmouseout="wall.postLikeOut('1964550_2102')" onclick="wall.like('1964550_2102', 'eeea795eb989389487'); event.cancelBubble = true;">
      <span class="post_like_link fl_l" id="like_link1964550_2102">Мне нравится</span>
      <i class="post_like_icon sp_main  fl_l" id="like_icon1964550_2102"></i>
      <span class="post_like_count fl_l" id="like_count1964550_2102">15</span>
    </div>
    <div class="post_share fl_r " onmouseover="wall.postShareOver('1964550_2102')" onmouseout="wall.postShareOut('1964550_2102', event)" onclick="wall.likeShareCustom('1964550_2102'); event.cancelBubble = true;">
      <span class="post_share_link fl_l" id="share_link1964550_2102">Поделиться</span>
      <i class="post_share_icon sp_main fl_l" id="share_icon1964550_2102"></i>
      <span class="post_share_count fl_l" id="share_count1964550_2102">1</span>
    </div>
  </div>
</div>
      <div class="replies"><div class="reply_link_wrap sm" id="wpe_bottom1964550_2102">
  <small><a href="/wall1964550_2102" onclick="return showWiki({w: 'wall1964550_2102'}, false, event);"><span class="rel_date">22 мая в 23:23</span></a></small><span id="reply_link1964550_2102" class="reply_link"><span class="divide">|</span><a class="reply_link" onclick="return Wall.showEditReply('1964550_2102', event)">Комментировать</a></span>
</div>
<div class="replies_wrap clear" id="replies_wrap1964550_2102" style="display: none">
  <div id="replies1964550_2102"><input id="start_reply1964550_2102" value="" type="hidden"></div>
  <div class="reply_fakebox_wrap" id="reply_fakebox1964550_2102" onclick="return Wall.showEditReply('1964550_2102', event)"><div class="reply_fakebox">Комментировать..</div></div>
</div></div>
    </div>
  </div>

</div><div id="post1964550_2101" class="post all post_online" onmouseover="wall.postOver('1964550_2101');" onmouseout="wall.postOut('1964550_2101');" onclick="wall.postClick('1964550_2101', event);">
  <div class="post_table">
    <div class="post_image">
      <a class="post_image" href="/ostapkovi4_sergei"><img src="https://pp.vk.me/c630431/v630431715/39cc3/_8WtNLlMYCQ.jpg" data-post-id="1964550_2101" height="50" width="50"></a>
      <span class="online">Online<b class="mob_onl wall_mob_onl" onmouseover="mobileOnlineTip(this, {mid: 70668715})" onclick="mobilePromo(); "></b></span>
    </div>
    <div class="post_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="post_delete1964550_2101" class="post_delete_button fl_r" onclick="wall.deletePost('1964550_2101', '525329e32299e40d8a');" onmouseover="wall.activeDeletePost('1964550_2101', 'Удалить запись', 'post_delete')" onmouseout="wall.deactiveDeletePost('1964550_2101', 'post_delete')"></div></div></div>
      <div class="wall_text"><div class="wall_text_name"><a class="author" href="/ostapkovi4_sergei" data-from-id="70668715" data-post-id="70668715_2101">Сергей Остапкович</a></div> <div id="wpt1964550_2101"><div class="page_post_queue_wide"><div class="page_post_sized_thumbs  clear_fix" style="width: 500px; height: 340px;"><a onclick="return showPhoto('70668715_412354295', 'wall1964550_2101', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c626128/v626128567/&quot;,&quot;x_&quot;:[&quot;abcf/Kk3SCB3XSC4&quot;,604,410]},queue:1}, event)" style="width: 500px; height: 340px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c626128/v626128567/abcf/Kk3SCB3XSC4.jpg" style="" class="page_post_thumb_sized_photo" height="340" width="500"></a></div></div>
<div class="page_post_queue_narrow"><div class="page_post_sized_thumbs  clear_fix" style="width: 337px; height: 228px;"><a onclick="return showPhoto('70668715_412354295', 'wall1964550_2101', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c626128/v626128567/&quot;,&quot;x_&quot;:[&quot;abcf/Kk3SCB3XSC4&quot;,604,410]},queue:1}, event)" style="width: 337px; height: 228px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c626128/v626128567/abcf/Kk3SCB3XSC4.jpg" style="" class="page_post_thumb_sized_photo" height="228" width="337"></a></div></div></div></div>
      <div class="post_full_like_wrap sm fl_r">
  <div class="post_full_like">
    <div class="post_like fl_r" onmouseover="wall.postLikeOver('1964550_2101')" onmouseout="wall.postLikeOut('1964550_2101')" onclick="wall.like('1964550_2101', '012d6ce4596c6f7ef7'); event.cancelBubble = true;">
      <span class="post_like_link fl_l" id="like_link1964550_2101">Мне нравится</span>
      <i class="post_like_icon sp_main no_likes fl_l" id="like_icon1964550_2101"></i>
      <span class="post_like_count fl_l" id="like_count1964550_2101"></span>
    </div>
    <div class="post_share fl_r no_shares" onmouseover="wall.postShareOver('1964550_2101')" onmouseout="wall.postShareOut('1964550_2101', event)" onclick="wall.likeShareCustom('1964550_2101'); event.cancelBubble = true;">
      <span class="post_share_link fl_l" id="share_link1964550_2101">Поделиться</span>
      <i class="post_share_icon sp_main fl_l" id="share_icon1964550_2101"></i>
      <span class="post_share_count fl_l" id="share_count1964550_2101"></span>
    </div>
  </div>
</div>
      <div class="replies"><div class="reply_link_wrap sm" id="wpe_bottom1964550_2101">
  <small><a href="/wall1964550_2101" onclick="return showWiki({w: 'wall1964550_2101'}, false, event);"><span class="rel_date">1 мая в 13:36</span></a></small><span id="reply_link1964550_2101" class="reply_link"><span class="divide">|</span><a class="reply_link" onclick="return Wall.showEditReply('1964550_2101', event)">Комментировать</a></span>
</div>
<div class="replies_wrap clear" id="replies_wrap1964550_2101" style="display: none">
  <div id="replies1964550_2101"><input id="start_reply1964550_2101" value="" type="hidden"></div>
  <div class="reply_fakebox_wrap" id="reply_fakebox1964550_2101" onclick="return Wall.showEditReply('1964550_2101', event)"><div class="reply_fakebox">Комментировать..</div></div>
</div></div>
    </div>
  </div>

</div><div id="post1964550_2086" class="post all own post_online" onmouseover="wall.postOver('1964550_2086');" onmouseout="wall.postOut('1964550_2086');" onclick="wall.postClick('1964550_2086', event);">
  <div class="post_table">
    <div class="post_image">
      <a class="post_image" href="/borxezz"><img src="https://pp.vk.me/c628431/v628431550/402bd/2wBeRVUFE9U.jpg" data-post-id="1964550_2086" height="50" width="50"></a>
      <span class="online">Online</span>
    </div>
    <div class="post_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="post_delete1964550_2086" class="post_delete_button fl_r" onclick="wall.deletePost('1964550_2086', '2d0e060dd895b99467');" onmouseover="wall.activeDeletePost('1964550_2086', 'Удалить запись', 'post_delete')" onmouseout="wall.deactiveDeletePost('1964550_2086', 'post_delete')"></div></div></div>
      <div class="wall_text"><div class="wall_text_name"><a class="author" href="/borxezz" data-from-id="1964550" data-post-id="1964550_2086">Александр Борохов</a> <span class="explain">обновил фотографию на странице:</span></div> <div id="wpt1964550_2086"><div class="page_post_queue_wide"><div class="page_post_sized_thumbs  clear_fix" style="width: 340px; height: 340px;"><a href="/photo1964550_404402598" onclick="return showPhoto('1964550_404402598', 'wall1964550_2086', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c608816/v608816550/&quot;,&quot;x_&quot;:[&quot;b9eb/4-dI7Ia0BpQ&quot;,604,604],&quot;y_&quot;:[&quot;b9ec/7ekw1yUAhBQ&quot;,640,640]},queue:1}, event)" style="width: 340px; height: 340px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c608816/v608816550/b9eb/4-dI7Ia0BpQ.jpg" style="" class="page_post_thumb_sized_photo" height="340" width="340"></a></div></div>
<div class="page_post_queue_narrow"><div class="page_post_sized_thumbs  clear_fix" style="width: 320px; height: 320px;"><a href="/photo1964550_404402598" onclick="return showPhoto('1964550_404402598', 'wall1964550_2086', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c608816/v608816550/&quot;,&quot;x_&quot;:[&quot;b9eb/4-dI7Ia0BpQ&quot;,604,604],&quot;y_&quot;:[&quot;b9ec/7ekw1yUAhBQ&quot;,640,640]},queue:1}, event)" style="width: 320px; height: 320px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c608816/v608816550/b9eb/4-dI7Ia0BpQ.jpg" style="" class="page_post_thumb_sized_photo" height="320" width="320"></a></div></div></div></div>
      <div class="post_full_like_wrap sm fl_r">
  <div class="post_full_like">
    <div class="post_like fl_r" onmouseover="wall.postLikeOver('1964550_2086')" onmouseout="wall.postLikeOut('1964550_2086')" onclick="wall.like('1964550_2086', '95b0d1dbac5523eea9'); event.cancelBubble = true;">
      <span class="post_like_link fl_l" id="like_link1964550_2086">Мне нравится</span>
      <i class="post_like_icon sp_main  fl_l" id="like_icon1964550_2086"></i>
      <span class="post_like_count fl_l" id="like_count1964550_2086">30</span>
    </div>
    <div class="post_share fl_r no_shares" onmouseover="wall.postShareOver('1964550_2086')" onmouseout="wall.postShareOut('1964550_2086', event)" onclick="wall.likeShareCustom('1964550_2086'); event.cancelBubble = true;">
      <span class="post_share_link fl_l" id="share_link1964550_2086">Поделиться</span>
      <i class="post_share_icon sp_main fl_l" id="share_icon1964550_2086"></i>
      <span class="post_share_count fl_l" id="share_count1964550_2086"></span>
    </div>
  </div>
</div>
      <div class="replies"><div class="reply_link_wrap sm" id="wpe_bottom1964550_2086">
  <small><a href="/wall1964550_2086" onclick="return showWiki({w: 'wall1964550_2086'}, false, event);"><span class="rel_date">23 фев в 17:18</span></a></small>
</div>
<div class="replies_wrap clear" id="replies_wrap1964550_2086" style="">
  <div id="replies1964550_2086"><a class="wr_header" onclick="return wall.showReplies('1964550_2086', false, false, event);" offs="3/8" href="/wall1964550_2086?offset=last&amp;f=replies">
  <div class="wrh_text" id="wrh_text1964550_2086">Показать все 8 комментариев</div>
  <div class="progress wrh_prg" id="wrh_prg1964550_2086"></div>
</a><input id="start_reply1964550_2086" value="2092" type="hidden"><div id="post1964550_2092" class="reply reply_dived clear  reply_replieable" onmouseover="wall.replyOver('1964550_2092')" onmouseout="wall.replyOut('1964550_2092')" onclick="Wall.replyClick('1964550_2086', 2092, event, 20492048)">
  <div class="reply_table">
    <a class="reply_image" href="/snow_petite_girlie">
      <img src="https://pp.vk.me/c633226/v633226048/3b02a/UR7APa5f_tI.jpg" class="reply_image" height="50" width="50">
    </a>
    <div class="reply_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="reply_delete1964550_2092" class="reply_delete_button fl_r" onclick="wall.deletePost('1964550_2092', '408b4d12f8a827bef5');" onmouseover="wall.activeDeletePost('1964550_2092', 'Удалить', 'reply_delete')" onmouseout="wall.deactiveDeletePost('1964550_2092', 'reply_delete')"></div></div></div>
      <div class="reply_text">
        <a class="author" href="/snow_petite_girlie" data-from-id="20492048">Ольга Протасевич</a> <div id="wpt1964550_2092"><div class="page_post_queue_wide"><div class="page_post_sized_thumbs  clear_fix" style="width: 132px; height: 98px;"><a onclick="return showPhoto('20492048_399555812', 'wall1964550_2092', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c630017/v630017934/&quot;,&quot;x_&quot;:[&quot;1989c/4rsFpYOJ5gE&quot;,500,369]},queue:1}, event)" style="width: 132px; height: 98px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c630017/v630017934/1989c/4rsFpYOJ5gE.jpg" style="" class="page_post_thumb_sized_photo" height="98" width="132"></a></div></div>
<div class="page_post_queue_narrow"><div class="page_post_sized_thumbs  clear_fix" style="width: 132px; height: 98px;"><a onclick="return showPhoto('20492048_399555812', 'wall1964550_2092', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c630017/v630017934/&quot;,&quot;x_&quot;:[&quot;1989c/4rsFpYOJ5gE&quot;,500,369]},queue:1}, event)" style="width: 132px; height: 98px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c630017/v630017934/1989c/4rsFpYOJ5gE.jpg" style="" class="page_post_thumb_sized_photo" height="98" width="132"></a></div></div></div>
      </div>
      <div class="info_footer sm" id="wpe_bottom1964550_2092">
        <div class="like_wrap fl_r" onclick="wall.like('1964550_wall_reply2092', '5f28df8bac64afc41f'); event.cancelBubble = true;" onmouseover="wall.likeOver('1964550_wall_reply2092')" onmouseout="wall.likeOut('1964550_wall_reply2092')">
  <span class="like_link fl_l" id="like_link1964550_wall_reply2092">Мне нравится</span>
  <i class="my_like fl_l" id="like_icon1964550_wall_reply2092"></i>
  <span class="like_count fl_l" id="like_count1964550_wall_reply2092">1</span>
</div>
        <a class="wd_lnk" href="/wall1964550_2086?reply=2092" onclick="return showWiki({w: 'wall1964550_2086', reply: '2092'}, false, event);"><span class="rel_date">23 фев в 20:57</span></a><span class="sdivide">|</span><a class="_reply_lnk">Ответить</a>
      </div>
    </div>
  </div>
</div><div id="post1964550_2093" class="reply reply_dived clear  reply_replieable" onmouseover="wall.replyOver('1964550_2093')" onmouseout="wall.replyOut('1964550_2093')" onclick="Wall.replyClick('1964550_2086', 2093, event, 87407042)">
  <div class="reply_table">
    <a class="reply_image" href="/id87407042">
      <img src="https://pp.vk.me/c633727/v633727042/2f91b/j8YYLb2FRlY.jpg" class="reply_image" height="50" width="50">
    </a>
    <div class="reply_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="reply_delete1964550_2093" class="reply_delete_button fl_r" onclick="wall.deletePost('1964550_2093', 'd32b0b2ea2ff80bc00');" onmouseover="wall.activeDeletePost('1964550_2093', 'Удалить', 'reply_delete')" onmouseout="wall.deactiveDeletePost('1964550_2093', 'reply_delete')"></div></div></div>
      <div class="reply_text">
        <a class="author" href="/id87407042" data-from-id="87407042">Александр Марецкий</a> <div id="wpt1964550_2093"><div class="wall_reply_text"><a class="wall_reply_greeting" href="/borxezz" onclick="return wall.showReply('1964550_2086', '1964550_2091')">Александр</a>, понял не буду.......)))))))))</div></div>
      </div>
      <div class="info_footer sm" id="wpe_bottom1964550_2093">
        <div class="like_wrap fl_r" onclick="wall.like('1964550_wall_reply2093', '576e6fb97e603014bd'); event.cancelBubble = true;" onmouseover="wall.likeOver('1964550_wall_reply2093')" onmouseout="wall.likeOut('1964550_wall_reply2093')">
  <span class="like_link fl_l" id="like_link1964550_wall_reply2093">Мне нравится</span>
  <i class="no_likes fl_l" id="like_icon1964550_wall_reply2093"></i>
  <span class="like_count fl_l" id="like_count1964550_wall_reply2093"></span>
</div>
        <a class="wd_lnk" href="/wall1964550_2086?reply=2093" onclick="return showWiki({w: 'wall1964550_2086', reply: '2093'}, false, event);"><span class="rel_date">23 фев в 21:01</span></a> <a href="/borxezz" class="reply_to" onclick="return wall.showReply('1964550_2086', '1964550_2091')" rid="1964550">Александру</a><span class="sdivide">|</span><a class="_reply_lnk">Ответить</a>
      </div>
    </div>
  </div>
</div><div id="post1964550_2094" class="reply reply_dived clear  reply_replieable" onmouseover="wall.replyOver('1964550_2094')" onmouseout="wall.replyOut('1964550_2094')" onclick="Wall.replyClick('1964550_2086', 2094, event, 1568882)">
  <div class="reply_table">
    <a class="reply_image" href="/juli_kasper">
      <img src="https://pp.vk.me/c315427/v315427882/ddcd/C-V3m3msgDQ.jpg" class="reply_image" height="50" width="50">
    </a>
    <div class="reply_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="reply_delete1964550_2094" class="reply_delete_button fl_r" onclick="wall.deletePost('1964550_2094', '118d5f4ef4d4d4affe');" onmouseover="wall.activeDeletePost('1964550_2094', 'Удалить', 'reply_delete')" onmouseout="wall.deactiveDeletePost('1964550_2094', 'reply_delete')"></div></div></div>
      <div class="reply_text">
        <a class="author" href="/juli_kasper" data-from-id="1568882">Юлия Борохова</a> <div id="wpt1964550_2094"><div class="wall_reply_text">Какой ты у меня юный!</div></div>
      </div>
      <div class="info_footer sm" id="wpe_bottom1964550_2094">
        <div class="like_wrap fl_r" onclick="wall.like('1964550_wall_reply2094', '17895c698822c51715'); event.cancelBubble = true;" onmouseover="wall.likeOver('1964550_wall_reply2094')" onmouseout="wall.likeOut('1964550_wall_reply2094')">
  <span class="like_link fl_l" id="like_link1964550_wall_reply2094">Мне нравится</span>
  <i class="my_like fl_l" id="like_icon1964550_wall_reply2094"></i>
  <span class="like_count fl_l" id="like_count1964550_wall_reply2094">1</span>
</div>
        <a class="wd_lnk" href="/wall1964550_2086?reply=2094" onclick="return showWiki({w: 'wall1964550_2086', reply: '2094'}, false, event);"><span class="rel_date">24 фев в 12:30</span></a><span class="sdivide">|</span><a class="_reply_lnk">Ответить</a>
      </div>
    </div>
  </div>
</div></div>
  <div class="reply_fakebox_wrap" id="reply_fakebox1964550_2086" onclick="return Wall.showEditReply('1964550_2086', event)"><div class="reply_fakebox">Комментировать..</div></div>
</div></div>
    </div>
  </div>

</div><div id="post1964550_2084" class="post all post_online" onmouseover="wall.postOver('1964550_2084');" onmouseout="wall.postOut('1964550_2084');" onclick="wall.postClick('1964550_2084', event);">
  <div class="post_table">
    <div class="post_image">
      <a class="post_image" href="/id145206310"><img src="https://pp.vk.me/c630019/v630019310/8bbd/zJ3m1UM_-pU.jpg" data-post-id="1964550_2084" height="50" width="50"></a>
      <span class="online">Online<b class="mob_onl wall_mob_onl" onmouseover="mobileOnlineTip(this, {mid: 145206310})" onclick="mobilePromo(); "></b></span>
    </div>
    <div class="post_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="post_delete1964550_2084" class="post_delete_button fl_r" onclick="wall.deletePost('1964550_2084', '043bd21f965fa8b6d9');" onmouseover="wall.activeDeletePost('1964550_2084', 'Удалить запись', 'post_delete')" onmouseout="wall.deactiveDeletePost('1964550_2084', 'post_delete')"></div></div></div>
      <div class="wall_text"><div class="wall_text_name"><a class="author" href="/id145206310" data-from-id="145206310" data-post-id="145206310_2084">Дарья Дудина</a></div> <div id="wpt1964550_2084"><div class="wall_post_text">Сашка! <br>С днем рождения! Всего самого-пресамого лучшего тебе, Юльке, Дашке и всем твоим любимым и близким людям! <br>Найти себя!<br>Пусть все получается легко и приносит удовольствие!</div><div class="page_post_queue_wide"><div class="page_post_sized_thumbs  clear_fix" style="width: 537px; height: 315px;"><a onclick="return showPhoto('145206310_404109468', 'wall1964550_2084', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c317222/v317222021/&quot;,&quot;x_&quot;:[&quot;794d/L_2yFBPqllM&quot;,604,355]},queue:1}, event)" style="width: 537px; height: 315px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c317222/v317222021/794d/L_2yFBPqllM.jpg" style="" class="page_post_thumb_sized_photo" height="315" width="537"></a></div></div>
<div class="page_post_queue_narrow"><div class="page_post_sized_thumbs  clear_fix" style="width: 337px; height: 198px;"><a onclick="return showPhoto('145206310_404109468', 'wall1964550_2084', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c317222/v317222021/&quot;,&quot;x_&quot;:[&quot;794d/L_2yFBPqllM&quot;,604,355]},queue:1}, event)" style="width: 337px; height: 198px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c317222/v317222021/794d/L_2yFBPqllM.jpg" style="" class="page_post_thumb_sized_photo" height="198" width="337"></a></div></div></div></div>
      <div class="post_full_like_wrap sm fl_r">
  <div class="post_full_like">
    <div class="post_like fl_r" onmouseover="wall.postLikeOver('1964550_2084')" onmouseout="wall.postLikeOut('1964550_2084')" onclick="wall.like('1964550_2084', 'c16affaee7d753add6'); event.cancelBubble = true;">
      <span class="post_like_link fl_l" id="like_link1964550_2084">Мне нравится</span>
      <i class="post_like_icon sp_main my_like fl_l" id="like_icon1964550_2084"></i>
      <span class="post_like_count fl_l" id="like_count1964550_2084">1</span>
    </div>
    <div class="post_share fl_r no_shares" onmouseover="wall.postShareOver('1964550_2084')" onmouseout="wall.postShareOut('1964550_2084', event)" onclick="wall.likeShareCustom('1964550_2084'); event.cancelBubble = true;">
      <span class="post_share_link fl_l" id="share_link1964550_2084">Поделиться</span>
      <i class="post_share_icon sp_main fl_l" id="share_icon1964550_2084"></i>
      <span class="post_share_count fl_l" id="share_count1964550_2084"></span>
    </div>
  </div>
</div>
      <div class="replies"><div class="reply_link_wrap sm" id="wpe_bottom1964550_2084">
  <small><a href="/wall1964550_2084" onclick="return showWiki({w: 'wall1964550_2084'}, false, event);"><span class="rel_date">15 фев в 23:04</span></a></small>
</div>
<div class="replies_wrap clear" id="replies_wrap1964550_2084" style="">
  <div id="replies1964550_2084"><input id="start_reply1964550_2084" value="2085" type="hidden"><div id="post1964550_2085" class="reply reply_dived clear  reply_replieable" onmouseover="wall.replyOver('1964550_2085')" onmouseout="wall.replyOut('1964550_2085')" onclick="Wall.replyClick('1964550_2084', 2085, event, 1964550)">
  <div class="reply_table">
    <a class="reply_image" href="/borxezz">
      <img src="https://pp.vk.me/c628431/v628431550/402bd/2wBeRVUFE9U.jpg" class="reply_image" height="50" width="50">
    </a>
    <div class="reply_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="reply_delete1964550_2085" class="reply_delete_button fl_r" onclick="wall.deletePost('1964550_2085', 'f87fe418b3a7a0f75a');" onmouseover="wall.activeDeletePost('1964550_2085', 'Удалить', 'reply_delete')" onmouseout="wall.deactiveDeletePost('1964550_2085', 'reply_delete')"></div></div></div>
      <div class="reply_text">
        <a class="author" href="/borxezz" data-from-id="1964550">Александр Борохов</a> <div id="wpt1964550_2085"><div class="wall_reply_text">Дашка, спасибо тебе огромное!!</div></div>
      </div>
      <div class="info_footer sm" id="wpe_bottom1964550_2085">
        <div class="like_wrap fl_r" onclick="wall.like('1964550_wall_reply2085', '7d63c78e97442f8484'); event.cancelBubble = true;" onmouseover="wall.likeOver('1964550_wall_reply2085')" onmouseout="wall.likeOut('1964550_wall_reply2085')">
  <span class="like_link fl_l" id="like_link1964550_wall_reply2085">Мне нравится</span>
  <i class="no_likes fl_l" id="like_icon1964550_wall_reply2085"></i>
  <span class="like_count fl_l" id="like_count1964550_wall_reply2085"></span>
</div>
        <a class="wd_lnk" href="/wall1964550_2084?reply=2085" onclick="return showWiki({w: 'wall1964550_2084', reply: '2085'}, false, event);"><span class="rel_date">15 фев в 23:28</span></a>
      </div>
    </div>
  </div>
</div></div>
  <div class="reply_fakebox_wrap" id="reply_fakebox1964550_2084" onclick="return Wall.showEditReply('1964550_2084', event)"><div class="reply_fakebox">Комментировать..</div></div>
</div></div>
    </div>
  </div>

</div><div id="post1964550_2081" class="post all" onmouseover="wall.postOver('1964550_2081');" onmouseout="wall.postOut('1964550_2081');" onclick="wall.postClick('1964550_2081', event);">
  <div class="post_table">
    <div class="post_image">
      <a class="post_image" href="/oleg.goncharenko"><img src="https://pp.vk.me/c629220/v629220947/1cf83/FoWGBjr59jc.jpg" data-post-id="1964550_2081" height="50" width="50"></a>

    </div>
    <div class="post_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="post_delete1964550_2081" class="post_delete_button fl_r" onclick="wall.deletePost('1964550_2081', '823afb58c346a51a4f');" onmouseover="wall.activeDeletePost('1964550_2081', 'Удалить запись', 'post_delete')" onmouseout="wall.deactiveDeletePost('1964550_2081', 'post_delete')"></div></div></div>
      <div class="wall_text"><div class="wall_text_name"><a class="author" href="/oleg.goncharenko" data-from-id="758947" data-post-id="758947_2081">Олег Гончаренко</a></div> <div id="wpt1964550_2081"><div class="wall_post_text">С Днем рождения, дружище!! Успехов, удачи, тепла и бодрячка! ;)</div></div></div>
      <div class="post_full_like_wrap sm fl_r">
  <div class="post_full_like">
    <div class="post_like fl_r" onmouseover="wall.postLikeOver('1964550_2081')" onmouseout="wall.postLikeOut('1964550_2081')" onclick="wall.like('1964550_2081', '5e5cbc0753d342ffd4'); event.cancelBubble = true;">
      <span class="post_like_link fl_l" id="like_link1964550_2081">Мне нравится</span>
      <i class="post_like_icon sp_main my_like fl_l" id="like_icon1964550_2081"></i>
      <span class="post_like_count fl_l" id="like_count1964550_2081">1</span>
    </div>
    <div class="post_share fl_r no_shares" onmouseover="wall.postShareOver('1964550_2081')" onmouseout="wall.postShareOut('1964550_2081', event)" onclick="wall.likeShareCustom('1964550_2081'); event.cancelBubble = true;">
      <span class="post_share_link fl_l" id="share_link1964550_2081">Поделиться</span>
      <i class="post_share_icon sp_main fl_l" id="share_icon1964550_2081"></i>
      <span class="post_share_count fl_l" id="share_count1964550_2081"></span>
    </div>
  </div>
</div>
      <div class="replies"><div class="reply_link_wrap sm" id="wpe_bottom1964550_2081">
  <small><a href="/wall1964550_2081" onclick="return showWiki({w: 'wall1964550_2081'}, false, event);"><span class="rel_date">15 фев в 17:47</span></a><a onmouseover="wall.postTooltip(this, '1964550_2081', {i: '-1', dark: 1})" href="/app3140623" class="wall_post_source_icon wall_post_source_iphone"></a></small>
</div>
<div class="replies_wrap clear" id="replies_wrap1964550_2081" style="">
  <div id="replies1964550_2081"><input id="start_reply1964550_2081" value="2082" type="hidden"><div id="post1964550_2082" class="reply reply_dived clear  reply_replieable" onmouseover="wall.replyOver('1964550_2082')" onmouseout="wall.replyOut('1964550_2082')" onclick="Wall.replyClick('1964550_2081', 2082, event, 1964550)">
  <div class="reply_table">
    <a class="reply_image" href="/borxezz">
      <img src="https://pp.vk.me/c628431/v628431550/402bd/2wBeRVUFE9U.jpg" class="reply_image" height="50" width="50">
    </a>
    <div class="reply_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="reply_delete1964550_2082" class="reply_delete_button fl_r" onclick="wall.deletePost('1964550_2082', 'a7e524e0572bee51b3');" onmouseover="wall.activeDeletePost('1964550_2082', 'Удалить', 'reply_delete')" onmouseout="wall.deactiveDeletePost('1964550_2082', 'reply_delete')"></div></div></div>
      <div class="reply_text">
        <a class="author" href="/borxezz" data-from-id="1964550">Александр Борохов</a> <div id="wpt1964550_2082"><div class="wall_reply_text">Спаси бобро!</div></div>
      </div>
      <div class="info_footer sm" id="wpe_bottom1964550_2082">
        <div class="like_wrap fl_r" onclick="wall.like('1964550_wall_reply2082', '5d73b791534a750acf'); event.cancelBubble = true;" onmouseover="wall.likeOver('1964550_wall_reply2082')" onmouseout="wall.likeOut('1964550_wall_reply2082')">
  <span class="like_link fl_l" id="like_link1964550_wall_reply2082">Мне нравится</span>
  <i class="no_likes fl_l" id="like_icon1964550_wall_reply2082"></i>
  <span class="like_count fl_l" id="like_count1964550_wall_reply2082"></span>
</div>
        <a class="wd_lnk" href="/wall1964550_2081?reply=2082" onclick="return showWiki({w: 'wall1964550_2081', reply: '2082'}, false, event);"><span class="rel_date">15 фев в 18:02</span></a>
      </div>
    </div>
  </div>
</div><div id="post1964550_2083" class="reply reply_dived clear  reply_replieable" onmouseover="wall.replyOver('1964550_2083')" onmouseout="wall.replyOut('1964550_2083')" onclick="Wall.replyClick('1964550_2081', 2083, event, 758947)">
  <div class="reply_table">
    <a class="reply_image" href="/oleg.goncharenko">
      <img src="https://pp.vk.me/c629220/v629220947/1cf83/FoWGBjr59jc.jpg" class="reply_image" height="50" width="50">
    </a>
    <div class="reply_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="reply_delete1964550_2083" class="reply_delete_button fl_r" onclick="wall.deletePost('1964550_2083', '3f7709b10cdd4bb665');" onmouseover="wall.activeDeletePost('1964550_2083', 'Удалить', 'reply_delete')" onmouseout="wall.deactiveDeletePost('1964550_2083', 'reply_delete')"></div></div></div>
      <div class="reply_text">
        <a class="author" href="/oleg.goncharenko" data-from-id="758947">Олег Гончаренко</a> <div id="wpt1964550_2083"><div class="wall_reply_text">Лови добро, бро!! ;)</div></div>
      </div>
      <div class="info_footer sm" id="wpe_bottom1964550_2083">
        <div class="like_wrap fl_r" onclick="wall.like('1964550_wall_reply2083', '0f70b1c50c2c336a54'); event.cancelBubble = true;" onmouseover="wall.likeOver('1964550_wall_reply2083')" onmouseout="wall.likeOut('1964550_wall_reply2083')">
  <span class="like_link fl_l" id="like_link1964550_wall_reply2083">Мне нравится</span>
  <i class="no_likes fl_l" id="like_icon1964550_wall_reply2083"></i>
  <span class="like_count fl_l" id="like_count1964550_wall_reply2083"></span>
</div>
        <a class="wd_lnk" href="/wall1964550_2081?reply=2083" onclick="return showWiki({w: 'wall1964550_2081', reply: '2083'}, false, event);"><span class="rel_date">15 фев в 18:03</span></a> <a href="/borxezz" class="reply_to" onclick="return wall.showReply('1964550_2081', '1964550_2082')" rid="1964550">Александру</a><span class="sdivide">|</span><a class="_reply_lnk">Ответить</a>
      </div>
    </div>
  </div>
</div></div>
  <div class="reply_fakebox_wrap" id="reply_fakebox1964550_2081" onclick="return Wall.showEditReply('1964550_2081', event)"><div class="reply_fakebox">Комментировать..</div></div>
</div></div>
    </div>
  </div>

</div><div id="post1964550_2080" class="post all" onmouseover="wall.postOver('1964550_2080');" onmouseout="wall.postOut('1964550_2080');" onclick="wall.postClick('1964550_2080', event);">
  <div class="post_table">
    <div class="post_image">
      <a class="post_image" href="/id9111869"><img src="https://pp.vk.me/c636826/v636826869/1f0fb/Gkz8jYaxY00.jpg" data-post-id="1964550_2080" height="50" width="50"></a>

    </div>
    <div class="post_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="post_delete1964550_2080" class="post_delete_button fl_r" onclick="wall.deletePost('1964550_2080', '3e269816d7887c9225');" onmouseover="wall.activeDeletePost('1964550_2080', 'Удалить запись', 'post_delete')" onmouseout="wall.deactiveDeletePost('1964550_2080', 'post_delete')"></div></div></div>
      <div class="wall_text"><div class="wall_text_name"><a class="author" href="/id9111869" data-from-id="9111869" data-post-id="9111869_2080">Анна Жогал</a></div> <div id="wpt1964550_2080"><div class="wall_post_text">С днем варенья!</div></div></div>
      <div class="post_full_like_wrap sm fl_r">
  <div class="post_full_like">
    <div class="post_like fl_r" onmouseover="wall.postLikeOver('1964550_2080')" onmouseout="wall.postLikeOut('1964550_2080')" onclick="wall.like('1964550_2080', '0a2bcf9b8aa29e8032'); event.cancelBubble = true;">
      <span class="post_like_link fl_l" id="like_link1964550_2080">Мне нравится</span>
      <i class="post_like_icon sp_main my_like fl_l" id="like_icon1964550_2080"></i>
      <span class="post_like_count fl_l" id="like_count1964550_2080">1</span>
    </div>
    <div class="post_share fl_r no_shares" onmouseover="wall.postShareOver('1964550_2080')" onmouseout="wall.postShareOut('1964550_2080', event)" onclick="wall.likeShareCustom('1964550_2080'); event.cancelBubble = true;">
      <span class="post_share_link fl_l" id="share_link1964550_2080">Поделиться</span>
      <i class="post_share_icon sp_main fl_l" id="share_icon1964550_2080"></i>
      <span class="post_share_count fl_l" id="share_count1964550_2080"></span>
    </div>
  </div>
</div>
      <div class="replies"><div class="reply_link_wrap sm" id="wpe_bottom1964550_2080">
  <small><a href="/wall1964550_2080" onclick="return showWiki({w: 'wall1964550_2080'}, false, event);"><span class="rel_date">15 фев в 16:35</span></a><a onmouseover="wall.postTooltip(this, '1964550_2080', {i: '-1', dark: 1})" href="/app3140623" class="wall_post_source_icon wall_post_source_iphone"></a></small><span id="reply_link1964550_2080" class="reply_link"><span class="divide">|</span><a class="reply_link" onclick="return Wall.showEditReply('1964550_2080', event)">Комментировать</a></span>
</div>
<div class="replies_wrap clear" id="replies_wrap1964550_2080" style="display: none">
  <div id="replies1964550_2080"><input id="start_reply1964550_2080" value="" type="hidden"></div>
  <div class="reply_fakebox_wrap" id="reply_fakebox1964550_2080" onclick="return Wall.showEditReply('1964550_2080', event)"><div class="reply_fakebox">Комментировать..</div></div>
</div></div>
    </div>
  </div>

</div><div id="post1964550_2078" class="post all" onmouseover="wall.postOver('1964550_2078');" onmouseout="wall.postOut('1964550_2078');" onclick="wall.postClick('1964550_2078', event);">
  <div class="post_table">
    <div class="post_image">
      <a class="post_image" href="/voicenet"><img src="https://pp.vk.me/c625327/v625327323/3769a/g76xT9TeJgo.jpg" data-post-id="1964550_2078" height="50" width="50"></a>

    </div>
    <div class="post_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="post_delete1964550_2078" class="post_delete_button fl_r" onclick="wall.deletePost('1964550_2078', '5e714da1d823b60fca');" onmouseover="wall.activeDeletePost('1964550_2078', 'Удалить запись', 'post_delete')" onmouseout="wall.deactiveDeletePost('1964550_2078', 'post_delete')"></div></div></div>
      <div class="wall_text"><div class="wall_text_name"><a class="author" href="/voicenet" data-from-id="45220323" data-post-id="45220323_2078">Олег Голос</a></div> <div id="wpt1964550_2078"><div class="wall_post_text">Крепкого здравия, Александр! Всех благ, достатка! <br>С ДНЕМ РОЖДЕНИЯ!)))</div></div></div>
      <div class="post_full_like_wrap sm fl_r">
  <div class="post_full_like">
    <div class="post_like fl_r" onmouseover="wall.postLikeOver('1964550_2078')" onmouseout="wall.postLikeOut('1964550_2078')" onclick="wall.like('1964550_2078', '75d6e580fb980d61c2'); event.cancelBubble = true;">
      <span class="post_like_link fl_l" id="like_link1964550_2078">Мне нравится</span>
      <i class="post_like_icon sp_main my_like fl_l" id="like_icon1964550_2078"></i>
      <span class="post_like_count fl_l" id="like_count1964550_2078">1</span>
    </div>
    <div class="post_share fl_r no_shares" onmouseover="wall.postShareOver('1964550_2078')" onmouseout="wall.postShareOut('1964550_2078', event)" onclick="wall.likeShareCustom('1964550_2078'); event.cancelBubble = true;">
      <span class="post_share_link fl_l" id="share_link1964550_2078">Поделиться</span>
      <i class="post_share_icon sp_main fl_l" id="share_icon1964550_2078"></i>
      <span class="post_share_count fl_l" id="share_count1964550_2078"></span>
    </div>
  </div>
</div>
      <div class="replies"><div class="reply_link_wrap sm" id="wpe_bottom1964550_2078">
  <small><a href="/wall1964550_2078" onclick="return showWiki({w: 'wall1964550_2078'}, false, event);"><span class="rel_date">15 фев в 15:46</span></a></small>
</div>
<div class="replies_wrap clear" id="replies_wrap1964550_2078" style="">
  <div id="replies1964550_2078"><input id="start_reply1964550_2078" value="2079" type="hidden"><div id="post1964550_2079" class="reply reply_dived clear  reply_replieable" onmouseover="wall.replyOver('1964550_2079')" onmouseout="wall.replyOut('1964550_2079')" onclick="Wall.replyClick('1964550_2078', 2079, event, 1964550)">
  <div class="reply_table">
    <a class="reply_image" href="/borxezz">
      <img src="https://pp.vk.me/c628431/v628431550/402bd/2wBeRVUFE9U.jpg" class="reply_image" height="50" width="50">
    </a>
    <div class="reply_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="reply_delete1964550_2079" class="reply_delete_button fl_r" onclick="wall.deletePost('1964550_2079', '1bc945cf9d6d5e825c');" onmouseover="wall.activeDeletePost('1964550_2079', 'Удалить', 'reply_delete')" onmouseout="wall.deactiveDeletePost('1964550_2079', 'reply_delete')"></div></div></div>
      <div class="reply_text">
        <a class="author" href="/borxezz" data-from-id="1964550">Александр Борохов</a> <div id="wpt1964550_2079"><div class="wall_reply_text">Благодарю!</div></div>
      </div>
      <div class="info_footer sm" id="wpe_bottom1964550_2079">
        <div class="like_wrap fl_r" onclick="wall.like('1964550_wall_reply2079', '126bc189bf822e2c6e'); event.cancelBubble = true;" onmouseover="wall.likeOver('1964550_wall_reply2079')" onmouseout="wall.likeOut('1964550_wall_reply2079')">
  <span class="like_link fl_l" id="like_link1964550_wall_reply2079">Мне нравится</span>
  <i class="no_likes fl_l" id="like_icon1964550_wall_reply2079"></i>
  <span class="like_count fl_l" id="like_count1964550_wall_reply2079"></span>
</div>
        <a class="wd_lnk" href="/wall1964550_2078?reply=2079" onclick="return showWiki({w: 'wall1964550_2078', reply: '2079'}, false, event);"><span class="rel_date">15 фев в 16:19</span></a>
      </div>
    </div>
  </div>
</div></div>
  <div class="reply_fakebox_wrap" id="reply_fakebox1964550_2078" onclick="return Wall.showEditReply('1964550_2078', event)"><div class="reply_fakebox">Комментировать..</div></div>
</div></div>
    </div>
  </div>

</div><div id="post1964550_2077" class="post all" onmouseover="wall.postOver('1964550_2077');" onmouseout="wall.postOut('1964550_2077');" onclick="wall.postClick('1964550_2077', event);">
  <div class="post_table">
    <div class="post_image">
      <a class="post_image" href="/beatboxdarvin"><img src="https://pp.vk.me/c623319/v623319320/5c9b3/GZG0djY7arU.jpg" data-post-id="1964550_2077" height="50" width="50"></a>

    </div>
    <div class="post_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="post_delete1964550_2077" class="post_delete_button fl_r" onclick="wall.deletePost('1964550_2077', '858944c9544c7a07f0');" onmouseover="wall.activeDeletePost('1964550_2077', 'Удалить запись', 'post_delete')" onmouseout="wall.deactiveDeletePost('1964550_2077', 'post_delete')"></div></div></div>
      <div class="wall_text"><div class="wall_text_name"><a class="author" href="/beatboxdarvin" data-from-id="27271320" data-post-id="27271320_2077">Сашка Насибянц</a></div> <div id="wpt1964550_2077"><div class="wall_post_text">С Днем Рождения)) Счастья  и только  счастья))</div></div></div>
      <div class="post_full_like_wrap sm fl_r">
  <div class="post_full_like">
    <div class="post_like fl_r" onmouseover="wall.postLikeOver('1964550_2077')" onmouseout="wall.postLikeOut('1964550_2077')" onclick="wall.like('1964550_2077', 'f7feccabe5dd49dfd4'); event.cancelBubble = true;">
      <span class="post_like_link fl_l" id="like_link1964550_2077">Мне нравится</span>
      <i class="post_like_icon sp_main my_like fl_l" id="like_icon1964550_2077"></i>
      <span class="post_like_count fl_l" id="like_count1964550_2077">1</span>
    </div>
    <div class="post_share fl_r no_shares" onmouseover="wall.postShareOver('1964550_2077')" onmouseout="wall.postShareOut('1964550_2077', event)" onclick="wall.likeShareCustom('1964550_2077'); event.cancelBubble = true;">
      <span class="post_share_link fl_l" id="share_link1964550_2077">Поделиться</span>
      <i class="post_share_icon sp_main fl_l" id="share_icon1964550_2077"></i>
      <span class="post_share_count fl_l" id="share_count1964550_2077"></span>
    </div>
  </div>
</div>
      <div class="replies"><div class="reply_link_wrap sm" id="wpe_bottom1964550_2077">
  <small><a href="/wall1964550_2077" onclick="return showWiki({w: 'wall1964550_2077'}, false, event);"><span class="rel_date">15 фев в 15:17</span></a><a onmouseover="wall.postTooltip(this, '1964550_2077', {i: '-1'})" onclick="mobilePromo()" class="wall_post_source_icon wall_post_source_mobile"></a></small><span id="reply_link1964550_2077" class="reply_link"><span class="divide">|</span><a class="reply_link" onclick="return Wall.showEditReply('1964550_2077', event)">Комментировать</a></span>
</div>
<div class="replies_wrap clear" id="replies_wrap1964550_2077" style="display: none">
  <div id="replies1964550_2077"><input id="start_reply1964550_2077" value="" type="hidden"></div>
  <div class="reply_fakebox_wrap" id="reply_fakebox1964550_2077" onclick="return Wall.showEditReply('1964550_2077', event)"><div class="reply_fakebox">Комментировать..</div></div>
</div></div>
    </div>
  </div>

</div><div id="post1964550_2074" class="post all post_online" onmouseover="wall.postOver('1964550_2074');" onmouseout="wall.postOut('1964550_2074');" onclick="wall.postClick('1964550_2074', event);">
  <div class="post_table">
    <div class="post_image">
      <a class="post_image" href="/snow_petite_girlie"><img src="https://pp.vk.me/c633226/v633226048/3b02a/UR7APa5f_tI.jpg" data-post-id="1964550_2074" height="50" width="50"></a>
      <span class="online">Online</span>
    </div>
    <div class="post_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="post_delete1964550_2074" class="post_delete_button fl_r" onclick="wall.deletePost('1964550_2074', 'd7aa12792d82f448ea');" onmouseover="wall.activeDeletePost('1964550_2074', 'Удалить запись', 'post_delete')" onmouseout="wall.deactiveDeletePost('1964550_2074', 'post_delete')"></div></div></div>
      <div class="wall_text"><div class="wall_text_name"><a class="author" href="/snow_petite_girlie" data-from-id="20492048" data-post-id="20492048_2074">Ольга Протасевич</a></div> <div id="wpt1964550_2074"><div class="wall_post_text">С Днём РОЖДЕНИЯ!!))<img class="emoji" alt="🍸" src="/images/emoji/D83CDF78.png"><img class="emoji" alt="🎁" src="/images/emoji/D83CDF81.png"><img class="emoji" alt="🎂" src="/images/emoji/D83CDF82.png"><img class="emoji" alt="🎂" src="/images/emoji/D83CDF82.png"><img class="emoji" alt="🎂" src="/images/emoji/D83CDF82.png">) Александр , желаю тебе крепкого здоровья, семейного счастья),любви, !!! успехов на работе!!! пусть тебя преследует удача !<img class="emoji" alt="👻" src="/images/emoji/D83DDC7B.png"><img class="emoji" alt="🎊" src="/images/emoji/D83CDF8A.png"><img class="emoji" alt="🎉" src="/images/emoji/D83CDF89.png"><img class="emoji" alt="🎉" src="/images/emoji/D83CDF89.png"><img class="emoji" alt="🎉" src="/images/emoji/D83CDF89.png"><img class="emoji" alt="🎈" src="/images/emoji/D83CDF88.png"><img class="emoji" alt="🎈" src="/images/emoji/D83CDF88.png"><img class="emoji" alt="🎈" src="/images/emoji/D83CDF88.png"><img class="emoji" alt="🎈" src="/images/emoji/D83CDF88.png"><img class="emoji" alt="🎈" src="/images/emoji/D83CDF88.png"></div></div></div>
      <div class="post_full_like_wrap sm fl_r">
  <div class="post_full_like">
    <div class="post_like fl_r" onmouseover="wall.postLikeOver('1964550_2074')" onmouseout="wall.postLikeOut('1964550_2074')" onclick="wall.like('1964550_2074', 'ac1d851af4463b31c8'); event.cancelBubble = true;">
      <span class="post_like_link fl_l" id="like_link1964550_2074">Мне нравится</span>
      <i class="post_like_icon sp_main my_like fl_l" id="like_icon1964550_2074"></i>
      <span class="post_like_count fl_l" id="like_count1964550_2074">1</span>
    </div>
    <div class="post_share fl_r no_shares" onmouseover="wall.postShareOver('1964550_2074')" onmouseout="wall.postShareOut('1964550_2074', event)" onclick="wall.likeShareCustom('1964550_2074'); event.cancelBubble = true;">
      <span class="post_share_link fl_l" id="share_link1964550_2074">Поделиться</span>
      <i class="post_share_icon sp_main fl_l" id="share_icon1964550_2074"></i>
      <span class="post_share_count fl_l" id="share_count1964550_2074"></span>
    </div>
  </div>
</div>
      <div class="replies"><div class="reply_link_wrap sm" id="wpe_bottom1964550_2074">
  <small><a href="/wall1964550_2074" onclick="return showWiki({w: 'wall1964550_2074'}, false, event);"><span class="rel_date">15 фев в 14:32</span></a></small>
</div>
<div class="replies_wrap clear" id="replies_wrap1964550_2074" style="">
  <div id="replies1964550_2074"><input id="start_reply1964550_2074" value="2075" type="hidden"><div id="post1964550_2075" class="reply reply_dived clear  reply_replieable" onmouseover="wall.replyOver('1964550_2075')" onmouseout="wall.replyOut('1964550_2075')" onclick="Wall.replyClick('1964550_2074', 2075, event, 1964550)">
  <div class="reply_table">
    <a class="reply_image" href="/borxezz">
      <img src="https://pp.vk.me/c628431/v628431550/402bd/2wBeRVUFE9U.jpg" class="reply_image" height="50" width="50">
    </a>
    <div class="reply_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="reply_delete1964550_2075" class="reply_delete_button fl_r" onclick="wall.deletePost('1964550_2075', '3754709bf8ee6f2c49');" onmouseover="wall.activeDeletePost('1964550_2075', 'Удалить', 'reply_delete')" onmouseout="wall.deactiveDeletePost('1964550_2075', 'reply_delete')"></div></div></div>
      <div class="reply_text">
        <a class="author" href="/borxezz" data-from-id="1964550">Александр Борохов</a> <div id="wpt1964550_2075"><div class="wall_reply_text">Спасибо большое!</div></div>
      </div>
      <div class="info_footer sm" id="wpe_bottom1964550_2075">
        <div class="like_wrap fl_r" onclick="wall.like('1964550_wall_reply2075', '84cf8349abe0b5d720'); event.cancelBubble = true;" onmouseover="wall.likeOver('1964550_wall_reply2075')" onmouseout="wall.likeOut('1964550_wall_reply2075')">
  <span class="like_link fl_l" id="like_link1964550_wall_reply2075">Мне нравится</span>
  <i class=" fl_l" id="like_icon1964550_wall_reply2075"></i>
  <span class="like_count fl_l" id="like_count1964550_wall_reply2075">1</span>
</div>
        <a class="wd_lnk" href="/wall1964550_2074?reply=2075" onclick="return showWiki({w: 'wall1964550_2074', reply: '2075'}, false, event);"><span class="rel_date">15 фев в 14:51</span></a>
      </div>
    </div>
  </div>
</div></div>
  <div class="reply_fakebox_wrap" id="reply_fakebox1964550_2074" onclick="return Wall.showEditReply('1964550_2074', event)"><div class="reply_fakebox">Комментировать..</div></div>
</div></div>
    </div>
  </div>

</div><div id="post1964550_2069" class="post all" onmouseover="wall.postOver('1964550_2069');" onmouseout="wall.postOut('1964550_2069');" onclick="wall.postClick('1964550_2069', event);">
  <div class="post_table">
    <div class="post_image">
      <a class="post_image" href="/s.oneal"><img src="https://pp.vk.me/c409525/v409525674/b0e9/eUQ7uOtGDIE.jpg" data-post-id="1964550_2069" height="50" width="50"></a>

    </div>
    <div class="post_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="post_delete1964550_2069" class="post_delete_button fl_r" onclick="wall.deletePost('1964550_2069', '5590ad0435d2e80683');" onmouseover="wall.activeDeletePost('1964550_2069', 'Удалить запись', 'post_delete')" onmouseout="wall.deactiveDeletePost('1964550_2069', 'post_delete')"></div></div></div>
      <div class="wall_text"><div class="wall_text_name"><a class="author" href="/s.oneal" data-from-id="18682674" data-post-id="18682674_2069">Александр Александров</a></div> <div id="wpt1964550_2069"><div class="wall_post_text">С Днем Рождения!)) всего самого хорошего))</div></div></div>
      <div class="post_full_like_wrap sm fl_r">
  <div class="post_full_like">
    <div class="post_like fl_r" onmouseover="wall.postLikeOver('1964550_2069')" onmouseout="wall.postLikeOut('1964550_2069')" onclick="wall.like('1964550_2069', 'd55e4c256de08c6966'); event.cancelBubble = true;">
      <span class="post_like_link fl_l" id="like_link1964550_2069">Мне нравится</span>
      <i class="post_like_icon sp_main no_likes fl_l" id="like_icon1964550_2069"></i>
      <span class="post_like_count fl_l" id="like_count1964550_2069"></span>
    </div>
    <div class="post_share fl_r no_shares" onmouseover="wall.postShareOver('1964550_2069')" onmouseout="wall.postShareOut('1964550_2069', event)" onclick="wall.likeShareCustom('1964550_2069'); event.cancelBubble = true;">
      <span class="post_share_link fl_l" id="share_link1964550_2069">Поделиться</span>
      <i class="post_share_icon sp_main fl_l" id="share_icon1964550_2069"></i>
      <span class="post_share_count fl_l" id="share_count1964550_2069"></span>
    </div>
  </div>
</div>
      <div class="replies"><div class="reply_link_wrap sm" id="wpe_bottom1964550_2069">
  <small><a href="/wall1964550_2069" onclick="return showWiki({w: 'wall1964550_2069'}, false, event);"><span class="rel_date">15 фев в 11:36</span></a></small>
</div>
<div class="replies_wrap clear" id="replies_wrap1964550_2069" style="">
  <div id="replies1964550_2069"><input id="start_reply1964550_2069" value="2070" type="hidden"><div id="post1964550_2070" class="reply reply_dived clear  reply_replieable" onmouseover="wall.replyOver('1964550_2070')" onmouseout="wall.replyOut('1964550_2070')" onclick="Wall.replyClick('1964550_2069', 2070, event, 1964550)">
  <div class="reply_table">
    <a class="reply_image" href="/borxezz">
      <img src="https://pp.vk.me/c628431/v628431550/402bd/2wBeRVUFE9U.jpg" class="reply_image" height="50" width="50">
    </a>
    <div class="reply_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="reply_delete1964550_2070" class="reply_delete_button fl_r" onclick="wall.deletePost('1964550_2070', '3e39955df5100f3e94');" onmouseover="wall.activeDeletePost('1964550_2070', 'Удалить', 'reply_delete')" onmouseout="wall.deactiveDeletePost('1964550_2070', 'reply_delete')"></div></div></div>
      <div class="reply_text">
        <a class="author" href="/borxezz" data-from-id="1964550">Александр Борохов</a> <div id="wpt1964550_2070"><div class="wall_reply_text">Спасибо большое!</div></div>
      </div>
      <div class="info_footer sm" id="wpe_bottom1964550_2070">
        <div class="like_wrap fl_r" onclick="wall.like('1964550_wall_reply2070', 'effbc6dee60bb337e2'); event.cancelBubble = true;" onmouseover="wall.likeOver('1964550_wall_reply2070')" onmouseout="wall.likeOut('1964550_wall_reply2070')">
  <span class="like_link fl_l" id="like_link1964550_wall_reply2070">Мне нравится</span>
  <i class="no_likes fl_l" id="like_icon1964550_wall_reply2070"></i>
  <span class="like_count fl_l" id="like_count1964550_wall_reply2070"></span>
</div>
        <a class="wd_lnk" href="/wall1964550_2069?reply=2070" onclick="return showWiki({w: 'wall1964550_2069', reply: '2070'}, false, event);"><span class="rel_date">15 фев в 11:48</span></a>
      </div>
    </div>
  </div>
</div></div>
  <div class="reply_fakebox_wrap" id="reply_fakebox1964550_2069" onclick="return Wall.showEditReply('1964550_2069', event)"><div class="reply_fakebox">Комментировать..</div></div>
</div></div>
    </div>
  </div>

</div><div id="post1964550_2059" class="post own post_online" onmouseover="wall.postOver('1964550_2059');" onmouseout="wall.postOut('1964550_2059');" onclick="wall.postClick('1964550_2059', event);">
  <div class="post_table">
    <div class="post_image">
      <a class="post_image" href="/borxezz"><img src="https://pp.vk.me/c628431/v628431550/402bd/2wBeRVUFE9U.jpg" data-post-id="1964550_2059" height="50" width="50"></a>
      <span class="online">Online</span>
    </div>
    <div class="post_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="post_delete1964550_2059" class="post_delete_button fl_r" onclick="wall.deletePost('1964550_2059', 'f5ed3527405b8186e5');" onmouseover="wall.activeDeletePost('1964550_2059', 'Удалить запись', 'post_delete')" onmouseout="wall.deactiveDeletePost('1964550_2059', 'post_delete')"></div></div></div>
      <div class="wall_text"><div class="wall_text_name"><a class="author" href="/borxezz" data-from-id="1964550" data-post-id="1964550_2059">Александр Борохов</a></div> <div id="wpt1964550_2059"><div class="wall_post_text">Диски <a href="/feed?section=search&amp;q=%23vossen">#vossen</a> добрались и до <a href="/feed?section=search&amp;q=%23%D0%B1%D1%80%D0%B5%D1%81%D1%82">#брест</a> <a href="/feed?section=search&amp;q=%23%D0%B0%D0%B2%D1%82%D0%BE%D1%81%D0%B5%D1%82%D1%8C">#автосеть</a> 22" @ Автосеть</div><div class="page_post_queue_wide"><div class="page_post_sized_thumbs  clear_fix" style="width: 340px; height: 340px;"><a href="/photo1964550_388917722" onclick="return showPhoto('1964550_388917722', 'wall1964550_2059', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c629105/v629105550/&quot;,&quot;x_&quot;:[&quot;1bf21/2UFwRWtnYSs&quot;,604,604],&quot;y_&quot;:[&quot;1bf22/xDvA-3XJJIs&quot;,807,807],&quot;z_&quot;:[&quot;1bf23/QxcnPeWje24&quot;,1080,1080]},queue:1}, event)" style="width: 340px; height: 340px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c629105/v629105550/1bf21/2UFwRWtnYSs.jpg" style="" class="page_post_thumb_sized_photo" height="340" width="340"></a></div></div>
<div class="page_post_queue_narrow"><div class="page_post_sized_thumbs  clear_fix" style="width: 320px; height: 320px;"><a href="/photo1964550_388917722" onclick="return showPhoto('1964550_388917722', 'wall1964550_2059', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c629105/v629105550/&quot;,&quot;x_&quot;:[&quot;1bf21/2UFwRWtnYSs&quot;,604,604],&quot;y_&quot;:[&quot;1bf22/xDvA-3XJJIs&quot;,807,807],&quot;z_&quot;:[&quot;1bf23/QxcnPeWje24&quot;,1080,1080]},queue:1}, event)" style="width: 320px; height: 320px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c629105/v629105550/1bf21/2UFwRWtnYSs.jpg" style="" class="page_post_thumb_sized_photo" height="320" width="320"></a></div></div><div class="media_desc">
  <div class="page_media_place page_media_place__no_img clear_fix" id="post_media_lnk1964550_2059_-3">

    <div class="clear_fix"><a onclick="return showBox('al_places.php', {act: 'show_photo_place', geohash: '8ZCjRRVh', from_wall: 1}, {cache: 1});" class="page_media_place_label_inline">Трудовая улица, Брест</a></div>
  </div>
</div></div></div>
      <div class="post_full_like_wrap sm fl_r">
  <div class="post_full_like">
    <div class="post_like fl_r" onmouseover="wall.postLikeOver('1964550_2059')" onmouseout="wall.postLikeOut('1964550_2059')" onclick="wall.like('1964550_2059', 'a26320029daac0873c'); event.cancelBubble = true;">
      <span class="post_like_link fl_l" id="like_link1964550_2059">Мне нравится</span>
      <i class="post_like_icon sp_main  fl_l" id="like_icon1964550_2059"></i>
      <span class="post_like_count fl_l" id="like_count1964550_2059">11</span>
    </div>
    <div class="post_share fl_r no_shares" onmouseover="wall.postShareOver('1964550_2059')" onmouseout="wall.postShareOut('1964550_2059', event)" onclick="wall.likeShareCustom('1964550_2059'); event.cancelBubble = true;">
      <span class="post_share_link fl_l" id="share_link1964550_2059">Поделиться</span>
      <i class="post_share_icon sp_main fl_l" id="share_icon1964550_2059"></i>
      <span class="post_share_count fl_l" id="share_count1964550_2059"></span>
    </div>
  </div>
</div>
      <div class="replies"><div class="reply_link_wrap sm" id="wpe_bottom1964550_2059">
  <small><a href="/wall1964550_2059" onclick="return showWiki({w: 'wall1964550_2059'}, false, event);"><span class="rel_date">6 ноя 2015</span></a><a onmouseover="wall.postTooltip(this, '1964550_2059', {i: '-1', dark: 1})" href="/away.php?to=https%3A%2F%2Finstagram.com%2Fp%2F9vbn3WFHvz%2F" target="_blank" class="wall_post_source_icon wall_post_source_instagram"></a></small>
</div>
<div class="replies_wrap clear" id="replies_wrap1964550_2059" style="">
  <div id="replies1964550_2059"><input id="start_reply1964550_2059" value="2060" type="hidden"><div id="post1964550_2060" class="reply reply_dived clear  reply_replieable" onmouseover="wall.replyOver('1964550_2060')" onmouseout="wall.replyOut('1964550_2060')" onclick="Wall.replyClick('1964550_2059', 2060, event, 3555283)">
  <div class="reply_table">
    <a class="reply_image" href="/i.slesar">
      <img src="https://pp.vk.me/c621828/v621828283/31ea3/EQ2dJeYAMr8.jpg" class="reply_image" height="50" width="50">
    </a>
    <div class="reply_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="reply_delete1964550_2060" class="reply_delete_button fl_r" onclick="wall.deletePost('1964550_2060', '352897817721710fb5');" onmouseover="wall.activeDeletePost('1964550_2060', 'Удалить', 'reply_delete')" onmouseout="wall.deactiveDeletePost('1964550_2060', 'reply_delete')"></div></div></div>
      <div class="reply_text">
        <a class="author" href="/i.slesar" data-from-id="3555283">Паша Слюсарь</a> <div id="wpt1964550_2060"><div class="wall_reply_text">Резину можно было уже и не одевать</div></div>
      </div>
      <div class="info_footer sm" id="wpe_bottom1964550_2060">
        <div class="like_wrap fl_r" onclick="wall.like('1964550_wall_reply2060', '2f534f1dcfc67f1b09'); event.cancelBubble = true;" onmouseover="wall.likeOver('1964550_wall_reply2060')" onmouseout="wall.likeOut('1964550_wall_reply2060')">
  <span class="like_link fl_l" id="like_link1964550_wall_reply2060">Мне нравится</span>
  <i class=" fl_l" id="like_icon1964550_wall_reply2060"></i>
  <span class="like_count fl_l" id="like_count1964550_wall_reply2060">1</span>
</div>
        <a class="wd_lnk" href="/wall1964550_2059?reply=2060" onclick="return showWiki({w: 'wall1964550_2059', reply: '2060'}, false, event);"><span class="rel_date">6 ноя 2015</span></a><span class="sdivide">|</span><a class="_reply_lnk">Ответить</a>
      </div>
    </div>
  </div>
</div><div id="post1964550_2061" class="reply reply_dived clear  reply_replieable" onmouseover="wall.replyOver('1964550_2061')" onmouseout="wall.replyOut('1964550_2061')" onclick="Wall.replyClick('1964550_2059', 2061, event, 1964550)">
  <div class="reply_table">
    <a class="reply_image" href="/borxezz">
      <img src="https://pp.vk.me/c628431/v628431550/402bd/2wBeRVUFE9U.jpg" class="reply_image" height="50" width="50">
    </a>
    <div class="reply_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="reply_delete1964550_2061" class="reply_delete_button fl_r" onclick="wall.deletePost('1964550_2061', '21111dcea8405191fc');" onmouseover="wall.activeDeletePost('1964550_2061', 'Удалить', 'reply_delete')" onmouseout="wall.deactiveDeletePost('1964550_2061', 'reply_delete')"></div></div></div>
      <div class="reply_text">
        <a class="author" href="/borxezz" data-from-id="1964550">Александр Борохов</a> <div id="wpt1964550_2061"><div class="wall_reply_text"><a class="wall_reply_greeting" href="/i.slesar" onclick="return wall.showReply('1964550_2059', '1964550_2060')">Паша</a>, это просто кожух, который защищает диск от абразивного воздействия асфальта</div></div>
      </div>
      <div class="info_footer sm" id="wpe_bottom1964550_2061">
        <div class="like_wrap fl_r" onclick="wall.like('1964550_wall_reply2061', 'ac6c910841e5db03fb'); event.cancelBubble = true;" onmouseover="wall.likeOver('1964550_wall_reply2061')" onmouseout="wall.likeOut('1964550_wall_reply2061')">
  <span class="like_link fl_l" id="like_link1964550_wall_reply2061">Мне нравится</span>
  <i class="no_likes fl_l" id="like_icon1964550_wall_reply2061"></i>
  <span class="like_count fl_l" id="like_count1964550_wall_reply2061"></span>
</div>
        <a class="wd_lnk" href="/wall1964550_2059?reply=2061" onclick="return showWiki({w: 'wall1964550_2059', reply: '2061'}, false, event);"><span class="rel_date">7 ноя 2015</span></a> <a href="/i.slesar" class="reply_to" onclick="return wall.showReply('1964550_2059', '1964550_2060')" rid="3555283">Паше</a>
      </div>
    </div>
  </div>
</div><div id="post1964550_2062" class="reply reply_dived clear  reply_replieable" onmouseover="wall.replyOver('1964550_2062')" onmouseout="wall.replyOut('1964550_2062')" onclick="Wall.replyClick('1964550_2059', 2062, event, 18327434)">
  <div class="reply_table">
    <a class="reply_image" href="/dimon_romanuk">
      <img src="https://pp.vk.me/c629229/v629229434/3d819/WWtJuFQufgk.jpg" class="reply_image" height="50" width="50">
    </a>
    <div class="reply_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="reply_delete1964550_2062" class="reply_delete_button fl_r" onclick="wall.deletePost('1964550_2062', '86775af7bec53fc350');" onmouseover="wall.activeDeletePost('1964550_2062', 'Удалить', 'reply_delete')" onmouseout="wall.deactiveDeletePost('1964550_2062', 'reply_delete')"></div></div></div>
      <div class="reply_text">
        <a class="author" href="/dimon_romanuk" data-from-id="18327434">Дмитрий Романюк</a> <div id="wpt1964550_2062"><div class="wall_reply_text">эфка ?</div></div>
      </div>
      <div class="info_footer sm" id="wpe_bottom1964550_2062">
        <div class="like_wrap fl_r" onclick="wall.like('1964550_wall_reply2062', '0da5d1961f1158b83a'); event.cancelBubble = true;" onmouseover="wall.likeOver('1964550_wall_reply2062')" onmouseout="wall.likeOut('1964550_wall_reply2062')">
  <span class="like_link fl_l" id="like_link1964550_wall_reply2062">Мне нравится</span>
  <i class="no_likes fl_l" id="like_icon1964550_wall_reply2062"></i>
  <span class="like_count fl_l" id="like_count1964550_wall_reply2062"></span>
</div>
        <a class="wd_lnk" href="/wall1964550_2059?reply=2062" onclick="return showWiki({w: 'wall1964550_2059', reply: '2062'}, false, event);"><span class="rel_date">8 ноя 2015</span></a><span class="sdivide">|</span><a class="_reply_lnk">Ответить</a>
      </div>
    </div>
  </div>
</div></div>
  <div class="reply_fakebox_wrap" id="reply_fakebox1964550_2059" onclick="return Wall.showEditReply('1964550_2059', event)"><div class="reply_fakebox">Комментировать..</div></div>
</div></div>
    </div>
  </div>

</div><div id="post1964550_2057" class="post own post_online" onmouseover="wall.postOver('1964550_2057');" onmouseout="wall.postOut('1964550_2057');" onclick="wall.postClick('1964550_2057', event);">
  <div class="post_table">
    <div class="post_image">
      <a class="post_image" href="/borxezz"><img src="https://pp.vk.me/c628431/v628431550/402bd/2wBeRVUFE9U.jpg" data-post-id="1964550_2057" height="50" width="50"></a>
      <span class="online">Online</span>
    </div>
    <div class="post_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="post_delete1964550_2057" class="post_delete_button fl_r" onclick="wall.deletePost('1964550_2057', '7e74cee29408a98a10');" onmouseover="wall.activeDeletePost('1964550_2057', 'Удалить запись', 'post_delete')" onmouseout="wall.deactiveDeletePost('1964550_2057', 'post_delete')"></div></div></div>
      <div class="wall_text"><div class="wall_text_name"><a class="author" href="/borxezz" data-from-id="1964550" data-post-id="1964550_2057">Александр Борохов</a> <span class="explain">обновил фотографию на странице:</span></div> <div id="wpt1964550_2057"><div class="page_post_queue_wide"><div class="page_post_sized_thumbs  clear_fix" style="width: 509px; height: 340px;"><a href="/photo1964550_387661682" onclick="return showPhoto('1964550_387661682', 'wall1964550_2057', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c628431/v628431550/&quot;,&quot;x_&quot;:[&quot;1e5eb/jk96QYwdyus&quot;,604,403],&quot;y_&quot;:[&quot;1e5ec/9Bw6cmLW8U0&quot;,807,538],&quot;z_&quot;:[&quot;1e5ed/-s3UTvKas5k&quot;,1280,853]},queue:1}, event)" style="width: 509px; height: 340px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c628431/v628431550/1e5eb/jk96QYwdyus.jpg" style="" class="page_post_thumb_sized_photo" height="340" width="509"></a></div></div>
<div class="page_post_queue_narrow"><div class="page_post_sized_thumbs  clear_fix" style="width: 337px; height: 224px;"><a href="/photo1964550_387661682" onclick="return showPhoto('1964550_387661682', 'wall1964550_2057', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c628431/v628431550/&quot;,&quot;x_&quot;:[&quot;1e5eb/jk96QYwdyus&quot;,604,403],&quot;y_&quot;:[&quot;1e5ec/9Bw6cmLW8U0&quot;,807,538],&quot;z_&quot;:[&quot;1e5ed/-s3UTvKas5k&quot;,1280,853]},queue:1}, event)" style="width: 337px; height: 224px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c628431/v628431550/1e5eb/jk96QYwdyus.jpg" style="" class="page_post_thumb_sized_photo" height="224" width="337"></a></div></div></div></div>
      <div class="post_full_like_wrap sm fl_r">
  <div class="post_full_like">
    <div class="post_like fl_r" onmouseover="wall.postLikeOver('1964550_2057')" onmouseout="wall.postLikeOut('1964550_2057')" onclick="wall.like('1964550_2057', '151fc673557707a58d'); event.cancelBubble = true;">
      <span class="post_like_link fl_l" id="like_link1964550_2057">Мне нравится</span>
      <i class="post_like_icon sp_main  fl_l" id="like_icon1964550_2057"></i>
      <span class="post_like_count fl_l" id="like_count1964550_2057">55</span>
    </div>
    <div class="post_share fl_r no_shares" onmouseover="wall.postShareOver('1964550_2057')" onmouseout="wall.postShareOut('1964550_2057', event)" onclick="wall.likeShareCustom('1964550_2057'); event.cancelBubble = true;">
      <span class="post_share_link fl_l" id="share_link1964550_2057">Поделиться</span>
      <i class="post_share_icon sp_main fl_l" id="share_icon1964550_2057"></i>
      <span class="post_share_count fl_l" id="share_count1964550_2057"></span>
    </div>
  </div>
</div>
      <div class="replies"><div class="reply_link_wrap sm" id="wpe_bottom1964550_2057">
  <small><a href="/wall1964550_2057" onclick="return showWiki({w: 'wall1964550_2057'}, false, event);"><span class="rel_date">27 окт 2015</span></a></small>
</div>
<div class="replies_wrap clear" id="replies_wrap1964550_2057" style="">
  <div id="replies1964550_2057"><input id="start_reply1964550_2057" value="2100" type="hidden"><div id="post1964550_2100" class="reply reply_dived clear  reply_replieable" onmouseover="wall.replyOver('1964550_2100')" onmouseout="wall.replyOut('1964550_2100')" onclick="Wall.replyClick('1964550_2057', 2100, event, 125129979)">
  <div class="reply_table">
    <a class="reply_image" href="/mama_xu">
      <img src="https://pp.vk.me/c615718/v615718979/18c3b/fjOWfmWV9GI.jpg" class="reply_image" height="50" width="50">
    </a>
    <div class="reply_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="reply_delete1964550_2100" class="reply_delete_button fl_r" onclick="wall.deletePost('1964550_2100', '10b4d3fb96359f0e3a');" onmouseover="wall.activeDeletePost('1964550_2100', 'Удалить', 'reply_delete')" onmouseout="wall.deactiveDeletePost('1964550_2100', 'reply_delete')"></div></div></div>
      <div class="reply_text">
        <a class="author" href="/mama_xu" data-from-id="125129979">Ксения Жук</a> <div id="wpt1964550_2100"><div class="wall_reply_text">Красивые такие!!!!</div></div>
      </div>
      <div class="info_footer sm" id="wpe_bottom1964550_2100">
        <div class="like_wrap fl_r" onclick="wall.like('1964550_wall_reply2100', '883de8600c1a2f11db'); event.cancelBubble = true;" onmouseover="wall.likeOver('1964550_wall_reply2100')" onmouseout="wall.likeOut('1964550_wall_reply2100')">
  <span class="like_link fl_l" id="like_link1964550_wall_reply2100">Мне нравится</span>
  <i class="my_like fl_l" id="like_icon1964550_wall_reply2100"></i>
  <span class="like_count fl_l" id="like_count1964550_wall_reply2100">1</span>
</div>
        <a class="wd_lnk" href="/wall1964550_2057?reply=2100" onclick="return showWiki({w: 'wall1964550_2057', reply: '2100'}, false, event);"><span class="rel_date">9 апр в 16:43</span></a><span class="sdivide">|</span><a class="_reply_lnk">Ответить</a>
      </div>
    </div>
  </div>
</div></div>
  <div class="reply_fakebox_wrap" id="reply_fakebox1964550_2057" onclick="return Wall.showEditReply('1964550_2057', event)"><div class="reply_fakebox">Комментировать..</div></div>
</div></div>
    </div>
  </div>

</div><div id="post1964550_2056" class="post own post_copy post_online" onmouseover="wall.postOver('1964550_2056');" onmouseout="wall.postOut('1964550_2056');" onclick="wall.postClick('1964550_2056', event);" data-copy="1568882_0">
  <div class="post_table">
    <div class="post_image">
      <a class="post_image" href="/borxezz"><img src="https://pp.vk.me/c628431/v628431550/402bd/2wBeRVUFE9U.jpg" data-post-id="1964550_2056" height="50" width="50"></a>
      <span class="online">Online</span>
    </div>
    <div class="post_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="post_delete1964550_2056" class="post_delete_button fl_r" onclick="wall.deletePost('1964550_2056', '08afab9ff698c5fa66');" onmouseover="wall.activeDeletePost('1964550_2056', 'Удалить запись', 'post_delete')" onmouseout="wall.deactiveDeletePost('1964550_2056', 'post_delete')"></div></div></div>
      <div class="wall_text"><div class="wall_text_name"><a class="author" href="/borxezz" data-from-id="1964550" data-post-id="1964550_2056">Александр Борохов</a></div> <div id="wpt1964550_2056"><div class="published_comment"><div class="wall_post_text">Было замечательное лето))) Люблю своих девчёнок)</div></div></div><div class="published_by_quote"><table class="published_by_wrap" cellpadding="0" cellspacing="0">
  <tbody><tr>
    <td>
      <a class="published_by_photo" href="/juli_kasper"><img src="https://pp.vk.me/c315427/v315427882/ddcd/C-V3m3msgDQ.jpg" height="30" width="30"></a>
    </td>
    <td>
      <div class="published_by_title"><a class="published_by" href="/juli_kasper">Юлия Борохова</a> </div>
      <div class="published_by_date sm"><a class="published_by_date sm" href="/photo1568882_387784268">фотография</a></div>
    </td>
  </tr>
</tbody></table><div class="page_post_queue_wide"><div class="page_post_sized_thumbs  clear_fix" style="width: 500px; height: 334px;"><a href="/photo1568882_387784268" onclick="return showPhoto('1568882_387784268', 'wall1964550_2056', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c628518/v628518882/&quot;,&quot;x_&quot;:[&quot;19571/CpqzTxMyHdw&quot;,604,403],&quot;y_&quot;:[&quot;19572/q1FJIZiR7KA&quot;,807,538],&quot;z_&quot;:[&quot;19573/fqsSjcyvOrg&quot;,1280,853]},queue:1}, event)" style="width: 500px; height: 334px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c628518/v628518882/19571/CpqzTxMyHdw.jpg" style="" class="page_post_thumb_sized_photo" height="334" width="500"></a></div></div>
<div class="page_post_queue_narrow"><div class="page_post_sized_thumbs  clear_fix" style="width: 327px; height: 218px;"><a href="/photo1568882_387784268" onclick="return showPhoto('1568882_387784268', 'wall1964550_2056', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c628518/v628518882/&quot;,&quot;x_&quot;:[&quot;19571/CpqzTxMyHdw&quot;,604,403],&quot;y_&quot;:[&quot;19572/q1FJIZiR7KA&quot;,807,538],&quot;z_&quot;:[&quot;19573/fqsSjcyvOrg&quot;,1280,853]},queue:1}, event)" style="width: 327px; height: 218px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c628518/v628518882/19571/CpqzTxMyHdw.jpg" style="" class="page_post_thumb_sized_photo" height="218" width="327"></a></div></div></div></div>
      <div class="post_full_like_wrap sm fl_r">
  <div class="post_full_like">
    <div class="post_like fl_r" onmouseover="wall.postLikeOver('1964550_2056')" onmouseout="wall.postLikeOut('1964550_2056')" onclick="wall.like('1964550_2056', 'cc81bf2d1fd7c7103b'); event.cancelBubble = true;">
      <span class="post_like_link fl_l" id="like_link1964550_2056">Мне нравится</span>
      <i class="post_like_icon sp_main  fl_l" id="like_icon1964550_2056"></i>
      <span class="post_like_count fl_l" id="like_count1964550_2056">19</span>
    </div>
    <div class="post_share fl_r no_shares" onmouseover="wall.postShareOver('1964550_2056')" onmouseout="wall.postShareOut('1964550_2056', event)" onclick="wall.likeShareCustom('1964550_2056'); event.cancelBubble = true;">
      <span class="post_share_link fl_l" id="share_link1964550_2056">Поделиться</span>
      <i class="post_share_icon sp_main fl_l" id="share_icon1964550_2056"></i>
      <span class="post_share_count fl_l" id="share_count1964550_2056"></span>
    </div>
  </div>
</div>
      <div class="replies"><div class="reply_link_wrap sm" id="wpe_bottom1964550_2056">
  <small><a href="/wall1964550_2056" onclick="return showWiki({w: 'wall1964550_2056'}, false, event);"><span class="rel_date">25 окт 2015</span></a></small>
</div>
<div class="replies_wrap clear" id="replies_wrap1964550_2056" style="">
  <div id="replies1964550_2056"><input id="start_reply1964550_2056" value="2058" type="hidden"><div id="post1964550_2058" class="reply reply_dived clear  reply_replieable" onmouseover="wall.replyOver('1964550_2058')" onmouseout="wall.replyOut('1964550_2058')" onclick="Wall.replyClick('1964550_2056', 2058, event, 1568882)">
  <div class="reply_table">
    <a class="reply_image" href="/juli_kasper">
      <img src="https://pp.vk.me/c315427/v315427882/ddcd/C-V3m3msgDQ.jpg" class="reply_image" height="50" width="50">
    </a>
    <div class="reply_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="reply_delete1964550_2058" class="reply_delete_button fl_r" onclick="wall.deletePost('1964550_2058', '522fae1079f07191e8');" onmouseover="wall.activeDeletePost('1964550_2058', 'Удалить', 'reply_delete')" onmouseout="wall.deactiveDeletePost('1964550_2058', 'reply_delete')"></div></div></div>
      <div class="reply_text">
        <a class="author" href="/juli_kasper" data-from-id="1568882">Юлия Борохова</a> <div id="wpt1964550_2058"><div class="wall_reply_text"><img class="emoji_css" alt="❤" emoji="2764" style="background-position: 0px -442px;" src="/images/blank.gif"><img class="emoji_css" alt="❤" emoji="2764" style="background-position: 0px -442px;" src="/images/blank.gif"><img class="emoji_css" alt="❤" emoji="2764" style="background-position: 0px -442px;" src="/images/blank.gif"><img class="emoji_css" alt="❤" emoji="2764" style="background-position: 0px -442px;" src="/images/blank.gif"></div></div>
      </div>
      <div class="info_footer sm" id="wpe_bottom1964550_2058">
        <div class="like_wrap fl_r" onclick="wall.like('1964550_wall_reply2058', '06da7974499371cfda'); event.cancelBubble = true;" onmouseover="wall.likeOver('1964550_wall_reply2058')" onmouseout="wall.likeOut('1964550_wall_reply2058')">
  <span class="like_link fl_l" id="like_link1964550_wall_reply2058">Мне нравится</span>
  <i class="no_likes fl_l" id="like_icon1964550_wall_reply2058"></i>
  <span class="like_count fl_l" id="like_count1964550_wall_reply2058"></span>
</div>
        <a class="wd_lnk" href="/wall1964550_2056?reply=2058" onclick="return showWiki({w: 'wall1964550_2056', reply: '2058'}, false, event);"><span class="rel_date">28 окт 2015</span></a><span class="sdivide">|</span><a class="_reply_lnk">Ответить</a>
      </div>
    </div>
  </div>
</div></div>
  <div class="reply_fakebox_wrap" id="reply_fakebox1964550_2056" onclick="return Wall.showEditReply('1964550_2056', event)"><div class="reply_fakebox">Комментировать..</div></div>
</div></div>
    </div>
  </div>

</div><div id="post1964550_2053" class="post own post_online" onmouseover="wall.postOver('1964550_2053');" onmouseout="wall.postOut('1964550_2053');" onclick="wall.postClick('1964550_2053', event);">
  <div class="post_table">
    <div class="post_image">
      <a class="post_image" href="/borxezz"><img src="https://pp.vk.me/c628431/v628431550/402bd/2wBeRVUFE9U.jpg" data-post-id="1964550_2053" height="50" width="50"></a>
      <span class="online">Online</span>
    </div>
    <div class="post_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="post_delete1964550_2053" class="post_delete_button fl_r" onclick="wall.deletePost('1964550_2053', '2aba444f66202da8d9');" onmouseover="wall.activeDeletePost('1964550_2053', 'Удалить запись', 'post_delete')" onmouseout="wall.deactiveDeletePost('1964550_2053', 'post_delete')"></div></div></div>
      <div class="wall_text"><div class="wall_text_name"><a class="author" href="/borxezz" data-from-id="1964550" data-post-id="1964550_2053">Александр Борохов</a> <span class="explain">оставил комментарий на странице <a class="lnk" id="post_media_lnk1964550_2053_-1" href="/away.php?to=http%3A%2F%2Fwww.novoeradio.by%2Foffers%2Fvyigraj-zimnie-shiny-dlya-svoej-mashiny&amp;post=1964550_2053" target="_blank" onmouseover="wall.postTooltip(this, '1964550_2053', {i: -1})"><span class="a">Новое Радио | Акция Выиграй зимние ши..</span></a></span></div> <div id="wpt1964550_2053"><div class="wall_post_text">Ребят, ничего что на картинке - комплект летней резины? Потом подарите победителю не то</div><div class="media_desc media_desc__">
  <a class="lnk" id="post_media_lnk1964550_2053_-1" href="/away.php?to=http%3A%2F%2Fwww.novoeradio.by%2Foffers%2Fvyigraj-zimnie-shiny-dlya-svoej-mashiny&amp;post=1964550_2053" target="_blank" onmouseover="wall.postTooltip(this, '1964550_2053', {i: '-1'})">
    <b class="fl_l "></b>Ссылка
    <span class="a">Новое Радио | Акция Выиграй зимние ши..</span></a>
</div></div></div>
      <div class="post_full_like_wrap sm fl_r">
  <div class="post_full_like">
    <div class="post_like fl_r" onmouseover="wall.postLikeOver('1964550_2053')" onmouseout="wall.postLikeOut('1964550_2053')" onclick="wall.like('1964550_2053', 'ffcc8dc1624180cdc9'); event.cancelBubble = true;">
      <span class="post_like_link fl_l" id="like_link1964550_2053">Мне нравится</span>
      <i class="post_like_icon sp_main  fl_l" id="like_icon1964550_2053"></i>
      <span class="post_like_count fl_l" id="like_count1964550_2053">2</span>
    </div>
    <div class="post_share fl_r no_shares" onmouseover="wall.postShareOver('1964550_2053')" onmouseout="wall.postShareOut('1964550_2053', event)" onclick="wall.likeShareCustom('1964550_2053'); event.cancelBubble = true;">
      <span class="post_share_link fl_l" id="share_link1964550_2053">Поделиться</span>
      <i class="post_share_icon sp_main fl_l" id="share_icon1964550_2053"></i>
      <span class="post_share_count fl_l" id="share_count1964550_2053"></span>
    </div>
  </div>
</div>
      <div class="replies"><div class="reply_link_wrap sm" id="wpe_bottom1964550_2053">
  <small><a href="/wall1964550_2053" onclick="return showWiki({w: 'wall1964550_2053'}, false, event);"><span class="rel_date">22 окт 2015</span></a></small>
</div>
<div class="replies_wrap clear" id="replies_wrap1964550_2053" style="">
  <div id="replies1964550_2053"><input id="start_reply1964550_2053" value="2054" type="hidden"><div id="post1964550_2054" class="reply reply_dived clear  reply_replieable" onmouseover="wall.replyOver('1964550_2054')" onmouseout="wall.replyOut('1964550_2054')" onclick="Wall.replyClick('1964550_2053', 2054, event, 119208948)">
  <div class="reply_table">
    <a class="reply_image" href="/id119208948">
      <img src="https://pp.vk.me/c628017/v628017948/288/TMQKk545Uxk.jpg" class="reply_image" height="50" width="50">
    </a>
    <div class="reply_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="reply_delete1964550_2054" class="reply_delete_button fl_r" onclick="wall.deletePost('1964550_2054', 'c2757de2231166bcf3');" onmouseover="wall.activeDeletePost('1964550_2054', 'Удалить', 'reply_delete')" onmouseout="wall.deactiveDeletePost('1964550_2054', 'reply_delete')"></div></div></div>
      <div class="reply_text">
        <a class="author" href="/id119208948" data-from-id="119208948">Μаксим Μиронов</a> <div id="wpt1964550_2054"><div class="wall_reply_text">Александр<img class="emoji_css" alt="😊" emoji="D83DDE0A" style="background-position: 0px 0px;" src="/images/blank.gif">Просто картинка уж больно хороша)) А подарок подберем соответствующий<img class="emoji_css" alt="😉" emoji="D83DDE09" style="background-position: 0px -34px;" src="/images/blank.gif"></div></div>
      </div>
      <div class="info_footer sm" id="wpe_bottom1964550_2054">
        <div class="like_wrap fl_r" onclick="wall.like('1964550_wall_reply2054', 'e95cbed01a8e3e21fe'); event.cancelBubble = true;" onmouseover="wall.likeOver('1964550_wall_reply2054')" onmouseout="wall.likeOut('1964550_wall_reply2054')">
  <span class="like_link fl_l" id="like_link1964550_wall_reply2054">Мне нравится</span>
  <i class="no_likes fl_l" id="like_icon1964550_wall_reply2054"></i>
  <span class="like_count fl_l" id="like_count1964550_wall_reply2054"></span>
</div>
        <a class="wd_lnk" href="/wall1964550_2053?reply=2054" onclick="return showWiki({w: 'wall1964550_2053', reply: '2054'}, false, event);"><span class="rel_date">23 окт 2015</span></a><span class="sdivide">|</span><a class="_reply_lnk">Ответить</a>
      </div>
    </div>
  </div>
</div><div id="post1964550_2055" class="reply reply_dived clear  reply_replieable" onmouseover="wall.replyOver('1964550_2055')" onmouseout="wall.replyOut('1964550_2055')" onclick="Wall.replyClick('1964550_2053', 2055, event, 1964550)">
  <div class="reply_table">
    <a class="reply_image" href="/borxezz">
      <img src="https://pp.vk.me/c628431/v628431550/402bd/2wBeRVUFE9U.jpg" class="reply_image" height="50" width="50">
    </a>
    <div class="reply_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="reply_delete1964550_2055" class="reply_delete_button fl_r" onclick="wall.deletePost('1964550_2055', '90a7536f416fdca094');" onmouseover="wall.activeDeletePost('1964550_2055', 'Удалить', 'reply_delete')" onmouseout="wall.deactiveDeletePost('1964550_2055', 'reply_delete')"></div></div></div>
      <div class="reply_text">
        <a class="author" href="/borxezz" data-from-id="1964550">Александр Борохов</a> <div id="wpt1964550_2055"><div class="wall_reply_text"><a href="/id119208948" class="mem_link" mention="" mention_id="id119208948" onclick="return mentionClick(this, event)" onmouseover="mentionOver(this)">Новое</a>, обращайтесь, поможем с выбором)))</div></div>
      </div>
      <div class="info_footer sm" id="wpe_bottom1964550_2055">
        <div class="like_wrap fl_r" onclick="wall.like('1964550_wall_reply2055', '829264c690bac636d3'); event.cancelBubble = true;" onmouseover="wall.likeOver('1964550_wall_reply2055')" onmouseout="wall.likeOut('1964550_wall_reply2055')">
  <span class="like_link fl_l" id="like_link1964550_wall_reply2055">Мне нравится</span>
  <i class="no_likes fl_l" id="like_icon1964550_wall_reply2055"></i>
  <span class="like_count fl_l" id="like_count1964550_wall_reply2055"></span>
</div>
        <a class="wd_lnk" href="/wall1964550_2053?reply=2055" onclick="return showWiki({w: 'wall1964550_2053', reply: '2055'}, false, event);"><span class="rel_date">23 окт 2015</span></a> <a href="/id119208948" class="reply_to" onclick="return wall.showReply('1964550_2053', '1964550_2054')" rid="119208948">Μаксиму</a>
      </div>
    </div>
  </div>
</div></div>
  <div class="reply_fakebox_wrap" id="reply_fakebox1964550_2053" onclick="return Wall.showEditReply('1964550_2053', event)"><div class="reply_fakebox">Комментировать..</div></div>
</div></div>
    </div>
  </div>

</div><div id="post1964550_2050" class="post own post_online" onmouseover="wall.postOver('1964550_2050');" onmouseout="wall.postOut('1964550_2050');" onclick="wall.postClick('1964550_2050', event);">
  <div class="post_table">
    <div class="post_image">
      <a class="post_image" href="/borxezz"><img src="https://pp.vk.me/c628431/v628431550/402bd/2wBeRVUFE9U.jpg" data-post-id="1964550_2050" height="50" width="50"></a>
      <span class="online">Online</span>
    </div>
    <div class="post_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="post_delete1964550_2050" class="post_delete_button fl_r" onclick="wall.deletePost('1964550_2050', '96e649f89a14c80111');" onmouseover="wall.activeDeletePost('1964550_2050', 'Удалить запись', 'post_delete')" onmouseout="wall.deactiveDeletePost('1964550_2050', 'post_delete')"></div></div></div>
      <div class="wall_text"><div class="wall_text_name"><a class="author" href="/borxezz" data-from-id="1964550" data-post-id="1964550_2050">Александр Борохов</a></div> <div id="wpt1964550_2050"><div class="wall_post_text">Продолжаем готовиться к зимнему сезону! На этот раз нас пригласил ведущий финский бренд Nokian. <a href="/feed?section=search&amp;q=%23%D0%B0%D0%B2%D1%82%D0%BE%D1%81%D0%B5%D1%82%D1%8C">#автосеть</a> <a href="/feed?section=search&amp;q=%23%D1%88%D0%B8%D0%BD%D1%8B">#шины</a> <a href="/feed?section=search&amp;q=%23%D0%B7%D0%B8%D0%BC%D0%BD%D0%B8%D0%B5%D1%88%D0%B8%D0%BD%D1%8B">#зимниешины</a> <a href="/feed?section=search&amp;q=%23%D0%BD%D0%BE%D0%BA%D0%B8%D0%B0%D0%BD">#нокиан</a> <a href="/feed?section=search&amp;q=%23nokian">#nokian</a> <a href="/feed?section=search&amp;q=%23nokiantyres">#nokiantyres</a>  @ Отель "Эрмитаж" Брест</div><div class="page_post_queue_wide"><div class="page_post_sized_thumbs  clear_fix" style="width: 340px; height: 340px;"><a href="/photo1964550_383637300" onclick="return showPhoto('1964550_383637300', 'wall1964550_2050', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c623628/v623628550/&quot;,&quot;x_&quot;:[&quot;55279/tg35rRDemxk&quot;,604,604],&quot;y_&quot;:[&quot;5527a/RdCfVssXf40&quot;,807,807],&quot;z_&quot;:[&quot;5527b/H-dIaZCQgUw&quot;,1024,1024]},queue:1}, event)" style="width: 340px; height: 340px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c623628/v623628550/55279/tg35rRDemxk.jpg" style="" class="page_post_thumb_sized_photo" height="340" width="340"></a></div></div>
<div class="page_post_queue_narrow"><div class="page_post_sized_thumbs  clear_fix" style="width: 320px; height: 320px;"><a href="/photo1964550_383637300" onclick="return showPhoto('1964550_383637300', 'wall1964550_2050', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c623628/v623628550/&quot;,&quot;x_&quot;:[&quot;55279/tg35rRDemxk&quot;,604,604],&quot;y_&quot;:[&quot;5527a/RdCfVssXf40&quot;,807,807],&quot;z_&quot;:[&quot;5527b/H-dIaZCQgUw&quot;,1024,1024]},queue:1}, event)" style="width: 320px; height: 320px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c623628/v623628550/55279/tg35rRDemxk.jpg" style="" class="page_post_thumb_sized_photo" height="320" width="320"></a></div></div><div class="media_desc">
  <div class="page_media_place page_media_place__no_img clear_fix" id="post_media_lnk1964550_2050_-3">

    <div class="clear_fix"><a onclick="return showBox('al_places.php', {act: 'show_photo_place', geohash: '8ZCmCubJ', from_wall: 1}, {cache: 1});" class="page_media_place_label_inline">улица Чкалова, Брест</a></div>
  </div>
</div></div></div>
      <div class="post_full_like_wrap sm fl_r">
  <div class="post_full_like">
    <div class="post_like fl_r" onmouseover="wall.postLikeOver('1964550_2050')" onmouseout="wall.postLikeOut('1964550_2050')" onclick="wall.like('1964550_2050', '075d3b14ed8f0f5142'); event.cancelBubble = true;">
      <span class="post_like_link fl_l" id="like_link1964550_2050">Мне нравится</span>
      <i class="post_like_icon sp_main  fl_l" id="like_icon1964550_2050"></i>
      <span class="post_like_count fl_l" id="like_count1964550_2050">2</span>
    </div>
    <div class="post_share fl_r no_shares" onmouseover="wall.postShareOver('1964550_2050')" onmouseout="wall.postShareOut('1964550_2050', event)" onclick="wall.likeShareCustom('1964550_2050'); event.cancelBubble = true;">
      <span class="post_share_link fl_l" id="share_link1964550_2050">Поделиться</span>
      <i class="post_share_icon sp_main fl_l" id="share_icon1964550_2050"></i>
      <span class="post_share_count fl_l" id="share_count1964550_2050"></span>
    </div>
  </div>
</div>
      <div class="replies"><div class="reply_link_wrap sm" id="wpe_bottom1964550_2050">
  <small><a href="/wall1964550_2050" onclick="return showWiki({w: 'wall1964550_2050'}, false, event);"><span class="rel_date">29 сен 2015</span></a><a onmouseover="wall.postTooltip(this, '1964550_2050', {i: '-1', dark: 1})" href="/away.php?to=https%3A%2F%2Finstagram.com%2Fp%2F8NMjCaFHr0%2F" target="_blank" class="wall_post_source_icon wall_post_source_instagram"></a></small><span id="reply_link1964550_2050" class="reply_link"><span class="divide">|</span><a class="reply_link" onclick="return Wall.showEditReply('1964550_2050', event)">Комментировать</a></span>
</div>
<div class="replies_wrap clear" id="replies_wrap1964550_2050" style="display: none">
  <div id="replies1964550_2050"><input id="start_reply1964550_2050" value="" type="hidden"></div>
  <div class="reply_fakebox_wrap" id="reply_fakebox1964550_2050" onclick="return Wall.showEditReply('1964550_2050', event)"><div class="reply_fakebox">Комментировать..</div></div>
</div></div>
    </div>
  </div>

</div><div id="post1964550_2048" class="post own post_online" onmouseover="wall.postOver('1964550_2048');" onmouseout="wall.postOut('1964550_2048');" onclick="wall.postClick('1964550_2048', event);">
  <div class="post_table">
    <div class="post_image">
      <a class="post_image" href="/borxezz"><img src="https://pp.vk.me/c628431/v628431550/402bd/2wBeRVUFE9U.jpg" data-post-id="1964550_2048" height="50" width="50"></a>
      <span class="online">Online</span>
    </div>
    <div class="post_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="post_delete1964550_2048" class="post_delete_button fl_r" onclick="wall.deletePost('1964550_2048', 'aa4db1a9c345ae8bc1');" onmouseover="wall.activeDeletePost('1964550_2048', 'Удалить запись', 'post_delete')" onmouseout="wall.deactiveDeletePost('1964550_2048', 'post_delete')"></div></div></div>
      <div class="wall_text"><div class="wall_text_name"><a class="author" href="/borxezz" data-from-id="1964550" data-post-id="1964550_2048">Александр Борохов</a></div> <div id="wpt1964550_2048"><div class="wall_post_text">Насыщенно, интересно, увлекательно прошёл семинар <a href="/feed?section=search&amp;q=%23Goodyear">#Goodyear</a>. Скоро выпустим ролик по результатам презентации новинок, следите за новостями! <a href="/feed?section=search&amp;q=%23%D0%B0%D0%B2%D1%82%D0%BE%D1%81%D0%B5%D1%82%D1%8C">#автосеть</a> <a href="/feed?section=search&amp;q=%23%D1%88%D0%B8%D0%BD%D1%8B">#шины</a> <a href="/feed?section=search&amp;q=%23%D1%81%D0%B5%D0%BC%D0%B8%D0%BD%D0%B0%D1%80">#семинар</a> <a href="/feed?section=search&amp;q=%23goodyear">#goodyear</a>  @ Victoria Hotel Minsk</div><div class="page_post_queue_wide"><div class="page_post_sized_thumbs  clear_fix" style="width: 340px; height: 340px;"><a href="/photo1964550_382232612" onclick="return showPhoto('1964550_382232612', 'wall1964550_2048', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c623627/v623627550/&quot;,&quot;x_&quot;:[&quot;40081/D8EprUonMBQ&quot;,604,604],&quot;y_&quot;:[&quot;40082/wTts3sibBAw&quot;,807,807],&quot;z_&quot;:[&quot;40083/jZ8KCmSg9Uo&quot;,1024,1024]},queue:1}, event)" style="width: 340px; height: 340px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c623627/v623627550/40081/D8EprUonMBQ.jpg" style="" class="page_post_thumb_sized_photo" height="340" width="340"></a></div></div>
<div class="page_post_queue_narrow"><div class="page_post_sized_thumbs  clear_fix" style="width: 320px; height: 320px;"><a href="/photo1964550_382232612" onclick="return showPhoto('1964550_382232612', 'wall1964550_2048', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c623627/v623627550/&quot;,&quot;x_&quot;:[&quot;40081/D8EprUonMBQ&quot;,604,604],&quot;y_&quot;:[&quot;40082/wTts3sibBAw&quot;,807,807],&quot;z_&quot;:[&quot;40083/jZ8KCmSg9Uo&quot;,1024,1024]},queue:1}, event)" style="width: 320px; height: 320px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c623627/v623627550/40081/D8EprUonMBQ.jpg" style="" class="page_post_thumb_sized_photo" height="320" width="320"></a></div></div><div class="media_desc">
  <div class="page_media_place page_media_place__no_img clear_fix" id="post_media_lnk1964550_2048_-3">

    <div class="clear_fix"><a onclick="return showBox('al_places.php', {act: 'show_photo_place', geohash: '8YadTVGs', from_wall: 1}, {cache: 1});" class="page_media_place_label_inline">проспект Победителей, Минск</a></div>
  </div>
</div></div></div>
      <div class="post_full_like_wrap sm fl_r">
  <div class="post_full_like">
    <div class="post_like fl_r" onmouseover="wall.postLikeOver('1964550_2048')" onmouseout="wall.postLikeOut('1964550_2048')" onclick="wall.like('1964550_2048', '174dacac82633d2de1'); event.cancelBubble = true;">
      <span class="post_like_link fl_l" id="like_link1964550_2048">Мне нравится</span>
      <i class="post_like_icon sp_main  fl_l" id="like_icon1964550_2048"></i>
      <span class="post_like_count fl_l" id="like_count1964550_2048">4</span>
    </div>
    <div class="post_share fl_r no_shares" onmouseover="wall.postShareOver('1964550_2048')" onmouseout="wall.postShareOut('1964550_2048', event)" onclick="wall.likeShareCustom('1964550_2048'); event.cancelBubble = true;">
      <span class="post_share_link fl_l" id="share_link1964550_2048">Поделиться</span>
      <i class="post_share_icon sp_main fl_l" id="share_icon1964550_2048"></i>
      <span class="post_share_count fl_l" id="share_count1964550_2048"></span>
    </div>
  </div>
</div>
      <div class="replies"><div class="reply_link_wrap sm" id="wpe_bottom1964550_2048">
  <small><a href="/wall1964550_2048" onclick="return showWiki({w: 'wall1964550_2048'}, false, event);"><span class="rel_date">18 сен 2015</span></a><a onmouseover="wall.postTooltip(this, '1964550_2048', {i: '-1', dark: 1})" href="/away.php?to=https%3A%2F%2Finstagram.com%2Fp%2F7xUFLElHjo%2F" target="_blank" class="wall_post_source_icon wall_post_source_instagram"></a></small><span id="reply_link1964550_2048" class="reply_link"><span class="divide">|</span><a class="reply_link" onclick="return Wall.showEditReply('1964550_2048', event)">Комментировать</a></span>
</div>
<div class="replies_wrap clear" id="replies_wrap1964550_2048" style="display: none">
  <div id="replies1964550_2048"><input id="start_reply1964550_2048" value="" type="hidden"></div>
  <div class="reply_fakebox_wrap" id="reply_fakebox1964550_2048" onclick="return Wall.showEditReply('1964550_2048', event)"><div class="reply_fakebox">Комментировать..</div></div>
</div></div>
    </div>
  </div>

</div><div id="post1964550_2047" class="post own post_online" onmouseover="wall.postOver('1964550_2047');" onmouseout="wall.postOut('1964550_2047');" onclick="wall.postClick('1964550_2047', event);">
  <div class="post_table">
    <div class="post_image">
      <a class="post_image" href="/borxezz"><img src="https://pp.vk.me/c628431/v628431550/402bd/2wBeRVUFE9U.jpg" data-post-id="1964550_2047" height="50" width="50"></a>
      <span class="online">Online</span>
    </div>
    <div class="post_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="post_delete1964550_2047" class="post_delete_button fl_r" onclick="wall.deletePost('1964550_2047', 'c52d9e4ad93b524fd2');" onmouseover="wall.activeDeletePost('1964550_2047', 'Удалить запись', 'post_delete')" onmouseout="wall.deactiveDeletePost('1964550_2047', 'post_delete')"></div></div></div>
      <div class="wall_text"><div class="wall_text_name"><a class="author" href="/borxezz" data-from-id="1964550" data-post-id="1964550_2047">Александр Борохов</a></div> <div id="wpt1964550_2047"><div class="wall_post_text">Зачекинились на семинаре. Готовы к поглощению массы информации о новинках сезона от @goodyear.<br><a href="/feed?section=search&amp;q=%23%D0%B0%D0%B2%D1%82%D0%BE%D1%81%D0%B5%D1%82%D1%8C">#автосеть</a> <a href="/feed?section=search&amp;q=%23%D0%B3%D1%83%D0%B4%D1%8C%D0%B5%D1%80">#гудьер</a> <a href="/feed?section=search&amp;q=%23%D1%88%D0%B8%D0%BD%D1%8B">#шины</a> <a href="/feed?section=search&amp;q=%23%D1%81%D0%B5%D0%BC%D0%B8%D0%BD%D0%B0%D1%80">#семинар</a>  @ Victoria Hotel Minsk</div><div class="page_post_queue_wide"><div class="page_post_sized_thumbs  clear_fix" style="width: 340px; height: 340px;"><a href="/photo1964550_382209048" onclick="return showPhoto('1964550_382209048', 'wall1964550_2047', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c623627/v623627550/&quot;,&quot;x_&quot;:[&quot;40031/diWNlLsS2jM&quot;,604,604],&quot;y_&quot;:[&quot;40032/WbqxkSMRbtA&quot;,750,750]},queue:1}, event)" style="width: 340px; height: 340px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c623627/v623627550/40031/diWNlLsS2jM.jpg" style="" class="page_post_thumb_sized_photo" height="340" width="340"></a></div></div>
<div class="page_post_queue_narrow"><div class="page_post_sized_thumbs  clear_fix" style="width: 320px; height: 320px;"><a href="/photo1964550_382209048" onclick="return showPhoto('1964550_382209048', 'wall1964550_2047', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c623627/v623627550/&quot;,&quot;x_&quot;:[&quot;40031/diWNlLsS2jM&quot;,604,604],&quot;y_&quot;:[&quot;40032/WbqxkSMRbtA&quot;,750,750]},queue:1}, event)" style="width: 320px; height: 320px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c623627/v623627550/40031/diWNlLsS2jM.jpg" style="" class="page_post_thumb_sized_photo" height="320" width="320"></a></div></div><div class="media_desc">
  <div class="page_media_place page_media_place__no_img clear_fix" id="post_media_lnk1964550_2047_-3">

    <div class="clear_fix"><a onclick="return showBox('al_places.php', {act: 'show_photo_place', geohash: '8YadTVGs', from_wall: 1}, {cache: 1});" class="page_media_place_label_inline">проспект Победителей, Минск</a></div>
  </div>
</div></div></div>
      <div class="post_full_like_wrap sm fl_r">
  <div class="post_full_like">
    <div class="post_like fl_r" onmouseover="wall.postLikeOver('1964550_2047')" onmouseout="wall.postLikeOut('1964550_2047')" onclick="wall.like('1964550_2047', '83be82ea7a340d9c68'); event.cancelBubble = true;">
      <span class="post_like_link fl_l" id="like_link1964550_2047">Мне нравится</span>
      <i class="post_like_icon sp_main  fl_l" id="like_icon1964550_2047"></i>
      <span class="post_like_count fl_l" id="like_count1964550_2047">5</span>
    </div>
    <div class="post_share fl_r no_shares" onmouseover="wall.postShareOver('1964550_2047')" onmouseout="wall.postShareOut('1964550_2047', event)" onclick="wall.likeShareCustom('1964550_2047'); event.cancelBubble = true;">
      <span class="post_share_link fl_l" id="share_link1964550_2047">Поделиться</span>
      <i class="post_share_icon sp_main fl_l" id="share_icon1964550_2047"></i>
      <span class="post_share_count fl_l" id="share_count1964550_2047"></span>
    </div>
  </div>
</div>
      <div class="replies"><div class="reply_link_wrap sm" id="wpe_bottom1964550_2047">
  <small><a href="/wall1964550_2047" onclick="return showWiki({w: 'wall1964550_2047'}, false, event);"><span class="rel_date">18 сен 2015</span></a><a onmouseover="wall.postTooltip(this, '1964550_2047', {i: '-1', dark: 1})" href="/away.php?to=https%3A%2F%2Finstagram.com%2Fp%2F7w3UNWlHjF%2F" target="_blank" class="wall_post_source_icon wall_post_source_instagram"></a></small><span id="reply_link1964550_2047" class="reply_link"><span class="divide">|</span><a class="reply_link" onclick="return Wall.showEditReply('1964550_2047', event)">Комментировать</a></span>
</div>
<div class="replies_wrap clear" id="replies_wrap1964550_2047" style="display: none">
  <div id="replies1964550_2047"><input id="start_reply1964550_2047" value="" type="hidden"></div>
  <div class="reply_fakebox_wrap" id="reply_fakebox1964550_2047" onclick="return Wall.showEditReply('1964550_2047', event)"><div class="reply_fakebox">Комментировать..</div></div>
</div></div>
    </div>
  </div>

</div><div id="post1964550_2046" class="post own post_online" onmouseover="wall.postOver('1964550_2046');" onmouseout="wall.postOut('1964550_2046');" onclick="wall.postClick('1964550_2046', event);">
  <div class="post_table">
    <div class="post_image">
      <a class="post_image" href="/borxezz"><img src="https://pp.vk.me/c628431/v628431550/402bd/2wBeRVUFE9U.jpg" data-post-id="1964550_2046" height="50" width="50"></a>
      <span class="online">Online</span>
    </div>
    <div class="post_info">
      <div class="fl_r post_actions_wrap"><div class="post_actions"><div id="post_delete1964550_2046" class="post_delete_button fl_r" onclick="wall.deletePost('1964550_2046', '482cd53b8f5769e4f6');" onmouseover="wall.activeDeletePost('1964550_2046', 'Удалить запись', 'post_delete')" onmouseout="wall.deactiveDeletePost('1964550_2046', 'post_delete')"></div></div></div>
      <div class="wall_text"><div class="wall_text_name"><a class="author" href="/borxezz" data-from-id="1964550" data-post-id="1964550_2046">Александр Борохов</a></div> <div id="wpt1964550_2046"><div class="wall_post_text">С первыми лучами солнца мы снова в пути. Ждите новости от @goodyear к зимнему сезону!<br><a href="/feed?section=search&amp;q=%23%D0%B0%D0%B2%D1%82%D0%BE%D1%81%D0%B5%D1%82%D1%8C">#автосеть</a> <a href="/feed?section=search&amp;q=%23%D0%B4%D0%BE%D1%80%D0%BE%D0%B3%D0%B0">#дорога</a> <a href="/feed?section=search&amp;q=%23%D1%88%D0%B8%D0%BD%D1%8B">#шины</a> <a href="/feed?section=search&amp;q=%23%D0%B3%D1%83%D0%B4%D1%8C%D0%B5%D1%80">#гудьер</a> <a href="/feed?section=search&amp;q=%23goodyear">#goodyear</a></div><div class="page_post_queue_wide"><div class="page_post_sized_thumbs  clear_fix" style="width: 340px; height: 340px;"><a href="/photo1964550_382195782" onclick="return showPhoto('1964550_382195782', 'wall1964550_2046', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c623627/v623627550/&quot;,&quot;x_&quot;:[&quot;40020/o7f4gC0WbeM&quot;,604,604],&quot;y_&quot;:[&quot;40021/WvfnpJSpwo0&quot;,807,807],&quot;z_&quot;:[&quot;40022/m8k-3Fdjyfs&quot;,1024,1024]},queue:1}, event)" style="width: 340px; height: 340px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c623627/v623627550/40020/o7f4gC0WbeM.jpg" style="" class="page_post_thumb_sized_photo" height="340" width="340"></a></div></div>
<div class="page_post_queue_narrow"><div class="page_post_sized_thumbs  clear_fix" style="width: 320px; height: 320px;"><a href="/photo1964550_382195782" onclick="return showPhoto('1964550_382195782', 'wall1964550_2046', {&quot;temp&quot;:{&quot;base&quot;:&quot;https://pp.vk.me/c623627/v623627550/&quot;,&quot;x_&quot;:[&quot;40020/o7f4gC0WbeM&quot;,604,604],&quot;y_&quot;:[&quot;40021/WvfnpJSpwo0&quot;,807,807],&quot;z_&quot;:[&quot;40022/m8k-3Fdjyfs&quot;,1024,1024]},queue:1}, event)" style="width: 320px; height: 320px;" class="page_post_thumb_wrap  page_post_thumb_last_column page_post_thumb_last_row"><img src="https://pp.vk.me/c623627/v623627550/40020/o7f4gC0WbeM.jpg" style="" class="page_post_thumb_sized_photo" height="320" width="320"></a></div></div></div></div>
      <div class="post_full_like_wrap sm fl_r">
  <div class="post_full_like">
    <div class="post_like fl_r" onmouseover="wall.postLikeOver('1964550_2046')" onmouseout="wall.postLikeOut('1964550_2046')" onclick="wall.like('1964550_2046', '09955fb3949615f0b6'); event.cancelBubble = true;">
      <span class="post_like_link fl_l" id="like_link1964550_2046">Мне нравится</span>
      <i class="post_like_icon sp_main  fl_l" id="like_icon1964550_2046"></i>
      <span class="post_like_count fl_l" id="like_count1964550_2046">5</span>
    </div>
    <div class="post_share fl_r no_shares" onmouseover="wall.postShareOver('1964550_2046')" onmouseout="wall.postShareOut('1964550_2046', event)" onclick="wall.likeShareCustom('1964550_2046'); event.cancelBubble = true;">
      <span class="post_share_link fl_l" id="share_link1964550_2046">Поделиться</span>
      <i class="post_share_icon sp_main fl_l" id="share_icon1964550_2046"></i>
      <span class="post_share_count fl_l" id="share_count1964550_2046"></span>
    </div>
  </div>
</div>
      <div class="replies"><div class="reply_link_wrap sm" id="wpe_bottom1964550_2046">
  <small><a href="/wall1964550_2046" onclick="return showWiki({w: 'wall1964550_2046'}, false, event);"><span class="rel_date">18 сен 2015</span></a><a onmouseover="wall.postTooltip(this, '1964550_2046', {i: '-1', dark: 1})" href="/away.php?to=https%3A%2F%2Finstagram.com%2Fp%2F7wgLRbFHsC%2F" target="_blank" class="wall_post_source_icon wall_post_source_instagram"></a></small><span id="reply_link1964550_2046" class="reply_link"><span class="divide">|</span><a class="reply_link" onclick="return Wall.showEditReply('1964550_2046', event)">Комментировать</a></span>
</div>
<div class="replies_wrap clear" id="replies_wrap1964550_2046" style="display: none">
  <div id="replies1964550_2046"><input id="start_reply1964550_2046" value="" type="hidden"></div>
  <div class="reply_fakebox_wrap" id="reply_fakebox1964550_2046" onclick="return Wall.showEditReply('1964550_2046', event)"><div class="reply_fakebox">Комментировать..</div></div>
</div></div>
    </div>
  </div>

</div></div><a style="display: block;" class="more_link clear" id="wall_more_link" onclick="wall.showMore(10);"><div class="progress" id="wall_more_progress"></div><div>к предыдущим записям</div></a></div>
</div></div>
  <br class="clear">

</div></div>
  </div>
</div></div>
    </div>

    <div id="footer_wrap" class="fl_r" style="width: 661px;">
      <div id="bottom_nav">
  <a class="bnav_a" href="/about">о сайте</a>
  <a class="bnav_a" href="/support?act=home" onclick="return nav.go(this, event);" style="">помощь</a>
  <a class="bnav_a" href="/terms">правила</a>
  <a class="bnav_a" href="/ads">реклама</a>

  <a class="bnav_a" href="/dev">разработчикам</a>
  <a class="bnav_a" href="/jobs" style="">вакансии</a>
</div>
<div id="footer" class="clear">
  <div class="copy_lang">ВКонтакте © 2016 <a class="bnav_lang" onclick="showBox('lang.php', {act: 'lang_dialog'}, {params: {dark: true, bodyStyle: 'padding: 0px'}, noreload: true})">Русский</a></div>

  <div>
    <small><a href="/durov" onclick="return nav.go(this, event)">Павел Дуров</a></small>

  </div>
</div>
    </div>
    <div class="clear"></div>
  </div>
</div></div><noscript><div style="position:absolute;left:-10000px;">
<img src="//top-fwz1.mail.ru/counter?id=2579437;pid=1964550;js=na" style="border:0;" height="1" width="1" />
</div></noscript><div id=""><div class="scroll_fix" id="custom_menu_wrap" style="width:1604px"><div id="custom_menu_cont"><div style="position: absolute;" class="add_media_menu " id="add_media_menu_1"><div class="add_media_rows"><div class="rows"><div class="add_media_items"><div class="add_media_head noselect"><nobr>Прикрепить</nobr></div><a style="background-image: url(&quot;/images/icons/attach_icons.png?6&quot;); background-position: 3px 3px;" class="add_media_type_1_photo add_media_item"><nobr>Фотографию</nobr></a><a style="background-image: url(&quot;/images/icons/attach_icons.png?6&quot;); background-position: 3px -20px;" class="add_media_type_1_video add_media_item"><nobr>Видеозапись</nobr></a><a style="background-image: url(&quot;/images/icons/attach_icons.png?6&quot;); background-position: 3px -42px;" class="add_media_type_1_audio add_media_item"><nobr>Аудиозапись</nobr></a><div class="add_media_more_wrap"><a class="add_media_more add_media_item"><nobr>Другое..</nobr></a><div style="display: none;" class="add_media_more_node"><div class="unshown"></div><a style="background-image: url(&quot;/images/icons/attach_icons.png?6&quot;); background-position: 3px -152px;" class="add_media_type_1_graffiti add_media_item"><nobr>Граффити</nobr></a><a style="background-image: url(&quot;/images/icons/attach_icons.png?6&quot;); background-position: 3px -130px;" class="add_media_type_1_note add_media_item"><nobr>Заметку</nobr></a><a style="background-image: url(&quot;/images/icons/attach_icons.png?6&quot;); background-position: 3px -64px;" class="add_media_type_1_doc add_media_item"><nobr>Документ</nobr></a><a style="background-image: url(&quot;/images/icons/attach_icons.png?6&quot;); background-position: 3px -86px;" class="add_media_type_1_map add_media_item"><nobr>Карту</nobr></a><a style="background-image: url(&quot;/images/icons/attach_icons.png?6&quot;); background-position: 3px -108px;" class="add_media_type_1_poll add_media_item"><nobr>Опрос</nobr></a><a style="background-image: url(&quot;/images/icons/attach_icons.png?6&quot;); background-position: 3px -173px;" class="add_media_type_1_postpone add_media_item"><nobr>Таймер</nobr></a></div></div></div></div></div></div></div></div></div></div>