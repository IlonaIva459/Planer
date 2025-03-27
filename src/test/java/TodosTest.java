import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tasks.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWithMultipleTasks() {
        Todos todos = new Todos();
        SimpleTask simpleTask = new SimpleTask(1, "Купить молоко");
        Epic epic = new Epic(2, new String[]{"Сделать проект", "Запустить тесты"});
        Meeting meeting = new Meeting(3, "Обсуждение проекта", "Проект", "12:00");

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] results = todos.search("проект");
        assertEquals(2, results.length);
        assertTrue(Arrays.asList(results).contains(epic));
        assertTrue(Arrays.asList(results).contains(meeting));
    }
}