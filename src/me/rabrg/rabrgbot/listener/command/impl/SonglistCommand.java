package me.rabrg.rabrgbot.listener.command.impl;

import me.rabrg.rabrgbot.RabrgBot;
import me.rabrg.rabrgbot.listener.command.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import java.io.File;

public final class SonglistCommand implements Command {

    @Override
    public String getName() {
        return "songlist";
    }

    @Override
    public String getDescription() {
        return "Get a list of available songs";
    }

    @Override
    public void run(final RabrgBot bot, final MessageReceivedEvent event, final String args) {
        final File[] root = new File("./music/").listFiles();
        if (root != null) {
            final StringBuilder builder = new StringBuilder();
            builder.append("Available songs:\n");
            for (final File fileEntry : root) {
                builder.append("\t\t\t\t\t\t").append(fileEntry.getName()).append("\n");
            }
            event.getChannel().sendMessage(builder.toString());
        } else {
            event.getChannel().sendMessage("No songs found");
        }
    }
}
