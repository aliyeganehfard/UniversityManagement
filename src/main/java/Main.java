import controller.exception.*;
import controller.exception.exceptionHandler.ExceptionHandlerImpl;
import controller.service.Proffessor.ProfessorServiceImpl;
import controller.service.Student.StudentServiceImpl;
import controller.service.college.CollegeServiceImpl;
import controller.service.course.CourseServiceImpl;
import controller.service.score.ScoreServiceImpl;
import controller.service.trainingEmployee.TrainingEmployeeServiceImpl;
import model.entity.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        var collegeService = new CollegeServiceImpl();
        var professorService = new ProfessorServiceImpl();
        var studentService = new StudentServiceImpl();
        var trainingEmployeeService = new TrainingEmployeeServiceImpl();
        var courseService = new CourseServiceImpl();
        var scoreService = new ScoreServiceImpl();
        var exceptionHandler = new ExceptionHandlerImpl();
        Student student = null;
        Professor professor = null;
        TrainingEmployee trainingEmployee = null;
        College college = null;
        Course course = null;
        Score score = null;

        boolean flag = false;
        boolean state = true;
        int permission = -1;
        String tempTerm = "";
        String id = "";
        String commendLine;
        String[] commend;
        while (state) {
            printLoginForm();
            commendLine = scn.nextLine().trim();
            commend = commendLine.split(" ");
            switch (commend[0]) {
                case "login":
                    trainingEmployee = trainingEmployeeService.login(TrainingEmployee.class, commend[1], commend[2]);
                    student = studentService.login(Student.class, commend[1], commend[2]);
                    professor = professorService.login(Professor.class, commend[1], commend[2]);
                    if (trainingEmployee != null) {
                        permission = 1;
                        flag = true;
                        printTrainingEmployeeCommend();
                    } else if (student != null) {
                        permission = 2;
                        flag = true;
                        printStudentCommend();
                    } else if (professor != null) {
                        permission = 3;
                        flag = true;
                        printProfessorCommend();
                    } else {
                        System.out.println("wrong userName or password!");
                    }
                    break;
                case "registerCollege":
                    try {
                        collegeService.save(
                                new College(
                                        null,
                                        commend[1],
                                        commend[1]
                                )
                        );
                    } catch (Exception e) {
                        System.out.println("wrong input");
                    }
                    break;
                case "addTrainingEmployee":
                    try {
                        exceptionHandler.isId(Integer.valueOf(commend[4]));
                        college = collegeService.findById(College.class, Integer.valueOf(commend[4]));
                        if (college == null)
                            throw new CollegeNotFound();
                        trainingEmployeeService.save(
                                new TrainingEmployee(
                                        null,
                                        commend[1],
                                        commend[2],
                                        commend[3],
                                        college
                                )
                        );
                    } catch (IdException idException) {
                        System.out.println("incorrect id");
                    } catch (CollegeNotFound collegeNotFound) {
                        System.out.println("college not found");
                    } catch (Exception e) {
                        System.out.println("wrong input");
                    }
                    break;
                case "showColleges":
                    try {
                        collegeService.findAll(College.class).forEach(System.out::println);
                    } catch (Exception e) {
                    }

                    break;
                default:
                    System.out.println("wrong input");
                    break;
            }

            while (flag) {
                switch (permission) {
                    case 1:
                        System.out.print("commend : ");
                        commendLine = scn.nextLine().trim();
                        commend = commendLine.split(" ");
                        switch (commend[0]) {
                            case "showProfile":
                                System.out.println(trainingEmployeeService.findById(TrainingEmployee.class, trainingEmployee.getId()));
                                break;
                            case "registerStudent":
                                try {
                                    exceptionHandler.isId(Integer.valueOf(commend[5]));
                                    college = collegeService.findById(College.class, Integer.valueOf(commend[5]));
                                    if (college == null)
                                        throw new CollegeNotFound();
                                    studentService.save(
                                            new Student(
                                                    null,
                                                    commend[1],
                                                    commend[2],
                                                    commend[3],
                                                    commend[4],
                                                    college
                                            )
                                    );
                                } catch (IdException idException) {
                                    System.out.println("incorrect id");
                                } catch (CollegeNotFound collegeNotFound) {
                                    System.out.println("college not found");
                                } catch (Exception e) {
                                    System.out.println("wrong input");
                                }
                                break;
                            case "deleteStudent":
                                try {
                                    exceptionHandler.isId(Integer.valueOf(commend[1]));
                                    student = studentService.findById(Student.class, Integer.valueOf(commend[1]));
                                    if (student == null)
                                        throw new StudentNotFound();
                                    studentService.delete(student);
                                } catch (IdException idException) {
                                    System.out.println("incorrect id");
                                } catch (StudentNotFound studentNotFound) {
                                    System.out.println("student not found");
                                } catch (Exception e) {
                                    System.out.println("wrong input");
                                }
                                break;
                            case "editStudent":
                                try {
                                    exceptionHandler.isId(Integer.valueOf(commend[1]));
                                    student = studentService.findById(Student.class, Integer.valueOf(commend[1]));
                                    if (student == null)
                                        throw new StudentNotFound();
                                    student.setUserName(commend[2]);
                                    student.setPassword(commend[3]);
                                    studentService.update(student);
                                } catch (IdException idException) {
                                    System.out.println("incorrect id");
                                } catch (StudentNotFound studentNotFound) {
                                    System.out.println("student not found");
                                } catch (Exception e) {
                                    System.out.println("wrong input");
                                }
                                break;
                            case "registerProfessor":
                                try {
                                    exceptionHandler.isId(Integer.valueOf(commend[6]));
                                    college = collegeService.findById(College.class, Integer.valueOf(commend[6]));
                                    if (college == null)
                                        throw new CollegeNotFound();
                                    professorService.save(
                                            new Professor(
                                                    null,
                                                    commend[1],
                                                    commend[2],
                                                    commend[3],
                                                    commend[4],
                                                    commend[5],
                                                    college
                                            )
                                    );
                                } catch (IdException idException) {
                                    System.out.println("incorrect id");
                                } catch (CollegeNotFound collegeNotFound) {
                                    System.out.println("college not found");
                                } catch (Exception e) {
                                    System.out.println("wrong input");
                                }
                                break;
                            case "deleteProfessor":
                                try {
                                    exceptionHandler.isId(Integer.valueOf(commend[1]));
                                    professor = professorService.findById(Professor.class, Integer.valueOf(commend[1]));
                                    if (professor == null)
                                        throw new ProfessorNotFound();
                                    professorService.delete(professor);
                                } catch (IdException idException) {
                                    System.out.println("incorrect id");
                                } catch (ProfessorNotFound professorNotFound) {
                                    System.out.println("professor not found");
                                } catch (Exception e) {
                                    System.out.println("wrong input");
                                }
                                break;
                            case "editProfessor":
                                try {
                                    exceptionHandler.isId(Integer.valueOf(commend[1]));
                                    professor = professorService.findById(Professor.class, Integer.valueOf(commend[1]));
                                    if (professor == null)
                                        throw new ProfessorNotFound();
                                    professor.setUserName(commend[2]);
                                    professor.setPassword(commend[3]);
                                } catch (IdException idException) {
                                    System.out.println("incorrect id");
                                } catch (ProfessorNotFound professorNotFound) {
                                    System.out.println("professor not found");
                                } catch (Exception e) {
                                    System.out.println("wrong input");
                                }
                                break;
                            case "registerTrainingEmployee":
                                try {
                                    exceptionHandler.isId(Integer.valueOf(commend[4]));
                                    college = collegeService.findById(College.class, Integer.valueOf(commend[4]));
                                    if (college == null)
                                        throw new CollegeNotFound();
                                    trainingEmployeeService.save(
                                            new TrainingEmployee(
                                                    null,
                                                    commend[1],
                                                    commend[2],
                                                    commend[3],
                                                    college
                                            )
                                    );
                                } catch (IdException idException) {
                                    System.out.println("incorrect id");
                                } catch (CollegeNotFound collegeNotFound) {
                                    System.out.println("college not found");
                                } catch (Exception e) {
                                    System.out.println("wrong input");
                                }
                                break;
                            case "deleteTrainingEmployee":
                                try {
                                    exceptionHandler.isId(Integer.valueOf(commend[1]));
                                    trainingEmployee = trainingEmployeeService.findById(TrainingEmployee.class, Integer.valueOf(commend[1]));
                                    if (trainingEmployee == null)
                                        throw new TrainingEmployeeNotFound();
                                    trainingEmployeeService.delete(trainingEmployee);
                                } catch (TrainingEmployeeNotFound trainingEmployeeNotFound) {
                                    System.out.println("training employee not found");
                                } catch (IdException idException) {
                                    System.out.println("incorrect id");
                                } catch (Exception e) {
                                    System.out.println("wrong input");
                                }
                                break;
                            case "editTrainingEmployee":
                                try {
                                    exceptionHandler.isId(Integer.valueOf(commend[1]));
                                    trainingEmployee = trainingEmployeeService.findById(TrainingEmployee.class, Integer.valueOf(commend[1]));
                                    if (trainingEmployee == null)
                                        throw new TrainingEmployeeNotFound();
                                    trainingEmployee.setUserName(commend[2]);
                                    trainingEmployee.setPassword(commend[3]);
                                    trainingEmployeeService.update(trainingEmployee);
                                } catch (TrainingEmployeeNotFound trainingEmployeeNotFound) {
                                    System.out.println("training employee not found");
                                } catch (IdException idException) {
                                    System.out.println("incorrect id");
                                } catch (Exception e) {
                                    System.out.println("wrong input");
                                }
                                break;
                            case "addCourse":
                                try {
                                    exceptionHandler.isId(Integer.valueOf(commend[3]));
                                    exceptionHandler.isUnit(Integer.valueOf(commend[2]));
                                    college = collegeService.findById(College.class, Integer.valueOf(commend[3]));
                                    if (college == null)
                                        throw new CollegeNotFound();
                                    courseService.save(
                                            new Course(
                                                    null,
                                                    commend[1],
                                                    Integer.valueOf(commend[2]),
                                                    college
                                            )
                                    );
                                } catch (CollegeNotFound collegeNotFound) {
                                    System.out.println("college not found");
                                } catch (UnitException unitException) {
                                    System.out.println("incorrect unit");
                                } catch (IdException idException) {
                                    System.out.println("incorrect id");
                                } catch (Exception e) {
                                    System.out.println("wrong input");
                                }
                                break;
                            case "deleteCourse":
                                System.out.println("deleteCourse courseId");
                                try {
                                    exceptionHandler.isId(Integer.valueOf(commend[1]));
                                    course = courseService.findById(Course.class, Integer.valueOf(commend[1]));
                                    if (course == null)
                                        throw new CourseNotFound();
                                    courseService.delete(course);
                                } catch (CourseNotFound courseNotFound) {
                                    System.out.println("course not found");
                                } catch (IdException idException) {
                                    System.out.println("incorrect id");
                                } catch (Exception e) {
                                    System.out.println("wrong input");
                                }
                                break;
                            case "editCourse":
                                System.out.println("editCourse courseId newName newUnit");
                                try {
                                    exceptionHandler.isId(Integer.valueOf(commend[1]));
                                    exceptionHandler.isUnit(Integer.valueOf(commend[2]));
                                    course = courseService.findById(Course.class, Integer.valueOf(commend[1]));
                                    if (course == null)
                                        throw new CourseNotFound();
                                    course.setName(commend[2]);
                                    course.setUnit(Integer.valueOf(commend[3]));
                                } catch (UnitException unitException) {
                                    System.out.println("incorrect unit");
                                } catch (IdException idException) {
                                    System.out.println("incorrect id");
                                } catch (CourseNotFound courseNotFound) {
                                    System.out.println("course not found");
                                } catch (Exception e) {
                                    System.out.println("wrong input");
                                }
                                break;
                            case "salary":
                                System.out.println("");
                                break;
                            case "showStudentList":
                                try {
                                    studentService.findAll(Student.class).forEach(System.out::println);
                                } catch (Exception e) {
                                }

                                break;
                            case "showProfessorList":
                                try {
                                    professorService.findAll(Professor.class).forEach(System.out::println);
                                } catch (Exception e) {
                                }

                                break;
                            case "showTrainingEmployeeList":
                                try {
                                    trainingEmployeeService.findAll(TrainingEmployee.class).forEach(System.out::println);
                                } catch (Exception e) {
                                }

                                break;
                            case "showCourseList":
                                try {
                                    courseService.findAll(Course.class).forEach(System.out::println);
                                } catch (Exception e) {
                                }

                                break;
                            case "showColleges":
                                try {
                                    collegeService.findAll(College.class).forEach(System.out::println);
                                } catch (Exception e) {
                                }

                                break;
                            case "help":
                                printTrainingEmployeeCommend();
                                break;
                            case "logout":
                                flag = false;
                                break;
                            case "exit":
                                state = false;
                                flag = false;
                                break;
                            default:
                                System.out.println("wrong input!");
                                break;
                        }
                        break;
                    case 2:
                        System.out.print("commend : ");
                        commendLine = scn.nextLine().trim();
                        commend = commendLine.split(" ");
                        switch (commend[0]) {
                            case "showProfile":
                                System.out.println(studentService.findById(Student.class, student.getId()));
                                break;
                            case "showCoursesList":
                                try {
                                    courseService.findAll(Course.class).forEach(System.out::println);
                                } catch (Exception e) {
                                }

                                break;
                            case "showProfessorList":
                                try {
                                    professorService.findAll(Professor.class).forEach(System.out::println);
                                } catch (Exception e) {
                                }
                                break;
                            case "selectUnit":
                                try {
                                    studentService.studentCourse(student).forEach(System.out::println);
                                }catch (Exception e){}

                                try {

                                    exceptionHandler.isId(Integer.valueOf(commend[1]));
                                    exceptionHandler.isId(Integer.valueOf(commend[2]));
                                    exceptionHandler.isTerm(Integer.valueOf(commend[3]));
                                    professor = professorService.findById(Professor.class, Integer.valueOf(commend[1]));
                                    course = courseService.findById(Course.class, Integer.valueOf(commend[2]));
                                    student = studentService.findById(Student.class, student.getId());
                                    System.out.println(student);
                                    System.out.println(course);
                                    System.out.println(professor);
                                    scoreService.save(
                                            new Score(
                                                    null,
                                                    student,
                                                    professor,
                                                    course,
                                                    Integer.valueOf(commend[3]),
                                                    null
                                            )
                                    );
                                } catch (TermException termException) {
                                    System.out.println("incorrect term");
                                } catch (IdException idException) {
                                    System.out.println("incorrect id");
                                } catch (ProfessorNotFound professorNotFound) {
                                    System.out.println("professor not found");
                                } catch (CourseNotFound courseNotFound) {
                                    System.out.println("course not found");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    System.out.println("wrong input");
                                }
                                break;
                            case "showSelectedCourses":
                                try {
                                    studentService.getResult(student).forEach(System.out::println);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                            case "help":
                                printStudentCommend();
                                break;
                            case "logout":
                                flag = false;
                                break;
                            case "exit":
                                state = false;
                                flag = false;
                                break;
                            default:
                                System.out.println("wrong input!");
                                break;
                        }
                        break;
                    case 3:
                        System.out.print("commend : ");
                        commendLine = scn.nextLine().trim();
                        commend = commendLine.split(" ");
                        switch (commend[0]) {
                            case "showProfile":
                                break;
                            case "showCourses":
                                courseService.findAll(Course.class).forEach(System.out::println);
                                break;
                            case "showStudent":
                                professorService.getStudent(professor).forEach(System.out::println);
                                break;
                            case "showWaitingStudentForeScore":
                                professorService.setScoreForStudent(professor).forEach(System.out::println);
                                break;
                            case "setScore":
                                try {
                                    exceptionHandler.isId(Integer.valueOf(commend[1]));
//                                    exceptionHandler.isScore(Double.valueOf(commend[2]));
                                    score = scoreService.findById(Score.class, Integer.valueOf(commend[1]));
                                    if (score == null)
                                        throw new ScoreNotFound();
                                    score.setScore(Double.valueOf(commend[2]));
                                    scoreService.update(score);
                                } catch (ScoreNotFound scoreException) {
                                    System.out.println("score not fouond");
                                } catch (IdException idException) {
                                    System.out.println("incorrect id");
                                } catch (ScoreException scoreException) {
                                    System.out.println("incorrect score");
                                } catch (Exception e) {
                                    System.out.println("wrong input");
                                }
                                break;
                            case "showSalary":
                                break;
                            case "help":
                                printProfessorCommend();
                                break;
                            case "logout":
                                flag = false;
                                break;
                            case "exit":
                                state = false;
                                flag = false;
                                break;
                            default:
                                System.out.println("wrong input!");
                                break;
                        }
                        break;
                }

            }
        }
    }

    public static void printLoginForm() {
        System.out.println("login userName password ");
        System.out.println("registerCollege name city");
        System.out.println("addTrainingEmployee name username password collegeId");
        System.out.println("showColleges");
        System.out.print("commend : ");
    }

    public static void printTrainingEmployeeCommend() {
        System.out.println("showProfile");
        System.out.println("registerStudent name username password city collegeId");
//        System.out.println("{ department => COMPUTER , ACCOUNTING , ELECTRONIC , ELECTRICAL }");
        System.out.println("deleteStudent studentId");
        System.out.println("editStudent studentId newUsername newPassword");
        System.out.println("registerProfessor name username password degree office collegeId");
//        System.out.println("{ status => SCIENCE_COMMITTEE , TUITION_FEE}");
        System.out.println("deleteProfessor professorId");
        System.out.println("editProfessor professorId newUsername newPassword");
        System.out.println("registerTrainingEmployee name username password collegeId");
        System.out.println("deleteTrainingEmployee TrainingEmployeeId");
        System.out.println("editTrainingEmployee TrainingEmployeeId newUsername newPassword");
        System.out.println("addCourse name unit collegeId");
//        System.out.println("{ department => COMPUTER , ACCOUNTING , ELECTRONIC , ELECTRICAL }");
        System.out.println("deleteCourse courseId");
        System.out.println("editCourse courseId newName newUnit");
        System.out.println("salary");
        System.out.println("showColleges");
        System.out.println("showStudentList");
        System.out.println("showProfessorList");
        System.out.println("showTrainingEmployeeList");
        System.out.println("showCourseList");
        System.out.println("help");
        System.out.println("logout");
        System.out.println("exit");

    }

    public static void printStudentCommend() {
        System.out.println("showProfile");
        System.out.println("showCoursesList");
        System.out.println("selectUnit professorId courseId term");
        System.out.println("showProfessorList");
        System.out.println("showSelectedCourses");
        System.out.println("help");
        System.out.println("logout");
        System.out.println("exit");
    }

    public static void printProfessorCommend() {
        System.out.println("showProfile");
        System.out.println("showCourses");
        System.out.println("showStudent");
        System.out.println("setScore scoreId score");
        System.out.println("showSalary term");
        System.out.println("showWaitingStudentForeScore");
        System.out.println("help");
        System.out.println("logout");
        System.out.println("exit");
    }

}

