package br.com.brasilprev.Avaliacao.Services.implementacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.brasilprev.Avaliacao.model.Usuario;
import br.com.brasilprev.Avaliacao.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario user = usuarioRepository.findOneByUsername(username);

		if (user != null) {

			return user;
		} else {

			throw new UsernameNotFoundException("Usuário não encontado na base");
		}

	}
	
}
