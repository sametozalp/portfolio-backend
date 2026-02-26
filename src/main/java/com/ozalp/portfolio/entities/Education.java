package com.ozalp.portfolio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "educations")
@NoArgsConstructor
@AllArgsConstructor
public class Education extends Resume {

    @Column
    private String major;

    @Column
    private String school;

}
