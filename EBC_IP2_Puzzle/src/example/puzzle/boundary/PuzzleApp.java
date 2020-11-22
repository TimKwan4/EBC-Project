package example.puzzle.boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import example.puzzle.controller.GameStateController;
import example.puzzle.controller.MoveTileController;
import example.puzzle.controller.ResetController;
import example.puzzle.controller.SelectTileController;
import example.puzzle.model.Model;
import example.puzzle.model.MoveType;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PuzzleApp extends JFrame {

	private JPanel contentPane;
	PuzzlePanel panel;
	
	Model model;
	JButton btnUp, btnDown, btnLeft, btnRight;
	
	public PuzzlePanel getPuzzlePanel() {return panel;}
	public JButton getUpButton() {return btnUp;}
	public JButton getDownButton() {return btnDown;}
	public JButton getLeftButton() {return btnLeft;}
	public JButton getRightButton() {return btnRight;}

	/**
	 * Create the frame.
	 */
	public PuzzleApp(Model m) {
		super();
		this.model = m;
		
		setTitle("Puzzle");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 765, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new PuzzlePanel(m);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				new SelectTileController(model,PuzzleApp.this).process(me.getPoint());
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ResetController(model, PuzzleApp.this).reset();
			}
		});
		
		btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, PuzzleApp.this).move(MoveType.Up);
				new GameStateController(model, PuzzleApp.this).updateGame();
			}
		});
		
		btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, PuzzleApp.this).move(MoveType.Down);
				new GameStateController(model, PuzzleApp.this).updateGame();
			}
		});
		
		btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, PuzzleApp.this).move(MoveType.Right);
				new GameStateController(model, PuzzleApp.this).updateGame();
			}
		});
		
		btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, PuzzleApp.this).move(MoveType.Left);
				new GameStateController(model, PuzzleApp.this).updateGame();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnReset))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(122)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnUp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnDown, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addComponent(btnLeft, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(75)
							.addComponent(btnRight, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)))
					.addGap(77))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(366, Short.MAX_VALUE)
							.addComponent(btnReset))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(125)
							.addComponent(btnUp)
							.addGap(15)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLeft)
								.addComponent(btnRight))
							.addGap(11)
							.addComponent(btnDown)
							.addPreferredGap(ComponentPlacement.RELATED, 165, Short.MAX_VALUE))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		UpdateButtons.enableButtons(this, new ArrayList<MoveType>());
		
	}
}
