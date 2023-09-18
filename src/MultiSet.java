public interface MultiSet<E> {
    boolean add(E item);
    void remove(E item);
    boolean contains(E item);
    boolean isEmpty();
    int count(E item);
    int size();
}