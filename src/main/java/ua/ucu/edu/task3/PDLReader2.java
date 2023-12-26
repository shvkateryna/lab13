package ua.ucu.edu.task3;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import lombok.SneakyThrows;

public class PDLReader2 {
    @SneakyThrows
    public static Map<String, String> extract(String domain) {
        URL url = new URL(domain);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        String text = new Scanner(connection.getInputStream()).useDelimiter("\\Z").next();
        Document doc = Jsoup.parse(text);
        String name = doc.title();

        Element descriptionElement = doc.select("meta[name=description]").first();
        String description = (descriptionElement != null) ? descriptionElement.attr("content") : "";

        Element imgElement = doc.select("img[src*=/logo], img[class*=logo], img[alt*=logo], img[src$=.png], img[src$=.jpg]").first();
        String logoURL = (imgElement != null) ? imgElement.absUrl("src") : "";

        CompanyData company = new CompanyData(domain, description, logoURL, name);

        Map<String, String> result = new HashMap<>();
        result.put("name", name);
        result.put("logo", logoURL);
        result.put("description", description);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(extract("https://shop.silpo.ua"));
    }
}