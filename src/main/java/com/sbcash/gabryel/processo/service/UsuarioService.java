package com.sbcash.gabryel.processo.service;

import com.sbcash.gabryel.processo.dto.UsuarioDTO;
import com.sbcash.gabryel.processo.entity.jpa.UsuarioEntity;
import com.sbcash.gabryel.processo.execption.BusinessException;
import com.sbcash.gabryel.processo.publisher.LogUsuarioPublisher;
import com.sbcash.gabryel.processo.repository.jpa.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private LogUsuarioPublisher usuarioPublisher;
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, LogUsuarioPublisher usuarioPublisher) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioPublisher = usuarioPublisher;
    }

    public UsuarioDTO buscarUsuarioPorId(Long id) throws BusinessException {
        var optEntity = usuarioRepository.findById(id);
        if (optEntity.isPresent())
            return new UsuarioDTO(optEntity.get());

        throw new BusinessException(" Usuario nao encontrado");
    }

    public UsuarioDTO salvarUsuario(UsuarioDTO dto) {
        var entity = new UsuarioEntity(dto);
        entity = usuarioRepository.save(entity);
        dto.setId(entity.getId());
        usuarioPublisher.publisher(dto);

        return dto;
    }

    public void deletarUsuario(Long id) throws BusinessException{
        var entity = buscarUsuarioPorId(id);
        usuarioRepository.deleteById(entity.getId());
    }

}
