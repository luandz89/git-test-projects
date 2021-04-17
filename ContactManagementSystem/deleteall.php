<?php

// Include config file
include_once 'config.php';
// Delete All SQL statement to delete on database
$truncatetable = "TRUNCATE TABLE contacts";

$query = mysqli_query($conn, $truncatetable) or die($truncatetable);
header("Location: view.php");
?>

