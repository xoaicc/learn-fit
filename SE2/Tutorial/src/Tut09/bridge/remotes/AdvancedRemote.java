package Tut09.bridge.remotes;

import Tut09.bridge.devices.Device;

public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    //TO-DO: Implement the mute() method
    public void mute() {
    	//Display the current volume status is 'mute'
        System.out.println("The volume status is 'mute'");
         
        //Set the volume to 0
        device.setVolume(0);
    }
}
