<?php
$conn = mysqli_connect("localhost", "root","id11661395_aplicacionado"
// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
echo "Bienvenido";
mysqli_close($conn);

?>