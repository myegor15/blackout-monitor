package xyz.melnychuk.blackoutmonitor.dto;

import xyz.melnychuk.blackoutmonitor.model.TGChat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TGChatDTO extends TGChat {

    public TGChatDTO(Long id, Long refId, String refName, Long tgUserId, Instant createDate) {
        super(id, refId, refName, tgUserId, createDate);
    }
}
