package engine;

import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

public class MessageListener {
	Map<String, Command> commandMap = new HashMap<String, Command>();

	public MessageListener() {
		commandMap.put("test", (event, args) -> {
			event.getChannel().sendMessage("Hello World!");
		});
	}

	@EventSubscriber
	public void handle(MessageReceivedEvent event) {
		System.out.println(event.getMessage().getContent());
		if (event.getMessage().getContent().startsWith(Properties.commandPrefix) == false
				|| event.getAuthor().isBot() == Properties.disallowBotUsers) {
			System.out.println("||");
			return;
		}
		String[] input = event.getMessage().getContent().split(Properties.commandPrefix);
		String command = input[0].substring(1);
		List<String> args = new ArrayList<String>(Arrays.asList(input));
		args.remove(0);
		if(commandMap.containsKey(command)) {
			commandMap.get(command).run(event, args);
		} else System.out.println("&&" + command);
	}
}
