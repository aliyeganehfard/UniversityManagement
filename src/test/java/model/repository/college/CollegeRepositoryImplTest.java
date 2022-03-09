package model.repository.college;

import model.entity.College;
import org.assertj.core.api.Assertions;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollegeRepositoryImplTest {
    private CollegeRepositoryImpl collegeRepository;

    @BeforeEach
    public void beforeEach() {
        collegeRepository = new CollegeRepositoryImpl();
    }

    @Test
    void save() {
//        arrange
        var college = new College(null, "azad", "lar");
//        act
        collegeRepository.save(college);
        var load = collegeRepository.findById(College.class, college.getId());
//        assert
        Assertions.assertThat(load).isNotNull();
    }

    @Test
    void update() {
//        arrange
        var college = new College(null, "azad", "lar");
//        act
        collegeRepository.save(college);
        collegeRepository.update(new College(college.getId(), "dolati","tehran"));
        var load = collegeRepository.findById(College.class,college.getId());
//        assert
        assertAll(
                ()-> Assertions.assertThat("dolati").isEqualTo(load.getName()),
                ()-> Assertions.assertThat("tehran").isEqualTo(load.getCity())
        );
    }

    @Test
    void delete() {
//        arrange
        var college = new College(null, "azad", "lar");
//        act
        collegeRepository.save(college);
        collegeRepository.delete(college);
        var load = collegeRepository.findById(College.class,college.getId());
//        assert
        Assertions.assertThat(load).isNull();
    }

    @Test
    void findById() {
//        arrange
        var college = new College(null, "azad", "lar");
//        act
        collegeRepository.save(college);
        var load = collegeRepository.findById(College.class,college.getId());
//        assert
        Assertions.assertThat(load).isNotNull();
    }

    @Test
    void findAll() {
//        arrange
        var college = new College(null, "azad", "lar");
//        act
        var size = collegeRepository.findAll(College.class);
        collegeRepository.save(college);
        size.add(college);
//        assert
        Assertions.assertThat(size).hasSize(collegeRepository.findAll(College.class).size());
    }
}