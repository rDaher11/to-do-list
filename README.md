# To-Do List CLI Application

A simple command-line To-Do List application built in Java for managing tasks efficiently.

## Features
- Add, update, delete tasks
- Mark tasks as `TODO`, `IN_PROGRESS`, or `DONE`
- List tasks by status
- Save and load tasks from a JSON file
## important note
The core functionality is complete. Parser implementation and edge case handling are planned for future development.
## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/rDaher11/to-do-list.git
   cd to-do-list
   ```
2. Compile the project:
   ```sh
   javac -d out -sourcepath src src/Main.java
   ```
3. Run the application:
   ```sh
   java -cp out Main
   ```

## Usage
### Adding a Task
```sh
task-cli add "Buy groceries"
# Output: Task added successfully (ID: 1)
```

### Updating a Task
```sh
task-cli update 1 "Buy groceries and cook dinner"
```

### Deleting a Task
```sh
task-cli delete 1
```

### Marking Task Status
```sh
task-cli mark-in-progress 1
task-cli mark-done 1
```

### Listing Tasks
```sh
task-cli list       # List all tasks
task-cli list done # List completed tasks
```

## Contributing
Feel free to submit issues or pull requests to improve the app.

## License
This project is licensed under the MIT License.

