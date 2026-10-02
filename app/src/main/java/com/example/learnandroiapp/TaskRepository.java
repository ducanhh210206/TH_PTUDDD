package com.example.learnandroiapp;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private static List<CongViec> taskList = new ArrayList<>();

    public static List<CongViec> getTaskList() {
        return taskList;
    }

    public static void addTask(CongViec task) {
        taskList.add(task);
    }
}
