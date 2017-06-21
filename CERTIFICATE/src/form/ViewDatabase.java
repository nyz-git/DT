package form;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class ViewDatabase extends JFrame {
	String pname;
	ResultSet rs;
	PreparedStatement ps;
	/*JTextArea area;
	JScrollPane scroll;*/
	private javax.swing.JButton search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea area;
    private javax.swing.JTextField name;
	public ViewDatabase() {
		// TODO Auto-generated constructor stub

		/*JTextField name = new JTextField();
		name.setBounds(0, 0, 100, 40);
		name.setFont(new Font("Arial Black", Font.BOLD, 20));

		JButton search = new JButton("SEARCH");
		search.setBounds(0, 50, 100, 40);
		
		area = new JTextArea(10,20);
		area.setBounds(0, 100, 300, 50);
		area.setFont(new Font("Arial Black", Font.BOLD, 20));
		scroll = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		add(name);
		add(search);
		add(area);
		add(scroll);*/
		jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        area.setFont(new Font("Arial Black", Font.BOLD, 20));
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        name.setFont(new Font("Arial Black", Font.BOLD, 20));
        search = new javax.swing.JButton();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        area.setColumns(20);
        area.setRows(5);
        jScrollPane1.setViewportView(area);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("STUDENT CERTIFICATE DETAILS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("NAME :");

        search.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        search.setText("SEARCH");
        
            

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name))
                    .addComponent(jLabel1))
                .addGap(109, 109, 109))
            .addGroup(layout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(name))
                .addGap(14, 14, 14)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
		
		setSize(811,650);
		
		setVisible(true);

		
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String pname = name.getText();
				try {
					System.out.println("1");
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("2");
					Connection con = DriverManager.getConnection("jdbc:mysql://10.16.61.156:3306/DemoBD", "root", "root");
					System.out.println("3");
					//PreparedStatement ps = con.prepareStatement("select * from certificate where name=?");
					//ps = con.prepareStatement("SELECT * FROM certificate WHERE name LIKE '%'");
					//System.out.println("4");
					//ps.setString(1, pname);
					
					String sql = "SELECT * FROM certificate WHERE name LIKE ?";
					ps = con.prepareStatement(sql);
					ps.setString(1, "%" + pname + "%");
					ResultSet rs = ps.executeQuery();
					
					name.setText("");
					area.setText("");
					if (rs.next()) {
						 do{
							 area.append(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
							 area.append("\n");
							 //area.setText(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  "+ rs.getString(4));
							//System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  "+ rs.getString(4));
						}while (rs.next());
					} else {
						area.append("NO RECORDS FOUND");
						System.out.println("NO RECORD");
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ViewDatabase();
	}

}
