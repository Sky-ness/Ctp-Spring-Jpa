package fr.but3.ctp;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface QuestionRepository extends CrudRepository<Question,Integer> {
    @Query("SELECT q FROM Question q WHERE q.active = true")
    Optional<Question> findActive();
}
