<<<<<<< HEAD
<?php
$users = json_decode(file_get_contents("users.txt"));

function getUser($username, $users) {
	foreach ($users as $user) {
		if ($user->username == $username) {
			return $user;
		}
	}
	return false;
}
=======
<?php
$users = json_decode(file_get_contents("users.txt"));

function getUser($username, $users) {
	foreach ($users as $user) {
		if ($user->username == $username) {
			return $user;
		}
	}
	return false;
}
>>>>>>> origin/main
?>