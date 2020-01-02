package ir.mctab.java32.hibernate.projects.multiconfig.entities.db1;

import ir.mctab.java32.hibernate.projects.multiconfig.config.hibernate.PersistenceEntity;
import ir.mctab.java32.hibernate.projects.multiconfig.entities.db1.embeddables.CustomerFileStatus;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(exclude = "interfaces")

@Entity
public class CustomerFile extends PersistenceEntity<Long> {

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    private CustomerFileStatus status;

    @ManyToOne
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "file", orphanRemoval = true)
    private Set<CustomerInterface> interfaces = new HashSet<>();
}
