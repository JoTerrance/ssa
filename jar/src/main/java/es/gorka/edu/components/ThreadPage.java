package es.gorka.edu.components;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("thread.html")
public class ThreadPage extends WebPage {
	public ThreadPage() {

		Thread t1 = new Thread() {
			@Override
			public void run() {
				add(new Label("title", "Test de threads"));
			}
		};
		t1.start();
	}
}
