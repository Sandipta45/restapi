package in.sandipta.restapi.service;

import in.sandipta.restapi.dto.ExpenseDTO;

import java.util.List;

public interface ExpenseService {

    List<ExpenseDTO> getAllExpenses();

}
