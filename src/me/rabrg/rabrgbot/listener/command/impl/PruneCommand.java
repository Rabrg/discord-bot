package me.rabrg.rabrgbot.listener.command.impl;

import me.rabrg.rabrgbot.RabrgBot;
import me.rabrg.rabrgbot.listener.command.Command;
import net.dv8tion.jda.entities.Message;
import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import java.util.stream.Collectors;

public final class PruneCommand implements Command {

    @Override
    public String getName() {
        return "prune";
    }

    @Override
    public String getDescription() {
        return "Deletes the 5 most recent messages of the specified user";
    }

    @Override
    public void run(final RabrgBot bot, final MessageReceivedEvent event, final String args) {
        final User user = event.getGuild().getUsers().stream().filter(
                vChan -> vChan.getUsername().equalsIgnoreCase(args)).findFirst().orElse(null);
        if (user == null) {
            event.getChannel().sendMessage("Couldn't find user " + args);
        } else {
            event.getGuild().getTextChannels().get(0).getHistory().retrieve().stream()
                    .filter(message -> message.getAuthor().getUsername().equalsIgnoreCase(args)).limit(5)
                    .collect(Collectors.toList()).forEach(Message::deleteMessage);
            event.getChannel().sendMessage("Removed " + user.getUsername() + "'s last 5 messages");
        }
    }
}