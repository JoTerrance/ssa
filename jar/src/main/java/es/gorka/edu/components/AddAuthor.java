package es.gorka.edu.components;

import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import es.gorka.edu.dto.AuthorDTO;
import es.gorka.edu.service.AddingAuthorService;


public class AddAuthor extends WebPage{
	@SpringBean
	AddingAuthorService aService;
	
	@SpringBean
	AuthorDTO authorDTO;
	
	public AddAuthor(){
		
		Form <AuthorDTO>formAuthor = new Form <AuthorDTO> ("addingNewAuthor", new CompoundPropertyModel<AuthorDTO>(authorDTO)){
			
			private static final long serialVersionUID = 1L;
			
		@Override
		protected void onSubmit(){
			super.onSubmit();
			boolean isInserted = aService.insert(getModelObject());
			FeedbackMessage message;
			if(isInserted){
				message = new FeedbackMessage(this, "SUCCESFULL INSERTION", FeedbackMessage.INFO);
			}else {
				message = new FeedbackMessage(this, "ERROR IN THE INSERTION", FeedbackMessage.INFO);
			}
			getFeedbackMessages().add(message);
		}
		
		};
		formAuthor.add(new Label("nameAuthorLabel", getString("author.name")));
		formAuthor.add(new RequiredTextField("nameOfAuthor"));
		
		formAuthor.add(new Label("dateOfBirthLabel", getString("date.of.birth")));
		DateTextField datetimePicker = new DateTextField("dateOfBirthFromAuthor", "dd-MM-yyyy");
		formAuthor.add(datetimePicker);
		
		add(new BookmarkablePageLink<String>("linkReturn", HomePage.class));		
		
		FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackMessage");
		feedbackPanel.setOutputMarkupId(true);
		add(feedbackPanel);

		add(formAuthor);
	}

}