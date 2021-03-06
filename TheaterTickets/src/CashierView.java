import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CashierView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierView frame = new CashierView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	DefaultListModel model; 
	JList list;
	private JTextField textField_cn;
	private JTextField textField_rr;
	private JTextField textField_fr;
	private JTextField textField_pr;
	public CashierView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u03A0\u03A1\u039F\u0393\u03A1\u0391\u039C\u039C\u0391 \u03A0\u0391\u03A1\u0391\u03A3\u03A4\u0391\u03A3\u0395\u03A9\u039D");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 11, 203, 23);
		contentPane.add(label);
		
		
		
		model = new DefaultListModel();
		final JList list = new JList(model);
		list.setBounds(20, 45, 429, 111);
		contentPane.add(list);
		
		String query = "select * from Tickets;";
		Connection con = Handler.connect();
		ResultSet rs = Handler.executeQuery(query, con);
		
		try{
			while (rs.next()){
				
				String str=rs.getString(2) + " "+rs.getString(4) + " "+rs.getString(5);
				
				model.addElement(str);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally
		{
			Handler.disconnect(con);
		}
		
		
		JButton btnNewButton = new JButton("\u0395\u03A0\u0399\u039B\u039F\u0393\u0397");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = list.getSelectedIndex();
				i++;
				String query = "select * from Tickets where ID="+i+";";
				Connection con = Handler.connect();
				ResultSet rs = Handler.executeQuery(query, con);
				
				try{
					while (rs.next()){
						
						String str=rs.getString(3);
						textField.setText(str);
						str=rs.getString(6);
						textField_fr.setText(str);
						str=rs.getString(7);
						textField_cn.setText(str);
						str=rs.getString(8);
						textField_rr.setText(str);
						str=rs.getString(9);
						textField_pr.setText(str);
		
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally
				{
					Handler.disconnect(con);
				}
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		btnNewButton.setBounds(496, 64, 98, 67);
		contentPane.add(btnNewButton);
		
		JLabel label_1 = new JLabel("\u03A0\u0395\u03A1\u0399\u0393\u03A1\u0391\u03A6\u0397");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(10, 179, 73, 29);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(20, 215, 429, 80);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u0395\u039B\u0395\u03A5\u0398\u0395\u03A1\u0395\u03A3 \u0398\u0395\u03A3\u0395\u0399\u03A3:");
		label_2.setBounds(30, 306, 142, 23);
		contentPane.add(label_2);
		
		final JRadioButton radioButton = new JRadioButton("\u0395\u039C\u03A0\u03A1\u039F\u03A3");
		buttonGroup.add(radioButton);
		radioButton.setBounds(158, 336, 91, 38);
		contentPane.add(radioButton);
		
		final JRadioButton radioButton_1 = new JRadioButton("\u039A\u0395\u039D\u03A4\u03A1\u039F",true);
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(264, 336, 91, 38);
		contentPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("\u03A0\u0399\u03A3\u03A9");
		buttonGroup.add(radioButton_2);
		radioButton_2.setBounds(364, 336, 85, 38);
		contentPane.add(radioButton_2);
		
		JCheckBox checkBox = new JCheckBox("\u039C\u0395\u0399\u03A9\u039C\u0395\u039D\u039F");
		checkBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = list.getSelectedIndex();
				i++;
				String query = "select * from Tickets where ID="+i+";";
				Connection con = Handler.connect();
				ResultSet rs = Handler.executeQuery(query, con);
				
				try{
					while (rs.next()){

						String str=rs.getString(10);
						textField_pr.setText(str);
		
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally
				{
					Handler.disconnect(con);
				}

			}
		});
		checkBox.setBounds(30, 377, 98, 38);
		contentPane.add(checkBox);
		
		JLabel label_4 = new JLabel("\u0395\u03A0\u0399\u039B\u039F\u0393\u0397 \u0398\u0395\u03A3\u0397\u03A3");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(20, 340, 118, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u03A4\u0399\u039C\u0397:");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(296, 392, 47, 23);
		contentPane.add(label_5);
		
		JButton button = new JButton("\u0395\u039A\u03A4\u03A5\u03A0\u03A9\u03A3\u0397");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = list.getSelectedIndex();
				i++;
				String query=null;
				if (radioButton.isSelected()){
					int fr=Integer.parseInt(textField_fr.getText());
					fr--;
					textField_fr.setText(String.valueOf(fr));
					query = "update Tickets set Front="+fr+" where ID="+i+";";
				}else if(radioButton_1.isSelected()){
					int cn=Integer.parseInt(textField_cn.getText());
					cn--;
					textField_cn.setText(String.valueOf(cn));
					query = "update Tickets set Center="+cn+" where ID="+i+";";
				}else{
					int rr=Integer.parseInt(textField_rr.getText());
					rr--;
					textField_rr.setText(String.valueOf(rr));
					query = "update Tickets set Rear="+rr+" where ID="+i+";";
				}
				
				Connection con = Handler.connect();
				Handler.executeQuery(query, con);
		
				Handler.disconnect(con);

			}
		});
		button.setBounds(496, 343, 98, 67);
		contentPane.add(button);
		
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AdminView aView = new AdminView();
				aView.setVisible(true);
			}
		});
		btnAdmin.setBounds(496, 203, 98, 67);
		contentPane.add(btnAdmin);
		
		textField_cn = new JTextField();
		textField_cn.setHorizontalAlignment(SwingConstants.CENTER);
		textField_cn.setEditable(false);
		textField_cn.setBounds(264, 307, 91, 20);
		contentPane.add(textField_cn);
		textField_cn.setColumns(10);
		
		textField_rr = new JTextField();
		textField_rr.setHorizontalAlignment(SwingConstants.CENTER);
		textField_rr.setEditable(false);
		textField_rr.setBounds(363, 307, 86, 20);
		contentPane.add(textField_rr);
		textField_rr.setColumns(10);
		
		textField_fr = new JTextField();
		textField_fr.setHorizontalAlignment(SwingConstants.CENTER);
		textField_fr.setEditable(false);
		textField_fr.setBounds(158, 307, 91, 20);
		contentPane.add(textField_fr);
		textField_fr.setColumns(10);
		
		textField_pr = new JTextField();
		textField_pr.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_pr.setEditable(false);
		textField_pr.setBounds(364, 386, 86, 29);
		contentPane.add(textField_pr);
		textField_pr.setColumns(10);
	}
}
