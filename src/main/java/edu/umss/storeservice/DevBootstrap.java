/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice;

import edu.umss.storeservice.service.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private CategoryService categoryService;
    private ContractService contractService;
    private EmployeeService employeeService;
    private ExpenseService expenseService;
    private FeatureInstanceService featureInstanceService;
    private FeatureService featureService;
    private ItemInstanceService itemInstanceService;
    private ItemService itemService;
    private PositionService positionService;
    private SaleService saleService;
    private SubCategoryService subCategoryService;

    public DevBootstrap(CategoryService categoryService, ContractService contractService,
            EmployeeService employeeService, ExpenseService expenseService,
            FeatureInstanceService featureInstanceService, FeatureService featureService,
            ItemInstanceService itemInstanceService, ItemService itemService, PositionService positionService,
            SaleService saleService, SubCategoryService subCategoryService) {
        this.categoryService = categoryService;
        this.contractService = contractService;
        this.employeeService = employeeService;
        this.expenseService = expenseService;
        this.featureInstanceService = featureInstanceService;
        this.featureService = featureService;
        this.itemInstanceService = itemInstanceService;
        this.itemService = itemService;
        this.positionService = positionService;
        this.saleService = saleService;
        this.subCategoryService = subCategoryService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

    }
}
