<?php
// Include config file
include 'config.php';
include "header.php";

// select all query 
$sql = "SELECT * FROM contacts";
$result = $conn->query($sql);
?>
<!DOCTYPE html>
<html>

    <head>
        <title>Contacts Management System</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

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

        <!-- Button to Add new contact -->
        <a href="addcontact.php" name title="Add Contacts" data-toggle='tooltip' id="btn-add"  class="add-btn">Add New Contact</a>

        <!-- Button to log out -->
        <a href="logout.php"  title='Logout' data-toggle='tooltip' class="logout-btn" onclick="return confirm('Are you sure you want to logout?');">Logout</a>

        <table id="contactinfo">

            <h2>All contacts</h2>

            <!--Search bar-->
            <input id="myInput" name="search" type="text" placeholder="Search Contacts..." ><br><br>

            <!-- Table heading-->
            <tr>
                <th>S.No</th>
                <th>Names</th>
                <th>Phone</th>
                <th>Edit</th>
                <th>Delete</th>

            </tr>

            <?php
//pull Data from the database
            if ($result->num_rows > 0) {
                while ($row = $result->fetch_assoc()) {
                    ?>
                    <tr>
                        <td><?php echo $row['s_no']; ?></td>
                        <td><?php echo $row['names']; ?></td>
                        <td><?php echo $row['phone']; ?></td>

                        <!--submit and cancel buttons-->
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
                            if (confirm("Are you sure you want to delete the contact?")) {
                                window.location.href = 'delete.php?s_no=' + delid + '';
                                return true;
                            }
                        }
                    </script>
                    <?php
                }
            } else {
                ?>

                <p> <em>Sorry! No Contacts found!</em> </p>

                <?php
            }
            ?>

        </table>

        <div class="pagination">

            <a href="#"class="active">1</a>
            <a href="#" >2</a>
            <a href="#">3</a>

            <a href="#">&raquo;</a>
        </div>
        <br><br>
        <!--Business and private contacts and Delete all btns  -->
        <a href="business.php" title="Business Contacts" data-toggle="tooltip" class="business-btn">Business Contacts</a>
        <a href="private.php" title="Private Contacts" data-toggle="tooltip" class="private-btn">Private Contacts</a>
        <a href="deleteall.php"  title='delete all' data-toggle='tooltip' class="del_all-btn" onclick="return confirm('Are you sure to delete all your contacts?');">Delete all</a>


    </body>

</html>