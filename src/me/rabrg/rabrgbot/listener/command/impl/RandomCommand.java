package me.rabrg.rabrgbot.listener.command.impl;

import me.rabrg.rabrgbot.RabrgBot;
import me.rabrg.rabrgbot.listener.command.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class RandomCommand implements Command {

    @Override
    public String getName() {
        return "random";
    }

    @Override
    public String getDescription() {
        return "Displays a random image from imgur";
    }

    @Override
    public void run(final RabrgBot bot, final MessageReceivedEvent event, final String args) {
        try {
            final String string = "http://imgur.com/gallery/random";
            final URL url = new URL(string);
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setInstanceFollowRedirects(false);
            bot.sendMessage(event.getChannel(), connection.getHeaderField("Location"));
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
