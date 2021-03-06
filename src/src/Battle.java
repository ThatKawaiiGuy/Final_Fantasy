package src;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.Border;

public class Battle extends JFrame implements KeyListener{
	
	BMusic1 bm1 = new BMusic1();
	BMusic2 bm2 = new BMusic2();
	
	public CharacterRules charles = new CharacterRules();
	public JFrame frame;
	
	public JLabel status;
	public JLabel action;
	public JLabel selectionBox;
	public JLabel selectLabel;
	public JLabel bgr;
	public JLabel mage;
	public JLabel enemy;
	public JLabel mageHP = new JLabel("Black Mage   " + charles.userHealth + "/712");
	public JLabel enemyHP = new JLabel("Wizard      " + charles.enemyHealth +"/1200");
	
	public JLabel attack1 = new JLabel("Metronome");
	public JLabel attack2 = new JLabel("Flare Blits");
	public JLabel attack3 = new JLabel("Heal");
	public JLabel attack4 = new JLabel("Lightning Storm");

	Color borderColor = new Color(223, 234, 216);
	Color selectorBg = new Color(24, 32, 204);
	
	ImageIcon select = new ImageIcon(getClass().getResource("white_arrow.png"));
	ImageIcon bg = new ImageIcon(getClass().getResource("Background.png"));
	ImageIcon mageIcon = new ImageIcon(getClass().getResource("black-mage.png"));
	ImageIcon enemyIcon = new ImageIcon(getClass().getResource("Enemy.gif"));
	
	public void start() {
		makeFrame();
		createBoxes();
		frame.setVisible(true);
		if((int)(Math.random() * 2 + 1) == 1)
			bm1.init();
		else
			bm2.init();
		frame.addKeyListener(this);
	}

