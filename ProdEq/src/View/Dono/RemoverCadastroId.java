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

import Controller.Dono.RemoverCadastroIdController;

import java.awt.*;
import java.awt.event.*;

public class RemoverCadastroId extends JFrame implements ActionListener{
    JLabel lid; 
    JTextField tid;
    JButton ok, cancelar;
    
    public RemoverCadastroId() {
        setTitle("Remover Acesso");
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(((int)screen.getWidth()/2)-200, ((int)screen.getHeight()/2)-200);
        getContentPane().setLayout(new GridLayout(2, 2, 0, 0));
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lid = criarLabel("Id: ");
        add(lid);
        tid = criarTextField();
        add(tid);
        
        ok = criarButton("Ok");
        add(ok);
        
        cancelar = criarButton("Cancelar");
        add(cancelar);
        
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

    public JTextField criarTextField(){
        JTextField jt = new JTextField();
        jt.setHorizontalAlignment(SwingConstants.CENTER);
        jt.setFont(new Font("Arial", Font.PLAIN, 18));
        add(jt);
        return jt;
    }

    public JButton criarButton(String texto) {
        JButton b1 = new JButton(texto);
        b1.addActionListener(this);
        b1.setFont(new Font("Arial", Font.BOLD, 24));
        add(b1);
        return b1;
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ok){
            int confirmacao = JOptionPane.showConfirmDialog(rootPane,"Confirmar Remoção?","Confirmação",2);
            if(confirmacao == 0){
                int id = Integer.parseInt(tid.getText());
                RemoverCadastroIdController controller = new RemoverCadastroIdController();
                controller.removerAcesso(id);
                setVisible(false);
                new DonoMenuView();
            }
        }
        if(e.getSource() == cancelar){
            setVisible(false);
            new DonoMenuView();
        }
    }
}
