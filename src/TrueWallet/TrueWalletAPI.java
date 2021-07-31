package TrueWallet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class TrueWalletAPI {
	
	final public String mobileNumber;
    final public double multiply;
    final JsonObject return_error = (JsonObject) new JsonParser().parse("{\"message\":\"Java error.\",\"code\":\"JAVA_ERROR\"}");
    public String VERIFY_URL = "https://gift.truemoney.com/campaign/vouchers/%hash%/verify";
    public String REDEEM_URL = "https://gift.truemoney.com/campaign/vouchers/%hash%/redeem";

    public TrueWalletAPI(String mobileNumber,double multiply) {
        this.mobileNumber = mobileNumber;
        this.multiply = multiply;
    }

    public JsonPrimitive getVoucherStatus(String vocherId) {
        HttpGet get = new HttpGet(VERIFY_URL.replaceAll("%hash%", vocherId));
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(get)) {
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JsonObject redeemVoucher(String voucherId) throws IOException {
        //EXHash AdVgpElIUm9lb1qYjn
        //Gift Url: https://gift.truemoney.com/campaign/?v=xxxxxxxxxxxxxxxxxx <- numbers,uppercase,lowercase
        HttpPost post = new HttpPost(REDEEM_URL.replaceAll("%hash%", voucherId));
        post.addHeader("Content-Type", "application/json");

        JsonObject json = new JsonObject();
        json.addProperty("mobile", mobileNumber);
        json.addProperty("voucher_hash", voucherId);
        post.setEntity(new StringEntity(json.toString()));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {
            return (JsonObject) new JsonParser().parse(EntityUtils.toString(response.getEntity()));
        } catch (Exception ex) {
            ex.printStackTrace();
            return return_error;
        }
    }

    public JsonObject redeemVoucherFormUrl(String voucher_url) throws IOException {
        try {
            URL url = new URL(voucher_url);
            if (!(url.getHost().equalsIgnoreCase("gift.truemoney.com") && url.getPath().equalsIgnoreCase("/campaign/"))) {
                return return_error;
            }
        } catch (MalformedURLException e) {
            return return_error;
        }
        return redeemVoucher(urlToHash(voucher_url));
    }

    public JsonObject redeem(String voucher) throws IOException {
        if (voucher.contains("v=")) {
            return redeemVoucherFormUrl(voucher);
        } else {
            return redeemVoucher(voucher);
        }
    }

    public String urlToHash(String url) {
        return url.split("v=")[1].replaceAll("[^a-zA-Z0-9]", "");
    }

}
