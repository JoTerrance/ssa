package es.gorka.edu.components;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class ExamenPage extends WebPage {
	
	public ExamenPage() {
		add(new Label("title", "Examen"));
		add(new BookmarkablePageLink<String>("desayunoLink", DesayunoPage.class));
		add(new BookmarkablePageLink<String>("listLink", ListDesayunoPage.class));
	}
}
