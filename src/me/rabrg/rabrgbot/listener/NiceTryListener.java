package me.rabrg.rabrgbot.listener;

import me.rabrg.rabrgbot.RabrgBot;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.hooks.ListenerAdapter;

public final class NiceTryListener extends ListenerAdapter {

    private final RabrgBot bot;

    public NiceTryListener(final RabrgBot bot) {
        this.bot = bot;
    }

    public void onMessageReceived(final MessageReceivedEvent event) {
        final String message = event.getMessage().getContent();
        final String[] words = message.toLowerCase().split(" ");
        for (final String word : words) {
            if (word.startsWith("nt") || word.equals("n t") || word.contains("nice try") || word.contains(" n t")
                    || word.contains("en tea")) {
                event.getMessage().deleteMessage();
                event.getChannel().sendMessage("Deleted " + event.getAuthor().getAsMention() + "'s dumb message");
                break;
            }
        }
    }
}
