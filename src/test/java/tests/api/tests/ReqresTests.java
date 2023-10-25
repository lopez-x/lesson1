package tests.api.tests;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.api.steps.ReqresSteps;

public class ReqresTests {
    private ReqresSteps reqresSteps;

    @BeforeClass(alwaysRun = true)
    void beforeClass() {
        reqresSteps = new ReqresSteps();
    }

    @Test(description = "Создание клиента")
    void successCreateClientTest() {
        String clientRequestBody = reqresSteps.getReqresRequestBody("client.json");
        String clientResponseBody = reqresSteps.postClient(clientRequestBody);

        String expectedClientName = new JSONObject(clientRequestBody).get("name").toString();

        String actualClientName = new JSONObject(clientResponseBody).get("name").toString();
        String clientId = new JSONObject(clientResponseBody).get("id").toString();

        String expectedClientJob = "Sbermarket";
        String clientChangedName = "Alexander";
        JSONObject addJob = new JSONObject(clientResponseBody).put("job", expectedClientJob);
        String changeClient = addJob.put("name", clientChangedName).toString();
        String putResponseBody = reqresSteps.postClient(changeClient);
        String actualClientJob = new JSONObject(putResponseBody).get("job").toString();
        String actualChangedName = new JSONObject(putResponseBody).get("name").toString();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualClientName, expectedClientName, "Имя сохранилось неверно");
        softAssert.assertNotNull(clientId, "id клиента равен null");
        softAssert.assertEquals(expectedClientJob, actualClientJob, "Место работы добавлено неверно");
        softAssert.assertEquals(actualChangedName, clientChangedName, "Имя изменено неверно");
        softAssert.assertAll();
    }
}