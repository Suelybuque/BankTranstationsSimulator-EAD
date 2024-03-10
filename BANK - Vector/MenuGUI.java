//Algorithm complexitity O(1)

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuGUI extends JFrame implements ActionListener {
	private CardLayout cardLayout;
	private JPanel mainPanel, menuPanel, aberturaPanel;
	private JButton buttonAbertura, buttonLevantamento, buttonTransferencia, buttonPagamento, buttonConsultarSaldo, continueButton;

	private float saldo;
	private TodosUsuarios usuarios;
	private Abertura abr;
	private Validacoes val;
	private  Visualizacoes vis;

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

		//Abertura de conta
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

		//Menu
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
		if (e.getSource()  == continueButton) {
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
	JPanel panel = new JPanel(new GridLayout(4, 2)); // Layout de grade 4x2

	// Adicionar rótulo e campo de texto para solicitar o valor de abertura
	JLabel labelValorAbertura = new JLabel("Insira o valor inicial para abertura de conta: ");
	JTextField textFieldValorAbertura = new JTextField();
	panel.add(labelValorAbertura);
	panel.add(textFieldValorAbertura);

	// Adicionar rótulo e campo de texto para solicitar o número da conta
	JLabel labelNumeroConta = new JLabel("Número da Conta: ");
	JTextField textFieldNumeroConta = new JTextField();
	panel.add(labelNumeroConta);
	panel.add(textFieldNumeroConta);

	// Adicionar rótulo e campo de texto para solicitar o PIN
	JLabel labelPin = new JLabel("PIN: ");
	JPasswordField passwordFieldPin = new JPasswordField();
	panel.add(labelPin);
	panel.add(passwordFieldPin);

	// Exibir o JOptionPane personalizado e aguardar a entrada do usuário
	int result = JOptionPane.showConfirmDialog(null, panel, "Abertura de Conta", JOptionPane.OK_CANCEL_OPTION);
	if (result == JOptionPane.OK_OPTION) {
		// Verificar se o usuário inseriu um valor válido para a abertura da conta
		try {
			float valorAbertura = Float.parseFloat(textFieldValorAbertura.getText());
			if (valorAbertura > 0) {
				//  armazenar o valor de abertura, número da conta e PIN em variáveis e usar conforme necessário

				// Atualizar o saldo dentro do objeto Abertura
				abr.setSaldo(valorAbertura);
				saldo = abr.getSaldo(); // Atualiza o saldo local com o valor atualizado do objeto Abertura
				// Passar para o menu principal
				cardLayout.show(mainPanel, "menu");
			} else {
				JOptionPane.showMessageDialog(null, "O valor de abertura deve ser maior que zero!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException nb) {
			JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido para a abertura de conta!", "Erro", JOptionPane.ERROR_MESSAGE);
		}

		// Verificar se o PIN foi preenchido
		char[] pin = passwordFieldPin.getPassword();
		if (pin.length == 0) {
			JOptionPane.showMessageDialog(null, "Por favor, insira um PIN!", "Erro", JOptionPane.ERROR_MESSAGE);
			return; // Encerrar o método se o PIN não foi preenchido
		}

		// Aqui você pode usar o número da conta e o PIN conforme necessário
		String numeroConta = textFieldNumeroConta.getText();
		// Aqui você pode converter o PIN para uma string se precisar usá-lo como texto

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

					abr.setSaldo((abr.getSaldo())-valorLevantamento);

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
						abr.setSaldo((abr.getSaldo())-valorTr);


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
		// Criar um painel para o JOptionPane
		JPanel panel = new JPanel(new GridLayout(4, 1)); // Layout de grade 4x1

		// Adicionar rótulos e botões para as opções de pagamento
		JLabel label = new JLabel("Selecione o tipo de pagamento:");
		JButton tvButton = new JButton("TV");
		JButton servicosBasicosButton = new JButton("Serviços Básicos");
		JButton pagamentoServicosButton = new JButton("Pagamento de Serviços");

		// Adicionar ação aos botões
		tvButton.addActionListener(e -> showTvOptions());
		servicosBasicosButton.addActionListener(e -> showServicosBasicosOptions());
		pagamentoServicosButton.addActionListener(e -> showPagamentoServicosOptions());

		panel.add(label);
		panel.add(tvButton);
		panel.add(servicosBasicosButton);
		panel.add(pagamentoServicosButton);

		// Exibir o JOptionPane com as opções de pagamento
		JOptionPane.showMessageDialog(null, panel, "Pagamento", JOptionPane.PLAIN_MESSAGE);
	}

	private void showTvOptions() {
		// Criar um array de opções de TV
		String[] tvOptions = {"DSTV", "GOTV", "ZAP", "TVCabo"};

		// Exibir um JOptionPane para selecionar uma opção de TV
		String selectedOption = (String) JOptionPane.showInputDialog(
				null,
				"Selecione uma opção de TV:",
				"TV",
				JOptionPane.QUESTION_MESSAGE,
				null,
				tvOptions,
				tvOptions[0]);

		if (selectedOption != null) {
			// Criar campos de texto para o número do cartão e o valor a pagar
			JTextField numeroCartaoField = new JTextField();
			JTextField valorPagarField = new JTextField();

			// Criar um painel para os campos de texto
			JPanel panel = new JPanel(new GridLayout(3, 2));
			panel.add(new JLabel("Número do Cartão:"));
			panel.add(numeroCartaoField);
			panel.add(new JLabel("Valor a Pagar:"));
			panel.add(valorPagarField);

			// Exibir um JOptionPane para preencher os campos de número do cartão e valor a pagar
			int result = JOptionPane.showConfirmDialog(null, panel, "Informações de Pagamento", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {

				try {
					int valorPagar = Integer.parseInt(valorPagarField.getText());
					abr.setSaldo(abr.getSaldo()-valorPagar);
					JOptionPane.showMessageDialog(null ,
							"Pagamento de " + selectedOption + " efetuado com sucesso!\n" +
									"Número do Cartão: " + numeroCartaoField.getText() + "\n" +
									"Valor Pago: " + valorPagar,
							"Pagamento Efetuado",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Por favor, insira um valor numérico válido para o valor a pagar!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	private void showServicosBasicosOptions() {
		// Criar um array de opções de serviços básicos
		String[] servicosBasicosOptions = {"Água", "Luz"};

		// Exibir um JOptionPane para selecionar um serviço básico
		String selectedOption = (String) JOptionPane.showInputDialog(
				null,
				"Selecione um serviço básico:",
				"Serviços Básicos",
				JOptionPane.QUESTION_MESSAGE,
				null,
				servicosBasicosOptions,
				servicosBasicosOptions[0]);

		if (selectedOption != null) {
			// Criar um campo de texto para o valor a pagar
			JTextField valorPagarField = new JTextField();

			// Criar um painel para o campo de texto
			JPanel panel = new JPanel(new GridLayout(2, 2));
			panel.add(new JLabel("Valor a Pagar:"));
			panel.add(valorPagarField);

			// Exibir um JOptionPane para preencher o campo de valor a pagar
			int result = JOptionPane.showConfirmDialog(null, panel, "Informações de Pagamento", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {

				try {
					int valorPagar = Integer.parseInt(valorPagarField.getText());
					abr.setSaldo(abr.getSaldo()-valorPagar);//Atualiza o saldo
					JOptionPane.showMessageDialog(null,
							"Pagamento de " + selectedOption + " no valor de " + valorPagarField.getText() + " efetuado com sucesso!",
							"Pagamento Efetuado",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Por favor, insira um valor numérico válido para o valor a pagar!", "Erro", JOptionPane.ERROR_MESSAGE);
				}


			}
		}
	}

	private void showPagamentoServicosOptions() {
		// Criar campos de texto para entidade, referência e valor a pagar
		JTextField entidadeField = new JTextField();
		JTextField referenciaField = new JTextField();
		JTextField valorField = new JTextField();

		// Criar um painel para os campos de texto
		JPanel panel = new JPanel(new GridLayout(3, 2));
		panel.add(new JLabel("Entidade:"));
		panel.add(entidadeField);
		panel.add(new JLabel("Referência:"));
		panel.add(referenciaField);
		panel.add(new JLabel("Valor a Pagar:"));
		panel.add(valorField);

		// Exibir um JOptionPane para preencher os campos de pagamento de serviços
		int result = JOptionPane.showConfirmDialog(null, panel, "Pagamento de Serviços", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			try{
				int valorPagar = Integer.parseInt(valorField.getText());
				abr.setSaldo(abr.getSaldo()-valorPagar);

				JOptionPane.showMessageDialog(null,
						"Entidade: " + entidadeField.getText() + "\n" +
								"Referência: " + referenciaField.getText() + "\n" +
								"Valor a Pagar: " + valorField.getText(),
						"Informações do Pagamento",
						JOptionPane.INFORMATION_MESSAGE);
			}catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Por favor, insira um valor numérico válido para o valor a pagar!", "Erro", JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	private void consultarSaldo() {
		// Implementa a lógica de consultar saldo
		vis= new Visualizacoes();
		JPanel panel = new JPanel(new GridLayout(2,2));

		//Visualizar saldo

		JLabel label = new JLabel(vis.saldo(abr.getSaldo()));
		panel.add(label);

		//Adicionar botao de cancelar
		JButton cancelarButton= new JButton("Cancelar");
		cancelarButton.addActionListener(e-> {
			System.exit(0);// Fechar aplicacao
		});
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(cancelarButton);
		panel.add(buttonPanel);

		//Resultado/continuar
		JOptionPane.showMessageDialog(null, panel, "Consulta de saldo", JOptionPane.PLAIN_MESSAGE);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(MenuGUI::new);
	}
}
