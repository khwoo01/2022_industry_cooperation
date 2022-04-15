package com.gg.academicCareerInfo;

import java.util.List;

public interface AcademicService {
	public abstract void insertAcademic(AcademicDTO dto);
	public abstract List<AcademicDTO> academicList(String userID);
}
