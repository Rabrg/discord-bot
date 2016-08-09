package me.rabrg.rabrgbot.listener.command;

import me.rabrg.rabrgbot.RabrgBot;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

public interface Command {

    String getName();

    String getDescription();

    void run(final RabrgBot bot, final MessageReceivedEvent event, final String args);
}
