package com.example;

import com.example.entity.EmpRole;
import com.example.entity.Employee;
import com.example.entity.ExpReimbursementReq;
import com.example.repository.EmployeeRepository;
import com.example.repository.JdbcEmployeeRepository;
import com.example.repository.JdbcReimbursementReqRepository;
import com.example.repository.ReimbursementReqRepository;
import com.example.service.JavaMailUtil;

import java.io.Console;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Application {

    public static String Cont() {
        Scanner s = new Scanner(System.in);
        String cont = "";
        String start = "start";

        while (start.equals("start")) {
            System.out.println("Type y for yes or n for no:");
            cont = s.nextLine();
            if (!(cont.equals("y") || cont.equals("n"))){

                System.out.println("Your entry did not register");
            }else {
                return cont;
            }
        }

        return cont;


    }

    public static String Start(String str) {
        if(str.equals("y")){
            return "start";
        }else return "stop";

    }

    public static void main(String[] args) throws Exception {
        String start="start";
        String cont;
        String input;
        //JavaMailUtil.sendMail("vremailfromjava@gmail.com");

        while(start.equals("start")) {
            Scanner s = new Scanner(System.in);
            System.out.println("Welcome to homepage");
            System.out.println("Would you like to login:");
            cont = Cont();
            if (cont.equals("y")) {
                System.out.println("Plese enter your username: ");
                String username = s.nextLine();
                System.out.println("Please enter your password");
                String password = s.nextLine();
                EmployeeRepository jdbcEmpRepo = new JdbcEmployeeRepository();
                System.out.println(jdbcEmpRepo.authenticate(username, password));
                Optional<Employee> emp1 = jdbcEmpRepo.empAuthentication(username,password);
                if(emp1.get()==null){
                    System.out.println("Your credentials could not be authenticated would you like to try again?");
                    start=Start(Cont());

                }else if(emp1.get().getRole().toString().equals("EMPLOYEE")){
//----------------------------------------------------------------------------------------------------------------------
                    System.out.println("in employee view");

                    while (start.equals("start")) {
                        ReimbursementReqRepository jdbcReimRepo = new JdbcReimbursementReqRepository();
                        ExpReimbursementReq req = new ExpReimbursementReq();
                        System.out.println("Please decide what you would like to do:");
                        System.out.println("a) Submit an Expense Reimbursement Request.");
                        System.out.println("b) View my pending open requests.");
                        System.out.println("c) View my resolved requests.");
                        System.out.println("d) View my personal information.");
                        System.out.println("e) Update my personal information.");
                        System.out.println("f) Reset password.");
                        System.out.println("g) Logout.");
                        System.out.println("Please make a selection: ");
                        cont = s.nextLine();
                        switch (cont){
                            case "a" :
                                System.out.println("Submitting an Expense Reimbursement Request.");
                                while(start.equals("start")) {
                                    System.out.print("Please enter the amount to be reimbursed: $");
                                    input = s.nextLine();
                                    if (Double.parseDouble(input) > 0.0) {
                                        req.setAmount(Double.parseDouble(input));
                                        System.out.print("Please enter the reason for reimbursement: ");
                                        input = s.nextLine();
                                        req.setReimReason(input);
                                        req.setEmployee(emp1.get());
                                        System.out.println("You are requesting a reimbursement of $" + req.getAmount() + " for '" + req.getReimReason() + ".'");
                                        jdbcReimRepo.save(req);
                                        start = "stop";
                                    } else {
                                        System.out.println("Amount must be greater than $0.00");
                                        System.out.println("Wish to start over?");
                                        start = Start(Cont());
                                    }
                                }
                                start="start";
                                break;

                            case "b" :
                                System.out.println("Viewing my pending open requests:");
                                List<ExpReimbursementReq> allRec = jdbcReimRepo.findAllByStatusForEmployee("PENDING", Integer.parseInt(emp1.get().getEmp_ID()));
                                System.out.println(allRec);
                                System.out.println(emp1.get().getEmp_ID());
                                break;
                            case "c" :
                                System.out.println("Viewing my resolved requests:");
                                allRec = jdbcReimRepo.findAllResolvedForEmployee(Integer.parseInt(emp1.get().getEmp_ID()));
                                System.out.println(allRec);
                                System.out.println(emp1.get().getEmp_ID());
                                break;
                            case "d" :
                                System.out.println("Viewing my personal information:");
                                emp1.get().viewEmpInfo(emp1.get());
                                break;
                            case "e" :
                                System.out.println("Updating my personal information.");
                                emp1.get().updateEmpInfo("", emp1.get());
                                jdbcEmpRepo.update(emp1.get());
                                break;
                            case "f" :
                                System.out.println("Resetting password:");
                                emp1.get().updateEmpInfo("password",emp1.get());
                                jdbcEmpRepo.update(emp1.get());
                                break;
                            case "g" :
                                System.out.println("Logging out:");
                                start="stop";
                                break;
                            default :
                                System.out.println("Please choose an option provided:");
                                cont=Cont();
                                start=Start(cont);
                                break;

                        }
                    }

                    start="start";
///---------------------------------------------------------------------------------------------------------------------

                }else if(emp1.get().getRole().toString().equals("MANAGER")){
                    System.out.println("in manager view");

                    while (start.equals("start")) {
                        ReimbursementReqRepository jdbcReimRepo = new JdbcReimbursementReqRepository();
                        ExpReimbursementReq req = new ExpReimbursementReq();
                        System.out.println("Please decide what you would like to do:");
                        System.out.println("a) Register an employee.");
                        System.out.println("b) View all employees.");
                        System.out.println("c) View resolved employee requests.");
                        System.out.println("d) View pending employee requests.");
                        System.out.println("e) View my personal information:");
                        System.out.println("f) Update my personal information.");
                        System.out.println("g) Reset password.");
                        System.out.println("h) Logout.");
                        System.out.println("Please make a selection: ");
                        cont = s.nextLine();
                        switch (cont){
                            case "a" :
                                System.out.println("Registering an employee:");
                                while(start.equals("start")) {
                                    System.out.print("Please enter the new employees first name: ");
                                    String fname = s.nextLine();
                                    System.out.print("Please enter the new employees name: ");
                                    String lname = s.nextLine();
                                    System.out.print("Please enter the new employees email: ");
                                    String email = s.nextLine();
                                    System.out.println("Please enter the new employees role : ");
                                    while(start.equals("start")) {
                                        System.out.print("Please enter (a) for EMPLOYEE (b) for MANAGER : ");
                                        input = s.nextLine();
                                        if (input.equals("a")) {
                                            Employee emp = new Employee(fname, lname, email, "EMPLOYEE");
                                            JavaMailUtil.sendMail(emp);
                                            jdbcEmpRepo.save(emp);
                                            start="stop";
                                        }else if (input.equals("b")) {
                                            Employee emp = new Employee(fname, lname, email, "MANAGER");
                                            jdbcEmpRepo.save(emp);
                                            JavaMailUtil.sendMail(emp);

                                            start="stop";
                                        }else {
                                            System.out.println("Selection did not match an available option.");
                                            System.out.println("Wish to re-enter a selection for the employee's role?");
                                            start=Start(Cont());
                                        }
                                    }
                                }
                                start="start";
                                break;

                            case "b" :
                                System.out.println("Viewing all employees:");
                                List<Employee> empList =jdbcEmpRepo.findAll();
                                for(int i=0;i<empList.size();i++){
                                    System.out.println(empList.get(i));
                                }

                                break;
                            case "c" :
                                System.out.println("Viewing resolved employee requests:");
                                List<ExpReimbursementReq> expReimbursementReqList = jdbcReimRepo.findAllResolved();
                                for(int i=0;i<expReimbursementReqList.size();i++){
                                    System.out.println(expReimbursementReqList.get(i));
                                }

                                break;
                            case "d" :
                                System.out.println("Viewing pending employee requests:");
                                expReimbursementReqList = jdbcReimRepo.findAllByStatus("PENDING");
                                for(int i=0;i<expReimbursementReqList.size();i++){
                                    System.out.println(expReimbursementReqList.get(i));
                                }

                                break;

                            case "e" :
                                System.out.println("Viewing my personal information:");
                                emp1.get().viewEmpInfo(emp1.get());
                                break;

                            case "f" :
                                System.out.println("Updating my personal information.");
                                emp1.get().updateEmpInfo("", emp1.get());
                                jdbcEmpRepo.update(emp1.get());
                                break;

                            case "g" :
                                System.out.println("Resetting password:");
                                emp1.get().updateEmpInfo("password",emp1.get());
                                jdbcEmpRepo.update(emp1.get());

                                break;

                            case "h" :
                                System.out.println("Logging out:");
                                start="stop";
                                break;
                            default :
                                System.out.println("Please choose an option provided:");
                                cont=Cont();
                                start=Start(cont);
                                break;

                        }
                    }

                    start="start";



//---------------------------------------------------------------------------------------------------------------------
                }else {
                    System.out.println("role was not found");
                    start="stop";
                }

            } else if (cont.equals("n")) {
                System.out.println("Thanks for playing");
                start = "stop";

            } else {
                System.out.println("Your entry did not register");
            }

        }
/*

            List<ExpReimbursementReq> allReq = jdbcReimRepo.findAll();
            jdbcEmpRepo.update(emp.get());




            jdbcReimRepo.updateStatus(allReq.get(2), "APPROVED");

        */
    }
}
