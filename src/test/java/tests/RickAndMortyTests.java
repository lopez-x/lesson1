package tests;

import java.util.*;
import org.apache.commons.lang3.math.NumberUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

public class RickAndMortyTests {
    private RickAndMortySteps rickAndMortySteps;

    @BeforeClass(alwaysRun = true)
    void beforeClass() {
        rickAndMortySteps = new RickAndMortySteps();
    }

    @Test(description = "Успешное получение эпизодов для Морти")
    void successGetMortyEpisodesTest() {
        List<String> episodes = rickAndMortySteps.getCharacterEpisodes(2);
        Assert.assertEquals(episodes.size(), 51, "Количество эпизодов не совпадает");

        //Находим последний эпизод и получаем его индекс
        String Last = episodes.get(episodes.size() - 1);
        String episodeLast = Last.substring(Last.lastIndexOf("/") + 1);
        int episodeLastMorty = NumberUtils.toInt(episodeLast);

        //Находим в эпизоде последнего персонажа и получаем его индекс
        List<String> persons = rickAndMortySteps.getLastPerson(episodeLastMorty);
        String personLast = persons.get(persons.size() - 1);
        String characterLast = personLast.substring(personLast.lastIndexOf("/") + 1);
        int characterLastInt = NumberUtils.toInt(characterLast);

        //Получаем данные расы и локейшн последнего персонажа и Морти и сравниваем их
        String humanPerson = rickAndMortySteps.getHumanPerson(characterLastInt);
        HashMap<String, List<String>> locationPerson = rickAndMortySteps.getLocationPerson(characterLastInt);
        String humanMorty = rickAndMortySteps.getHumanPerson(2);
        HashMap<String, List<String>> locationMorty = rickAndMortySteps.getLocationPerson(2);
        Assert.assertEquals(humanPerson, humanMorty, "Раса Морти и последнего персонажа задания не совпадают!");
        Assert.assertEquals(locationPerson, locationMorty, "Расположение Морти и последнего персонажа задания " +
                "не совпадают!");
    }
}


