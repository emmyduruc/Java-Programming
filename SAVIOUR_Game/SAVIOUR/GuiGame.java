import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GuiGame extends JFrame implements  UserActionInterface, UserAssistanceInterface {

    //GUI Labels
    private JTextArea displayTextArea;
    private JButton goNorthButton;
    private JButton goWestButton;
    private JButton goEastButton;
    private JButton goSouthButton;

    Game guiGame;
    Room startRoom;
    public GuiGame(Room startRoom){
        guiGame = new Game();
        this.startRoom = startRoom;
    }


    public void startGamePlay(){
        //GUI Part
        this.createGameFrame();
    }

    private void createGameFrame()
    {
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

        makeMenuBar();

        contentPane.setLayout(new BorderLayout(8, 8));

        displayTextArea = new JTextArea();
        contentPane.add(displayTextArea, BorderLayout.CENTER);

        JPanel upperToolbar = new JPanel();
        upperToolbar.setLayout(new GridLayout(1, 0));

        JPanel upperFlow = new JPanel();
        upperFlow.add(upperToolbar);

        contentPane.add(upperFlow, BorderLayout.NORTH);

        JPanel sideToolbar = new JPanel();
        sideToolbar.setLayout(new GridLayout(0, 1));

        goNorthButton = new JButton("Go North");
        sideToolbar.add(goNorthButton);
        goWestButton = new JButton("Go West");
        sideToolbar.add(goWestButton);
        goEastButton = new JButton("Go East");
        sideToolbar.add(goEastButton);
        goSouthButton = new JButton("Go South");
        sideToolbar.add(goSouthButton);

        JPanel sideFlow = new JPanel();
        sideFlow.add(sideToolbar);

        contentPane.add(sideFlow, BorderLayout.EAST);


        pack();
        setVisible(true);
        displayTextArea.setText("Welcome to the World of Zuul!\n"+"World of Zuul is a new, incredibly boring adventure game.\n"+"Type 'help' if you need help.\n"+startRoom.getLongDescription());
    }

    private void makeMenuBar()
    {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu;
        JMenuItem item1, item2, item3;

        menu = new JMenu("User Controls");
        menuBar.add(menu);

        item1 = new JMenuItem("Back");
        menu.add(item1);

        item2 = new JMenuItem("Help");
        menu.add(item2);


        item3 = new JMenuItem("Quit");
        menu.add(item3);
    }

}
