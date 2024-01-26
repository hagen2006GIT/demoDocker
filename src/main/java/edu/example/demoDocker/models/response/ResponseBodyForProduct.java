package edu.example.demoDocker.models.response;

import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;

@Getter @Setter
public class ResponseBodyForProduct {
    private HashMap<String,Object> data=new HashMap<>();
    public static ResponseBodyForProduct Of(String instanceId){
        ResponseBodyForProduct responseBody=new ResponseBodyForProduct();
        responseBody.setData(new HashMap<>() {{
            put("instanceId",instanceId);
            put("supplementaryAgreementId",new String[]{"supplementaryAgreementId1","supplementaryAgreementId2"});
            put("registerId",new String[]{"registerId1","registerId2"});
        }});
        return responseBody;
    }
}
