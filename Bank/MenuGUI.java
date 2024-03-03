import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuGUI extends JFrame implements ActionListener {
	private CardLayout cardLayout;
	private JPanel mainPanel, menuPanel, aberturaPanel;
	private JButton buttonAbertura, buttonLevantamento, buttonTransferencia, buttonPagamento, buttonConsultarSaldo, continueButton;
	private JLabel saldoLabel;
	private float saldo;
	private TodosUsuarios usuarios;
	private Abertura abr;
	private Validacoes val;

	public MenuGUI() {
		setTitle("Menu");
		setSize(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		mainPanel = new JPanel();
		cardLayout = new CardLayout();
		mainPanel.setLayout(cardLayout);

		JPanel welcomePanel = new JPanel(new BorderLayout());
		JLabel welcomeLabel = new JLabel("Bem-vindo ao AKSL", JLabel.CENTER);
		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
		welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
		continueButton = new JButton("Continuar");
		continueButton.addActionListener(this);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(continueButton);
		welcomePanel.add(buttonPanel, BorderLayout.SOUTH);
		mainPanel.add(welcomePanel, "bem-vindo");

		aberturaPanel = new JPanel(new BorderLayout());
		JLabel aberturaLabel = new JLabel("Painel de Abertura de Conta", JLabel.CENTER);
		aberturaLabel.setFont(new Font("Arial", Font.BOLD, 18));
		buttonAbertura = new JButton("Abrir Conta");
		buttonAbertura.addActionListener(this);
		JPanel aberturaButtonPanel = new JPanel();
		aberturaButtonPanel.add(buttonAbertura);
		aberturaPanel.add(aberturaLabel, BorderLayout.CENTER);
		aberturaPanel.add(aberturaButtonPanel, BorderLayout.SOUTH);
		mainPanel.add(aberturaPanel, "abertura");

		menuPanel = new JPanel(new GridLayout(4, 1));
		buttonLevantamento = new JButton("Levantamento");
		buttonTransferencia = new JButton("Transferência");
		buttonPagamento = new JButton("Pagamento");
		buttonConsultarSaldo = new JButton("Consultar Saldo");
		buttonLevantamento.addActionListener(this);
		buttonTransferencia.addActionListener(this);
		buttonPagamento.addActionListener(this);
		buttonConsultarSaldo.addActionListener(this);
		menuPanel.add(buttonLevantamento);
		menuPanel.add(buttonTransferencia);
		menuPanel.add(buttonPagamento);
		menuPanel.add(buttonConsultarSaldo);
		mainPanel.add(menuPanel, "menu");

		add(mainPanel);

		setLocationRelativeTo(null);
		setVisible(true);

		saldo = 0;
		usuarios = new TodosUsuarios();
		usuarios.lerDoFicheiro("User.txt");
		abr = new Abertura();
		val= new Validacoes();
		saldo = abr.getSaldo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == continueButton) {
			cardLayout.show(mainPanel, "abertura");
		} else if (e.getSource() == buttonAbertura) {
			abrirConta();
		} else if (e.getSource() == buttonLevantamento) {
			levantamento();
		} else if (e.getSource() == buttonTransferencia) {
			transferencia();
		} else if (e.getSource() == buttonPagamento) {
			pagamento();
		} else if (e.getSource() == buttonConsultarSaldo) {
			consultarSaldo();
		}
	}

//Metodo usado para a abertura de conta
	private void abrirConta() {
		// Criar um painel para personalizar o JOptionPane
		JPanel panel = new JPanel(new GridLayout(2, 2)); // Layout de grade 2x2

		// Adicionar rótulo e campo de texto para solicitar o valor de abertura
		JLabel label = new JLabel("Insira o valor inicial para abertura de conta: ");
		JTextField textField = new JTextField();
		panel.add(label);
		panel.add(textField);

		// Exibir o JOptionPane personalizado e aguardar a entrada do usuário
		int result = JOptionPane.showConfirmDialog(null, panel, "Abertura de Conta", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			// Verificar se o usuário inseriu um valor válido
			try {
				float valorAbertura = Float.parseFloat(textField.getText());
				if (valorAbertura > 0) {
					// Atualizar o saldo dentro do objeto Abertura
					abr.setSaldo(valorAbertura);
					saldo = abr.getSaldo(); // Atualiza o saldo local
					// Passar para o menu principal
					cardLayout.show(mainPanel, "menu");
				} else {
					JOptionPane.showMessageDialog(null, "O valor de abertura deve ser maior que zero!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException nb) {
				JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}


	private void levantamento() {
		// Implementa a lógica de levantamento
		// Criar o painel para o JOptionPane
		JPanel panel = new JPanel(new GridLayout(3, 2));

		// Adicionar rótulo e campo de texto para valor de levantamento
		JLabel label = new JLabel("Insira o valor que pretende levantar (maior que 100)");
		JTextField textField = new JTextField();
		panel.add(label);
		panel.add(textField);

		// Exibir e esperar por Input
		int result = JOptionPane.showConfirmDialog(null, panel, "Levantamento", JOptionPane.OK_CANCEL_OPTION);

		// Verificar input
		if (result == JOptionPane.OK_OPTION) {
			try {
				float valorLevantamento = Float.parseFloat(textField.getText());
				if (valorLevantamento > 0) {
					//Levantamento lv = new Levantamento();
					//lv.levantamento(abr.getSaldo(), valorLevantamento);
					// Criar o painel para exibir o resultado do levantamento
					JPanel resultadoPanel = new JPanel(new GridLayout(2, 1));
					JLabel label2 = new JLabel("Levantamento efetuado com sucesso!");
					resultadoPanel.add(label2);
					// Adicionar botao "Cancelar"
					JButton cancelarButton = new JButton("Cancelar");
					cancelarButton.addActionListener(e -> {
						System.exit(0); // Fechar a aplicação
					});
					JPanel buttonPanel = new JPanel();
					buttonPanel.add(cancelarButton);
					resultadoPanel.add(buttonPanel);

					// Exibir o painel com o resultado do levantamento
					JOptionPane.showMessageDialog(null, resultadoPanel, "Resultado do Levantamento", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException nb) {
				JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void transferencia() {
		// Implementa a lógica de transferência
		JPanel panel= new JPanel(new GridLayout(2,2));

		JLabel label=  new JLabel("Insira o NIB da conta destinataria: ");
		JTextField textField=  new JTextField();
		panel.add(label);
		panel.add(textField);

		//wait for input
		int result = JOptionPane.showConfirmDialog(null, panel, "Transferencia", JOptionPane.OK_CANCEL_OPTION);


		//verificar input
		if (result==JOptionPane.OK_OPTION){
			int nib= Integer.parseInt(textField.getText());
			try{
				if (nib>0){
					JPanel panel2= new JPanel(new GridLayout(2,2));
					JLabel label2=  new JLabel("Insira o valor da transferencia: ");
					JTextField textField2=  new JTextField();
					panel2.add(label2);
					panel2.add(textField2);

					//wait for input
					int result2 = JOptionPane.showConfirmDialog(null, panel2, "Transferencia", JOptionPane.OK_CANCEL_OPTION);

					int valorTr= Integer.parseInt(textField2.getText());
					if (valorTr>0){
						// Criar o painel para exibir o resultado
							JPanel resultadoPanel = new JPanel(new GridLayout(2, 1));
						JLabel label3 = new JLabel("Tranferencia efetuada com sucesso!");
						resultadoPanel.add(label3);
						// Adicionar botao "Cancelar"
						JButton cancelarButton = new JButton("Cancelar");
						cancelarButton.addActionListener(e -> {
							System.exit(0); // Fechar a aplicação
						});
						JPanel buttonPanel = new JPanel();
						buttonPanel.add(cancelarButton);
						resultadoPanel.add(buttonPanel);

						// Exibir o painel com o resultado
						JOptionPane.showMessageDialog(null, resultadoPanel, "Resultado da tranferencia ", JOptionPane.PLAIN_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido!", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}catch (NumberFormatException nb) { JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void pagamento() {
		// Implementa a lógica de pagamento
		
	}

	private void consultarSaldo() {
		// Implementa a lógica de consultar saldo aqui
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(MenuGUI::new);
	}
}
