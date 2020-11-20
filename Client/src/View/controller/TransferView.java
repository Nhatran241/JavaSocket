package View.controller;

import View.bean.MenuBean;
import View.searchJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TransferView {

    private JPanel jPanelRoot;
    private String kindSelected = "";

    private List<MenuBean> listItem = null;

    public TransferView(JPanel jPanelRoot) {
        this.jPanelRoot = jPanelRoot;
    }

    public void setView(JPanel jPanelItem, JLabel jLabelItem) {
        kindSelected = "search";
        jPanelItem.setBackground(new Color(0, 0, 204));
        jLabelItem.setBackground(new Color(0, 0, 204));

        jPanelRoot.removeAll();
        jPanelRoot.setLayout(new BorderLayout());
        jPanelRoot.add(new searchJPanel());
        jPanelRoot.validate();
        jPanelRoot.repaint();
    }

    public void setEvent(List<MenuBean> listItem) {
        this.listItem = listItem;
        listItem.forEach((item) -> {
            item.getjLabel().addMouseListener(new LabelEvent(item.getKind(), item.getjPanel(), item.getjLabel()));
        });
    }

    class LabelEvent implements MouseListener {

        private JPanel nodeJPanel;
        private String kind;
        private JPanel itemJPanel;
        private JLabel itemJLabel;

        public LabelEvent(String kind, JPanel itemJPanel, JLabel itemJLabel) {
            this.kind = kind;
            this.itemJPanel = itemJPanel;
            this.itemJLabel = itemJLabel;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "search":
                    nodeJPanel = new searchJPanel();
                    break;
                default:
                    break;
            }
            jPanelRoot.removeAll();
            jPanelRoot.setLayout(new BorderLayout());
            jPanelRoot.add(nodeJPanel);
            jPanelRoot.validate();
            jPanelRoot.repaint();
            setChangeBackgroud(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            itemJPanel.setBackground(new Color(0, 0, 204));
            itemJLabel.setBackground(new Color(0, 0, 204));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            itemJPanel.setBackground(new Color(0, 0, 204));
            itemJLabel.setBackground(new Color(0, 0, 204));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                itemJPanel.setBackground(new Color(66,133,244));
                itemJLabel.setBackground(new Color(66,133,244));
            }
        }

    }
    
    private void setChangeBackgroud(String kind) {
        listItem.forEach((item) -> {
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getjPanel().setBackground(new Color(0, 0, 204));
                item.getjLabel().setBackground(new Color(0, 0, 204));
            } else {
                item.getjPanel().setBackground(new Color(66,133,244));
                item.getjLabel().setBackground(new Color(66,133,244));
            }
        });
    }
}
