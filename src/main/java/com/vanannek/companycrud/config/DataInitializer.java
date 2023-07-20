package com.vanannek.companycrud.config;

import com.vanannek.companycrud.entity.*;
import com.vanannek.companycrud.enums.*;
import com.vanannek.companycrud.repository.*;
import com.vanannek.companycrud.repository.department.DeptRepository;
import com.vanannek.companycrud.repository.employee.EmpRepository;
import com.vanannek.companycrud.repository.project.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final AccountRepository accountRepo;
    private final DeptRepository deptRepo;
    private final EmpRepository empRepo;
    private final LeaveRequestRepository leaveRequestRepo;
    private final MilestoneRepository milestoneRepo;
    private final MileTaskRepository mileTaskRepo;
    private final ProjectRepository projRepo;
    private final ProjAssignRepository assignRepo;
    private final ProjBonusRepository bonusRepo;
    private final RoleRepository roleRepo;
    private final TaskRepository taskRepo;
    private final TaskCheckOutRepository checkOutRepo;
    private final TimeSheetRepository timesheetRepo;

    @Override
    public void run(String... args) throws Exception {
        try {
            deleteAll();

            List<Role> roles = initRole();
            List<Employee> emps = initEmployee(roles);
            List<Account> accs = initAccount(emps);
            List<Department> depts = initDept(emps);
            List<Project> projs = initProjects(emps.get(0));
            List<Task> tasks = initTask(projs.get(0), emps.get(2));
            List<LeaveRequest> requests = initLeaveRequest(emps.get(1), emps.get(3));
            List<Milestone> milestones = initMilestone(projs.get(0));
            List<MileTask> mileTasks = initMileTask(milestones.get(0), tasks);
            List<ProjectAssignment> assignments = initAssign(projs.get(0), depts);
            List<ProjectBonus> projectBonuses = initProjBonus(projs.get(0), emps.get(1)); // emps: index = 1 is Nor-Employee
            List<TimeSheet> timeSheets = initTimeSheet(emps.get(1), tasks.get(0));
            List<TaskCheckOut> taskCheckOuts = initCheckOut(timeSheets.get(0), tasks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAll() {
        accountRepo.deleteAll();
        deptRepo.deleteAll();
        empRepo.deleteAll();
        leaveRequestRepo.deleteAll();
        milestoneRepo.deleteAll();
        mileTaskRepo.deleteAll();
        projRepo.deleteAll();
        assignRepo.deleteAll();
        bonusRepo.deleteAll();
        roleRepo.deleteAll();
        taskRepo.deleteAll();
        checkOutRepo.deleteAll();
        timesheetRepo.deleteAll();
    }

    public List<Role> initRole() {
        List<Role> roles = List.of(
                Role.builder()
                        .perms(EPermission.MGR)
                        .title("Manager Role")
                        .salary(BigDecimal.valueOf(80000))
                        .build(),
                Role.builder()
                        .perms(EPermission.DEP_HEAD)
                        .title("Department Head Role")
                        .salary(BigDecimal.valueOf(70000))
                        .build(),
                Role.builder()
                        .perms(EPermission.NOR_EMPL)
                        .title("Employee Role")
                        .salary(BigDecimal.valueOf(50000))
                        .build(),
                Role.builder()
                        .perms(EPermission.HR)
                        .title("HR Role")
                        .salary(BigDecimal.valueOf(60000))
                        .build()
        );
        return roleRepo.saveAll(roles);
    }

    public List<Employee> initEmployee(List<Role> roles) {
        List<Employee> employees = List.of(
                Employee.builder()
                        .name("John Doe")
                        .gender(EGender.MALE)
                        .birthday(new Date())
                        .identifyCard("123456789")
                        .email("john.doe@example.com")
                        .phoneNumber("1234567890")
                        .address("123 Main Street")
                        .roleId(roles.get(0).getId())
                        .build(),
                Employee.builder()
                        .name("Jane Smith")
                        .gender(EGender.FEMALE)
                        .birthday(new Date())
                        .identifyCard("987654321")
                        .email("jane.smith@example.com")
                        .phoneNumber("1234567810")
                        .address("456 Oak Avenue")
                        .deptId(1L)
                        .roleId(roles.get(2).getId())
                        .build(),
                Employee.builder()
                        .name("Alex Johnson")
                        .gender(EGender.MALE)
                        .birthday(new Date())
                        .identifyCard("654321987")
                        .email("alex.johnson@example.com")
                        .phoneNumber("1234567811")
                        .address("789 Elm Street")
                        .deptId(1L)
                        .roleId(roles.get(1).getId())
                        .build(),
                Employee.builder()
                        .name("Jane Smith")
                        .gender(EGender.FEMALE)
                        .birthday(new Date())
                        .identifyCard("987654321")
                        .email("jane.smith@example.com")
                        .phoneNumber("1234567810")
                        .address("456 Oak Avenue")
                        .roleId(roles.get(3).getId())
                        .build()
        );
        return empRepo.saveAll(employees);
    }

    public List<Account> initAccount(List<Employee> emps) {
        List<Account> accs = new ArrayList<>();
        for (Employee emp : emps) {
            Account acc = Account.builder()
                    .username("username" + emp.getId())
                    .pass("password" + emp.getId())
                    .empId(emp.getId())
                    .build();
            accs.add(acc);
        }
        return accountRepo.saveAll(accs);
    }

    public List<Department> initDept(List<Employee> emps) {
        List<Department> depts = List.of(
                Department.builder()
                        .name("Department 1")
                        .deptHeadId(emps.get(2).getId())
                        .build()

        );
        return deptRepo.saveAll(depts);
    }

    public List<Project> initProjects(Employee owner) {
        List<Project> projs = List.of(
                Project.builder()
                        .name("Website Redesign")
                        .details("Redesign the company's website to improve user experience and modernize the design.")
                        .created(new Date(2023, 1, 1))
                        .start(new Date(2023, 5, 20, 9, 0))
                        .end(new Date(2023, 6, 30, 18, 0))
                        .completed(new Date(2023, 6, 30, 18, 0))
                        .progress("In progress")
                        .status(EProjStatus.IN_PROCESS)
                        .ownerId(owner.getId())
                        .bonusSalary(BigDecimal.valueOf(200000000))
                        .build(),
                Project.builder()
                        .name("Mobile App Development")
                        .details("Develop a mobile app for both iOS and Android platforms.")
                        .created(new Date(2023, 7, 01))
                        .start(new Date(2023, 7, 1, 10, 30))
                        .end(new Date(2023, 8, 30, 10, 30))
                        .completed(null)
                        .progress("Planning phase")
                        .status(EProjStatus.PLANNING)
                        .ownerId(owner.getId())
                        .bonusSalary(BigDecimal.valueOf(150000000))
                        .build()
        );
        return projRepo.saveAll(projs);
    }

    public List<Task> initTask(Project project, Employee assignee) {
        List<Task> tasks = List.of(
                Task.builder()
                        .title("Update Website Content")
                        .explanation("Update website content with latest product information.")
                        .start(new Date())
                        .deadline(new Date(System.currentTimeMillis() + 86400000))
                        .progress(100)
                        .ownerId(project.getOwnerId())
                        .assigneeId(assignee.getId())
                        .projId(project.getId())
                        .status(ETaskStatus.IN_PROCESS)
                        .build(),
                Task.builder()
                        .title("Prepare Monthly Report")
                        .explanation("Prepare the monthly financial report for review.")
                        .start(new Date())
                        .deadline(new Date(System.currentTimeMillis() + 604800000))
                        .progress(100)
                        .ownerId(project.getOwnerId())
                        .assigneeId(assignee.getId())
                        .projId(project.getId())
                        .status(ETaskStatus.REVIEWING)
                        .build()
        );
        return taskRepo.saveAll(tasks);
    }

    public List<LeaveRequest> initLeaveRequest(Employee requester, Employee approver) {
        List<LeaveRequest> requests = List.of(
                LeaveRequest.builder()
                        .reason("Vacation")
                        .notes("Taking a short vacation to relax and unwind.")
                        .start(new Date())
                        .end(new Date(System.currentTimeMillis() + 604800000))
                        .status(ELeavStatus.UNAPPROVED)
                        .requesterId(requester.getId())
                        .approverId(approver.getId())
                        .response("")
                        .build(),
                LeaveRequest.builder()
                        .reason("Sick Leave")
                        .notes("Taking a sick leave due to a mild flu.")
                        .start(new Date(System.currentTimeMillis() + 86400000))
                        .end(new Date(System.currentTimeMillis() + 172800000))
                        .status(ELeavStatus.APPROVED)
                        .requesterId(requester.getId())
                        .approverId(approver.getId())
                        .response("Feel better soon!")
                        .build()
        );
        return leaveRequestRepo.saveAll(requests);
    }

    public List<Milestone> initMilestone(Project project) {
        List<Milestone> milestones = List.of(
                Milestone.builder()
                        .title("Design Phase Completion")
                        .explanation("Complete the design phase of the project.")
                        .start(new Date())
                        .end(new Date(System.currentTimeMillis() + 604800000))
                        .completed(new Date(System.currentTimeMillis() + 302400000))
                        .ownerId(project.getOwnerId())
                        .projId(project.getId())
                        .build(),
                Milestone.builder()
                        .title("Product Launch")
                        .explanation("Launch the product to the market.")
                        .start(new Date(System.currentTimeMillis() + 86400000))
                        .end(new Date(System.currentTimeMillis() + 2592000000L))
                        .completed(null)
                        .ownerId(project.getOwnerId())
                        .projId(project.getId())
                        .build()
        );
        return milestoneRepo.saveAll(milestones);
    }

    public List<MileTask> initMileTask(Milestone milestone, List<Task> tasks) {
        List<MileTask> mileTasks = List.of(
                MileTask.builder()
                        .id(new MileTask.MileTaskId(milestone.getId(), tasks.get(0).getId()))
                        .build(),
                MileTask.builder()
                        .id(new MileTask.MileTaskId(milestone.getId(), tasks.get(1).getId()))
                        .build()
        );
        return mileTaskRepo.saveAll(mileTasks);
    }

    public List<ProjectAssignment> initAssign(Project project, List<Department> depts) {
        List<ProjectAssignment> assigns = List.of(
                ProjectAssignment.builder()
                        .id(new ProjectAssignment.ProjAssignId(project.getId(), depts.get(0).getId()))
                        .build()
        );
        return assignRepo.saveAll(assigns);
    }

    public List<ProjectBonus> initProjBonus(Project project, Employee receiver) {
        List<ProjectBonus> bonuses = List.of(
                ProjectBonus.builder()
                        .amount(BigDecimal.valueOf(50000000))
                        .received(new Date())
                        .receiverId(receiver.getId())
                        .projId(project.getId())
                        .percent(10)
                        .build()
        );
        return bonusRepo.saveAll(bonuses);
    }

    public List<TimeSheet> initTimeSheet(Employee employee, Task task) {
        List<TimeSheet> timeSheets = List.of(
                TimeSheet.builder()
                        .emplID(employee.getId())
                        .checkInTime(new Date())
                        .checkOutTime(new Date(System.currentTimeMillis() + 28800000))
                        .taskCheckInID(task.getId())
                        .build()
        );
        return timesheetRepo.saveAll(timeSheets);
    }

    public List<TaskCheckOut> initCheckOut(TimeSheet timeSheet, List<Task> tasks) {
        List<TaskCheckOut> checkOuts = List.of(
                TaskCheckOut.builder()
                        .id(new TaskCheckOut.TaskCheckOutId(timeSheet.getId(), tasks.get(0).getId()))
                        .updated(new Date())
                        .progress(50)
                        .build(),
                TaskCheckOut.builder()
                        .id(new TaskCheckOut.TaskCheckOutId(timeSheet.getId(), tasks.get(1).getId()))
                        .updated(new Date(System.currentTimeMillis() - 86400000))
                        .progress(75)
                        .build()
        );
        return checkOutRepo.saveAll(checkOuts);
    }
}