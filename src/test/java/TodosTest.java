import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTest {

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

    @BeforeEach
    public void setup() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
    }

    @Test
    public void shouldGetTaskFromTheClasses() {

        Task[] expected = {epic}; // Должен находить задачу в классе Epic по подходящему слову
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);

        Task[] expected1 = {simpleTask}; // Должен находить задачу в классе SimpleTask по подходящему слову
        Task[] actual1 = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected1, actual1);

        Task[] expected2 = {meeting}; // Должен находить задачу в классе Meeting по подходящему слову
        Task[] actual2 = todos.search("Выкатка");
        Assertions.assertArrayEquals(expected2, actual2);

        Task[] expected3 = {}; // Не должен находить задачу, так как слова нет ни в одном классе
        Task[] actual3 = todos.search("Сыр");
        Assertions.assertArrayEquals(expected3, actual3);
    }

    @Test
    public void shouldNotGetTaskFromTheClasses() {
        Task[] expected = {}; // Не должен находить задачу, так как слова нет ни в одном классе
        Task[] actual = todos.search("Сыр");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotGetTaskFromEmptyTodos() { // не должен находить задачу в пустом репозитории
        Todos todos2 = new Todos();
        Task[] expected = {};
        Task[] actual = todos2.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}
