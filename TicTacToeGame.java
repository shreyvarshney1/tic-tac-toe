import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGame {
    private JFrame frame;
    private JButton[][] buttons;
    private JLabel statusLabel; // Label to display the turn
    private boolean isXTurn; // To track whose turn it is (true for X, false for O)
    private int movesCount;  // To track the number of moves made

    public TicTacToeGame() {
        frame = new JFrame("Tic-Tac-Toe");
        frame.setSize(400, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttons = new JButton[3][3];
        isXTurn = true; // X always starts first
        movesCount = 0;

        initializeUI();

        frame.setVisible(true);
    }

    private void initializeUI() {
        // Main panel with BorderLayout
        frame.setLayout(new BorderLayout());

        // Status label at the top
        statusLabel = new JLabel("X's Turn", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 20));
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(statusLabel, BorderLayout.NORTH);

        // Panel for the buttons (game grid)
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(3, 3, 10, 10)); // 10px gap between buttons
        gridPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margins around the grid

        // Initialize buttons and add to the grid
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 60));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                gridPanel.add(buttons[i][j]);
            }
        }

        frame.add(gridPanel, BorderLayout.CENTER);
    }

    private class ButtonClickListener implements ActionListener {
        private int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!buttons[row][col].getText().equals("")) {
                // Ignore if the button is already clicked
                return;
            }

            // Set the button text to X or O based on the current turn
            buttons[row][col].setText(isXTurn ? "X" : "O");

            // Increment the move count
            movesCount++;

            // Check for a winner or a draw
            if (checkWinner(row, col)) {
                JOptionPane.showMessageDialog(frame, (isXTurn ? "X" : "O") + " wins!");
                resetGame();
                return;
            }

            if (movesCount == 9) {
                JOptionPane.showMessageDialog(frame, "It's a draw!");
                resetGame();
                return;
            }

            // Switch turn and update the status label
            isXTurn = !isXTurn;
            statusLabel.setText(isXTurn ? "X's Turn" : "O's Turn");
        }
    }

    private boolean checkWinner(int row, int col) {
        String symbol = isXTurn ? "X" : "O";

        // Check row
        if (buttons[row][0].getText().equals(symbol) &&
            buttons[row][1].getText().equals(symbol) &&
            buttons[row][2].getText().equals(symbol)) {
            return true;
        }

        // Check column
        if (buttons[0][col].getText().equals(symbol) &&
            buttons[1][col].getText().equals(symbol) &&
            buttons[2][col].getText().equals(symbol)) {
            return true;
        }

        // Check diagonal (top-left to bottom-right)
        if (row == col &&
            buttons[0][0].getText().equals(symbol) &&
            buttons[1][1].getText().equals(symbol) &&
            buttons[2][2].getText().equals(symbol)) {
            return true;
        }

        // Check diagonal (top-right to bottom-left)
        if (row + col == 2 &&
            buttons[0][2].getText().equals(symbol) &&
            buttons[1][1].getText().equals(symbol) &&
            buttons[2][0].getText().equals(symbol)) {
            return true;
        }

        return false;
    }

    private void resetGame() {
        // Reset the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }

        // Reset turn, moves count, and status label
        isXTurn = true;
        movesCount = 0;
        statusLabel.setText("X's Turn");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TicTacToeGame::new);
    }
}
