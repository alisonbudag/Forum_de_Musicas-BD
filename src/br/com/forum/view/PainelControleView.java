package br.com.forum.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.forum.bean.PerfilBean;
import br.com.forum.dao.PainelControleDao;
import br.com.forum.dao.PerfilDao;

public class PainelControleView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public PainelControleView(int idUsuarioLogado) {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 270);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblMembros = new JLabel("Membros");
		lblMembros.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMembros.setHorizontalAlignment(SwingConstants.CENTER);
		lblMembros.setOpaque(true);
		lblMembros.setBackground(Color.LIGHT_GRAY);
		lblMembros.setBounds(10, 11, 300, 17);
		contentPane.add(lblMembros);
		
		//Instanciar Painel de Controle
		PainelControleDao pcd = new PainelControleDao();
		
		//Puxar dados do usuário logado
		PerfilBean pb = new PerfilBean();
		PerfilDao pd = new PerfilDao();
		pd.puxarDados(idUsuarioLogado, pb);
		
		JScrollPane barraTabela = new JScrollPane();
		barraTabela.setBounds(10, 39, 300, 156);
		contentPane.add(barraTabela);
		
		table = new JTable(pcd.listarMembros());
		table.setBackground(Color.LIGHT_GRAY);
		table.setDefaultEditor(Object.class, null);
		barraTabela.setViewportView(table);
		
		JButton btnBanir = new JButton("Banir");
		btnBanir.setBounds(10, 206, 145, 23);
		contentPane.add(btnBanir);
		btnBanir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow() != -1) {
					if(pb.isAdm() || pb.isMod()) {
						
						int linha = table.getSelectedRow();
						String usuarioSelecionado = table.getValueAt(linha, 0).toString();
						boolean isBanned = false;
						
						if(table.getValueAt(linha, 1).toString().equals("Administrador")) {
							JOptionPane.showMessageDialog(null, "Impossível banir um ADM.");
						}else if(table.getValueAt(linha, 1).toString().equals("Moderador")) {
							JOptionPane.showMessageDialog(null, "Impossível banir um Moderador.");
						}else if(table.getValueAt(linha, 1).toString().equals("Banido")) {
							isBanned = true;
							pcd.banirMembro(usuarioSelecionado, isBanned);
						}else {
							isBanned = false;
							pcd.banirMembro(usuarioSelecionado, isBanned);
						}
						
						
						table.setModel(pcd.listarMembros());
						
					}else {
						JOptionPane.showMessageDialog(null, "Você não tem permissão para fazer isto.");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um usuário primeiro.");
				}
				
			}
		});
		
		JButton btnAdicionarModerador = new JButton("Adicionar Mod");
		btnAdicionarModerador.setBounds(165, 206, 145, 23);
		contentPane.add(btnAdicionarModerador);
		btnAdicionarModerador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(table.getSelectedRow() != -1) {
					if(pb.isAdm()) {
						int linha = table.getSelectedRow();
						String usuarioSelecionado = table.getValueAt(linha, 0).toString();
						boolean isMod = false;
						
						if(table.getValueAt(linha, 1).toString().equals("Administrador")) {
							JOptionPane.showMessageDialog(null, "Impossível rebaixar o nível de um ADM.");
						}else if(table.getValueAt(linha, 1).toString().equals("Banido")) {
							JOptionPane.showMessageDialog(null, "Impossível dar Mod à um membro banido.");
						}else if(table.getValueAt(linha, 1).toString().equals("Moderador")) {
							isMod = true;
							pcd.darMod(usuarioSelecionado, isMod);
						}else {
							isMod = false;
							pcd.darMod(usuarioSelecionado, isMod);
						}
						
						table.setModel(pcd.listarMembros());
					}else {
						JOptionPane.showMessageDialog(null, "Você não tem permissão para fazer isto.");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um usuário primeiro.");
				}
					
			}
		});
	
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				int linha = table.getSelectedRow();
				
				if(table.getValueAt(linha, 1).toString().equals("Moderador")) {
					btnAdicionarModerador.setText("Remover Mod");
					btnBanir.setText("Banir");
				}else if(table.getValueAt(linha, 1).toString().equals("Membro")){
					btnAdicionarModerador.setText("Adicionar Mod");
					btnBanir.setText("Banir");
				}else if(table.getValueAt(linha, 1).toString().equals("Banido")) {
					btnAdicionarModerador.setText("Adicionar Mod");
					btnBanir.setText("Desbanir");
				}else {
					btnAdicionarModerador.setText("Remover Mod");
					btnBanir.setText("Banir");
				}
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeView hv = new HomeView(idUsuarioLogado);
				dispose();
			}
		});
		btnVoltar.setBounds(123, 236, 70, 23);
		contentPane.add(btnVoltar);
		
		setVisible(true);
	}
}
