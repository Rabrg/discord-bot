package me.rabrg.rabrgbot.listener.command.impl;

import me.rabrg.rabrgbot.RabrgBot;
import me.rabrg.rabrgbot.listener.command.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class AskCommand implements Command {

    private static final List<String> RESPONSES = Arrays.asList("It is certain", "It is decidedly so", "Without a doubt",
            "Yes, definitely", "You may rely on it", "As I see it, yes", "Most likely", "Outlook good", "Yes",
            "Signs point to yes", "Reply hazy try again", "Ask again later", "Better not tell you now",
            "Concentrate and ask again", "Don't count on it", "My reply is no", "My sources say no",
            "Outlook not so good", "Very doubtful");

    private final Random random = new SecureRandom();

    @Override
    public String getName() {
        return "ask";
    }

    @Override
    public String getDescription() {
        return "Ask the Magic 8-Ball a question";
    }

    @Override
    public void run(final RabrgBot bot, final MessageReceivedEvent event, final String args) {
        if (args.toLowerCase().contains("should i ban pery") || args.toLowerCase().contains("should i ban perry"))
            bot.sendMessage(event.getChannel(), "Yes, definitely");
        else
            bot.sendMessage(event.getChannel(), RESPONSES.get(random.nextInt(RESPONSES.size())));
    }
}
