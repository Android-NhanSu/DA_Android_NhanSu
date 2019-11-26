package com.example.nhansu.Model_Adapter;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserModel_NV {
    private static final String TAG = "k";
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public UserModel_NV() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database

    }

    public List<item_nv> loadnv( String Mnv) throws SQLException {
        List<item_nv> list = new ArrayList<>();
//        connection = jdbcController.ConnnectionData();
//        Statement statement = null;
        // Tạo đối tượng Statement.

        Statement statement = connection.createStatement();

        String sql ="SELECT MANV,NHANVIEN.HOTEN, GIOITINH, DIENTHOAI, EMAIL, NGAYSINH,  TENCHUCVU, TENPHONGBAN, TENNGOAINGU, TENTRINHDOHOCVAN, NGAYVAOLAM, DIACHITHUONGTRU, QUEQUAN\n" +
                "FROM NHANVIEN , HOSOTUYENDUNG, CHUCVU, PHONGBAN, NGOAINGU, TRINHDOHOCVAN, CHITIETNGOAINGU\n" +
                "WHERE NHANVIEN.MAHOSO=HOSOTUYENDUNG.MAUNGVIEN AND NHANVIEN.MAPHONGBAN=PHONGBAN.MAPHONGBAN AND NHANVIEN.MACHUCVU=CHUCVU.MACHUCVU AND\n" +
                " HOSOTUYENDUNG.MATRINHDOHOCVAN=TRINHDOHOCVAN.MATRINHDOHOCVAN AND HOSOTUYENDUNG.MAUNGVIEN=CHITIETNGOAINGU.MAUNGVIEN AND NGOAINGU.MANGOAINGU=CHITIETNGOAINGU.MANGOAINGU\n" +
                " AND MANV='"+Mnv+"'";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            // list.add(new item_lscc(rs.getDate("").toString(), rs.getTime("GIOVAO").toString(),rs.getTime("GIORA").toString()));// Đọc dữ liệu từ ResultSet

            boolean add = list.add(new item_nv(rs.getString("MANV"), rs.getString("HOTEN"), rs.getString("GIOITINH"),rs.getString("DIENTHOAI"),
                    rs.getString("EMAIL"), rs.getString("DIACHITHUONGTRU"), rs.getString("TENCHUCVU"), rs.getString("TENPHONGBAN"),
                    rs.getString("TENNGOAINGU"), rs.getString("TENTRINHDOHOCVAN"), rs.getDate("NGAYVAOLAM").toString(), rs.getDate("NGAYSINH").toString(),
                    rs.getString("QUEQUAN")));
        }

        connection.close();// Đóng kết nối
        return list;
    }
    public List<item_suattnv> loadhsuv( String Mnv) throws SQLException {
        List<item_suattnv> list = new ArrayList<>();
//        connection = jdbcController.ConnnectionData();
//        Statement statement = null;
        // Tạo đối tượng Statement.

        Statement statement = connection.createStatement();

        String sql ="select MANV, DIENTHOAI, DIACHITHUONGTRU, EMAIL\n" +
                "from HOSOTUYENDUNG, NHANVIEN\n" +
                "where HOSOTUYENDUNG.MAUNGVIEN=NHANVIEN.MAHOSO and MANV='"+Mnv+"'";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            // list.add(new item_lscc(rs.getDate("").toString(), rs.getTime("GIOVAO").toString(),rs.getTime("GIORA").toString()));// Đọc dữ liệu từ ResultSet

            boolean add = list.add(new item_suattnv(rs.getString("MANV"),rs.getString("DIENTHOAI"),rs.getString("DIACHITHUONGTRU"),rs.getString("EMAIL")));
        }

        connection.close();// Đóng kết nối
        return list;
    }


    public boolean Update(String pma,  String pdt, String pdc, String emai) throws SQLException {
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
       String sql = "update HOSOTUYENDUNG SET DIENTHOAI='"+pdt+"',DIACHITHUONGTRU='"+pdc+"', EMAIL='"+emai+"'from HOSOTUYENDUNG INNER JOIN NHANVIEN on(HOSOTUYENDUNG.MAUNGVIEN=NHANVIEN.MAHOSO) where  MANV='"+pma+"'";
        if (statement.executeUpdate(sql) > 0) {
            connection.close();
            return true;
        } else
            connection.close();
        return false;
    }

    private class connect extends AsyncTask<Void,Void,Connection> {

        @Override
        protected Connection doInBackground(Void... voids) {
            connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
           // Log.d("a", "UserModel_chamcong: "+connection);
            return connection;
        }
    }

}
