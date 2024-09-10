import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SiparisUygulamasi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JCheckBox iskender,beyti,ayran,kola;
	Map<String,Integer> siparisler = new LinkedHashMap<String, Integer>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SiparisUygulamasi frame = new SiparisUygulamasi();
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
	public SiparisUygulamasi() {
		setTitle("Sipariş Uygulaması");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menü");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel.setBounds(112, 29, 329, 55);
		contentPane.add(lblNewLabel);
		
		iskender = new JCheckBox("İskender - 15 TL");
		iskender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		iskender.setBounds(221, 90, 151, 21);
		contentPane.add(iskender);
		
		beyti = new JCheckBox("Beyti - 12 TL");
		beyti.setFont(new Font("Tahoma", Font.PLAIN, 16));
		beyti.setBounds(221, 113, 151, 21);
		contentPane.add(beyti);
		
		ayran = new JCheckBox("Ayran - 5 TL");
		ayran.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ayran.setBounds(221, 177, 151, 21);
		contentPane.add(ayran);
		
		kola = new JCheckBox("Kola - 8 TL");
		kola.setFont(new Font("Tahoma", Font.PLAIN, 16));
		kola.setBounds(221, 197, 151, 21);
		contentPane.add(kola);
		
		JButton siparisGöster = new JButton("Siparişleri Göster");
		siparisGöster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siparisGösterActionPerformed(e);
			}
		});
		siparisGöster.setFont(new Font("Tahoma", Font.PLAIN, 18));
		siparisGöster.setBounds(185, 247, 187, 31);
		contentPane.add(siparisGöster);
	}
	public void siparisleriGöster() {
		String message = "";
		int tutar=0;
		if(siparisler.isEmpty()) {
			message = "Siparişiniz bulunmamaktadır.";
		}
		else {
			message += "Siparişler\n";
			for(Map.Entry<String, Integer> entry: siparisler.entrySet()) {
				message += entry.getKey() + "\n";
				tutar += entry.getValue();
			}
			message += "Toplam tutar: " + tutar;
		}
		JOptionPane.showMessageDialog(this,message);
	}
	
	private void siparisGösterActionPerformed(ActionEvent e) {
		if(iskender.isSelected()) {
			siparisler.put("İskender", 15);
			
		}
		else {
			siparisler.remove("İskender");
		}
		if(beyti.isSelected()) {
			siparisler.put("Beyti", 12);
			
		}
		else {
			siparisler.remove("Beyti");
		}
		if(ayran.isSelected()) {
			siparisler.put("Ayran", 5);
			
		}
		else {
			siparisler.remove("Ayran");
		}
		if(kola.isSelected()) {
			siparisler.put("Kola", 8);
			
		}
		else {
			siparisler.remove("Kola");
		}
		
		siparisleriGöster();
		
	}
}
