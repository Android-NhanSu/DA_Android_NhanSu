package com.example.nhansu.Model_Adapter;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserModel_Luong {
    private static final String TAG = "k";
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public UserModel_Luong() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }

    public List<item_khenthuong> getuserlist_KhenThuong() throws SQLException {
        List<item_khenthuong> list = new ArrayList<>();
        Statement statement = connection.createStatement();
        String sql =  "select NGAYKHENTHUONG, LOAITENKHENTHUONG, TIENTHUONG\n" +
        "from CHITIETKHENTHUONG, LOAIKHENTHUONG\n" +
        "where LOAIKHENTHUONG.MALOAIKHENTHUONG = CHITIETKHENTHUONG.MALOAIKHENTHUONG\n";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(new item_khenthuong(rs.getDate("NGAYKHENTHUONG").toString(), rs.getString("LOAITENKHENTHUONG"),rs.getBigDecimal("TIENTHUONG").toString()));// Đọc dữ liệu từ ResultSet
        }
        connection.close();// Đóng kết nối
        return list;
    }

    private class connect extends AsyncTask<Void,Void,Connection> {

        @Override
        protected Connection doInBackground(Void... voids) {
            connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
            Log.d("a", "UserModel_chamcong: "+connection);
            return connection;
        }
    }


}
