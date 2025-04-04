package QR;

import static io.restassured.RestAssured.baseURI;

import com.google.gson.JsonObject;

public class Qr {
	
	public static String generateQrRequest(String token, String channel, String orderSubject, String amount ) throws Exception {
        baseURI = "https://merchant.moco.com.np/mpi";

        // Generate the timestamp
        String timestamp = hashcreate.generateTimestamp();

        // Generate the hash
        String secret = "almondsc";
        String dataToHash = token + channel + timestamp;
        String hash = hashcreate.generateHMACSHA256(dataToHash, secret);

        // Create the JSON object with the data
        JsonObject packageObj = new JsonObject();
        packageObj.addProperty("token", token);
        packageObj.addProperty("channel", channel);
        packageObj.addProperty("orderSubject", orderSubject);
        packageObj.addProperty("amount", amount);
        packageObj.addProperty("timestamp", timestamp);
        packageObj.addProperty("hash", hash);
        
        return packageObj.toString();

        
    }

}
