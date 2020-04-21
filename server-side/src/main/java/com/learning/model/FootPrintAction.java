package com.learning.model;

import com.learning.system.Attribute.StatusAttribute;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by karim on 4/16/20.
 */

@Entity
@Data
@Table(name = "FootPrintAction")
public class FootPrintAction implements StatusAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "footPrintId")
    FootPrint footPrint;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId")
    Account account;
    Date createdDate;
    String description;

}
