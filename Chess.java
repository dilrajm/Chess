//Name: Dilraj Mukkar
//Date: Starting Date: 12/22/2016 Ending Date: 1/20/2017
//Purpose: To learn more about arrays, and how they function on a more complex level

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
public class Chess extends Applet implements ActionListener
{
    Panel p_card;  //to hold all of the screens
    Panel card1, card2, card3;
    CardLayout cdLayout = new CardLayout ();
    char turn = 'w';
    int last = -1;
    JLabel whoseTurn;

    //grid 8 by 8
    int row = 8;
    int col = 8;
    JButton a[] = new JButton [row * col];

    //piece array
    char piece[] [] = {{'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'},
	    {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
	    {'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'}};

    //background array
    char bg[] [] = {{'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
	    {'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'},
	    {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
	    {'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'},
	    {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
	    {'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'},
	    {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
	    {'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'}};

    //piece array
    char sel[] [] = {{'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
	    {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
	    {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
	    {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
	    {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
	    {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
	    {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
	    {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}};

    //colour array
    char colour[] [] = {{'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'},
	    {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    //array for reset
    char r1[] [] = {{'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'},
	    {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
	    {'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'}};

    //array for reset
    char r2[] [] = {{'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
	    {'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'},
	    {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
	    {'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'},
	    {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
	    {'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'},
	    {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
	    {'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'}};

    //array for reset
    char r3[] [] = {{'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
	    {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
	    {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
	    {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
	    {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
	    {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
	    {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
	    {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}};

    //array for reset
    char r4[] [] = {{'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'},
	    {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    public void init ()
    {
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	screen1 ();
	screen2 ();
	screen3 ();
	resize (1020, 680);
	setLayout (new BorderLayout ());
	add ("Center", p_card);
    }


    public void screen1 ()
    { //screen 1 is set up.
	card1 = new Panel ();
	setLayout (new BorderLayout ());
	JLabel wallpaper = new JLabel (createImageIcon ("chesswallpaper.jpg"));

	JButton chessbutton = new JButton (createImageIcon ("chessbutton.jpg"));
	chessbutton.setPreferredSize (new Dimension (235, 114));
	chessbutton.setActionCommand ("s2");
	chessbutton.addActionListener (this);

	card1.add (chessbutton);
	card1.add (wallpaper);
	p_card.add ("1", card1);
    }


    public void screen2 ()
    { //screen 2 is set up.
	card2 = new Panel (new BorderLayout ());
	card2.setBackground (new Color (94, 33, 33));

	JLabel instructions = new JLabel (createImageIcon ("instructions.jpg"));

	JButton gamescreen = new JButton (createImageIcon ("gamescreenS2.jpg"));
	gamescreen.setActionCommand ("s3");
	gamescreen.addActionListener (this);
	gamescreen.setPreferredSize (new Dimension (505, 150));

	JButton backtohomepage = new JButton (createImageIcon ("backtohomepageS2.jpg"));
	backtohomepage.setPreferredSize (new Dimension (505, 150));
	backtohomepage.setActionCommand ("s1");
	backtohomepage.addActionListener (this);

	Panel p = new Panel ();
	p.add (backtohomepage);
	p.add (gamescreen);

	card2.add ("Center", instructions);
	card2.add ("South", p);


	p_card.add ("2", card2);
    }


    public void screen3 ()
    { //screen 3 is set up.
	card3 = new Panel (new BorderLayout ());
	card3.setBackground (new Color (94, 33, 33));

	JLabel chesslabel = new JLabel (createImageIcon ("chessbutton.jpg"));

	whoseTurn = new JLabel ("" + turn);

	JButton reset = new JButton (createImageIcon ("reset.jpg"));
	reset.setBackground (new Color (94, 33, 33));
	reset.setPreferredSize (new Dimension (80, 80));
	reset.setActionCommand ("reset");
	reset.addActionListener (this);

	JButton backtohomepage = new JButton (createImageIcon ("backtohomepage.jpg"));
	backtohomepage.setPreferredSize (new Dimension (205, 76));
	backtohomepage.setActionCommand ("s1");
	backtohomepage.addActionListener (this);

	JButton instructions1 = new JButton (createImageIcon ("instructions1.jpg"));
	instructions1.setActionCommand ("s2");
	instructions1.addActionListener (this);
	instructions1.setPreferredSize (new Dimension (205, 76));

	JButton check = new JButton ("Check");
	check.setFont (new Font ("Calibri", Font.BOLD, 15));
	check.setForeground (new Color (25, 25, 112));
	check.setBackground (new Color (244, 164, 96));
	check.setActionCommand ("check");
	check.addActionListener (this);
	check.setPreferredSize (new Dimension (100, 30));

	JButton unselected = new JButton ("Unselected");
	unselected.setFont (new Font ("Calibri", Font.BOLD, 15));
	unselected.setForeground (new Color (25, 25, 112));
	unselected.setBackground (new Color (244, 164, 96));
	unselected.setActionCommand ("unselected");
	unselected.addActionListener (this);
	unselected.setPreferredSize (new Dimension (110, 30));

	JButton findking = new JButton ("Find King");
	findking.setFont (new Font ("Calibri", Font.BOLD, 15));
	findking.setForeground (new Color (25, 25, 112));
	findking.setBackground (new Color (244, 164, 96));
	findking.setActionCommand ("findking");
	findking.addActionListener (this);
	findking.setPreferredSize (new Dimension (100, 30));

	//This button is to be coded after 1/20/2016,
	//plan is to make one of the buttons dissappear if its not their turn.
	JButton white = new JButton ("White's Turn");
	white.setFont (new Font ("Calibri", Font.BOLD, 15));
	white.setForeground (new Color (139, 69, 19));
	white.setBackground (new Color (255, 228, 181));
	white.setPreferredSize (new Dimension (100, 30));
	white.setActionCommand ("white");
	white.addActionListener (this);

	//same with this once, just ignore them
	JButton black = new JButton ("Black's Turn");
	black.setFont (new Font ("Calibri", Font.BOLD, 15));
	black.setForeground (new Color (255, 250, 205));
	black.setBackground (new Color (139, 69, 19));
	black.setPreferredSize (new Dimension (100, 30));
	black.setActionCommand ("black");
	black.addActionListener (this);

	//Grid is transfered onto the screen
	Panel p = new Panel (new GridLayout (row, col));
	int move = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		//Converts all char letters in array, into jpg, so computer can get the images
		a [move] = new JButton (createImageIcon ("" + piece [i] [j] + colour [i] [j] + bg [i] [j] + sel [i] [j] + ".jpg"));
		a [move].setPreferredSize (new Dimension (57, 57));
		a [move].addActionListener (this);
		a [move].setActionCommand ("" + move);
		p.add (a [move]);
		move++;
	    }
	}

	Panel p3 = new Panel ();
	p3.add (p);

	Panel p1 = new Panel ();
	p1.add (backtohomepage);
	p1.add (reset);
	p1.add (instructions1);

	Panel p2 = new Panel ();
	p2.add (check);
	p2.add (unselected);
	p2.add (findking);

	Panel p4 = new Panel ();
	p4.add (black);
	p4.add (white);
	p4.add (whoseTurn);

	card3.add ("North", chesslabel);
	card3.add ("East", p4);
	card3.add ("Center", p3);
	card3.add ("South", p1);
	card3.add ("West", p2);


	p_card.add ("3", card3);
	redraw ();
    }


    protected static ImageIcon createImageIcon (String path)
    {
	java.net.URL imgURL = Chess.class.getResource (path);
	if (imgURL != null)
	{
	    return new ImageIcon (imgURL);
	}
	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }


    public void reset ()
    {
	//to reset the screen
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		piece [i] [j] = r1 [i] [j];
		bg [i] [j] = r2 [i] [j];
		sel [i] [j] = r3 [i] [j];
		colour [i] [j] = r4 [i] [j];
	    }
	}
	redraw ();
    }


    public void redraw ()
    {
	//to redraw the screen
	int move = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		a [move].setIcon (createImageIcon ("" + piece [i] [j] + colour [i] [j] + bg [i] [j] + sel [i] [j] + ".jpg"));
		move++;
	    }
	}
    }


    public void checkblack ()
    {
	//if the black king is in check
	char oldturn = turn;
	turn = 'w';
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		if (colour [i] [j] == 'w')
		{
		    if (piece [i] [j] == 'p')
			selectPawn (i, j);

		    if (piece [i] [j] == 'n')
			selectKnight (i, j);

		    if (piece [i] [j] == 'r')
			selectRook (i, j);

		    if (piece [i] [j] == 'b')
			selectBishop (i, j);

		    if (piece [i] [j] == 'q')
			selectQueen (i, j);

		    if (piece [i] [j] == 'k')
			selectKing (i, j);

		}
	    }
	}

	int kingx = 0;
	int kingy = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		if (piece [i] [j] == 'k' && colour [i] [j] == 'b')
		{
		    kingx = i;
		    kingy = j;

		}
	    }
	}

	int places = 0;
	//up left
	if (kingx - 1 >= 0 && kingy - 1 >= 0 && colour [kingx - 1] [kingy - 1] == 'b' && sel [kingx - 1] [kingy - 1] != 's')
	    places++;

	//up
	if (kingx - 1 >= 0 && colour [kingx - 1] [kingy] == 'b' && sel [kingx - 1] [kingy] != 's')
	    places++;

	//up right
	if (kingx - 1 >= 0 && kingy + 1 <= 7 && colour [kingx - 1] [kingy + 1] == 'b' && sel [kingx - 1] [kingy + 1] != 's')
	    places++;

	//right
	if (kingy + 1 <= 7 && colour [kingx] [kingy + 1] == 'b' && sel [kingx] [kingy + 1] != 's')
	    places++;

	//down right
	if (kingx + 1 <= 7 && kingy + 1 <= 7 && colour [kingx + 1] [kingy + 1] == 'b' && sel [kingx + 1] [kingy + 1] != 's')
	    places++;

	//down
	if (kingx + 1 <= 7 && colour [kingx + 1] [kingy] == 'b' && sel [kingx + 1] [kingy] != 's')
	    places++;

	//down left
	if (kingx + 1 <= 7 && kingy - 1 >= 0 && colour [kingx + 1] [kingy - 1] == 'b' && sel [kingx + 1] [kingy - 1] != 's')
	    places++;

	//left
	if (kingy - 1 >= 0 && colour [kingx] [kingy - 1] == 'b' && sel [kingx] [kingy - 1] != 's')
	    places++;

	//checkmate
	if (sel [kingx] [kingy] == 's' && places == 0)
	    showStatus ("Checkmate");

	//check
	if (sel [kingx] [kingy] == 's')
	{
	    //Show a warning dialog with the options OK, CANCEL, title 'Warning',
	    // and message 'Click OK to continue':
	    Object[] options = {"OK"};
	    JOptionPane.showOptionDialog (null, "The Black King is in check", "Warning",
		    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
		    null, options, options [0]);
	}
	turn = oldturn;
    }


    public void checkwhite ()
    {
	//if white king is in check
	char oldturn = turn;
	turn = 'b';
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		if (colour [i] [j] == 'b')
		{
		    if (piece [i] [j] == 'p')
			selectPawn (i, j);

		    if (piece [i] [j] == 'n')
			selectKnight (i, j);

		    if (piece [i] [j] == 'r')
			selectRook (i, j);

		    if (piece [i] [j] == 'b')
			selectBishop (i, j);

		    if (piece [i] [j] == 'q')
			selectQueen (i, j);

		    if (piece [i] [j] == 'k')
			selectKing (i, j);

		}
	    }
	}

	int kingx = 0;
	int kingy = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		if (piece [i] [j] == 'k' && colour [i] [j] == 'w')
		{
		    kingx = i;
		    kingy = j;

		}
	    }
	}

	int places = 0;
	//up left
	if (kingx - 1 >= 0 && kingy - 1 >= 0 && colour [kingx - 1] [kingy - 1] == 'w' && sel [kingx - 1] [kingy - 1] != 's')
	    places++;

	//up
	if (kingx - 1 >= 0 && colour [kingx - 1] [kingy] == 'w' && sel [kingx - 1] [kingy] != 's')
	    places++;

	//up right
	if (kingx - 1 >= 0 && kingy + 1 <= 7 && colour [kingx - 1] [kingy + 1] == 'w' && sel [kingx - 1] [kingy + 1] != 's')
	    places++;

	//right
	if (kingy + 1 <= 7 && colour [kingx] [kingy + 1] == 'w' && sel [kingx] [kingy + 1] != 's')
	    places++;

	//down right
	if (kingx + 1 <= 7 && kingy + 1 <= 7 && colour [kingx + 1] [kingy + 1] == 'w' && sel [kingx + 1] [kingy + 1] != 's')
	    places++;

	//down
	if (kingx + 1 <= 7 && colour [kingx + 1] [kingy] == 'w' && sel [kingx + 1] [kingy] != 's')
	    places++;

	//down left
	if (kingx + 1 <= 7 && kingy - 1 >= 0 && colour [kingx + 1] [kingy - 1] == 'w' && sel [kingx + 1] [kingy - 1] != 's')
	    places++;

	//left
	if (kingy - 1 >= 0 && colour [kingx] [kingy - 1] == 'w' && sel [kingx] [kingy - 1] != 's')
	    places++;

	//checkmate
	if (sel [kingx] [kingy] == 's' && places == 0)
	    showStatus ("Checkmate");

	//check
	if (sel [kingx] [kingy] == 's')
	{
	    //Show a warning dialog with the options OK, CANCEL, title 'Warning',
	    // and message 'Click OK to continue':
	    Object[] options = {"OK"};
	    JOptionPane.showOptionDialog (null, "The White King is in check", "Warning",
		    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
		    null, options, options [0]);
	}
	turn = oldturn;
    }


    public void unselected ()
    {
	//loop to set all to unselected, was used for testing
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		sel [i] [j] = 'u';
	    }
	}
    }


    public void findking ()
    {
	//gives the coordinates of the black or white king depending on turn
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		if (piece [i] [j] == 'k' && colour [i] [j] == turn)
		{
		    showStatus ("(" + i + ", " + j + ")");

		}
	    }
	}
    }


    public void selectKnight (int x, int y)
    {
	//code for knight
	if (x - 2 >= 0 && y - 1 >= 0 && colour [x - 2] [y - 1] != turn)
	    sel [x - 2] [y - 1] = 's';

	if (x - 2 >= 0 && y + 1 <= 7 && colour [x - 2] [y + 1] != turn)
	    sel [x - 2] [y + 1] = 's';

	if (x + 2 <= 7 && y - 1 >= 0 && colour [x + 2] [y - 1] != turn)
	    sel [x + 2] [y - 1] = 's';

	if (x + 2 <= 7 && y + 1 <= 7 && colour [x + 2] [y + 1] != turn)
	    sel [x + 2] [y + 1] = 's';

	if (x + 1 <= 7 && y - 2 >= 0 && colour [x + 1] [y - 2] != turn)
	    sel [x + 1] [y - 2] = 's';

	if (x + 1 <= 7 && y + 2 <= 7 && colour [x + 1] [y + 2] != turn)
	    sel [x + 1] [y + 2] = 's';

	if (x - 1 >= 0 && y - 2 >= 0 && colour [x - 1] [y - 2] != turn)
	    sel [x - 1] [y - 2] = 's';

	if (x - 1 >= 0 && y + 2 <= 7 && colour [x - 1] [y + 2] != turn)
	    sel [x - 1] [y + 2] = 's';
    }


    public void selectRook (int x, int y)
    {
	//code for rook
	//can go down
	if (x + 1 <= 7 && colour [x + 1] [y] != colour [x] [y])
	{
	    int move = x + 1;
	    while (move <= 7 && colour [move] [y] == 'x')
	    {
		sel [move] [y] = 's';
		move++;
	    }
	    if (move <= 7 && colour [move] [y] != turn)
		sel [move] [y] = 's';
	}

	//can go up
	if (x - 1 >= 0 && colour [x - 1] [y] != colour [x] [y])
	{
	    int move = x - 1;
	    while (move >= 0 && colour [move] [y] == 'x')
	    {
		sel [move] [y] = 's';
		move--;
	    }
	    if (move >= 0 && colour [move] [y] != turn)
		sel [move] [y] = 's';
	}

	//can go left
	if (y - 1 >= 0 && colour [x] [y - 1] != colour [x] [y])
	{
	    int move = y - 1;
	    while (move >= 0 && colour [x] [move] == 'x')
	    {
		sel [x] [move] = 's';
		move--;
	    }
	    if (move >= 0 && colour [x] [move] != turn)
		sel [x] [move] = 's';
	}

	//can go right
	if (y + 1 <= 7 && colour [x] [y + 1] != colour [x] [y])
	{
	    int move = y + 1;
	    while (move <= 7 && colour [x] [move] == 'x')
	    {
		sel [x] [move] = 's';
		move++;
	    }
	    if (move <= 7 && colour [x] [move] != turn)
		sel [x] [move] = 's';
	}
    }


    public void selectQueen (int x, int y)
    {
	//code for queen
	//can go top left
	if (x - 1 >= 0 && y - 1 >= 0 && colour [x - 1] [y - 1] != colour [x] [y])
	{
	    int up = x - 1;
	    int left = y - 1;
	    while (up >= 0 && left >= 0 && colour [up] [left] == 'x')
	    {
		sel [up] [left] = 's';
		up--;
		left--;
	    }
	    if (up >= 0 && left >= 0 && colour [up] [left] != turn)
		sel [up] [left] = 's';
	}

	//can go up
	if (x - 1 >= 0 && colour [x - 1] [y] != colour [x] [y])
	{
	    int move = x - 1;
	    while (move >= 0 && colour [move] [y] == 'x')
	    {
		sel [move] [y] = 's';
		move--;
	    }
	    if (move >= 0 && colour [move] [y] != turn)
		sel [move] [y] = 's';
	}

	//can go top right
	if (x - 1 >= 0 && y + 1 <= 7 && colour [x - 1] [y + 1] != colour [x] [y])
	{
	    int up = x - 1;
	    int right = y + 1;
	    while (up >= 0 && right <= 7 && colour [up] [right] == 'x')
	    {
		sel [up] [right] = 's';
		up--;
		right++;
	    }
	    if (up >= 0 && right <= 7 && colour [up] [right] != turn)
		sel [up] [right] = 's';
	}

	//can go right
	if (y + 1 <= 7 && colour [x] [y + 1] != colour [x] [y])
	{
	    int move = y + 1;
	    while (move <= 7 && colour [x] [move] == 'x')
	    {
		sel [x] [move] = 's';
		move++;
	    }
	    if (move <= 7 && colour [x] [move] != turn)
		sel [x] [move] = 's';
	}

	//can go down right
	if (x + 1 <= 7 && y + 1 <= 7 && colour [x + 1] [y + 1] != colour [x] [y])
	{
	    int down = x + 1;
	    int right = y + 1;
	    while (down <= 7 && right <= 7 && colour [down] [right] == 'x')
	    {
		sel [down] [right] = 's';
		down++;
		right++;
	    }
	    if (down <= 7 && right <= 7 && colour [down] [right] != turn)
		sel [down] [right] = 's';
	}

	//can go down
	if (x + 1 <= 7 && colour [x + 1] [y] != colour [x] [y])
	{
	    int move = x + 1;
	    while (move <= 7 && colour [move] [y] == 'x')
	    {
		sel [move] [y] = 's';
		move++;
	    }
	    if (move <= 7 && colour [move] [y] != turn)
		sel [move] [y] = 's';
	}

	//can go down left
	if (x + 1 <= 7 && y - 1 >= 0 && colour [x + 1] [y - 1] != colour [x] [y])
	{
	    int down = x + 1;
	    int left = y - 1;
	    while (down <= 7 && left >= 0 && colour [down] [left] == 'x')
	    {
		sel [down] [left] = 's';
		down++;
		left--;
	    }
	    if (down <= 7 && left >= 0 && colour [down] [left] != turn)
		sel [down] [left] = 's';
	}

	//can go left
	if (y - 1 >= 0 && colour [x] [y - 1] != colour [x] [y])
	{
	    int move = y - 1;
	    while (move >= 0 && colour [x] [move] == 'x')
	    {
		sel [x] [move] = 's';
		move--;
	    }
	    if (move >= 0 && colour [x] [move] != turn)
		sel [x] [move] = 's';
	}
    }


    public void selectBishop (int x, int y)
    {
	//code for bishop
	//can go top left
	if (x - 1 >= 0 && y - 1 >= 0 && colour [x - 1] [y - 1] != colour [x] [y])
	{
	    int up = x - 1;
	    int left = y - 1;
	    while (up >= 0 && left >= 0 && colour [up] [left] == 'x')
	    {
		sel [up] [left] = 's';
		up--;
		left--;
	    }
	    if (up >= 0 && left >= 0 && colour [up] [left] != turn)
		sel [up] [left] = 's';
	}

	//can go top right
	if (x - 1 >= 0 && y + 1 <= 7 && colour [x - 1] [y + 1] != colour [x] [y])
	{
	    int up = x - 1;
	    int right = y + 1;
	    while (up >= 0 && right <= 7 && colour [up] [right] == 'x')
	    {
		sel [up] [right] = 's';
		up--;
		right++;
	    }
	    if (up >= 0 && right <= 7 && colour [up] [right] != turn)
		sel [up] [right] = 's';
	}

	//can go down left
	if (x + 1 <= 7 && y - 1 >= 0 && colour [x + 1] [y - 1] != colour [x] [y])
	{
	    int down = x + 1;
	    int left = y - 1;
	    while (down <= 7 && left >= 0 && colour [down] [left] == 'x')
	    {
		sel [down] [left] = 's';
		down++;
		left--;
	    }
	    if (down <= 7 && left >= 0 && colour [down] [left] != turn)
		sel [down] [left] = 's';
	}

	//can go down right
	if (x + 1 <= 7 && y + 1 <= 7 && colour [x + 1] [y + 1] != colour [x] [y])
	{
	    int down = x + 1;
	    int right = y + 1;
	    while (down <= 7 && right <= 7 && colour [down] [right] == 'x')
	    {
		sel [down] [right] = 's';
		down++;
		right++;
	    }
	    if (down <= 7 && right <= 7 && colour [down] [right] != turn)
		sel [down] [right] = 's';
	}
    }


    public void selectKing (int x, int y)
    {
	//code for king
	//up left
	if (x - 1 >= 0 && y - 1 >= 0 && colour [x - 1] [y - 1] != turn)
	    sel [x - 1] [y - 1] = 's';

	//up
	if (x - 1 >= 0 && colour [x - 1] [y] != turn)
	    sel [x - 1] [y] = 's';

	//up right
	if (x - 1 >= 0 && y + 1 <= 7 && colour [x - 1] [y + 1] != turn)
	    sel [x - 1] [y + 1] = 's';

	//right
	if (y + 1 <= 7 && colour [x] [y + 1] != turn)
	    sel [x] [y + 1] = 's';

	//down right
	if (x + 1 <= 7 && y + 1 <= 7 && colour [x + 1] [y + 1] != turn)
	    sel [x + 1] [y + 1] = 's';

	//down
	if (x + 1 <= 7 && colour [x + 1] [y] != turn)
	    sel [x + 1] [y] = 's';

	//down left
	if (x + 1 <= 7 && y - 1 >= 0 && colour [x + 1] [y - 1] != turn)
	    sel [x + 1] [y - 1] = 's';

	//left
	if (y - 1 >= 0 && colour [x] [y - 1] != turn)
	    sel [x] [y - 1] = 's';
    }


    public void selectPawn (int x, int y)
    {
	//black pawn
	if (piece [x] [y] == 'p' && colour [x] [y] == 'b')
	{
	    if (x == 1 && colour [x + 2] [y] != 'b')
	    {
		sel [x + 2] [y] = 's';
		sel [x + 1] [y] = 's';
	    }
	    //down left
	    if (x + 1 <= 7 && y - 1 >= 0 && colour [x + 1] [y - 1] == 'w')
		sel [x + 1] [y - 1] = 's';

	    //down right
	    if (x + 1 <= 7 && y + 1 <= 7 && colour [x + 1] [y + 1] == 'w')
		sel [x + 1] [y + 1] = 's';

	    if (x + 1 <= 7 && colour [x + 1] [y] != 0)
		sel [x + 1] [y] = 's';

	    //where it cant go
	    if (x + 1 <= 7 && colour [x + 1] [y] == 'w')
		sel [x + 1] [y] = 'u';

	    if (x + 1 <= 7 && colour [x + 1] [y] == 'b')
		sel [x + 1] [y] = 'u';
	}

	//swapping from pawn to any piece when reached end zone
	if (piece [x] [y] == 'p' && colour [x] [y] == 'b')
	{
	    if (x == 7)
	    {
		//Show a dialog asking the user to select from a combobox:
		String[] possibleValues = {"Queen", "Bishop", "Knight", "Rook"};
		String selectedValue = (String) JOptionPane.showInputDialog (null,
			"Choose one", "Input", JOptionPane.INFORMATION_MESSAGE, null,
			possibleValues, possibleValues [0]);

		if (selectedValue.equals ("Queen"))
		    piece [x] [y] = 'q';

		if (selectedValue.equals ("Bishop"))
		    piece [x] [y] = 'b';

		if (selectedValue.equals ("Knight"))
		    piece [x] [y] = 'n';

		if (selectedValue.equals ("Rook"))
		    piece [x] [y] = 'r';
	    }
	}

	//white pawn
	if (piece [x] [y] == 'p' && colour [x] [y] == 'w')
	{
	    if (x == 6 && colour [x - 2] [y] != 'w')
	    {
		sel [x - 2] [y] = 's';
		sel [x - 1] [y] = 's';

	    }
	    //top right
	    if (x - 1 >= 0 && y + 1 <= 7 && colour [x - 1] [y + 1] == 'b')
		sel [x - 1] [y + 1] = 's';

	    //top left
	    if (x - 1 >= 0 && y - 1 >= 0 && colour [x - 1] [y - 1] == 'b')
		sel [x - 1] [y - 1] = 's';

	    if (x - 1 >= 0 && colour [x - 1] [y] != 0)
		sel [x - 1] [y] = 's';

	    //where it cant go
	    if (x - 1 >= 0 && colour [x - 1] [y] == 'b')
		sel [x - 1] [y] = 'u';

	    if (x - 1 >= 0 && colour [x - 1] [y] == 'w')
		sel [x - 1] [y] = 'u';
	}

	//swapping from pawn to any piece when reached end zone
	if (piece [x] [y] == 'p' && colour [x] [y] == 'w')
	{
	    if (x == 0)
	    {
		//Show a dialog asking the user to select from a combobox:
		String[] possibleValues = {"Queen", "Bishop", "Knight", "Rook"};
		String selectedValue = (String) JOptionPane.showInputDialog (null,
			"Choose one", "Input", JOptionPane.INFORMATION_MESSAGE, null,
			possibleValues, possibleValues [0]);

		if (selectedValue.equals ("Queen"))
		    piece [x] [y] = 'q';

		if (selectedValue.equals ("Bishop"))
		    piece [x] [y] = 'b';

		if (selectedValue.equals ("Knight"))
		    piece [x] [y] = 'n';

		if (selectedValue.equals ("Rook"))
		    piece [x] [y] = 'r';

	    }
	}
    }


    public void actionPerformed (ActionEvent e)
    { //moves between the screens
	if (e.getActionCommand ().equals ("s1"))
	    cdLayout.show (p_card, "1");
	else if (e.getActionCommand ().equals ("s2"))
	    cdLayout.show (p_card, "2");
	else if (e.getActionCommand ().equals ("s3"))
	    cdLayout.show (p_card, "3");
	else if (e.getActionCommand ().equals ("check"))
	{
	    checkblack ();
	    checkwhite ();
	    redraw ();
	}
	else if (e.getActionCommand ().equals ("findking"))
	{
	    findking ();
	    redraw ();
	}
	else if (e.getActionCommand ().equals ("unselected"))
	{
	    unselected ();
	    redraw ();
	}
	else if (e.getActionCommand ().equals ("reset"))
	    reset ();

	else
	{
	    //code to handle the game
	    int n = Integer.parseInt (e.getActionCommand ());
	    int x = n / row;
	    int y = n % row;
	    // showStatus ("(" + x + ", " + y + ")");
	    if (last == -1) //click one
	    {
		if (sel [x] [y] == 'u' && colour [x] [y] == turn)
		{
		    selection (x, y);
		    last = n;
		}

	    } //click one
	    else if (last == n)
	    {
		last = -1;
		sel [x] [y] = 'u';
		//loop to set all sel to 'u'
		for (int i = 0 ; i < row ; i++)
		{
		    for (int j = 0 ; j < col ; j++)
		    {
			sel [i] [j] = 'u';
		    }
		}
	    }
	    else //click two
	    {
		if (sel [x] [y] == 's')
		{
		    move (n);
		} //selected
	    }
	    redraw ();
	}
    }


    public void move (int n)
    {
	int x = n / row;
	int y = n % row;
	int lastx = last / row;
	int lasty = last % row;
	//remove piece
	piece [x] [y] = piece [lastx] [lasty];
	piece [lastx] [lasty] = 'x';
	//remove colour
	colour [x] [y] = colour [lastx] [lasty];
	colour [lastx] [lasty] = 'x';
	//moved piece to new position
	last = -1;

	if (turn == 'b')
	{
	    turn = 'w';
	    whoseTurn.setText ("" + turn);

	}
	else
	{
	    turn = 'b';
	    whoseTurn.setText ("" + turn);
	}

	//loop to set all sel to 'u'
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		sel [i] [j] = 'u';
	    }
	}
    }


    public void selection (int x, int y)
    {
	sel [x] [y] = 's';
	//black and white pawn
	if (piece [x] [y] == 'p')
	{
	    selectPawn (x, y);
	}


	//black and white knight
	else if (piece [x] [y] == 'n')
	{
	    selectKnight (x, y);
	}


	//black and white rook
	else if (piece [x] [y] == 'r')
	{
	    selectRook (x, y);
	}


	//black and white bishop
	else if (piece [x] [y] == 'b')
	{
	    selectBishop (x, y);
	}


	//black and white queen
	else if (piece [x] [y] == 'q')
	{
	    selectQueen (x, y);
	}


	//black and white king
	else if (piece [x] [y] == 'k')
	{
	    selectKing (x, y);
	}
    }
}


