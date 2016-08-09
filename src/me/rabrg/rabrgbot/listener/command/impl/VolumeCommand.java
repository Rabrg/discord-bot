package me.rabrg.rabrgbot.listener.command.impl;

import me.rabrg.rabrgbot.RabrgBot;
import me.rabrg.rabrgbot.listener.command.Command;
import net.dv8tion.jda.audio.player.Player;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

public final class VolumeCommand implements Command {

    @Override
    public String getName() {
        return "volume";
    }

    @Override
    public String getDescription() {
        return "Change the volume of the current song";
    }

    @Override
    public void run(final RabrgBot bot, final MessageReceivedEvent event, final String args) {
        final Player player = bot.getAudioPlayer(event.getGuild().getId());
        if (player == null || player.isStopped()) {
            event.getChannel().sendMessage("Must be playing to change the volume.");
        } else {
            try {
                final float volume = Math.min(Float.parseFloat(args), 1);
                player.setVolume(volume);
                event.getChannel().sendMessage("Set volume to " + volume);
            } catch (final NumberFormatException e) {
                event.getChannel().sendMessage(args + " isn't a valid number");
            }
        }
    }
}