	public void makeFrame() {
		frame = new JFrame("Final Fantasy");
		bgr = new JLabel(bg);
		frame.setContentPane(bgr);	
		frame.setAlwaysOnTop(true);
		frame.setBounds(500, 200, 960, 544);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public void createBoxes() {
		mage = new JLabel(mageIcon);
		mage.setBounds(600,150,200,300);
		
		mageHP.setBounds(650, 400, 200, 100);
		mageHP.setForeground(Color.WHITE);
		mageHP.setFont(mageHP.getFont().deriveFont(16.0f));
		
		enemy = new JLabel(enemyIcon);
		enemy.setBounds(0,-50,500,500);
		
		enemyHP.setBounds(650, 425, 200, 100);
		enemyHP.setForeground(Color.WHITE);
		enemyHP.setFont(enemyHP.getFont().deriveFont(16.0f));
		
		attack1.setBounds(50, 395, 200, 50);
		attack1.setForeground(Color.WHITE);
		attack1.setFont(attack1.getFont().deriveFont(16.0f));
		
		attack2.setBounds(50, 445, 200, 50);
		attack2.setForeground(Color.WHITE);
		attack2.setFont(attack2.getFont().deriveFont(16.0f));
		
		attack3.setBounds(340, 395, 200, 50);
		attack3.setForeground(Color.WHITE);
		attack3.setFont(attack3.getFont().deriveFont(16.0f));
		
		attack4.setBounds(340, 445, 200, 50);
		attack4.setForeground(Color.WHITE);
		attack4.setFont(attack4.getFont().deriveFont(16.0f));
		
		selectLabel = new JLabel(select);
		selectLabel.setBounds(attack1.getX() - 45, attack1.getY(), 50, 50);
		
		selectionBox = new JLabel();
		selectionBox.setForeground(Color.white);
		Border border = BorderFactory.createLineBorder(borderColor, 5);
		selectionBox.setBorder(border);
		selectionBox.setBackground(selectorBg);
		selectionBox.setOpaque(true);
		selectionBox.setBounds(0, 377, 949, 136);
		
		status = new JLabel();
		status.setForeground(Color.white);
		status.setBorder(border);
		status.setBackground(selectorBg);
		status.setOpaque(true);
		status.setBounds(600, 377, 349, 136);
		
		JLayeredPane layer = new JLayeredPane();
		frame.setContentPane(layer);
		layer.add(mage, 5);
		layer.add(enemy, 5);
		layer.add(selectionBox, 4);
		layer.add(status, 3);
		layer.add(mageHP, 0);
		layer.add(enemyHP, 0);
		layer.add(selectLabel, 0);
		layer.add(attack1, 1);
		layer.add(attack2, 1);
		layer.add(attack3, 1);
		layer.add(attack4, 1);
		layer.add(bgr, 6);
	}
	
	/// MAKE SOUND LOOOOP
	public void attackSelect(JLabel label){	
		action = new JLabel("You used " + label.getText() + "!");
		action.setForeground(Color.white);
		action.setFont(action.getFont().deriveFont(35.0f));
		action.setBounds(80, 345, 800, 200);
		frame.add(action);
		frame.add(selectionBox);
		JLayeredPane layer = new JLayeredPane();
		frame.setContentPane(layer);
		layer.add(mage, 5);
		layer.add(enemy, 5);
		layer.add(selectionBox, 4);
		layer.add(status, 3);
		layer.add(mageHP, 0);
		layer.add(enemyHP, 0);
		layer.add(selectLabel, 0);
		layer.add(attack1, 1);
		layer.add(attack2, 1);
		layer.add(attack3, 1);
		layer.add(attack4, 1);
		layer.add(bgr, 6);
		if(label == attack1){
			int k = (int)(Math.random() * 10 + 1);
			if(k > 2)
				Character(1, 1);
			else
				Character(550, 1);
		}
		else if(label == attack2)
			Character(215, 2);
		else if(label == attack4)
			Character(300, 4);
		else if(label == attack3)
			Character(400, 3);
		frame.setVisible(true);
	}
	public void gameComplete(int eh, int ph){
		if(ph == 0 && eh == 0){
			frame.setVisible(true);
			frame.setContentPane(bgr);
			frame.add(action);
			frame.add(mageHP);
			frame.add(enemyHP);
			action.setText("Uhh, you both lost?");
		}
		else if(eh == 0){
			frame.setVisible(true);
			frame.setContentPane(bgr);
			frame.add(action);
			frame.add(mageHP);
			frame.add(enemyHP);
			action.setText("You won!");
		}
		else if(ph == 0){
			frame.setVisible(true);
			frame.setContentPane(bgr);
			frame.add(action);
			frame.add(mageHP);
			frame.add(enemyHP);
			action.setText("You lost....");
		}
	}
	public void Character(int d,int attack){
		if(attack == 1){
			charles.damageEnemy(d);
			gameComplete(charles.getEnemyHealth(), charles.getPlayerHealth());
			charles.damagePlayer(125);
			mageHP.setText("Black Mage   " + charles.userHealth + "/712");
			enemyHP.setText("Wizard      " + charles.enemyHealth +"/1200");
			gameComplete(charles.getEnemyHealth(), charles.getPlayerHealth());
		}else if(attack == 2){
			charles.damageEnemy(d + 300);
			gameComplete(charles.getEnemyHealth(), charles.getPlayerHealth());
			charles.damagePlayer(200);
			mageHP.setText("Black Mage   " + charles.userHealth + "/712");
			enemyHP.setText("Wizard      " + charles.enemyHealth +"/1200");
			gameComplete(charles.getEnemyHealth(), charles.getPlayerHealth());
		}else if(attack == 3){
			charles.healPlayer(d);
			mageHP.setText("Black Mage   " + charles.userHealth + "/712");
			gameComplete(charles.getEnemyHealth(), charles.getPlayerHealth());
		}else if(attack == 4){
			charles.damageEnemy(d);
			gameComplete(charles.getEnemyHealth(), charles.getPlayerHealth());
			charles.damagePlayer(125);
			mageHP.setText("Black Mage   " + charles.userHealth + "/712");
			enemyHP.setText("Wizard      " + charles.enemyHealth +"/1200");
			gameComplete(charles.getEnemyHealth(), charles.getPlayerHealth());
		}
	}
	
	@Override
	public void keyPressed(KeyEvent key) {
		if(key.getKeyCode() == KeyEvent.VK_ENTER){
			if(selectLabel.getX() == attack1.getX() - 45)
				attackSelect(attack1);
			if(selectLabel.getY() == attack2.getY())
				attackSelect(attack2);
			if(selectLabel.getX() == attack3.getX() - 45)
				attackSelect(attack3);
			if(selectLabel.getY() == attack4.getY())
				attackSelect(attack4);
		}
		else if(key.getKeyCode() == KeyEvent.VK_DOWN){
			if(selectLabel.getX() == attack1.getX() - 45)
				selectLabel.setLocation(attack2.getX() - 45, attack2.getY());
			if(selectLabel.getX() == attack3.getX() - 45)
				selectLabel.setLocation(attack4.getX() - 45, attack4.getY());
		}
		else if(key.getKeyCode() == KeyEvent.VK_RIGHT){
			if(selectLabel.getX() == attack1.getX() - 45)
				selectLabel.setLocation(attack3.getX() - 45, attack3.getY());
			if(selectLabel.getX() == attack2.getX() - 45)
				selectLabel.setLocation(attack4.getX() - 45, attack4.getY());
		}
		else if(key.getKeyCode() == KeyEvent.VK_LEFT){
			if(selectLabel.getX() == attack3.getX() - 45)
				selectLabel.setLocation(attack1.getX() - 45, attack1.getY());
			if(selectLabel.getX() == attack4.getX() - 45)
				selectLabel.setLocation(attack2.getX() - 45, attack2.getY());
		}
		else if(key.getKeyCode() == KeyEvent.VK_UP){
			if(selectLabel.getX() == attack2.getX() - 45)
				selectLabel.setLocation(attack1.getX() - 45, attack1.getY());
			if(selectLabel.getX() == attack4.getX() - 45)
				selectLabel.setLocation(attack3.getX() - 45, attack3.getY());
		}
		frame.setVisible(true);	
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}
}