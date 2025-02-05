package backend.apiestacionamento.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "vehicle")
@EntityListeners(AuditingEntityListener.class)
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String Mark;

    @Column(nullable = false)
    private String Model;

    @Column(nullable = false)
    private String Color;

    @Column(nullable = false)
    private String Plate;

    @Column(nullable = false)
    private String Type;

    @ManyToOne
    @JoinColumn(name = "establishment_id", referencedColumnName = "id", nullable = false)
    private Establishment establishment;

    @CreatedDate
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;


}
