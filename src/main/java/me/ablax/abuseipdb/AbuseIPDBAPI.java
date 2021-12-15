package me.ablax.abuseipdb;

import me.ablax.abuseipdb.ednpoints.Blacklist;
import me.ablax.abuseipdb.ednpoints.Check;
import me.ablax.abuseipdb.ednpoints.CheckBlock;
import me.ablax.abuseipdb.ednpoints.ClearAddress;
import me.ablax.abuseipdb.ednpoints.Report;
import me.ablax.abuseipdb.interfaces.Endpoint;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class AbuseIPDBAPI {

    private static final Map<String, AbuseIPDBAPI> instances = new HashMap<>();
    public final Check check;
    public final CheckBlock checkBlock;
    public final ClearAddress clearAddress;
    public final Blacklist blacklist;
    public final Report report;
    private final String apiKey;

    private AbuseIPDBAPI(final String apiKey) {
        this.apiKey = apiKey;

        this.check = createInstance(Check.class);
        this.checkBlock = createInstance(CheckBlock.class);
        this.clearAddress = createInstance(ClearAddress.class);
        this.blacklist = createInstance(Blacklist.class);
        this.report = createInstance(Report.class);
    }

    public static AbuseIPDBAPI registerAPI(final String name, final String apiKey) {
        if (instances.containsKey(name)) {
            //TODO: Throw exception
            return null;
        }

        final AbuseIPDBAPI api = new AbuseIPDBAPI(apiKey);
        instances.put(name, api);

        return api;
    }


    public static AbuseIPDBAPI getAPI(final String name) {
        if (instances.containsKey(name)) {
            return instances.get(name);
        }
        //TODO: Throw exception
        return null;
    }


    private <T extends Endpoint<?, ?>> T createInstance(final Class<T> clazz) {
        try {
            final Constructor<T> constructor = clazz.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            return constructor.newInstance(this.apiKey);
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException x) {
            x.printStackTrace();
        }
        return null;
    }
}
