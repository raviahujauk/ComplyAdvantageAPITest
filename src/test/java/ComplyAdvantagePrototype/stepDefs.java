package ComplyAdvantagePrototype;

import ComplyAdvantageAPIMethods.PoliticianAPI;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

public class stepDefs {

    Response response;
    PoliticianAPI apAPI = new PoliticianAPI();
    JsonPath jp;

    @Given("^I request ComplyAdvantage$")
    public void i_request_ComplyAdvantage() throws Throwable {
        /* API authentication steps comes here
        Because this API has no firewall we leave it blank for potential authentication  */
    }

    @When("^I post adding politicians \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_post_adding_politicians_and(String name, String country, String yob, String position, int risk) throws Throwable {
        Response response = apAPI.addPolitician(name,country,yob,position,risk);
        // Display response
        jp = response.jsonPath();
        System.out.println("Newly created ID is : "+jp.get("id"));
        System.out.println("Response message is : "+jp.get("message"));
        System.out.println("Response status is : "+jp.get("ok"));
    }

    @Then("^I get an OK response$")
    public void i_get_an_OK_response() throws Throwable {
        Assert.assertEquals(jp.get("ok"),true);
    }

    @When("^I request get method for endpoint \"([^\"]*)\"$")
    public void i_request_get_method_for_endpoint(String url) throws Throwable {
        response = apAPI.getPolitician(url);
    }

    @Then("^I get response as list of the latest (\\d+) politicians, order by date of creation$")
    public void i_get_response_as_list_of_the_latest_politicians_order_by_date_of_creation(int arg1) throws Throwable {
        jp = response.jsonPath();
        List<String> jsonResponse = jp.getList("name");
        for(int i=0; i<5 ; i++)
        System.out.println(jsonResponse.get(i));
    }
}
