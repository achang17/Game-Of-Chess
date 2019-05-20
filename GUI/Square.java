package GUI;

import Chess.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Square extends JPanel {

    private int row;
    private int col;
    public String iconPath;

    public Square(int row, int col) {
        super(new GridBagLayout());
        this.row = row;
        this.col = col;

        setPreferredSize(new Dimension(80,80));
        validate();

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse clicked on row: " + row + " col: " + col);
                ChessGameController.takePos(row, col);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //ChessGame.finishMove(xCoord, yCoord);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

    public void fillColor() {
        if ((this.row+this.col)%2 == 0) { //lighter square
            setBackground(new Color(255,204,156));//specify rows and cols for pieces

        } else { //darker square
            setBackground(new Color(219,138,58));
        }
    }

    private ImageIcon getImage(String path) {
        ImageIcon image = new ImageIcon(getClass().getResource(path));
        Image image_resized = image.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH); // scale it the smooth way
        return new ImageIcon(image_resized);  // transform it backJLabel label = new JLabel(image);
    }

    public void fillPiece(String path) {
        removeAll();
        revalidate();
        repaint();
        JLabel label = new JLabel(getImage(path));
        add(label);
        this.iconPath = path;
    }

    public void emptySquare() {
        System.out.println("in empty square");
        removeAll();
        revalidate();
        repaint();
    }
}
