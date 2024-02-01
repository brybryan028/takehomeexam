import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileManagerGUI extends JFrame {
    private JTextField fileNameField, extensionField, sizeField;
    private JButton saveButton, deleteButton;
    private JPanel filePanel, buttonPanel;
    private JTable fileTable;
    private JScrollPane tableScrollPane;

    public FileManagerGUI() {

        setTitle("File Manager");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        filePanel = new JPanel();
        filePanel.setLayout(new GridLayout(4, 2));
        filePanel.add(new JLabel("Nama File:"));

        fileNameField = new JTextField();
        filePanel.add(fileNameField);
        filePanel.add(new JLabel("Ekstensi:"));

        extensionField = new JTextField();
        filePanel.add(extensionField);
        filePanel.add(new JLabel("Ukuran dalam MB:"));

        sizeField = new JTextField();
        filePanel.add(sizeField);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        tombolSimpan = new JButton("Simpan");
        tombolHapus = new JButton("Hapus");
        buttonPanel.add(tombolSimpan);
        buttonPanel.add(tombolHapus);

        tombolSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(FileManagerGUI.this, "Berhasil di Simpan!");
            }
        });

        tombolHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(FileManagerGUI.this, "Berhasil di Hapus!");
            }
        });

        setLayout(new BorderLayout());
        add(filePanel, BorderLayout.NORTH);

        String[] columnNames = {"Nama File", "Ekstensi", "Ukuran dalam MB"};
        String[][] data = {
                {"data penghasilan", "xls", "500"},
                {"007movie", "mp4", "2000"},
                {"fotokeluarga", "jpg", "5"}
        };
        fileTable = new JTable(data, columnNames);
        tableScrollPane = new JScrollPane(fileTable);
        add(tableScrollPane, BorderLayout.CENTER);

        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileManagerGUI();
            }
        });
    }
}