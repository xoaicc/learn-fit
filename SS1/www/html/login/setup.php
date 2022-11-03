<?php
$objUser1 = new stdClass();
$objUser1->username = 'xoaicc';
$objUser1->password = '123';

$objUser2 = new stdClass();
$objUser2->username = 'xoaic';
$objUser2->password = '1234';

$users = [
	$objUser1,
	$objUser2
];

$strJSON = json_encode($users);
echo $strJSON;
?>