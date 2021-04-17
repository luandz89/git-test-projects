<?php
// Include config file
include 'config.php';
include "header.php";

// Get the select query execution
$sql = "SELECT s_no, names, phone  FROM contacts WHERE contact_group = 'Private'";
$result = $conn->query($sql);
?>
<!DOCTYPE html>
<html>

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Private contacts</title>

        <!-- Form Stylesheet-->
        <link rel="stylesheet" href="style.css">

        <!--Calling Jquery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <!-- Javascript function for calling the validation form -->
        <script src="validate_function.js"></script> 

        <!--Search bar script-->
        <script>$(document).ready(function () {
                $("#myInput").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#contactinfo tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
            });

        </script>
    </head>

    <body>

        <table id="contactinfo">
            <h2>Private contacts</h2>

            <!--Search bar-->
            <input id="myInput" name="search" type="text" placeholder="Search..." ><br><br>

            <!-- Table heading-->
            <tr>
                <th>S.No</th>
                <th>Names</th>
                <th>Phone</th>
                <th>Edit</th>
                <th>Delete</th>      
            </tr>

            <?php
//Fetch Data form database
            if ($result->num_rows > 0) {
                while ($row = $result->fetch_assoc()) {
                    ?>
                    <tr>
                        <td><?php echo $row['s_no']; ?></td>
                        <td><?php echo $row['names']; ?></td>
                        <td><?php echo $row['phone']; ?></td>

                        <!--Buttons to edit and Delete-->
<td>
<a href="update.php?edit=<?php echo $row['s_no']; ?>"  title="Edit" data-toggle='tooltip'  class="edit-btn" >Edit</a><br>
</td>
<td>
    <input type="button" onClick="deleteme(<?php echo $row['s_no']; ?>)"  title="Delete" data-toggle='tooltip'  class="delete-btn" name="Delete" value="Delete">
</td>
</tr>
 
<!-- Javascript function for deleting data -->
 <script language="javascript">
 function deleteme(delid)
 {
 if(confirm("Are you sure you want to delete the contact?")){
 window.location.href='delete.php?s_no=' +delid+'';
 return true;
 }
 } 
 </script>
                    <?php
                }
            } else {
                ?>
                <p> <em>Sorry! No Contacts found!!</em> </p>

                <?php
            }
            ?>

        </table>
        <br>
        <!--link to all contacts-->
        <a href="view.php" class="All-btn">All contacts</a>
    </body>

</html>





















