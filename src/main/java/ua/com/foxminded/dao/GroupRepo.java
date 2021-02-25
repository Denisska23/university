package ua.com.foxminded.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.foxminded.model.Group;

public interface GroupRepo extends JpaRepository<Group, Integer> {
}
