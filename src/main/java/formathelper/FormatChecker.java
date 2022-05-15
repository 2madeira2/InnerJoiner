package formathelper;

import java.io.File;

public class FormatChecker {

    public boolean checkLineFormat(String[] line, int lineNumber, File file) {
        boolean check = true;
        if (line.length != 2) {
            System.out.println("!Не хватает значений: файл " + file.getName() + ", строка " + lineNumber);
            return false;
        }
        if (line[1].isBlank()) {
            System.out.println("!Неверное строковое значение: файл " + file.getName() + ", строка " + lineNumber);
            check = false;
        }
        try {
            Integer.parseInt(line[0]);
        } catch (NumberFormatException ex) {
            System.out.println("!Неверно задано численное значение: файл " + file.getName() + ", строка " + lineNumber);
            check = false;
        }
        return check;
    }

}
