package me.rabrg.rabrgbot.listener.command.impl;

import me.rabrg.rabrgbot.RabrgBot;
import me.rabrg.rabrgbot.listener.command.Command;
import me.rabrg.rabrgbot.overwatch.OverwatchProfileData;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

public final class OverwatchProfileCommand implements Command {

    @Override
    public String getName() {
        return "owprofile";
    }

    @Override
    public String getDescription() {
        return "Gets the profile of the specified Overwatch user";
    }

    @Override
    public void run(final RabrgBot bot, final MessageReceivedEvent event, final String args) {
        if (args == null || args.length() == 0) {
            bot.sendMessage(event.getChannel(), "You need to specify the tag");
            return;
        }

        final OverwatchProfileData data = bot.getOverwatchApi().getProfileData(args);
        bot.sendMessage(event.getChannel(), "```diff\n" + data.toString() + "\n```");
    }
}
