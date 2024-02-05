package data;

import models.request.JsonPlaceholderRequestModelPOST;

public class JsonPlaceholderDataFactory {

    private JsonPlaceholderRequestModelPOST request;

    public JsonPlaceholderDataFactory(JsonPlaceholderRequestModelPOST requestBody){
        request = requestBody;
    }
    public JsonPlaceholderDataFactory setTitle(String value){
        request.setTitle(value);
        return this;
    }
    public JsonPlaceholderDataFactory setBody(String value){
        request.setBody(value);
        return this;
    }
    public JsonPlaceholderRequestModelPOST createRequest(){
        return request;
    }
}
