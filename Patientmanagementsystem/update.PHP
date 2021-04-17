<?php
//fetch the record to be updated
include_once 'config.php';
if (isset($_GET['edit'])) {
    $id = $_GET['edit'];
    $update = true;
    //SQL statement to fetch selected data from table
    $record = mysqli_query($conn, "SELECT * FROM patientinfo WHERE patientid=$id");


    $n = mysqli_fetch_array($record);
    $name = sanitizeString($n['name']);
    $surname = sanitizeString($n['surname']);
    $dob = sanitizeString($n['dob']);
    $gender = sanitizeString($n['gender']);
    $phone = sanitizeString($n['phone']);
    $address = sanitizeString($n['address']);
    $section = sanitizeString($n['section']);
    $medicalaid = sanitizeString($n['medical_aid']);
}
?>

<HTML>
    <head>
        <!-- Form Stylesheet-->
        <link rel="stylesheet" type="text/css" href="Style.css">
        <title>Patient Management System Update</title>
    </head>
    <body>
        <?php
// Include config file
        include_once 'config.php';

        if (isset($_POST['update'])) {

            $name = sanitizeString($_POST['name']);
            $surname = sanitizeString($_POST['surname']);
            $dob = sanitizeString($_POST['dob']);
            $gender = sanitizeString($_POST['gender']);
            $phone = sanitizeString($_POST['phonenumber']);
            $address = sanitizeString($_POST['address']);
            $section = sanitizeString($_POST['section']);
            $medicalaid = sanitizeString($_POST['medicalaid']);

            // Update SQL statement to Update on database
            $sql = "UPDATE patientinfo SET name='$name',surname='$surname', dob='$dob',gender='$gender', 
                    phone='$phone', address='$address', section='$section', medical_aid='$medicalaid' WHERE patientid='$id'";


            if (mysqli_query($conn, $sql)) {

                echo "<script>alert('Patient updated successfully');document.location=' view.php'</script>";
            } else {
                echo "Error: " . $sql . ":-" . mysqli_error($conn);
            }
            mysqli_close($conn);
        }
        ?>
        <div class="container">		
            <h1 style="text-shadow: 2px 2px 5px gold; text-align:center">Update/Edit Patient Information: </h1>
            <!-- Javascript function for calling the validation form -->	
            <script src="validate_function.js"></script> 

            <!--Form for data insertion--> 
            <form method="post"  action="<?php $_PHP_SELF ?>" >

                <input type="hidden" name="id" value="<?php echo $id; ?>">
                <div class="row">
                    <label for="name">Name</label>
                    <input type="text" name="name" value="<?php echo $name; ?>" required>
                </div>

                <div class="row">
                    <label for="surname">Surname</label>
                    <input type="text" name="surname"value="<?php echo $surname; ?>" required >
                </div>

                <div class="row">
                    <label for="dob">Date of Birth</label>
                    <input type="date" name="dob" value="<?php echo $dob; ?>" required>
                </div>
                <div class="row"> 
                    <div class="col-25">
                        <label for="gender">Gender</label>
                    </div>
                    <div class="col-75">
                        <input type="text" name="gender" value="<?php echo $gender; ?>" required>
                    </div>
                </div>
                <div class="row">
                    <label for="phonenumber">Phone number</label>
                    <input type="text" pattern="[0-9]{3}?[0-9]{3}?[0-9]{4}" name="phonenumber" value="<?php echo $phone; ?>" required>
                </div>

                <div class="row">
                    <label for="address">Address</label>
                    <input type="text" name="address" value="<?php echo $address; ?>" required>
                </div>

                <div class="row">
                    <label for="section">Section</label>
                    <input type="text" name="section" value="<?php echo $section; ?>" required>
                </div>

                <div class="row">
                    <label for="medicalaid">Medical Aid</label>
                    <input type="text" name="medicalaid"  value="<?php echo $medicalaid; ?>" required>
                </div>
                <br><br>

                <!--Buttons to submit and cancel-->
                <div class="row">
                    <input type="submit" name="update" value="Update">
                </div>

                <div class="row">
                    <input type="button" onclick="document.location = 'view.php';" value="Cancel" />
                </div>

            </form>	
        </div> 
    </body>
</HTML>










































