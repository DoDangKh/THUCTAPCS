package QLCHUNGKHOAN;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Entity.NGANHANG;
import Entity.NHANVIEN;
import Service.NGANHANGService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormNganHang extends JFrame {

	private JPanel contentPane;
	private JTable tableNH;
	private JTextField txtmanh;
	private JTextField txttennh;
	private NGANHANGService nhService=new NGANHANGService();
	/**
	 * Launch the application.
	 */
	ArrayList<NGANHANG> ar=new ArrayList<>();
	/**
	 * Create the frame.
	 */
	public FormNganHang(NHANVIEN nv) {
		setTitle("Ng\u00E2n H\u00E0ng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame fr = new JFrame("JOptionPane showMessageDialog example");
		setBounds(100, 100, 802, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(346, 11, 430, 239);
		contentPane.add(scrollPane);
		
		tableNH = new JTable();
		
		tableNH.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MANH", "TENNH"
			}
		));
		tableNH.getColumnModel().getColumn(0).setPreferredWidth(80);
		tableNH.getColumnModel().getColumn(1).setPreferredWidth(380);
		scrollPane.setViewportView(tableNH);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 Ng\u00E2n H\u00E0ng:");
		lblNewLabel.setBounds(10, 18, 272, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn Ng\u00E2n H\u00E0ng: ");
		lblNewLabel_1.setBounds(10, 72, 272, 14);
		contentPane.add(lblNewLabel_1);
		
		txtmanh = new JTextField();
		txtmanh.setBounds(10, 43, 326, 20);
		contentPane.add(txtmanh);
		txtmanh.setColumns(10);
		
		txttennh = new JTextField();
		txttennh.setColumns(10);
		txttennh.setBounds(10, 97, 326, 20);
		contentPane.add(txttennh);
		
		JButton btnluu = new JButton("L\u01B0u");
		
		btnluu.setBounds(10, 128, 74, 23);
		contentPane.add(btnluu);
		
		JButton btnxoa = new JButton("X\u00F3a");
		
		btnxoa.setBounds(94, 128, 74, 23);
		contentPane.add(btnxoa);
		
		JButton btnsua = new JButton("S\u1EEDa");
		
		btnsua.setBounds(178, 128, 74, 23);
		contentPane.add(btnsua);
		
		JButton btnthoat = new JButton("Thoát");
		btnthoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormADMIN frm=new FormADMIN(nv);
				frm.setVisible(true); 
				dispose();
			}
		});
		btnthoat.setBounds(262, 128, 74, 23);
		contentPane.add(btnthoat);
		DefaultTableModel model=(DefaultTableModel) tableNH.getModel();
		try 
		{
			ar=nhService.loadNH(nv);
			for(NGANHANG nh:ar)
			{
				String ob[]= {nh.getManh(), nh.getTennh()};
				model.addRow(ob);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		tableNH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectedrow=tableNH.getSelectedRow();
				txtmanh.setText(String.valueOf(model.getValueAt(selectedrow, 0)));
				txttennh.setText(String.valueOf(model.getValueAt(selectedrow, 1)));
			}
		});
		btnluu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtmanh.getText().equals("")||txttennh.getText().equals(""))
				{
					JOptionPane.showConfirmDialog(fr, "Vui lòng điền đầy đủ thông tin", "Thông báo", JOptionPane.CLOSED_OPTION);
					return;
				}
				if(txtmanh.getText().length()>10)
				{
					JOptionPane.showConfirmDialog(fr, "Mã ngân hàng không vượt quá 10 kí tự", "Thông báo", JOptionPane.CLOSED_OPTION);
					return;
				}
				for(NGANHANG nh:ar)
				{
					if(nh.getManh().equals(txtmanh.getText()))
					{
						JOptionPane.showConfirmDialog(fr, "Mã sàn giao dịch bị trùng", "Thông báo", JOptionPane.CLOSED_OPTION);
						return;
					}
					if(nh.getTennh().equals(txttennh.getText()))
					{
						JOptionPane.showConfirmDialog(fr, "Tên ngân hàng bị trùng", "Thông báo", JOptionPane.CLOSED_OPTION);
						return;
					}
				}
				NGANHANG nh=new NGANHANG();
				nh.setManh(txtmanh.getText());
				nh.setTennh(txttennh.getText());
				String ob[]= { nh.getManh(), nh.getTennh()};
				model.addRow(ob);
				try
				{
					Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
					String add = "INSERT INTO NGANHANG(MANH, TENNH) values(?, ?)";
					PreparedStatement pst = ketnoi.prepareStatement(add);
					pst.setString(1, nh.getManh());
					pst.setString(2, nh.getTennh());
					pst.executeLargeUpdate();
				}
				catch(SQLException ex)
				{
					ex.printStackTrace();
				}
				JOptionPane.showConfirmDialog(fr, "Lưu thành công", "Thông báo", JOptionPane.CLOSED_OPTION);
				txtmanh.setText("");
				txttennh.setText("");
			}
		});
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedrow = tableNH.getSelectedRow();
				String tmp=String.valueOf(model.getValueAt(selectedrow, 0));
				Iterator<NGANHANG> itor=ar.iterator();
				int i=JOptionPane.showConfirmDialog(fr, "Bạn có muốn xóa ngân hàng đã chọn?", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
				if(i==JOptionPane.CANCEL_OPTION)
				{
					txtmanh.setText("");
					txttennh.setText("");
					return;
				}
				else if(i==JOptionPane.OK_OPTION)
				{
					try
					{
						while (itor.hasNext())
						{
						    NGANHANG nh = itor.next();
						    if (nh.getManh().equals(txtmanh.getText()))
						    {
						    	itor.remove();
						    }
						}
						model.removeRow(selectedrow);
						Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
						Statement st = ketnoi.createStatement();
						String del="DELETE FROM NGANHANG WHERE MANH='"+tmp+"'";
						st.executeUpdate(del);
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
				txtmanh.setText("");
				txttennh.setText("");
			}
		});
		btnsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedrow=tableNH.getSelectedRow();
				int i=JOptionPane.showConfirmDialog(fr, "Bạn có muốn lưu lại chỉnh sửa?", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
				if(i==JOptionPane.CANCEL_OPTION)
				{
					txtmanh.setText("");
					txttennh.setText("");
					return;
				}
				else if(i==JOptionPane.OK_OPTION)
				{
				try
				{
					for(NGANHANG nh:ar)
					{
						if(nh.getManh().equals(txtmanh.getText()))
						{
							nh.setManh(txtmanh.getText());
							nh.setTennh(txttennh.getText());
							model.setValueAt(txtmanh.getText(), selectedrow, 0);
							model.setValueAt(txttennh.getText(), selectedrow, 1);
						}
					}
					Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
					String sql = "UPDATE NGANHANG SET TENNH=? WHERE MANH='"+txtmanh.getText()+"'";
					PreparedStatement pst = ketnoi.prepareStatement(sql);
					pst.setString(1, txttennh.getText());
					pst.executeLargeUpdate();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				}
				txtmanh.setText("");
				txttennh.setText("");
			}
		});
	}

}
