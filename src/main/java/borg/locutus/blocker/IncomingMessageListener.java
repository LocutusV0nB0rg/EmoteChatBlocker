package borg.locutus.blocker;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.main.LabyMod;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class IncomingMessageListener implements MessageReceiveEvent {
    private final Pattern pattern = Pattern.compile(".*:.*\\+[a-z0-9]{5}:.*");
    private final Pattern replacePattern = Pattern.compile(":.*\\+[a-z0-9]{5}:");

    @Override
    public boolean onReceive(String message, String unformattedMessage) {
        Matcher matcher = pattern.matcher(message);
        if (!matcher.matches()) {
            return false;
        }

        LabyMod.getInstance().displayMessageInChat(message.replaceAll(replacePattern.pattern(), ""));

        return true;
    }
}
