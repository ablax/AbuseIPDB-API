package me.ablax.abuseipdb.client;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Map;

public class HttpClient {

    public final OkHttpClient client = new OkHttpClient();

    public String sendGetRequest(final String endpoint, final String apiKey, final Map<Object, Object> fields) throws IOException {
        final HttpUrl.Builder httpBuilder = getBaseUrl().addPathSegment(endpoint);

        fields.forEach((key, value) -> httpBuilder.addQueryParameter(key.toString(), value.toString()));
        final HttpUrl httpUrl = httpBuilder.build();

        final Request.Builder builder = new Request.Builder();
        builder.url(httpUrl);
        builder.addHeader("Key", apiKey);
        builder.addHeader("Accept", "application/json");

        return client.newCall(builder.build()).execute().body().string();
    }

    public String sendPostRequest(final String endpoint, final String apiKey, final Map<Object, Object> fields) throws IOException {
        final HttpUrl.Builder httpBuilder = getBaseUrl().addPathSegment(endpoint);

        final FormBody.Builder formBuilder = new FormBody.Builder();

        fields.forEach((key, value) -> formBuilder.add(key.toString(), value.toString()));
        final HttpUrl httpUrl = httpBuilder.build();

        final Request.Builder builder = new Request.Builder();
        builder.url(httpUrl);
        builder.post(formBuilder.build());
        builder.addHeader("Key", apiKey);
        builder.addHeader("Accept", "application/json");

        return client.newCall(builder.build()).execute().body().string();
    }

    @NotNull
    private HttpUrl.Builder getBaseUrl() {
        return new HttpUrl.Builder()
                .scheme("https")
                .host("api.abuseipdb.com")
                .addPathSegment("api")
                .addPathSegment("v2");
    }

}
