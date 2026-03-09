package com.example.csc325_firebase_webview_auth.view;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private TextField displayNameField;
    @FXML private Label statusLabel;

    @FXML
    private void handleRegister() {
        String email = emailField.getText().trim();
        String pass = passwordField.getText().trim();
        String displayName = displayNameField.getText().trim();

        if (email.isEmpty() || pass.isEmpty()) {
            statusLabel.setText("Email and password are required.");
            return;
        }

        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(email)
                .setPassword(pass)
                .setEmailVerified(false)
                .setDisabled(false);

        if (!displayName.isEmpty()) {
            request.setDisplayName(displayName);
        }

        try {
            UserRecord userRecord = App.fauth.createUser(request);
            statusLabel.setText("Account created! UID: " + userRecord.getUid());
        } catch (FirebaseAuthException e) {
            statusLabel.setText("Registration failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void goBack() {
        try {
            App.setRoot("/files/AccessFBView.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

