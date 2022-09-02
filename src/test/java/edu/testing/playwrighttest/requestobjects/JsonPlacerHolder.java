package edu.testing.playwrighttest.requestobjects;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.Validatable;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class JsonPlacerHolder {

    private static String BASE_URI = "https://jsonplaceholder.typicode.com/";
    private static String ENDPOINT_POSTS = "posts";

    public JsonPlacerHolder(){
    }

    public static Response getForPostsEndpoint(){
        baseURI = BASE_URI;
        return given().baseUri(baseURI)
                .when().get(ENDPOINT_POSTS);
    }

    public static Response getForPostsEndpointByPosition(int position) {
        baseURI = BASE_URI;
        return given().baseUri(baseURI)
                .when().get(ENDPOINT_POSTS+"/"+position);
    }

    public static Response postForPostsEndpoint(String payload) {
        baseURI = BASE_URI;
        return given()
                .baseUri(baseURI)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when().post(ENDPOINT_POSTS);
    }

    public static Response putForPostsEndpoint(String payload, int position) {
        baseURI = BASE_URI;
        return given()
                .baseUri(baseURI)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when().put(ENDPOINT_POSTS+"/"+position);
    }

    public static Response deleteForPostsEndpoint(int position) {
        baseURI = BASE_URI;
        return given()
                .baseUri(baseURI)
                .when().delete(ENDPOINT_POSTS+"/"+position);
    }
}
