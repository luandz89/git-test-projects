<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>  
    <br><br>
    <h1 style="text-shadow: 2px 2px 5px gold; text-align:center">Welcome to the Patient Management System: </h1>
    <br><br>
    <link rel="stylesheet" type="text/css" href="Style.css">   
</head>
<body>
    <?php
    include("config.php");

    if (isset($_POST['login'])) {
        $user_name = sanitizeString($_POST['user']);
        $user_pass = sanitizeString($_POST['pass']);

        $check_user = "select * from login_info WHERE username='$user_name'AND password='$user_pass'";

        $run = mysqli_query($conn, $check_user);

        if (mysqli_num_rows($run)) {
            echo "<script>alert('Logged in successfully!');window.open('view.php','_self')</script>";

            $_SESSION['name'] = $user_name; //here session is used and value of $user_name store in $_SESSION.  
        } else {
            echo "<script>alert('Username and password do not match, please try again!')</script>";
        }
    }
    ?> 


    <div class="container">
        <h1 align="left">Secure Admin Login: </h1>
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
