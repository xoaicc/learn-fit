<?php # src/Controller/PageController.php
namespace App\Controller;

use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class PageController {
	/**
	 * @Route("/about.html")
	 */
	public function about(): Response {
		return new Response(
			'<html><body>This is the about page.</body></html>'
		);
	}
	/**
	 * @Route("/contact.html")
	 */
	public function contact(): Response {
		return new Response(
			'<html><body>This is the contact page.</body></html>'
		);
	}
}