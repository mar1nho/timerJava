import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinuteTimer extends JFrame {
    private JLabel label;
    private Timer timer;
    private int segundos;
    private int minutos;
    private int tempoTotal;

    public MinuteTimer() {
        super("Minute Timer");
        label = new JLabel("00:00");
        add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 100);
        setVisible(true);

        minutos = solicitarMinutos();
        tempoTotal = minutos * 60;
        segundos = 0;

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempoTotal--;
                segundos = tempoTotal % 60;
                minutos = tempoTotal / 60;
                if (tempoTotal < 0) {
                    timer.stop();
                    label.setText("Fim do tempo");
                } else {
                    String time = String.format("%02d:%02d", minutos, segundos);
                    label.setText(time);
                }
            }
        });
        timer.start();
    }

    private int solicitarMinutos() {
        String input = JOptionPane.showInputDialog(this, "Digite o número de minutos:", "Tempo", JOptionPane.QUESTION_MESSAGE);
        int minutos = Integer.parseInt(input);
        return minutos;
    }

    public static void main(String[] args) {
        new MinuteTimer();
    }
}
