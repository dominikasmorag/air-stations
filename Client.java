import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class Client {
    private static final String WEBSITE_URI = "https://api.gios.gov.pl/pjp-api/rest/station/findAll";
    private final HttpClient client = HttpClient.newHttpClient();
    private final HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(WEBSITE_URI))
            .header("accept", "application/json")
            .GET()
            .build();
    private final ObjectMapper mapper = new ObjectMapper();

    public static ArrayList<Station> stationsList = new ArrayList<>();
    public static ArrayList<City> citiesList = new ArrayList<>();

    @JsonIgnoreProperties(ignoreUnknown = true)

    public Client() throws IOException, InterruptedException {
        mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
    }

    public void jsonToObjects() throws IOException, InterruptedException{
        toObjects();
    }

    private void toObjects() throws IOException, InterruptedException {
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonNode node = mapper.readTree(response.body());
        System.out.println(node.size());
        System.out.println(node);
        for (JsonNode jsonNode : node) {
            Station station = new Station();
            City city = new City();
            JsonNode cityNode = jsonNode.at("/city");
            JsonNode communeNode = cityNode.at("/commune");

            station.setId(jsonNode.get("id").asInt());
            station.setStationName(jsonNode.get("stationName").asText());
            station.setGegrLat(Float.valueOf(jsonNode.get("gegrLat").asText()));
            station.setGegrLon(Float.valueOf(jsonNode.get("gegrLon").asText()));
            station.setAddressStreet(jsonNode.get("addressStreet").asText());
            station.setCityId(cityNode.get("id").asInt());
            stationsList.add(station);

            city.setId(cityNode.get("id").asInt());
            city.setName(cityNode.get("name").asText());
            city.setCommuneName(communeNode.get("communeName").asText());
            city.setDistrictName(communeNode.get("districtName").asText());
            city.setProvinceName(communeNode.get("provinceName").asText());
            citiesList.add(city);
        }
    }
}

