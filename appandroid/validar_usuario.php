<?php
include 'conexion1.php';
$usu_usuario=$_POST['usuario'];
$usu_password=$_POST['pass'];

//$usu_usuario="h";
//$usu_password="1234";

$sentencia=$conexion->prepare("SELECT * FROM login WHERE usuario=? AND pass=?");
$sentencia->bind_param('ss',$usu_usuario,$usu_password);
$sentencia->execute();

$resultado = $sentencia->get_result();
if ($fila = $resultado->fetch_assoc()) {
         echo json_encode($fila,JSON_UNESCAPED_UNICODE);     
}
$sentencia->close();
$conexion->close();
?>