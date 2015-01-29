package library;

/**
 * Created by Oliver on 28/01/2015.
 */
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.content.Context;

public class UserFunctions {

    private JSONParser jsonParser;

    // Testing in localhost using wamp
    // use http://10.0.2.2/ to connect to your localhost ie http://localhost/
    private static String loginURL = "http://10.0.2.2/ah_login_api/";
    private static String registerURL = "http://10.0.2.2/ah_login_api/";

    private static String login_tag = "login";
    private static String register_tag = "register";

    // constructor
    public UserFunctions(){
        jsonParser = new JSONParser();
    }


    /**
     * function make register Request
     * @param name
     * @param email
     * @param phone
     * @param address1
     * @param address2
     * @param postCode
     * */
    public JSONObject registerUser(String name, String email, String address1, String address2, String postCode, String phone){
        // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", register_tag));
        params.add(new BasicNameValuePair("name", name));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("address1", address1));
        params.add(new BasicNameValuePair("phone", phone));
        params.add(new BasicNameValuePair("address2", address2));
        params.add(new BasicNameValuePair("postCode", postCode));

        // getting JSON Object
        JSONObject json = jsonParser.getJSONFromUrl(registerURL, params);
        // return json
        return json;
    }

}