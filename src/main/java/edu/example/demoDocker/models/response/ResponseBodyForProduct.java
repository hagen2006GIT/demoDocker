package edu.example.demoDocker.models.response;

import edu.example.demoDocker.service.dto.AgreementsDTO;
import edu.example.demoDocker.service.dto.TppProductRegisterDTO;
import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;

@Getter @Setter
public class ResponseBodyForProduct {
    private HashMap<String,Object> data=new HashMap<>();
    public static ResponseBodyForProduct Of(String instanceId, AgreementsDTO[] arrAgr, TppProductRegisterDTO[] arrProductRegister){
        ResponseBodyForProduct responseBody=new ResponseBodyForProduct();
        responseBody.setData(new HashMap<>() {{
            put("instanceId",instanceId);
//            put("supplementaryAgreementId",new String[]{"supplementaryAgreementId1","supplementaryAgreementId2"});
            put("supplementaryAgreementId",arrAgr);
//            put("registerId",new String[]{"registerId1","registerId2"});
            put("registerId",arrProductRegister);
        }});
        return responseBody;
    }
}
