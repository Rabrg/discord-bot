package me.rabrg.rabrgbot.listener;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.hooks.ListenerAdapter;

public final class MessageLogListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(final MessageReceivedEvent event) {
        System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(), event.getTextChannel().getName(),
                event.getAuthor().getUsername(), event.getMessage().getContent());
    }
}
