package engine;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;

public class ClientHelper {
	public static IDiscordClient getClient(String token) {
		ClientBuilder CB = new ClientBuilder();
		CB.withToken(token);
		return CB.build();
	}
}
