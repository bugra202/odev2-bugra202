package com.bugratasdemir.odev2bugra202.general;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class BaseAdditionalFields {

    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long creatorId;
    private Long updaterId;
}