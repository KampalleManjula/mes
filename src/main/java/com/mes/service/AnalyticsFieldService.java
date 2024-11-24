package com.mes.service;

import java.util.List;

import com.mes.model.AnalyticsField;

public interface AnalyticsFieldService {
	 List<AnalyticsField> getAllAnalyticsFields();
	    AnalyticsField getAnalyticsFieldById(Long id);
	    AnalyticsField createAnalyticsField(AnalyticsField analyticsField);
	    AnalyticsField updateAnalyticsField(Long id, AnalyticsField analyticsField);
	    void deleteAnalyticsField(Long id);


}
