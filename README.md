# Tic-Tac-Toe Game with GUI in Java

This is a simple yet interactive **Tic-Tac-Toe Game** implemented in Java using the **Swing** library for the graphical user interface (GUI). It supports two players and features a clean design, clear turn indicators, and automatic game resets after completion.

---

## Features

- **Interactive GUI**: A 3x3 grid of buttons for playing the game.
- **Turn Indicator**: A dynamic display showing whose turn it is ("X's Turn" or "O's Turn").
- **Winner Detection**: Automatically detects and announces when a player wins.
- **Draw Handling**: Detects and announces a draw when the grid is full with no winner.
- **Automatic Reset**: Resets the game after a win or draw for continuous play.
- **Clean Layout**: Includes proper margins and spacing for an aesthetically pleasing design.

---

## How to Play

1. The game is played by two players, "X" and "O."
2. Players take turns clicking on the grid cells to place their mark.
3. The game declares a winner if one player gets three of their marks in a row, column, or diagonal.
4. If the grid is filled without a winner, the game declares a draw.
5. The game resets automatically after a win or draw.

---

## Installation and Setup

1. **Prerequisites**:
   - Java Development Kit (JDK) installed (version 8 or higher).
   - A code editor or IDE like IntelliJ IDEA, Eclipse, or Visual Studio Code (optional).

2. **Steps to Run**:
   - Download or clone this repository.
   - Save the source code file as `TicTacToeGame.java`.
   - Compile the program using the terminal or your IDE:
     ```bash
     javac TicTacToeGame.java
     ```
   - Run the program:
     ```bash
     java TicTacToeGame
     ```

3. The game window will open, and you can start playing immediately!

---

## Code Structure

- **Main Class**: `TicTacToeGame`
  - Initializes the GUI components and handles game logic.
  - Includes nested `ButtonClickListener` class for button interactions.
- **UI Components**:
  - `JFrame`: Main application window.
  - `JLabel`: Displays the current player's turn.
  - `JButton[][]`: Represents the 3x3 game grid.

---

## Screenshots

### Game Window
![Tic-Tac-Toe GUI](https://github.com/user-attachments/assets/2c952870-1e2a-4558-9901-d37b3e893866)


---

## Future Enhancements

- **Scoreboard**: Add a scoreboard to track wins for each player.
- **Player vs Computer**: Implement a mode to play against an AI opponent.
- **Custom Grid Sizes**: Allow players to select larger grid sizes (e.g., 4x4 or 5x5).

---

## License

This project is licensed under the MIT License. Feel free to use, modify, and distribute it as needed.

---

## Contributing

Contributions are welcome! If you'd like to improve the game or add features:
1. Fork the repository.
2. Make your changes.
3. Submit a pull request with a clear description of your modifications.

---

## Author

Developed by **Shrey Varshney**  
Contact: shreyvarshney1@gmail.com  
