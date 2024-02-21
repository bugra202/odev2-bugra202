package com.bugratasdemir.odev2bugra202.general;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements BaseModel{

    @Embedded
    private BaseAdditionalFields baseAdditionalFields;
}