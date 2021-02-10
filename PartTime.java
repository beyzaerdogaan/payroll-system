public class PartTime extends Personnel {
    private double salary;
    public PartTime(String name, String surname, String registerNumber, String position, int yearOfStart) {
        super(name, surname, registerNumber, position, yearOfStart);
    }

    //calculate salary for part-time employees based on their number of working hours
    public double calculateBaseSalary() {
        for (int hour : getWorkingHours()) {
            if (10 <= hour && hour < 20) {
                salary = salary + (hour * 18);
            }
            else if (20 <= hour) {
                salary = salary + (20 * 18);
            }
        }
        return salary;
    }

    //calculate total salary for part-time employees
    public void calculateSalary() {
        setTotalSalary(calculateBaseSalary() + calculateSeverancePay());
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
