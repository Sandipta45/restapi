package in.sandipta.restapi.repository;

import in.sandipta.restapi.entity.ExpenseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {
    @Bean
    public default ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
