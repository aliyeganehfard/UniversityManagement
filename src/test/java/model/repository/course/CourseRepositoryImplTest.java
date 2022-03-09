package model.repository.course;

import model.entity.College;
import model.entity.Course;
import model.repository.college.CollegeRepositoryImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseRepositoryImplTest {
    private CollegeRepositoryImpl collegeRepository;
    private CourseRepositoryImpl courseRepository;

    @BeforeEach
    public void beforeEach(){
        collegeRepository = new CollegeRepositoryImpl();
        courseRepository = new CourseRepositoryImpl();
    }

    @Test
    void save(){
//        arrange
        var college = new College(null,"azad","tehran");
        var course = new Course(null,"java",2,college);
//        act
         collegeRepository.save(college);
         courseRepository.save(course);
         var load = courseRepository.findById(Course.class, course.getId());
//        assert
        Assertions.assertThat(load).isNotNull();
    }

    @Test
    void update(){
//        arrange
        var college = new College(null,"azad","tehran");
        var course = new Course(null,"java",2,college);
//        act
        collegeRepository.save(college);
        courseRepository.save(course);
        courseRepository.update(new Course(college.getId(),"c",1,college));
        var load = courseRepository.findById(Course.class, course.getId());
//        assert
        assertAll(
                ()-> Assertions.assertThat("c").isEqualTo(load.getName()),
                ()-> Assertions.assertThat(1).isEqualTo(load.getUnit())
        );
    }

    @Test
    void delete(){
//        arrange
        var college = new College(null,"azad","tehran");
        var course = new Course(null,"java",2,college);
//        act
        collegeRepository.save(college);
        courseRepository.save(course);
        courseRepository.delete(course);
        var load = courseRepository.findById(Course.class,course.getId());
//        assert
        Assertions.assertThat(load).isNull();
    }

    @Test
    void findById(){
//        arrange
        var college = new College(null,"azad","tehran");
        var course = new Course(null,"java",2,college);
//        act
        collegeRepository.save(college);
        courseRepository.save(course);
        var load = courseRepository.findById(Course.class,course.getId());
//        assert
        Assertions.assertThat(load).isNotNull();
    }

    @Test
    void findAll(){
//        arrange
        var college = new College(null,"azad","tehran");
        var course = new Course(null,"java",2,college);
//        act
        var size = courseRepository.findAll(Course.class);
        collegeRepository.save(college);
        courseRepository.save(course);
        size.add(course);
//        assert
        Assertions.assertThat(size).hasSize(courseRepository.findAll(Course.class).size());
    }
}