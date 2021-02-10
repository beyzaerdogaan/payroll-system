public class Main {
    public static void main(String[] args) {
        String personnelTxt = args[0];
        String monitoringTxt = args[1];
        University university = new University(personnelTxt, monitoringTxt);
        university.createTexts();
    }
}
