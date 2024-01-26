package edu.example.demoDocker.service.impl;

import edu.example.demoDocker.models.TppRefAccountType;
import edu.example.demoDocker.repository.TppRefAccountTypeRepository;
import edu.example.demoDocker.service.TppRefAccountTypeService;
import edu.example.demoDocker.service.convertor.TppRefAccountTypeMapper;
import edu.example.demoDocker.service.dto.TppRefAccountTypeDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TppRefAccountTypeServiceImpl implements TppRefAccountTypeService {
    private final TppRefAccountTypeRepository tppRefAccountTypeRepository;
    private final TppRefAccountTypeMapper tppRefAccountTypeMapper;

    @Override public List<TppRefAccountTypeDTO> findAll() {
        return tppRefAccountTypeMapper.toListDto(tppRefAccountTypeRepository.findAll());
    }

    @Override public TppRefAccountTypeDTO findById(@NonNull Long id) {
        return Optional.ofNullable(getById(id)).map(tppRefAccountTypeMapper::modelToDto).get();
    }

    @Override @Transactional
    public TppRefAccountTypeDTO save(TppRefAccountTypeDTO book) {
        return tppRefAccountTypeMapper.modelToDto(tppRefAccountTypeRepository.save(
                tppRefAccountTypeMapper.dtoToModel(book)));
    }
    @Override @Transactional public void deleteById(Long id) {
        var book = getById(id);
        tppRefAccountTypeRepository.delete(book);
    }
    private TppRefAccountType getById(Long id) {
        return tppRefAccountTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Book with id: " + id + " not found"));
    }
}
