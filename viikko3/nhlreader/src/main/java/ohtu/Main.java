package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        String bodyText = Request.Get(url).execute().returnContent().asString();

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);

        // Sort by total points
        List<Player> plist = Arrays.asList(players);
        Collections.sort(plist, (a, b) -> b.getPoints() - a.getPoints());
        plist = plist.stream()
            .filter(p -> p.getNationality().equals("FIN"))
            .collect(Collectors.toList());
    
        plist.forEach(System.out::println);
    }
  
}
