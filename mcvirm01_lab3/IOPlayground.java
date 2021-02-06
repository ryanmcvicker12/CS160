package mcvirm01_lab3;
import java.util.Scanner;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;



public class IOPlayground extends JFrame implements ActionListener {

	public static JDialog dialogOne,dialogTwo, dialogThree;
	public static JFrame dialogFrame;
	public JTextField firstTextfield;		

	public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		
		System.out.print("What is your first username?: ");

		String userName= input.next();

		String[] splitUsername = userName.split("");
		
		System.out.printf("Users name is : %s\n", userName);

		System.out.printf("Length of username : %d characters long \n", userName.length());

		System.out.printf("First character of the users name : %s\n Last character of the users name: %s\n", splitUsername[0], splitUsername[userName.length() - 1]);

		System.out.printf("Username to upper case: %s\n Username to lower case : %s\n", userName.toUpperCase(),userName.toLowerCase());

		// ========== GUI ==========
		
		IOPlayground IOPlaygroundObject = new IOPlayground();

		dialogFrame = new JFrame("dialog frame");

		IOPlayground classObject = new IOPlayground();

		JPanel dialogPanel = new JPanel();

		dialogFrame.add(dialogPanel);
		
		dialogFrame.setSize(400,400);

		
		JLabel firstLabel = new JLabel("Hello " + userName + ". I will now ask you a question");

		JButton firstButton = new JButton("OK");
		
		firstButton.setSize(20,10);
		
		dialogPanel.add(firstLabel);
		dialogPanel.add(firstButton);
		dialogFrame.add(dialogPanel);
		firstButton.addActionListener(IOPlaygroundObject);
		
		dialogFrame.setSize(400,400);
		dialogFrame.show();	
	}

	public void actionPerformed(ActionEvent eventOne){

		String IOPlaygroundObject = eventOne.getActionCommand();
		
		if( IOPlaygroundObject.equals("OK")){
			
			dialogOne = new JDialog(dialogFrame, "dialog 1");

			JLabel labelTwo = new JLabel("What is your favorite number?");
			
			firstTextfield = new JTextField(20);
			

			JButton secondButton = new JButton("OK");

			JButton thirdButton = new JButton("Cancel");

			JPanel panelTwo = new JPanel();

			thirdButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){

					dialogOne.setVisible(false);
				}

			 });


			secondButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					dialogThree = new JDialog(dialogFrame, "dialog 3");

					JLabel labelThree = new JLabel("Your names favorite number is : " + firstTextfield.getText());
					JButton fourthButton = new JButton("OK");
					
					JPanel panelThree = new JPanel();
									
					
					fourthButton.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){

							dialogThree.setVisible(false);
							dialogOne.setVisible(false);
						}

			 		});
					panelThree.add(fourthButton);
					panelThree.add(labelThree);
					dialogThree.add(panelThree);
					dialogThree.setSize(500, 200);
					dialogThree.setVisible(true);
	
				}
			});
			panelTwo.add(secondButton);
			panelTwo.add(thirdButton);
			panelTwo.add(firstTextfield);
			panelTwo.add(labelTwo);
			dialogOne.add(panelTwo);
			dialogOne.setSize(500, 200);
			dialogOne.setVisible(true);
		
		}
		else{

			dialogTwo = new JDialog(dialogFrame, "dialog 2");

			JLabel labelThree = new JLabel("third label here");

			dialogTwo.add(labelThree);

			dialogTwo.setSize(200,200);

			dialogTwo.setLocation(200,200);

			dialogTwo.setVisible(true);	
		}

	} 















}
