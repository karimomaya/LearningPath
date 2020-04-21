package com.learning.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by karim on 4/21/20.
 */
@Entity
@Data
@Table(name = "ErrorLog")
public class ErrorLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    boolean logSource;
    int logType;
    String message;
    Date createdDate;


}
