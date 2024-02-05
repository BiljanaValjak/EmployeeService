package mother;

import models.request.JsonPlaceholderRequestModelPOST;

public class JsonPlaceholderMother {

    public static JsonPlaceholderRequestModelPOST createBodyForPost(){
        return JsonPlaceholderRequestModelPOST.builder()
                .title("Default title")
                .body("Default body")
                .build();
    }
}
