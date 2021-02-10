public class Security extends Personnel {
    private double salary;
    public Security(String name, String surname, String registerNumber, String position, int yearOfStart) {
        super(name, surname, registerNumber, position, yearOfStart);
    }

    //calculate salary for security based on their minimum and maximum working hours
    public double calculateBaseSalary() {
        for (int hour : getWorkingHours()) {
            if (30 <= hour && hour <= 54) {
                salary = salary + (hour * 10) + (15 * 6);
            }
        }
        return salary;
    }

    //calculate total salary for security
    public void calculateSalary() {
        setTotalSalary(calculateBaseSalary() + calculateSeverancePay());
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}
