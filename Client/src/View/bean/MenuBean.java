package View.bean;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuBean {
    private String kind;
    private JPanel jPanel;
    private JLabel jLabel;

    public MenuBean() {
    }

    public MenuBean(String kind, JPanel jPanel, JLabel jLabel) {
        this.kind = kind;
        this.jPanel = jPanel;
        this.jLabel = jLabel;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kindl) {
        this.kind = kindl;
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    public JLabel getjLabel() {
        return jLabel;
    }

    public void setjLabel(JLabel jLabel) {
        this.jLabel = jLabel;
    }
    
    
}
