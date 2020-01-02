package ir.mctab.java32.hibernate.projects.multiconfig.entities.db1;

import ir.mctab.java32.hibernate.projects.multiconfig.config.hibernate.PersistenceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)

@Entity
public class BookOne extends PersistenceEntity<Long> {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String isbn;
}
