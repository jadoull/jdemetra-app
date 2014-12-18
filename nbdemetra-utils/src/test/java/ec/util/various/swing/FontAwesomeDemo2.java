/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.util.various.swing;

import java.awt.Color;
import java.awt.Image;
import java.util.List;
import java.util.concurrent.Callable;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.border.Border;

/**
 *
 * @author charphi
 */
public final class FontAwesomeDemo2 extends javax.swing.JPanel {

    public static void main(String[] args) {
        new BasicSwingLauncher()
                .content(FontAwesomeDemo2.class)
                .title("Font Awesome Demo 2")
                .size(240, 200)
                .icons(new Callable<List<Image>>() {
                    @Override
                    public List<Image> call() throws Exception {
                        return FontAwesome.FA_FONT.getImages(Color.BLUE, 16f, 32f, 64f);
                    }
                })
                .resizable(false)
                .launch();
    }

    static void setIcon(JTextField c, Icon icon) {
        Border b1 = BorderFactory.createMatteBorder(0, icon.getIconWidth(), 0, 0, icon);
        c.setBorder(BorderFactory.createCompoundBorder(c.getBorder(), b1));
    }

    /**
     * Creates new form FontAwesomeDemo2
     */
    public FontAwesomeDemo2() {
        initComponents();

        wordpress.setIcon(FontAwesome.FA_WORDPRESS.getIcon(Color.DARK_GRAY, 32f));
        setIcon(user, FontAwesome.FA_USER.getIcon(Color.GRAY, 14f));
        setIcon(password, FontAwesome.FA_LOCK.getIcon(Color.GRAY, 14f));

        Color color = Color.decode("#045697");
        login.setIcon(FontAwesome.FA_REFRESH.getIcon(color, 14f));
        login.setDisabledIcon(FontAwesome.FA_REFRESH.getSpinningIcon(login, color, 14f));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wordpress = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        login = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();

        wordpress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wordpress.setText("<html><font size=+2 color='#045697'>Word</font><font size=+2 color='#404040'>Press</font>");

        login.setText("Log In");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password)
                    .addComponent(wordpress, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addComponent(user)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(login)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wordpress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(login)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        user.setEnabled(false);
        password.setEnabled(false);
        login.setEnabled(false);
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(3000);
                return null;
            }

            @Override
            protected void done() {
                user.setEnabled(true);
                password.setEnabled(true);
                login.setEnabled(true);
            }
        }.execute();
    }//GEN-LAST:event_loginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton login;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField user;
    private javax.swing.JLabel wordpress;
    // End of variables declaration//GEN-END:variables
}