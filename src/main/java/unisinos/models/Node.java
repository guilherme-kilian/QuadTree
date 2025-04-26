package unisinos.models;

public class Node<T> {
    public int X;
    public int Y;
    public T Value;
    public Node<T> NW;
    public Node<T> NE;
    public Node<T> SE;
    public Node<T> SW;

    public Node(int x, int y, T value) {
        Value = value;
        X = x;
        Y = y;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s) %s", X, Y, Value);
    }
}
