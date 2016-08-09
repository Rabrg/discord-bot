package me.rabrg.rabrgbot.listener.command.impl;

import me.rabrg.rabrgbot.RabrgBot;
import me.rabrg.rabrgbot.listener.command.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

public final class LeaveCommand implements Command {

    @Override
    public String getName() {
        return "leave";
    }

    @Override
    public String getDescription() {
        return "Leave the current channel";
    }

    @Override
    public void run(final RabrgBot bot, final MessageReceivedEvent event, final String args) {
        if (event.getGuild().getAudioManager().getConnectedChannel() != null) {
            event.getChannel().sendMessage("Leaving channel " + event.getGuild().getAudioManager()
                    .getConnectedChannel().getName());
            event.getGuild().getAudioManager().closeAudioConnection();
        } else {
            event.getChannel().sendMessage("Not in a channel");
        }
    }
}
