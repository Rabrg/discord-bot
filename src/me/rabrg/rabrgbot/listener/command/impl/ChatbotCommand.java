package me.rabrg.rabrgbot.listener.command.impl;

import me.rabrg.rabrgbot.RabrgBot;
import me.rabrg.rabrgbot.listener.command.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

public final class ChatbotCommand implements Command {

    @Override
    public String getName() {
        return "chatbot";
    }

    @Override
    public String getDescription() {
        return "An artificially intelligent chatbot";
    }

    @Override
    public void run(final RabrgBot bot, final MessageReceivedEvent event, final String args) {
        event.getChannel().sendMessage("Chatbot " + (bot.toggleChatbot() ? "enabled" : "disabled"));
    }
}
