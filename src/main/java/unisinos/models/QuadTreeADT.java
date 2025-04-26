package unisinos.models;

import java.util.List;

public interface QuadTreeADT<T> {
    void clear();
    Boolean isEmpty();
    void insert(int x, int y, T value);
    void query2D(Interval2D interval);
    Node<T> search(Point point);
    List<Point> allPoints();
}
