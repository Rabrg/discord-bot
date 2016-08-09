package me.rabrg.rabrgbot.listener;

import me.rabrg.rabrgbot.RabrgBot;
import me.rabrg.rabrgbot.listener.command.Command;
import me.rabrg.rabrgbot.listener.command.impl.*;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.hooks.ListenerAdapter;

import java.util.*;

public final class CommandListener extends ListenerAdapter {

    private final List<Command> commands;

    private final RabrgBot bot;

    public CommandListener(final RabrgBot bot) {
        this.bot = bot;

        commands = Arrays.asList(new HelpCommand(), new JoinCommand(), new LeaveCommand(), new PlayCommand(),
                new StopCommand(), new VolumeCommand(), new SonglistCommand(), new RollCommand(), new AskCommand());
    }

    public void onMessageReceived(final MessageReceivedEvent event) {
        String message = event.getMessage().getContent();

        if (message.startsWith("!")) {
            message = message.substring(1);
            final String name = message.split(" ")[0];
            for (final Command command : commands) {
                if (command.getName().equalsIgnoreCase(name)) {
                    final String args = name.length() + 1 >= message.length() ? "" : message.substring(name.length() + 1);
                    command.run(bot, event, args);
                }
            }
        }
    }

    public List<Command> getCommands() {
        return commands;
    }
}
