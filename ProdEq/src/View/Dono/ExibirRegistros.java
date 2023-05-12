/*
 * Turma: A
    Autores: João Victor Matulis || Id de aluno: 1142445416
            Bernardo Galvão de Souza || Id de aluno: 1142473154
            Gabriel de Melo Silva || Id de aluno: 1141267353
            Kevin de Sousa dos Santos || Id de aluno: 1142168549

    Professor: Carlos Veríssimo
 */
package View.Dono;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ExibirRegistros extends JFrame implements ActionListener{
    JPanel p1,p2,p3;
    JLabel label1, label2, label3, label4, label5;
    JButton menu, anterior, proximo;
    int contador = 1;
    int numero = 1;
    public ExibirRegistros() {
        setTitle("Exibir Registros");
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(((int)screen.getWidth()/2)-200, ((int)screen.getHeight()/2)-200);
        getContentPane().setLayout(new GridLayout(3, 1, 0, 0));
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        menu = criarButton("Menu");
        
        label1 = criarLabel("1");
        label2 = criarLabel("2");
        label3 = criarLabel("3");
        label4 = criarLabel("4");
        label5 = criarLabel("5");
        
        anterior = criarButton("Anterior");
        proximo = criarButton("Proximo");

        BorderLayout gl3 = new BorderLayout(5, 0);
        p3 = criarPainel(Color.white, gl3, menu);

        GridLayout gl1 = new GridLayout(5, 1, 0, 0);
        p1 = criarPainel(Color.white, gl1, label1);
        p1.add(label2);
        p1.add(label3);
        p1.add(label4);
        p1.add(label5);
        
		GridLayout gl2 = new GridLayout(1, 2, 0, 0);
        p2 = criarPainel(Color.white, gl2, anterior);
        p2.add(proximo);
        setVisible(true);
        centralizar();
    }
    
    public void centralizar() {
        // obtém a altura e largura da resolução vídeo
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        // obtém a altura e largura da minha janela
        Dimension janela = getSize();
        if (janela.height > screen.height)
            setSize(janela.width, screen.height);
        if (janela.width > screen.width)
            setSize(screen.width, janela.height);
        setLocation((int)(((screen.width - (janela.width*2)) / 1.5f)+janela.width),
            (screen.height - janela.height) / 2);
    }
    
    public JLabel criarLabel(String texto) {
        JLabel l1 = new JLabel(texto);
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setFont(new Font("Arial", Font.BOLD, 24));
        add(l1);
        return l1;
    }

    private JPanel criarPainel(Color cor, GridLayout gl, JLabel label1) {
        JPanel p1 = new JPanel();
		p1.setLayout(gl);
		p1.setBackground(cor);
		p1.add(label1);
		add(p1);
		return p1;
	}

    private JPanel criarPainel(Color cor, BorderLayout bl, JButton botao1) {
        JPanel p1 = new JPanel();
		p1.setLayout(bl);
		p1.setBackground(cor);
		p1.add(botao1);
		add(p1);
		return p1;
	}

    private JPanel criarPainel(Color cor, GridLayout gl, JButton botao1) {
        JPanel p1 = new JPanel();
		p1.setLayout(gl);
		p1.setBackground(cor);
		p1.add(botao1);
		add(p1);
		return p1;
	}

    public JButton criarButton(String texto) {
        JButton b1 = new JButton(texto);
        b1.addActionListener(this);
        b1.setFont(new Font("Arial", Font.BOLD, 24));
        add(b1);
        return b1;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == proximo){
            label1.setText(Integer.toString(numero++));
            label2.setText(Integer.toString(numero++));
            label3.setText(Integer.toString(numero++));
            label4.setText(Integer.toString(numero++));
            label5.setText(Integer.toString(numero++));
            contador++;
        }
        if(e.getSource() == anterior){
            if(contador > 1){
                label5.setText(Integer.toString(--numero));
                label4.setText(Integer.toString(--numero));
                label3.setText(Integer.toString(--numero));
                label2.setText(Integer.toString(--numero));
                label1.setText(Integer.toString(--numero));
            contador--;
            }
        }
        if(e.getSource() == menu){
            setVisible(false);
            new DonoMenuView();
        }
    }
}

