import model.util.SingleTonConnection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
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
            if (commend[0].equals("login")) {
//                if (trainingEmployeeList.login(commend[1], commend[2])) {
                if (true) {
                    id = commend[2];
                    permission = 1;
                    flag = true;
                    printTrainingEmployeeCommend();
//                } else if (studentList.login(commend[1], commend[2])) {
                } else if (false) {
                    id = commend[1];
                    permission = 2;
                    flag = true;
                    printStudentCommend();
//                } else if (professorList.login(commend[1], commend[2])) {
                } else if (true) {
                    id = commend[1];
                    permission = 3;
                    flag = true;
                    printProfessorCommend();
                } else {
                    System.out.println("wrong userName or password!");
                }
            }

            while (flag) {
                switch (permission) {
                    case 1:
                        System.out.print("commend : ");
                        commendLine = scn.nextLine().trim();
                        commend = commendLine.split(" ");
                        switch (commend[0]) {
                            case "registerStudent":
                                break;
                            case "deleteStudent":
                                break;
                            case "editStudent":
                                break;
                            case "registerProfessor":
                                break;
                            case "deleteProfessor":
                                break;
                            case "editProfessor":
                                break;
                            case "registerTrainingEmployee":
                                break;
                            case "deleteTrainingEmployee":
                                break;
                            case "editTrainingEmployee":
                                break;
                            case "addCourse":
                                break;
                            case "deleteCourse":
                                break;
                            case "editCourse":
                                break;
                            case "salary":
                                break;
                            case "showStudentList":
                                break;
                            case "showProfessorList":
                                break;
                            case "showTrainingEmployeeList":
                                break;
                            case "showCourseList":
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
                                break;
                            case "showCoursesList":
                                break;
                            case "selectUnit":
                                break;
                            case "showSelectedCourses":
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
                                break;
                            case "showStudent":
                                break;
                            case "setScore":
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
        System.out.println("login userName password \t {user name => studentCode || professorCode && password => nationalCode}");
        System.out.print("commend : ");
    }

    public static void printTrainingEmployeeCommend() {
        System.out.println("registerStudent firstName LastName nationalCode birthDate department");
        System.out.println("{ department => COMPUTER , ACCOUNTING , ELECTRONIC , ELECTRICAL }");
        System.out.println("deleteStudent studentCode");
        System.out.println("editStudent studentCode newFirstName newLastName newNationalCode");
        System.out.println("registerProfessor firstName LastName nationalCode birthDate status");
        System.out.println("{ status => SCIENCE_COMMITTEE , TUITION_FEE}");
        System.out.println("deleteProfessor professorCode");
        System.out.println("editProfessor professorCode newFirstName newLastName newNationalCode");
        System.out.println("registerTrainingEmployee firstName LastName nationalCode birthDate userName password");
        System.out.println("deleteTrainingEmployee TrainingEmployeeCode ");
        System.out.println("editTrainingEmployee TrainingEmployeeCode newFirstName newLastName newNationalCode");
        System.out.println("addCourse courseCode department courseName unit professorNationalCode");
        System.out.println("{ department => COMPUTER , ACCOUNTING , ELECTRONIC , ELECTRICAL }");
        System.out.println("deleteCourse courseCode");
        System.out.println("editCourse courseCode newCourseName newUnit newProfessorNationalCode");
        System.out.println("salary");
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
        System.out.println("selectUnit term courseCode... \t{ selectUnit 1-95 1 2 \" you can write multi course id \" }");
        System.out.println("showSelectedCourses  \t {show selected course & score & grad point average }");
        System.out.println("help");
        System.out.println("logout");
        System.out.println("exit");
    }

    public static void printProfessorCommend() {
        System.out.println("showProfile");
        System.out.println("showCourses");
        System.out.println("showStudent");
        System.out.println("setScore courseCode studentNationalCode score");
        System.out.println("showSalary term");
        System.out.println("help");
        System.out.println("logout");
        System.out.println("exit");
    }

}

