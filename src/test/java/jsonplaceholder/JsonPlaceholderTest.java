package jsonplaceholder;

import client.JsonPlaceholderClient;
import data.JsonPlaceholderDataFactory;
import io.restassured.response.Response;
import models.request.JsonPlaceholderRequestModelPOST;
import models.response.JsonPlaceholderResponseModelPOST;
import org.junit.Test;

import static mother.JsonPlaceholderMother.createBodyForPost;
import static org.junit.Assert.assertEquals;

public class JsonPlaceholderTest {

    @Test
    public void postJsonPlaceholderDefaultValuesTest(){

        JsonPlaceholderRequestModelPOST requestBody = new JsonPlaceholderDataFactory(createBodyForPost())
                .createRequest();

        Response responsePost = new JsonPlaceholderClient()
                .postJsonPlaceholder(requestBody);

        JsonPlaceholderResponseModelPOST jsonPlaceholderResponse = responsePost.body().as(JsonPlaceholderResponseModelPOST.class);

        assertEquals(201, responsePost.statusCode());
        assertEquals("Default title",jsonPlaceholderResponse.getTitle() );
        assertEquals("Default body",jsonPlaceholderResponse.getBody());
    }
    @Test
    public void postJsonPlaceholderValuesTest(){

        JsonPlaceholderRequestModelPOST requestBody = new JsonPlaceholderDataFactory(createBodyForPost())
                .setTitle("Makedonija osvoi svetsko prvenstvo vo fudbal")
                .setBody("Noviot svetski prvak Makedonija go osvoi svetskoto prvenstvo vo fudbal odrzano vo Madrid")
                .createRequest();

        Response responsePost = new JsonPlaceholderClient()
                .postJsonPlaceholder(requestBody);

        JsonPlaceholderResponseModelPOST jsonPlaceholderResponse = responsePost.body().as(JsonPlaceholderResponseModelPOST.class);

        assertEquals(201, responsePost.statusCode());
        assertEquals("Makedonija osvoi svetsko prvenstvo vo fudbal",jsonPlaceholderResponse.getTitle() );
        assertEquals("Noviot svetski prvak Makedonija go osvoi svetskoto prvenstvo vo fudbal odrzano vo Madrid",jsonPlaceholderResponse.getBody() );
    }
}
