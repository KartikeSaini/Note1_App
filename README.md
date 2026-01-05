# 📝 NOTES APP (ANDROID)

A modern **Notes Application** built using **Kotlin** for Android that allows users to securely sign up, sign in, and manage their personal notes efficiently. The app follows **MVVM architecture** and focuses on clean UI and scalable code structure.

---

## 🚀 FEATURES

* 🔐 **USER AUTHENTICATION**

  * Sign Up & Sign In using Email
  * Phone Number Login support
* 🗒️ **NOTES MANAGEMENT**

  * Create, edit, and delete notes
  * View notes in a clean list layout

* 🧭 **SMOOTH NAVIGATION**

  * Splash Screen
  * Fragment-based navigation
* ♻️ **RECYCLERVIEW** for efficient list handling
* 🧠 **MVVM ARCHITECTURE** for better maintainability

---

## 🛠️ TECH STACK

* **Language:** Kotlin
* **Architecture:** MVVM (Model–View–ViewModel)
* **UI:** XML Layouts, Fragments
* **State Management:** ViewModel & LiveData
* **Authentication:** Firebase Authentication
* **Build Tool:** Gradle

---

## 📂 PROJECT STRUCTURE

```
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
├── models
│   ├── Note.kt
│   └── UserRegistration.kt
```

---

## 📸 SCREENS INCLUDED

* Login / Signup Screen
  
    <img width="381" height="834" alt="Screenshot 2026-01-05 164833" src="https://github.com/user-attachments/assets/8754ba86-1485-4a74-b2ce-85eb7101f9ce" />
    
* Phone Login Screen

    <img width="372" height="835" alt="Screenshot 2026-01-05 165019" src="https://github.com/user-attachments/assets/9578a97e-191b-41a1-ac26-548742d26bfb" />

* Notes Home Screen

    <img width="378" height="833" alt="Screenshot 2026-01-05 165150" src="https://github.com/user-attachments/assets/b48073b5-4b76-4bb5-8cdf-c43b81d27949" />

* Add / Edit Note Screen
  
    <img width="377" height="835" alt="Screenshot 2026-01-05 165218" src="https://github.com/user-attachments/assets/66b38058-ca94-449b-b894-8310c811487a" />

---


## ✅ HOW TO RUN THE PROJECT

1. Clone the repository

   ```bash
   git clone https://github.com/KartikeSaini/photoGalleryApp.git
   ```
2. Open the project in **Android Studio**
3. Sync Gradle files
4. Configure Firebase (`google-services.json`)
5. Run the app on an emulator or physical device ▶️

---

## 🎯 LEARNING OUTCOMES

* Understanding **MVVM architecture** in Android
* Working with **Fragments & RecyclerView**
* Implementing **Firebase Authentication**
* Writing clean and maintainable Kotlin code

---

## 👨‍💻 AUTHOR

**Kartike Saini**
Android Developer | Kotlin
📧 Email: [kartikesaini2304@gmail.com](mailto:kartikesaini2304@gmail.com)

---

## ⭐ SUPPORT

If you like this project, give it a ⭐ on GitHub and feel free to fork or contribute!
