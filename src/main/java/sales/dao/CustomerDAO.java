package sales.dao;

import sales.entities.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO {
    private final Connection conn;

    public CustomerDAO(Connection conn) {
        this.conn = conn;
    }

    public ArrayList<Customer> selectAll() throws SQLException {
        if (conn == null) return null;

        String select = "SELECT customer_id, customer_name, contact_name, address, city, post_code, country " +
                "FROM customers ORDER BY customer_id";

        ArrayList<Customer> customers = new ArrayList<>();

        try (Statement s = conn.createStatement();
             ResultSet rs = s.executeQuery(select)) {

            while (rs.next()) {
                Customer c = new Customer();

                c.setId(rs.getInt("customer_id"));
                c.setName(rs.getString("customer_name"));
                c.setContact(rs.getString("contact_name"));
                c.setAddress(rs.getString("address"));
                c.setCity(rs.getString("city"));
                c.setPostCode(rs.getString("post_code"));
                c.setCountry(rs.getString("country"));

                customers.add(c);
            }

        } catch (SQLException e) {
            throw new SQLException("Can not display customers: " + e.getMessage());
        }

        return customers;
    }

    public boolean insert(Customer customer) throws SQLException {
        if (conn == null) return false;

        String insert = "INSERT INTO customers (customer_name, contact_name, address, city, post_code, country) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        int index = 1;
        try (PreparedStatement ps = conn.prepareStatement(insert)) {
            ps.setString(index++, customer.getName());
            ps.setString(index++, customer.getContact());
            ps.setString(index++, customer.getAddress());
            ps.setString(index++, customer.getCity());
            ps.setString(index++, customer.getPostCode());
            ps.setString(index++, customer.getCountry());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new SQLException("Can not insert customer: " + e.getMessage());
        }
    }

    public boolean update(int id, Customer customer) throws SQLException {
        if (conn == null) return false;

        String update = "UPDATE customers SET customer_name=?, contact_name=?, address=?, city=?, post_code=?, country=? " +
                "WHERE customer_id=?";

        int index = 1;
        try (PreparedStatement ps = conn.prepareStatement(update)) {
            ps.setString(index++, customer.getName());
            ps.setString(index++, customer.getContact());
            ps.setString(index++, customer.getAddress());
            ps.setString(index++, customer.getCity());
            ps.setString(index++, customer.getPostCode());
            ps.setString(index++, customer.getCountry());

            ps.setInt(index, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new SQLException("Can not update customer: " + e.getMessage());
        }
    }

    public boolean delete(int id) throws SQLException {
        if (conn == null) return false;

        String delete = "DELETE FROM customers WHERE customer_id=?";

        try (PreparedStatement ps = conn.prepareStatement(delete)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new SQLException("Can not delete customer: " + e.getMessage());
        }
    }
}
