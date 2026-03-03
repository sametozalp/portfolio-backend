package com.ozalp.portfolio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "abouts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class About extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private String title;

    @Column
    private String profileImageUrl;

    @Column
    private String skills;

}
