public class Manager extends Professional{
    private String managerID; // CRM
    private int yearsAsaManager;

    public Manager (String name, String SSN, String cell_phone, String age, String sex, float weight, float height, float hourlyPrice, String managerID, int yearsAsaManager) {
        super(name, SSN, cell_phone, age, sex, weight, height, hourlyPrice);
        this.managerID = managerID;
        this.yearsAsaManager = yearsAsaManager;
    } 

    public String complain() {
        return "'Being a hospital manager is challenging...'";
    }

    public double payment(int hoursWorked) {
        return (hourlyPrice * hoursWorked * 3.50);
    }

    public String history() {
        String desc = this.getName() + "is the manager and he/she has " + yearsAsaManager + " years of experience as a manager."; 
        return desc;
    }   
    
    public String paySalaryMeeting(Professional prof, int hoursWorked) {
        if ((prof instanceof Doctor) || (prof instanceof Nurse)) {
            
            return "\n" + prof.complain() + "\n$ " + prof.payment(hoursWorked) + "\nSalary paid for " + prof.getSSN();
        } else {
            return "I can't pay another manager.";
        }
    }
}
