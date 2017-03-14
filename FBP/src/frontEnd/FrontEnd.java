package frontEnd;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fbp.FBPmain;

public class FrontEnd extends JFrame {
  private JTextField addressString = new JTextField("http://www.espn.com/college-football/playbyplay?gameId=400869187");
  private JTextField saveString = new JTextField();

  private JButton fileButton = new JButton("File Location");
  private JButton createButton = new JButton("Create");
  private JLabel label = new JLabel("Game Address:");

  private String fileLocation;
  private String urlString;

  private FBPmain fbMain = new FBPmain();

  public FrontEnd() {
    JPanel panel = new JPanel();

    fileButton.addActionListener(new SaveL());
    createButton.addActionListener(new SendToParser());
    panel.add(fileButton);
    panel.add(createButton);
    Container cp = getContentPane();
    cp.add(panel, BorderLayout.SOUTH);
    addressString.setEditable(true);
    saveString.setEditable(false);
    panel = new JPanel();
    panel.add(label);
    label = new JLabel("Save Path:");
    panel.add(label);
    panel.setLayout(new GridLayout(2, 1));
    panel.add(addressString);
    panel.add(saveString);
    cp.add(panel, BorderLayout.NORTH);
  }

  class SendToParser implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent arg0) {
      try {
        urlString = addressString.getText();
      } catch (Exception ex) {
        System.out.println(ex);
      }

      try {
        fbMain.startTheProcess(urlString, fileLocation);
      } catch (IllegalArgumentException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      System.out.println("urlString: " + urlString);
      System.out.println("fileLocation: " + fileLocation);
    }
  }

  class SaveL implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JFileChooser c = new JFileChooser();
      // Demonstrate "Save" dialog:
      int rVal = c.showSaveDialog(FrontEnd.this);
      if (rVal == JFileChooser.APPROVE_OPTION) {
        saveString.setText(c.getSelectedFile().getName());
        fileLocation = c.getSelectedFile().getAbsoluteFile().getAbsolutePath();
      }
      if (rVal == JFileChooser.CANCEL_OPTION) {
        addressString.setText("You pressed cancel");
      }
    }
  }

  public static void main(String[] args) {
    run(new FrontEnd(), 350, 110);
  }

  public static void run(JFrame frame, int width, int height) {
    frame.setTitle("Green Analytics");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(width, height);
    frame.setVisible(true);

  }
}
