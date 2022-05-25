package joiner;

import ioutils.WriterFile;
import model.Pair;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListJoiner implements Joiner<LinkedList<Pair>> {

    private final String inputPath;

    public LinkedListJoiner(String inputPath) {
        this.inputPath = inputPath;
    }

    @Override
    public void join(LinkedList<Pair> linkedListOne, LinkedList<Pair> linkedListTwo) throws IOException {
        try (FileWriter fileWriter = new FileWriter(inputPath)) {
            WriterFile writerFile = new WriterFile(fileWriter);
            writerFile.printHeaders();
            ListIterator<Pair> firstIterator = linkedListOne.listIterator();
            ListIterator<Pair> secondIterator = linkedListTwo.listIterator();
            Pair firstPair, secondPair;
            int count;
            while (firstIterator.hasNext()) {
                count = 0;
                firstPair = firstIterator.next();
                while (secondIterator.hasNext()) {
                    secondPair = secondIterator.next();
                    if (firstPair.getId() >= secondPair.getId()) {
                        if (firstPair.getId().equals(secondPair.getId())) {
                            count++;
                            writerFile.printResultLine(firstPair, secondPair);
                        }
                    } else {
                        count++;
                        for(int c = 0; c < count; c++) {
                            secondIterator.previous();
                        }
                        break;
                    }
                }
            }
        }
    }
}
