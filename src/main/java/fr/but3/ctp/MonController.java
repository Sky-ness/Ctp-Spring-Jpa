package fr.but3.ctp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MonController{
    @Autowired
    ChoixRepository choixRepository;
    @Autowired
    QuestionRepository questionRepository;
    @GetMapping("/activer")
    public String activer(Model model)
    {
//        Iterable<Question> questions = questionRepository.findAll();
//        model.addAttribute("questions",questions);
        return "activer";
    }

    @GetMapping("/voter")
    public String voter(@RequestParam("id") int idQuestion,Model model)
    {
        return "voter";
    }
    @GetMapping("/voir")
    public String voir(@RequestParam("id") Integer idQuestion, Model model)
    {
//        Iterable<Choix> choix = choixRepository.findAllById(idQuestion);
//        model.addAttribute("choix",choix);
        return "voir";
    }
    @PostMapping("/voir")
    public void incr(@RequestParam("id") Integer idQuestion, Model model)
    {
//        choixRepository.save()
    }

}
