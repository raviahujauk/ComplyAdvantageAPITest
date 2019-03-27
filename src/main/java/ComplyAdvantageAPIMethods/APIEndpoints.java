package ComplyAdvantageAPIMethods;

import com.google.common.collect.Multimap;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class APIEndpoints {

    static Multimap<String, String> multiMap;
    Response response;
    
    static PoliticianAPI apAPI = new PoliticianAPI();


    public static void main(String[] args) {

        Response response = apAPI.addPolitician("Testing", "NL", "26/10/1978", "Senator", 2);

        // Display response
        JsonPath jp = response.jsonPath();
        System.out.println("Newly created ID is : "+jp.get("id"));
        System.out.println("Response message is : "+jp.get("message"));
        System.out.println("Response status is : "+jp.get("ok"));
    }

}
