<?php
require "conn.php";

$hoten = $_POST["hoten"];
$dienthoai = $_POST["dienthoai"];
$diachi = $_POST["diachi"];
$email = $_POST["email"];
$gioitinh = $_POST["gioitinh"];
$password = $_POST["password"];

$isValiEmail = filter_var($email, FILTER_VALIDATE_EMAIL);
if($conn){
if(strlen('$passsword')>40||strlen('$password')<6){
echo "Password must be less than 40";
}else if($isValiEmail ==false){
echo "This Email is not valid";
}
else{
$sqlCheckHoten = "SELECT * FROM `taikhoan` WHERE `hoten` LIKE '$hoten'";
$hotenQuery = mysqli_query($conn, $sqlCheckHoten);

$sqlCheckEmail= "SELECT*FROM `taikhoan` WHERE `email` LIKE '$email'";
$emailQuery = mysqli_query($conn, $sqlCheckEmail);

if(mysqli_num_rows($hotenQuery)>0){
echo "User name is allready used, type another one";
}else if(mysqli_num_rows($emailQuery)>0){
echo "Email is allready used, type another one";
}else{
$sql_register = "INSERT INTO `taikhoan`(`HOTEN`,`DIENTHOAI`,`DIACHI`,`EMAIL`,`GIOITINH`,`PASSWORD`) VALUES('$hoten', '$dienthoai', '$diachi', '$email', '$gioitinh', '$password')";
if(mysqli_query($conn, $sql_register)){
echo "Successful Register";
}
else{
echo "Failed to register!";
}
}
}
}
else{
echo "Connection Error";
}
?>