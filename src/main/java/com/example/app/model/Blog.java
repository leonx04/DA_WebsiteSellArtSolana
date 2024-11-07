package com.example.app.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogId;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, columnDefinition = "NVARCHAR(MAX)")
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "promoted_artwork_id", nullable = false)
    private Artwork promotedArtwork;

    @Column(name = "featured_image_url", length = 255)
    private String featuredImageUrl;

    @Column(length = 255)
    private String tags;

    @Column(nullable = false, length = 50)
    private String status = "draft";

    @Column(name = "views_count", nullable = false)
    private int viewsCount = 0;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt = new Date();

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

}
