import converter.StructureConverter;
import ioutils.ReaderFile;
import model.Pair;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class MainApp {
    public static void main(String[] args) {
        if(checkCommandLineArguments(args.length)) {
            try (FileWriter fileWriter = new FileWriter(args[2]);) {
                ReaderFile readerFile = new ReaderFile();
                ArrayList<Pair> pairsInA = readerFile.getPairsFromFile(args[0]);
                ArrayList<Pair> pairsInB = readerFile.getPairsFromFile(args[1]);
                StructureConverter structureConverter = new StructureConverter();
                InnerJoiner innerJoiner = new InnerJoiner(fileWriter);
                innerJoiner.join(pairsInA, pairsInB);
                LinkedList<Pair> firstLinkedList = structureConverter.convertToSortedLinkedList(pairsInA);
                LinkedList<Pair> secondLinkedList = structureConverter.convertToSortedLinkedList(pairsInB);
                innerJoiner.join(firstLinkedList, secondLinkedList);
                HashMap<Integer, ArrayList<Pair>> hashMapOne = structureConverter.convertToHashMap(pairsInA);
                HashMap<Integer, ArrayList<Pair>> hashMapTwo = structureConverter.convertToHashMap(pairsInB);
                innerJoiner.join(hashMapOne, hashMapTwo);
            } catch (IOException ex) {
                System.out.println("Неверно задан путь к файлу");
            }
        }
    }

    private static boolean checkCommandLineArguments(int argsLength) {
        switch (argsLength) {
            case 0:
                System.out.println("Не заданы аргументы командной строки с путями до двух файлов для чтения данных и файла для вывода результата join-а");
                return false;
            case 1:
                System.out.println("Не задан аргумент командной строки с путем до второго файла для чтения данных и файла для вывода результата join-а");
                return false;
            case 2:
                System.out.println("Не задан аргумент командной строки с путем до файла для вывода результата join-а");
                return false;
            case 3:
                return true;
            default:
                System.out.println("Слишком много аргументов командной строки. Требуется 3 аргумента: пути до двух файлов для чтения данных, путь до файла для вывода результата join-а");
                return false;
        }
    }
}
