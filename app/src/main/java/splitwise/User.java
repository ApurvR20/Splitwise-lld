package main.java.splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    /**
     * InnerUser
     */
    public enum StrategyEnum {
    EQUAL,
    UNEQUAL;        
    }
    
    private String name;
    private String id;
    private String email;
    private Map<String, Double> account;
    private Orchestrator orc;
    private Map<String,Expense> expenseList;
    private Map<String,Bill> billList;

    User(String name, String id, String email, Orchestrator orc){
        this.name = name;
        this.id = id;
        this.email = email;
        account = new HashMap<>();
        this.orc = orc;
        expenseList = new ArrayList<>();
        billList = new HashMap<>();
    }

    String getName(){
        return name;
    }

    String getEmail(){
        return email;
    }

    Map getDebt(){
        return account;
    }

    void addNewDebt(String id, double share){
        account.put(id,share);
    }

    Expense createExpense(double amt, List<User> participants, Map<String,Double> specificAmts, StrategyEnum strategy){

        SplitStrategy strategyObj;
        if(strategy == EQUAL){
            strategyObj = EQUAL;
        } else {
            strategyObj = UNEQUAL;
        }

        Expense newExpense = new Expense(amt, participants, specificAmts, strategy);
        return newExpense;
    }

    void sendExpense(Expense expense){
        orc.receiveExpense(expense);
    }

    void receiveBill(Bill bill){
        billList.put(bill.get(email),bill);
    }

    void clearBill(String email){
        billList.remove(email);
    }
}
