package edu.umss.storeservice.devbootstrap;

import edu.umss.storeservice.model.Bill;
import edu.umss.storeservice.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.List;

public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private BillRepository billRepository;

    public DevBootstrap(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        List<Bill> billList = billRepository.findAll();

        Bill billItem = billRepository.findById(1L);
        billItem.getBillCode();

        Boolean isDeleted = billRepository.deleteById(3L);
        if(isDeleted){
            System.out.println("DELETE");
        }
    }
}
