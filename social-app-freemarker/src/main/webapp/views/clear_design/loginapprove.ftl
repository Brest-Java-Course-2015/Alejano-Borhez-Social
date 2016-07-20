<#ftl output_format="HTML">

<!doctype html>

<#include "build_modules/head.ftl"/>

        <style type="text/css">
			body { background: url(img/bg-login.jpg) !important; }
		</style>





<body>
		<div class="container-fluid-full">
		<div class="row-fluid">

			<div class="row-fluid">

				<h1> Welcome ${user.firstName!""} ${user.lastName!""} ! </h1>

			</div><!--/row-->


	</div><!--/.fluid-container-->

		</div><!--/fluid-row-->

</body>

<#include "build_modules/footer.ftl"/>



</html>
