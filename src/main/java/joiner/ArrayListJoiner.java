package joiner;

import ioutils.WriterFile;
import model.Pair;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayListJoiner implements Joiner<ArrayList<Pair>> {
    private final String inputPath;

    public ArrayListJoiner(String inputPath) {
        this.inputPath = inputPath;
    }

    @Override
    public void join(ArrayList<Pair> arrayListOne, ArrayList<Pair> arrayListTwo) throws IOException {
        try (FileWriter fileWriter = new FileWriter(inputPath)) {
            WriterFile writerFile = new WriterFile(fileWriter);
            writerFile.printHeaders();
            for (Pair pairOne : arrayListOne) {
                for (Pair pairTwo : arrayListTwo) {
                    if (pairOne.getId().equals(pairTwo.getId())) {
                        writerFile.printResultLine(pairOne, pairTwo);
                    }
                }
            }
        }
    }
}
