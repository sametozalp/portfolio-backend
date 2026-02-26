package com.ozalp.portfolio.entities;

import jakarta.persistence.*;
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
@Inheritance(strategy = InheritanceType.JOINED)
public class ProfileImage extends Image {

    @MapsId
    @Column
    private int imageId;

    @Column
    private Boolean isProfileImage;

}
