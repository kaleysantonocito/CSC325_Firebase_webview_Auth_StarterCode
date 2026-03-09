package com.example.csc325_firebase_webview_auth.view;

import com.google.firebase.auth.FirebaseAuthException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.application.Platform;

public class SignInController {

    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    @FXML
    private void handleSignIn() {
        String email = emailField.getText();
        String password = passwordField.getText();


        if (email.equals("user@example.com") && password.equals("secretPassword")) {
            errorLabel.setText("Sign-in successful!");
            System.out.println("✅ User signed in.");
        } else {
            errorLabel.setText("Invalid email or password.");
        }
    }
}

