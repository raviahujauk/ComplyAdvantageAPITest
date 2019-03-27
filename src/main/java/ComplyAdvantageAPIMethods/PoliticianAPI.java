package ComplyAdvantageAPIMethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PoliticianAPI {

    static Response response;

    public static Response addPolitician(String name, String country, String yob, String position, int risk) {

        response =
                RestAssured.given().
                        when().
                        header("Content-Type", "application/json").
                        body("{\n" +
                                "\t\"name\":\""+name+"\",\n" +
                                "\t\"country\":\""+country+"\",\n" +
                                "\t\"yob\":\""+yob+"\",\n" +
                                "\t\"position\":\""+position+"\",\n" +
                                "\t\"risk\":"+risk+"\n" +
                                "}").
                        post("http://ec2-34-251-162-89.eu-west-1.compute.amazonaws.com/peps");
        response.then().
                assertThat().log().all().
                statusCode(201);

        return response;
    }

    public static Response getPolitician() {
        response =
                RestAssured.given().
                        when().
                        header("Content-Type", "application/json").
                        get("http://ec2-34-251-162-89.eu-west-1.compute.amazonaws.com/peps");
        response.then().
                assertThat().log().all().
                statusCode(201);


        return response;
    }

}
