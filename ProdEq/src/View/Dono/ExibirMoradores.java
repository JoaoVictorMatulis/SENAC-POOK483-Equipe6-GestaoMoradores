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

public class ExibirMoradores extends JFrame implements ActionListener{
    JPanel p1,p2;
    JLabel[] label;
    JButton menu, anterior, proximo;
    int contadorElementosTela = 5, tela = 1;
    int linha = 0;
    int coluna = 0;
    String[][] result;
    public ExibirMoradores(String[][] result) {
        this.result = result;
        label = new JLabel[result.length];
        setTitle("Exibir Moradores");
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(((int)screen.getWidth()/2)-100, ((int)screen.getHeight()/2)-100);
        getContentPane().setLayout(new GridLayout(3, 1, 0, 0));
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        menu = criarButton("Menu");
        
        anterior = criarButton("Anterior");
        anterior.setEnabled(false);
        proximo = criarButton("Proximo");
        if(label.length>5){
            proximo.setEnabled(true);
        }else{
            proximo.setEnabled(false);
        }
        GridLayout gl1 = new GridLayout(5, 1, 0, 0);
        p1 = criarPainel(Color.white, gl1, anterior);
        if(label.length<=5){
            for(int i = 0; i < label.length;i++){
                label[i] = criarLabel(leitor(linha++, coluna));
                p1.add(label[i]);
            }
        }else{
            for(int i = 0; i < 5;i++){
                label[i] = criarLabel(leitor(linha++, coluna));
                p1.add(label[i]);
            }
        }
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
        l1.setFont(new Font("Arial", Font.BOLD, 18));
        add(l1);
        return l1;
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
            p1.removeAll();
            p1.revalidate();
            p1.repaint();
            anterior.setEnabled(true);
            if(label.length-(contadorElementosTela*tela) <= 5){
                for(int i = 0; i < (label.length-(contadorElementosTela*tela));i++){
                    label[i+(contadorElementosTela*tela)] = criarLabel(leitor(linha++, coluna));
                    p1.add(label[i+(contadorElementosTela*tela)]);
                }
                proximo.setEnabled(false);
            }else{
                for(int i = 0; i < 5;i++){
                    label[i] = criarLabel(leitor(linha++, coluna));
                    p1.add(label[i]);
                }
            }
            tela++;
        }
        if(e.getSource() == anterior){
            p1.removeAll();
            p1.revalidate();
            p1.repaint();
            proximo.setEnabled(true);
            tela--;
            if((contadorElementosTela*tela)-6 >=0){
                linha = (contadorElementosTela*tela)-6;
                for(int i = (contadorElementosTela*tela)-6; i < ((contadorElementosTela*tela)-1);i++){
                    label[i] = criarLabel(leitor(linha++, coluna));
                    p1.add(label[i]);
                }
            }else{
                linha = 0;
                for(int i = 0; i < 5;i++){
                    label[i] = criarLabel(leitor(linha++, coluna));
                    p1.add(label[i]);
                }
                anterior.setEnabled(false);
            }
        }
        if(e.getSource() == menu){
            setVisible(false);
            new DonoMenuView();
        }
    }

    public String leitor(int linha, int coluna){
        return ("ID: "+ result[linha][coluna++] + " - Nome: "+result[linha][coluna++]+" | Apartamento: "+result[linha][coluna++]+" | Bloco: "+result[linha][coluna++]+" | CPF: "+result[linha][coluna++]+" | Fone: "+result[linha][coluna++]+" | Email: "+result[linha][coluna]);
    }   
}
