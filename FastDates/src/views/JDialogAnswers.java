package views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import controllers.Controller;
import controllers.Events;

public class JDialogAnswers extends JDialog {

	public static final String TEXT_LABEL_TRAVEL = "I like to travel";
	public static final String TEXT_LABEL_DRINK_OR_SMOKE = "I drink or smoke";
	public static final String TEXT_LABEL_PETS = "I like pets";
	public static final String ACCEPT_JBUTTON = "Accept";
	private static final long serialVersionUID = 1L;
	private JButton jbtnAccept;
	private JCheckBox jcbPets, jcbDrinkOrSmoke, jcbTravel;
	public static final Color RED_COLOR = Color.decode("#8a1327");
	public static final Font FONT_UBUNTU = new Font("Ubuntu", Font.BOLD, 20);

	public JDialogAnswers(Controller controller, MainWindow mainWindow) {
		super(mainWindow, true);
		setLayout(new FlowLayout());
		setSize(230, 210);
		setLocationRelativeTo(mainWindow);
		JLabel selectPets = new JLabel(TEXT_LABEL_PETS);
		selectPets.setForeground(Color.WHITE);
		selectPets.setBackground(RED_COLOR);
		selectPets.setFont(FONT_UBUNTU);
		add(selectPets);
		jcbPets = new JCheckBox();
		jcbPets.setOpaque(false);
		add(jcbPets);
		JLabel selectDrinkOrSmoking = new JLabel(TEXT_LABEL_DRINK_OR_SMOKE);
		selectDrinkOrSmoking.setForeground(Color.WHITE);
		selectDrinkOrSmoking.setBackground(RED_COLOR);
		selectDrinkOrSmoking.setFont(FONT_UBUNTU);
		add(selectDrinkOrSmoking);
		jcbDrinkOrSmoke = new JCheckBox();
		jcbDrinkOrSmoke.setOpaque(false);
		add(jcbDrinkOrSmoke);
		JLabel selectTravel = new JLabel(TEXT_LABEL_TRAVEL);
		selectTravel.setForeground(Color.WHITE);
		selectTravel.setBackground(RED_COLOR);
		selectTravel.setFont(FONT_UBUNTU);
		add(selectTravel);
		jcbTravel = new JCheckBox();
		jcbTravel.setOpaque(false);
		add(jcbTravel);
		jbtnAccept = new JButton(ACCEPT_JBUTTON);
		jbtnAccept.addActionListener(controller);
		jbtnAccept.setActionCommand(Events.ACCEPT_ANSWERS.toString());
		jbtnAccept.setForeground(Color.WHITE);
		jbtnAccept.setBackground(RED_COLOR);
		jbtnAccept.setFont(FONT_UBUNTU);
		add(jbtnAccept);
		getContentPane().setBackground(RED_COLOR);
	}
	
	public boolean getCheckBoxPets(){
		return jcbPets.isSelected();
	}
	
	public boolean getCheckBoxDrinkOrSmoke(){
		return jcbDrinkOrSmoke.isSelected();
	}
	
	public boolean getCheckBoxTravel(){
		return jcbTravel.isSelected();
	}
	
	public void defaultCheckBox(){
		jcbPets.setSelected(false);
		jcbDrinkOrSmoke.setSelected(false);
		jcbTravel.setSelected(false);
	}
}