package com.example.nhansu.Model_Adapter;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserModel_listLuong {
    private static final String TAG = "k";
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public UserModel_listLuong() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }
    ////////////////////////////// luong ///////////////////////////////
    public List<item_luong> getuserlist_luong() throws SQLException {
        List<item_luong> list = new ArrayList<>();
        Statement statement = connection.createStatement();
        String sql = "select LUONGTHOATHUAN from CHITIETHOPDONG";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(new item_luong(rs.getBigDecimal("LUONGTHOATHUAN").toString()));// Đọc dữ liệu từ ResultSet
        }
        connection.close();// Đóng kết nối
        return list;
    }

    private class connect extends AsyncTask<Void,Void,Connection> {

        @Override
        protected Connection doInBackground(Void... voids) {
            connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
            Log.d("a", "UserModel_listLuong: "+connection);
            return connection;
        }
    }

}
