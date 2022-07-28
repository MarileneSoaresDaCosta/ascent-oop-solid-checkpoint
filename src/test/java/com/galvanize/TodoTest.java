package com.galvanize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

public class TodoTest {
    private Owner owner;
    @BeforeEach
    public void setUp() {
        owner = new Owner("Alex", "Hamilton", "alex@example.com", "Treasurer");
    }

    @Test
    public void testICalendar() {
        Todo todo = new Todo("Do stuff", owner);

        String expected = "BEGIN:VTODO\n" +
                "COMPLETED::null\n" +
                "UID:[a-z0-9-]{36}@example.com\n" +
                "SUMMARY:Do stuff\n" +
                "END:VTODO\n";

        assertLinesMatch(Arrays.asList(expected.split("\n")), Arrays.asList(todo.iCalendar().split("\n")));
    }

    @Test
    public void toStringWorks() {
        Todo todo = new Todo("Do stuff", owner);

        assertEquals(
                "Do stuff <Alex Hamilton> alex@example.com (Treasurer): incomplete",
                todo.toString()
        );

        todo.markComplete();

        assertEquals(
                "Do stuff <Alex Hamilton> alex@example.com (Treasurer): complete",
                todo.toString()
        );
    }

    @Test
    public void itHasADescription() {
        Todo todo = new Todo("Do stuff", owner);
        todo.setDescription("There's a million things he hasn't done");

        assertEquals(
                "There's a million things he hasn't done",
                todo.getDescription()
        );
    }

    /*
    @Test
    public void returnsNewNameInAllTodosWhenChangesOwnerName() {
        Todo todo = new Todo("Do stuff", owner);
        Todo todo2 = new Todo("Do extra stuff", owner);
        todo.setOwnerName();

        assertEquals(
                "There's a million things he hasn't done",
                todo.
        );
    }
*/
}
