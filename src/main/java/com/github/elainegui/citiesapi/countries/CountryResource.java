package com.github.elainegui.citiesapi.countries;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {
    //@Autowired //posso fazer isso ao inves de criar o construtor
    private CountryRepository repository;

    public CountryResource(CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<Country> countries(Pageable page){
        // Pageable do spring e usado para paginar quando se tem muitos dados
        // agora o spring vai devolver uma pagina ao inves de uma lista
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    //public Country getOne (@PathVariable Long id){
    public ResponseEntity<Country> getOne (@PathVariable Long id){
        // return repository.findById(id);
        Optional<Country> optional = repository.findById(id);
        //return optional.get();  //vai retornar o country mas vai dar erro 500 se esse id nao existir

        if(optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
            //agora o metodo precisa retornar uma ResponseEntity
    }
}
