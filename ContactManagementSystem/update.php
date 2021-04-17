<?php
//pull the row to be updated
include_once 'config.php';
if (isset($_GET['edit'])) {
    $id = $_GET['edit'];
    $update = true;
    //SQL statement to fetch selected data from table
    $record = mysqli_query($conn, "SELECT * FROM contacts WHERE s_no=$id");


    $n = mysqli_fetch_array($record);
    $names = sanitizeString($n['names']);
    $profession = sanitizeString($n['profession']);
    $emailaddress = sanitizeString($n['emailaddress']);
    $phone = sanitizeString($n['phone']);
    $city = sanitizeString($n['city']);
    $address = sanitizeString($n['address']);
    $contact_group = sanitizeString($n['contact_group']);
}
?>

<HTML>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Form Stylesheet-->
        <link rel="stylesheet" type="text/css" href="Style.css">
        <title>Contact Management System Edit</title>
        <h1 style="text-shadow: 2px 2px 5px gold; text-align:center"> Contacts Management System</h1>
    </head>
    <body>
        <?php
// Include config file
        include_once 'config.php';

        if (isset($_POST['update'])) {

            $names = sanitizeString($_POST['names']);
            $profession = sanitizeString($_POST['profession']);
            $emailaddress = sanitizeString($_POST['emailaddress']);
            $phone = sanitizeString($_POST['phone']);
            $city = sanitizeString($_POST['city']);
            $address = sanitizeString($_POST['address']);
            $contact_group = sanitizeString($_POST['contact_group']);

// Update SQL statement to Update on database
            $sql = "UPDATE contacts SET names='$names', profession='$profession', emailaddress='$emailaddress', phone='$phone', city='$city', address='$address', contact_group='$contact_group' WHERE s_no='$id'";


            if (mysqli_query($conn, $sql)) {

                echo "<script>alert('Contact updated successfully');document.location=' view.php'</script>";
            } else {
                echo "Error: " . $sql . ":-" . mysqli_error($conn);
            }
            mysqli_close($conn);
        }
        ?>
        <div class="container">		
            <h1 style="text-shadow: 2px 2px 5px gold; text-align:center"> Edit Contact:</h1>
            <!-- Javascript function for calling the validation form -->	
            <script src="validate_function.js"></script> 

            <!--Form for data insertion--> 
            <form method="post"  action="<?php $_PHP_SELF ?>" >

                <input type="hidden" name="id" value="<?php echo $id; ?>">
                <div class="row">
                    <label for="name">Names</label>
                    <input type="text" name="names" value="<?php echo $names; ?>" required>
                </div>

                <div class="row">
                    <label for="profession">Profession</label>
                    <input type="text" name="profession" value="<?php echo $profession; ?>" required >
                </div>

                <div class="row">
                    <label for="email">Email</label>
                    <input type="email"  name="emailaddress" value="<?php echo $emailaddress; ?>" required >
                </div>
                <div class="row">
                    <label for="phone">Phone</label>
                    <input type="text"  pattern="[0-9]{3}?[0-9]{3}?[0-9]{4}" name="phone" value="<?php echo $phone; ?>" required>
                </div>

                <div class="row">
                    <label for="ward">City</label>
                    <input type="text" name="city" value="<?php echo $city; ?>" required >
                </div>

                <div class="row">
                    <label for="address">Address</label>
                    <input type="text" name="address" value="<?php echo $address; ?>" required >
                </div>
                <div class="row">
                    <label for="contact_group">Contact_group</label>
                    <input type="text" name="contact_group" value="<?php echo $contact_group; ?>" required >
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
        <br><br>
    </body>
</HTML>


