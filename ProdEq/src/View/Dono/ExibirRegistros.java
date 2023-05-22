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
    JPanel p1,p2;
    JLabel[] label;
    JButton menu, anterior, proximo;
    int contadorElementosTela = 5, tela = 1;
    int morador = 5;
    int linha = 0;
    int coluna = 0;
    String[][] result;
    public ExibirRegistros(String[][] result) {
        this.result = result;
        label = new JLabel[result.length];
        for(int i = 0; i < result.length; i++){
            label[i] = criarLabel(leitor(linha++, coluna));
        }
        setTitle("Exibir Moradores");
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(((int)screen.getWidth()/2)-100, ((int)screen.getHeight()/2)-100);
        getContentPane().setLayout(new GridLayout(3, 1, 0, 0));
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout gl1 = new GridLayout(5, 1, 0, 0);
        GridLayout gl2 = new GridLayout(1, 2, 0, 0);
        
        menu = criarButton("Menu",'m');

        anterior = criarButton("Anterior",'a');
        anterior.setEnabled(false);
        
        proximo = criarButton("Proximo",'d');
        //Se tiver mais de 5 moradores registrados, o botão proximo fica disponivel para ser clicado
        if(label.length>5){
            proximo.setEnabled(true);
        }else{
            proximo.setEnabled(false);
        }

        p1 = criarPainel(Color.white, gl1, anterior);
        //Verifica se tem mais de 5 morados para exibir na tela
        if(label.length<=5){
            for(int i = 0; i < label.length;i++){
                p1.add(label[i]);
            }
        }else{
            for(int i = 0; i < 5;i++){
                p1.add(label[i]);
            }
        }

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

    public JButton criarButton(String texto, char botao) {
        JButton b1 = new JButton(texto);
        b1.addActionListener(this);
        b1.setFont(new Font("Arial", Font.BOLD, 24));
        b1.setMnemonic(botao);
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
                    p1.add(label[morador++]);
                }
                proximo.setEnabled(false);
            }
            else{
                for(int i = 0; i < 5;i++){
                    p1.add(label[morador++]);
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
            morador = (contadorElementosTela * tela)-5;
            if(tela == 1){
                for(int i = 0; i < 5; i++){
                    p1.add(label[morador++]);
                }
                anterior.setEnabled(false);
            }else{
                for(int i = 0; i<5;i++){
                    p1.add(label[morador++]);
                }                
            }
        }
        if(e.getSource() == menu){
            setVisible(false);
            new DonoMenuView();
        }
    }

    public String leitor(int linha, int coluna){
        if(result[linha][3] == null){
            return ("ID do Registro: "+ result[linha][coluna++] + " - ID do Morador: "+result[linha][coluna++]+" | Entrada: "+result[linha][coluna++]+" | Saída: Ainda dentro da loja");
        }
        return ("ID do Registro: "+ result[linha][coluna++] + " - ID do Morador: "+result[linha][coluna++]+" | Entrada: "+result[linha][coluna++]+" | Saída: "+result[linha][coluna]);
    } 
}

