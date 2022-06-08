package QLCHUNGKHOAN;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entity.NHANVIEN;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class formNhanVien extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formNhanVien frame = new formNhanVien(null);
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
	public formNhanVien(NHANVIEN N) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("H\u1ECD t\u00EAn: ");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(24, 83, 63, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblMNhnVin = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn: ");
		lblMNhnVin.setForeground(Color.DARK_GRAY);
		lblMNhnVin.setFont(new Font("Arial", Font.BOLD, 13));
		lblMNhnVin.setBounds(24, 47, 99, 26);
		contentPane.add(lblMNhnVin);
		
		JLabel lblPhi = new JLabel("Ph\u00E1i:");
		lblPhi.setForeground(Color.DARK_GRAY);
		lblPhi.setFont(new Font("Arial", Font.BOLD, 13));
		lblPhi.setBounds(404, 47, 63, 26);
		contentPane.add(lblPhi);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ng\u00E0y sinh:");
		lblNewLabel_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(24, 124, 82, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("L\u01B0\u01A1ng:");
		lblNewLabel_1_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(404, 124, 63, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i: ");
		lblSinThoi.setForeground(Color.DARK_GRAY);
		lblSinThoi.setFont(new Font("Arial", Font.BOLD, 13));
		lblSinThoi.setBounds(404, 83, 99, 26);
		contentPane.add(lblSinThoi);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u0110\u1ECBa ch\u1EC9: ");
		lblNewLabel_1_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(24, 160, 63, 26);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblPHAI = new JLabel("New label");
		lblPHAI.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPHAI.setBounds(456, 47, 125, 26);
		contentPane.add(lblPHAI);
		
		JLabel lblNGAYSINH = new JLabel("New label");
		lblNGAYSINH.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNGAYSINH.setBounds(103, 124, 125, 26);
		contentPane.add(lblNGAYSINH);
		
		JLabel lblHOTEN = new JLabel("New label");
		lblHOTEN.setFont(new Font("Arial", Font.PLAIN, 12));
		lblHOTEN.setBounds(83, 83, 125, 26);
		contentPane.add(lblHOTEN);
		
		JLabel lblMANV = new JLabel("New label");
		lblMANV.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMANV.setBounds(133, 47, 125, 26);
		contentPane.add(lblMANV);
		
		JLabel lblLUONG = new JLabel("New label");
		lblLUONG.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLUONG.setBounds(466, 124, 169, 26);
		contentPane.add(lblLUONG);
		
		JLabel lblSDT = new JLabel("New label");
		lblSDT.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSDT.setBounds(513, 83, 169, 26);
		contentPane.add(lblSDT);
		
		JLabel lblDIACHI = new JLabel("New label");
		lblDIACHI.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDIACHI.setBounds(83, 160, 549, 26);
		contentPane.add(lblDIACHI);
		
		JButton btnNewButton = new JButton("Qu\u1EA3n l\u00FD Nh\u00E0 \u0110\u1EA7u T\u01B0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				formNDT frm = new formNDT(N);
				frm.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(10, 218, 334, 98);
		contentPane.add(btnNewButton);
		
		JLabel lblThngTinNhn = new JLabel("TH\u00D4NG TIN NH\u00C2N VI\u00CAN");
		lblThngTinNhn.setForeground(Color.BLACK);
		lblThngTinNhn.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblThngTinNhn.setBounds(255, 10, 196, 26);
		contentPane.add(lblThngTinNhn);
		
		JButton btnQunLLnh = new JButton("Qu\u1EA3n l\u00FD L\u1EC7nh \u0110\u1EB7t");
		btnQunLLnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				formLENHDAT frm = new formLENHDAT(N);
				frm.setVisible(true);				
			}
		});
		btnQunLLnh.setBackground(SystemColor.textHighlight);
		btnQunLLnh.setFont(new Font("Arial", Font.BOLD, 14));
		btnQunLLnh.setBounds(366, 218, 335, 98);
		contentPane.add(btnQunLLnh);
		/* --------------------------------------FORM-LOAD--------------------------------------- */
		lblMANV.setText(String.valueOf(N.getMANV()));
		lblPHAI.setText(N.getPHAI());
		lblHOTEN.setText(N.getHO()+" "+N.getTEN());
		lblSDT.setText(N.getSDT());
		//lblNGAYSINH.setText(N.getNGAYSINH());
		lblLUONG.setText(String.valueOf(N.getLuong()));
		lblDIACHI.setText(N.getDIACHI());
		
		JButton btnThoat = new JButton("Thoát>>");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setBounds(613, 15, 88, 44);
		contentPane.add(btnThoat);
		
	}
}
