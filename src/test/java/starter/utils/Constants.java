package starter.utils;

//untuk hal-hal reuseable
public class Constants {
    public static String DIR = System.getProperty("user.dir");  //dir itu bakal ngambil root directory
    public static String BASE_URL = "https://reqres.in";
    public static String JSON_FOLDER = DIR + "/src/test/resources/JSON/"; //mulai dari directory
    public static String REQ_BODY = JSON_FOLDER + "REQ_BODY/";
    public static String JSON_SCHEMA = JSON_FOLDER + "JSON_SCHEMA/";

}
