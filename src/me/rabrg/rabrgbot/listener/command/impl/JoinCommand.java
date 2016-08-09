package me.rabrg.rabrgbot.listener.command.impl;

import me.rabrg.rabrgbot.RabrgBot;
import me.rabrg.rabrgbot.listener.command.Command;
import net.dv8tion.jda.entities.VoiceChannel;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

public final class JoinCommand implements Command {

    @Override
    public String getName() {
        return "join";
    }

    @Override
    public String getDescription() {
        return "Make the bot join the specified channel";
    }

    @Override
    public void run(final RabrgBot bot, final MessageReceivedEvent event, final String args) {
        final VoiceChannel channel = event.getGuild().getVoiceChannels().stream().filter(
                vChan -> vChan.getName().equalsIgnoreCase(args)).findFirst().orElse(null);
        if (channel == null) {
            event.getChannel().sendMessage("Channel " + args + " doesn't exist");
        } else if (channel == event.getGuild().getAudioManager().getConnectedChannel()) {
            event.getChannel().sendMessage("Already in channel " + args);
        } else {
            event.getGuild().getAudioManager().closeAudioConnection();
            event.getGuild().getAudioManager().openAudioConnection(channel);
            event.getChannel().sendMessage("Joined channel " + args);
        }
    }
}
