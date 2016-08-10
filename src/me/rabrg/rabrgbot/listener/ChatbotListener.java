package me.rabrg.rabrgbot.listener;

import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;
import me.rabrg.rabrgbot.RabrgBot;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.hooks.ListenerAdapter;

public final class ChatbotListener extends ListenerAdapter {

    private final RabrgBot bot;

    private ChatterBotSession chatbot;

    public ChatbotListener(final RabrgBot bot) {
        this.bot = bot;
    }

    public void onMessageReceived(final MessageReceivedEvent event) {
        final String message = event.getMessage().getContent();
        if (bot.chatbotEnabled() && !event.getAuthor().isBot() && !"!chatbot".equals(message)
                && !message.contains("http") && !message.contains("www.")
                && !message.startsWith(CommandListener.COMMAND_PREFIX)) {
            if (chatbot == null) {
                try {
                    chatbot = new ChatterBotFactory().create(ChatterBotType.CLEVERBOT).createSession();
                } catch (final Exception e) {
                    e.printStackTrace();
                    event.getChannel().sendMessage("Failed to create chatbot");
                }
            }
            if (chatbot != null) {
                try {
                    event.getChannel().sendMessage(chatbot.think(event.getMessage().getContent()));
                } catch (final Exception e) {
                    e.printStackTrace();
                    event.getChannel().sendMessage("Failed to get chatbot response");
                }
            }
        }
    }
}
