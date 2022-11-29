package com.agile;

import java.io.IOException;
import javafx.fxml.FXML;

public class InitElementController {

		@FXML
		private void importMap() throws IOException {
			

			App.setRoot("primary");
		}

		@FXML
		private void loadProject() throws IOException {
			App.setRoot("primary");
		}
}