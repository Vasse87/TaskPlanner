import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void shouldMatchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(2, "Сделать домашнее задание");

        boolean expected = true; // Проверка по подходящему слову
        boolean actual = simpleTask.matches("Позвонить родителям");
        Assertions.assertEquals(expected, actual);

        boolean expected2 = false; // // Проверка по неподходящему слову
        boolean actual2 = simpleTask2.matches("Позвонить родителям");
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    public void shouldMatchMeeting() {
        Meeting meeting = new Meeting(1, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        Meeting meeting2 = new Meeting(2, "Выкатка 4й версии приложения", "Приложение Сбербанка", "Во вторник");

        boolean expected = true; // Проверка по подходящему слову в topic
        boolean actual = meeting.matches("Выкатка");
        Assertions.assertEquals(expected, actual);

        boolean expected2 = true; // // Проверка по подходящему слову в project
        boolean actual2 = meeting.matches("Приложение");
        Assertions.assertEquals(expected2, actual2);

        boolean expected3 = false; // // Проверка по подходящему слову в Start
        boolean actual3 = meeting2.matches("вторник");
        Assertions.assertEquals(expected3, actual3);

        boolean expected4 = false; // // Проверка по неподходящему слову
        boolean actual4 = meeting2.matches("созвон");
        Assertions.assertEquals(expected4, actual4);
    }

    @Test
    public void shouldMatchEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(1, subtasks);

        String[] subtasks2 = {};
        Epic epic2 = new Epic(2, subtasks2);

        boolean expected = true; // проверка по подходящему слову
        boolean actual = epic.matches("Молоко");
        Assertions.assertEquals(expected, actual);

        boolean expected2 = false; // проверка по неподходящему слову
        boolean actual2 = epic.matches("Картошка");
        Assertions.assertEquals(expected2, actual2);

        boolean expected3 = false; // проверка в пустом массиве
        boolean actual3 = epic2.matches("выпивка");
        Assertions.assertEquals(expected3, actual3);

    }

}
