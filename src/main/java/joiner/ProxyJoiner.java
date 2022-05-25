package joiner;

import model.Pair;

import java.io.IOException;
import java.util.ArrayList;

public class ProxyJoiner implements Joiner {

    private String inputPath;
    private ArrayListJoiner arrayListJoiner;
    private LinkedListJoiner linkedListJoiner;
    private HashMapJoiner hashMapJoiner;

    public ProxyJoiner(String inputPath) {
        this.inputPath = inputPath;
    }

    @Override
    public void join(ArrayList<Pair> listOne, ArrayList<Pair> listTwo) throws IOException {
        if (arrayListJoiner == null) {
            arrayListJoiner = new ArrayListJoiner(inputPath);
        }
        doJoin(arrayListJoiner, listOne, listTwo);
        if (linkedListJoiner == null) {
            linkedListJoiner = new LinkedListJoiner(inputPath + "LinkedList");
        }
        doJoin(linkedListJoiner, listOne, listTwo);
        if (hashMapJoiner == null) {
            hashMapJoiner = new HashMapJoiner(inputPath + "HashMap");
        }
        doJoin(hashMapJoiner, listOne, listTwo);
    }

    private void doJoin(Joiner joiner, ArrayList<Pair> listOne, ArrayList<Pair> listTwo) throws IOException {
        long now = System.currentTimeMillis();
        joiner.join(listOne, listTwo);
        System.out.println((System.currentTimeMillis() - now) / 1000);
    }
}
