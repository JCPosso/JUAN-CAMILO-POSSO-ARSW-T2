package edu.eci.arsw.coronavirus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.coronavirus.cache.cache;
import edu.eci.arsw.coronavirus.service.HTTPConnectionServices;

@Service
public class CoronavirusService {
    @Autowired
    HTTPConnectionServices hca;

    @Autowired
    cache cc;

    public String getCountry(String country) {
        String virus;
        if(cc.cacheCountry(country)) {
            virus = cc.getCache(country);
        } else {
            virus = hca.getCountry(country);
            cc.saveCache(country, virus);
        }
        return virus;
    }
    public String getAllCountries() {
        String virus = hca.getCountries();
        return virus;
    }
    public String getUbication(String country) {
        String ubication = hca.getLocation(country);
        return ubication;
    }
}