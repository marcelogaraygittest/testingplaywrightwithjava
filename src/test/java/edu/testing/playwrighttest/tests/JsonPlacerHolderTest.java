package edu.testing.playwrighttest.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.testing.playwrighttest.requestobjects.JsonPlacerHolder;
import edu.testing.playwrighttest.requestobjects.Post;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class JsonPlacerHolderTest {

    //GET /posts
    @Test
    public void MethodGetForPostsEndPointItsStatusCodeShouldBe200(){
        Response response = JsonPlacerHolder.getForPostsEndpoint();
        response.then().assertThat().statusCode(200);
    }

    //GET /posts
    @Test
    public void MethodGetForPostsEndPointItsSizeShouldNotBeZero(){
        JsonPlacerHolder.getForPostsEndpoint().then().assertThat().body("size()", Matchers.not(0));
    }

    //GET /posts/1
    @Test
    public void MethodGetForPostsFirstEndPointItsSizeShouldNotBeZero(){
        JsonPlacerHolder.getForPostsEndpointByPosition(1).then().assertThat().body("size()", Matchers.equalTo(4));
        JsonPlacerHolder.getForPostsEndpointByPosition(1).then().assertThat().body("id", Matchers.equalTo(1));
    }

    //POST /posts
    @Test
    public void MethodPostForPostsEndPointBodyRequestShouldBeEqualsToBodyResponse() throws JsonProcessingException {
        Post postA = new Post();
        postA.setBody("fooo");
        postA.setTitle("bar");
        postA.setUserId(1);

        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(postA);

        Response response = JsonPlacerHolder.postForPostsEndpoint(payload);
        response.then().assertThat().body("size()", Matchers.not(0));
        response.then().assertThat().body("body", Matchers.equalTo(postA.getBody()));
        response.then().assertThat().body("title", Matchers.equalTo(postA.getTitle()));
        response.then().assertThat().body("userId", Matchers.equalTo(postA.getUserId()));
    }

    //PUT /posts/1
    @Test
    public void MethodPutForPostsEndPointBodyRequestShouldBeEqualsToBodyResponse() throws JsonProcessingException {
        Post postA = new Post();
        postA.setBody("Testing body");
        postA.setTitle("Testing Title");
        postA.setUserId(1);

        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(postA);

        Response response = JsonPlacerHolder.putForPostsEndpoint(payload, 1);
        response.then().assertThat().body("size()", Matchers.not(0));
        response.then().assertThat().body("body", Matchers.equalTo(postA.getBody()));
        response.then().assertThat().body("title", Matchers.equalTo(postA.getTitle()));
        response.then().assertThat().body("userId", Matchers.equalTo(postA.getUserId()));
    }

    //DELETE /posts/1
    @Test
    public void MethodDeleteForPostsEndPointBodyRequestShouldBeEqualsToBodyResponse() throws JsonProcessingException {
        JsonPlacerHolder.deleteForPostsEndpoint( 1).then().assertThat().statusCode(200);
    }
}
