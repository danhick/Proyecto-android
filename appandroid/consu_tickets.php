<?php

include 'conexion1.php';

$hida=$_POST['hida'];
$hvuelta=$_POST['hvuelta'];
$destino=$_POST['destino'];
$origen=$_POST['origen'];
$redondo=$_POST['redondo'];
$asiento=$_POST['totalasientos'];
$total=$_POST['total'];   
$subtotal=$_POST['subtotal'];

$data = $conexion -> query("INSERT INTO tickets (origen,destino,hida,hvuelta,redondo,totalasientos,subtotal,total) 
values('$origen','$destino','$hida','$hvuelta','$redondo','$asiento',$subtotal,$total)");

//$data = $conexion -> query("SELECT * FROM tickets");// (origen,destino,hida,hvuelta)
//values('$origen','$destino','$hida','$hvuelta')",);


/*$response = array($data);
$response ["success"] =true;*/

//echo json_encode($response);

$resultado = $conexion->insert_id;



echo json_encode(array("id"=>$resultado),JSON_UNESCAPED_UNICODE);     

$sentencia->close();
$conexion->close();


?>