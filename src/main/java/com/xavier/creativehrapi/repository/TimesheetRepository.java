package com.xavier.creativehrapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xavier.creativehrapi.model.Timesheet;

public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {

}
