package com.example.nhansu.Model_Adapter;
import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserModel_chamcong {

    private static final String TAG = "k";
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public UserModel_chamcong() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database

    }

    public List<item_lscc> getuserlist() throws SQLException {
        List<item_lscc> list = new ArrayList<>();
//        connection = jdbcController.ConnnectionData();
//        Statement statement = null;
       // Tạo đối tượng Statement.

        Statement statement = connection.createStatement();
        String sql = "select NGAYLAM, GIOVAO, GIORA from BANGCHAMCONG";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(new item_lscc(rs.getDate("NGAYLAM").toString(), rs.getTime("GIOVAO").toString(),rs.getTime("GIORA").toString()));// Đọc dữ liệu từ ResultSet
        }


        connection.close();// Đóng kết nối
        return list;
    }

    private class connect extends AsyncTask<Void,Void,Connection>{

        @Override
        protected Connection doInBackground(Void... voids) {
            connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
            Log.d("a", "UserModel_chamcong: "+connection);
            return connection;
        }
    }
}
