package com.maua.pong.pii;

public class QuizTela extends javax.swing.JFrame {

    public QuizTela() {
        initComponents();
        this.setLocationRelativeTo(null);
        pergunta.setText(Quiz.getPergunta());
        alternativa1.setText(Quiz.getAlternativa1());
        alternativa2.setText(Quiz.getAlternativa2());
        alternativa3.setText(Quiz.getAlternativa3());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        alternativa1 = new javax.swing.JButton();
        alternativa2 = new javax.swing.JButton();
        alternativa3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pergunta = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Quiz"));

        alternativa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativa1ActionPerformed(evt);
            }
        });

        alternativa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativa2ActionPerformed(evt);
            }
        });

        alternativa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativa3ActionPerformed(evt);
            }
        });

        pergunta.setEditable(false);
        pergunta.setColumns(20);
        pergunta.setRows(5);
        jScrollPane1.setViewportView(pergunta);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(alternativa1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                        .addComponent(alternativa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(alternativa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(alternativa1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alternativa2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alternativa3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alternativa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativa1ActionPerformed
        if (Quiz.getAlternativa1() != Quiz.getResposta()) {
            if (Quiz.isPlayer() == true) {
                Game.adicionarPontoPlayer2();

            } else {
                Game.adicionarPontoPlayer();
            }
        }
        Game.setFreezeGame(0);
        this.dispose();
    }//GEN-LAST:event_alternativa1ActionPerformed

    private void alternativa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativa3ActionPerformed
        if (Quiz.getAlternativa3() != Quiz.getResposta()) {
            if (Quiz.isPlayer() == true) {
                Game.adicionarPontoPlayer2();
            } else {
                Game.adicionarPontoPlayer();
            }
        }
        Game.setFreezeGame(0);
        this.dispose();
    }//GEN-LAST:event_alternativa3ActionPerformed

    private void alternativa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativa2ActionPerformed
        if (Quiz.getAlternativa2() != Quiz.getResposta()) {
            if (Quiz.isPlayer() == true) {
                Game.adicionarPontoPlayer2();
            } else {
                Game.adicionarPontoPlayer();
            }
        }
        Game.setFreezeGame(0);
        this.dispose();
    }//GEN-LAST:event_alternativa2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuizTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alternativa1;
    private javax.swing.JButton alternativa2;
    private javax.swing.JButton alternativa3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea pergunta;
    // End of variables declaration//GEN-END:variables
}
