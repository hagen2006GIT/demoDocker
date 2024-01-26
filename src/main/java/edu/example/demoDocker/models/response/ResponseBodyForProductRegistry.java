package edu.example.demoDocker.models.response;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter @Setter
public class ResponseBodyForProductRegistry {
    private HashMap<String,String> data=new HashMap<>();
    public static ResponseBodyForProductRegistry Of(String accountId){
        ResponseBodyForProductRegistry responseBody=new ResponseBodyForProductRegistry();
        responseBody.setData(new HashMap<>() {{put("accountId",accountId);}});
        return responseBody;
    }
}
