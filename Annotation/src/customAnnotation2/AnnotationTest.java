package customAnnotation2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Nina
 * DateTime 2020/8/4 13:04
 * Description
 */
public class AnnotationTest {
    private JFrame mainWin = new JFrame("使用注解绑定事件监听器");
    @ActionListenerFor(listener = OkListener.class)
    private JButton ok = new JButton("确定");
    @ActionListenerFor(listener = CancelListener.class)
    private JButton cancel = new JButton("取消");

    public void init() {
        JPanel jp = new JPanel();
        jp.add(ok);
        jp.add(cancel);
        mainWin.add(jp);
        ActionListenerInstaller.processAnnotation(this);
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);
    }

    public static void main(String[] args) {
        new AnnotationTest().init();
    }
}

class OkListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "单机了确认按钮");
    }
}

class CancelListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "单机了取消按钮");
    }
}