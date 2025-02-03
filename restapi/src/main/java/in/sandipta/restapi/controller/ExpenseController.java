package in.sandipta.restapi.controller;

import in.sandipta.restapi.dto.ExpenseDTO;
import in.sandipta.restapi.io.ExpenseResponse;
import in.sandipta.restapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;  // Add this import

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class ExpenseController {

    private final ExpenseService expenseService;
    private final ModelMapper modelMapper;

    @GetMapping("/expenses")
    public List<ExpenseResponse> getExpense() {  // Change return type to List<ExpenseResponse>
        log.info("API GET /expenses called");
        // Call the service method
        List<ExpenseDTO> list = expenseService.getAllExpenses();
        log.info("Printing the data from the service{}", list);
        // Convert the Expense DTO to Expense Response
        List<ExpenseResponse> response = list.stream()  // Correct the stream usage
                .map(expenseDTO -> modelMapper.map(expenseDTO, ExpenseResponse.class))
                .collect(Collectors.toList());
        // Return the response/list
        return response;
    }

    private ExpenseResponse mapToExpenseResponse(ExpenseDTO expenseDTO) {
        return modelMapper.map(expenseDTO, ExpenseResponse.class);
    }
}
