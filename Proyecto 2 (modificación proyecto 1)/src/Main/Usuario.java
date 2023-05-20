package Main;

import java.util.ArrayList;
import java.util.HashMap;

public class Usuario {
	public HashMap<String,ArrayList<String>> MapaUsuarios=new HashMap<>();
	
	public boolean CrearUsuario(String usuario, String contraseña) {
		if (this.MapaUsuarios.containsKey(usuario)) {
			return false;
		}else {
			ArrayList<String> infoUsuario = new ArrayList<>();
			infoUsuario.add(usuario);
			infoUsuario.add(contraseña);
			this.MapaUsuarios.put(usuario, infoUsuario);
			return true;
		}	
	}
	public boolean VerificarUsuario(String usuario, String contraseña) {
		if(this.MapaUsuarios.containsKey(usuario)) {
			ArrayList<String> mapa=this.MapaUsuarios.get(usuario);
			if(mapa.contains(contraseña)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
}
