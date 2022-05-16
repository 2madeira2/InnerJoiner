package ioutils;

import formathelper.FormatChecker;
import model.Pair;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class ReaderFile {

    private final FormatChecker formatChecker;

    public ReaderFile() {
        this.formatChecker = new FormatChecker();
    }

    public ArrayList<Pair> getPairsFromFile(String inputPath) throws IOException {
        ArrayList<Pair> pairs = new ArrayList<>();
        File file = new File(inputPath);
        try (FileReader fileReader = new FileReader(inputPath)) {
            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
            String line;
            String[] parseLine;
            while ((line = lineNumberReader.readLine()) != null) {
                parseLine = line.split(",");
                if (formatChecker.checkLineFormat(parseLine, lineNumberReader.getLineNumber(), file)) {
                    pairs.add(new Pair(Integer.parseInt(parseLine[0]), parseLine[1]));
                }
            }
        }
        return pairs;
    }

}
