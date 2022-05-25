package joiner;

import model.Pair;

import java.io.IOException;
import java.util.ArrayList;

public interface Joiner<T> {
    void join(T collectionOne, T collectionTwo) throws IOException;
}
