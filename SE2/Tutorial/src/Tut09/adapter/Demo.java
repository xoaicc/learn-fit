package Tut09.adapter;

import Tut09.adapter.adapter.SquarePegAdapter;
import Tut09.adapter.round.RoundHole;
import Tut09.adapter.round.RoundPeg;
import Tut09.adapter.square.SquarePeg;

/**
 * Somewhere in client code...
 */
public class Demo {
	public static void main(String[] args) {
		//TO-DO: Create 2 instances of RoundHole and RoundPeg with same radius
		RoundHole rh = new RoundHole(10.4);
		RoundPeg rp = new RoundPeg(10.4);
	 
		//TO-DO: If RoundHole instance can "fits" with RoundPeg instance => show a message
		if (rh.fits(rp)) System.out.println("RoundHole instance fits with RoundPeg instance!");
	 
		//TO-DO: Create 2 instances of SquarePeg with 2 different widths
		SquarePeg sp1 = new SquarePeg(10.6);
		SquarePeg sp2 = new SquarePeg(20.2);
 
		//Note: You can't make RoundHole instance "fit" with SquarePeg instance
		//Therefore, we need to use Adapter for solving the problem.
		
		//TO-DO: Create 2 corresponding instances of SquarePegAdapter
		SquarePegAdapter spa1 = new SquarePegAdapter(sp1);
		SquarePegAdapter spa2 = new SquarePegAdapter(sp2);
		 
		//TO-DO: If the RoundHole instance can "fits" with "small" RoundPegAdapter instance 
		//show a suitable message
		if(rh.fits(spa1)) System.out.println("RoundHole instance fits with small RoundPegAdapter instance!");
	 
		//TO-DO: If the RoundHole instance can not "fits" with "big" RoundPegAdapter instance 
		//show a suitable message
		if(rh.fits(spa2)) System.out.println("RoundHole instance fits with big RoundPegAdapter instance!");
	}
}