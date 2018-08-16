/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaodeestoque.Views;

import br.com.gestaodeestoque.Models.CategoriaModelo;
import br.com.gestaodeestoque.Models.SubCategoriaModelo;
import br.com.gestaodeestoque.Utilities.Utilidades;
import br.com.gestaodeestoque.dao.CategoriaDAO;
import br.com.gestaodeestoque.dao.SubCategoriaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Guibs
 */
public class FrmCategoria extends javax.swing.JFrame {

    public FrmCategoria() {
        initComponents();
//        this.setUndecorated(true); 
        btnNovo.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtNomeSubCat = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        cmbNomeCat = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Categoria");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton2.setText("Nova Categoria");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jLabel3.setText("|");
        jToolBar1.add(jLabel3);

        btnNovo.setText("Novo");
        btnNovo.setFocusable(false);
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnNovo);

        btnAlterar.setText("Alterar");
        btnAlterar.setFocusable(false);
        btnAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnAlterar);

        btnExcluir.setText("Excluir");
        btnExcluir.setFocusable(false);
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnExcluir);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 50));
        getContentPane().add(txtNomeSubCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 250, -1));

        jLabel2.setText("Nome Subcategoria");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        getContentPane().add(cmbNomeCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 250, -1));

        jLabel1.setText("Nome Categoria");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        setSize(new java.awt.Dimension(446, 268));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

        public void ListarCategoria() {
        try {
            List<CategoriaModelo> listacategoria = new ArrayList<>();
            CategoriaDAO dao = new CategoriaDAO();
            listacategoria = dao.listarCategorias();
            cmbNomeCat.removeAllItems();
            cmbNomeCat.addItem("");
            for(CategoriaModelo obj : listacategoria) {
                cmbNomeCat.addItem(obj);
            }
        } catch (Exception e) {
        }
    }
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // CADASTRO DE CATEGORIA
        //categoria dps
        if (txtNomeSubCat.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Campos vazios!");
        }
            try {
                //categoria dps
                SubCategoriaModelo subcategoriamodelo = new SubCategoriaModelo();
                subcategoriamodelo.setSubcategoria_nome(txtNomeSubCat.getText());
                subcategoriamodelo.setCategoria((CategoriaModelo) cmbNomeCat.getSelectedItem());
                //metodo
                SubCategoriaDAO subcategoriadao = new SubCategoriaDAO();
                subcategoriadao.cadastraSubCategoria(subcategoriamodelo);

                JOptionPane.showMessageDialog(null, "SubCategoria cadastrada.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ops, ocorreu um erro ao cadastrar a SubCategoria: " + e);
            }
//        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        ListarCategoria();
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
                String novacategoria = JOptionPane.showInputDialog(null, "digite o nome da categoria").toString();
        try {
            CategoriaModelo categoriamodelo = new CategoriaModelo();
            categoriamodelo.setCategoria_desc(novacategoria);
            CategoriaDAO dao = new CategoriaDAO();
            dao.cadastraCategoria(categoriamodelo);

            JOptionPane.showMessageDialog(null, "Categoria Cadastrada!");
            ListarCategoria();
        }catch(Exception e ){
        
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox cmbNomeCat;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtNomeSubCat;
    // End of variables declaration//GEN-END:variables
}