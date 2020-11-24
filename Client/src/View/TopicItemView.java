package View;

import java.awt.Desktop;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javalibrary.model.reponse.RelatedTopicReponse;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class TopicItemView extends javax.swing.JPanel {

    RelatedTopicReponse relatedTopicReponse = new RelatedTopicReponse();

    public TopicItemView(RelatedTopicReponse relatedTopicReponse) {
        initComponents();
        this.relatedTopicReponse = relatedTopicReponse;
        showData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleJLabel = new javax.swing.JLabel();
        descriptionJLabel = new javax.swing.JLabel();
        imgJLabel = new javax.swing.JLabel();

        titleJLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        titleJLabel.setText("jLabel1");
        titleJLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                titleJLabelMouseClicked(evt);
            }
        });

        descriptionJLabel.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(imgJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(titleJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                    .addComponent(descriptionJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(imgJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void titleJLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleJLabelMouseClicked
        try {
            Desktop.getDesktop().browse(new URL(relatedTopicReponse.getUrl()).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_titleJLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel descriptionJLabel;
    private javax.swing.JLabel imgJLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel titleJLabel;
    // End of variables declaration//GEN-END:variables

    private void showData() {
//        try {
//            URL url = new URL(relatedTopicReponse.getImage());
//            Image image = ImageIO.read(url);
//            imgJLabel.setIcon(new ImageIcon(image));
//        } catch (MalformedURLException ex) {
//            System.out.println(ex);
//        } catch (IOException ex) {
//            System.out.println(ex);
//        }
        
        titleJLabel.setText(relatedTopicReponse.getTitle());
        descriptionJLabel.setText(relatedTopicReponse.getDescription());
    }
}
