package ir.mctab.java32.hibernate.projects.multiconfig.entities.db1.embeddables;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Getter
@Setter
@ToString
@Embeddable
public class ContactInfo {

    @Column(nullable = false)
    private String mobile;

    @Column(nullable = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;
}
