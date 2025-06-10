# Firebase-google-auth

## Introduction

This project serves as a source code example demonstrating how to integrate user authentication using **Google Accounts** into your Android application, leveraging the **Firebase Authentication** service. It provides a practical look at setting up and implementing a Google Sign-In flow.

![Group 1](https://github.com/user-attachments/assets/de65ba1f-def5-404c-8a10-d21552e1bc30)

## Technologies Used

This project utilizes the following key technologies and architectural patterns for Android development:

* **Jetpack Compose:** Building the modern declarative user interface.
* **Kotlin:** The primary programming language.
* **MVVM (Model-View-ViewModel):** Architectural pattern for separating UI logic from business logic.
* **Jetpack Navigation Compose:** Managing in-app navigation between screens.
* **Firebase Authentication:** Backend service for handling user authentication.
* **Google Sign-In Android SDK:** Specific SDK for implementing Google Sign-In on Android.


## Purpose

The main goal of this project is to provide a clear, functional example of integrating Google Sign-In with Firebase Authentication in a modern Android application built with Jetpack Compose and following the MVVM architectural pattern.

## Features

* Allows users to sign in with their Google Account.
* Authenticates users via Firebase Authentication.
* (Likely) Displays basic user information after successful login.
* (Likely) Provides a Sign Out option.

## Setup and Installation

To get this project running on your local machine and connect it to your Firebase project, follow these steps:

1.  **Prerequisites:**
    * Android Studio Arctic Fox or later.
    * An Android device or emulator.
    * A Google Account.

2.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/huytran2005/NoteMobileApp.git](https://github.com/huytran2005/NoteMobileApp.git)
    cd NoteMobileApp # Or the name of the cloned directory
    ```

3.  **Open the Project in Android Studio:**
    * Launch Android Studio and open the cloned project directory.

4.  **Sync Gradle:**
    * Android Studio should automatically prompt you to sync the project. Ensure you have an internet connection. Click "Sync Now" if prompted, or go to `File > Sync Project with Gradle Files`.

5.  **Connect to Firebase & Configure Google Sign-In:**

    * **In Android Studio, use the Firebase Assistant:**
        * Go to `Tools > Firebase`.
        ![1](https://github.com/user-attachments/assets/5ea00190-0893-4aa5-b631-3b49fba82b61)
        * Click on **Authentication** and then **Authenticate using Google**.
        ![2](https://github.com/user-attachments/assets/325fea18-aedf-4fed-aead-43a89f3893c2)
        * Follow the steps in the assistant to connect your project to Firebase and add the necessary Authentication dependencies.

    * **Manual Setup (Alternative/Verification in Firebase Console):**
        * Go to the [Firebase Console](https://console.firebase.google.com/) and create a new project or select an existing one.
        ![image](https://github.com/user-attachments/assets/8488367b-ed8b-4a84-b164-b5d24de5b3ce)
        * Provide a name for your project.
        ![image](https://github.com/user-attachments/assets/de0cf588-d830-41db-bdee-1c8abefcb3ca)
        * Click the **Android icon** to add an Android app to Firebase.
        ![image](https://github.com/user-attachments/assets/5d71d683-e8f5-4370-82ab-9c42f3cc315c)
        * **Enter your Android Package Name:** Find your application's package name in your `build.gradle.kts (Module :app)` file (under `android { defaultConfig { applicationId "your.package.name" } }`).
        ![image](https://github.com/user-attachments/assets/7c122662-be20-4130-ae04-1ba88c83b72e)
        * Input your package name into the Firebase Console.
        ![image](https://github.com/user-attachments/assets/9decfe0a-b073-4a04-b091-fa6a050241c4)
        * **Find and Input your SHA-1 fingerprint:** This is essential for Google Sign-In.
            * In Android Studio, open the **Gradle** tab (on the right).
            ![image](https://github.com/user-attachments/assets/3f29e523-d9e8-4289-ba1e-2140e376bd35)
            * Click the "Execute Gradle Task" icon.
            ![image](https://github.com/user-attachments/assets/0e7d9bba-112e-4d3d-b965-1f908649983f)
            * Enter `signingReport` and press Enter.
            ![My Application – Login kt My_Application app main 22_04_2025 12_03_08 CH](https://github.com/user-attachments/assets/e39727d8-f9f0-4279-a5f7-05b2e9d455b1)
            * Copy the SHA-1 fingerprint from the Run console output.
            ![image](https://github.com/user-attachments/assets/77af4e90-cce1-4453-b1c8-a6ac205e253e)
            * Paste the SHA-1 fingerprint into the Firebase Console field.
        * Click **Register app**.
        * **Download `google-services.json`:** Follow the prompt to download the configuration file.
        * **Add `google-services.json` to Project:** Copy the downloaded `google-services.json` file and paste it into the `app/` directory of your Android project in the Project view.
        * **Enable Google Sign-In Method:** In the Firebase Console, navigate to **Authentication > Sign-in method**. Enable the **Google** provider.
        ![image](https://github.com/user-attachments/assets/f3da80c8-4e00-4231-aabb-1fb8496e69a2)
        * **Add Dependencies in `build.gradle`:** Ensure your `build.gradle (Project)` has the google-services plugin classpath and your `build.gradle (Module :app)` has the `google-services` plugin applied, the Firebase BoM, and the `firebase-auth-ktx` and `play-services-auth` dependencies (the Firebase Assistant usually handles this).

6.  **Sync Gradle Again:** After adding the `google-services.json` file and verifying dependencies, sync your project with Gradle files one more time.

7.  **Run the Application:**
    * Connect your Android device or start an emulator.
    * Click the Run button in Android Studio.

**Note:** The "Web client ID" you found in the Firebase console is needed in your **Kotlin code** when configuring the Google Sign-In flow to request an ID token. You'll typically pass this to `GoogleSignInOptions`.

