package com.fabrick.checkfinancial.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "MOV_HISTORY")
@Data
@EqualsAndHashCode
@ToString
public class MovHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "historyDateTime")
    LocalDateTime historyDateTime;

    @ManyToOne
    @JoinColumn(name = "mov_id")
    private Movement movement;
}
