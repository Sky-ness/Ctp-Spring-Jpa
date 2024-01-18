package fr.but3.ctp;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Choix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cno;
    @Column(name="libchoix")
    String libChoix;
    @Column(name="statut")
    boolean statut;
    @Column(name="nbChoix")
    int nbChoix;
    int qno;

}
