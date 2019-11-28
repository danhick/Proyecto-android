<?php
header('Content-Type: application/json');
$conexion = new mysqli("mysql.webcindario.com","appado","appado","appado");
// Check connection
$usuario=$_POST["usuario"];
$correo=$_POST["correo"];
$contra=$_POST["pass"];

$data = $conexion -> query("INSERT INTO login (usuario,correo,pass) values('$usuario','$correo','$contra')");

$response = array();
$response ["success"] =true;

echo json_encode($response);

?>