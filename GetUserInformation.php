<?php
define('HOST','localhost');
define('USER','root');
define('PASS','');
define('DB','logindb');
$con = mysqli_connect(HOST,USER,PASS,DB);
$sql = "select username,photo from users";
$res = mysqli_query($con,$sql);
 while ($row = mysqli_fetch_array($res)) {
     $array[] = array("username" => $row['username'],"photo" => $row['photo']);
 }
    
    echo json_encode($array , JSON_PRETTY_PRINT);

?>
