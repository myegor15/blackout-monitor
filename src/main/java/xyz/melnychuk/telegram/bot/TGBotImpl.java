package xyz.melnychuk.telegram.bot;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.starter.SpringWebhookBot;
import xyz.melnychuk.telegram.bot.exception.TGBotException;
import xyz.melnychuk.telegram.bot.handler.command.TGBotCommandDispatcher;

@Slf4j
@Builder
public class TGBotImpl extends SpringWebhookBot implements TGBot {

    @Getter private final String botUsername;
    @Getter private final String botToken;
    @Getter private final String botPath;
    private final TGBotCommandDispatcher commandDispatcher;

    private TGBotImpl(String botUsername, String botToken, String botPath, TGBotCommandDispatcher commandDispatcher, SetWebhook setWebhook) {
        super(setWebhook);
        this.botUsername = botUsername;
        this.botToken = botToken;
        this.botPath = botPath;
        this.commandDispatcher = commandDispatcher;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        UserRequest request = UserRequest.builder()
                .chatId(update.getMessage().getChatId())
                .userId(update.getMessage().getFrom().getId())
                .update(update)
                .bot(this)
                .build();
        return commandDispatcher.dispatch(request);
    }

    @Override
    public void sendMessage(Long chatId, String text) {
        sendMessage(chatId, text, null);
    }

    @Override
    public void sendMessage(Long chatId, String text, ReplyKeyboard replyKeyboard) {
        try {
            SendMessage sendMessage = SendMessage.builder()
                    .text(text)
                    .chatId(chatId.toString())
                    .parseMode(ParseMode.HTML) //Other possible parse modes: MARKDOWNV2, MARKDOWN, which allows to make text bold, and all other things
                    .replyMarkup(replyKeyboard)
                    .build();
            this.execute(sendMessage);
        } catch (Exception e) {
            throw new TGBotException(e);
        }
    }

    // CUSTOMISE BUILDER FOR LOMBOK
    public static class TGBotImplBuilder {
        private SetWebhook setWebhook;

        public TGBotImplBuilder setWebhook(final SetWebhook setWebhook) {
            this.setWebhook = setWebhook;
            return this;
        }

        public TGBotImpl build() {
            return new TGBotImpl(this.botUsername, this.botToken, this.botPath, this.commandDispatcher, this.setWebhook);
        }
    }
}
