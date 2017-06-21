package form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class CertMain extends JFrame {
	private javax.swing.JButton insert;
	private javax.swing.JButton issue;
	private javax.swing.JButton view;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;

	public CertMain() {
		// TODO Auto-generated constructor stub
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		insert = new javax.swing.JButton();
		issue = new javax.swing.JButton();
		view = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
		jLabel1.setText("CERTIFICATE CENTER");

		jLabel2.setIcon(new javax.swing.ImageIcon("D:\\1200px-NIIT_logo.svg.png")); // NOI18N
		jLabel2.setText("jLabel2");

		// insert.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
		insert.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		insert.setText("INSERT");

		// issue.setBackground(new java.awt.Color(255, 255, 0));
		issue.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		issue.setText("ISSUE");

		// view.setBackground(new java.awt.Color(255, 0, 0));
		view.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		view.setText("VIEW");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(86, 86, 86)
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(35, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup()
												.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 658,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(34, 34, 34))
										.addGroup(layout.createSequentialGroup()
												.addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, 153,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, 160,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(77, 77, 77)
												.addComponent(issue, javax.swing.GroupLayout.PREFERRED_SIZE, 156,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(51, 51, 51)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(insert, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
						.addComponent(view, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(issue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
				.addGap(42, 42, 42).addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));

		setSize(727, 438);
		setVisible(true);

		insert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InsertFormDatabase();
			}
		});

		view.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ViewDatabase();
			}
		});

		issue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new IssueCertificate();
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CertMain();
	}

}
