package com.malibentoeventservice.malibentoeventservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AssetFormat getAssetFormat() {
        return assetFormat;
    }

    public void setAssetFormat(AssetFormat assetFormat) {
        this.assetFormat = assetFormat;
    }

    public AssetType getAssetType() {
        return assetType;
    }

    public void setAssetType(AssetType assetType) {
        this.assetType = assetType;
    }

    public AssetSize getAssetSize() {
        return assetSize;
    }

    public void setAssetSize(AssetSize assetSize) {
        this.assetSize = assetSize;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
