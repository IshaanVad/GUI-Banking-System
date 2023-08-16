import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JPanel {
    private static final int RECT_W = 90;
    private static final int RECT_H = 70;
    private static final int PREF_W = 600;
    private static final int PREF_H = 300;
    private static final Color DRAW_RECT_COLOR = Color.black;
    private static final Color DRAG_RECT_COLOR = new Color(180, 200, 255);
    private Rectangle rect = new Rectangle(25, 25, RECT_W, RECT_H);
    private boolean dragging = false;
    private int deltaX = 0;
    private int deltaY = 0;

    public GUI() {
        MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
        addMouseListener(myMouseAdapter);
        addMouseMotionListener(myMouseAdapter);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (rect != null) {
            Color c = dragging ? DRAG_RECT_COLOR : DRAW_RECT_COLOR;
            g.setColor(c);
            Graphics2D g2 = (Graphics2D) g;
            g2.draw(rect);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    private class MyMouseAdapter extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            Point mousePoint = e.getPoint();
            if (rect.contains(mousePoint)) {
                dragging = true;
                deltaX = rect.x - mousePoint.x;
                deltaY = rect.y - mousePoint.y;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            dragging = false;
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            Point p2 = e.getPoint();
            if (dragging) {
                int x = p2.x + deltaX;
                int y = p2.y + deltaY;
                rect = new Rectangle(x, y, RECT_W, RECT_H);
                GUI.this.repaint();
            }
        }
    }

    private static void createAndShowGui() {
        GUI mainPanel = new GUI();

        JFrame frame = new JFrame("GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}