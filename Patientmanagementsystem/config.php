<?php
$hostname = 'localhost';
$dbusername = 'root';
$dbpassword = '';
$database = 'patientmanagementsystem';

// Create connection
$conn = new mysqli($hostname, $dbusername, $dbpassword, $database);

// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
  
}

 //function to sanitize strings 
function sanitizeString($var)
 {
 if (get_magic_quotes_gpc())
 $var = stripslashes($var);
 $var = strip_tags($var);
 $var = htmlentities($var);
 return $var;
 }
?>






