import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

public class Splash extends javax.swing.JFrame {
    int i = 0;
    int j = 0;
    
    private void disposeThis(){
        this.dispose();
    }
    
    public Splash() {
        initComponents();
        // Create a timer
        final Timer time = new Timer();
        TimerTask task = new TimerTask(){
            public void run(){
                String text = "Giraffe Airlines";
                if(i < 3700) { //Close the window after 3.5 seconds
                    if (i%80==0) j++; //increase j every 80 milliseconds
                    if(j>=text.length()) j=0;
                    i++;
                    //Highlight the letter at j using html
                    jLabel1.setText("<html><font color=#fea500>" +
                            text.substring(0, j)+ "</font>"
                            + "<font color=\"white\">" +
                            text.substring(j, j+1)+ "</font>"
                            + "<font color=#fea500>" +
                            text.substring(j+1)+ "</font> </html>");
                }
                else {
                    //After 3.5 seconds, dispose this window and add a login window
                    final Login login  = new Login();
                    login.setLocationRelativeTo(null);
                    login.show();
                    time.cancel();
                    disposeThis();
                }
                
            }
        };
        time.scheduleAtFixedRate(task, 0, 1);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 0, 0));
        setName("me"); // NOI18N
        setPreferredSize(new java.awt.Dimension(577, 348));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tunga", 1, 42)); // NOI18N
        jLabel1.setText("Title");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background 2.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Splash().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
