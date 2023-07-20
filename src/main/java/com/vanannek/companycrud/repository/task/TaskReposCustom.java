package com.vanannek.companycrud.repository.task;

import com.vanannek.companycrud.entity.Milestone;
import com.vanannek.companycrud.entity.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Date;
import java.util.List;

@NoRepositoryBean
public interface TaskReposCustom {

    /**
     * Retrieves a list of tasks associated with a specific project and assigned to a particular employee.
     *
     * This method uses a native SQL query to retrieve tasks from the database that meet the specified criteria.
     *
     * @param projId The ID of the project to which the tasks are associated.
     * @param empId  The ID of the employee to whom the tasks are assigned.
     * @return A list of Task entities that are associated with the given project and assigned to the specified employee.
     */
    @Query(value = "SELECT * FROM task t WHERE t.project_id = :projId AND t.assignee_id = :empId", nativeQuery = true)
    List<Task> findByEmpId(Long projId, Long empId);

    /**
     * Retrieves a list of tasks assigned to a specific employee and not yet completed
     * with deadlines greater than or equal to the specified date.
     *
     * @param empId    The ID of the employee to retrieve tasks for.
     * @param curDate  The current date used to filter tasks with deadlines greater than or equal to this date.
     * @return A list of Task entities that meet the specified criteria.
     */
    @Query(value = "SELECT * FROM task t WHERE t.assignee_id = :empId AND t.deadline >= :curDate " +
                    "AND t.start <= :curDate AND t.progress != 'COMPLETED'", nativeQuery = true)
    List<Task> findTasksCheckOut(Long empId, Date curDate);

    @Query(value = "SELECT * FROM task WHERE id IN (SELECT task_id FROM mile_task WHERE mile_id = :mileId)",
            nativeQuery = true)
    List<Task> findByMileId(Long mileId);

    @Query(value = "", nativeQuery = true)
    List<Task> findTaskCompletedByMileId(Long mileId);

    @Query(value = "", nativeQuery = true)
    List<Task> findTasksCanAddToMile(Milestone milestone);
}
