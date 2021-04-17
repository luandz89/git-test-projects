<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>  
    <br><br>
    <h1 style="text-shadow: 2px 2px 5px gold; text-align:center">Welcome to the Contacts Management System: </h1>
    <br><br>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Form Stylesheet-->
    <link rel="stylesheet" type="text/css" href="Style.css">   
</head>
<body>
    <?php
    include("config.php");

//Btn login to pull login details from database
    if (isset($_POST['login'])) {
        $user_name = sanitizeString($_POST['user']);
        $user_pass = sanitizeString($_POST['pass']);

        //get user from database
        $check_user = "select * from admin WHERE username='$user_name'AND password='$user_pass'";

        $run = mysqli_query($conn, $check_user);

        if (mysqli_num_rows($run)) {
            echo "<script>alert('Successfully logged in');window.open('view.php','_self')</script>";

            $_SESSION['name'] = $user_name; //here session is used and value of $user_name store in $_SESSION.  
        } else {
            echo "<script>alert('Username or password is incorrect!')</script>";
        }
    }
    ?> 

    <div class="container">
        <h1 align="center">User Login: </h1>

        <form action="login.php" method="POST">

            <p>
                <label>Username:</label>
                <input type="text" name="user" name="user"/>
            </p> 

            <p>
                <label>Password:</label>
                <input type="password" name="pass" name="pass"/>
            </p>

            <p>
                <input type="submit" name="login" value="Login"/>
            </p> 

        </form> 
    </div>
</body>
</html>
