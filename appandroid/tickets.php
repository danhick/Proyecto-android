<?php
$conn = new mysqli("localhost", "id11661395_aplicacionado","appado","id11661395_aplicacionado");
// Check connection
$data =$conn -> query("SELECT * FROM login ");
if ($data->num_rows <0){
    echo '<div class="alert alert-info alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button> No se encontraron datos.</div>';

}else {
    $conn->close();
    var_dump($data);
    while ($row= mysqli_fetch_assoc($data)) {
        $id=$row["idlogin"];
        $usuario=$row["usuario"];
        $correo=$row["correo"];
        $password=$row["password"];
        
    }
   $res = array ($id,$usuario,$correo,$password);
    return json_encode($res);
    
}
   


?>