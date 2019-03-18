package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.EnrollmentHistory;

public interface EnrollmentHistoryService {

	public void addEnrollmentHistory(EnrollmentHistory enrollmentHistory);

	public void modifyEnrollmentHistory(EnrollmentHistory enrollmentHistory);

	public void deleteEnrollmentHistoryById(Long id);

	public EnrollmentHistory findEnrollmentHistoryById(Long id);

}
