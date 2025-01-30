package backend.apiestacionamento.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;

@Entity
@Data
@Table(name = "establishment")
@EntityListeners(AuditingEntityListener.class)
public class Establishment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private int vacancies_motorcycles;

    @Column(nullable = false)
    private int vacancies_car;

    @CreatedDate
    private Date created_at;

    @LastModifiedDate
    private Date updated_at;

}
