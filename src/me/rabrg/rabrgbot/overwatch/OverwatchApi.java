package me.rabrg.rabrgbot.overwatch;

import com.google.gson.Gson;
import me.rabrg.rabrgbot.util.JsonUtil;

public final class OverwatchApi {

    private static final String BASE_ENDPOINT = "https://api.lootbox.eu";

    private static final String PLATFORM = "pc";
    private static final String REGION = "us";

    private final Gson gson = new Gson();

    public OverwatchProfileData getProfileData(final String tag) {
        return gson.fromJson(getResposne(tag.replace("#", "-"), "profile"), OverwatchProfile.class).getData();
    }

    private String getResposne(final String... args) {
        final StringBuilder endpoint = new StringBuilder(BASE_ENDPOINT).append('/').append(PLATFORM)
                .append('/').append(REGION);
        for (final String arg : args)
            endpoint.append('/').append(arg);

        return JsonUtil.getJsonResponse(endpoint.toString());
    }
}
