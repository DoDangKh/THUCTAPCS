package QLCHUNGKHOAN;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import Entity.KeyValue;
import Entity.NHADAUTU;
import Entity.NHANVIEN;
import Service.LENHDATService;
import Service.NHADAUTUService;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Color;

public class formNDT extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaTK;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtNoiSinh;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	private JLabel lblNewLabel_3_3;
	private JTextField txtSDT;
	private JLabel lblNewLabel_3_4;
	private JTextField txtCMND;
	private JLabel lblNewLabel_3_5;
	private JLabel lblNewLabel_3_6;
	private JLabel lblNewLabel_3_7;
	private JTextField txtNoiLamViec;
	private JLabel lblNewLabel_3_8;
	private JTextField txtMaGD;
	private JLabel lblNewLabel_3_9;
	private JTextField txtMaDL;
	private JButton btnSua;
	private JButton btnXoa;
	private JScrollPane scrollPane;
	private JTable tblNDT;
	private JTextField txtNoiCap;
	private LENHDATService ldService=new LENHDATService();
	private NHADAUTUService ndtService=new NHADAUTUService();
	/**
	 * Create the frame.
	 */
	ArrayList<NHADAUTU> DSNDT= new ArrayList<NHADAUTU>();
	public formNDT(NHANVIEN N) {
		/* --------------------------------------DEFINITION--------------------------------------- */
		NHANVIEN nhanVien = N;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 661);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã tài khoản:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(184, 63, 88, 16);
		contentPane.add(lblNewLabel);
		
		txtMaTK = new JTextField();
		txtMaTK.setColumns(10);
		txtMaTK.setBounds(295, 63, 148, 22);
		contentPane.add(txtMaTK);
		
		txtHo = new JTextField();
		txtHo.setColumns(10);
		txtHo.setBounds(545, 63, 148, 22);
		contentPane.add(txtHo);
		
		JLabel lblNewLabel_1 = new JLabel("Họ:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(507, 63, 32, 16);
		contentPane.add(lblNewLabel_1);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(824, 63, 148, 22);
		contentPane.add(txtTen);
		
		JLabel lblNewLabel_2 = new JLabel("Tên:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(782, 63, 50, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ngày sinh:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(184, 111, 88, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nơi sinh:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(479, 111, 70, 16);
		contentPane.add(lblNewLabel_1_1);
		
		txtNoiSinh = new JTextField();
		txtNoiSinh.setColumns(10);
		txtNoiSinh.setBounds(545, 111, 148, 22);
		contentPane.add(txtNoiSinh);
		
		JLabel lblNewLabel_2_1 = new JLabel("Phái:");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(782, 111, 50, 16);
		contentPane.add(lblNewLabel_2_1);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(295, 283, 677, 22);
		contentPane.add(txtDiaChi);
		
		JLabel lblNewLabel_3_1 = new JLabel("Địa chỉ:");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(184, 283, 93, 16);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Email:\r\n");
		lblNewLabel_3_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3_2.setBounds(184, 155, 88, 16);
		contentPane.add(lblNewLabel_3_2);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(295, 155, 220, 22);
		contentPane.add(txtEmail);
		
		lblNewLabel_3_3 = new JLabel("Số điện thoại:");
		lblNewLabel_3_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3_3.setBounds(654, 155, 88, 16);
		contentPane.add(lblNewLabel_3_3);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(752, 155, 220, 22);
		contentPane.add(txtSDT);
		
		lblNewLabel_3_4 = new JLabel("CMND_PASSPORT:");
		lblNewLabel_3_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3_4.setBounds(184, 187, 108, 16);
		contentPane.add(lblNewLabel_3_4);
		
		txtCMND = new JTextField();
		txtCMND.setColumns(10);
		txtCMND.setBounds(295, 187, 220, 22);
		contentPane.add(txtCMND);
		
		lblNewLabel_3_5 = new JLabel("Ngày cấp:");
		lblNewLabel_3_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3_5.setBounds(654, 187, 88, 16);
		contentPane.add(lblNewLabel_3_5);
		
		lblNewLabel_3_6 = new JLabel("Nơi cấp:");
		lblNewLabel_3_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3_6.setBounds(184, 219, 88, 16);
		contentPane.add(lblNewLabel_3_6);
		
		lblNewLabel_3_7 = new JLabel("Nơi làm việc:");
		lblNewLabel_3_7.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3_7.setBounds(654, 219, 88, 16);
		contentPane.add(lblNewLabel_3_7);
		
		txtNoiLamViec = new JTextField();
		txtNoiLamViec.setColumns(10);
		txtNoiLamViec.setBounds(752, 217, 220, 22);
		contentPane.add(txtNoiLamViec);
		
		lblNewLabel_3_8 = new JLabel("Mã giao dịch:");
		lblNewLabel_3_8.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3_8.setBounds(184, 251, 88, 16);
		contentPane.add(lblNewLabel_3_8);
		
		txtMaGD = new JTextField();
		txtMaGD.setColumns(10);
		txtMaGD.setBounds(295, 251, 220, 22);
		contentPane.add(txtMaGD);
		
		lblNewLabel_3_9 = new JLabel("Mã đặt lệnh:");
		lblNewLabel_3_9.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3_9.setBounds(654, 251, 88, 16);
		contentPane.add(lblNewLabel_3_9);
		
		txtMaDL = new JTextField();
		txtMaDL.setColumns(10);
		txtMaDL.setBounds(752, 249, 220, 22);
		contentPane.add(txtMaDL);
		
		btnSua = new JButton("SỬA");
		btnSua.setBounds(660, 319, 172, 44);
		contentPane.add(btnSua);
		
		btnXoa = new JButton("XÓA");
		btnXoa.setBounds(910, 319, 172, 44);
		contentPane.add(btnXoa);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 379, 1314, 251);
		contentPane.add(scrollPane);
		
		tblNDT = new JTable();
		tblNDT.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 T.Kho\u1EA3n", "H\u1ECD", "T\u00EAn", "Ng\u00E0y sinh", "N\u01A1i sinh", "Ph\u00E1i", "\u0110\u1ECBa ch\u1EC9", "Email", "SDT", "CMND_PASSWORD", "Ng\u00E0y c\u1EA5p", "N\u01A1i c\u1EA5p", "N\u01A1i l\u00E0m vi\u1EC7c", "M\u00E3 G.D\u1ECBch", "M.Kh\u1EA9u \u0110.L\u1EC7nh"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		tblNDT.setDefaultEditor(Object.class, null);
		tblNDT.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(tblNDT);
		
		JDateChooser dtNgaySinh = new JDateChooser();
		dtNgaySinh.setBounds(295, 111, 148, 22);
		contentPane.add(dtNgaySinh);
		
		JDateChooser dtNgayCap = new JDateChooser();
		dtNgayCap.setBounds(752, 187, 220, 22);
		contentPane.add(dtNgayCap);
		
		JComboBox cmbPhai = new JComboBox();
		cmbPhai.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cmbPhai.setBounds(824, 109, 148, 21);
		contentPane.add(cmbPhai);
		
		txtNoiCap = new JTextField();
		txtNoiCap.setColumns(10);
		txtNoiCap.setBounds(295, 218, 220, 22);
		contentPane.add(txtNoiCap);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("CheckBox.border"));
		panel.setBounds(220, 309, 390, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnGhi = new JButton("GHI");
		btnGhi.setBounds(203, 10, 172, 44);
		panel.add(btnGhi);
		
		JButton btnThem = new JButton("THÊM");
		btnThem.setBounds(10, 10, 172, 44);
		panel.add(btnThem);
		
		JButton btnThoat = new JButton("Trở về>>");
		btnThoat.setBounds(996, 63, 88, 44);
		contentPane.add(btnThoat);
		
		/* --------------------------------------IMPORTANT-LOAD--------------------------------------- */
		//frame nền của message thông báo
		JFrame groundFr = new JFrame("JOptionPane showMessageDialog example");
		//load DS nhà đầu tư
		try {
			DSNDT = ndtService.loadDS_NDT(N);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(groundFr, "Lỗi load danh sách các lệnh đặt");
			dispose();
		}
		//đổ DS nhà đầu tư ra table
		DefaultTableModel modelTable = (DefaultTableModel) this.tblNDT.getModel();
		for(NHADAUTU s : DSNDT) {
			String data[]= {s.getMATK(), s.getHO(), s.getTEN(), s.getNGAYSINH(), 
					s.getNOISINH(), s.getPHAI(), s.getDIACHI(), s.getEMAIL(), 
					s.getSDT(), s.getCMND_PASSPORT(), s.getNGAYCAP(), s.getNOICAP(), 
					s.getNOILAMVIEC(), s.getMAGD(), s.getMKDATLENH() };
			modelTable.addRow(data);
		}
		//EMPTY
		txtMaTK.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtNoiSinh.setText("");
		txtEmail.setText("");
		txtSDT.setText("");
		txtCMND.setText("");
		txtNoiCap.setText("");
		txtNoiLamViec.setText("");
		txtMaGD.setText("");
		txtMaDL.setText("");
		txtDiaChi.setText("");
		cmbPhai.setSelectedIndex(-1);
		dtNgaySinh.setCalendar(null);
		dtNgayCap.setCalendar(null);
		
		JLabel lblQunLNh = new JLabel("QUẢN LÝ NHÀ ĐẦU TƯ");
		lblQunLNh.setForeground(new Color(65, 105, 225));
		lblQunLNh.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		lblQunLNh.setBounds(569, 10, 213, 27);
		contentPane.add(lblQunLNh);
		/* --------------------------------------DATASOURCE COMBOBOX--------------------------------------- */
		KeyValue[] cmbItems = new KeyValue[] {
				new KeyValue("1","One"),
				new KeyValue("2","Two")
		};
		/* --------------------------------------EVENT-FUNCTIONS--------------------------------------- */
		tblNDT.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		tblNDT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tblNDT.getSelectedRow();
				txtMaTK.setText(modelTable.getValueAt(index, 0).toString());
				txtHo.setText(modelTable.getValueAt(index, 1).toString());
				txtTen.setText(modelTable.getValueAt(index, 2).toString());
				try {
					txtNoiSinh.setText(modelTable.getValueAt(index, 4).toString());
				}catch(NullPointerException ex) {
					txtNoiSinh.setText("");
				}
				txtDiaChi.setText(modelTable.getValueAt(index, 6).toString());
				txtEmail.setText(modelTable.getValueAt(index, 7).toString());
				txtSDT.setText(modelTable.getValueAt(index, 8).toString());
				txtCMND.setText(modelTable.getValueAt(index, 9).toString());
				txtNoiCap.setText(modelTable.getValueAt(index, 11).toString());
				txtNoiLamViec.setText(modelTable.getValueAt(index, 12).toString());
				txtMaGD.setText(modelTable.getValueAt(index, 13).toString());
				txtMaDL.setText(modelTable.getValueAt(index, 14).toString());
				
				for (int i = 0; i < cmbPhai.getItemCount(); i++) {
					String item = (String)cmbPhai.getItemAt(i);
					if(item.equals(modelTable.getValueAt(index, 5).toString())) {
						cmbPhai.setSelectedIndex(i);
						break;
					}
				}
				
				String day, month, year = "";
				String birthDay = modelTable.getValueAt(index, 3).toString();
				String cardDay = modelTable.getValueAt(index, 10).toString();
				if(birthDay.equals(""))
					dtNgaySinh.setCalendar(null);
				else {
					year = birthDay.substring(0, 4);
					month = birthDay.substring(5,7);
					day = birthDay.substring(8,10);
					dtNgaySinh.setDate(ldService.getDate(day, month, year));
				}
				year = cardDay.substring(0, 4);
				month = cardDay.substring(5,7);
				day = cardDay.substring(8,10);
				dtNgayCap.setDate(ldService.getDate(day, month, year));
			}
		});

		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaTK.setText("");
				txtHo.setText("");
				txtTen.setText("");
				txtNoiSinh.setText("");
				txtEmail.setText("");
				txtSDT.setText("");
				txtCMND.setText("");
				txtNoiCap.setText("");
				txtNoiLamViec.setText("");
				txtMaGD.setText("");
				txtMaDL.setText("");
				txtDiaChi.setText("");
				
				cmbPhai.setSelectedIndex(-1);
				
				dtNgaySinh.setCalendar(null);
				dtNgayCap.setCalendar(null);
			}
		});
		btnGhi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String MATK, HO, TEN, NGAYSINH, NOISINH, PHAI, DIACHI, EMAIL, SDT, CMND_PASSPORT,
    			NGAYCAP, NOICAP, NOILAMVIEC, MAGD, MKDATLENH = "";
				String getCmbValue = "";
				
				MATK = txtMaTK.getText();
				HO = txtHo.getText();
				TEN = txtTen.getText();
				NOISINH = txtNoiSinh.getText();
				EMAIL = txtEmail.getText();
				SDT = txtSDT.getText();
				CMND_PASSPORT = txtCMND.getText();
				NOICAP = txtNoiCap.getText();
				NOILAMVIEC = txtNoiLamViec.getText();
				MAGD = txtMaGD.getText();
				MKDATLENH = txtMaDL.getText();
				DIACHI = txtDiaChi.getText();
				
				getCmbValue = (String)cmbPhai.getSelectedItem();
				PHAI = getCmbValue;
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					NGAYSINH = sdf.format(dtNgaySinh.getDate());
				}catch(NullPointerException ex) {
					NGAYSINH = "";
				}
				try {
					NGAYCAP = sdf.format(dtNgayCap.getDate());
				}catch(NullPointerException ex) {
					NGAYCAP = "";
				}
				
				NHADAUTU nhaDauTu = new NHADAUTU(MATK, HO, TEN, NGAYSINH, NOISINH, PHAI, DIACHI, EMAIL, SDT, CMND_PASSPORT,
		    			NGAYCAP, NOICAP, NOILAMVIEC, MAGD, MKDATLENH);
				if(MATK.trim().equals("") || HO.trim().equals("") || TEN.trim().equals("") || NGAYSINH.trim().equals("") 
						|| PHAI.trim().equals("") || DIACHI.trim().equals("") || EMAIL.trim().equals("") 
						|| SDT.trim().equals("") || CMND_PASSPORT.trim().equals("") || NGAYCAP.trim().equals("") 
						|| NOICAP.trim().equals("") || NOILAMVIEC.trim().equals("") || MAGD.trim().equals("") 
						|| MKDATLENH.trim().equals(""))
				{
					JOptionPane.showMessageDialog(groundFr, "Hãy Điền Đầy Đủ Thông Tin, có thể bỏ trống ngày sinh!");
					return;
				}
				
				for(NHADAUTU N: DSNDT) {
					if(N.getMATK().equals(txtMaTK.getText()) || N.getCMND_PASSPORT().equals(txtCMND.getText())) {
						JOptionPane.showMessageDialog(groundFr, "Đã tồn tại mã tài khoản hoặc số CMND này, vui lòng sửa lại!");
						return;
					}
				}
				
				if(ndtService.themNDT(nhaDauTu,N)==0) {
					JOptionPane.showMessageDialog(groundFr, "Lỗi thêm nhà đầu tư, vui lòng thử lại sau!");
					return;
				}
				
				DSNDT.add(nhaDauTu);
				String data[]= {MATK, HO, TEN, NGAYSINH, NOISINH, PHAI, DIACHI, EMAIL, SDT, CMND_PASSPORT,
		    			NGAYCAP, NOICAP, NOILAMVIEC, MAGD, MKDATLENH};
				modelTable.addRow(data);
			}
		});
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String MATK, HO, TEN, NGAYSINH, NOISINH, PHAI, DIACHI, EMAIL, SDT, CMND_PASSPORT,
    			NGAYCAP, NOICAP, NOILAMVIEC, MAGD, MKDATLENH = "";
				String getCmbValue = "";
				
				MATK = txtMaTK.getText().trim();
				HO = txtHo.getText().trim();
				TEN = txtTen.getText().trim();
				NOISINH = txtNoiSinh.getText().trim();
				EMAIL = txtEmail.getText().trim();
				SDT = txtSDT.getText().trim();
				CMND_PASSPORT = txtCMND.getText().trim();
				NOICAP = txtNoiCap.getText().trim();
				NOILAMVIEC = txtNoiLamViec.getText().trim();
				MAGD = txtMaGD.getText().trim();
				MKDATLENH = txtMaDL.getText().trim();
				DIACHI = txtDiaChi.getText().trim();
				
				getCmbValue = (String)cmbPhai.getSelectedItem();
				PHAI = getCmbValue;
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					NGAYSINH = sdf.format(dtNgaySinh.getDate());
				}catch(NullPointerException ex) {
					NGAYSINH = "";
				}
				try {
					NGAYCAP = sdf.format(dtNgayCap.getDate());
				}catch(NullPointerException ex) {
					NGAYCAP = "";
				}
				
				NHADAUTU nhaDauTu = new NHADAUTU(MATK, HO, TEN, NGAYSINH, NOISINH, PHAI, DIACHI, EMAIL, SDT, CMND_PASSPORT,
		    			NGAYCAP, NOICAP, NOILAMVIEC, MAGD, MKDATLENH);
				if(MATK.trim().equals("") || HO.trim().equals("") || TEN.trim().equals("") || NGAYSINH.trim().equals("") 
						|| PHAI.trim().equals("") || DIACHI.trim().equals("") || EMAIL.trim().equals("") 
						|| SDT.trim().equals("") || CMND_PASSPORT.trim().equals("") || NGAYCAP.trim().equals("") 
						|| NOICAP.trim().equals("") || NOILAMVIEC.trim().equals("") || MAGD.trim().equals("") 
						|| MKDATLENH.trim().equals(""))
				{
					JOptionPane.showMessageDialog(groundFr, "Hãy Điền Đầy Đủ Thông Tin, có thể bỏ trống ngày sinh!");
					return;
				}
				
				boolean check = false;
				for(NHADAUTU N: DSNDT) {
					if(N.getMATK().equals(txtMaTK.getText())) {
						check = true;
						break;
					}
				}
				if(!check) {
					JOptionPane.showMessageDialog(groundFr, "Không tìm thấy mã khách hàng muốn sửa thông tin!");
					return;
				}
				
				if(ndtService.suaNDT(nhaDauTu,N)==0) {
					JOptionPane.showMessageDialog(groundFr, "Lỗi thêm nhà đầu tư, vui lòng thử lại sau!");
					return;
				}
				
				String data[]= {MATK, HO, TEN, NGAYSINH, NOISINH, PHAI, DIACHI, EMAIL, SDT, CMND_PASSPORT,
		    			NGAYCAP, NOICAP, NOILAMVIEC, MAGD, MKDATLENH};
				for(int i=0;i<modelTable.getRowCount();i++) {
					if(String.valueOf(modelTable.getValueAt(i, 0)).equals(txtMaTK.getText())) {
						modelTable.setValueAt(nhaDauTu.getMATK(), i, 0);
						modelTable.setValueAt(nhaDauTu.getHO(), i, 1);
						modelTable.setValueAt(nhaDauTu.getTEN(), i, 2);
						modelTable.setValueAt(nhaDauTu.getNGAYSINH(), i, 3);
						modelTable.setValueAt(nhaDauTu.getNOISINH(), i, 4);
						modelTable.setValueAt(nhaDauTu.getPHAI(), i, 5);
						modelTable.setValueAt(nhaDauTu.getDIACHI(), i, 6);
						modelTable.setValueAt(nhaDauTu.getEMAIL(), i, 7);
						modelTable.setValueAt(nhaDauTu.getSDT(), i, 8);
						modelTable.setValueAt(nhaDauTu.getCMND_PASSPORT(), i, 9);
						modelTable.setValueAt(nhaDauTu.getNGAYCAP(), i, 10);
						modelTable.setValueAt(nhaDauTu.getNOICAP(), i, 11);
						modelTable.setValueAt(nhaDauTu.getNOILAMVIEC(), i, 12);
						modelTable.setValueAt(nhaDauTu.getMAGD(), i, 13);
						modelTable.setValueAt(nhaDauTu.getMKDATLENH(), i, 14);
						break;
					}
				}
			}
		});
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modelTable.getRowCount()==0) {
					JOptionPane.showMessageDialog(groundFr, "Không còn dữ liệu để xoá");
					return;
				}
				if(txtMaTK.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(groundFr, "Vui lòng nhập mã tài khoản nhà đầu tư cần xoá");
					return;
				}
				
				if(JOptionPane.showConfirmDialog(groundFr, "Bạn có chắc chắn muốn xoá lệnh mua này!")!=JOptionPane.OK_OPTION)
					return;
				
				for(NHADAUTU s: DSNDT) {
					if(s.getMATK().equals(txtMaTK.getText())) {
						//kiểm tra khoá ngoại
						if(ndtService.xoaNDT(txtMaTK.getText(),N) == 0) {
							JOptionPane.showMessageDialog(groundFr, "Lỗi xoá lệnh mua!");
							return;
						}
						
						for(int i=0;i<modelTable.getRowCount();i++) {
							if(String.valueOf(modelTable.getValueAt(i, 0)).equals(txtMaTK.getText())) {
								DSNDT.remove(i);
								modelTable.removeRow(i);
								if(modelTable.getRowCount()!=0)
									tblNDT.setRowSelectionInterval(i, i);
								break;
							}
						}
						return;
					}
				}
				JOptionPane.showMessageDialog(groundFr, "Không tồn tại mã tài khoản này!");
			}
		});btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  	dispose();
				formNhanVien frm = new formNhanVien(nhanVien);
				frm.setVisible(true);
			}
		});
	}
}
