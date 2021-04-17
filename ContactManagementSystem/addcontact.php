<!DOCTYPE html>
<HTML>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Form Stylesheet-->
        <link rel="stylesheet" type="text/css" href="Style.css">
        <!-- Javascript function for calling the validation form -->
        <script src="validate_function.js"></script>   
        <title>Contact Management System Add</title>
    </head>
    <body>
        <?php
// Include config and header file
        include 'config.php';
        include "header.php";


//register btn is clicked
        if (isset($_POST['Add'])) {

            $names = sanitizeString($_POST['names']);
            $profession = sanitizeString($_POST['profession']);
            $emailaddress = sanitizeString($_POST['emailaddress']);
            $phone = sanitizeString($_POST['phone']);
            $city = sanitizeString($_POST['city']);
            $address = sanitizeString($_POST['address']);
            $contact_group = sanitizeString($_POST['contact_group']);

//Insert SQL statement to DB
            $sql = "INSERT INTO contacts (names,profession,emailaddress,phone,city,address,contact_group)
          VALUES ('$names','$profession','$emailaddress','$phone','$city','$address','$contact_group')";

            if (mysqli_query($conn, $sql)) {

                echo "<script>alert('Contact added successfully');document.location=' view.php'</script>";
            } else {
                echo "Error: " . $sql . ":-" . mysqli_error($conn);
            }
            mysqli_close($conn);
        }
        ?>


        <div class="container">
            <h1 style="text-shadow: 2px 2px 5px gold; text-align:center">Add Contacts </h1>

            <!--Form for data insertion-->
            <form  method="post"  name="Add" onsubmit="return Validate()" action="<?php $_PHP_SELF ?>">

                <div class="row">
                    <label for="names">Names</label>
                    <input type="text" placeholder="Enter Full Name" maxlength="32" id="names" name="names" >
                </div>

                <div class="row">
                    <label for="profession">Profession</label>
                    <input type="text" placeholder="Enter Profession" maxlength="32" id="profession" name="profession" >
                </div>

                <div class="row">
                    <label for="email">Email</label>
                    <input type="email" placeholder="Enter Email" id="emailaddress" name="emailaddress" >
                </div>

                <div class="row">
                    <label for="phone">Phone</label>
                    <input type="text" placeholder="Enter Mobile number" id="phone" pattern="[0-9]{3}?[0-9]{3}?[0-9]{4}" name="phone" >
                </div>

                <div class="row">
                    <label for="city">City</label>
                    <input type="text" placeholder="Enter City" id="city"  name="city" >
                </div>

                <div class="row">
                    <label for="address">Address</label>
                    <input type="text"placeholder="Enter Address" id="address" name="address" >
                </div>

                <div class="row"> 

                    <label for="contact_group">Contact group</label>
                    <select name="contact_group" class="contact_group"id="contact_group">
                        <option value="Select">Select</option>}
                        <option value="business">Business</option>
                        <option value="private">Private</option>
                    </select>
                </div>
                <br><br>

                <!--Buttons to submit and cancel-->
                <div class="row">
                    <input type="submit" name="Add" value="Add">
                </div>

                <div class="row">
                    <input type="button" onclick="document.location = 'view.php';" value="Cancel" />
                </div>

            </form>
        </div>   
    </body>
</HTML>




































