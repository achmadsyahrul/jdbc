package cobajdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class LihatData {
    public String nim, nama, alamat;
    int jmlData;
    String data[][] = new String[500][4];
    
    DBConnect connect = new DBConnect();    
    
    //DEKLARASI KOMPONEN
    JFrame window = new JFrame("JDBC");
    JTable tabel;
    DefaultTableModel tableModel; //otomatis dibuat kalo buat JTable
    JScrollPane scrollPane;
    Object namaKolom[] = {"NIM","Nama","Alamat"}; //membuat kolom dgn array tipe object;

    public LihatData(){
        window.setLayout(null);
        window.setSize(550,600);
      //  window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        try{
            int jmlData = 0; //menampung jumlah data sebanyak jumlah data yang ada, defaultnya 0
            String query = "Select * from `mahasiswa`"; //proses pengambilan data
            connect.statement = connect.connection.createStatement();
            ResultSet resultSet = connect.statement.executeQuery(query); //result isinya tabel belum berupa string
            while(resultSet.next()){ //konversi tabel ke string
                data[jmlData][0] = resultSet.getString("nim"); 
                data[jmlData][1] = resultSet.getString("nama"); 
                data[jmlData][2] = resultSet.getString("alamat");
                jmlData++; 
            }
            connect.statement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
        
        tabel = new JTable(data,namaKolom); //tabel merupakan variabel untuk tabelnya dengan isi tablemodel
        scrollPane = new JScrollPane(tabel);
        window.add(scrollPane);
        
        scrollPane.setBounds(20, 35, 500, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        
    }
    
    public int getBanyakData(){ //menghitung jumlah baris yg ada pada db
        int jmlData = 0; //nilai awal 0
        try{
            connect.statement = connect.connection.createStatement();
            String query = "Select * from `mahasiswa`";
            ResultSet resultSet = connect.statement.executeQuery(query); //pengambilan data dalam java dari database
            while(resultSet.next()){ //ambil nilai dari baris ke 0 sampai baris akhir
                jmlData++;
            }
            return jmlData; //mengembalikan jumlah data ke readData
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
        
    }
    
    public String[][] readData(){ //dua dimensi (baris-kolom)
        try{
            int jmlData = 0; //menampung jumlah data sebanyak jumlah data yang ada, defaultnya 0
            String data[][] = new String[getBanyakData()][4];//menampung array. barisnya isinya di getBanyakData,kolomnya itu atribut
            String query = "Select * from `mahasiswa`"; //proses pengambilan data
            ResultSet resultSet = connect.statement.executeQuery(query); //result isinya tabel belum berupa string
            while(resultSet.next()){ //konversi tabel ke string
                data[jmlData][0] = resultSet.getString("nim"); 
                data[jmlData][1] = resultSet.getString("nama"); 
                data[jmlData][2] = resultSet.getString("alamat");
                jmlData++; 
                
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
}
