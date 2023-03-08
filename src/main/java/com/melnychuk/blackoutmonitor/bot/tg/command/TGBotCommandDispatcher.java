package com.melnychuk.blackoutmonitor.bot.tg.command;

import com.melnychuk.blackoutmonitor.bot.tg.UserRequest;
import org.springframework.util.Assert;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TGBotCommandDispatcher {

    private List<TGBotCommand> commandList;

    public TGBotCommandDispatcher(List<TGBotCommand> commands) {
        Assert.notEmpty(commands, "commands cannot be null or empty");
        this.commandList = commands
                .stream()
                .sorted(Comparator
                        .comparing(TGBotCommand::isGlobal)
                        .reversed())
                .collect(Collectors.toList());
    }

    public boolean dispatch(UserRequest userRequest) {
        for (TGBotCommand userRequestHandler : this.commandList) {
            if (userRequestHandler.isApplicable(userRequest)) {
                userRequestHandler.handle(userRequest);
                return true;
            }
        }
        return false;
    }
}
