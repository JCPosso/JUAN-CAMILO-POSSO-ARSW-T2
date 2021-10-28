package edu.eci.arsw.coronavirus.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import edu.eci.arsw.coronavirus.model.coronavirus;

@Component
public class cache {
    private ConcurrentHashMap<String, coronavirus> cacheCountry = new ConcurrentHashMap<>();

    public synchronized boolean cacheCountry(String country) {
        boolean hayCache = false;
        if (cacheCountry.get(country) != null && System.currentTimeMillis() - cacheCountry.get(country).getTime() <= 180000) {
            hayCache = true;
        }
        return hayCache;
    }

    public void saveCache(String name, String stringjson) {
        coronavirus corona = new coronavirus(System.currentTimeMillis(), stringjson);
        cacheCountry.put(name, corona);
        System.out.println("cache");
    }

    public String getCache(String name) {
        return cacheCountry.get(name).getStringJson();
    }
}