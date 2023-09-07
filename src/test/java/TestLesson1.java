import org.testng.Assert;
import org.testng.annotations.*;

public class TestLesson1 {
    private int rad;

    @BeforeMethod(alwaysRun = true)
    void beforeTest() {
        rad = 15;
        System.out.println("Радиус окружности - "+rad +" мм");
    }


    @AfterMethod(alwaysRun = true)
    void afterTest() {
        System.out.println("Тест завершен!");
    }

    @Test(description = "Первый тест. Длина окружности")
    void firstTest() {
        double length = Math.PI * 2 * rad;
        Assert.assertEquals(94.24777960769379, length, "Ошибка! Длина окружности считается некорректно!");
        System.out.println("Игог первого теста: длина окружности равна "+length+" мм");
    }

    @Test(description = "Второй тест. Площадь круга")
    void secondTest() {
        double square = Math.PI * (rad * rad);
        Assert.assertEquals(706.8583470577034, square, "Ошибка! Длина окружности считается некорректно!");
        System.out.println("Игог второго теста: площадь окружности равна "+square+" мм²");
    }
}