package me.rabrg.rabrgbot.listener;

import me.rabrg.rabrgbot.RabrgBot;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.hooks.ListenerAdapter;

import java.util.Arrays;
import java.util.List;

public final class NiceTryListener extends ListenerAdapter {

    private final RabrgBot bot;

    public NiceTryListener(final RabrgBot bot) {
        this.bot = bot;
    }

    public void onMessageReceived(final MessageReceivedEvent event) {
        final String message = event.getMessage().getContent();
        final List<String> words = Arrays.asList(message.toLowerCase().split(" "));
        if (words.contains("nt") || message.equals("n t") || message.contains("nice try") || message.contains(" n t")
                || message.contains("en tea")) {
            event.getMessage().deleteMessage();
            event.getChannel().sendMessage("Deleted " + event.getAuthor().getAsMention() + "'s dumb message");
        }
    }
}
