package fr.but3.ctp;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

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

    @ColumnDefault("0")
    @Column(name="nbChoix")
    int nbChoix;

    @ManyToOne
    @JoinColumn(name = "qno")
    Question question;

    public void incrementChoix(){
        nbChoix++;
    }
}
