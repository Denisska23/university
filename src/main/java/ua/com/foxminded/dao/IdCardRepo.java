package ua.com.foxminded.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.foxminded.model.IdCard;

public interface IdCardRepo extends JpaRepository<IdCard, Integer> {
}
