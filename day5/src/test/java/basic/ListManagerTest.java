package basic;

import static org.junit.jupiter.api.Assertions.*;

import org.example.junit.basic.ListManager;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {
    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        ListManager.addElement(list, 5);
        assertTrue(list.contains(5)); // Ensure the element was added
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        ListManager.removeElement(list, 5);
        assertFalse(list.contains(5)); // Ensure the element was removed
    }

    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        assertEquals(0, ListManager.getSize(list)); // Initially empty
        list.add(5);
        assertEquals(1, ListManager.getSize(list)); // Size should be 1 after adding an element
    }
}
