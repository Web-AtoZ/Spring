package com.test.hello.database.webatoz.anonymous;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Getter
@Setter
@Entity
public class Anonymous {

    @Id @GeneratedValue
    private Long anonymous_id;

    private String name;

    private String secret;

    @CreationTimestamp
    private Date created_date;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_date;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deleted_date;
}