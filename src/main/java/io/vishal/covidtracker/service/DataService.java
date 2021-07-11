package io.vishal.covidtracker.service;

import io.vishal.covidtracker.models.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {

    private static String RAW_DATA_URL = "https://raw.githubusercontent.com/datasets/covid-19/main/data/countries-aggregated.csv";

    private List<LocationStats> allStats = new ArrayList<>();

    public List<LocationStats> getAllStats() {
        return allStats;
    }

    @PostConstruct
    @Scheduled(cron = "* * 13 * * *")
    public  void fetchData() throws IOException, InterruptedException {
        List<LocationStats> newStats = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(RAW_DATA_URL)).build();

        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        StringReader csvReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);
        String date = LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        for (CSVRecord record : records) {
            LocationStats locationStats = new LocationStats();
            String recordDate = record.get("Date");
            if (recordDate.equals(date)) {
                locationStats.setDate(record.get("Date"));
                locationStats.setCountry(record.get("Country"));
                locationStats.setLatestTotalCases(Integer.parseInt(record.get("Confirmed")));
                locationStats.setRecoveredCases(Integer.parseInt(record.get("Recovered")));
                locationStats.setDeaths(Integer.parseInt(record.get("Deaths")));
                newStats.add(locationStats);
            }
        }

        this.allStats = newStats;

    }
}
