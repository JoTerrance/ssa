package es.gorka.edu.components;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.web.client.RestTemplate;
import org.wicketstuff.annotation.mount.MountPath;

import es.gorka.edu.dto.UserDTO;
import es.gorka.edu.service.IService;
import es.gorka.edu.utils.Utilities;

@MountPath("signup.html")
public class SignUpPage extends BaseUserPage {

	private static final Logger logger = LogManager.getLogger(SignUpPage.class.getName());

	@SpringBean(name = "userService")
	private IService userService;

	public IService getUserService() {
		return userService;
	}

	public void setUserService(IService userService) {
		this.userService = userService;
	}

	public SignUpPage() {
		add(new Label("title", getString("title")));
		StatelessForm<UserDTO> form = new StatelessForm<UserDTO>("formLogin",
				new CompoundPropertyModel<UserDTO>((UserDTO) userService.newEntity()));
		AjaxButton ajaxButton = new AjaxButton("button",form) {
			private RestTemplate restTemplate = new RestTemplate();

			@Override
			protected void onSubmit(AjaxRequestTarget target) {
				super.onSubmit(target);
				UserDTO userDto = form.getModelObject();
				String uri = new String(Utilities.getServerUrl() + "/user/insert/new");
				Boolean isInsertedUser = restTemplate.postForObject(uri, userDto, Boolean.class);
				addFeedbackMessageIfUserIsInserted(isInsertedUser);
				updateFeedbackPanel(target);

			}

			private void addFeedbackMessageIfUserIsInserted(Boolean insertedDto) {
				if (insertedDto) {
					getFeedbackMessages()
							.add(new FeedbackMessage(this, "Usuario insertado", FeedbackMessage.INFO));
				} else {
					getFeedbackMessages()
							.add(new FeedbackMessage(this, "El usuario no se ha insertado", FeedbackMessage.ERROR));
				}
			}

			private void updateFeedbackPanel(AjaxRequestTarget target) {
				target.add(getFeedbackPanel());
			}
		};
		form.setOutputMarkupId(true);
		form.add(ajaxButton);
		
		fillUserForm(form);

		add(form);

		add(new BookmarkablePageLink<String>("homeLink", HomePage.class));
	}

	private void submitNewUser(UserDTO userDto) {
		if (userService.insertNewEntityDto(userDto)) {
			logger.debug("El usuario se ha guardado correctamente");
			getFeedbackMessages().add(this, "El usuario se ha guardado correctamente", FeedbackMessage.INFO);
		}
	}


}
