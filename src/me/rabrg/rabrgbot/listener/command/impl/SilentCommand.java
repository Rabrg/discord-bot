package me.rabrg.rabrgbot.listener.command.impl;

import me.rabrg.rabrgbot.RabrgBot;
import me.rabrg.rabrgbot.listener.command.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

public final class SilentCommand implements Command {

    @Override
    public String getName() {
        return "silent";
    }

    @Override
    public String getDescription() {
        return "Silences the bot";
    }

    @Override
    public void run(final RabrgBot bot, final MessageReceivedEvent event, final String args) {
        event.getChannel().sendMessage("Silent mode is " + (bot.toggleSilence() ? "enabled" : "disabled"));
    }
}
