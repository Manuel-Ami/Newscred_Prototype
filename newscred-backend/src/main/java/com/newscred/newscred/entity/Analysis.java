    package com.newscred.newscred.entity;

    import jakarta.persistence.*;
    import lombok.Data;

    @Entity
    @Data
    @Table(name = "analysis")
    public class Analysis {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(columnDefinition = "TEXT")
        private String articleText;

        private Integer credibilityScore;

        private String credibilityLabel;

        private String userEmail;
    }