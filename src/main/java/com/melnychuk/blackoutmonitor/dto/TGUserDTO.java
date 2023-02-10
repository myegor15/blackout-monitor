package com.melnychuk.blackoutmonitor.dto;

import com.melnychuk.blackoutmonitor.model.TGUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TGUserDTO extends TGUser {
}
