package QLCHUNGKHOAN;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Service.BackupAndRestore;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Recovery extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	private String selectedname=null;
	private ArrayList<String> listfile= new ArrayList<String>();
	private BackupAndRestore bar=new BackupAndRestore();
	/**
	 * Create the frame.
	 */
	public Recovery() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 855, 387);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedname=String.valueOf(table.getValueAt(table.getSelectedRow(),0));
				
				for(int i=0;i<table.getRowCount();i++) {
					listfile.add(String.valueOf(table.getValueAt(i, 0)));
				}
				System.out.print(selectedname);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"T\u00EAn File"
			}
		));
		String path=System.getProperty("user.dir");
		path+="\\Backup";
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		final File folder =new File(path);
		for(final File fileEntry:	folder.listFiles() ) {
			String data[]= {fileEntry.getName()};
			model.addRow(data);
		}
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("D\u1EEF li\u1EC7u c\u1EE7a b\u1EA1n \u0111\u00E3 b\u1ECB m\u1EA5t h\u00E3y l\u1EF1a file backup \u0111\u1EC3 kh\u00F4i ph\u1EE5c d\u1EEF li\u1EC7u");
		lblNewLabel.setBounds(10, 10, 855, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Tho\u00E1t");
		btnNewButton.setBounds(780, 503, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Kh\u00F4i Ph\u1EE5c");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedname==null) {
					JOptionPane.showMessageDialog(btnNewButton, "Hãy Chọn file backup bạn muốn");
				}
				else {
					if(bar.restore(selectedname, listfile)) {
						JOptionPane.showMessageDialog(btnNewButton_1, "Khôi Phục Thành Công");
						FromDangNhap frm=new FromDangNhap();
						frm.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(btnNewButton_1, "Khôi Phục Thất Bại");
					}
				}
			}
		});
		btnNewButton_1.setBounds(628, 503, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
