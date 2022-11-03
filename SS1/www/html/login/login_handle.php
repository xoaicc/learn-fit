<?php
function getUser($username, $users) {
	foreach ($users as $user) {
		if ($user->username == $username) {
			return $user;
		}
	}
	return false;
}

$users = json_decode(file_get_contents("users.txt"));

if (isset($_COOKIE['login'])) {
	$username = $_COOKIE['login'];
	$objUser = getUser($username, $users);
	if ($objUser) {
		?>
		Welcome, <?=$objUser->username?>!<br />
		<a href="logout.php">Logout</a>
		<?php
	}
} else if (count($_POST) > 0) {
	$username = $_POST['username'];
	$password = $_POST['password'];
	
	objUser = getUser($username, $users);
	if ($objUser) {
		if ($objUser->password == $password) {
			setcookie('login', $objUser->username, time() + 300);
			header('Location: login_handle.php');
		}
	} else {
		echo "User $username does not exist!<br />";
	}
}
?>