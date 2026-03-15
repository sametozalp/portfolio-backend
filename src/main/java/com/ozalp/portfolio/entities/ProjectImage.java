package com.ozalp.portfolio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "project_images")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectImage extends Image {

    @MapsId
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Column
    private Boolean isCoverImage = false;

    @Column
    private int orderNumber;

    public ProjectImage(Project project, String url) {
        super(url);
        this.project = project;
    }
}
