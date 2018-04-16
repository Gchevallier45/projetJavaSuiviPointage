package guillaume.projet.java.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainWindow extends JFrame {
	public MainWindow() {
        initUI();
    }

    private void initUI() {
        setTitle("Pointeuse");
        
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.addTab("yolo", null);
        tabbedPane.addTab("yolo111", null);
        /*String titles[] = { "A", "B", "C", "D", "E", "F" };
        for (int i = 0, n = titles.length; i < n; i++) {
          add(tabbedPane, titles[i]);
        }*/

        add(tabbedPane, BorderLayout.CENTER);
        
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
        setVisible(true);
    }

    /*public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            SimpleEx ex = new SimpleEx();
            ex.setVisible(true);
        });
    }*/
}
