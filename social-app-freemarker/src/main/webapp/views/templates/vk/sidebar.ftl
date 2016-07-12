<div id="side_bar" class="fl_l" style="">
<ol>
  <li>
    <table id="myprofile_table" cellpadding="0" cellspacing="0">
      <tbody>
        <tr>
          <td id="myprofile_wrap">
            <a href="users" id="myprofile" class="left_row">
              <span class="left_label inl_bl"> <@spring.message code="users.all"/> </span>
            </a>
          </td>
          <!-- <td id="myprofile_edit_wrap">
            <a href="/edit" id="myprofile_edit" class="left_row">
              <span class="left_label inl_bl">ред.</span></a>
          </td> -->
        </tr>
      </tbody>
    </table>
  </li>

  <li id="l_fr">
    <a href="friends?id=${dto.user.userId}" class="left_row">
      <span class="left_fixer">
        <span class="left_count_pad">
          <span style="opacity: 1; display: block;" class="left_count_wrap  left_void fl_r">
            <span class="inl_bl left_count">
              +
            </span>
          </span>
        </span>
        <span class="left_label inl_bl">Мои Друзья</span>
      </span>
    </a>
  </li>

  <li id="l_ph">
    <a href="photo?id=${dto.user.userId}" class="left_row">
      <span class="left_fixer">
        <span class="left_count_pad">
          <span style="opacity: 1; display: block;" class="left_count_wrap  left_void fl_r">
            <span class="inl_bl left_count">
              +
            </span>
          </span>
        </span>
        <span class="left_label inl_bl">Мои Фотографии</span>
      </span>
    </a>
  </li>

  <li id="l_vid">
    <a href="video?id=${dto.user.userId}" class="left_row">
      <span class="left_fixer">
        <span class="left_count_pad">
          <span style="opacity: 1; display: block;" class="left_count_wrap  left_void fl_r">
            <span class="inl_bl left_count">
              +
            </span>
          </span>
        </span>
        <span class="left_label inl_bl">Мои Видеозаписи</span>
      </span>
    </a>
  </li>

  <li>
    <a href="audio?id=${dto.user.userId}" class="left_row">
      <span class="left_fixer">
        <span class="left_count_wrap  left_void fl_r">
          <span class="inl_bl left_plus">
            +
          </span>
        </span>
        <span class="left_label inl_bl">Мои Аудиозаписи</span>
      </span>
    </a>
  </li>

  <li id="l_msg">
    <a href="message?id=${dto.user.userId}" class="left_row">
      <span class="left_fixer">
        <span class="left_count_pad left_count_persist">
          <span style="opacity: 1; display: block;" class="left_count_wrap  left_void fl_r">
            <span class="inl_bl left_count">+</span>
          </span>
        </span>
        <span class="left_label inl_bl">Мои Сообщения</span>
      </span>
    </a>
  </li>

  <li style="display: none" id="l_nts">
    <a href="/notes" class="left_row">
      <span class="left_fixer">
        <span style="opacity: 1; display: block;" class="left_count_wrap  left_void fl_r">
          <span class="inl_bl left_count">
            +
          </span>
        </span>
        <span class="left_label inl_bl">Мои Заметки</span>
      </span>
    </a>
  </li>

</ol>
</div>