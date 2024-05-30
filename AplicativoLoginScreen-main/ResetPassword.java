package loginScreen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ResetPassword {
public void resetPassword(String username) {
	
String newPassword = JOptionPane.showInputDialog("Digite a nova senha:");

if (newPassword != null && !newPassword.isEmpty()) {
	String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados"; // Corrigido de 'msql' para 'mysql'
	String user = "seu_usuario";
	String pass = "sua_senha";

	try {
		Connection connection = DriverManager.getConnection(url, user, pass);
		String query = "UPDATE usuarios SET password=? WHERE username=?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, newPassword);
		statement.setString(2, username);

		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {

			JOptionPane.showMessageDialog(null, "Senha resetada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
		}

	} catch (SQLException ex) {
		ex.printStackTrace();
		JOptionPane.showMessageDialog(null, "Erro ao resetar a senha!", "Erro", JOptionPane.ERROR_MESSAGE);
	}

} else {
	JOptionPane.showMessageDialog(null, "Nova senha não pode ser vazia!", "Erro", JOptionPane.ERROR_MESSAGE);

		}

	}
}
