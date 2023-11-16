import java.io.Serializable;

public abstract class Person implements Serializable {
    
    private String name;
    private String SSN; // CPF
    private String cell_phone;
    private String age;
    private String sex;
    private float weight;
    private float height;

    public abstract String complain();

    public Person (String name,String SSN,String cell_phone, String age, String sex,float weight,float height) {
        this.name = name;
        this.SSN = SSN;
        this.cell_phone = cell_phone;
        this.age = age;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
    }

    public float calculateBMI() {
        // Calcula o IMC (peso em kg / altura em metros ao quadrado)
        float heightInMeters = height / 100; // convertendo altura de centímetros para metros
        return weight / (heightInMeters * heightInMeters);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String CPF) {
        this.SSN = SSN;
    }

    public String getCell_PhoneNumber() {
        return cell_phone;
    }

    public void setCell_PhoneNumber(String number) {
        this.cell_phone = cell_phone;
    }

    // Métodos getter e setter para age (herdado de Person)
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
    
