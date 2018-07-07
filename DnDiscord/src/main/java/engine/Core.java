package engine;

import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;

public class Core {
	public static IDiscordClient cl;

	public static void main(String[] args) {
		cl = ClientHelper.getClient(args[0]);
		cl.login();
		EventDispatcher ev = cl.getDispatcher();
		ev.registerListener(new MessageListener());
	}
}
