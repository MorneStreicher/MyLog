package com.mylog.entries.budget;

import java.util.ArrayList;
import java.util.List;

import com.mylog.entries.def.AEntryTypeDefinitionFactory;
import com.mylog.entries.def.EntryDefinition;
import com.mylog.entries.def.EntryTypeDefinition;
import com.mylog.entries.def.FieldDefinition;
import com.mylog.entries.def.ReportDefinition;
import com.mylog.entries.def.SearchDefinition;

public class BudgetTypeFactory extends AEntryTypeDefinitionFactory
{

	@Override
	public EntryTypeDefinition createEntryTypeDefinition() throws Exception
	{

		//
		// Fields
		//
		List<FieldDefinition> fields = new ArrayList<FieldDefinition>();
		FieldDefinition id = new FieldDefinition("Id", "Id", false,
				FieldDefinition.FieldType.INTERNAL, 100);
		FieldDefinition fieldDate = new FieldDefinition("Date", "Date", false,
				FieldDefinition.FieldType.DATE, 0);
		FieldDefinition fieldDescription = new FieldDefinition("Description", "Description", false,
				FieldDefinition.FieldType.TEXT, 50);
		FieldDefinition fieldAmount = new FieldDefinition("Amount", "Amount", false,
				FieldDefinition.FieldType.AMOUNT, 20);
		fields.add(id);
		fields.add(fieldDate);
		fields.add(fieldDescription);
		fields.add(fieldAmount);

		//
		// EntryDefinition
		//
		EntryDefinition entryDefinition = new EntryDefinition(BudgetEntry.class, fields);

		//
		// Report and Search Definitions
		//
		List<ReportDefinition> reportDefinitions = new ArrayList<ReportDefinition>();
		List<SearchDefinition> searchDefinitions = new ArrayList<SearchDefinition>();

		SearchDefinition searchDefCurrentMonth = new SearchDefinition("CurrentMonth",
				"Current month", BudgetEntryDateSearch.class, new Object[]
				{});
		searchDefinitions.add(searchDefCurrentMonth);

		EntryTypeDefinition definition = new EntryTypeDefinition(NAME, entryDefinition,
				reportDefinitions, searchDefinitions);

		return definition;
	}

	public static final String NAME = "Budget";

}
