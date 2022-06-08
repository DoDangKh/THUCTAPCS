package QLCHUNGKHOAN;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Entity.COPHIEU;
import Entity.NHANVIEN;
import Entity.SANGIAODICH;
import Service.COPHIEUService;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

import java.util.regex.*;

public class FormCoPhieu extends JFrame {

	private JPanel contentPane;
	private JTable tableCP;
	private JTextField txtmacp;
	private JTextField txttencty;
	private JTextField txtdiachi;
	private JTextField txtsdt;
	private JTextField txtfax;
	private JTextField txtdiachiweb;
	private JTextField txtemail;
	private JTextField txtslcp;

	/**
	 * Launch the application.
	 */
	ArrayList<COPHIEU> arr=new ArrayList<>();
	COPHIEUService cpService=new COPHIEUService();
	ArrayList<SANGIAODICH> ar=new ArrayList<>();
	/**
	 * Create the frame.
	 */
	public FormCoPhieu(NHANVIEN nv) {
		setTitle("Cổ phiếu");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame fr = new JFrame("JOptionPane showMessageDialog example");
		setBounds(100, 100, 959, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 923, 188);
		contentPane.add(scrollPane);
		
		tableCP = new JTable();
		
		scrollPane.setViewportView(tableCP);
		tableCP.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MACP", "MASAN", "TENCTY", "DIACHI", "SDT", "FAX", "DIACHIWEB", "EMAIL", "SLCP"
			}
		));
		
		JLabel lblNewLabel = new JLabel("M\u00E3 c\u1ED5 phi\u1EBFu:");
		lblNewLabel.setBounds(43, 210, 92, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 s\u00E0n:");
		lblNewLabel_1.setBounds(43, 236, 92, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("T\u00EAn c\u00F4ng ty:");
		lblNewLabel_2.setBounds(43, 261, 92, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblNewLabel_3.setBounds(43, 286, 92, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblNewLabel_4.setBounds(43, 311, 92, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("FAX:");
		lblNewLabel_5.setBounds(43, 336, 92, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u0110\u1ECBa ch\u1EC9 web:");
		lblNewLabel_6.setBounds(43, 361, 92, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Email: ");
		lblNewLabel_7.setBounds(43, 386, 92, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng c\u1ED5 phi\u1EBFu: ");
		lblNewLabel_8.setBounds(43, 411, 92, 14);
		contentPane.add(lblNewLabel_8);
		
		txtmacp = new JTextField();
		txtmacp.setBounds(145, 207, 114, 20);
		contentPane.add(txtmacp);
		txtmacp.setColumns(10);
		
		txttencty = new JTextField();
		txttencty.setColumns(10);
		txttencty.setBounds(145, 258, 226, 20);
		contentPane.add(txttencty);
		
		txtdiachi = new JTextField();
		txtdiachi.setColumns(10);
		txtdiachi.setBounds(145, 283, 226, 20);
		contentPane.add(txtdiachi);
		
		txtsdt = new JTextField();
		txtsdt.setColumns(10);
		txtsdt.setBounds(145, 308, 114, 20);
		contentPane.add(txtsdt);
		
		txtfax = new JTextField();
		txtfax.setColumns(10);
		txtfax.setBounds(145, 333, 226, 20);
		contentPane.add(txtfax);
		
		txtdiachiweb = new JTextField();
		txtdiachiweb.setColumns(10);
		txtdiachiweb.setBounds(145, 358, 226, 20);
		contentPane.add(txtdiachiweb);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(145, 383, 226, 20);
		contentPane.add(txtemail);
		
		txtslcp = new JTextField();
		txtslcp.setColumns(10);
		txtslcp.setBounds(145, 408, 114, 20);
		contentPane.add(txtslcp);
		
		JButton btnluu = new JButton("L\u01B0u");
		
		btnluu.setBounds(474, 307, 89, 23);
		contentPane.add(btnluu);
		
		JButton btnxoa = new JButton("X\u00F3a");
		
		btnxoa.setBounds(598, 307, 89, 23);
		contentPane.add(btnxoa);
		
		JButton btnsua = new JButton("S\u1EEDa");
		
		btnsua.setBounds(721, 307, 89, 23);
		contentPane.add(btnsua);
		
		JButton btnthoat = new JButton("Tho\u00E1t");
		btnthoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				FormADMIN frm=new FormADMIN(nv);
				frm.setVisible(true);
				dispose();
			}
		});
		btnthoat.setBounds(844, 307, 89, 23);
		contentPane.add(btnthoat);
		JComboBox cbb = new JComboBox();
		cbb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int sltrow=cbb.getSelectedIndex();
			}
		});
		cbb.setBounds(145, 232, 114, 22);
		contentPane.add(cbb);
		DefaultTableModel model=(DefaultTableModel) tableCP.getModel();
		try
		{
			
			arr=cpService.loadCP(nv);
			for(COPHIEU cp : arr)
			{
				String ob[]= { cp.getMacp(), cp.getMasan(), cp.getTencty(), cp.getDiachi(), cp.getSdt(), cp.getFax(), cp.getDiachiweb(), cp.getEmail(), String.valueOf(cp.getSlcp())};
				model.addRow(ob);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
        {
			Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
		    Statement st=st=ketnoi.createStatement();
            ResultSet rs=st.executeQuery("Select * From SANGIAODICH");
            while(rs.next())
            {
            	String masan=rs.getString("MASAN");
                SANGIAODICH s=new SANGIAODICH(masan);
                cbb.addItem(s.getMasan().trim());
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
		btnluu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtmacp.getText().equals("")||txttencty.getText().equals("")||txtdiachi.getText().equals("")||
						txtsdt.getText().equals("")||txtfax.getText().equals("")||txtdiachiweb.getText().equals("")||txtemail.getText().equals("")||txtslcp.getText().equals(""))
				{
					JOptionPane.showConfirmDialog(fr, "Vui lòng điền đầy đủ thông tin", "Thông báo", JOptionPane.CLOSED_OPTION);
					return;
				}
				if(txtmacp.getText().length()>10)
				{
					JOptionPane.showConfirmDialog(fr, "Mã cổ phiếu không vượt quá 10 kí tự", "Thông báo", JOptionPane.CLOSED_OPTION);
					return;
				}
				String RegexNummber="[0-9]+";
				if(!txtsdt.getText().matches(RegexNummber)) {
					JOptionPane.showMessageDialog(fr, "Số Điện Thoại Phải Là Số");
					return;
				}
				for(COPHIEU cp:arr)
				{
					if(cp.getMacp().equals(txtmacp.getText()))
					{
						JOptionPane.showConfirmDialog(fr, "Mã cổ phiếu bị trùng", "Thông báo", JOptionPane.CLOSED_OPTION);
						return;
					}
					if(cp.getTencty().equals(txttencty.getText()))
					{
						JOptionPane.showConfirmDialog(fr, "Tên công ty bị trùng", "Thông báo", JOptionPane.CLOSED_OPTION);
						return;
					}
				}
				if(Integer.valueOf(txtslcp.getText())<0)
				{
					JOptionPane.showConfirmDialog(fr, "Số lượng cổ phiếu là số dương", "Thông báo", JOptionPane.CLOSED_OPTION);
					return;
				}
				int sltrow=cbb.getSelectedIndex();
				COPHIEU cp=new COPHIEU();
				cp.setMacp(txtmacp.getText());
				cp.setMasan(String.valueOf(cbb.getItemAt(sltrow)));
				cp.setTencty(txttencty.getText());
				cp.setDiachi(txtdiachi.getText());
				cp.setSdt(txtsdt.getText());
				cp.setFax(txtfax.getText());
				cp.setDiachiweb(txtdiachiweb.getText());
				cp.setEmail(txtemail.getText());
				cp.setSlcp(Integer.valueOf(txtslcp.getText()));
				arr.add(cp);
				cpService.ThemCP(cp,nv);
				String ob[]= { cp.getMacp(), cp.getMasan(), cp.getTencty(), cp.getDiachi(), cp.getSdt(), cp.getFax(), cp.getDiachiweb(), cp.getEmail(), String.valueOf(cp.getSlcp())};
				model.addRow(ob);
				JOptionPane.showConfirmDialog(fr, "Lưu thành công", "Thông báo", JOptionPane.CLOSED_OPTION);
				txtmacp.setText("");
				txttencty.setText("");
				txtdiachi.setText("");
				txtsdt.setText("");
				txtfax.setText("");
				txtdiachiweb.setText("");
				txtemail.setText("");
				txtslcp.setText("");
			}
		});
		tableCP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectedrow = tableCP.getSelectedRow();
				txtmacp.setText(String.valueOf(model.getValueAt(selectedrow, 0)));
				String s=String.valueOf(model.getValueAt(selectedrow, 1));
				System.out.print(String.valueOf(model.getValueAt(selectedrow, 1)));
				cbb.getModel().setSelectedItem(s);
				System.out.print(cbb.getSelectedItem());
				txttencty.setText(String.valueOf(model.getValueAt(selectedrow, 2)));
				txtdiachi.setText(String.valueOf(model.getValueAt(selectedrow, 3)));
				txtsdt.setText(String.valueOf(model.getValueAt(selectedrow, 4)));
				txtfax.setText(String.valueOf(model.getValueAt(selectedrow, 5)));
				txtdiachiweb.setText(String.valueOf(model.getValueAt(selectedrow, 6)));
				txtemail.setText(String.valueOf(model.getValueAt(selectedrow, 7)));
				txtslcp.setText(String.valueOf(model.getValueAt(selectedrow, 8)));
			}
		});
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedrow = tableCP.getSelectedRow();
				String tmp=String.valueOf(model.getValueAt(selectedrow, 0));
				Iterator<COPHIEU> itor=arr.iterator();
				int i=JOptionPane.showConfirmDialog(fr, "Bạn có muốn xóa cổ phiếu đã chọn?", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
				if(i==JOptionPane.CANCEL_OPTION)
				{
					txtmacp.setText("");
					txttencty.setText("");
					txtdiachi.setText("");
					txtsdt.setText("");
					txtfax.setText("");
					txtdiachiweb.setText("");
					txtemail.setText("");
					txtslcp.setText("");
					return;
				}
				else
				{
					try
					{
						while (itor.hasNext())
						{
						    COPHIEU cp = itor.next();
						    if (cp.getMacp().equals(txtmacp.getText()))
						    {
						    	itor.remove();
						    }
						}
						model.removeRow(selectedrow);
						Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
						Statement st = ketnoi.createStatement();
						String del="DELETE FROM COPHIEU WHERE MACP='"+tmp+"'";
						st.executeUpdate(del);
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
				txtmacp.setText("");
				txttencty.setText("");
				txtdiachi.setText("");
				txtsdt.setText("");
				txtfax.setText("");
				txtdiachiweb.setText("");
				txtemail.setText("");
				txtslcp.setText("");
			}
		});
		btnsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedrow = tableCP.getSelectedRow();
				int sltrow=cbb.getSelectedIndex();
				if(!tableCP.getValueAt(selectedrow, 0).equals(txtmacp)) {
					JOptionPane.showMessageDialog(fr, "Không Được Sữa Mã Cổ Phiếu");
					return;
				}
				int i=JOptionPane.showConfirmDialog(fr, "Bạn có muốn lưu lại chỉnh sửa?", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
				if(i==JOptionPane.CANCEL_OPTION)
				{
					txtmacp.setText("");
					txttencty.setText("");
					txtdiachi.setText("");
					txtsdt.setText("");
					txtfax.setText("");
					txtdiachiweb.setText("");
					txtemail.setText("");
					txtslcp.setText("");
					return;
				}
				else if(i==JOptionPane.OK_OPTION)
				{
					try
					{
						for(COPHIEU cp:arr)
						{
							if(cp.getMacp().equals(txtmacp.getText()))
							{
								cp.setMacp(txtmacp.getText());
								cp.setMasan(String.valueOf(cbb.getItemAt(sltrow)));
								cp.setTencty(txttencty.getText());
								cp.setDiachi(txtdiachi.getText());
								cp.setSdt(txtsdt.getText());
								cp.setFax(txtfax.getText());
								cp.setDiachiweb(txtdiachiweb.getText());
								cp.setEmail(txtemail.getText());
								cp.setSlcp(Integer.valueOf(txtslcp.getText()));
								model.setValueAt(txtmacp.getText(), selectedrow, 0);
								model.setValueAt(String.valueOf(cbb.getItemAt(sltrow)), selectedrow, 1);
								model.setValueAt(txttencty.getText(), selectedrow, 2);
								model.setValueAt(txtdiachi.getText(), selectedrow, 3);
								model.setValueAt(txtsdt.getText(), selectedrow, 4);
								model.setValueAt(txtfax.getText(), selectedrow, 5);
								model.setValueAt(txtdiachiweb.getText(), selectedrow, 6);
								model.setValueAt(txtemail.getText(), selectedrow, 7);
								model.setValueAt(txtslcp.getText(), selectedrow, 8);
							}
						}
						Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
						String sql = "UPDATE COPHIEU SET TENCTY=?, DIACHI=?, SDT=?, FAX=?, DIACHIWEB=?, EMAIL=?, SLCP=? WHERE MACP='"+txtmacp.getText()+"'";
						PreparedStatement pst = ketnoi.prepareStatement(sql);
						pst.setString(1, txttencty.getText());
						pst.setString(2, txtdiachi.getText());
						pst.setString(3, txtsdt.getText());
						pst.setString(4, txtfax.getText());
						pst.setString(5, txtdiachiweb.getText());
						pst.setString(6, txtemail.getText());
						pst.setInt(7, Integer.valueOf(txtslcp.getText()));
						pst.executeLargeUpdate();
					}
					catch(Exception exx)
					{
						exx.printStackTrace();
					}
					txtmacp.setText("");
					txttencty.setText("");
					txtdiachi.setText("");
					txtsdt.setText("");
					txtfax.setText("");
					txtdiachiweb.setText("");
					txtemail.setText("");
					txtslcp.setText("");
				}
			}
		});
	}
}
