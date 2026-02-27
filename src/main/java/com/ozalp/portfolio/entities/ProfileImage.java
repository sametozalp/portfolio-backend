package com.ozalp.portfolio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "profile_images")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfileImage extends Image {

    @MapsId
    private int id;

    @Column
    private Boolean isProfileImage;

}
