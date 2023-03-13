package xyz.melnychuk.telegram.bot;
import lombok.Builder;
import lombok.Getter;
import org.telegram.telegrambots.meta.api.objects.Update;

@Getter
@Builder
public class UserRequest {

    private final Long chatId;
    private final Long userId;
    private final Update update;
    private final TGBot bot;
}
