
class Vehicle {
    private String licensePlate;
    private int dailyRate;

    public Vehicle(String licensePlate, int dailyRate) {
        this.licensePlate = licensePlate;
        this.dailyRate = dailyRate;
    }

    public int getdailyRate() {
        return dailyRate;
    }

    public void setdailyRate(int dailyRate) {
        this.dailyRate = dailyRate;
    }

    public int calculateRental(int days) {
        int cost;
        return cost = dailyRate * days;
    }

    public void safetyCheck() {
        System.out.println("Components checked");
    }
    public boolean checkRisk(){
        return false;
    }

    public static void main(String[] args) {
        Vehicle[]cars= new Vehicle[3];
        cars[0]=new Vehicle("35 ADB 23", 200);
        cars[1]=new Truck("34 GFH 12", 120, 45 );
        cars[2]= new HeavyDutyTruck("23 UYT 89" , 400, 35,3);
        for(int i= 0; i<cars.length; i++){
            Vehicle a= cars[0];
            Vehicle b= cars[1];
            Vehicle c= cars[2];
            System.out.println(a.licensePlate);
            System.out.println("Rental 6 days: " + a.calculateRental(6));
            a.safetyCheck();
            System.out.println(b.licensePlate);
            System.out.println("Rental 6 days: " + b.calculateRental(6));
            b.safetyCheck();
            System.out.println(b.checkRisk());
            System.out.println(c.licensePlate);
            System.out.println("Rental 6 days: " + c.calculateRental(6));
            c.safetyCheck();
            System.out.println();
            return;

        }


        }
    }

    class Truck extends Vehicle {
        private int cargoCapacity;

        public Truck(String licensePlate, int dailyRate, int cargoCapacity) {
            super(licensePlate, dailyRate);
            this.cargoCapacity = cargoCapacity;
        }
        public int getcargoCapacity(){
            return cargoCapacity;
        }
        public void setcargoCapacity(int cargoCapacity){
            this.cargoCapacity=cargoCapacity;
        }

        public Truck() {
                super("27 BLK 27", 200);
            }

            @Override
            public void safetyCheck () {
                if (cargoCapacity > 40) {
                    System.out.println("UNSAFE TO GO");
                } else {
                    System.out.println("SAFE TO GO");
                }
            }
            @Override
        public boolean checkRisk(){
            if(cargoCapacity>20){
                return true;
            }else{
                return false;
            }
            }


        }

        class HeavyDutyTruck extends Truck {
            private int axleCount;

            public HeavyDutyTruck(String licensePlate, int dailyRate, int cargoCapacity, int axleCount) {
                super(licensePlate, dailyRate, cargoCapacity);
                this.axleCount = axleCount;
            }

            @Override
            public int calculateRental(int days) {
                int cost;
                return cost = super.getdailyRate() * days * axleCount;
            }

            @Override
            public boolean checkRisk() {
                if (axleCount > 4) {
                    return true;
                }else{
                    return false;
                }

            }

        }
