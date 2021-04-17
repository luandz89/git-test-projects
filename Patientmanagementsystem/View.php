<?php
// Include config file
include 'config.php';

// Get the select query execution
$sql = "SELECT * FROM patientinfo";
$result = $conn->query($sql);
?>
<!DOCTYPE html>
<html>
    <head>
        <title>Patient Management System Register</title>
        <!-- Form Stylesheet-->
        <link rel="stylesheet" type="text/css" href="Style.css">
    </head>
    <body>

        <!-- Form heading-->
        <h1 style="text-shadow: 2px 2px 5px gold; text-align:center">Patient Management System Dashboard: </h1>

        <!-- Button to Add new Patient -->
        <a href="register.php" title='Add new patient' class="one">Add New Patient</a>
        <!-- Button to Delete All -->
        <a href="DeleteAll.php"  title='Delete all'  class="deleteall" onclick="return confirm('Are you sure you want to delete all?');">Delete All</a>

        <!-- Button to logout -->
        <a href="logout.php"  title='Logout' class="logout" onclick="return confirm('Are you sure to logout?');">Logout</a>
        <br><br>

        <table id="patientinfo" >

            <!-- Table heading-->
            <tr>
                <th>Patient ID</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Date Of Birth</th>
                <th>Gender</th>
                <th>Phone Number</th>
                <th>Address</th>
                <th>Section</th>
                <th>Medical Aid</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>

<?php
//Fetch Data form database
if ($result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        ?>
                    <tr>
                        <td><?php echo $row['patientid']; ?></td>
                        <td><?php echo $row['name']; ?></td>
                        <td><?php echo $row['surname']; ?></td>
                        <td><?php echo $row['dob']; ?></td>
                        <td><?php echo $row['gender']; ?></td>
                        <td><?php echo $row['phone']; ?></td>
                        <td><?php echo $row['address']; ?></td>
                        <td><?php echo $row['section']; ?></td>
                        <td><?php echo $row['medical_aid']; ?></td>

                        <!--Buttons to Update and Delete-->
                        <td>
                            <a href="update.php?edit=<?php echo $row['patientid']; ?>" class="update_btn" >Update</a>
                        </td>
                        <td>
                            <input type="button" onClick="deleteme(<?php echo $row['patientid']; ?>)" class="delete_btn" name="Delete" value="Delete">
                        </td>
                    </tr>

                    <!-- Javascript function for deleting data -->
                    <script language="javascript">
                        function deleteme(delid)
                        {
                            if (confirm("Do you want to Delete?")) {
                                window.location.href = 'delete.php?id=' + delid + '';
                                return true;
                            }
                        }
                    </script>
        <?php
    }
} else {
    ?>
                <p><em>No patients were found.</em></p>
                <?php
            }
            ?>

        </table>

    </body>
</html>
