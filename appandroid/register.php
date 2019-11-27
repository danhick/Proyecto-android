<?php
$conn = new mysqli("localhost","root","id11661395_aplicacionado");
// Check connection
$usuario=$_POST["usuario"];
$correo=$_POST["correo"];
$contra=$_POST["pass"];

$data = $conn -> query("INSERT INTO login (usuario,correo,pass) values('$usuario','$correo','$contra')";
mysqli_stmt_bind_param($data,"sss",$usuario,$correo,$contra);
mysqli_stmt_execute($data);
$response = array();
$response ["success"] =true;

echo json_encode($response);

?>