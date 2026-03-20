package com.ozalp.portfolio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Filter;

import java.time.LocalDate;
import java.util.ArrayList;
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

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String features;

    @OrderBy(value = "orderNumber ASC")
    @Filter(name = "deletedFilter", condition = "id IN (SELECT img.id FROM images img WHERE img.deleted_at IS NULL)")
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<ProjectImage> images = new ArrayList<>();

    @Column
    private LocalDate projectDate;

    @Column(columnDefinition = "TEXT")
    private String techStack;

    @Column
    private String liveDemoUrl;

    @Column
    private String sourceCodeUrl;
}
