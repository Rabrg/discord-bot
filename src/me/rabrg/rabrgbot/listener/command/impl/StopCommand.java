package me.rabrg.rabrgbot.listener.command.impl;

import me.rabrg.rabrgbot.RabrgBot;
import me.rabrg.rabrgbot.listener.command.Command;
import net.dv8tion.jda.audio.player.Player;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

public final class StopCommand implements Command {

    @Override
    public String getName() {
        return "stop";
    }

    @Override
    public String getDescription() {
        return "Stop the current song";
    }

    @Override
    public void run(final RabrgBot bot, final MessageReceivedEvent event, final String args) {
        final String guildId = event.getGuild().getId();
        final Player player = bot.getAudioPlayer(guildId);
        if (player == null || player.isStopped()) {
            bot.sendMessage(event.getChannel(), "Must be playing to stop");
        } else {
            player.stop();
            bot.putAudioPlayer(guildId, null);
            bot.sendMessage(event.getChannel(), "Stopped playing");
        }
    }
}
