package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    private String query;

    @Test
    public void testSimpleTaskMatchesSuccess () {
        SimpleTask task = new SimpleTask( 1234, "Позвонить Наташе");
        boolean actual = task.matches("Позвонить Наташе");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskMatchesFailed() {
        SimpleTask task = new SimpleTask( 1234, "Позвонить Наташе");
        boolean actual = task.matches("Написать Наташе");
        Assertions.assertFalse(actual);
    }
    @Test
    public void testEpicMatchesSuccess () {
        Epic task = new Epic( 1234, new String[] {"Мясо","Сало","Конфеты","Мясо"});
        boolean actual = task.matches("Конфеты");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicMatchesFailed () {
        Epic task = new Epic( 1234, new String[] {"Мясо","Сало","Конфеты","Мясо"});
        boolean actual = task.matches("Игрушка");
        Assertions.assertFalse(actual);
    }
}