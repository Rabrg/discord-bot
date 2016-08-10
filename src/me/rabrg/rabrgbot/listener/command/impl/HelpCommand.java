package me.rabrg.rabrgbot.listener.command.impl;

import me.rabrg.rabrgbot.RabrgBot;
import me.rabrg.rabrgbot.listener.command.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

public final class HelpCommand implements Command {

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Get a list of available commands";
    }

    @Override
    public void run(final RabrgBot bot, final MessageReceivedEvent event, final String args) {
        final StringBuilder builder = new StringBuilder();
        builder.append("Available commands:\n");
        for (final Command command : bot.getCommandListener().getCommands()) {
            builder.append("\t\t\t\t\t\t").append(command.getName()).append(": ").append(command.getDescription())
                    .append("\n");
        }
        bot.sendMessage(event.getChannel(), builder.toString());
    }
}
