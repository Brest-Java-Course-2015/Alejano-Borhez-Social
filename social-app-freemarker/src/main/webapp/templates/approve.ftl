<>
<html>
    <head>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    </head>
    <body>
       <div class="container-fluid">
       <div class="row-fluid">
               <h1> Hello ${user.firstName!""}! </h1>
           </div>
           <div class="row-fluid">
               Thank you for registering at <strong>Simple Social Network.</strong><br>
               Your account is created and must be activated before you can use it.<br>
               To activate the account select the following link or copy-paste it in your browser:<br>
               <strong><a href="${path!""}/${action!""}?token=${token!""}">Click here</a></strong>
           </div>
       </div>
    </body>
</html>