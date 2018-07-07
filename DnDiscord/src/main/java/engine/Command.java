package engine;

import java.util.List;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

public interface Command {
	public void run(MessageReceivedEvent event, List<String> args);
}
