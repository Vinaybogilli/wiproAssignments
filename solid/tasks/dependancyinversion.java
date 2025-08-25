interface Switchable {
    void turnOn();
    void turnOff();
}

class LightBulb implements Switchable {
    public void turnOn() {
        System.out.println("LightBulb ON");
    }

    public void turnOff() {
        System.out.println("LightBulb OFF");
    }
}

class Fan implements Switchable {
    public void turnOn() {
        System.out.println("Fan ON");
    }

    public void turnOff() {
        System.out.println("Fan OFF");
    }
}

class ElectricSwitch {
    private Switchable device;

    ElectricSwitch(Switchable device) {
        this.device = device;
    }

    void press() {
        device.turnOn();
    }
}



public class dependancyinversion {

	public static void main(String[] args) {
		Switchable bulb = new LightBulb();
        ElectricSwitch bulbSwitch = new ElectricSwitch(bulb);
        bulbSwitch.press();  
        
        Switchable fan = new Fan();
        ElectricSwitch fanSwitch = new ElectricSwitch(fan);
        fanSwitch.press();   

	}

}
