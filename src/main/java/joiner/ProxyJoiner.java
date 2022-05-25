package joiner;

import converter.StructureConverter;
import model.Pair;

import java.io.IOException;
import java.util.ArrayList;

public class ProxyJoiner implements Joiner<ArrayList<Pair>> {

    private String inputPath;
    private ArrayListJoiner arrayListJoiner;
    private LinkedListJoiner linkedListJoiner;
    private HashMapJoiner hashMapJoiner;
    private StructureConverter structureConverter;

    public ProxyJoiner(String inputPath) {
        this.inputPath = inputPath;
        this.structureConverter = new StructureConverter();
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
        doJoin(linkedListJoiner, structureConverter.convertToSortedLinkedList(listOne), structureConverter.convertToSortedLinkedList(listTwo));

        if (hashMapJoiner == null) {
            hashMapJoiner = new HashMapJoiner(inputPath + "HashMap");
        }
        doJoin(hashMapJoiner, structureConverter.convertToHashMap(listOne), structureConverter.convertToHashMap(listTwo));
    }

    private <T> void doJoin(Joiner<T> joiner, T collectionOne, T collectionTwo) throws IOException {
        long now = System.currentTimeMillis();
        joiner.join(collectionOne, collectionTwo);
        System.out.println((System.currentTimeMillis() - now) / 1000);
    }
}
