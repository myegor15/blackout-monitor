package com.melnychuk.blackoutmonitor.bot.tg.command;

import com.melnychuk.blackoutmonitor.bot.tg.command.TGBotCommand;
import com.melnychuk.blackoutmonitor.model.TGUser;
import org.springframework.util.Assert;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TGBotCommandDispatcher {

    private List<TGBotCommand> commandList;

    public TGBotCommandDispatcher(List<TGBotCommand> commands) {
        Assert.notEmpty(commands, "Commands cannot be null or empty");
        this.commandList = commands
                .stream()
                .sorted(Comparator
                        .comparing(UserRequestHandler::isGlobal)
                        .reversed())
                .collect(Collectors.toList());
    }

    public boolean dispatch(UserRequest userRequest) {
        for (TGBotCommand userRequestHandler : commandList) {
            if(userRequestHandler.isApplicable(userRequest)){
                userRequestHandler.handle(userRequest);
                return true;
            }
        } new TGUser()
        return false;
    }
}
