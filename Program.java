/********************************************************
*   Programmer : Anthony D'Ambrosio
*    Date       : 11/10/2015
*    Title      : csm10j-Lab11
*    Purpose    : GUI Weighted Average
*    Notes      :
********************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Program extends JFrame
{
    private int width = 400;
    private int height = 600;
    private JLabel gradesL, weightsL;
    private JTextField testTF[] = new JTextField[4];
    private JTextField weightTF[] = new JTextField[4];
    private JTextField answerTF;
    private JButton calculateB;
    private CalculateButtonHandler cbHandler;

    public Program()
    {
        setTitle( "" );
        setSize( width, height );
        setVisible( false );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }
    
    public void setup ()
    {
        gradesL = new JLabel("Grades %", SwingConstants.LEFT);
        weightsL = new JLabel("Weight", SwingConstants.LEFT);
        
        for (int c = 0; c < 4; c++)
        {
            testTF[ c ] = new JTextField( 10 );
            weightTF[ c ] = new JTextField( 10 );   
        }
        
        answerTF = new JTextField( 10 );
        
        calculateB = new JButton("Calculate");
        cbHandler = new CalculateButtonHandler();
        calculateB.addActionListener(cbHandler);

        Container pane = getContentPane();
        pane.setLayout( new GridLayout(6,2) );
        
        pane.add( gradesL );
        pane.add( weightsL );
        
        for (int c = 0; c < 4; c++ )
        {
            pane.add( testTF[ c ] );
            pane.add( weightTF[ c ] );
        }
        
        pane.add( calculateB );
        pane.add( answerTF );
    }
    
    private class CalculateButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            double testscore[] = new double[4];
            double weight[] = new double[4];

            try
            {
                for ( int c = 0; c < 4; c++ )
                {
                    testscore[0] = Double.parseDouble( testTF[c].getText() );
                    weight[0] = Double.parseDouble( weightTF[c].getText() );
                }
                
                double tempAverage = 0;
                
                for (int c = 0; c < 4; c++)
                    tempAverage += ( testscore[0] * weight[0] );
                
                String weightedAverage = String.valueOf( tempAverage );
                weightedAverage = String.format("%.2f", tempAverage);
                answerTF.setText("" + weightedAverage);
            }
            catch(NumberFormatException nFEx)
            {
                answerTF.setText("N/A");
            }
        }
    }
    
    public static void main( String[] args )
    {
        Program p = new Program();
        p.setup();
        p.setSize( 200,300 );
        p.setVisible( true );
        
    }
}
