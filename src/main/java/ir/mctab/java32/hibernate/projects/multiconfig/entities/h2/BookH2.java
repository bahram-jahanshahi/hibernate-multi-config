package ir.mctab.java32.hibernate.projects.multiconfig.entities.h2;

import ir.mctab.java32.hibernate.projects.multiconfig.config.hibernate.PersistenceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class BookH2 extends PersistenceEntity<Long> {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String isbn;
}
