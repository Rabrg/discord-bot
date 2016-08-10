package me.rabrg.rabrgbot.listener.command.impl;

import me.rabrg.rabrgbot.RabrgBot;
import me.rabrg.rabrgbot.listener.command.Command;
import net.dv8tion.jda.audio.player.FilePlayer;
import net.dv8tion.jda.audio.player.Player;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public final class PlayCommand implements Command {

    @Override
    public String getName() {
        return "play";
    }

    @Override
    public String getDescription() {
        return "Play the specified song";
    }

    @Override
    public void run(final RabrgBot bot, final MessageReceivedEvent event, final String args) {
        Player player = bot.getAudioPlayer(event.getGuild().getId());
        if (player != null && player.isPlaying())
            player.stop();

        final File audioFile = new File("./music/" + args);
        try {
            player = new FilePlayer(audioFile);
            bot.putAudioPlayer(event.getGuild().getId(), player);
            event.getGuild().getAudioManager().setSendingHandler(player);
            player.play();
            bot.sendMessage(event.getChannel(), "Now playing: " + args);
        } catch (final IOException e) {
            bot.sendMessage(event.getChannel(), "Could not load the file " + audioFile.getName());
            e.printStackTrace();
        } catch (final UnsupportedAudioFileException e) {
            bot.sendMessage(event.getChannel(),
                    "Could not load file. It either isn't an audio file or isn't a recognized audio format.");
            e.printStackTrace();
        }
    }
}
