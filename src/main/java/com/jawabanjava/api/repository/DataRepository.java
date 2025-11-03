package com.jawabanjava.api.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.jawabanjava.api.model.Transaction;
import com.jawabanjava.api.model.Status;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DataRepository {

    private final JdbcTemplate jdbc;

    public DataRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Transaction> findAllTransactions() {
        String sql = "SELECT id, productID, productName, amount, customerName, status, " +
                     "DATE_FORMAT(transactionDate, '%Y-%m-%d %H:%i:%s') AS transactionDate, " +
                     "createBy, DATE_FORMAT(createOn, '%Y-%m-%d %H:%i:%s') AS createOn " +
                     "FROM transactions";
        return jdbc.query(sql, (rs, rowNum) -> mapTransaction(rs));
    }

    public List<Status> findAllStatus() {
        String sql = "SELECT id, name FROM status_master";
        return jdbc.query(sql, (rs, rowNum) -> {
            Status s = new Status();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            return s;
        });
    }

    private Transaction mapTransaction(ResultSet rs) throws SQLException {
        Transaction t = new Transaction();
        t.setId(rs.getInt("id"));
        t.setProductID(rs.getString("productID"));
        t.setProductName(rs.getString("productName"));
        t.setAmount(rs.getString("amount"));
        t.setCustomerName(rs.getString("customerName"));
        t.setStatus(rs.getInt("status"));
        t.setTransactionDate(rs.getString("transactionDate"));
        t.setCreateBy(rs.getString("createBy"));
        t.setCreateOn(rs.getString("createOn"));
        return t;
    }
}
