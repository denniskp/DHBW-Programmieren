package de.dhbwka.java.exercise.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Comparator;
import java.util.List;

class GeonamesSortByPopulation implements Comparator<Geonames> {
    @Override
    public int compare(Geonames o1, Geonames o2) {
        return Integer.compare(o1.population, o2.population);
    }
}

class Geonames {
    public String fcodeName;
    public String toponymName;
    public String countrycode;
    public String fcl;
    public String fclName;
    public String name;
    public String wikipedia;
    public double lng;
    public String fcode;
    public int geonameId;
    public double lat;
    public int population;
}

@SuppressWarnings("unused")
class GeocodingResult {
    public List<Geonames> geonames;
}

public class Cities {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.iai.kit.edu/javavl/data/static/cities.json");
        try (Reader reader = new InputStreamReader(url.openConnection().getInputStream())) {
            GeocodingResult result = new Gson().fromJson(reader, GeocodingResult.class);
            result.geonames.sort(new GeonamesSortByPopulation());
            System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(result.geonames));
        }
    }
}
