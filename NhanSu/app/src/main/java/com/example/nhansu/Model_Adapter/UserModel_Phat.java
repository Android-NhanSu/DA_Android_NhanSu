package com.example.nhansu.Model_Adapter;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserModel_Phat {
    private static final String TAG = "k";
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public UserModel_Phat() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }
    ////////////////////// ky luat //////////////////////////////
    public List<item_phat> getuserlist_Phat() throws SQLException {
        List<item_phat> list1 = new ArrayList<>();
        Statement statement = connection.createStatement();
        String sql =  "select NGAYKYLUAT, TENKYLUAT, TIENKYLUAT\n" +
                " from QUANLYKYLUAT, DS_KYLUAT\n" +
                "where QUANLYKYLUAT.MAKYLUAT = DS_KYLUAT.MAKYLUAT\n";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list1.add(new item_phat(rs.getDate("NGAYKYLUAT").toString(), rs.getString("TENKYLUAT"),rs.getBigDecimal("TIENKYLUAT").toString()));// Đọc dữ liệu từ ResultSet
        }
        connection.close();// Đóng kết nối
        return list1;
    }

    private class connect extends AsyncTask<Void,Void,Connection> {

        @Override
        protected Connection doInBackground(Void... voids) {
            connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
            Log.d("a", "UserModel_Phat: "+connection);
            return connection;
        }
    }
}
