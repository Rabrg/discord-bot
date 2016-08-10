package me.rabrg.rabrgbot.listener.command.impl;

import me.rabrg.rabrgbot.RabrgBot;
import me.rabrg.rabrgbot.listener.command.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import java.security.SecureRandom;
import java.util.Random;

public final class RollCommand implements Command {

    private final Random random = new SecureRandom();

    @Override
    public String getName() {
        return "roll";
    }

    @Override
    public String getDescription() {
        return "Roll a 6 faced dice";
    }

    @Override
    public void run(final RabrgBot bot, final MessageReceivedEvent event, final String args) {
        bot.sendMessage(event.getChannel(), "Rolled a " + (random.nextInt(6) + 1));
    }
}
