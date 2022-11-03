package Tut09.bridge.remotes;

import Tut09.bridge.devices.Device;

public class BasicRemote implements Remote {
	protected Device device;

	public BasicRemote() {
	}

	public BasicRemote(Device device) {
		this.device = device;
	}

	@Override
	public void power() {
		System.out.println("Remote: power toggle");
		if (device.isEnabled()) {
			device.disable();
		} else {
			device.enable();
		}
	}

	//TO-DO: Implement the volumeDown() method
	@Override
	public void volumeDown() {
		//Display the current status is 'volume down'
		System.out.println("Remote: volume down");
        
        //Decrease the current volume for 10
		device.setVolume(10);
	}

	//TO-DO: Implement the volumeUp() method
	@Override
	public void volumeUp() {
		//Display the current status is 'volume up'
		System.out.println("Remote: volume up");
        
        //Increase the current volume for 10
		device.setVolume(10);
	}

	//TO-DO: Implement the channelDown() method
	@Override
	public void channelDown() {
		//Display the current status is 'channel down'
		System.out.println("Remote: channel down");
        
        //Decrease the current channel for 1
		device.setChannel(1);
	}
	
	//TO-DO: Implement the channelUp() method
	@Override
	public void channelUp() {
		//Display the current status is 'channel up'
		System.out.println("Remote: channel up");
        
        //Increase the current channel for 1
		device.setVolume(1);
	}
}
