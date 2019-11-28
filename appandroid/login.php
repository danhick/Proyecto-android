<?php
header('Content-Type: application/json');
$conn = new mysqli("mysql.webcindario.com","appado","appado","appado");
// Check connection

$usuario=$_POST["usuario"];
$contra=$_POST["pass"];

$data =$conn -> query("SELECT * FROM login where usuario='$usuario' and pass='$contra'");
if ($data->num_rows <0){
    echo '<div class="alert alert-info alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button> No se encontraron datos.</div>';

}else {
    $conn->close();
   
    while ($row= mysqli_fetch_assoc($data)) {
        $id=$row["idlogin"];
        $usuario=$row["usuario"];
        $correo=$row["correo"];
        $contra=$row["pass"];
        
    }
    
   $res = array ("id"=>$id,"usuario"=>$usuario,"correo"=>$correo,"pass"=>$contra);
   
   return print_r(json_encode($res));
    
}
   


?>