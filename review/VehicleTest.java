abstract class Vehicle{
    String modelName;
    String Company;
    String Owner;
    String engineType;
    double  tankSize;
    double  fuelConsumption;
    Vehicle(String modelName,String Company, String Owner, String engineType,double  tankSize,double fuelConsumption){
	     this.modelName = modelName;
	     this.Company = Company;
	     this.Owner = Owner;
	     this.engineType = engineType;
	     this.tankSize = tankSize;
	     this.fuelConsumption = fuelConsumption;
    }
    public abstract String toString();

    double movableDistance(){
	     return tankSize*fuelConsumption;
    };
    public abstract double costFor100Km(PetroleumPrice x);
    public abstract void setAirConON();
}

class Car extends Vehicle{
    int numberOfSeats;
    boolean airConditiOn;
    Car(String modelName,String Company, String Owner, String engineType,double  tankSize,double fuelConsumption,int numberOfSeats){
	     super(modelName,Company,Owner,engineType,tankSize,fuelConsumption);
	     this.numberOfSeats = numberOfSeats;
    }

    public String toString(){
	     return "ModelName: "+modelName+", Company: "+Company+", Owner: "+Owner+", EngineType: "+engineType+", TankSize:"+tankSize+", FuelConsumption: "+fuelConsumption+", NumberOfSeat: "+numberOfSeats;
    }
    public double costFor100Km(PetroleumPrice x){
	    return (100.0/fuelConsumption)*x.getGasolineCost();
    }
    public void setAirConON(){
	     this.airConditiOn = true;
	     this.fuelConsumption *= 0.85;
    }

}

class MiniVan extends Vehicle{
    int numberOfSeats;
    boolean hasAutoDoor;
    boolean airConditiOn=false;
    MiniVan(String modelName,String Company, String Owner, String engineType,double  tankSize,double fuelConsumption,int numberOfSeats,boolean hasAutoDoor){
	super(modelName,Company,Owner,engineType,tankSize,fuelConsumption);
	this.numberOfSeats = numberOfSeats;
	this.hasAutoDoor = hasAutoDoor;
    }
     public String toString(){
	 return "ModelName: "+modelName+", Company: "+Company+", Owner: "+Owner+", EngineType: "+engineType+", TankSize:"+tankSize+", FuelConsumption: "+fuelConsumption+", NumberOfSeat: "+numberOfSeats+",\nHasAutodoor: "+ hasAutoDoor;
    }
    public double costFor100Km(PetroleumPrice x){
	if(engineType == "Gasoline")
	    return (100.0/fuelConsumption)*x.getGasolineCost();
	return (100.0/fuelConsumption) * x.getDieselCost();
    }
    public void setAirConON(){
	this.airConditiOn = true;
	this.fuelConsumption *= 0.75;
    }
}

class Truck extends Vehicle{
    int numberOfSeats;
    int power;
    boolean airConditiOn=false;
    Truck(String modelName,String Company, String Owner, String engineType,double  tankSize,double fuelConsumption,int numberOfSeats,int power){
	super(modelName,Company,Owner,engineType,tankSize,fuelConsumption);
	this.numberOfSeats = numberOfSeats;
	this.power = power;
    }
    public String toString(){
	return "ModelName: "+modelName+", Company: "+Company+", Owner: "+Owner+", EngineType: "+engineType+", TankSize:"+tankSize+", FuelConsumption: "+fuelConsumption+", NumberOfSeat: "+numberOfSeats+",\npower: "+ power;
    }
    public double costFor100Km(PetroleumPrice x){
	return (100.0/fuelConsumption) * x.getDieselCost();
    }
    public void setAirConON(){
	this.airConditiOn = true;
	this.fuelConsumption *= 0.75;
    }
}

class PetroleumPrice{
    double gasolinePrice,dieselPrice;
    PetroleumPrice(double gasolinePrice, double dieselPrice ){
	this.gasolinePrice =  gasolinePrice;
	this.dieselPrice = dieselPrice;
    }
    double getGasolineCost(){
	return gasolinePrice;
    }
    double getDieselCost(){
	return dieselPrice;
    }
}

public class VehicleTest {

    public static void describe(Vehicle v) {
        System.out.println(v);
    }

    public static void main(String[] args) {
        Vehicle vehicles[] = {
	    new Car("Camley", "Toyota", "Suzuki", "Gasoline", 70., 15.15, 5),
	    new Car("Aqua", "Toyota", "Nakajima", "Hybrid", 36., 40.0, 5),
	    new MiniVan("Sienna", "Toyota", "Tanaka", "Gasoline", 75.,  9.0, 8, true),
	    new MiniVan("Odyssey", "Honda", "Kikuchi", "Diesel", 56., 11.0, 8, false),
	    new MiniVan("Presage", "Nissan", "Shirotora", "Gasoline", 60., 7.0, 7, false),
	    new Truck("Tundra", "Toyota", "Sugai", "Diesel", 100., 6.76, 5, 310),
	    new Truck("Ridgeline", "Honda", "Watanabe", "Diesel", 83.279, 7.23, 5, 250)
	};

        PetroleumPrice priceInfo = new PetroleumPrice(128.7, 105.7);

        for(Vehicle v: vehicles) {
	    describe(v);
	    System.out.println("Movable distance: " + v.movableDistance() + " Km");
	    System.out.println("Cost for 100 Km: " + v.costFor100Km(priceInfo) + " Yen");
	    System.out.println();
	}
        System.out.println();
	System.out.println("After Aircondition is ON\n");
        for(Vehicle v: vehicles) {
	    v.setAirConON();
	    describe(v);
	    System.out.println("Movable distance: " + v.movableDistance() + " Km");
	    System.out.println("Cost for 100 Km: " + v.costFor100Km(priceInfo) + " Yen");
            System.out.println();
	}

    }  // end of main
}
