package QLCHUNGKHOAN;
//JOptionPane.showMessageDialog(groundFr, "Hãy Điền Đầy Đủ Thông Tin");
//3 Bước để thêm 1 mẩu tin: 1/Kiểm tra khoá chính, 2/Thêm mẩu tin vào csdl, 3/Thêm 1 row vào ArrayList của table
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import Entity.KeyValue;
import Entity.LENHDAT;
import Entity.NHANVIEN;
import Service.LENHDATService;

import java.awt.Scrollbar;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;

public class formLENHDAT extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaLenh;
	private JLabel lblMTiKhon;
	private JComboBox<KeyValue> cmbCoPhieu;
	private JLabel lblNewLabel_2;
	private JComboBox cmbLoaiGD;
	private JLabel lblLoiGiaoDch;
	private JLabel lblMTrngThi;
	private JComboBox<String> cmbTKNH;
	private JLabel lblMLoiLnh;
	private JComboBox<KeyValue> cmbLoaiLenh;
	private JComboBox<KeyValue> cmbTT;
	private JLabel lblMTrngThi_1;
	private JTextField txtSLDat;
	private JLabel lblSLngt;
	private JTextField txtGiaDat;
	private JLabel lblNewLabel_3;
	private JTable tblLENHDAT;
	private JPanel panel;
	private JButton btnGhi;
	private JButton btnThem;
	private LENHDATService ldService=new LENHDATService();
	/**
	 * Create the frame.
	 */

	ArrayList<LENHDAT> DSLD = new ArrayList<LENHDAT>();
	private JButton btnThoat;
	private JLabel lblQunLt;
	public formLENHDAT(NHANVIEN N) {
		/* --------------------------------------DEFINITION--------------------------------------- */
		NHANVIEN nhanVien = N;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 974, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtMaLenh = new JTextField();
		txtMaLenh.setColumns(10);
		txtMaLenh.setBounds(156, 65, 172, 22);
		contentPane.add(txtMaLenh);
		
		JLabel lblNewLabel = new JLabel("Mã lệnh đặt:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(31, 65, 90, 16);
		contentPane.add(lblNewLabel);
		
		lblMTiKhon = new JLabel("Mã cổ phiếu:");
		lblMTiKhon.setFont(new Font("Arial", Font.BOLD, 12));
		lblMTiKhon.setBounds(450, 109, 90, 16);
		contentPane.add(lblMTiKhon);
		
		cmbCoPhieu = new JComboBox<KeyValue>();
		cmbCoPhieu.setBounds(541, 107, 389, 21);
		contentPane.add(cmbCoPhieu);
		
		lblNewLabel_2 = new JLabel("Ngày giờ đặt: ");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(31, 193, 90, 16);
		contentPane.add(lblNewLabel_2);
		
		cmbLoaiGD = new JComboBox();
		cmbLoaiGD.setModel(new DefaultComboBoxModel(new String[] {"M", "B"}));
		cmbLoaiGD.setBounds(156, 106, 172, 21);
		contentPane.add(cmbLoaiGD);
		
		lblLoiGiaoDch = new JLabel("Loại giao dịch:");
		lblLoiGiaoDch.setFont(new Font("Arial", Font.BOLD, 12));
		lblLoiGiaoDch.setBounds(31, 108, 92, 16);
		contentPane.add(lblLoiGiaoDch);
		
		lblMTrngThi = new JLabel("Mã tài khoản NH:");
		lblMTrngThi.setFont(new Font("Arial", Font.BOLD, 12));
		lblMTrngThi.setBounds(31, 151, 101, 16);
		contentPane.add(lblMTrngThi);
		
		cmbTKNH = new JComboBox();
		cmbTKNH.setBounds(154, 152, 174, 21);
		contentPane.add(cmbTKNH);
		
		lblMLoiLnh = new JLabel("Mã loại lệnh:");
		lblMLoiLnh.setFont(new Font("Arial", Font.BOLD, 12));
		lblMLoiLnh.setBounds(450, 151, 72, 16);
		contentPane.add(lblMLoiLnh);
		
		cmbLoaiLenh = new JComboBox();
		cmbLoaiLenh.setBounds(541, 151, 389, 21);
		contentPane.add(cmbLoaiLenh);
		
		cmbTT = new JComboBox();
		cmbTT.setBounds(540, 65, 155, 21);
		contentPane.add(cmbTT);
		
		lblMTrngThi_1 = new JLabel("Mã trạng thái:");
		lblMTrngThi_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblMTrngThi_1.setBounds(449, 65, 90, 16);
		contentPane.add(lblMTrngThi_1);
		
		txtSLDat = new JTextField();
		txtSLDat.setColumns(10);
		txtSLDat.setBounds(156, 235, 172, 22);
		contentPane.add(txtSLDat);
		
		lblSLngt = new JLabel("Số lượng đặt:");
		lblSLngt.setFont(new Font("Arial", Font.BOLD, 12));
		lblSLngt.setBounds(31, 237, 90, 16);
		contentPane.add(lblSLngt);
		
		txtGiaDat = new JTextField();
		txtGiaDat.setColumns(10);
		txtGiaDat.setBounds(540, 235, 172, 22);
		contentPane.add(txtGiaDat);
		
		lblNewLabel_3 = new JLabel("Giá đặt:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(450, 237, 75, 16);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 339, 938, 268);
		contentPane.add(scrollPane);
		
		tblLENHDAT = new JTable();
		
		tblLENHDAT.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 l\u1EC7nh", "M\u00E3 c\u1ED5 phi\u1EBFu", "M\u00E3 t\u00E0i kho\u1EA3n NH", "Lo\u1EA1i G.D\u1ECBch", "SL \u0111\u1EB7t", "Gi\u00E1 \u0111\u1EB7t", "Ng\u00E0y gi\u1EDD", "M\u00E3 T.Th\u00E1i", "M\u00E3 lo\u1EA1i l\u1EC7nh"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblLENHDAT.setDefaultEditor(Object.class, null);
		tblLENHDAT.getColumnModel().getColumn(0).setResizable(false);
		tblLENHDAT.getColumnModel().getColumn(0).setPreferredWidth(60);
		tblLENHDAT.getColumnModel().getColumn(0).setMaxWidth(115);
		tblLENHDAT.getColumnModel().getColumn(1).setResizable(false);
		tblLENHDAT.getColumnModel().getColumn(1).setMaxWidth(100);
		tblLENHDAT.getColumnModel().getColumn(3).setMaxWidth(100);
		tblLENHDAT.getColumnModel().getColumn(4).setMaxWidth(100);
		tblLENHDAT.getColumnModel().getColumn(7).setMaxWidth(100);
		tblLENHDAT.getColumnModel().getColumn(8).setMaxWidth(100);
		scrollPane.setViewportView(tblLENHDAT);
		
		JButton btnXoa = new JButton("XÓA");
		btnXoa.setBounds(758, 285, 172, 44);
		contentPane.add(btnXoa);
		
		JButton btnSua = new JButton("SỬA");
		btnSua.setBounds(523, 285, 172, 44);
		contentPane.add(btnSua);
		
		JDateChooser dtDateChooser = new JDateChooser();
		dtDateChooser.setBounds(379, 190, 158, 22);
		contentPane.add(dtDateChooser);
		
		JLabel lblNewLabel_2_1 = new JLabel("Giờ:");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(121, 194, 30, 16);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Phút:");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(235, 193, 30, 16);
		contentPane.add(lblNewLabel_2_1_1);
		
		JSpinner spHour = new JSpinner();
		spHour.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spHour.setBounds(154, 193, 60, 20);
		contentPane.add(spHour);
		
		JSpinner spMinute = new JSpinner();
		spMinute.setModel(new SpinnerNumberModel(0, 0, 60, 1));
		spMinute.setBounds(268, 192, 60, 20);
		contentPane.add(spMinute);
		
		panel = new JPanel();
		panel.setBorder(UIManager.getBorder("CheckBox.border"));
		panel.setLayout(null);
		panel.setBounds(79, 274, 390, 62);
		contentPane.add(panel);
		
		btnGhi = new JButton("GHI");
		btnGhi.setBounds(203, 10, 172, 44);
		panel.add(btnGhi);
		
		btnThem = new JButton("THÊM");
		
		btnThem.setBounds(10, 10, 172, 44);
		panel.add(btnThem);
		/* --------------------------------------DATASOURCE COMBOBOX--------------------------------------- */
		  cmbTT.setModel(new DefaultComboBoxModel<KeyValue>(ldService.loadDS_TrangThai(N)));
		  cmbCoPhieu.setModel(new DefaultComboBoxModel<KeyValue>(ldService.loadDS_CoPhieu(N)));
		  cmbTKNH.setModel(new DefaultComboBoxModel<String>(ldService.loadDS_TKNH(N)));
		  cmbLoaiLenh.setModel(new DefaultComboBoxModel<KeyValue>(ldService.loadDS_MaLoaiLenh(N)));
		  
		  btnThoat = new JButton("Trở về>>");
		  btnThoat.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  	dispose();
			formNhanVien frm = new formNhanVien(nhanVien);
			frm.setVisible(true);
		  	}
		  });
		  btnThoat.setBounds(842, 53, 88, 44);
		  contentPane.add(btnThoat);
		/* --------------------------------------IMPORTANT-LOAD--------------------------------------- */
			//frame nền của message thông báo
			JFrame groundFr = new JFrame("JOptionPane showMessageDialog example");
			//load DS lệnh đặt
			try {
				DSLD = ldService.loadDS_LD(N);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(groundFr, "Lỗi load danh sách các lệnh đặt");
				dispose();
			}
			//đổ DS lệnh đặt ra table
			DefaultTableModel modelTable = (DefaultTableModel) this.tblLENHDAT.getModel();
			for(LENHDAT s : DSLD) {
				String data[]= {s.getMALENH(), s.getMACP(), s.getMATKNH(), s.getLOAIGD(), 
						s.getSLDAT(), s.getGIADAT(), s.getNGAYGIODAT(), s.getMATT(),s.getMALOAILENH() };
				modelTable.addRow(data);
			}
			//EMPTY
			spHour.setValue(0);
			spMinute.setValue(0);					
			txtMaLenh.setText("");
			txtSLDat.setText("");
			txtGiaDat.setText("");
			cmbTT.setSelectedIndex(-1);
			cmbCoPhieu.setSelectedIndex(-1);
			cmbLoaiGD.setSelectedIndex(-1);
			cmbTKNH.setSelectedIndex(-1);
			cmbLoaiLenh.setSelectedIndex(-1);
			
			lblQunLt = new JLabel("QUẢN LÝ ĐẶT LỆNH");
			lblQunLt.setForeground(new Color(65, 105, 225));
			lblQunLt.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
			lblQunLt.setBounds(403, 10, 192, 27);
			contentPane.add(lblQunLt);
			/* --------------------------------------EVENT-FUNCTIONS--------------------------------------- */
			btnThem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtMaLenh.setText("");
					txtSLDat.setText("");
					txtGiaDat.setText("");
					cmbTT.setSelectedIndex(-1);
					cmbCoPhieu.setSelectedIndex(-1);
					cmbLoaiGD.setSelectedIndex(-1);
					cmbTKNH.setSelectedIndex(-1);
					cmbLoaiLenh.setSelectedIndex(-1);
					
					//ngày giờ thêm tự động tạo
					DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
				    DateTimeFormatter hourFormat = DateTimeFormatter.ofPattern("HH");
				    DateTimeFormatter minuteFormat = DateTimeFormatter.ofPattern("mm");
				    LocalDateTime now = LocalDateTime.now();  
				    spHour.setValue(Integer.valueOf(hourFormat.format(now)));
				    spMinute.setValue(Integer.valueOf(minuteFormat.format(now)));					
				    try {
				    	Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateFormat.format(now));
				    	System.out.println(dateFormat.format(now));
				    	dtDateChooser.setDate(date);
				    }catch(ParseException ex) {}
				}
			});
			tblLENHDAT.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = tblLENHDAT.getSelectedRow();
					txtMaLenh.setText(modelTable.getValueAt(index, 0).toString());
					txtSLDat.setText(modelTable.getValueAt(index, 4).toString());
					txtGiaDat.setText(modelTable.getValueAt(index, 5).toString());	
					
					String day, month, year = "";
					String date = modelTable.getValueAt(index, 6).toString();
					year = date.substring(0, 4);
					month = date.substring(5,7);
					day = date.substring(8,10);
					dtDateChooser.setDate(ldService.getDate(day, month, year));
					
					spHour.setValue(Integer.valueOf(date.substring(11,13)));
					spMinute.setValue(Integer.valueOf(date.substring(14, 16)));
					
					for (int i = 0; i < cmbTT.getItemCount(); i++) {
						KeyValue item = (KeyValue)cmbTT.getItemAt(i);
						if(item.getValue().equals(modelTable.getValueAt(index, 7).toString())) {
							cmbTT.setSelectedIndex(i);
							break;
						}
					}
					
					for (int i = 0; i < cmbTKNH.getItemCount(); i++) {
						String item = (String)cmbTKNH.getItemAt(i);
						if(item.equals(modelTable.getValueAt(index, 2).toString())) {
							cmbTKNH.setSelectedIndex(i);
							break;
						}
					}
					for (int i = 0; i < cmbLoaiLenh.getItemCount(); i++) {
						KeyValue item = (KeyValue)cmbLoaiLenh.getItemAt(i);
						if(item.getValue().equals(modelTable.getValueAt(index, 8).toString())) {
							cmbLoaiLenh.setSelectedIndex(i);
							break;
						}
					}
					for (int i = 0; i < cmbCoPhieu.getItemCount(); i++) {
						KeyValue item = (KeyValue)cmbCoPhieu.getItemAt(i);
						if(item.getValue().equals(modelTable.getValueAt(index, 1).toString())) {
							cmbCoPhieu.setSelectedIndex(i);
							break;
						}
					}
					for (int i = 0; i < cmbLoaiGD.getItemCount(); i++) {
						String item = (String)cmbLoaiGD.getItemAt(i);
						if(item.equals(modelTable.getValueAt(index, 3).toString().trim())) {
							cmbLoaiGD.setSelectedIndex(i);
							break;
						}
					}
				}
			});
			btnGhi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String MALENH, MACP, MATKNH, LOAIGD, SLDAT, GIADAT, NGAYGIODAT, MATT, MALOAILENH = "";
					KeyValue getCmbValue = new KeyValue();
					
					MALENH = txtMaLenh.getText();
					SLDAT = txtSLDat.getText();
					GIADAT = txtGiaDat.getText();
					LOAIGD = (String)cmbLoaiGD.getSelectedItem();
					MATKNH = (String)cmbTKNH.getSelectedItem();
					
					try {
						getCmbValue = (KeyValue)cmbTT.getSelectedItem();
						MATT = getCmbValue.getValue();
						getCmbValue = (KeyValue)cmbCoPhieu.getSelectedItem();
						MACP = getCmbValue.getValue();
						getCmbValue = (KeyValue)cmbLoaiLenh.getSelectedItem();
						MALOAILENH = getCmbValue.getValue();
					}catch(NullPointerException ex) {
						JOptionPane.showMessageDialog(groundFr, "Hãy Điền Đầy Đủ Thông Tin");
						return;
					}
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					try {
						NGAYGIODAT = sdf.format(dtDateChooser.getDate())+" "+spHour.getValue()+":"+spMinute.getValue()+":00.000";
					}catch(NullPointerException ex) {
						NGAYGIODAT = "";
					}
					
					LENHDAT lenhDat = new LENHDAT(MALENH, MACP, MATKNH, LOAIGD, SLDAT, GIADAT, NGAYGIODAT, MATT, MALOAILENH);
					
					if(MALENH.trim().equals("") || MACP.trim().equals("") || MATKNH.trim().equals("") 
							|| LOAIGD.trim().equals("") || SLDAT.trim().equals("") 
							|| GIADAT.trim().equals("") || NGAYGIODAT.trim().equals("") 
							|| MATT.trim().equals("") || MALOAILENH.trim().equals(""))
					{
						JOptionPane.showMessageDialog(groundFr, "Hãy Điền Đầy Đủ Thông Tin");
						return;
					}
					
					for(LENHDAT L: DSLD) {
						if(L.getMALENH().equals(txtMaLenh.getText())) {
							JOptionPane.showMessageDialog(groundFr, "Đã tồn tại mã lệnh này, vui lòng sửa lại!");
							return;
						}
					}
					
					if(ldService.themLD(lenhDat,N)==0) {
						JOptionPane.showMessageDialog(groundFr, "Lỗi thêm 1 lệnh mua!");
						return;
					}
					DSLD.add(lenhDat);
					String data[]= {MALENH, MACP, MATKNH, LOAIGD, SLDAT, GIADAT, NGAYGIODAT, MATT, MALOAILENH};
					modelTable.addRow(data);
				}
			});
			btnXoa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(modelTable.getRowCount()==0) {
						JOptionPane.showMessageDialog(groundFr, "Không còn dữ liệu để xoá");
						return;
					}
					if(txtMaLenh.getText().equals("")) {
						JOptionPane.showMessageDialog(groundFr, "Vui lòng nhập mã lệnh cần xoá");
						return;
					}
					
					if(JOptionPane.showConfirmDialog(groundFr, "Bạn có chắc chắn muốn xoá lệnh mua này!")!=JOptionPane.OK_OPTION)
						return;
					
					for(LENHDAT L: DSLD) {
						if(L.getMALENH().equals(txtMaLenh.getText())) {
							//kiểm tra khoá ngoại
							if(ldService.xoaLD(txtMaLenh.getText(),N) == 0) {
								JOptionPane.showMessageDialog(groundFr, "Lỗi xoá lệnh mua!");
								return;
							}
							
							for(int i=0;i<modelTable.getRowCount();i++) {
								if(String.valueOf(modelTable.getValueAt(i, 0)).equals(txtMaLenh.getText())) {
									DSLD.remove(i);
									modelTable.removeRow(i);
									if(modelTable.getRowCount()!=0)
										tblLENHDAT.setRowSelectionInterval(i, i);
									break;
								}
							}
							return;
						}
					}
					JOptionPane.showMessageDialog(groundFr, "Không tồn tại mã lệnh này!");
				}
			});

			btnSua.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String MALENH, MACP, MATKNH, LOAIGD, SLDAT, GIADAT, NGAYGIODAT, MATT, MALOAILENH = "";
					KeyValue getCmbValue = new KeyValue();
					
					MALENH = txtMaLenh.getText();
					SLDAT = txtSLDat.getText();
					GIADAT = txtGiaDat.getText();
					LOAIGD = (String)cmbLoaiGD.getSelectedItem();
					MATKNH = (String)cmbTKNH.getSelectedItem();
					
					try {
						getCmbValue = (KeyValue)cmbTT.getSelectedItem();
						MATT = getCmbValue.getValue();
						getCmbValue = (KeyValue)cmbCoPhieu.getSelectedItem();
						MACP = getCmbValue.getValue();
						getCmbValue = (KeyValue)cmbLoaiLenh.getSelectedItem();
						MALOAILENH = getCmbValue.getValue();
					}catch(NullPointerException ex) {
						JOptionPane.showMessageDialog(groundFr, "Hãy Điền Đầy Đủ Thông Tin");
						return;
					}
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					try {
						NGAYGIODAT = sdf.format(dtDateChooser.getDate())+" "+spHour.getValue()+":"+spMinute.getValue()+":00.000";
					}catch(NullPointerException ex) {
						NGAYGIODAT = "";
					}
					
					LENHDAT lenhDat = new LENHDAT(MALENH, MACP, MATKNH, LOAIGD, SLDAT, GIADAT, NGAYGIODAT, MATT, MALOAILENH);
					
					if(MALENH.trim().equals("") || MACP.trim().equals("") || MATKNH.trim().equals("") 
							|| LOAIGD.trim().equals("") || SLDAT.trim().equals("") || 
							GIADAT.trim().equals("") || NGAYGIODAT.trim().equals("") 
							|| MATT.trim().equals("") || MALOAILENH.trim().equals(""))
					{
						JOptionPane.showMessageDialog(groundFr, "Hãy Điền Đầy Đủ Thông Tin!");
						return;
					}
					boolean check = false;
					for(LENHDAT L: DSLD) {
						if(L.getMALENH().equals(txtMaLenh.getText())) {
							check = true;
							break;
						}
					}
					if(!check) {
						JOptionPane.showMessageDialog(groundFr, "Không tìm thấy mã lệnh muốn sửa thông tin!");
						return;
					}

					if(ldService.suaLD(lenhDat,N)==0) {
						JOptionPane.showMessageDialog(groundFr, "Lỗi sửa lệnh mua!");
						return;
					}
					for(int i=0;i<modelTable.getRowCount();i++) {
						if(String.valueOf(modelTable.getValueAt(i, 0)).equals(txtMaLenh.getText())) {
							modelTable.setValueAt(lenhDat.getMALENH(), i, 0);
							modelTable.setValueAt(lenhDat.getMACP(), i, 1);
							modelTable.setValueAt(lenhDat.getMATKNH(), i, 2);
							modelTable.setValueAt(lenhDat.getLOAIGD(), i, 3);
							modelTable.setValueAt(lenhDat.getSLDAT(), i, 4);
							modelTable.setValueAt(lenhDat.getGIADAT(), i, 5);
							modelTable.setValueAt(lenhDat.getNGAYGIODAT(), i, 6);
							modelTable.setValueAt(lenhDat.getMATT(), i, 7);
							modelTable.setValueAt(lenhDat.getMALOAILENH(), i, 8);
							break;
						}
					}
				}
			});
	}
}
