import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class musicFrame extends JFrame {
	
	JPanel musicPanel;
	JLabel musicInfo;
	JPanel musicPanelBtn;
	JButton play;
	JButton stop;
	JButton reset;
	JButton close;
	ImageIcon musicIcon;
	JButton openMusic;
	
	File musicFile;
	AudioInputStream audioStream;
	Clip myMusic;
	JFileChooser msc;
	String getMusic;
	
	public musicFrame()   {
		
		 
		 
			
				 
					musicFile= new File("Elfida.wav");
					 try {
							audioStream=AudioSystem.getAudioInputStream(musicFile);
						 myMusic= AudioSystem.getClip();
						 myMusic.open(audioStream);
						} catch (UnsupportedAudioFileException | IOException | LineUnavailableException m) {

							m.printStackTrace();
						}

		
		
		/// panel
		musicPanel= new JPanel();
		musicInfo= new JLabel("Music Info");
		musicInfo.setFont(new Font("Dialog", Font.BOLD, 30));
		
		musicPanelBtn= new JPanel();
		
		play= new JButton("Play");
		play.setFocusable(false);
		play.addActionListener(new Music());
		
		stop= new JButton("Stop");
		stop.setFocusable(false);
		stop.addActionListener(new Music());
		
		reset= new JButton("Reset");
		reset.setFocusable(false);
		reset.addActionListener(new Music());
		
		close= new JButton("Close");
		close.setFocusable(false);
		close.addActionListener(new Music());
		
		
		
		
		
		musicPanel.add(musicInfo);
		
		musicPanelBtn.add(play);
		musicPanelBtn.add(stop);
		musicPanelBtn.add(reset);
		musicPanelBtn.add(close);
		
		
		/// Frame
		setLayout(new BorderLayout());
		add(musicPanel, BorderLayout.NORTH);
		add(musicPanelBtn, BorderLayout.CENTER);
		setTitle("Music box");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		musicIcon= new ImageIcon("music.jpg");
		setIconImage(musicIcon.getImage());
		
		setSize(500,250);
		setVisible(true);
		
		
	}
	
	

	public class Music implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
				
				
				
			
			
			
			
			String name= musicFile.getPath();

			if(e.getSource()==play) {
				
				myMusic.start();
				
				musicInfo.setText("Playing...." + name);
				play.setBackground(Color.red);
				play.setForeground(Color.white);
				
				reset.setBackground(null);
				reset.setForeground(null);
				
				stop.setBackground(null);
				stop.setForeground(null);
				
				
			}
			if(e.getSource()==stop) {
				myMusic.stop();
				musicInfo.setText(name + " Stoped!");
				play.setBackground(null);
				play.setForeground(null);
				
				stop.setBackground(Color.red);
				stop.setForeground(Color.white);
				
				reset.setBackground(null);
				reset.setForeground(null);
				
			}
			if(e.getSource()==reset) {
				myMusic.setMicrosecondPosition(0);
				myMusic.start();
				musicInfo.setText(name + " Playing from begining");
				
				play.setBackground(null);
				play.setForeground(null);
				
				stop.setBackground(null);
				stop.setForeground(null);
				
				reset.setBackground(Color.red);
				reset.setForeground(Color.white);
			}
			if(e.getSource()==close) {
				myMusic.close();
				System.exit(0);
			}
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new musicFrame();

	}

}
