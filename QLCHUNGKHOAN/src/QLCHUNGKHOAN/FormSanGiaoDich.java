package QLCHUNGKHOAN;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Entity.NHANVIEN;
import Entity.SANGIAODICH;
import Service.SANGGIAODICHService;

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

public class FormSanGiaoDich extends JFrame {

	private JPanel contentPane;
	private JTable tableSGD;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtmasan;
	private JTextField txttensan;
	private JButton btnluu;
	private JButton btnxoa;
	private JButton btnsua;
	private SANGGIAODICHService sgdService=new SANGGIAODICHService();
	/**
	 * Launch the application.
	 */

	ArrayList<SANGIAODICH> ar=new ArrayList<>();
	private JButton btnthoat;
	/**
	 * Create the frame.
	 */
	public FormSanGiaoDich(NHANVIEN nv) {
		setTitle("S\u00E0n Giao D\u1ECBch");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame fr = new JFrame("JOptionPane showMessageDialog example");
		setBounds(100, 100, 673, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(209, 11, 438, 239);
		contentPane.add(scrollPane);
		
		tableSGD = new JTable();
		
		tableSGD.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MASAN", "TENSAN"
			}
		));
		tableSGD.getColumnModel().getColumn(0).setPreferredWidth(72);
		tableSGD.getColumnModel().getColumn(1).setPreferredWidth(213);
		scrollPane.setViewportView(tableSGD);
		
		lblNewLabel = new JLabel("M\u00E3 s\u00E0n giao d\u1ECBch:");
		lblNewLabel.setBounds(10, 18, 189, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("T\u00EAn s\u00E0n giao d\u1ECBch:");
		lblNewLabel_1.setBounds(10, 73, 189, 14);
		contentPane.add(lblNewLabel_1);
		
		txtmasan = new JTextField();
		txtmasan.setBounds(10, 43, 189, 20);
		contentPane.add(txtmasan);
		txtmasan.setColumns(10);
		
		txttensan = new JTextField();
		txttensan.setColumns(10);
		txttensan.setBounds(10, 98, 189, 20);
		contentPane.add(txttensan);
		
		btnluu = new JButton("L\u01B0u");
		
		btnluu.setBounds(10, 139, 74, 23);
		contentPane.add(btnluu);
		
		btnxoa = new JButton("X\u00F3a");
		
		btnxoa.setBounds(126, 166, 74, 23);
		contentPane.add(btnxoa);
		
		btnsua = new JButton("S\u1EEDa");
		
		btnsua.setBounds(10, 191, 74, 23);
		contentPane.add(btnsua);
		
		btnthoat = new JButton("Thoát");
		btnthoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				FormADMIN frm=new FormADMIN(nv);
				frm.setVisible(true);
				dispose();
			}
		});
		btnthoat.setBounds(125, 218, 74, 23);
		contentPane.add(btnthoat);
		
		DefaultTableModel model=(DefaultTableModel) tableSGD.getModel();
		try
		{
			ar=sgdService.loadSGD(nv);
			for(SANGIAODICH sgd : ar)
			{
				String ob[]= { sgd.getMasan(), sgd.getTensan()};
				model.addRow(ob);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		tableSGD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectedrow=tableSGD.getSelectedRow();
				txtmasan.setText(String.valueOf(model.getValueAt(selectedrow, 0)));
				txttensan.setText(String.valueOf(model.getValueAt(selectedrow, 1)));
			}
		});
		btnluu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtmasan.getText().equals("")||txttensan.getText().equals(""))
				{
					JOptionPane.showConfirmDialog(fr, "Vui lòng điền đầy đủ thông tin", "Thông báo", JOptionPane.CLOSED_OPTION);
					return;
				}
				if(txtmasan.getText().length()>10)
				{
					JOptionPane.showConfirmDialog(fr, "Mã sàn giao dịch không vượt quá 10 kí tự", "Thông báo", JOptionPane.CLOSED_OPTION);
					return;
				}
				for(SANGIAODICH sgd:ar)
				{
					if(sgd.getMasan().equals(txtmasan.getText()))
					{
						JOptionPane.showConfirmDialog(fr, "Mã sàn giao dịch bị trùng", "Thông báo", JOptionPane.CLOSED_OPTION);
						return;
					}
					if(sgd.getTensan().equals(txttensan.getText()))
					{
						JOptionPane.showConfirmDialog(fr, "Tên sàn giao dịch bị trùng", "Thông báo", JOptionPane.CLOSED_OPTION);
						return;
					}
				}
				SANGIAODICH sgd=new SANGIAODICH();
				sgd.setMasan(txtmasan.getText());
				sgd.setTensan(txttensan.getText());
				String ob[]= { sgd.getMasan(), sgd.getTensan()};
				model.addRow(ob);
				try
				{
					Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
					String add = "INSERT INTO SANGIAODICH(MASAN, TENSAN) values(?, ?)";
					PreparedStatement pst = ketnoi.prepareStatement(add);
					pst.setString(1, sgd.getMasan());
					pst.setString(2, sgd.getTensan());
					pst.executeLargeUpdate();
				}
				catch(SQLException ex)
				{
					ex.printStackTrace();
				}
				JOptionPane.showConfirmDialog(fr, "Lưu thành công", "Thông báo", JOptionPane.CLOSED_OPTION);
				txtmasan.setText("");
				txttensan.setText("");
			}
		});
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedrow = tableSGD.getSelectedRow();
				String tmp=String.valueOf(model.getValueAt(selectedrow, 0));
				Iterator<SANGIAODICH> itor=ar.iterator();
				int i=JOptionPane.showConfirmDialog(fr, "Bạn có muốn xóa sàn giao dịch đã chọn?", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
				if(i==JOptionPane.CANCEL_OPTION)
				{
					return;
				}
				else if(i==JOptionPane.OK_OPTION)
				{
					try
					{
						while (itor.hasNext())
						{
						    SANGIAODICH sgd = itor.next();
						    if (sgd.getMasan().equals(txtmasan.getText()))
						    {
						    	itor.remove();
						    }
						}
						model.removeRow(selectedrow);
						Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
						Statement st = ketnoi.createStatement();
						String del="DELETE FROM SANGIAODICH WHERE MASAN='"+tmp+"'";
						st.executeUpdate(del);
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
				txtmasan.setText("");
				txttensan.setText("");
			}
		});
		btnsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedrow=tableSGD.getSelectedRow();
				int i=JOptionPane.showConfirmDialog(fr, "Bạn có muốn lưu lại chỉnh sửa?", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
				if(i==JOptionPane.CANCEL_OPTION)
				{
					txtmasan.setText("");
					txttensan.setText("");
					return;
				}
				else if(i==JOptionPane.OK_OPTION)
				{
					try
					{
						for(SANGIAODICH sgd:ar)
						{
							if(sgd.getMasan().equals(txtmasan.getText()))
							{
								sgd.setMasan(txtmasan.getText());
								sgd.setTensan(txttensan.getText());
								model.setValueAt(txtmasan.getText(), selectedrow, 0);
								model.setValueAt(txttensan.getText(), selectedrow, 1);
							}
						}
						Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
						String sql = "UPDATE SANGIAODICH SET TENSAN=? WHERE MASAN='"+txtmasan.getText()+"'";
						PreparedStatement pst = ketnoi.prepareStatement(sql);
						pst.setString(1, txttensan.getText());
						pst.executeLargeUpdate();
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
				txtmasan.setText("");
				txttensan.setText("");
			}
		});
	}

}
