public class Officer extends Personnel {
    private double baseSalary = 2600;
    private double ssBenefits;
    private double overWorkSalary;

    public Officer(String name, String surname, String registerNumber, String position, int yearOfStart) {
        super(name, surname, registerNumber, position, yearOfStart);
    }

    //calculate special service benefits for officers
    public double calculateSsBenefits() {
        setSsBenefits((getBaseSalary() / 100) * 65);
        return getSsBenefits();
    }

    //calculate overwork salary for officers
    public double calculateOverWorkSalary() {
        for (int hour : getWorkingHours()) {
            int extraHour = hour - 40;
            if (extraHour <= 10) {
                overWorkSalary = overWorkSalary + extraHour * 20;
            }
            else {
                overWorkSalary = overWorkSalary + 200;
            }
        }
        return overWorkSalary;
    }

    //calculate salary for officers
    public void calculateSalary() {
        setTotalSalary(getBaseSalary() + calculateSsBenefits() + calculateOverWorkSalary() + calculateSeverancePay());
    }

    public void setSsBenefits(double ssBenefits) {
        this.ssBenefits = ssBenefits;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getSsBenefits() {
        return ssBenefits;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getOverWorkSalary() {
        return overWorkSalary;
    }

    public void setOverWorkSalary(double overWorkSalary) {
        this.overWorkSalary = overWorkSalary;
    }
}
