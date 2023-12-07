import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import Classes.Businessman;
import Classes.Local;
import Classes.Organization;
import Classes.Worker;


public class GUI {
    public static void main(String[] args) {

	}
}
class MyWindow{
    private JFrame frame = new JFrame("Businessmem");
    private Local store = new Local();
    private JPanel topPanel;
    private JPanel bottomPanelLeft;
    private JPanel bottomPanelRight;

    private Color COLOR_D7DAE0 = new Color(215,218,224);
    private Color COLOR_D6DFE6 = new Color(214,223,230);

    public MyWindow() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(350, 150, 700, 700);

        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(400, 200));
        topPanel.setLayout(new GridLayout(1, 0));

        bottomPanelLeft = new JPanel();
        bottomPanelLeft.setBackground(Color.lightGray);
        bottomPanelLeft.setLayout(new GridLayout(0, 1));

        bottomPanelRight = new JPanel();
        bottomPanelRight.setBackground(COLOR_D7DAE0);
        bottomPanelRight.setLayout(new GridLayout(0, 1));

        JButton organization = setButton("Organization");
        organization.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bottomPanelLeft.removeAll();
                bottomPanelRight.removeAll();
                JPanel scroll_panel = new JPanel();
                scroll_panel.setLayout(new GridLayout(0, 1));

                for (Organization i : store.getOrganization()) {
                    JButton button = setButton("" + i);
                    button.addActionListener((new ActionListener() {
                        public void actionPerformed(ActionEvent ev){
                            setText(i.info());
                        }
                    }));
                    scroll_panel.add(button);
                }
                JScrollPane scrollPane = new JScrollPane(scroll_panel);
                bottomPanelLeft.add(scrollPane);

                bottomPanelLeft.revalidate();
                bottomPanelLeft.repaint();

                bottomPanelRight.revalidate();
                bottomPanelRight.repaint();
                
                bottomPanelLeft.isVisible();
            }
        }));
        topPanel.add(organization);

        JButton businessman = setButton("Businessman");
        businessman.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bottomPanelLeft.removeAll();
                bottomPanelRight.removeAll();
                JPanel scroll_panel = new JPanel();
                scroll_panel.setLayout(new GridLayout(0, 1));

                for (Businessman i : store.getBusinessman()) {
                    JButton button = setButton("" + i);
                    button.addActionListener((new ActionListener() {
                        public void actionPerformed(ActionEvent ev){
                            setText(i.info());
                        }
                    }));
                    scroll_panel.add(button);
                }
                JScrollPane scrollPane = new JScrollPane(scroll_panel);
                bottomPanelLeft.add(scrollPane);

                bottomPanelLeft.revalidate();
                bottomPanelLeft.repaint();

                bottomPanelRight.revalidate();
                bottomPanelRight.repaint();
                
                bottomPanelLeft.isVisible();
            }
        }));
        topPanel.add(businessman);

        JButton worker = setButton("Worker");
        worker.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bottomPanelLeft.removeAll();
                bottomPanelRight.removeAll();
                JPanel scroll_panel = new JPanel();
                scroll_panel.setLayout(new GridLayout(0, 1));

                for (Worker i : store.getWorker()) {
                    JButton button = setButton("" + i);
                    button.addActionListener((new ActionListener() {
                        public void actionPerformed(ActionEvent ev){
                            setText(i.info());
                        }
                    }));
                    scroll_panel.add(button);
                }
                JScrollPane scrollPane = new JScrollPane(scroll_panel);
                bottomPanelLeft.add(scrollPane);

                bottomPanelLeft.revalidate();
                bottomPanelLeft.repaint();

                bottomPanelRight.revalidate();
                bottomPanelRight.repaint();

                bottomPanelLeft.isVisible();
            }
        }));
        topPanel.add(worker);

        JSplitPane splitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, bottomPanelLeft, bottomPanelRight);
        splitPanel.setDividerLocation(150);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(splitPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private JButton setButton(String bt_name){
        JButton button = new JButton(bt_name);
        button.setBorder(BorderFactory.createLineBorder(Color.lightGray, 10));
        button.setBackground(COLOR_D6DFE6);
        return button;
    }

    private void setText(Map<String, String> info){
        bottomPanelRight.removeAll();

        JTextArea text_info = new JTextArea();
        text_info.setOpaque(false);

        JPanel scroll_panel = new JPanel();
        scroll_panel.setOpaque(false);
        scroll_panel.setLayout(new GridLayout(0, 1));
        
        String texString = "";

        for (String key: info.keySet()){
            texString += String.format("[%s]: %s\n", key, info.get(key).replaceAll("[\\[\\]]", "").replaceAll("[,]", "\n\t"));
        }

        text_info.setText(texString);
        scroll_panel.add(text_info);

        JScrollPane scrollPane = new JScrollPane(scroll_panel);
        scrollPane.getViewport().setOpaque(false); // Делает прозрачным поле отображения у JScrollPane.
        scrollPane.setBackground(COLOR_D7DAE0);
        scrollPane.setBorder(BorderFactory.createLineBorder(COLOR_D7DAE0, 10));

        bottomPanelRight.add(scrollPane);
        bottomPanelRight.revalidate();
        bottomPanelRight.repaint();
        bottomPanelRight.isVisible();
    }

    public void putStore(Local store){
        this.store = store;
    }
}
