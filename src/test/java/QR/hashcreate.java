package QR;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.commons.codec.binary.Hex;

public class hashcreate {

    // Function to generate the timestamp in "yyyy-MM-dd HH:mm:ss" UTC format
    public static String generateTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(new Date());
    }

    // Function to calculate HMAC-SHA256 hash
    public static String generateHMACSHA256(String data, String secret) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
        mac.init(secretKey);
        byte[] hashBytes = mac.doFinal(data.getBytes());
        return Hex.encodeHexString(hashBytes);
    }
}