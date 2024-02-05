package edu.example.demoDocker;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.example.demoDocker.models.request.RequestBodyForProduct;
import edu.example.demoDocker.models.request.RequestBodyForProductRegister;
import edu.example.demoDocker.service.*;
import edu.example.demoDocker.service.dto.AgreementsDTO;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import java.util.Date;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Log
@SpringBootTest
@AutoConfigureMockMvc
class DemoDockerApplicationTests {
	@MockBean private ProductRegisterService productRegisterService;
	@MockBean private ProductService productService;
	@Autowired private MockMvc mockMvc;
	@Autowired	ObjectMapper mapper = new ObjectMapper();
	@Autowired
	AccountPoolService accountPoolService;
	@Autowired AgreementsService agreementsService;

	@Test
	@DisplayName("Проверка получения номера лицевого счета из пула для корректного сода подразделения")
	void GetAccountFromPoolSuccess() {
		AccountFromPool accountFromPool=new AccountFromPool(accountPoolService);
		Assertions.assertEquals("475335516415314841861",accountFromPool.getAccount("0022"),"Лицевой счет из пула счетов получен");
	}
	@Test
	@DisplayName("Проверка ошибки получения номера лицевого счета из пула для некорректного сода подразделения")
	void GetAccountFromPoolError() {
		AccountFromPool accountFromPool=new AccountFromPool(accountPoolService);
		when(accountFromPool.getAccount("0023")).thenReturn("Тест успешен - Ошибка определения номера счета");
	}
	@Test
	@DisplayName("Проверка сохранения записи в таблицу Agreements")
	void SaveAgreement() throws Exception {
		AgreementsDTO agr=agreementsService.save(prepareAgreement());
		Assertions.assertNotNull(agr.getId(),"ID экземпляра сохраненного доп. соглашения = "+agr.getId());
		log.info("agr.getId() = "+agr.getId());
	}
    @Test
	@DisplayName("Проверка присутствия в JSON обязательного параметра branchCode")
	void RequiredParamJson() throws Exception {
		String tstBranchCode=null;
		RequestBodyForProductRegister productRegister=prepareAccount(tstBranchCode);
		MvcResult mvcResult=mockMvc.perform(post("/corporate-settlement-account/create", 1L)
								.contentType(MediaType.APPLICATION_JSON)
								.content(mapper.writeValueAsString(productRegister)
								)
		).andExpect(status().isOk())
				.andReturn();
	}
	@Test
	@DisplayName("Проверка ответа сервиса 'ПР.СОЗДАНИЕ.POST corporate-settlement-account/create'")
	void PostAccountCreateServiceLive() throws Exception {
		String tstBranchCode="0022";
		RequestBodyForProductRegister productRegister=prepareAccount(tstBranchCode);
		ResultActions resultActions;
		resultActions=mockMvc.perform(post("/corporate-settlement-account/create", 1L)
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(productRegister))
		).andExpect(status().isOk());
	}
	@Test
	@DisplayName("Проверка ответа сервиса 'ПР.СОЗДАНИЕ.POST corporate-settlement-account/create'")
	void PostProductServiceLive() throws Exception {
		RequestBodyForProduct product=prepareProduct();
		ResultActions resultActions;
		resultActions=mockMvc.perform(post("/corporate-settlement-instance/create", 1L)
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(product))
		).andExpect(status().isOk());
	}
// заполнение умолчательными значениями структуры входящего запроса ПР.СОЗДАНИЕ.POST (получение номера лицевого счета из пула счетов)
	private RequestBodyForProductRegister prepareAccount(String tstBranchCode){
		RequestBodyForProductRegister acc=new RequestBodyForProductRegister();
		acc.setInstanceId(2L);
		acc.setRegistryTypeCode("03.012.002_47533_ComSoLd");
		acc.setAccountType("Клиентский");
		acc.setCurrencyCode("800");
		acc.setBranchCode(tstBranchCode);
		acc.setPriorityCode("00");
		acc.setMdmCode("15");
		return acc;
	}
// заполнение умолчательными значениями структуры для доп. соглашений
	private AgreementsDTO prepareAgreement(){
		AgreementsDTO agr=new AgreementsDTO();
		agr.setId(158L);
		agr.setGeneralAgreementId("521");
		agr.setSupplementaryAgreementId("854");
		agr.setArrangementType("НСО2");
		agr.setShedulerJobId(123456789L);
		agr.setNumber("НСО-521");
		agr.setOpeningDate(new Date());
		agr.setClosingDate(new Date());
		agr.setCancelDate(new Date());
		agr.setValidityDuration(365L);
		agr.setCancellationReason("reason1");
		agr.setStatus("1");
		return agr;
	}
	// заполнение умолчательными значениями структуры входящего запроса ЭП.СОЗДАНИЕ.POST corporate-settlement-instance/create
	private RequestBodyForProduct prepareProduct(){
		RequestBodyForProduct prod=new RequestBodyForProduct();
		prod.setInstanceId(100L);
		prod.setProductType("ДОГОВОР");
		prod.setProductCode("03.012.002");
		prod.setRegisterType("03.012.002_47533_ComSoLd");
		prod.setMdmCode("15");
		prod.setContractNumber("2024-01-10-000027");
		prod.setContractDate(new Date());
		prod.setPriority("2");
		prod.setByCentralBankType("???");
		prod.setInterestRatePenalty(12.25F);
		prod.setMinimalBalance(0);
		prod.setThresholdAmount(0);
		prod.setAccountingDetails("qwerty");
		prod.setRateType("0");
		prod.setTaxPercentageRate(13);
		prod.setTechnicalOverdraftLimitAmount(1000);
		prod.setContractId(112233);
		prod.setBranchCode("0022");
		prod.setIsoCurrencyCode("800");
		prod.setUrgencyCode("00");
		prod.setReferenceCode(1234);
		return prod;
	}
}
