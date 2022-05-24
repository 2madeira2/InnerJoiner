package joiner;

import converter.StructureConverter;
import ioutils.WriterFile;
import model.Pair;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class HashMapJoiner implements Joiner {

    private final StructureConverter structureConverter;
    private final String inputPath;

    public HashMapJoiner(String inputPath) {
        this.structureConverter = new StructureConverter();
        this.inputPath = inputPath;
    }

    @Override
    public void join(ArrayList<Pair> listOne, ArrayList<Pair> listTwo) throws IOException {
        try (FileWriter fileWriter = new FileWriter(inputPath)) {
            WriterFile writerFile = new WriterFile(fileWriter);
            HashMap<Integer, ArrayList<Pair>> hashMapOne = structureConverter.convertToHashMap(listOne);
            HashMap<Integer, ArrayList<Pair>> hashMapTwo = structureConverter.convertToHashMap(listTwo);
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
