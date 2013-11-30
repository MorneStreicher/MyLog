package com.mylog.entries.def;

import java.util.ArrayList;
import java.util.List;

public class EntryTypeDefinition {

	private String name;
	private EntryDefinition entryDefinition;
	private List<ReportDefinition> reportDefinitions = new ArrayList<ReportDefinition>();
	private List<SearchDefinition> searchDefinitions = new ArrayList<SearchDefinition>();

	public EntryTypeDefinition(String name, EntryDefinition entryDefinition,
			List<ReportDefinition> reportDefinitions,
			List<SearchDefinition> searchDefinitions) {
		super();
		this.name = name;
		this.entryDefinition = entryDefinition;
		this.reportDefinitions = reportDefinitions;
		this.searchDefinitions = searchDefinitions;
	}

	public String getName() {
		return name;
	}

	public EntryDefinition getEntryDefinition() {
		return entryDefinition;
	}

	public List<ReportDefinition> getReportDefinitions() {
		return reportDefinitions;
	}

	public List<SearchDefinition> getSearchDefinitions() {
		return searchDefinitions;
	}


}
