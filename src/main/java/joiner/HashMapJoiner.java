package joiner;

import ioutils.WriterFile;
import model.Pair;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class HashMapJoiner implements Joiner<HashMap<Integer, ArrayList<Pair>>> {

    private final String inputPath;

    public HashMapJoiner(String inputPath) {
        this.inputPath = inputPath;
    }

    @Override
    public void join(HashMap<Integer, ArrayList<Pair>> hashMapOne, HashMap<Integer, ArrayList<Pair>> hashMapTwo) throws IOException {
        try (FileWriter fileWriter = new FileWriter(inputPath)) {
            WriterFile writerFile = new WriterFile(fileWriter);
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
}
