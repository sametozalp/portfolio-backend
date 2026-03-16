package com.ozalp.portfolio.entities;

import jakarta.persistence.Entity;
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

    public ProfileImage(String url) {
        super(url);
    }

}
