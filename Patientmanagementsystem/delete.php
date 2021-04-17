<?php
// Include config file
include_once 'config.php';
// Delete SQL statement to delete on database
$select="DELETE FROM patientinfo where patientid='".$_GET['id']."'";

$query = mysqli_query($conn, $select) or die($select);
header ("Location: view.php");

?>




