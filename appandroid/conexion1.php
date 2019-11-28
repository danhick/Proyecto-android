<?php
$hostname='mysql.webcindario.com';
$database='appado';
$username='appado';
$password='appado';

$conexion=new mysqli($hostname,$username,$password,$database);
if($conexion->connect_errno){
    echo "El sitio web está experimentado problemas";
}
?>