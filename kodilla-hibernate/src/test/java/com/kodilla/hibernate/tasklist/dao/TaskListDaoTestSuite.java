package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    public static final String LISTNAME = "Test List";
    private static final String DESCRIPTION = "Test Description";

    @AfterEach
    public void cleanUp() {
        taskListDao.deleteAll();
    }

    @Test
    @DisplayName("Finding by a name")
    void testFindByListName() {
        // Given
        TaskList taskList = new TaskList(LISTNAME, DESCRIPTION);
        taskListDao.save(taskList);

        // When
        List<TaskList> readTaskLists = taskListDao.findByListName(LISTNAME);

        // Then
        assertEquals(1, readTaskLists.size());
        assertEquals(LISTNAME, readTaskLists.get(0).getListName());
        assertEquals(DESCRIPTION, readTaskLists.get(0).getDescription());
    }
}
