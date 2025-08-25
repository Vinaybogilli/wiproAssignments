
interface Vehicle {
    double calculateDistance();
}


class FuelCar implements Vehicle {
    double fuelLiters;
    double mileage; 

    FuelCar(double fuelLiters, double mileage) {
        this.fuelLiters = fuelLiters;
        this.mileage = mileage;
    }

    public double calculateDistance() {
        return fuelLiters * mileage;
    }

   
}


class ElectricCar implements Vehicle {
    double batteryPercent;
    double efficiency; 

    ElectricCar(double batteryPercent, double efficiency) {
        this.batteryPercent = batteryPercent;
        this.efficiency = efficiency;
    }

    public double calculateDistance() {
        return batteryPercent * efficiency;
    }

}



public class liksovdiversion {

	public static void main(String[] args) {
		FuelCar fuelCar = new FuelCar(10, 15);       
        ElectricCar electricCar = new ElectricCar(80, 1.2);
        System.out.println("FuelCar can travel: " + fuelCar.calculateDistance() + " km");
        System.out.println("ElectricCar can travel: " + electricCar.calculateDistance() + " km");

	}

}
