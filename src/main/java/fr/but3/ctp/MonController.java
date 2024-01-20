package fr.but3.ctp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class MonController{

    @Autowired
    ChoixRepository choixRepository;
    @Autowired
    QuestionRepository questionRepository;
    @GetMapping("/activer")
    public String activer(Model model)
    {
        Iterable<Question> questions = questionRepository.findAll();
        model.addAttribute("questions",questions);
        return "activer";
    }
    @PostMapping("/activer")
    @ResponseBody
    public String activerPost(@RequestParam int idQuestion)
    {
        // Désactiver toutes les questions et mettre les choix correspondants a 0
        Iterable<Question> questions = questionRepository.findAll();
        questions.forEach( question -> {
            question.setActive(false);
            question.getChoixList().forEach( choix-> {
                choix.setNbChoix(0);
                choixRepository.save(choix);
            });
            questionRepository.save(question);
        });
        // Activer la question que l'on a choisi
        Optional<Question> question = questionRepository.findById(idQuestion);
        question.ifPresent( question1 -> {
            question1.setActive(true);
            questionRepository.save(question1);
        });

        return "La question "+ idQuestion +" vient d’être activée";
    }

    @GetMapping("/voter")
    public String voter(Model model)
    {
        Optional<Question> question = questionRepository.findActive();
        question.ifPresent( question1 -> model.addAttribute("question",question1.getLibelle()));
        question.ifPresent( question1 -> model.addAttribute("choix",question1.choixList));
        return "voter";
    }
    @PostMapping("/voter")
    @ResponseBody
    public String voterPost(@RequestParam int idChoix)
    {
        // Activer la question que l'on a choisi
        Optional<Choix> choix = choixRepository.findById(idChoix);
        choix.ifPresent( choix1 -> {
            choix1.incrementChoix();
            choixRepository.save(choix1);
        });
        return "Votre choix a bien été pris en compte";
    }

    @GetMapping("/voir")
    public String voir(Model model)
    {
        Optional<Question> question = questionRepository.findActive();
        question.ifPresent( question1 -> model.addAttribute("question",question1));
        question.ifPresent( question1 -> model.addAttribute("choix",question1.choixList));
        return "voir";
    }
}
