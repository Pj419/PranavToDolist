package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Student;

public class StudentDao {
	public int insertStudent(Student s) {
		int check = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/", "sql12740819",
					"Xwn1XDG8bM");
			String sql = "insert  into student(name,city,percentage)values(?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, s.getName());
			pst.setString(2, s.getCity());
			pst.setDouble(3, s.getPercentage());
			check = pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return check;
	}

	public int deleteById(int id) {
		int check = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/", "sql12740819",
					"Xwn1XDG8bM");
			String sql = "delete from student where id=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			check = pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return check;
	}

	public Student findStudentById(int id) {
		Student s1 = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/", "sql12740819",
					"Xwn1XDG8bM");
			String sql = "select id, name,city,percentage from student where id=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				s1 = new Student();
				s1.setId(rs.getInt("id"));
				s1.setName(rs.getString("name"));
				s1.setCity(rs.getString("city"));
				s1.setPercentage(rs.getDouble("percentage"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return s1;
	}

	public List<Student> findAllStudent() {
		List<Student> list = new ArrayList();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/", "sql12740819",
					"Xwn1XDG8bM");
			String sql = "select id,name,city,percentage from student";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Student s1 = new Student();
				s1.setId(rs.getInt("id"));
				s1.setName(rs.getString("name"));
				s1.setCity(rs.getString("city"));
				s1.setPercentage(rs.getDouble("percentage"));
				list.add(s1);
			}
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return list;

	}

	public int updateStudent(Student s) {
		int check = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/", "sql12740819",
					"Xwn1XDG8bM");
			String sql = "update student set name=?,city=?,percentage=? where id=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, s.getName());
			pst.setString(2, s.getCity());
			pst.setDouble(3, s.getPercentage());
			pst.setInt(4, s.getId());
			check = pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return check;
	}
}
