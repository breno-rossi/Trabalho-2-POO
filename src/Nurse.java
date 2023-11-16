public class Nurse extends Professional{
    
    private String nurseID;
    private int assists;


    public Nurse (String name, String SSN, String cell_phone, String age, String sex, float weight, float height, float hourlyPrice, String nurseID, int assists) {
        super(name, SSN, cell_phone, age, sex, weight, height, hourlyPrice);
        this.nurseID = nurseID;
        this.assists = assists;
    }
    
    public String complain() {
        return "'I need to specialize my self.'";
    }

    public double payment(int hoursWorked) {
        return (hourlyPrice * hoursWorked * 1.20);
    }

    public String history() {
        String desc = this.getName() + "is a nurse and he/she have already made " + assists + " assists."; 
        return desc;
    }

    public String requestExam(Doctor d, Patient p) {
        String r = p.complain() + d.examine(p);
        this.assists += 1;
        return r;
    }

    public int getAssists() {
        return assists;
    }
}
