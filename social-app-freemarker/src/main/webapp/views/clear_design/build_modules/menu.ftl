<!-- start: Main Menu -->
			<div id="sidebar-left" class="span2">
				<div class="nav-collapse sidebar-nav navbar-static">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li><a href="users"><i class="icon-bar-chart"></i><span class="hidden-tablet"> <@spring.message code="users.all"/> </span></a></li>
						<li><a href="${("user?id=" + dto.user.userId)!"user"}"><i class="icon-eye-open"></i><span class="hidden-tablet"> Моя страница </span></a></li>
						<li><a href="${("friends?id=" + dto.user.userId)!"friends"}"><i class="icon-tasks"></i><span class="hidden-tablet"> Мои друзья </span></a></li>
						<li><a href="${("messages?id=" + dto.user.userId)!"message"}"><i class="icon-envelope"></i><span class="hidden-tablet"> Мои сообщения </span></a></li>
						<li><a href="${("photo?id=" + dto.user.userId)!"photo"}"><i class="icon-picture"></i><span class="hidden-tablet"> Мои фотографии </span></a></li>

						<li><a href="login"><i class="icon-lock"></i><span class="hidden-tablet"> Выйти </span></a></li>
					</ul>
				</div>
			</div>
<!-- end: Main Menu -->