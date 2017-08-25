/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CategoriaDAO;
import database.Utilitarios;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.Categoria;

/**
 *
 * @author Alunos
 */
public class JFrameListaCategorias extends javax.swing.JFrame {

    /**
     * Creates new form JFrameListaCategorias
     */
    public JFrameListaCategorias() {
        initComponents();
        clickDaTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneCategorias = new javax.swing.JScrollPane();
        jTableCategorias = new javax.swing.JTable();
        jButtonExcluir = new javax.swing.JButton();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTableCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneCategorias.setViewportView(jTableCategorias);
        if (jTableCategorias.getColumnModel().getColumnCount() > 0) {
            jTableCategorias.getColumnModel().getColumn(0).setResizable(false);
            jTableCategorias.getColumnModel().getColumn(1).setResizable(false);
            jTableCategorias.getColumnModel().getColumn(2).setResizable(false);
        }
        popularLista();

        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/excluir.png"))); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonExcluirMouseClicked(evt);
            }
        });

        jButtonCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novo.png"))); // NOI18N
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jButtonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salvar.png"))); // NOI18N
        jButtonAlterar.setText("Editar");
        jButtonAlterar.setEnabled(false);
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPaneCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonExcluir)
                .addGap(16, 16, 16)
                .addComponent(jButtonAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCadastrar)
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAlterar))
                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        new JFrameCadastroCategoria().setVisible(true);
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        popularLista();
    }//GEN-LAST:event_formWindowActivated

    private void jButtonExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonExcluirMouseClicked
        if (jTableCategorias.getSelectedRow() > -1) {
            int codigo = Integer.parseInt(jTableCategorias.getValueAt(jTableCategorias.getSelectedRow(), 0).toString());
            int codigoExclusao = new CategoriaDAO().excluir(codigo);
            String nome = jTableCategorias.getValueAt(jTableCategorias.getSelectedRow(), 1).toString();
            if (codigoExclusao == Utilitarios.NAO_FOI_POSSIVEL_EXCLUIR) {
                JOptionPane.showMessageDialog(null, "Não foi possivel excluir");
            } else {
                popularLista();
                JOptionPane.showMessageDialog(null, nome + "Excluido com sucesso");
                jButtonAlterar.setEnabled(false);
                jButtonExcluir.setEnabled(false);
            }

        }
        
    }//GEN-LAST:event_jButtonExcluirMouseClicked

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        if(jTableCategorias.getSelectedRow() > -1){
            int id = Integer.parseInt(jTableCategorias.getValueAt(jTableCategorias.getSelectedRow(), 0).toString());
            Categoria categoria = new CategoriaDAO().buscarCategoriaPorId(id);
            new JFrameCadastroCategoria(categoria).setVisible(true);
            
            
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed
    private void popularLista() {
        DefaultTableModel modelo = (DefaultTableModel) jTableCategorias.getModel();
        ArrayList<Categoria> categorias = new CategoriaDAO().retornarListaCategoria();
        modelo.setRowCount(0);
        for (Categoria categoria : categorias) {

            modelo.addRow(new Object[]{
                categoria.getId(), categoria.getNome(), categoria.isAtivo()
            });
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameListaCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameListaCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameListaCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameListaCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameListaCategorias().setVisible(true);
            }
        });
    }

    private void clickDaTabela() {
        jTableCategorias.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                jButtonAlterar.setEnabled(true);
                jButtonExcluir.setEnabled(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JScrollPane jScrollPaneCategorias;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableCategorias;
    // End of variables declaration//GEN-END:variables
}
