package es.gorka.edu.components;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;

import de.agilecoders.wicket.extensions.markup.html.bootstrap.form.datetime.DatetimePicker;


public class AddAuthor extends WebPage{
	
	public AddAuthor(){
		
		Form formAuthor = new Form("addingNewAuthor");
		
		formAuthor.add(new Label("nameAuthorLabel", getString("author.name")));
		formAuthor.add(new RequiredTextField("nameAuthor"));
		
		formAuthor.add(new Label("dateOfBirthLabel", getString("date.of.birth")));
		DatetimePicker datetimePicker = new DatetimePicker("dateOfBirth", "dd-MM-yyyy");
		formAuthor.add(datetimePicker);

		add(formAuthor);
	}

}
