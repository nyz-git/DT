package form;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InsertFormDatabase extends JFrame {
	 private javax.swing.JButton submit;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JTextField name;
	    private javax.swing.JTextField registration;
	    private javax.swing.JTextField course;
	
	//JTextField name, password, address, phone;
	Connection con;
	Statement stmt;

	void msg() {
		JOptionPane.showMessageDialog(this, "Record Inserted Successfully");
	}

	public InsertFormDatabase() {
		// TODO Auto-generated constructor stub

		/*name = new JTextField();
		name.setBounds(0, 0, 100, 40);
		password = new JTextField();
		password.setBounds(0, 50, 100, 40);
		address = new JTextField();
		address.setBounds(0, 100, 100, 40);
		phone = new JTextField();
		phone.setBounds(0, 150, 100, 40);
		submit = new JButton("SUBMIT");
		submit.setBounds(0, 200, 100, 30);

		add(name);
		add(password);
		add(address);
		add(phone);
		add(submit);*/

		jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        name.setFont(new Font("Arial Black", Font.BOLD, 20));
        registration = new javax.swing.JTextField();
        registration.setFont(new Font("Arial Black", Font.BOLD, 20));
        course = new javax.swing.JTextField();
        course.setFont(new Font("Arial Black", Font.BOLD, 20));
        submit = new javax.swing.JButton();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("INSERT CERTIFICATE DETAILS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("NAME :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("REGISTRATION NO :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("COURSE NAME : ");

        

        submit.setText("SUBMIT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(registration)
                            .addComponent(name)
                            .addComponent(course, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(registration, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(course))
                .addGap(69, 69, 69)
                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
		
        setSize(705, 464);
		setVisible(true);

		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {

					Class.forName("com.mysql.cj.jdbc.Driver");

					Connection con = DriverManager.getConnection("jdbc:mysql://10.16.61.156:3306/DemoBD", "root", "root");

					Statement stmt = con.createStatement();

					String pname = name.getText();
					String pregis = registration.getText();
					String pcourse = course.getText();
					//String pphone = phone.getText();

					stmt.executeUpdate("insert into certificate values('" + pname + "', '" + pregis + "', '" + pcourse + "')");

					con.close();
					msg();
					name.setText("");
					registration.setText("");
					course.setText("");
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
		new InsertFormDatabase();

		System.out.println("DONE");
	}

}
