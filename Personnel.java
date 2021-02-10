import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Personnel {
    private String name;
    private String surname;
    private String registerNumber;
    private String position;
    private int yearOfStart;
    private double severancePay;
    private double totalSalary;
    private ArrayList<Integer> workingHours = new ArrayList<>();

    public Personnel(String name, String surname, String registerNumber, String position, int yearOfStart) {
        this.name = name;
        this.surname = surname;
        this.registerNumber = registerNumber;
        this.position = position;
        this.yearOfStart = yearOfStart;
    }

    //calculate severance pay for each personnel
    public double calculateSeverancePay() {
        severancePay = (2020 - yearOfStart) * 20 * 0.8;
        return severancePay;
    }

    //create an array of working hours of each personnel
    public void workingHours(String monitoringText) {
        Path filePath = Paths.get(monitoringText);
        String[] lines = ReadFromFile.readFile(filePath.toAbsolutePath().toString());
        for (String line : lines) {
            String[] line1 = line.split("\t");
            if (line1[0].equals(registerNumber)) {
                workingHours.add(Integer.parseInt(line1[1]));
                workingHours.add(Integer.parseInt(line1[2]));
                workingHours.add(Integer.parseInt(line1[3]));
                workingHours.add(Integer.parseInt(line1[4]));
            }
        }
    }

    //create a payroll for a personnel
    public void createFiles() {
        try {
            FileWriter file = new FileWriter(registerNumber + ".txt");
            file.write("Name : " + name + "\n");
            file.write("Surname : " + surname + "\n");
            file.write("Registration Number : " + registerNumber + "\n");
            file.write("Position : " + position + "\n");
            file.write("Year of Start : " + yearOfStart + "\n");
            file.write("Total Salary : " + Math.round(totalSalary) + ".00 TL" +"\n");
            file.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getYearOfStart() {
        return yearOfStart;
    }

    public String getPosition() {
        return position;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public void setYearOfStart(int yearOfStart) {
        this.yearOfStart = yearOfStart;
    }

    public void setSeverancePay(double severancePay) {
        this.severancePay = severancePay;
    }

    public double getSeverancePay() {
        return severancePay;
    }

    public ArrayList<Integer> getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(ArrayList<Integer> workingHours) {
        this.workingHours = workingHours;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }
}
