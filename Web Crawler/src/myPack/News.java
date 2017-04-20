package myPack;
import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;


public class News {

	private JFrame frame;
	private JTextArea textArea;
	private JButton btnStartParsing;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private JButton btnBack;
	int iterator=-1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					News window = new News();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public News() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void display(int a)
	{
		Document doc;
		try {
			doc = Jsoup.connect("http://www.ndtv.com/india?pfrom=home-topnavigation").get();
			Elements date = doc.select("div.nstory_dateline");
			Elements head = doc.select("div.nstory_header");
			Elements body = doc.select("div.nstory_intro");
			btnBack.setVisible(true);
			btnStartParsing.setText("Next");
				textArea_1.setText(head.get(a).text());
				textArea_2.setText(date.get(a).text());
				textArea.setEnabled(true);
				textArea.setVisible(true);
				textArea.setText(body.get(a).text());
				} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IndexOutOfBoundsException p)
		{
			System.out.println("Aaj ke samachar hue. Sahara Pranam");
			System.exit(0);
		}
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 255, 204));
		frame.setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 329, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnStartParsing = new JButton("Start");
		btnStartParsing.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnStartParsing.setBackground(SystemColor.activeCaption);
		btnStartParsing.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnStartParsing.setIcon(new ImageIcon(News.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		btnStartParsing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iterator++;
				display(iterator);
				 } 
			
			
		});
		btnStartParsing.setBounds(175, 11, 95, 43);
		frame.getContentPane().add(btnStartParsing);
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(153, 255, 204));
		textArea.setEnabled(false);
		textArea.setVisible(false);
		textArea.setFont(new Font("Calibri", Font.PLAIN, 14));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(10, 186, 291, 242);
		frame.getContentPane().add(textArea);
		
		textArea_1 = new JTextArea();
		textArea_1.setWrapStyleWord(true);
		textArea_1.setLineWrap(true);
		textArea_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea_1.setBackground(new Color(153, 255, 204));
		textArea_1.setBounds(10, 65, 291, 46);
		frame.getContentPane().add(textArea_1);
		
		textArea_2 = new JTextArea();
		textArea_2.setWrapStyleWord(true);
		textArea_2.setLineWrap(true);
		textArea_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textArea_2.setBackground(new Color(153, 255, 204));
		textArea_2.setBounds(10, 129, 291, 46);
		frame.getContentPane().add(textArea_2);
		
		btnBack = new JButton("Back");
		btnBack.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnBack.setIcon(new ImageIcon(News.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		btnBack.setBackground(SystemColor.activeCaption);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(iterator>0){
					iterator--;
				display(iterator);
				}
			}
		});
		btnBack.setBounds(36, 11, 105, 43);
		btnBack.setVisible(false);
		frame.getContentPane().add(btnBack);
	}
}
