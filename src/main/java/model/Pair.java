package model;

public class Pair implements Comparable<Pair> {

    private final Integer id;
    private final String value;

    public Pair(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int compareTo(Pair o) {
        return this.id.compareTo(o.id);
    }
}
