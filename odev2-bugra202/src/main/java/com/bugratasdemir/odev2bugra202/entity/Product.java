package com.bugratasdemir.odev2bugra202.entity;

import com.bugratasdemir.odev2bugra202.enums.ProductStatus;
import com.bugratasdemir.odev2bugra202.general.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT")
public class Product extends BaseEntity {

    @SequenceGenerator(name = "sequenceGenerator",sequenceName = "S_ORDER",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequenceGenerator")
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME",length = 200,nullable = false)
    private String name;

    @Column(name = "PRICE",scale = 2,nullable = false)
    private Double price;

    @Column(name = "EXPIRATION_DATE",nullable = false)
    private LocalDateTime expirationDate;

    @Column(name = "DESCRIPTION",length = 200)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS",length = 30,nullable = false)
    private ProductStatus status;

    @JoinColumn(name = "CATEGORY_ID",referencedColumnName = "ID",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;


}
