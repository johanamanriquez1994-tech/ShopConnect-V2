package com.shopconnect.ms_usuarios.service;

import com.shopconnect.ms_usuarios.dto.UsuarioDTO;
import com.shopconnect.ms_usuarios.model.Usuario;
import com.shopconnect.ms_usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario save(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        
        usuario.setNombre(usuarioDTO.getUsername());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(usuarioDTO.getPassword());
        
        return usuarioRepository.save(usuario);
    }
}