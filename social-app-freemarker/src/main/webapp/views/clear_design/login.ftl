<#ftl output_format="HTML">

<!doctype html>

<#include "build_modules/head.ftl"/>

        <style type="text/css">
             body { background: url(<@spring.url "/img/bg-login.jpg"/>) !important; }
		</style>

<body>
		<div class="container-fluid-full">
		<div class="row-fluid">
					
			<div class="row-fluid">
				<div class="login-box">
					<div class="icons">
						<a href="index.html"><i class="halflings-icon home"></i></a>
						<a href="#"><i class="halflings-icon cog"></i></a>
					</div>
					<h2>Login to your account</h2>
					<form class="form-horizontal" name="user" action="loginapprove" method="post">
						<fieldset>
							
							<div class="input-prepend" title="Login">
								<span class="add-on"><i class="halflings-icon user"></i></span>
								<input class="input-large span10" name="login" id="login" type="text" placeholder="type login" required="true"/>
							</div>
							<div class="clearfix"></div>

							<div class="input-prepend" title="Password">
								<span class="add-on"><i class="halflings-icon lock"></i></span>
								<input class="input-large span10" name="password" id="password" type="password" placeholder="type password" required="true"/>
							</div>
							<div class="clearfix"></div>
							
			<!--			<label class="remember" for="remember"><input type="checkbox" id="remember" />Remember me</label> -->

							<div class="button-login">
								<a class="btn btn-default" href="adduser">Sign Up</a>

								<button type="submit" class="btn btn-primary">Login</button>
							</div>
							<div class="clearfix"></div>
					</form>
					<hr>

					<h3>Forgot Password?</h3>
					<p>
						No problem, <a href="#">click here</a> to get a new password.
					</p>

                    <h2> You will be redirected in <span id="timeLeft">10</span> seconds </h2>


				</div><!--/span-->
			</div><!--/row-->
			

	</div><!--/.fluid-container-->
	
		</div><!--/fluid-row-->


</body>

<#include "build_modules/footer.ftl"/>



</html>
