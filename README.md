📝 NOTES APP (ANDROID)

A modern Notes Application built using Kotlin for Android that allows users to securely sign up, sign in, and manage their personal notes efficiently. The app follows MVVM architecture and provides a clean, user-friendly interface.

🚀 Features

🔐 User Authentication

  Sign Up & Sign In using Email

  Phone Number Login support

🗒️ Notes Management

  Create, edit, and delete notes

  View notes in a clean list layout

Splash Screen

  Fragment-based navigation

♻️ RecyclerView for displaying notes efficiently

🧠 MVVM Architecture for clean and scalable code

🛠️ Tech Stack

  Language: Kotlin

  Architecture: MVVM (Model–View–ViewModel)

  UI: XML, Fragments

  State Management: ViewModel & LiveData

  Backend / Auth: Firebase Authentication

  Build System: Gradle (KTS)

📂 Project Structure
com.note.app
│
├── activities
│   ├── NoteSplashScreen.kt
│   ├── NoteSignInAndSignUpScreen.kt
│   └── NoteHomeScreen.kt
│
├── fragments
│   ├── LoginFragment.kt
│   ├── LoginUsingPhoneFragment.kt
│   ├── RegisterFragment.kt
│   ├── EditorFragment.kt
│   ├── ShowNoteFragment.kt
│   └── SearchScreenFragment.kt
│
├── adapters
│   └── NotesAdapter.kt
│
├── viewmodel
│   └── NoteViewModel.kt
│
├── repositories
│   └── EditorNoteRepository.kt
│
├── pojo
│   ├── Note.kt
│   └── UserRegistration.kt
📸 Screens Included

LOGIN \ SIGNUP SCREEN

<img width="381" height="834" alt="Screenshot 2026-01-05 164833" src="https://github.com/user-attachments/assets/e0291536-2db1-4a38-9cb8-47b7bea510b5" />

PHONE LOGIN SCREEN

<img width="372" height="835" alt="Screenshot 2026-01-05 165019" src="https://github.com/user-attachments/assets/6019b024-8ee4-4b68-9f53-ef6aa5a6a0a5" />

NOTES HOME SCREEN

<img width="378" height="833" alt="Screenshot 2026-01-05 165150" src="https://github.com/user-attachments/assets/e27abc37-2922-4dc9-b46a-c20442a887e5" />

ADD \ EDIT NOOTE SCREEN

<img width="375" height="835" alt="Screenshot 2026-01-05 165205" src="https://github.com/user-attachments/assets/cba8fa28-bb41-4044-858d-0c820d99c3c4" />


✅ How to Run the Project

  Clone the repository

  git clone <your-repo-url>

  Open the project in Android Studio

  Sync Gradle files

  Connect a physical device or emulator

  Run the app ▶️

⚠️ Make sure Firebase is properly configured (google-services.json already included).

🎯 Learning Outcomes

  Practical understanding of MVVM architecture

  Working with Fragments & RecyclerView

  Firebase Authentication integration

  Clean code structure and separation of concerns

👨‍💻 Author

Kartike Saini
Android Developer | Kotlin
📧 Email: kartikesaini2304@gmail.com

⭐ If you like this project

Give it a ⭐ on GitHub and feel free to fork or contribute!
