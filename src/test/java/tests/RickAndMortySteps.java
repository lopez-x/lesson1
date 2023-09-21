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

    public List<String> getCharacterEpisodes(int characterId) {
        Response response = given()
                .spec(rickSpecification)
                .when()
                .get("/character/" + characterId)
                .then()
                .extract()
                .response();
        List<String> episodes = response.getBody().jsonPath().get("episode");
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
        Response response = given()
                .spec(rickSpecification)
                .when()
                .get("/character/" + characterLastInt)
                .then()
                .extract()
                .response();
        String humanPerson = response.getBody().jsonPath().get("species");
        return humanPerson;
    }

    public HashMap<String, List<String>> getLocationPerson(int characterLastInt) {
        Response response = given()
                .spec(rickSpecification)
                .when()
                .get("/character/" + characterLastInt)
                .then()
                .extract()
                .response();
        HashMap<String, List<String>> locationPerson = response.getBody().jsonPath().get("location");
        return locationPerson;
    }

    public String getMortyHuman(int characterLastInt) {
        Response response = given()
                .spec(rickSpecification)
                .when()
                .get("/character/" + characterLastInt)
                .then()
                .extract()
                .response();
        String humanMorty = response.getBody().jsonPath().get("species");
        return humanMorty;
    }

    public HashMap<String, List<String>> getLocationMorty(int characterLastInt) {
        Response response = given()
                .spec(rickSpecification)
                .when()
                .get("/character/" + characterLastInt)
                .then()
                .extract()
                .response();
        HashMap<String, List<String>> locationMorty = response.getBody().jsonPath().get("location");
        return locationMorty;
    }
}
