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
public class CustomerInterface extends PersistenceEntity<Long> {

    @Column(nullable = false, length = 48)
    private String name;

    @Column(nullable = false, length = 48)
    private String family;

    @Column(nullable = false)
    @Enumerated
    private ContactInfo contactInfo;

    @ManyToOne
    private CustomerFile file;

}
