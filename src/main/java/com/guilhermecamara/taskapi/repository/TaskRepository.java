package com.guilhermecamara.taskapi.repository;

import com.guilhermecamara.taskapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
