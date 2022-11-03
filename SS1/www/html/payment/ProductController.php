<?php # src/Controller/ProductController.php
namespace App\Controller;

use Symfony\Component\HttpFoundation\Response;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Routing\Annotation\Route;

class ProductController extends AbstractController {
	/**
	 * @Route("/products", name="product_list")
	 */
	public function product_list(): Response {
		$products = [
			1 => (object) [
				'name' => 'iPhone 14',
				'price' => 999,
				'description' => 'Buy the new iPhone now',
			],
			2 => (object) [
				'name' => 'Samsung Galaxy Z Flip4',
				'price' => 720,
				'description' => 'This is not better than iPhone',
			],
		];
		return $this->render('product_list.html.twig', [
			'products' => $products
		]);
	}
	/**
	 * @Route("/product/{id<\d+>}", name="product_detail")
	 */
	public function product_detail(int $id): Response {
		$products = [
			1 => (object) [
				'name' => 'iPhone 14',
				'price' => 999,
				'description' => 'Buy the new iPhone now',
			],
			2 => (object) [
				'name' => 'Samsung Galaxy Z Flip4',
				'price' => 720,
				'description' => 'This is not better than iPhone',
			],
		];
		if (isset($products[$id])) {
			$product = $products[$id];
			return $this->render('product_detail.html.twig', [
				'product' => $product
			]);
		} else {
			return new Response('Product not found!');
		}
	}
}