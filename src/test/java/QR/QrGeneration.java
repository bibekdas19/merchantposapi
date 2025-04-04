package QR;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class QrGeneration {
    @Test
    public void QrGenerationWithValidParam() throws Exception {
        // Expected status code for this test (200 OK)
        String requestbody = Qr.generateQrRequest("0002902200002356", "Nepal_pay", "test", "100");
     // Send the POST request and assert the expected status code
        given().body(requestbody)
                .when().post("/qr")
                .then().statusCode(200).log().all();
    }

    @Test
    public void QrGenerationWithInvalidToken() throws Exception {
        // Expected status code for this test (400 Bad Request, or whatever is appropriate)
    	String requestbody = Qr.generateQrRequest("invalid_token", "Nepal_pay", "test", "100");
        
        given().body(requestbody)
        .when().post("/qr")
        .then().statusCode(422).log().all();
    }

    @Test
    public void QrGenerationWithAnotherValidParam() throws Exception {
        // Expected status code for this test (200 OK)
    	String requestbody = Qr.generateQrRequest("0002902200002356", "Nepal_pay", "test", "150");
        
        given().body(requestbody)
        .when().post("/qr")
        .then().statusCode(200).log().all();
    }
}
