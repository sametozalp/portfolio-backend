package com.ozalp.portfolio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project extends BaseEntity {

    @Column
    private String title;

    @Column
    private String summary;

    @Column
    private String description;

    @Column
    private List<String> features;

    @Column
    private String coverImage;

    @Column
    private List<String> images;

    @Column
    private LocalDate projectDate;

    @Column
    private List<String> techStack;

    @Column
    private String liveDemoUrl;

    @Column
    private String sourceCodeUrl;

    @Column
    private List<Integer> categories;

}
