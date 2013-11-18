package com.mylog.ui;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class MainForm
{
	private HttpServletRequest request;

	/**
	 * Constructor.
	 *
	 * @param request
	 * 			A handle to the request object for this page
	 */
	public MainForm(HttpServletRequest request)
	{
		this.request = request;
	}

	/**
	 *
	 * @return
	 * 		A list of sections, applicable to the user currently logged in
	 */

	public List<Section> getSections()
	{
		return getSectionsForAnonymousUser();
	}

	/**
	 *
	 * @return
	 * 		A list of sections, applicable to the user currently logged in
	 */

	private List<Section> getSectionsForAnonymousUser()
	{
		ArrayList<Section> list = new ArrayList<MainForm.Section>();

		Section section = new Section("Welcome!", new ArrayList<MainForm.SectionItem>());
		section.getItems().add(new SectionItem("Welcome", "welcome/welcome_not_logged_in.jsp"));
		section.getItems().add(new SectionItem("Login", "login/login.jsp"));
		section.getItems().add(new SectionItem("Register", "register/register.jsp"));
		list.add(section);

		return list;
	}

	/**
	 *
	 * A class, representing a single item in a section
	 *
	 */

	public class SectionItem
	{
		private String name;
		private String url;
		public SectionItem(String name, String url) {
			super();
			this.name = name;
			this.url = url;
		}

		public String getName() {
			return name;
		}

		public String getUrl() {
			return url;
		}
	}

	/**
	 *
	 * A class, representing a section on the Main Form
	 *
	 */

	public class Section
	{
		private String name;
		private List<SectionItem> items;

		public Section(String name, List<SectionItem> items) {
			super();
			this.name = name;
			this.items = items;
		}

		public String getName() {
			return name;
		}

		public List<SectionItem> getItems() {
			return items;
		}
	}
}
