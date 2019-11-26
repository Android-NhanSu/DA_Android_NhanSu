package com.example.nhansu.Model_Adapter;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserModel_dangnhap {
    private static final String TAG = "k";
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;
    String user;
    String pass;

   // String z="";

    public UserModel_dangnhap() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }

    public Boolean kiemtra_user(String manv, String pass) throws SQLException {
         boolean result = false;
        List<item_dangnhap> list = new ArrayList<>();
        connection = jdbcController.ConnnectionData();
        String sql = "select MANV, MATKHAU from TAIKHOAN \n" +
                "where MANV='"+manv+"' and MATKHAU='"+pass+"'";
        Statement statement = connection.createStatement();
        // Tạo đối tượng Statement.
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(new item_dangnhap(rs.getString("MANV"), rs.getString("MATKHAU")));// Đọc dữ liệu từ ResultSet
        }
        connection.close();// Đóng kết nối
        if(list.size()>0)
            result=true;
        return result;
    }
    private class connect extends AsyncTask<Void, Void, Connection> {

        @Override
        protected Connection doInBackground(Void... voids) {
            connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
            Log.d("a", "UserModel_dangnhap: " + connection);
            return connection;
        }
    }
}


//if (connection == null) {
//        z = "Không thể đang nhập";
//        } else {
//
//        String sql = "select MANV, MATKHAU from TAIKHOAN where MANV='" + manv + "' && MATKHAU='" + pass + "'";
//        Statement statement = connection.createStatement();
//        ResultSet rs = statement.executeQuery(sql);
//        while (rs.next()) {
//        list.add(new item_dangnhap(rs.getString("MANV"), rs.getString("MATKHAU")));// Đọc dữ liệu từ ResultSet
//        }
//        if (rs.next()) {
//        z = "Đang nhập thành công";
//        } else {
//        z = "Sai tài khoản hoặc mật khẩu";
//        }
//        }
//        return z;
