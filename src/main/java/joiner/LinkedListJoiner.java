package joiner;

import converter.StructureConverter;
import ioutils.WriterFile;
import model.Pair;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListJoiner implements Joiner {

    private final StructureConverter structureConverter;
    private final String inputPath;

    public LinkedListJoiner(String inputPath) {
        this.structureConverter = new StructureConverter();
        this.inputPath = inputPath;
    }

    @Override
    public void join(ArrayList<Pair> listOne, ArrayList<Pair> listTwo) throws IOException {
        try (FileWriter fileWriter = new FileWriter(inputPath)) {
            WriterFile writerFile = new WriterFile(fileWriter);
            LinkedList<Pair> linkedListOne = structureConverter.convertToSortedLinkedList(listOne);
            LinkedList<Pair> linkedListTwo = structureConverter.convertToSortedLinkedList(listTwo);
            writerFile.printHeaders();
            ListIterator<Pair> firstIterator = linkedListOne.listIterator();
            ListIterator<Pair> secondIterator = linkedListTwo.listIterator();
            Pair firstPair, secondPair;
            int counter;
            while (firstIterator.hasNext()) {
                firstPair = firstIterator.next();
                counter = 0;
                while (secondIterator.hasNext()) {
                    counter++;
                    secondPair = secondIterator.next();
                    if (firstPair.getId() >= secondPair.getId()) {
                        if (firstPair.getId().equals(secondPair.getId())) {
                            writerFile.printResultLine(firstPair, secondPair);
                        }
                    } else break;
                }
                for (int i = 0; i < counter; i++)
                    secondIterator.previous();
            }
        }
    }
}
