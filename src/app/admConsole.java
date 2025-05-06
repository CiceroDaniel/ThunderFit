package app;
import java.time.LocalDate;
import java.util.*;

import repository.UsuarioRepository;
import services.UsuarioService;

public class admConsole {
	UsuarioRepository uRepo = new UsuarioRepository();
	UsuarioService services = new UsuarioService(uRepo);
	Scanner scanner = new Scanner(System.in);
	
	public void cdAdm() {
		String dataScn = "2006-10-23";
		LocalDate dataDeNascimento = LocalDate.parse(dataScn);
		services.cadastroAdministrador("daniel", "12314563610", "daniel@gmail.com", "123123123", dataDeNascimento);
	}
	
}
