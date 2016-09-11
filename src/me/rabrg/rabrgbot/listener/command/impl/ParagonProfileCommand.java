package me.rabrg.rabrgbot.listener.command.impl;

import me.rabrg.rabrgbot.RabrgBot;
import me.rabrg.rabrgbot.listener.command.Command;
import me.rabrg.rabrgbot.paragon.ParagonProfileData;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

public final class ParagonProfileCommand implements Command {

    @Override
    public String getName() {
        return "paragon";
    }

    @Override
    public String getDescription() {
        return "Gets the profile of the specified Paragon user";
    }

    @Override
    public void run(final RabrgBot bot, final MessageReceivedEvent event, final String args) {
        if (args == null || args.length() == 0) {
            bot.sendMessage(event.getChannel(), "You need to specify the username");
            return;
        }

        try {
            final ParagonProfileData data = bot.getParagonApi().getProfileData(args);
            bot.sendMessage(event.getChannel(), "```diff\n" + data.toString() + "\n```");
        } catch (final Exception e) {
            e.printStackTrace();
            bot.sendMessage(event.getChannel(), "Failed to find " + args + "'s profile");
        }
    }
}
