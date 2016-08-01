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
               You are attempting to recover your password at <strong>Simple Social Network.</strong><br>
               To reset a password select the following link or copy-paste it in your browser:<br>
               <strong><a href="${path!""}/admin/${action!""}?token=${token!""}">Click here</a></strong>
           </div>
       </div>
    </body>
</html>