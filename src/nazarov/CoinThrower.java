package nazarov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CoinThrower {
    public static void main(String[] args) {
        ThrowerFrame frame = new ThrowerFrame();
        frame.setVisible(true);
        frame.setSize(300, 350);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }
}
class ThrowerFrame extends JFrame{
    public ThrowerFrame(){
        setTitle("Бросатель монетки");
        ThrowerPanel panel = new ThrowerPanel();
        add(panel);
    }
}
class ThrowerPanel extends JPanel {
    JButton start, top, heads, tails, countH, countT;
    JTextField count;
    JPanel north, center, south;
    Font countFont = new Font("TimesRoman", Font.BOLD, 100);
    Font buttonFont = new Font("Calibri", Font.PLAIN, 20);
    Font topFont = new Font("Calibri", Font.BOLD, 18);
    private int counter = 0;
    private int ch = 0;
    private int ct = 0;
    int [] mainInt = {1, 2};

    public ThrowerPanel(){
        ActionListener push = new Counter();
        setLayout(new BorderLayout());

        north = new JPanel();
        north.setLayout(new GridLayout(3,1));

        top = new JButton();
        top.setEnabled(false);
        top.setText("Сколько раз бросаем монетку?");
        top.setFont(topFont);
        north.add(top);

        count = new JTextField();
        count.setPreferredSize(new Dimension(150,50));
        count.setHorizontalAlignment(JTextField.CENTER);
        count.setFont(buttonFont);
        north.add(count);

        start = new JButton();
        start.setText("Подбросить");
        start.setFont(buttonFont);
        start.addActionListener(push);
        north.add(start);

        add(north, BorderLayout.NORTH);

        south = new JPanel();
        south.setPreferredSize(new Dimension(150, 50));
        south.setLayout(new GridLayout(1,1));

        heads = new JButton();
        heads.setEnabled(false);
        heads.setText("Орел");
        heads.setFont(buttonFont);
        heads.setBorderPainted(false);
        south.add(heads);

        tails = new JButton();
        tails.setEnabled(false);
        tails.setText("Решка");
        tails.setFont(buttonFont);
        tails.setBorderPainted(false);
        south.add(tails);

        add(south, BorderLayout.SOUTH);

        center = new JPanel();
        center.setLayout(new GridLayout(1,1));

        countH = new JButton();
        countH.setEnabled(false);
        countH.setText(String.valueOf(ch));
        countH.setFont(countFont);
        countH.setBorderPainted(false);
        center.add(countH);

        countT = new JButton();
        countT.setEnabled(false);
        countT.setText(String.valueOf(ct));
        countT.setFont(countFont);
        countT.setBorderPainted(false);
        center.add(countT);

        add(center, BorderLayout.CENTER);
    }
    public class Counter implements ActionListener{
        public void actionPerformed(ActionEvent e) {

            try {
            counter = Integer.parseInt(count.getText());
                if (e.getSource() == start) {
                    for (int i = 0; i < counter; i++) {
                        Random rand = new Random();
                        int result = mainInt[rand.nextInt(2)];
                        if (result == 1) ch++;
                        else ct++;
                    }
                }
            }
            catch (NumberFormatException aerr) {
                JOptionPane.showMessageDialog(null, "Введите число");
            }
                countH.setText(String.valueOf(ch));
                countT.setText(String.valueOf(ct));
                ch = ct = 0;
        }
    }
}


