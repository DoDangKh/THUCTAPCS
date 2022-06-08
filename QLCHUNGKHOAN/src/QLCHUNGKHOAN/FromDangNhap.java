package QLCHUNGKHOAN;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.eclipse.jface.text.link.LinkedModeUI.ExitFlags;

import Entity.NHANVIEN;
import Service.NHANVIENService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Closeable;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import Service.NHANVIENService;
import javax.swing.JPasswordField;
public class FromDangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField txttaikhoan;
	private JButton btndangnhap;
	private JButton btnthoat;
	private NHANVIENService nhanvienService=new NHANVIENService();
	private JPasswordField txtmatkhau;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public FromDangNhap() {
		JFrame fr = new JFrame("JOptionPane showMessageDialog example");
		setTitle("\u0110\u0103ng nh\u1EADp t\u00E0i kho\u1EA3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00E0i kho\u1EA3n: ");
		lblNewLabel.setBounds(32, 80, 58, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u1EADt kh\u1EA9u:");
		lblNewLabel_1.setBounds(32, 118, 58, 13);
		contentPane.add(lblNewLabel_1);
		
		txttaikhoan = new JTextField();
		txttaikhoan.setBounds(100, 77, 145, 19);
		contentPane.add(txttaikhoan);
		txttaikhoan.setColumns(10);
		
		btndangnhap = new JButton("\u0110\u0103ng nh\u1EADp");
		btndangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tk=txttaikhoan.getText();
				String mk= new String(txtmatkhau.getPassword());
				if(tk.equals("") || mk.equals(""))
				{
					JOptionPane.showConfirmDialog(fr, "Chưa nhập tài khoản hoặc mật khẩu", "Thông báo", JOptionPane.CLOSED_OPTION);
				}
				else 
				{	
					//NHANVIEN a=null;
					NHANVIEN a=nhanvienService.getlogin(tk, mk);
					//JOptionPane.showMessageDialog(fr, "b");
					
					
					if(a!=null)
					{
						System.out.print(a.getMANV());
						JOptionPane.showMessageDialog(fr, "Đăng nhập thành công");
						if(a.getRole().equals("NV")) {
							formNhanVien frmnv=new formNhanVien(a);
							frmnv.setVisible(true);
							dispose();
						}
						else {
							FormADMIN frmAdmin=new FormADMIN(a);
							frmAdmin.setVisible(true);
							dispose();
						}
					}
					else
					{
						JOptionPane.showMessageDialog(fr, "Đăng nhập thất bại");
					}
				}
			}
		});
		btndangnhap.setBounds(59, 172, 85, 21);
		contentPane.add(btndangnhap);
		
		btnthoat = new JButton("Tho\u00E1t");
		btnthoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnthoat.setBounds(207, 172, 85, 21);
		contentPane.add(btnthoat);
		
		txtmatkhau = new JPasswordField();
		txtmatkhau.setBounds(100, 115, 145, 19);
		contentPane.add(txtmatkhau);
	}

}
