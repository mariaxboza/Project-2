import MemoryGame.Pictures.Empty;

import javax.swing.*;

public class ImageList {
    // Class to create the pictures for the game
    private static ImageIcon pic1 = new ImageIcon(Empty.class.getResource("pic1.png"));
    private static ImageIcon pic2 = new ImageIcon(Empty.class.getResource("pic2.png"));
    private static ImageIcon pic3 = new ImageIcon(Empty.class.getResource("pic3.png"));
    private static ImageIcon pic4 = new ImageIcon(Empty.class.getResource("pic4.png"));
    private static ImageIcon pic5 = new ImageIcon(Empty.class.getResource("pic5.png"));
    private static ImageIcon pic6 = new ImageIcon(Empty.class.getResource("pic6.png"));
    private static ImageIcon pic7 = new ImageIcon(Empty.class.getResource("pic7.png"));
    private static ImageIcon pic8 = new ImageIcon(Empty.class.getResource("pic8.png"));

    // Array for all the pictures in the game
    private ImageIcon[] pics = {pic1, pic2, pic3, pic4 , pic5, pic6, pic7, pic8 , pic1, pic2,
                                pic3, pic4 , pic5, pic6, pic7, pic8};



    public ImageIcon[][] getPics() {   // Method to get the picture array 
        ImageIcon[][] pic = new ImageIcon[4][4];
        int x = (int)(Math.random() * 4) + 2;

        int i = 0;
        int j = 0;

        while (i < 16)
        {
            int k = 0;

            while( k < x )
            {
                int l = j % 16;
                int col = l % 4;
                int row = l / 4;

                if (pic[col][row] == null)
                {
                    k++;
                }

                if ( k < x )
                    j++;
            }

            int l = j % 16;
            int col = l % 4;
            int row = l / 4;

            if (pic[col][row] == null)
            {
                pic[col][row] = pics[i];
                i++;
                System.out.println(col + " " + row);
                System.out.println(i);
            }
            else
            {
                System.out.println("Error");
            }


        }

        return pic;}
}
