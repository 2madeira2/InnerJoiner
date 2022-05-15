import model.Pair;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

public class InnerJoiner {

    private final FileWriter fileWriter;

    public InnerJoiner(FileWriter fileWriter) throws IOException {
        this.fileWriter = fileWriter;
    }

    public void join(ArrayList<Pair> arrayListOne, ArrayList<Pair> arrayListTwo) throws IOException {
        for (Pair pairOne : arrayListOne) {
            for (Pair pairTwo : arrayListTwo) {
                if (pairOne.getId().equals(pairTwo.getId())) {
                    fileWriter.write(pairOne.getId() + " " + pairOne.getValue() + " " + pairTwo.getValue() + "\n");
                }
            }
        }
    }

    public void join(LinkedList<Pair> linkedListOne, LinkedList<Pair> linkedListTwo) throws IOException{
        ListIterator<Pair> firstIterator = linkedListOne.listIterator();
        ListIterator<Pair> secondIterator = linkedListTwo.listIterator();
        Pair firstPair;
        Pair secondPair;
        while(firstIterator.hasNext()) {
            firstPair = firstIterator.next();
            while (secondIterator.hasNext()) {
                secondPair = secondIterator.next();
                if(firstPair.getId().equals(secondPair.getId())) {
                    fileWriter.write(firstPair.getId() + " " + firstPair.getValue() + " " + secondPair.getValue() + "\n");
                }
            }
            for(int i = 0; i < linkedListTwo.size(); i++)
                secondIterator.previous();
        }
    }

    public void join(HashMap<Integer, ArrayList<Pair>> hashMapOne, HashMap<Integer, ArrayList<Pair>> hashMapTwo) throws IOException {
        for(Integer key : hashMapOne.keySet()) {
            if(hashMapTwo.containsKey(key)) {
                for(Pair p1 : hashMapOne.get(key)) {
                    for(Pair p2 : hashMapTwo.get(key)) {
                        if (p1.getId().equals(p2.getId())) {
                            fileWriter.write(p1.getId() + " " + p1.getValue() + " " + p2.getValue() + "\n");
                        }
                    }
                }
            }
        }
    }
}
