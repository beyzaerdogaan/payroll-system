import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class University {
    private HashMap<Personnel, Double> staff = new HashMap<>();
    public University(String personnelText, String monitoringText) {
        Path filePath = Paths.get(personnelText);
        String[] lines = ReadFromFile.readFile(filePath.toAbsolutePath().toString());
        for (String line : lines) {
            String [] line1 = line.split("\t");
            String[] name = line1[0].split(" ");
            switch (line1[2]) {
                case "FACULTY_MEMBER":
                    Academician facultyMember = new Academician(name[0], name[1], line1[1], line1[2], Integer.parseInt(line1[3]));
                    facultyMember.setPercent(135);
                    facultyMember.workingHours(monitoringText);
                    facultyMember.calculateSalary();
                    staff.put(facultyMember, facultyMember.getTotalSalary());
                    break;
                case "RESEARCH_ASSISTANT":
                    Academician researchAssistants = new Academician(name[0], name[1], line1[1], line1[2], Integer.parseInt(line1[3]));
                    researchAssistants.setPercent(105);
                    researchAssistants.workingHours(monitoringText);
                    researchAssistants.calculateSalary();
                    staff.put(researchAssistants, researchAssistants.getTotalSalary());
                    break;
                case "OFFICER":
                   Officer officer = new Officer(name[0], name[1], line1[1], line1[2], Integer.parseInt(line1[3]));
                   officer.workingHours(monitoringText);
                   officer.calculateSalary();
                   staff.put(officer, officer.getTotalSalary());
                   break;
                case "PARTTIME_EMPLOYEE":
                    PartTime partTime = new PartTime(name[0], name[1], line1[1], line1[2], Integer.parseInt(line1[3]));
                    partTime.workingHours(monitoringText);
                    partTime.calculateSalary();
                    staff.put(partTime, partTime.getTotalSalary());
                    break;
                case "WORKER":
                    FullTime worker = new FullTime(name[0], name[1], line1[1], line1[2], Integer.parseInt(line1[3]));
                    worker.setBaseSalary(2100);
                    worker.setMaxHour(10);
                    worker.setPricePerHour(11);
                    worker.workingHours(monitoringText);
                    worker.calculateSalary();
                    staff.put(worker, worker.getTotalSalary());
                    break;
                case "CHIEF":
                    FullTime chief = new FullTime(name[0], name[1], line1[1], line1[2], Integer.parseInt(line1[3]));
                    chief.setBaseSalary(2500);
                    chief.setMaxHour(8);
                    chief.setPricePerHour(15);
                    chief.workingHours(monitoringText);
                    chief.calculateSalary();
                    staff.put(chief, chief.getTotalSalary());
                    break;
                case "SECURITY":
                    Security security = new Security(name[0], name[1], line1[1], line1[2], Integer.parseInt(line1[3]));
                    security.workingHours(monitoringText);
                    security.calculateSalary();
                    staff.put(security, security.getTotalSalary());
                    break;
            }
        }
    }

    //create payrolls for each personnel
    public void createTexts() {
        for (Personnel personnel : staff.keySet()) {
            personnel.createFiles();
        }
    }
}
