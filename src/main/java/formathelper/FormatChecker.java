package formathelper;

public class FormatChecker {

    public boolean checkLineFormat(String[] line, int lineNumber) {
        boolean check = true;
        if (line.length != 2) {
            System.out.println("!Не хватает значений в строке номер: " + lineNumber);
            return false;
        }
        if(line[1].isBlank()) {
            System.out.println("!Неверное строковое значение в строке номер: " + lineNumber);
            check = false;
        }
        try {
            Integer.parseInt(line[0]);
        } catch (NumberFormatException ex) {
            System.out.println("!Неверное задано численное значение на строке номер: " + lineNumber);
            check = false;
        }
        return check;
    }

}
