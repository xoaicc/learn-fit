package com.example.jspservlet.dao;

import com.example.jspservlet.dbconnect.DBConnect;
import com.example.jspservlet.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection connection;

    public BookDAO() {
        connection = DBConnect.getConnection();
    }

    public List<Book> selectAllBooks() {
        List<Book> books = new ArrayList<>();

        try {
            String sql = "SELECT * FROM book";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String author = rs.getString("author");
                float price = rs.getFloat("price");
                books.add(new Book(id, title, author, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    public Book selectBook(int id) {
        Book book = null;
        try {
            String sql = "SELECT * FROM Book WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                float price = rs.getFloat("price");
                book = new Book(id, title, author, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public void insertBook(Book book) {
        try {
            String sql = "INSERT INTO Book (title, author, price) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setFloat(3, book.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean updateBook(Book book) {
        boolean rowUpdated = false;
        try {
            String sql = "UPDATE Book SET title = ?, author = ? , price = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setFloat(3, book.getPrice());
            ps.setInt(4, book.getId());
            rowUpdated = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    public boolean deleteBook(int id) {
        boolean rowDeleted = false;
        try {
            String sql = "DELETE FROM Book WHERE id = ?";
            PreparedStatement ps= connection.prepareStatement(sql);
            ps.setInt(1, id);
            rowDeleted = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}
