package xyz.melnychuk.telegram.bot.handler.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import xyz.melnychuk.telegram.bot.UserRequest;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class TGBotCommandDispatcher {

    private final List<TGBotCommand> commands;

    public TGBotCommandDispatcher(List<TGBotCommand> commands) {
        this.commands = Optional
                .ofNullable(commands)
                .stream()
                .flatMap(Collection::stream)
                .sorted(Comparator
                        .comparing(TGBotCommand::isGlobal)
                        .reversed())
                .collect(Collectors.toList());
    }

    public BotApiMethod<?> dispatch(UserRequest userRequest) {
        try {
            for (TGBotCommand userRequestHandler : this.commands) {
                if (userRequestHandler.isApplicable(userRequest)) {
                    return userRequestHandler.handle(userRequest);
                }
            }

            //TODO: unknown command handler
            return SendMessage.builder()
                    .chatId(userRequest.getChatId())
                    .text("I dont understand!!!")
                    .build();
//        } catch (TGBotException e) {

        } catch (Exception e) {
            //TODO: exception handler
            throw new RuntimeException(e);
        }
    }
}
