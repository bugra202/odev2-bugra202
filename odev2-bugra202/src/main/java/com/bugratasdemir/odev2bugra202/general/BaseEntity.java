package com.bugratasdemir.odev2bugra202.general;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements BaseModel{

    @Embedded
    private BaseAdditionalFields baseAdditionalFields;
}