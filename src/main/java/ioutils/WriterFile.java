package ioutils;

import model.Pair;

import java.io.FileWriter;
import java.io.IOException;

public class WriterFile {

    private final FileWriter fileWriter;

    public WriterFile(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public void printHeaders() throws IOException {
        fileWriter.write("ID\tA.VALUE\tB.VALUE\n");
    }

    public void printResultLine(Pair p1, Pair p2) throws IOException {
        fileWriter.write(p1.getId() + "\t" + p1.getValue() + "\t\t" + p2.getValue() + "\n");
    }
}
