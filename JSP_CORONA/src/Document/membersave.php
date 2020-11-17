<html>
   <meta charset="utf-8">
<?php
 
$host = 'localhost';
$user = 'root';
$pw = '1234';
$dbName = 'diring_db';
$mysql = new mysqli($host, $user, $pw, $dbName);
 
 $id=$_POST['id'];
 $password=$_POST['pwd'];
 $name=$_POST['name'];
 $position=$_POST['position'];
 
 
 $sql = "insert into member1";             
 $sql = $sql. "values('$id','$password','$name','$position')";         
 if($mysql->query($sql)){                                                             
  echo 'success inserting <p/>';                                                           
  echo $name.'님 가입 되셨습니다.<p/>';                                   
 }else{                                                                               
  echo 'fail to insert sql';                                                            
 }
mysqli_close($mysql);
 
 
?>
<input type="button" value="로그인하러가기" onclick="location='index.php'">
</html>