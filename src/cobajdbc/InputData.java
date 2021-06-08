
package cobajdbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class InputData extends JFrame{
    public String nim, nama, alamat;
    
    DBConnect connect = new DBConnect();    
    
    //DEKLARASI KOMPONEN
    JFrame window = new JFrame("JDBC");
   
    JLabel lNIM = new JLabel("NIM  ");
        JTextField tfNIM = new JTextField();
    JLabel lNama = new JLabel("NAMA  ");
        JTextField tfNama = new JTextField();
    JLabel lAlamat = new JLabel("ALAMAT ");
        JTextField tfAlamat = new JTextField();

    JButton btnTambahPanel = new JButton("Tambah");
    JButton btnLihat = new JButton("Lihat");

    public InputData() {
        window.setLayout(null);
        window.setSize(550,200);
      //  window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);


       // setDefaultCloseOperation(EXIT_ON_CLOSE);

//ADD COMPONENT
        window.add(lNama);
        window.add(tfNIM);
        window.add(tfNama);
        window.add(tfAlamat);
        window.add(lNIM);
        window.add(lAlamat);
        window.add(btnTambahPanel);
        window.add(btnLihat);



//LABEL
        lNIM.setBounds(5, 35, 120, 20);
        lNama.setBounds(5, 60, 120, 20);
        lAlamat.setBounds(5,105,120,20);

//TEXTFIELD
        tfNIM.setBounds(110, 35, 120, 20);
        tfNama.setBounds(110, 60, 120, 20);
        tfAlamat.setBounds(110, 105, 120, 20);


//BUTTON PANEL
        btnTambahPanel.setBounds(250, 35, 90, 20);
        btnLihat.setBounds(250,60,90,20);

        
        btnTambahPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                   try {
            String query = "INSERT INTO `mahasiswa`(`nim`, `nama`, `alamat`) VALUES ('"+getNIM()+"','"+getNama()+"','"+getAlamat()+"')";
            
            connect.statement = connect.connection.createStatement();
            connect.statement.executeUpdate(query);

            System.out.println("Insert Berhasil");
            JOptionPane.showMessageDialog(null,"Insert Berhasil !!");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
            }
        });
        
        btnLihat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                LihatData lihat = new LihatData();
            }
        });
    }
    
    

    public String getNama(){
        return tfNama.getText();
    }

    public String getNIM() {
        return tfNIM.getText();
    }

    public String getAlamat() {
        return tfAlamat.getText();
    }
    
    public void inputDB(){
        
    }
}


