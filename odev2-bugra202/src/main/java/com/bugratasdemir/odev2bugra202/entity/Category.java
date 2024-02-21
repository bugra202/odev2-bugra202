package com.bugratasdemir.odev2bugra202.entity;

import com.bugratasdemir.odev2bugra202.general.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "CATEGORY")
public class Category extends BaseEntity {

    @SequenceGenerator(name = "sequenceGenerator",sequenceName = "S_ORDER",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequenceGenerator")
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME",length = 200,nullable = false)
    private String name;
}
