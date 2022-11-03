package Tut09.bridge.devices;

public class Radio implements Device {
	private boolean on = false;
	private int volume = 30;
	private int channel = 1;
	 
	@Override
	public boolean isEnabled() {
		return on;
	}

	@Override
	public void enable() {
		on = true;
	}

	@Override
	public void disable() {
		on = false;
	}

	//TO-DO: Implement getVolume() method
	@Override
	public int getVolume() {
		return volume;
	}

	//TO-DO: Implement setVolume() method
	@Override
	public void setVolume(int volume) {
		//use 'if-elseif-else' structure to limit the volume from 0 to 100
		//outside the range is invalid
	 	if (volume >= 0 && volume <= 100) this.volume = volume;
	}

	//TO-DO: Implement getChannel() method
	@Override
	public int getChannel() {
		return channel;
	}

	//TO-DO: Implement setChannel() method
	@Override
	public void setChannel(int channel) {
		 this.channel = channel;
	}

	//TO-DO: Implement printStatus() method
	@Override
	public void printStatus() {
		//Show the current device is radio
		System.out.println("Device: The current device is radio");
		
		//Show the current status: enabled or disabled
		System.out.println("Device: The current status is " + isEnabled());
		
		//Show the current volume
		System.out.println("Device: The current volume is " + getVolume());
		
		//Show the current channel
		System.out.println("Device: The current channel is " + getChannel());
	}
}
