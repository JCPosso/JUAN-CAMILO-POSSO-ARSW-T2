package edu.eci.arsw.coronavirus.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kong.unirest.Unirest;
import kong.unirest.UnirestException;


@Component
public class HTTPConnectionServices {
    public String getCountries() {
        String JSON = null;
        try {
            kong.unirest.HttpResponse<String> response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats")
                    .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                    .header("x-rapidapi-key", "755a10ea15mshd6dd2c1cc4c60e2p196577jsnb5d76b1a4686").asString();
            JSON = response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return JSON;
    }

    public String getCountry(String country) {
        String JSON = "";
        try {
            kong.unirest.HttpResponse<String> response = Unirest
                    .get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=" + country)
                    .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                    .header("x-rapidapi-key", "755a10ea15mshd6dd2c1cc4c60e2p196577jsnb5d76b1a4686").asString();
            JSON = response.getBody();
            System.out.println(response);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        System.out.println(JSON);
        return JSON;
    }

    public String getLocation(String country) {
       String JSON = null;
        try {
            kong.unirest.HttpResponse<String> response = Unirest.get("https://restcountries-v1.p.rapidapi.com/name/" + country)
                    .header("x-rapidapi-host", "restcountries-v1.p.rapidapi.com")
                    .header("x-rapidapi-key", "755a10ea15mshd6dd2c1cc4c60e2p196577jsnb5d76b1a4686")
                    .asString();
            JSON = response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        System.out.println(JSON);
        return JSON;
    }

}