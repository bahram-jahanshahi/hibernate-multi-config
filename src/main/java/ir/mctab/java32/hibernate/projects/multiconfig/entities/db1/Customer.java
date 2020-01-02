package ir.mctab.java32.hibernate.projects.multiconfig.entities.db1;

import ir.mctab.java32.hibernate.projects.multiconfig.config.hibernate.PersistenceEntity;
import ir.mctab.java32.hibernate.projects.multiconfig.entities.db1.embeddables.ContactInfo;
import ir.mctab.java32.hibernate.projects.multiconfig.entities.db1.enums.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)

@Entity
public class Customer extends PersistenceEntity<Long> {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CustomerType customerType;

    @Column(nullable = false)
    private Long crmID;

    @Embedded
    private ContactInfo contactInfo;

    @Transient
    private String temp;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer", orphanRemoval = true)
    private Set<CustomerFile> files = new HashSet<>();
}
