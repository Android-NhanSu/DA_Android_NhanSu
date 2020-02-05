package com.example.nhansu.Model_Adapter;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCModel {
    public Connection getConnectionOf() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection objConn = null;
        String sConnURL = null;

//<<<<<<< HEAD
        JDBCObject objEntity = new JDBCObject("172.20.10.5", "sa", "sa2012", "DA_WIN_NANGCAO","1433");
//=======
        /*JDBCObject objEntity = new JDBCObject("192.168.1.81", "sa", "sa2012", "DA_WIN_NANGCAO","1433");
>>>>>>> 9fbbb6bf1e84c9bf08c9c8460a838e3c9cb2073e*/
        try {
            Class.forName(objEntity.getsClass());

            sConnURL = "jdbc:jtds:sqlserver://"
                    + objEntity.getsServerName() + ":" + objEntity.getsPrort() + ";"
                    + "databaseName=" + objEntity.getsDatabase()
                    + ";user=" + objEntity.getsUserId()
                    + ";password=" + objEntity.getsPwd() + ";";
            objConn = DriverManager.getConnection(sConnURL);
        } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        return objConn;
    }
}
