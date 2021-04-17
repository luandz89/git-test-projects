<!DOCTYPE html>
<HTML>
    <head>
        <!-- Form Stylesheet-->
        <link rel="stylesheet" type="text/css" href="Style.css">
        <title>Patient Management System Register</title>
    </head>
    <body>
        <?php
// Include config file
        include_once 'config.php';

//if the register button is clikced
        if (isset($_POST['Register'])) {

            $name = sanitizeString($_POST['name']);
            $surname = sanitizeString($_POST['surname']);
            $dob = sanitizeString($_POST['dob']);
            $gender = sanitizeString($_POST['gender']);
            $phone = sanitizeString($_POST['phonenumber']);
            $address = sanitizeString($_POST['address']);
            $section = sanitizeString($_POST['section']);
            $medicalaid = sanitizeString($_POST['medicalaid']);

//Insert SQL statement to insert on database
            $sql = "INSERT INTO patientinfo (name, surname,dob,gender, phone,address,section ,medical_aid)
            VALUES ('$name','$surname','$dob','$gender','$phone','$address','$section','$medicalaid')";

            if (mysqli_query($conn, $sql)) {

                echo "<script>alert('Patient registered successfully');document.location=' view.php'</script>";
            } else {
                echo "Error: " . $sql . ":-" . mysqli_error($conn);
            }
            mysqli_close($conn);
        }
        ?>
        <!-- Javascript function for calling the validation form -->
        <script src="validate_function.js"></script>    

        <div class="container">
            <h1 style="text-shadow: 2px 2px 5px gold; text-align:center">Register New Patient:</h1>

            <!--Form for data insertion-->
            <form  method="post" name="Insert" onsubmit="return validate(this)" action="<?php $_PHP_SELF ?>">

                <div class="row">
                    <label for="name">Name</label>
                    <input type="text" placeholder="Enter Name" maxlength="32" id="name" name="name" >
                </div>

                <div class="row">
                    <label for="surname">Surname</label>
                    <input type="text" placeholder="Enter Surname" maxlength="32"  id="surname"  name="surname" >
                </div>

                <div class="row">
                    <label for="dob">Date of Birth</label>
                    <input type="date" placeholder="Enter Date of Birth" maxlength="9" id="dob"name="dob" >
                </div>

                <div class="row"> 

                    <label for="gender">Gender</label>

                    <select name="gender" class="gender" id="gender">
                        <option value="Select">Select</option>}
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                    </select>
                </div>

                <div class="row">
                    <label for="phonenumber">Phone number</label>
                    <input type="text" placeholder="Enter Phonenumber"  pattern="[0-9]{3}?[0-9]{3}?[0-9]{4}" id="phonenumber" name="phonenumber" >
                </div>

                <div class="row">
                    <label for="address">Address</label>
                    <input type="text" placeholder="Enter Address" id="address" name="address" >
                </div>

                <div class="row">
                    <label for="section">Section</label>
                    <input type="text"placeholder="Enter Section" id="section" name="section" >
                </div>

                <div class="row">
                    <label for="medicalaid">Medical Aid</label>
                    <input type="text" placeholder="Enter Medical Aid" id="medicalaid" name="medicalaid" >
                </div>
                <br><br>

                <!--Buttons to submit and cancel-->
                <div class="row">
                    <input type="submit" name="Register" value="Register">
                </div>

                <div class="row">
                    <input type="button" onclick="document.location = 'view.php';" value="Cancel" />
                </div>

            </form>
        </div>   
    </body>
</HTML>































