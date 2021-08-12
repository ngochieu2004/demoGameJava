/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author ngochieu
 */
public class XOButton extends JButton{
    private ImageIcon X,O;
    private Point point;
    public static boolean isXMove = true;
    public int value = 0;
    public XOButton(int x, int y) {
	X = new ImageIcon(this.getClass().getResource("X.png"));
	O = new ImageIcon(this.getClass().getResource("O.png"));
	setHorizontalAlignment(SwingConstants.CENTER);
	setVerticalAlignment(SwingConstants.CENTER);
		
	this.point = new Point(x, y);
		
//		addActionListener(this);
    }
    public void setState(Boolean isXMove) {
	if (isXMove) {
		setIcon(X);
		value = 2;
		XOButton.isXMove = false;
	} else {
		setIcon(O);
		value = 1;
		XOButton.isXMove = true;
	}
		
    }
}
