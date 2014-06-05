package windows;

import gui2.MainWindow;
import gui2.Model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class ExecuteWindow extends javax.swing.JFrame {

    JEditorPane pane = new JEditorPane();
    JScrollPane scrollPane = new JScrollPane();

    public ExecuteWindow() throws IOException, InterruptedException {
        initComponents();
        this.scrollPane.setViewportView(pane);
        this.add(scrollPane);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        run();
    }

    private void append(String s) {
        try {
            Document doc = pane.getDocument();
            doc.insertString(doc.getLength(), s, null);
        } catch (BadLocationException exc) {
            exc.printStackTrace();
        }
    }

    private void run() throws IOException, InterruptedException {
        String command = Model.getInstance().getFileManager().getFortranPath().getAbsolutePath();

        Process proc = Runtime.getRuntime().exec(command);

        BufferedReader reader
                = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        String line = "";
        while ((line = reader.readLine()) != null) {
            //System.out.print(line + "\n");
            append(line + "\n");
        }

        proc.waitFor();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
