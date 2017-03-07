package es.gorka.edu.components;


import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import es.gorka.edu.dto.AlumnoDTO;
import es.gorka.edu.service.LonganizaService;
import es.gorka.edu.service.NaranjaService;
import es.gorka.edu.service.TofuService;

public class DesayunoPage extends WebPage{
	
	@SpringBean
	LonganizaService longaniza;
	
	@SpringBean
	TofuService tofu;
	
	@SpringBean
	NaranjaService naranja;
	
	@SpringBean
	AlumnoDTO alumnoDto;
	
	 public DesayunoPage() {
			add(new Label("title","Añade un desayuno"));
			Form<AlumnoDTO> form = new Form<AlumnoDTO>("formAddNewBreakfast", new CompoundPropertyModel<AlumnoDTO>(alumnoDto)){

				private static final long serialVersionUID = 1L;

				@Override
				protected void onSubmit() {
					super.onSubmit();
					FeedbackMessage message = null;
					if(getModelObject().getBocadillo().equals("Tofu") || getModelObject().getBocadillo().equals("Longaniza")){
						if(getModelObject().getBocadillo().equals("Longaniza")){
							boolean isInserted =  longaniza.insertNewBocadillo(getModelObject());
							FeedbackMessage message3;
							if(isInserted){
								message3 = new FeedbackMessage(this, "Desayuno insertado", FeedbackMessage.INFO);
							} else {
								message3 = new FeedbackMessage(this, "Error al insertar un desayuno", FeedbackMessage.ERROR);
							}
							getFeedbackMessages().add(message3);
						}else if(getModelObject().getBocadillo().equals("Tofu")){
							boolean isInserted =  tofu.insertNewTofu(getModelObject());
							FeedbackMessage message4;
							if(isInserted){
								message4 = new FeedbackMessage(this, "Desayuno insertado", FeedbackMessage.INFO);
							} else {
								message4 = new FeedbackMessage(this, "Error al insertar un desayuno", FeedbackMessage.ERROR);
							}
							getFeedbackMessages().add(message4);
						}
					} else {
						message = new FeedbackMessage(this, "Esa clase de bocadillo no existe", FeedbackMessage.ERROR);
					}
					getFeedbackMessages().add(message);
					
					FeedbackMessage message2 = null;
					if(getModelObject().getNaranja().equals("Si") || getModelObject().getNaranja().equals("")){
						if(getModelObject().getNaranja().equals("Si")){
							boolean isInserted =  naranja.insertNewNaranja(getModelObject());
							FeedbackMessage message5;
							if(isInserted){
								message5 = new FeedbackMessage(this, "Desayuno insertado", FeedbackMessage.INFO);
							} else {
								message5 = new FeedbackMessage(this, "Error al insertar un desayuno", FeedbackMessage.ERROR);
							}
							getFeedbackMessages().add(message5);
							message2 = new FeedbackMessage(this, "Valor aceptado", FeedbackMessage.ERROR);
						}	
					} else {
						message2 = new FeedbackMessage(this, "Introduce un valor aceptado", FeedbackMessage.ERROR);
					}

					getFeedbackMessages().add(message2);
				}
			};
			form.add(new Label("alumnoLabel", "Alumno"));
			form.add(new Label("bocadilloLabel", "Bocadillo"));
			form.add(new Label("naranjaLabel", "Naranja"));
			form.add(new TextField<String>("alumno"));
			form.add(new TextField<String>("bocadillo"));
			form.add(new TextField<String>("naranja"));
			FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackMessage");
			feedbackPanel.setOutputMarkupId(true);
			add(feedbackPanel);
			add(form);
	 }
}