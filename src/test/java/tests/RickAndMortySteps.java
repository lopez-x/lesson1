package tests;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RickAndMortySteps {
    private final RequestSpecification rickSpecification = new RequestSpecBuilder().setBaseUri("https://rickandmortyapi.com/api").build();

    public Response getResponse(int someId) {
        Response response = given()
                .spec(rickSpecification)
                .when()
                .get("/character/" + someId)
                .then()
                .extract()
                .response();
        return response;
    }

    public List<String> getCharacterEpisodes(int characterId) {
        int someId = characterId;
        List<String> episodes = getResponse(someId).getBody().jsonPath().get("episode");
        return episodes;
    }

    public List<String> getLastPerson(int episodeLastMorty) {
        Response response = given()
                .spec(rickSpecification)
                .when()
                .get("/episode/" + episodeLastMorty)
                .then()
                .extract()
                .response();
        List<String> persons = response.getBody().jsonPath().get("characters");
        return persons;
    }

    public String getHumanPerson(int characterLastInt) {
        int someId = characterLastInt;
        String humanPerson = getResponse(someId).getBody().jsonPath().get("species");
        return humanPerson;
    }

    public HashMap<String, List<String>> getLocationPerson(int characterLastInt) {
        int someId = characterLastInt;
        HashMap<String, List<String>> locationPerson = getResponse(someId).getBody().jsonPath().get("location");
        return locationPerson;
    }
}
