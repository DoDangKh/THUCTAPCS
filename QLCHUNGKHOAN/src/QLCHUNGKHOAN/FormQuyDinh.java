package QLCHUNGKHOAN;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Entity.NHANVIEN;
import Entity.QUYDINH;
import Service.QUYDINHService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class FormQuyDinh extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtmaqd;
	private JTextField txtmota;
	private QUYDINHService qdService=new QUYDINHService();
	/**
	 * Launch the application.
	 */
	
	ArrayList<QUYDINH> ar=new ArrayList<>();
	/**
	 * Create the frame.
	 */
	public FormQuyDinh(NHANVIEN nv) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame fr = new JFrame("JOptionPane showMessageDialog example");
		setBounds(100, 100, 580, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(246, 11, 308, 239);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
					"MAQD", "MOTA"
				}
			));
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		try 
		{
			ar=qdService.loadQD(nv);
			for(QUYDINH qd:ar)
			{
				String str[]= {qd.getMaqd(), qd.getMota()};
				model.addRow(str);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectedrow=table.getSelectedRow();
				txtmaqd.setText(String.valueOf(model.getValueAt(selectedrow, 0)));
				txtmota.setText(String.valueOf(model.getValueAt(selectedrow, 1)));
			}
		});

		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 quy \u0111\u1ECBnh:");
		lblNewLabel.setBounds(10, 18, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00F4 t\u1EA3:");
		lblNewLabel_1.setBounds(10, 78, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtmaqd = new JTextField();
		txtmaqd.setBounds(10, 43, 115, 20);
		contentPane.add(txtmaqd);
		txtmaqd.setColumns(10);
		
		txtmota = new JTextField();
		txtmota.setBounds(10, 103, 226, 20);
		contentPane.add(txtmota);
		txtmota.setColumns(10);
		
		JButton btnluu = new JButton("L\u01B0u");
		
		btnluu.setBounds(10, 134, 71, 23);
		contentPane.add(btnluu);
		
		JButton btnxoa = new JButton("X\u00F3a");
		
		btnxoa.setBounds(165, 134, 71, 23);
		contentPane.add(btnxoa);
		
		JButton btnthoat = new JButton("Tho\u00E1t");
		btnthoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				FormADMIN frm=new FormADMIN(nv);
				frm.setVisible(true);
				dispose();
			}
		});
		btnthoat.setBounds(165, 178, 71, 23);
		contentPane.add(btnthoat);
		
		JButton btnsua = new JButton("S\u1EEDa");
		
		btnsua.setBounds(10, 178, 71, 23);
		contentPane.add(btnsua);
		
		
		btnluu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtmaqd.getText().equals(""))
				{
					JOptionPane.showConfirmDialog(fr, "Vui lòng điền mã quy định", "Thông báo", JOptionPane.CLOSED_OPTION);
					return;
				}
				if(txtmaqd.getText().length()>10)
				{
					JOptionPane.showConfirmDialog(fr, "Mã quy định không vượt quá 10 kí tự", "Thông báo", JOptionPane.CLOSED_OPTION);
					return;
				}
				for(QUYDINH qd:ar)
				{
					if(qd.getMaqd().equals(txtmaqd.getText()))
					{
						JOptionPane.showConfirmDialog(fr, "Mã quy định bị trùng", "Thông báo", JOptionPane.CLOSED_OPTION);
						return;
					}
				}
				QUYDINH qd=new QUYDINH();
				qd.setMaqd(txtmaqd.getText());
				qd.setMota(txtmota.getText());
				String ob[]= { qd.getMaqd(), qd.getMota()};
				model.addRow(ob);
				try
				{
					Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
					String add = "INSERT INTO QUYDINH(MAQD, MOTA) values(?, ?)";
					PreparedStatement pst = ketnoi.prepareStatement(add);
					pst.setString(1, qd.getMaqd());
					pst.setString(2, qd.getMota());
					pst.executeLargeUpdate();
				}
				catch(SQLException ex)
				{
					ex.printStackTrace();
				}
				JOptionPane.showConfirmDialog(fr, "Lưu thành công", "Thông báo", JOptionPane.CLOSED_OPTION);
				txtmaqd.setText("");
				txtmota.setText("");
			}
		});
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedrow = table.getSelectedRow();
				String tmp=String.valueOf(model.getValueAt(selectedrow, 0));
				Iterator<QUYDINH> itor=ar.iterator();
				int i=JOptionPane.showConfirmDialog(fr, "Bạn có muốn xóa quy định đã chọn?", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
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
							QUYDINH qd = itor.next();
						    if (qd.getMaqd().equals(txtmaqd.getText()))
						    {
						    	itor.remove();
						    }
						}
						model.removeRow(selectedrow);
						Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
						Statement st = ketnoi.createStatement();
						String del="DELETE FROM QUYDINH WHERE MAQD='"+tmp+"'";
						st.executeUpdate(del);
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
				txtmaqd.setText("");
				txtmota.setText("");
			}
		});
		btnsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedrow=table.getSelectedRow();
				int i=JOptionPane.showConfirmDialog(fr, "Bạn có muốn lưu lại chỉnh sửa?", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
				if(i==JOptionPane.CANCEL_OPTION)
				{
					txtmaqd.setText("");
					txtmota.setText("");
					return;
				}
				else if(i==JOptionPane.OK_OPTION)
				{
					try
					{
						for(QUYDINH qd:ar)
						{
							if(qd.getMaqd().equals(txtmaqd.getText()))
							{
								qd.setMaqd(txtmaqd.getText());
								qd.setMota(txtmota.getText());
								model.setValueAt(txtmaqd.getText(), selectedrow, 0);
								model.setValueAt(txtmota.getText(), selectedrow, 1);
							}
						}
						Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
						String sql = "UPDATE QUYDINH SET MOTA=? WHERE MAQD='"+txtmaqd.getText()+"'";
						PreparedStatement pst = ketnoi.prepareStatement(sql);
						pst.setString(1, txtmota.getText());
						pst.executeLargeUpdate();
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
				txtmaqd.setText("");
				txtmota.setText("");
			}
		});
	}
}
