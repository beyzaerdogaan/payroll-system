public class Academician extends Personnel {
    private double baseSalary = 2600;
    private double ssBenefits;
    private int percent;
    private double addCourseFee;

    public Academician(String name, String surname, String registerNumber, String position, int yearOfStart) {
        super(name, surname, registerNumber, position, yearOfStart);
    }

    //calculate special service benefits of academicians by percentages of each group
    public double calculateSsBenefits(int percent) {
        setSsBenefits((getBaseSalary() / 100) * percent);
        return getSsBenefits();
    }

    //calculate additional course fee up to 8 hours for faculty members
    public double calculateAddCourseFee() {
        for (int hour : getWorkingHours()) {
            int extraHour = hour - 40;
            if (extraHour <= 8) {
                addCourseFee = addCourseFee + extraHour * 20;
            }
            else {
                addCourseFee = addCourseFee + 160;
            }
        }
        return addCourseFee;
    }

    //calculate salary of academicians
    public void calculateSalary() {
        if (getPosition().equals("RESEARCH_ASSISTANT")) {
            setTotalSalary(getBaseSalary() + calculateSeverancePay() + calculateSsBenefits(getPercent()));
        }
        if (getPosition().equals("FACULTY_MEMBER")) {
            setTotalSalary(calculateAddCourseFee() + getBaseSalary() + calculateSeverancePay() + calculateSsBenefits(getPercent()));
        }
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getSsBenefits() {
        return ssBenefits;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setSsBenefits(double ssBenefits) {
        this.ssBenefits = ssBenefits;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public void setAddCourseFee(double addCourseFee) {
        this.addCourseFee = addCourseFee;
    }

    public double getAddCourseFee() {
        return addCourseFee;
    }
}
