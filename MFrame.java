import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MFrame extends JFrame { // Class to create the game

    private ImageList images = new ImageList();
    private JPanel panel4Pic = new JPanel(new GridLayout(4,4));

    private  int count = 0;
    private  int[] opens = new int[2];


    JButton[][] buttons = new JButton[4][4];

    public MFrame()
    { // Constuctor for the frame of the game
        super("Memory");
        this.setLayout(null);
        this.setSize(1000,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel4Pic.setBounds(0,0,1000,800);
        createButtons();
        this.add(panel4Pic);

        this.setResizable(false);
        this.setVisible(true);
    }

    private boolean CompareOpens()
    { // Method to create the buttons open
        int r = opens[0] / 4;
        int c = opens[0] % 4;

        int r1 = opens[1] / 4;
        int c1 = opens[1] % 4;

        return buttons[r][c].getIcon() == buttons[r1][c1].getIcon();
    }

    public void createButtons()
    { // Method to create the game buttons which will be the ones to choose
        ImageIcon[][] pics = images.getPics();

        for(int r = 0; r < 4; r++)
        {
            for(int c = 0; c < 4; c++)
            {
                buttons[r][c] = new JButton();
                buttons[r][c].setName( String.valueOf(r * 4 + c) );
                panel4Pic.add(buttons[r][c]);
                buttons[r][c].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        JButton button = (JButton)e.getSource();

                        if ( button.getIcon() == null ) {
                            int l = Integer.parseInt(button.getName());
                            int r = l / 4;
                            int c = l % 4;

                            button.setIcon(pics[r][c]);

                            if ( count == 2 )
                            {
                                count = 0;

                                for ( int i = 0; i < 2; i++)
                                {
                                    r = opens[i] / 4;
                                    c = opens[i] % 4;

                                    buttons[r][c].setIcon(null);
                                }

                                opens[count] = l;
                                count++;
                            }
                            else
                            {
                                opens[count] = l;
                                count++;

                                if ( count == 2) {
                                    if (CompareOpens())
                                        count = 0;
                                }
                            }


                        }

                    }
                });
            }
        }


    }


}
