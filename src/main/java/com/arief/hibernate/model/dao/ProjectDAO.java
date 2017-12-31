package com.arief.hibernate.model.dao;

import com.arief.hibernate.model.entity.Project;

import java.util.List;

public interface ProjectDAO {
    void save(Project p);
    List<Project> findAll();
    void update(Project p);
    Project findOne(String projectId);
}
