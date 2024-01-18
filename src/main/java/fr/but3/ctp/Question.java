package fr.but3.ctp;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "Question")
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int qno;
    @Column(name="libquest")
    String libelle;
    @Column(name="active")
    @ColumnDefault("false")
    boolean active;
}
