import org.junit.jupiter.api.Test;
import unisinos.models.Interval;
import unisinos.models.Interval2D;
import unisinos.models.QuadTree;
import unisinos.models.QuadTreeADT;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
