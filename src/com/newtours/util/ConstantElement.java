package com.newtours.util;

public class ConstantElement {



	public enum DataLibraryType
	{
		PORTFOLIOS("Portfolios"),  CONTRACTS("Contracts"),CEDANT_PROJECTS("Cedant Projects"),ACCOUNTS("Accounts"),REFERENCES("References"),FAVORITES("Favorites"),SEARCH("Search");
		private final String statusCode;

		private DataLibraryType(String s) {
			statusCode = s;
		}

		public String getDataLibraryType() {
			return statusCode;
		}
	}
	public enum Locator
	{
		 XPATH("xpath"),  CSS("css"), ID("id"),LINKTEXT("linktext"),PARTIALLINKTEXT("partiallinktext"),CLASS("class"),TAGNAME("tagname");
		private final String statusCode;

		private Locator(String s) {
			statusCode = s;
		}

		public String getLocatorName() {
			return statusCode;
		}
	}

}

