package client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.JsonPlaceholderRequestModelPOST;
import util.ConfigurationJsonPlaceholder;

public class JsonPlaceholderClient {

    public Response postJsonPlaceholder(JsonPlaceholderRequestModelPOST request){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .post(ConfigurationJsonPlaceholder.JSONPLACEHOLDER_POST_URL)
                .thenReturn();

    }


}
