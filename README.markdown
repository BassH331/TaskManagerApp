# TaskManagerApp

TaskManagerApp is a simple yet powerful Android application for managing tasks. Built with Kotlin and Jetpack Navigation, it allows users to create, view, and organize tasks efficiently. The app features a clean Material Design interface, a navigation drawer, bottom navigation, and notification settings, making it a user-friendly tool for task management.

## Features

- **Task List**: View and manage tasks with a searchable list, including options to add new tasks and delete completed ones.
- **Task Suggestions**: Get suggested tasks to help with productivity.
- **Notification Settings**: Customize notifications for task reminders and deadlines.
- **About Page**: Learn more about the app and its version.
- **Navigation**: Seamlessly navigate between screens using a bottom navigation bar and a navigation drawer.
- **Material Design**: Modern UI with light/dark theme support using Material 3.

## Screenshots

*Coming soon! Add screenshots of the app’s UI here.*

## Prerequisites

- **Android Studio**: Version 2024.1.1 or later (e.g., Koala).
- **JDK**: Version 17 or later.
- **Android Device/Emulator**: API level 21 (Lollipop) or higher.
- **Git**: For cloning the repository.

## Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/BassH331/TaskManagerApp.git
   ```

2. **Open in Android Studio**:
   - Launch Android Studio.
   - Select **File > Open** and navigate to the cloned `TaskManagerApp` directory.

3. **Sync Project with Gradle**:
   - Ensure the following dependencies are in `app/build.gradle`:
     ```gradle
     implementation "androidx.core:core-ktx:1.13.1"
     implementation "androidx.appcompat:appcompat:1.7.0"
     implementation "com.google.android.material:material:1.12.0"
     implementation "androidx.constraintlayout:constraintlayout:2.1.4"
     implementation "androidx.navigation:navigation-fragment-ktx:2.7.7"
     implementation "androidx.navigation:navigation-ui-ktx:2.7.7"
     implementation "androidx.recyclerview:recyclerview:1.3.2"
     ```
   - Click **Sync Project with Gradle Files** in Android Studio.

4. **Build and Run**:
   - Connect an Android device or start an emulator.
   - Click **Run > Run 'app'** to build and install the app.

## Usage

1. **Launch the App**:
   - Open TaskManagerApp on your Android device.

2. **Navigate the App**:
   - Use the **bottom navigation bar** to switch between:
     - **Tasks**: View and manage your task list.
     - **Suggestions**: Explore suggested tasks.
     - **Settings**: Customize notification preferences.
   - Use the **navigation drawer** (swipe from the left or tap the hamburger icon) to access:
     - **Tasks**: Return to the task list.
     - **About**: View app information.

3. **Manage Tasks**:
   - **Add a Task**: Enter a task title in the input field and tap **Add** on the Tasks screen to navigate to the task creation screen.
   - **Search Tasks**: Use the search bar to filter tasks.
   - **Delete Completed Tasks**: Tap **Delete Completed** to remove completed tasks.
   - **Edit Tasks**: (Planned feature) Tap a task to edit its details.

4. **Customize Notifications**:
   - Go to the Settings screen to toggle notification preferences for reminders and deadlines.

## Project Structure

- **`app/src/main/java/com/example/taskmanagerapp/`**:
  - `MainActivity.kt`: Hosts the navigation graph and UI components (toolbar, bottom navigation, drawer).
  - `TaskListFragment.kt`: Manages the task list with a RecyclerView and task input.
  - `TaskEditFragment.kt`: Handles task creation and editing.
  - `TaskSuggestionsFragment.kt`: Displays suggested tasks.
  - `NotificationsSettingsFragment.kt`: Manages notification settings.
  - `AboutDocFragment.kt`: Shows app information.
  - `TaskAdapter.kt`: RecyclerView adapter for task items.

- **`app/src/main/res/layout/`**:
  - `activity_main.xml`: Main layout with DrawerLayout, Toolbar, NavHostFragment, and BottomNavigationView.
  - `task_list_fragment.xml`: Layout for the task list with search, input, and RecyclerView.
  - `task_edit_fragment.xml`: Layout for task creation/editing.
  - `task_suggestions_fragment.xml`: Layout for task suggestions.
  - `notifications_settings_fragment.xml`: Layout for notification settings.
  - `about_doc_fragment.xml`: Layout for the about page.
  - `task_item.xml`: Layout for individual task items in the RecyclerView.

- **`app/src/main/res/navigation/`**:
  - `nav_graph.xml`: Defines navigation between fragments.

- **`app/src/main/res/menu/`**:
  - `bottom_nav_menu.xml`: Menu for bottom navigation.
  - `nav_drawer_menu.xml`: Menu for the navigation drawer.

## Contributing

Contributions are welcome! To contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Make your changes and commit (`git commit -m "Add your feature"`).
4. Push to your branch (`git push origin feature/your-feature`).
5. Open a pull request on GitHub.

Please ensure your code follows the project’s coding standards and includes tests where applicable.

## Issues and Bug Reports

If you encounter bugs or issues:
- Check the [Issues](https://github.com/BassH331/TaskManagerApp/issues) page for existing reports.
- Open a new issue with a detailed description, including steps to reproduce and relevant logs.

## Roadmap

- Add task editing functionality in `TaskEditFragment`.
- Implement task categories or priorities.
- Add persistent storage (e.g., Room database) for tasks.
- Enhance task suggestions with machine learning.
- Improve UI with animations and transitions.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Built with [Android Jetpack](https://developer.android.com/jetpack) and [Material Design Components](https://m3.material.io/).
- Inspired by modern task management apps.

---

*Created by [BassH331](https://github.com/BassH331). Feel free to star the repository if you find it useful!*