package com.malibentoeventservice.malibentoeventservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String url;
    @ManyToOne
    private AssetFormat assetFormat;
    @ManyToOne
    private AssetType assetType;
    @ManyToOne
    private AssetSize assetSize;
    private LocalDateTime created;
    private LocalDateTime updated;
    @ManyToOne
    private Event event;
    private boolean active = true;
    private boolean deleted = true;
}
