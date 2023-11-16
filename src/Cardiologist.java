public class Cardiologist extends Doctor{

    private int numberOfHeartTransplant;


    public Cardiologist (String name, String SSN, String cell_phone, String age, String sex, float weight, float height, float hourlyPrice, String medicalID, int avarageHourlyAppointments, int numberOfHeartTransplant) {
        super(name, SSN, cell_phone, age, sex, weight, height, hourlyPrice, medicalID, avarageHourlyAppointments);
        this.numberOfHeartTransplant = numberOfHeartTransplant;
    } 

    public String complain() {
        return "'Where is the heart?! I have transplant to do.'";
    }

    public double payment(int hoursWorked) {
        return (hourlyPrice * hoursWorked * 3.00);
    }

    public String history() {
        String desc = this.getName() + "is a cardiologist and he/she have already made " + numberOfHeartTransplant + " transplants."; 
        return desc;
    }

    public String procedure() {
        return "*Using Stethoscope*";
    }

    public String examine(Patient p){
        return "'Your BMI is "+ p.calculateBMI() + ". " + p.getName() +", let me check your heart beats...'" + "\n" + this.procedure();
    }


}
