package com.fabric.checkfinancial.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "MOVEMENTS")
@Data
@EqualsAndHashCode
@ToString
public class Movement {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "movType")
    private String movType;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "insertDateTime")
    LocalDateTime insertDateTime;

    @OneToMany(mappedBy = "movement", cascade = CascadeType.ALL)
    private List<MovHistory> movHistories;
}
