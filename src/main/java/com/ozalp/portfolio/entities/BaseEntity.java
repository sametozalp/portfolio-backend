package com.ozalp.portfolio.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;

import java.time.Instant;

@MappedSuperclass
@Getter
@FilterDef(
        name = "showableFilter",
        defaultCondition = "showable = true",
        autoEnabled = true
)
@FilterDef(
        name = "deletedFilter",
        defaultCondition = "deleted_at IS NULL",
        autoEnabled = true
)
@Filter(name = "showableFilter")
@Filter(name = "deletedFilter")
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Instant createdAt;

    @Column
    private Instant updatedAt;

    @Column
    private Instant deletedAt;

    @Setter
    private Boolean showable = true;

    @PrePersist
    private void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
    }

    @PreUpdate
    private void onUpdate() {
        updatedAt = Instant.now();
    }

    public void markAsDeleted() {
        this.deletedAt = Instant.now();
    }
}
