<?php

// Include config file
include_once 'config.php';
// Delete SQL statement to delete on database
$select = "DELETE FROM contacts where s_no='" . $_GET['s_no'] . "'";

$query = mysqli_query($conn, $select) or die($select);
header("Location: view.php");
?>





