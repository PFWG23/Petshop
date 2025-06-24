package ui.panels;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class HeaderPanel {
    
    public JPanel createHeader(Font fntBold, Font fntCustom, Color darkBlue) {
        JPanel header = new JPanel(new BorderLayout());
          header.setBackground(darkBlue);
          header.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        JLabel title = new JLabel("Sistema Pet Shop");
          title.setFont(fntBold.deriveFont(20f));
          title.setForeground(Color.WHITE);
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM HH:mm");
        JLabel time = new JLabel(fmt.format(new Date()));
          time.setFont(fntCustom);
          time.setForeground(Color.WHITE);
          header.add(title, BorderLayout.WEST);
          header.add(time, BorderLayout.EAST);
        return header;
    }
}
