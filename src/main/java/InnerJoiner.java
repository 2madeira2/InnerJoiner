import model.Pair;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

public class InnerJoiner {

    private final FileWriter fileWriter;

    public InnerJoiner(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public void join(ArrayList<Pair> arrayListOne, ArrayList<Pair> arrayListTwo) throws IOException {
        printHeaders();
        for (Pair pairOne : arrayListOne) {
            for (Pair pairTwo : arrayListTwo) {
                if (pairOne.getId().equals(pairTwo.getId())) {
                    fileWriter.write(pairOne.getId() + "\t" + pairOne.getValue() + "\t\t" + pairTwo.getValue() + "\n");
                }
            }
        }
    }

    public void join(LinkedList<Pair> linkedListOne, LinkedList<Pair> linkedListTwo) throws IOException {
        printHeaders();
        ListIterator<Pair> firstIterator = linkedListOne.listIterator();
        ListIterator<Pair> secondIterator = linkedListTwo.listIterator();
        Pair firstPair;
        Pair secondPair;
        while (firstIterator.hasNext()) {
            firstPair = firstIterator.next();
            while (secondIterator.hasNext()) {
                secondPair = secondIterator.next();
                if (firstPair.getId().equals(secondPair.getId())) {
                    fileWriter.write(firstPair.getId() + "\t" + firstPair.getValue() + "\t\t" + secondPair.getValue() + "\n");
                }
            }
            for (int i = 0; i < linkedListTwo.size(); i++)
                secondIterator.previous();
        }
    }

    public void join(HashMap<Integer, ArrayList<Pair>> hashMapOne, HashMap<Integer, ArrayList<Pair>> hashMapTwo) throws IOException {
        printHeaders();
        for (Integer key : hashMapOne.keySet()) {
            if (hashMapTwo.containsKey(key)) {
                for (Pair p1 : hashMapOne.get(key)) {
                    for (Pair p2 : hashMapTwo.get(key)) {
                        if (p1.getId().equals(p2.getId())) {
                            fileWriter.write(p1.getId() + "\t" + p1.getValue() + "\t\t" + p2.getValue() + "\n");
                        }
                    }
                }
            }
        }
    }

    private void printHeaders() throws IOException{
        fileWriter.write("ID\tA.VALUE\tB.VALUE\n");
    }
}
