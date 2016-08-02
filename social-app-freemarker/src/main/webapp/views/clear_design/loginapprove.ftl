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
                <#if dto??>
				<h1> Welcome ${(dto.user.firstName)!""} ${(dto.user.lastName)!""} ! </h1>
                <#else>
                <h1> Sorry, something went wrong </h1>
                </#if>
			</div><!--/row-->


	</div><!--/.fluid-container-->

		</div><!--/fluid-row-->

</body>

<#include "build_modules/footer.ftl"/>



</html>
