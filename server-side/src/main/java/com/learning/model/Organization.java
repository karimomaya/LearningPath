package com.learning.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.learning.system.Attribute.CreationSystemAttribute;
import com.learning.system.Attribute.ModificationSystemAttribute;
import com.learning.system.Attribute.StatusAttribute;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by karim on 4/16/20.
 */
@Entity
@Data
@Table(name = "Organization")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Organization implements CreationSystemAttribute, StatusAttribute, ModificationSystemAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String orgName;

}
