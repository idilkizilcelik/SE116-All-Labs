import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
class Shipment {
    private int weightKg;
    private String trackingNo;
    private String contentType;
    private int distanceKm;

    public Shipment(int weightKg, String trackingNo, String contentType, int distanceKm) {
        this.weightKg = weightKg;
        this.trackingNo = trackingNo;
        this.contentType = contentType;
        this.distanceKm = distanceKm;
    }

    public int getweightKg() {
        return weightKg;
    }

    public String gettrackingNo() {
        return trackingNo;
    }

    public String getcontentType() {
        return contentType;
    }

    public int getdistanceKm() {
        return distanceKm;
    }

    public void setweightKg(int weightKg) {
        this.weightKg = weightKg;
    }

    public void settrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }

    public void setcontentType(String contentType) {
        this.contentType = contentType;
    }

    public void setdistanceKm(int distanceKm) {
        this.distanceKm = distanceKm;
    }

    public double calculateFee() {
        double fee;
        fee = (weightKg * distanceKm);
        return fee;
    }

    public void printReceipt() {
        double totalFee;
        totalFee = calculateFee();
        System.out.println(trackingNo + " " + contentType + " " + weightKg + " " + distanceKm + " " + totalFee);
    }



}


class StandardShipping extends Shipment {
    public StandardShipping(String trackingNo, String contentType, int weightKg, int distanceKm) {
        super(weightKg, trackingNo, contentType, distanceKm);
    }

    @Override
    public double calculateFee() {
        double fee = ((1.5*super.getweightKg())+(0.08*super.getdistanceKm())+15.0);
        return fee;


    }

}
class ExpressShipping extends Shipment {
    public ExpressShipping(String trackingNo, String contentType, int weightKg, int distanceKm) {
        super(weightKg, trackingNo, contentType, distanceKm);
    }

    @Override
    public double calculateFee() {
        double fee = ((2.2*super.getweightKg())+(0.12*super.getdistanceKm())+25.0+20.0);
        return fee;


    }

}
class InternationalShipping extends Shipment {
    public InternationalShipping(String trackingNo, String contentType, int weightKg, int distanceKm) {
        super(weightKg, trackingNo, contentType, distanceKm);
    }

    @Override
    public double calculateFee() {
        double fee;
        if (super.getdistanceKm() <= 800) {
            fee = ((3.0 * super.getweightKg()) + (0.15 * super.getdistanceKm()) + 30.0 + 40.0);

        } else {
            fee = (((3.0 * super.getweightKg()) + (0.15 * super.getdistanceKm()) + 30.0 + 40.0 + 35.0));

        }
        return fee;


    }

}
 class SwiftRouteApp {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.println("====Shipping Menu===\n" + "1=Standard\n" + "2=Express\n" + "3=International\n");
         int choose = sc.nextInt();
         System.out.println("Please enter your Shipment details:");

         System.out.println("Tracking No : ");
         sc.nextLine();
         String track = sc.nextLine();
         System.out.println("Content Type :");
         String content = sc.nextLine();
         System.out.println("Weight : ");
         int weight = sc.nextInt();
         System.out.println("Distance: ");
         int distance = sc.nextInt();
         HashMap<String, Shipment> shipmentMap= new HashMap<>();
         String key=content+track;
         for(int i=0; i<5; i++) {
             Shipment a = null;


             if (choose == 1) {
                 a = new StandardShipping(track, content, weight, distance);
                 System.out.println(a.calculateFee());

             }
             if (choose == 2) {
                 a = new ExpressShipping(track, content, weight, distance);
                 System.out.println(a.calculateFee());

             }
             if (choose == 3) {
                 a = new InternationalShipping(track, content, weight, distance);
                 System.out.println(a.calculateFee());


             }
             shipmentMap.put(key, a);
             for(Map.Entry<String, Shipment> entry: shipmentMap.entrySet() ){
                 entry.getValue().printReceipt();
                 return;
             }
         }


     }
 }
