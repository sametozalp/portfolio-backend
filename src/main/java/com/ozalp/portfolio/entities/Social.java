package com.ozalp.portfolio.entities;

import com.ozalp.portfolio.business.enums.SocialMedia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "socials")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Social extends BaseEntity {

    @Column
    @Enumerated(EnumType.STRING)
    private SocialMedia type;

    @Column
    private String url;

    @Column
    private int orderNumber = 1;
}
