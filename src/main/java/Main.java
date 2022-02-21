import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static final String BASE_URL="https://catfact.ninja/fact";

    public static void main(String[] args) {
        System.out.println("Do you want to hear some cat fact?(Yes or No)");
        Scanner scn = new Scanner(System.in);
        String answer = scn.nextLine();
        String result =retrieveInformation(BASE_URL);

        if(Objects.equals(answer, "Yes")) {
            Gson gson =new Gson();
            CatFacts catfacts =gson.fromJson(result,CatFacts.class);
            System.out.println(catfacts.fact);
        }else if (Objects.equals(answer, "No")){
            System.out.println("Enjoy your day!");
        }else
            System.out.println("Wrong input");

    }
    private static String retrieveInformation(String urlString) {
        HttpURLConnection connection = null;


        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            StringBuilder result = new StringBuilder();
            var inputStreamReader = new InputStreamReader(connection.getInputStream());
            var bufferedReader = new BufferedReader(inputStreamReader);
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                result.append(line);
            }

            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
