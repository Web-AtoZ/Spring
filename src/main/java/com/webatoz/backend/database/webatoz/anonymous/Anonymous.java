package com.webatoz.backend.database.webatoz.anonymous;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Anonymous {

    @Id @GeneratedValue
    private Long anonymousId;

    private String name;

    private String secret;

    @CreationTimestamp
    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private LocalDateTime deletedDate;
}