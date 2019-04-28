package part01.lesson04.task03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectBoxTest {

    private ObjectBox ob;

    @BeforeEach
    public void initCollection() {
        ob = new ObjectBox();
    }

    @Test
    void addElement() {
        assertEquals(0, ob.size());
        ob.addElement(new Object());
        assertEquals(1, ob.size());
    }

    @Test
    void deleteElement() {
        ob.addElement("test");
        ob.deleteElement("test");
        assertEquals(0, ob.size());
        ob.addElement(new Object());
        ob.deleteElement(new Object());
        assertEquals(1, ob.size());
    }

    @Test
    void dump() {
        ob.addElement("test");
        ob.addElement(123);
        ob.addElement(4.0);
        assertEquals("test, 123, 4.0", ob.dump());
    }

    @Test
    void notUnique() {
        assertEquals(0, ob.size());
        ob.addElement(1);
        ob.addElement(1);
        assertEquals(2, ob.size());
    }
}