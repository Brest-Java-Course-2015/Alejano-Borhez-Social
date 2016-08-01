<head>
    <#import "spring.ftl" as spring/>
    <!-- start: Meta -->
    	<meta charset="utf-8">
    	<title> <@spring.message code="users.list"/> - ${(pageInfo.mapping)!""} - enhanced with Janux theme </title>
    	<meta name="description" content="${(pageInfo.description)!"Simple Social Network - case study project"}">
    	<meta name="author" content="Alexander Borohov">
    	<meta name="keyword" content="${(pageInfo.keywords)!"simple social, java web"}">
    	<!-- end: Meta -->

    	<!-- start: Mobile Specific -->
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	<!-- end: Mobile Specific -->

        <link rel="shortcut icon" href="<@spring.url "/img/favicon.ico"/>" />
    	<!-- start: CSS -->

    	<link href="<@spring.url "/css/bootstrap.min.css"/>" id="bootstrap-style" rel="stylesheet">
    	<link href="<@spring.url "/css/bootstrap-responsive.min.css"/>" rel="stylesheet">
    	<link href="<@spring.url "/css/style.css"/>" id="base-style" rel="stylesheet">
    	<link href="<@spring.url "/css/style-responsive.css"/>" id="base-style-responsive" rel="stylesheet">
    	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
    	<!-- end: CSS -->


    	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    	<!--[if lt IE 9]>
    	  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    		<link id="ie-style" href="<@spring.url "/css/ie.css"/>" rel="stylesheet">
    	<![endif]-->

    	<!--[if IE 9]>
    		<link href="<@spring.url "/css/ie9.css"/>" id="ie9style" rel="stylesheet">
    	<![endif]-->

    	<!-- start: Favicon -->
    	<link href="<@spring.url "/img/favicon.ico"/>" rel="shortcut icon">
    	<!-- end: Favicon -->



</head>
