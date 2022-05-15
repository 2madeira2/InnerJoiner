package converter;

import model.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class StructureConverter {

    public LinkedList<Pair> convertToSortedLinkedList(ArrayList<Pair> arrayList) {
        LinkedList<Pair> result = new LinkedList<>(arrayList);
        Collections.sort(result);
        return result;
    }

    public HashMap<Integer, ArrayList<Pair>> convertToHashMap(ArrayList<Pair> arrayList) {
        HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
        for(Pair p : arrayList) {
            map.putIfAbsent(p.getId(), new ArrayList<>());
            map.get(p.getId()).add(p);
        }
        return map;
    }

}
