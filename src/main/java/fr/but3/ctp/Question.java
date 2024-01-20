package fr.but3.ctp;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

import static java.lang.Math.round;

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

    @OneToMany(mappedBy = "question")
    List<Choix> choixList;

    public float percentageAnswer(){
        float correct = 0;
        float total =0;
        for(Choix choix : choixList){
            if(choix.statut){
                correct += choix.nbChoix;
            }
            total += choix.nbChoix;
        }
        return (correct /total)*100;
    }
}
