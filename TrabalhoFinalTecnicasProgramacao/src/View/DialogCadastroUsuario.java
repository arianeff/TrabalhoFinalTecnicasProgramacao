package View;

import Business.UsuarioBusiness;
import Exception.ConnectionException;
import Exception.UsuarioException;
import Facade.UsuarioFacade;
import Helpers.PopulateComponents;
import Domain.TipoUsuario;
import Domain.Usuario;
import Exception.PersistenceException;
import Facade.TipoUsuarioFacade;
import Helpers.ComboboxHelper;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import javafx.util.Pair;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class DialogCadastroUsuario extends javax.swing.JFrame {

    private final MouseAdapter tableItemClick;

    DialogCadastroUsuario() throws ConnectionException, PersistenceException {
        TipoUsuarioFacade tipoUsuarioFacade = new TipoUsuarioFacade();
        Collection<TipoUsuario> tiposUsuario = tipoUsuarioFacade.buscarTodos();
        
        this.tableItemClick = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                editData(tableUsuarios.rowAtPoint(e.getPoint()), tableUsuarios);
            }
        };
        initComponents();
        txtId.setVisible(false);
        configureComboTipoUsuario(tiposUsuario);
        configureTableUsuarios();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvar = new javax.swing.JButton();
        cmbTipoUsuario = new javax.swing.JComboBox();
        txtNome = new javax.swing.JTextField();
        txtCpfCnpj = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();
        txtId = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuários");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipo de Usuário:");

        jLabel2.setText("Nome:");

        jLabel3.setText("CPF/CNPJ:");

        jLabel4.setText("Email:");

        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "CPF/CNPJ", "Email", "Tipo de Usuário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableUsuarios);

        txtId.setEditable(false);
        txtId.setText("0");

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1106, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCpfCnpj, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLimpar)
                                .addGap(160, 160, 160)
                                .addComponent(btnSalvar))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTipoUsuario, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cmbTipoUsuario.getAccessibleContext().setAccessibleName("cmbTipoUsuario");
        txtNome.getAccessibleContext().setAccessibleName("txtNome");
        txtCpfCnpj.getAccessibleContext().setAccessibleName("txtCpfCnpj");
        txtEmail.getAccessibleContext().setAccessibleName("txtEmail");

        setBounds(0, 55, 1148, 606);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            UsuarioFacade facade = new UsuarioFacade();

            Pair<Integer, String> selectedTipoUsuario = (Pair<Integer, String>) cmbTipoUsuario.getSelectedItem();
            int id = Integer.parseInt(txtId.getText());
            String nome = txtNome.getText();
            String cpfCnpj = txtCpfCnpj.getText();

            String email = txtEmail.getText().toLowerCase();

            TipoUsuario tipoUsuario = new TipoUsuario(selectedTipoUsuario.getKey(), selectedTipoUsuario.getValue());
            Usuario usuario = new Usuario(id, nome, cpfCnpj, email, tipoUsuario);

            UsuarioBusiness.validaUsuario(usuario);

            if (facade.cadastrarUsuario(usuario)) {
                refreshTable();
                clearFields();
                JOptionPane.showMessageDialog(rootPane, "Usuário cadastrado", null, JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (ConnectionException | PersistenceException | UsuarioException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        clearFields();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void refreshTable() throws ConnectionException, PersistenceException {
        DefaultTableModel model = (DefaultTableModel) tableUsuarios.getModel();
        model.setRowCount(0);
        for (Usuario usuario : new UsuarioFacade().buscarTodos()) {
            if (usuario.getCpfCnpj().length() < 12) {
                usuario.setCpfCnpj(String.format("%011d", Long.parseLong(usuario.getCpfCnpj())));
            } else if (usuario.getCpfCnpj().length() > 13) {
                usuario.setCpfCnpj(String.format("%014d", Long.parseLong(usuario.getCpfCnpj())));
            }
            model.addRow(new Object[]{usuario.getId(), usuario.getNome(), usuario.getCpfCnpj(), usuario.getEmail(), usuario.getTipoUsuario().getTipo()});
        }

    }

    private void clearFields() {
        txtId.setText("0");
        txtNome.setText("");
        txtCpfCnpj.setText("");
        txtEmail.setText("");
        cmbTipoUsuario.setSelectedIndex(0);
    }

    private void editData(int index, JTable table) {
        int numCols = table.getColumnCount();
        TableModel model = table.getModel();

        for (int j = 0; j < numCols; j++) {
            setFormValues(index, model);
            ComboboxHelper.setSelected(cmbTipoUsuario, model.getValueAt(index, 4).toString());
        }
    }
    
    private void setFormValues(int index, TableModel model) {
        txtId.setText(model.getValueAt(index, 0).toString());
        txtNome.setText(model.getValueAt(index, 1).toString());
        txtCpfCnpj.setText(model.getValueAt(index, 2).toString());
        txtEmail.setText(model.getValueAt(index, 3).toString());
    }

    private void configureComboTipoUsuario(Collection<TipoUsuario> tiposUsuario) {
        DefaultComboBoxModel mod = new DefaultComboBoxModel(PopulateComponents.populateComboTipoUsuario(tiposUsuario).toArray());
        cmbTipoUsuario.setModel(mod);
    }
    
    private void configureTableUsuarios() throws PersistenceException {
        tableUsuarios.setRowSelectionAllowed(true);
        tableUsuarios.setColumnSelectionAllowed(false);
        try {
            refreshTable();
            tableUsuarios.addMouseListener(this.tableItemClick);
        } catch (ConnectionException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cmbTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableUsuarios;
    private javax.swing.JTextField txtCpfCnpj;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
