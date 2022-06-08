package QLCHUNGKHOAN;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.naming.directory.AttributeModificationException;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.eclipse.ui.internal.e4.compatibility.ModeledFolderLayout;

import Entity.LENHDAT;
import Entity.NHANVIEN;
import Service.BackupAndRestore;
import Service.LENHDATService;
import Service.NHANVIENService;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class FormADMIN extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldHO;
	private JTextField textFieldTEN;
	private JTextField textFieldDIACHI;
	private JTextField textFieldSODIENTHOAI;
	private JTextField textFieldLuong;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldTaiKhoan;
	private JPasswordField passwordField;
	private JTable table;
	private BackupAndRestore barService=new BackupAndRestore();
	private LENHDATService ldService;
	/**
	 * Launch the application.
	 */
	NHANVIENService nvService=new NHANVIENService();
	/**
	 * Create the frame.
	 */
	NHANVIEN temp=new NHANVIEN();
	public FormADMIN(NHANVIEN nv) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 163, 516);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Sao Lưu Dữ Liệu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if(barService.Backup(nv)) JOptionPane.showMessageDialog(btnNewButton, "Đã Sao Lưu Dữ Liệu Thành Công");;
				String path=System.getProperty("user.dir");
				JOptionPane.showMessageDialog(panel, path);
			}
		});
		btnNewButton.setBounds(10, 10, 153, 80);
		panel.add(btnNewButton);
		
		JButton btnQuanr = new JButton("Quản Lý Ngân Hàng");
		btnQuanr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormNganHang frm=new FormNganHang(nv);
				frm.setVisible(true);
				dispose();
			}
		});
		btnQuanr.setBounds(10, 100, 153, 80);
		panel.add(btnQuanr);
		
		JButton btnQunLSn = new JButton("Quản Lý \r\nSàn Giao Dịch");
		btnQunLSn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormSanGiaoDich frm=new FormSanGiaoDich(nv);
				frm.setVisible(true);
				dispose();
			}
		});
		btnQunLSn.setBounds(10, 190, 153, 80);
		panel.add(btnQunLSn);
		
		JButton btnQunLC = new JButton("Quản Lý \r\nCổ Phiếu");
		btnQunLC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormCoPhieu frm=new FormCoPhieu(nv);
				frm.setVisible(true);
				dispose();
			}
		});
		//Nữ
		btnQunLC.setBounds(10, 280, 153, 80);
		panel.add(btnQunLC);
		
		JButton btnNewButton_5 = new JButton("Quản Lý Quy Định");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormQuyDinh frm=new FormQuyDinh(nv);
				frm.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setBounds(10, 370, 153, 80);
		panel.add(btnNewButton_5);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(106, 132, 98, 19);
	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(183, 10, 652, 516);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.add(dateChooser);
		textFieldHO = new JTextField();
		textFieldHO.setBounds(106, 12, 96, 19);
		panel_1.add(textFieldHO);
		textFieldHO.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("H\u1ECD");
		lblNewLabel.setBounds(10, 13, 67, 16);
		panel_1.add(lblNewLabel);
		
		textFieldTEN = new JTextField();
		textFieldTEN.setBounds(106, 45, 96, 19);
		panel_1.add(textFieldTEN);
		textFieldTEN.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn");
		lblNewLabel_1.setBounds(10, 48, 45, 13);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u0110\u1ECBa Ch\u1EC9");
		lblNewLabel_2.setBounds(249, 15, 45, 13);
		panel_1.add(lblNewLabel_2);
		
		textFieldDIACHI = new JTextField();
		textFieldDIACHI.setBounds(326, 10, 96, 19);
		panel_1.add(textFieldDIACHI);
		textFieldDIACHI.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i");
		lblNewLabel_3.setBounds(249, 48, 67, 13);
		panel_1.add(lblNewLabel_3);
		
		textFieldSODIENTHOAI = new JTextField();
		textFieldSODIENTHOAI.setBounds(326, 45, 96, 19);
		panel_1.add(textFieldSODIENTHOAI);
		textFieldSODIENTHOAI.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("L\u01B0\u01A1ng");
		lblNewLabel_4.setBounds(10, 77, 45, 13);
		panel_1.add(lblNewLabel_4);
		
		textFieldLuong = new JTextField();
		textFieldLuong.setText("");
		textFieldLuong.setBounds(106, 74, 96, 19);
		panel_1.add(textFieldLuong);
		textFieldLuong.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Ph\u00E1i");
		lblNewLabel_5.setBounds(249, 77, 45, 13);
		panel_1.add(lblNewLabel_5);
		
		JRadioButton RadioButtonNAM = new JRadioButton("Nam");
		RadioButtonNAM.setSelected(true);
		buttonGroup.add(RadioButtonNAM);
		RadioButtonNAM.setBounds(319, 73, 103, 21);
		panel_1.add(RadioButtonNAM);
		
		JRadioButton RadioButtonNu = new JRadioButton("N\u1EEF");
		buttonGroup.add(RadioButtonNu);
		RadioButtonNu.setBounds(424, 73, 103, 21);
		panel_1.add(RadioButtonNu);
		
		JLabel lblNewLabel_6 = new JLabel("T\u00E0i Kho\u1EA3n");
		lblNewLabel_6.setBounds(10, 106, 67, 13);
		panel_1.add(lblNewLabel_6);
		
		textFieldTaiKhoan = new JTextField();
		textFieldTaiKhoan.setBounds(106, 103, 96, 19);
		panel_1.add(textFieldTaiKhoan);
		textFieldTaiKhoan.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("M\u1EADt Kh\u1EA9u");
		lblNewLabel_7.setBounds(249, 106, 45, 13);
		panel_1.add(lblNewLabel_7);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(326, 100, 96, 19);
		panel_1.add(passwordField);
		
		JScrollPane scrollPane = new JScrollPane();
	
		scrollPane.setBounds(10, 193, 632, 267);
		panel_1.add(scrollPane);
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Nh\u00E2n Vi\u00EAn", "H\u1ECD", "T\u00EAn", "Ph\u00E1i", "\u0110\u1ECBa Ch\u1EC9", "S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i", "L\u01B0\u01A1ng", "Ng\u00E0y Sinh"
			}
		));
		List<NHANVIEN> NVList=nvService.getList(nv);
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index=table.getSelectedRow();
				temp.setMANV(Integer.parseInt(String.valueOf(model.getValueAt(index, 0))));
				temp.setHO(String.valueOf(model.getValueAt(index, 1)));
				temp.setTEN(String.valueOf(model.getValueAt(index, 2)));
				temp.setPHAI(String.valueOf(model.getValueAt(index, 3)));
				temp.setDIACHI(String.valueOf(model.getValueAt(index, 4)));
				temp.setSDT(String.valueOf(model.getValueAt(index, 5)));
				temp.setLuong(Integer.parseInt(String.valueOf(model.getValueAt(index, 6))));
				temp.setTaikhoan(nvService.getTK(temp.getMANV(),nv));
				temp.setMatkhau(nvService.getMK(temp.getMANV(),nv));
				temp.setNGAYSINH(String.valueOf(model.getValueAt(index, 7)));
				textFieldHO.setText(temp.getHO());
				textFieldTEN.setText(temp.getTEN());
				textFieldDIACHI.setText(temp.getDIACHI());
				textFieldSODIENTHOAI.setText(temp.getSDT());
				textFieldLuong.setText(String.valueOf(temp.getLuong()));
				if(temp.getPHAI().equals("Nam")) {
					RadioButtonNAM.setSelected(true);
				}
				else {
					RadioButtonNu.setSelected(true);
				}
				textFieldTaiKhoan.setText(temp.getTaikhoan());
				passwordField.setText(temp.getMatkhau());
				String day,month,year;
				year=temp.getNGAYSINH().substring(0,4);
				month=temp.getNGAYSINH().substring(5,7);
				day=temp.getNGAYSINH().substring(8,10);
				dateChooser.setDate(ldService.getDate(day, month, year));
				System.out.print(temp.getTaikhoan().length()+" "+temp.getMatkhau().length());
			}
		});
		for(NHANVIEN s:NVList) {
			String data[]= {String.valueOf(s.getMANV()),s.getHO(),s.getTEN(),s.getPHAI(),s.getDIACHI(),s.getSDT(),String.valueOf(s.getLuong()),s.getNGAYSINH()	};
			model.addRow(data);
		}	
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Tho\u00E1t");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				FromDangNhap frm=new FromDangNhap();
				frm.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(489, 485, 85, 21);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("X\u00F3a");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int MANV=Integer.parseInt(String.valueOf(model.getValueAt(table.getSelectedRow(), 0)));
				if(nvService.delete(MANV,textFieldTaiKhoan.getText(),nv)) {
					JOptionPane.showMessageDialog(contentPane, "Xóa Thành Công");
					model.removeRow(table.getSelectedRow());
					NHANVIEN deletevalue=null;
					for(NHANVIEN s:NVList) {
						if(s.getMANV()==MANV) {
							deletevalue=s;
							break;
						}
					}
					NVList.remove(deletevalue);
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Xóa Thất Bại");
				}
			}
		});
		btnNewButton_2.setBounds(394, 485, 85, 21);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("L\u01B0u");
		btnNewButton_3.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String regexHo="[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ ]+";
				String regexTen="[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]+";
				String regexNumber="[0-9]+";
				String regexDiaChi="[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ 0-9]+";
				if(textFieldHO.getText().matches(regexHo)&&textFieldTEN.getText().matches(regexTen)&&textFieldDIACHI.getText().matches(regexDiaChi)&&textFieldLuong.getText().matches(regexNumber)&&textFieldSODIENTHOAI.getText().matches(regexNumber)&&dateChooser!=null)
				{
					if(temp.getMANV()==0) {
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						String NGAYSINH= sdf.format(dateChooser.getDate());
						temp.setNGAYSINH(NGAYSINH);
						temp.setMANV(NVList.size()+1);
						temp.setHO(textFieldHO.getText());
						temp.setTEN(textFieldTEN.getText());
						temp.setDIACHI(textFieldDIACHI.getText());
						temp.setSDT(textFieldSODIENTHOAI.getText());
						temp.setLuong(Integer.parseInt(textFieldLuong.getText()));
						if(RadioButtonNAM.isSelected()) {
							temp.setPHAI("Nam");
						}
						else {
							temp.setPHAI("Nữ");
						}
						temp.setTaikhoan(textFieldTaiKhoan.getText());
						temp.setMatkhau(passwordField.getText());
						NVList.add(temp);
						if(nvService.Insert(temp,nv)) {
							JOptionPane.showMessageDialog(contentPane, "Thêm Thành Công");
							String data[]= {String.valueOf(temp.getMANV()),temp.getHO(),temp.getTEN(),temp.getPHAI(),temp.getDIACHI(),temp.getSDT(),String.valueOf(temp.getLuong()),temp.getNGAYSINH()};
							model.addRow(data);
						}
						else {
							JOptionPane.showMessageDialog(contentPane, "Thêm Thất Bại");
						}
					}
					else {
						temp.setHO(textFieldHO.getText());
						temp.setTEN(textFieldTEN.getText());
						temp.setDIACHI(textFieldDIACHI.getText());
						temp.setSDT(textFieldSODIENTHOAI.getText());
						temp.setLuong(Integer.parseInt(textFieldLuong.getText()));
						if(RadioButtonNAM.isSelected()) {
							temp.setPHAI("Nam");
						}
						else {
							temp.setPHAI("Nữ");
						}
						temp.setTaikhoan(textFieldTaiKhoan.getText());
						temp.setMatkhau(passwordField.getText());
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						temp.setNGAYSINH(sdf.format(dateChooser.getDate()));
						System.out.print(textFieldHO.getText());
						if (nvService.update(temp,nv)) {
							String data[]= {String.valueOf(temp.getMANV()),temp.getHO(),temp.getTEN(),temp.getPHAI(),temp.getDIACHI(),temp.getSDT(),String.valueOf(temp.getLuong()),temp.getNGAYSINH()};
							for(int i=0;i<model.getRowCount();i++) {
								if(model.getValueAt(i, 0).equals(temp.getMANV())) {
									for(int j=0;j<data.length;j++) {
										model.setValueAt(data[j], i, j);
									}
								}
							}
						}
						
					}
				}
				else {
					JOptionPane.showMessageDialog(panel, "Dữ Liệu Nhập Vào Sai Định Dạng Hãy Nhập Lại");
				}
			}
		});
		btnNewButton_3.setBounds(299, 485, 85, 21);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Reset");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldHO.setText("");
				textFieldTEN.setText("");
				textFieldDIACHI.setText("");
				textFieldSODIENTHOAI.setText("");
				textFieldLuong.setText("");
				textFieldTaiKhoan.setText("");
				passwordField.setText("");
				temp=new NHANVIEN();
			}
		});
		btnNewButton_4.setBounds(209, 485, 85, 21);
		panel_1.add(btnNewButton_4);
		
	
		
		JLabel lblNewLabel_8 = new JLabel("Ngày Sinh");
		lblNewLabel_8.setBounds(10, 138, 67, 13);
		panel_1.add(lblNewLabel_8);
	}
}
