package com.learning.model;

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
@Table(name = "FootPrint")
public class FootPrint implements StatusAttribute, ModificationSystemAttribute, CreationSystemAttribute{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    long footPrintCat; // 1 save; 2 update; 3 delete
    String footPrintValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orgId")
    Organization org;

}
