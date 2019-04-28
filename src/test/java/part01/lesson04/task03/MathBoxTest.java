package part01.lesson04.task03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import part01.lesson04.task03.MathBox;

import static org.junit.jupiter.api.Assertions.*;

class MathBoxTest {

    private MathBox mb;
    private Number[] array = {1, 5, 4, 6, 1.0, 1L, 3.0, 3.0};
    private Number[] uniqueArray = {1, 5, 4, 6, 1.0, 1L, 3.0};


    @BeforeEach
    public void initCollection() {
        mb = new MathBox(array);
    }

    @Test
    void uniqueness() {
        assertEquals(7, mb.size());
        assertEquals(new MathBox(uniqueArray), mb);
    }

    @Test
    void summator() {
        assertEquals(21.0, mb.summator());
    }

    @Test
    void splitter() {
        mb.splitter(2.0);
        assertEquals(new MathBox(new Number[]{0.5, 2.5, 2.0, 3.0, 1.5}), mb);
    }

    @Test
    void equals() {
        MathBox newMb = new MathBox(array);
        assertTrue(mb.equals(newMb));
        assertTrue(newMb.equals(mb));
        newMb.addElement(8);
        assertFalse(mb.equals(newMb));
        assertFalse(newMb.equals(mb));
    }

    @Test
    void deleteInteger() {
        mb.deleteInteger(4);
        assertEquals(new MathBox(new Number[] {1, 5, 6, 1.0, 1L, 3.0}), mb);
    }

    @Test
    void hashCode1() {
        int hashCode = 0;
        for (int i = 0; i < uniqueArray.length; i++) {
            hashCode += uniqueArray[i].hashCode();
        }
        assertEquals(hashCode, mb.hashCode());
    }

    @Test
    void toString1() {
        assertEquals("1.0, 1, 1, 4, 5, 6, 3.0", mb.toString());
    }
}