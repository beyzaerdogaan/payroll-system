public class FullTime extends Personnel {
    private double baseSalary;
    private double overWorkSalary;
    private int maxHour;
    private int pricePerHour;

    public FullTime(String name, String surname, String registerNumber, String position, int yearOfStart) {
        super(name, surname, registerNumber, position, yearOfStart);
    }

    //calculate overwork salary for full-time employees by their maximum work hours and money that they earn per hour
    public double calculateOverWorkSalary(int maxHour, int pricePerHour) {
        for (int hour : getWorkingHours()) {
            int extraHour = hour - 40;
            if (extraHour <= maxHour) {
                overWorkSalary = overWorkSalary + extraHour * pricePerHour;
            }
            else {
                overWorkSalary = overWorkSalary + (maxHour * pricePerHour);
            }
        }
        return overWorkSalary;
    }

    //calculate salary for full-time employees
    public void calculateSalary() {
        setTotalSalary(calculateSeverancePay() + getBaseSalary() + calculateOverWorkSalary(getMaxHour(), getPricePerHour()));
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setOverWorkSalary(double overWorkSalary) {
        this.overWorkSalary = overWorkSalary;
    }

    public double getOverWorkSalary() {
        return overWorkSalary;
    }

    public int getMaxHour() {
        return maxHour;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setMaxHour(int maxHour) {
        this.maxHour = maxHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
