package com.learning.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.system.Attribute.StatusAttribute;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by karim on 4/18/20.
 */
@Entity
@Data
@Table(name = "Account")
public class Account implements StatusAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private String username;
    private String accountName;
    private String email;
    private String password;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orgId")
    private Organization org;
    private boolean gender;
}