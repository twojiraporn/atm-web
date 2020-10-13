package th.ac.ku.atm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atm.model.Customer;
import th.ac.ku.atm.service.BankAccountService;
import th.ac.ku.atm.service.CustomerService;

@Controller
@RequestMapping("/login")
public class LoginController {

    private CustomerService customerService;
    private BankAccountService bankAccountService;

    public LoginController(CustomerService customerService, BankAccountService bankAccountService) {
        this.customerService = customerService;
        this.bankAccountService = bankAccountService;
    }

    @GetMapping
    public String getLoginPage() {
        return "login";
    }

    @PostMapping
    public String login(@ModelAttribute Customer customer, Model model) {
        // 1. check to see if id and pin matched customer info
        Customer matchingCustomer = customerService.checkPin(customer);

        // 2. if match, welcome user
        if (matchingCustomer != null) {
            model.addAttribute("customertitle", matchingCustomer.getName() + " Bank Accounts");
            model.addAttribute("bankaccounts", bankAccountService.getCustomerBankAccounts(customer.getId()));

            return "customeraccount";
        } else {
            // 3. not match, display that customer info is incorrection
            model.addAttribute("greeting", "Can't find customer");
            return "home";
        }

    }
}
