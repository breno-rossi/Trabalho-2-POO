public class Orthopedist extends Doctor{
    
    private int numberOfMeniscectomies;


    public Orthopedist (String name, String SSN, String cell_phone, String age, String sex, float weight, float height,
                        float hourlyPrice, String medicalID, int avarageHourlyAppointments, int numberOfMeniscectomies) {
        super(name, SSN, cell_phone, age, sex, weight, height, hourlyPrice, medicalID, avarageHourlyAppointments);
        this.numberOfMeniscectomies = numberOfMeniscectomies;
    } 

    public String complain() {
        return "'People don't wait for their bones to heal!'";
    }

    public double payment(int hoursWorked) {
        return (hourlyPrice * hoursWorked * 2.75);
    }

    public String history() {
        String desc = this.getName() + "is an orthopedist and he/she have already made " + numberOfMeniscectomies + " meniscectomies."; 
        return desc;
    }

    public String procedure() {
        return "*Hitting the patient knees with a hammer*";
    }

    public String examine(Patient p){
        return "'Your BMI is "+ p.calculateBMI() + ". " + p.getName() + ", let me check if you bones are ok...'" + "\n" + this.procedure();
    }
}
