package ch.bbw.addressbook;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AddressDAO_Database implements AddressDAO {

	private Connection connection; // TODO: to be replaced by connection pool

	private int idCounter = 0;
	private int getNewId() { return idCounter++; }

	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;


	@PostConstruct
	private void init() {
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, username,password);

			try (
					PreparedStatement stmt = connection.prepareStatement("CREATE TABLE IF NOT EXISTS address ( " +
						"id INT PRIMARY KEY, " +
						"firstname varchar(255), " +
						"lastname varchar(255), " +
						"phonenumber varchar(255), " +
						"registrationdate DATE " +
					");");
			) {
				stmt.execute();
				System.out.println("Created address table");
			}
		} catch (SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	@PreDestroy
	private void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Address ResultSet_to_Address(ResultSet entry) throws SQLException {
		return new Address(
				entry.getInt("id"), entry.getString("firstname"),
				entry.getString("lastname"), entry.getString("phonenumber"),
				new java.util.Date(entry.getDate("registrationDate").getTime()));
	}


	@Override
	public boolean isAvailable() {
		try {
			return connection.isValid(5);
		} catch (SQLException e) {
			return false;
		}
	}
	@Override
	public int getUniqueId() {
		return 4007;
	}

	// CRUD Commands: Create Read Update Delete
	@Override
	public Address read(int id) {
		try (
				PreparedStatement stmt = connection.prepareStatement("SELECT * FROM address WHERE id=?");
		) {
			stmt.setInt(1, id);
			try (ResultSet entries = stmt.executeQuery();) {
				if (entries.next()) {
					return (ResultSet_to_Address(entries));
				}
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Address> readAll() {
		List<Address> list = new ArrayList<>();
		try (
				Statement stmt = connection.createStatement();
				ResultSet entries = stmt.executeQuery("SELECT * FROM address");
		) {
			while (entries.next()) {
				list.add(ResultSet_to_Address(entries));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Address create(Address address) {
		address.setId(getNewId());
		try (
				PreparedStatement stmt = connection.prepareStatement(
						"INSERT INTO address (id, firstname, lastname, phonenumber, registrationdate) " +
								"VALUES (?, ?, ?, ?, ?)"
				);
		) {
			stmt.setInt(1, address.getId());
			stmt.setString(2, address.getFirstname());
			stmt.setString(3, address.getLastname());
			stmt.setString(4, address.getPhonenumber());
			stmt.setDate(5, new java.sql.Date(
					address.getRegistrationDate().getTime()
			));
			stmt.execute();

			return address; // Everything ok
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Address update(Address address) {
		try (
				PreparedStatement stmt = connection.prepareStatement(
						" UPDATE address SET firstname = ?, lastname = ?, phonenumber = ?, registrationdate = ? " +
								"WHERE id=?"
				);
		) {
			stmt.setString(1, address.getFirstname());
			stmt.setString(2, address.getLastname());
			stmt.setString(3, address.getPhonenumber());
			stmt.setDate(4, new java.sql.Date(
					address.getRegistrationDate().getTime()
			));
			stmt.setInt(5, address.getId());
			stmt.execute();

			return address; // Everything ok
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void delete(int id) {
		try (
				PreparedStatement stmt = connection.prepareStatement("DELETE FROM address WHERE id=?");
		) {
			stmt.setInt(1, id);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAll() {
		try (
				PreparedStatement stmt = connection.prepareStatement("TRUNCATE TABLE address");
		) {
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
