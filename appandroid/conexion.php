<?php
$conn = mysqli_connect("mysql.webcindario.com","appado","appado","appado");
// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
echo "Bienvenido";
mysqli_close($conn);

?>