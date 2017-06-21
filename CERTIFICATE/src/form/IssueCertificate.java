package form;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class IssueCertificate extends JFrame {

	String pname;
	ResultSet rs;
	PreparedStatement ps;
	private javax.swing.JButton search;
	private javax.swing.JButton id;
	private javax.swing.JButton issue;
	
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	
	private javax.swing.JTextField name;
	private javax.swing.JTextField regid;
	private javax.swing.JTextArea issuetext;

	void msg() {
		JOptionPane.showMessageDialog(this, "Certificate Issued");
	}
	public IssueCertificate() {
		// TODO Auto-generated constructor stub
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		name = new javax.swing.JTextField();
		name.setFont(new Font("Arial Black", Font.BOLD, 20));
		regid = new javax.swing.JTextField();
		regid.setFont(new Font("Arial Black", Font.BOLD, 20));
		search = new javax.swing.JButton();
		id = new javax.swing.JButton();
		issuetext = new javax.swing.JTextArea();
		issuetext.setFont(new Font("Arial Black", Font.BOLD, 20));
		issue = new javax.swing.JButton();

		// setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
		jLabel1.setText("ISSUE CERTIFICATE");

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabel2.setText("SEARCH BY NAME :");

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabel3.setText("SEARCH BY REGISTRATION ID :");

		search.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		search.setText("SEARCH NAME");

		id.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		id.setText("SEARCH ID");

		issue.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		issue.setText("ISSUE");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(235, 235, 235).addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGap(28, 28, 28)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(issuetext, javax.swing.GroupLayout.PREFERRED_SIZE, 520,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(issue,
														javax.swing.GroupLayout.PREFERRED_SIZE, 159,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup().addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addGroup(layout.createSequentialGroup()
														.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE,
																174, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18).addComponent(name))
												.addGroup(layout.createSequentialGroup()
														.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE,
																298, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(regid, javax.swing.GroupLayout.DEFAULT_SIZE, 296,
																Short.MAX_VALUE)))
												.addGap(26, 26, 26)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 139,
																Short.MAX_VALUE)
														.addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))))))
				.addContainerGap(59, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
								.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(name))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(regid, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(71, 71, 71)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(issuetext)
								.addComponent(issue, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
						.addContainerGap(272, Short.MAX_VALUE)));

		setSize(851, 464);
		setVisible(true);

		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String pname = name.getText();
				name.setText("");
				try {
					System.out.println("1");
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("2");
					Connection con = DriverManager.getConnection("jdbc:mysql://10.16.61.156:3306/DemoBD", "root",
							"root");
					System.out.println("3");
					// PreparedStatement ps = con.prepareStatement("select *
					// from certificate where name=?");
					// ps = con.prepareStatement("SELECT * FROM certificate
					// WHERE name LIKE '%'");
					// System.out.println("4");
					// ps.setString(1, pname);

					String sql = "SELECT * FROM certificate WHERE name LIKE ?";
					ps = con.prepareStatement(sql);
					ps.setString(1, "%" + pname + "%");
					ResultSet rs = ps.executeQuery();

					
					issuetext.setText("");
					if (rs.next()) {
						do {
							issuetext.append(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
							issuetext.append("\n");
							// issuetext.setText(rs.getString(1) + " " +
							// rs.getString(2) + " " + rs.getString(3) + " "+
							// rs.getString(4));
							// System.out.println(rs.getString(1) + " " +
							// rs.getString(2) + " " + rs.getString(3) + " "+
							// rs.getString(4));
						} while (rs.next());
					} else {
						issuetext.append("NO RECORDS FOUND");
						System.out.println("NO RECORD");
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});

		id.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String pregid = regid.getText();
				//regid.setText("");
				try {
					System.out.println("1");
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("2");
					Connection con = DriverManager.getConnection("jdbc:mysql://10.16.61.156:3306/DemoBD", "root",
							"root");
					System.out.println("3");
					// PreparedStatement ps = con.prepareStatement("select *
					// from certificate where name=?");
					// ps = con.prepareStatement("SELECT * FROM certificate
					// WHERE name LIKE '%'");
					// System.out.println("4");
					// ps.setString(1, pname);

					String sql = "SELECT * FROM certificate WHERE id LIKE ?";
					ps = con.prepareStatement(sql);
					ps.setString(1, "%" + pregid + "%");
					ResultSet rs = ps.executeQuery();

					//id.setText("");
					issuetext.setText("");
					if (rs.next()) {
						do {
							issuetext.append(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
							issuetext.append("\n");
							// issuetext.setText(rs.getString(1) + " " +
							// rs.getString(2) + " " + rs.getString(3) + " "+
							// rs.getString(4));
							// System.out.println(rs.getString(1) + " " +
							// rs.getString(2) + " " + rs.getString(3) + " "+
							// rs.getString(4));
						} while (rs.next());
					} else {
						issuetext.append("NO RECORDS FOUND");
						// System.out.println("NO RECORD");
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});

		issue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					System.out.println("1");
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("2");
					Connection con = DriverManager.getConnection("jdbc:mysql://10.16.61.156:3306/DemoBD", "root", "root");
					System.out.println("3");
					Statement stmt = con.createStatement();
					System.out.println("4");
					String pid = regid.getText();
					System.out.println("id is"+pid);
					//String pregis = registration.getText();
					//String pcourse = course.getText();
					//String pphone = phone.getText();
					//System.out.println(pname);
					System.out.println("5");
					stmt.executeLargeUpdate("insert into certificateissue (name, id, course,date) select name,id,course,NOW() from certificate where id = '"+pid+"'");//, '" + pcourse + "')");
					stmt.executeUpdate("DELETE FROM certificate WHERE id = '"+pid+"'");
					System.out.println("6");
					con.close();
					msg();
					name.setText("");
					regid.setText("");
					issuetext.setText("");
					//registration.setText("");
					//course.setText("");
					//phone.setText("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}																				
			}

			
		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new IssueCertificate();
	}

}
