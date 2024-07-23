package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repository.CategoryRepository;
import com.devsuperior.dscatalog.services.exceptions.DataBaseException;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        List<Category> list= repository.findAll();
        return list.stream().map(CategoryDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        Category category = obj.orElseThrow(() -> new ResourceNotFoundException(
                "Id Nao Encontrado"
        ));
        return new CategoryDTO(category);
    }

    @Transactional(readOnly = true)
    public CategoryDTO registerCategory(CategoryDTO cat) {
        Category entity = new Category();
        entity.setName(cat.getName());
        entity = repository.save(entity);
        return new CategoryDTO(entity);
    }

    @Transactional(readOnly = true)
    public CategoryDTO update(CategoryDTO cat) {
        try {
            Category entity = repository.getReferenceById(cat.getId());
            entity.setName(cat.getName());
            entity = repository.save(entity);
            return new CategoryDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("id not found");
        }
    }

    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso nao encontrado");
        }try{
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException("Falha na integridade referencial");
        }
    }
}
