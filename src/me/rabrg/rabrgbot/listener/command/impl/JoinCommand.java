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
            bot.sendMessage(event.getChannel(), "Channel " + args + " doesn't exist");
        } else if (channel == event.getGuild().getAudioManager().getConnectedChannel()) {
            bot.sendMessage(event.getChannel(), "Already in channel " + channel.getName());
        } else {
            event.getGuild().getAudioManager().closeAudioConnection();
            event.getGuild().getAudioManager().openAudioConnection(channel);
            bot.sendMessage(event.getChannel(), "Joined channel " + channel.getName());
        }
    }
}
