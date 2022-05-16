import ioutils.WriterFile;
import model.Pair;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

public class InnerJoiner {

    private final WriterFile writerFile;

    public InnerJoiner(FileWriter fileWriter) {
        this.writerFile = new WriterFile(fileWriter);
    }

    public void join(ArrayList<Pair> arrayListOne, ArrayList<Pair> arrayListTwo) throws IOException {
        writerFile.printHeaders();
        for (Pair pairOne : arrayListOne) {
            for (Pair pairTwo : arrayListTwo) {
                if (pairOne.getId().equals(pairTwo.getId())) {
                    writerFile.printResultLine(pairOne, pairTwo);
                }
            }
        }
    }

    public void join(LinkedList<Pair> linkedListOne, LinkedList<Pair> linkedListTwo) throws IOException {
        writerFile.printHeaders();
        ListIterator<Pair> firstIterator = linkedListOne.listIterator();
        ListIterator<Pair> secondIterator = linkedListTwo.listIterator();
        Pair firstPair, secondPair;
        while (firstIterator.hasNext()) {
            firstPair = firstIterator.next();
            while (secondIterator.hasNext()) {
                secondPair = secondIterator.next();
                if (firstPair.getId().equals(secondPair.getId())) {
                    writerFile.printResultLine(firstPair, secondPair);
                }
            }
            for (int i = 0; i < linkedListTwo.size(); i++)
                secondIterator.previous();
        }
    }

    public void join(HashMap<Integer, ArrayList<Pair>> hashMapOne, HashMap<Integer, ArrayList<Pair>> hashMapTwo) throws IOException {
        writerFile.printHeaders();
        for (Integer key : hashMapOne.keySet()) {
            if (hashMapTwo.containsKey(key)) {
                for (Pair p1 : hashMapOne.get(key))
                    for (Pair p2 : hashMapTwo.get(key))
                        writerFile.printResultLine(p1, p2);
            }
        }
    }
}
