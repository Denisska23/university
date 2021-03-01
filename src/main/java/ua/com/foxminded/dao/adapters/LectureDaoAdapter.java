package ua.com.foxminded.dao.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ua.com.foxminded.dao.LectureDAO;
import ua.com.foxminded.dao.LectureRepo;
import ua.com.foxminded.model.Lecture;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LectureDaoAdapter implements LectureDAO {

    private final LectureRepo repository;

    @Override
    public Lecture add(Lecture lecture) {
        return repository.save(lecture);
    }

    @Override
    public Lecture getById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Lecture> getAll() {
        return repository.findAll();
    }

    @Override
    public Lecture update(Lecture lecture) {
        return repository.save(lecture);
    }

    @Override
    public void remove(Lecture lecture) {
        repository.delete(lecture);
    }
}
