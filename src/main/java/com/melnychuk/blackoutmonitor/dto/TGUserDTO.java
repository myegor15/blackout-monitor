package com.melnychuk.blackoutmonitor.dto;

import com.melnychuk.blackoutmonitor.model.TGUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TGUserDTO extends TGUser {

    public TGUserDTO(Long id, Long refId, Instant createDate) {
        super(id, refId, createDate);
    }
}
