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
        long now = System.currentTimeMillis();
        arrayListJoiner.join(listOne, listTwo);
        System.out.println(System.currentTimeMillis() - now);
        if (linkedListJoiner == null) {
            linkedListJoiner = new LinkedListJoiner(inputPath + "LinkedList");
        }
        now = System.currentTimeMillis();
        linkedListJoiner.join(listOne, listTwo);
        System.out.println(System.currentTimeMillis() - now);
        if (hashMapJoiner == null) {
            hashMapJoiner = new HashMapJoiner(inputPath + "HashMap");
        }
        now = System.currentTimeMillis();
        hashMapJoiner.join(listOne, listTwo);
        System.out.println(System.currentTimeMillis() - now);
    }
}
