package unisinos.models;

import java.util.ArrayList;
import java.util.List;

public class QuadTree<T> implements  QuadTreeADT<T> {

    public Node<T> root;

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public Boolean isEmpty() {
        return root == null;
    }

    @Override
    public void insert(int x, int y, T value) {
        root = insert(root, x, y, value);
    }

    private Node<T> insert(Node<T> current, int x, int y, T value){

        if(current == null){
            return new Node<>(x, y, value);
        }
        else if(x < current.X && y >= current.Y){
            current.NW = insert(current.NW, x, y, value);
        }
        else if(x >= current.X && y >= current.Y){
            current.NE = insert(current.NE, x, y, value);
        }
        else if(x < current.X){
            current.SW = insert(current.SW, x, y, value);
        }
        else{
            current.SE = insert(current.SE, x, y, value);
        }

        return current;
    }

    @Override
    public void query2D(Interval2D interval) {
        query2D(root, interval);
    }

    private void query2D(Node<T> current, Interval2D interval) {

        if (current == null) {
            return;
        }

        var xMin = interval.X.Min;
        var xMax = interval.X.Max;
        var yMin = interval.Y.Min;
        var yMax = interval.Y.Max;

        if (interval.Contains(current.X, current.Y)) {
            System.out.println(current);
        }

        if (xMin < current.X && yMax >= current.Y) {
            query2D(current.NW, interval);
        }
        if(xMin < current.X && yMin < current.Y) {
            query2D(current.SW, interval);
        }
        if(xMax >= current.X && yMax >= current.Y){
            query2D(current.NE, interval);
        }
        if(xMax >= current.X && yMin < current.Y){
            query2D(current.SE, interval);
        }
    }

    @Override
    public Node<T> search(Point point) {
        return null;
    }

    @Override
    public List<Point> allPoints() {
        List<Point> points = new ArrayList<>();
        collectPoints(root, points);
        return points;
    }

    private void collectPoints(Node<T> current, List<Point> points) {
        if (current == null) {
            return;
        }
    
        points.add(new Point(current.X, current.Y));
    
        collectPoints(current.NW, points);
        collectPoints(current.NE, points);
        collectPoints(current.SE, points);
        collectPoints(current.SW, points);
    }
}
