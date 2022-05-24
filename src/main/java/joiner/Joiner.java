package joiner;

import model.Pair;

import java.io.IOException;
import java.util.ArrayList;

public interface Joiner {
    void join(ArrayList<Pair> listOne, ArrayList<Pair> listTwo) throws IOException;
}
