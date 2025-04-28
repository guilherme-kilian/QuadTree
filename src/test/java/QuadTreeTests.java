import org.junit.jupiter.api.Test;
import unisinos.models.Interval;
import unisinos.models.Interval2D;
import unisinos.models.Point;
import unisinos.models.QuadTree;
import unisinos.models.QuadTreeADT;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

public class QuadTreeTests {

    public QuadTreeADT<String> getList(){

        var list = new QuadTree<String>();

        list.insert(6, 6, "center");
        list.insert(3, 9, "nw");
        list.insert(9, 9, "ne");
        list.insert(9, 3, "se");
        list.insert(3, 3, "sw");
        return list;
    }

    @Test
    public void testEmpty(){
        var list = getList();

        var interval2D = new Interval2D(new Interval(0, 3), new Interval(0, 9));

        list.query2D(interval2D);

        assertEquals(false, list.isEmpty());
    }
    
    @Test
    public void testAllPoints() {
        var list = getList();

        List<Point> points = list.allPoints();

        assertNotNull(points);
        assertEquals(5, points.size());

        assertEquals(6, points.get(0).X);
        assertEquals(6, points.get(0).Y);

        assertEquals(3, points.get(1).X);
        assertEquals(9, points.get(1).Y);

        assertEquals(9, points.get(2).X);
        assertEquals(9, points.get(2).Y);

        assertEquals(9, points.get(3).X);
        assertEquals(3, points.get(3).Y);

        assertEquals(3, points.get(4).X);
        assertEquals(3, points.get(4).Y);
    }

    @Test
    public void testSearchExistingPoint() {
        var quadTree = getList();

        var result = quadTree.search(new Point(6, 6));
        assertNotNull(result);
        assertEquals("center", result.Value);

        result = quadTree.search(new Point(3, 9));
        assertNotNull(result);
        assertEquals("nw", result.Value);

        result = quadTree.search(new Point(9, 9));
        assertNotNull(result);
        assertEquals("ne", result.Value);
    }

    @Test
    public void testSearchNonExistingPoint() {
        var quadTree = getList();

        var result = quadTree.search(new Point(0, 0));
        assertNull(result);

        result = quadTree.search(new Point(10, 10));
        assertNull(result);
    }

    @Test
    public void testSearchOnEmptyTree() {
        var quadTree = new QuadTree<String>();

        var result = quadTree.search(new Point(6, 6));
        assertNull(result);
    }
}
