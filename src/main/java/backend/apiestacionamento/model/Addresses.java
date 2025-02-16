package backend.apiestacionamento.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "addresses")
@EntityListeners(AuditingEntityListener.class)
public class Addresses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int number;

    @Column(nullable = false)
    private String complement;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String postal_code;

    @Column(nullable = false)
    private String country;

    @CreatedDate
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;

    @OneToOne
    @JoinColumn(name = "establishment_id", referencedColumnName = "id", nullable = false)
    private Establishment establishment;

}
