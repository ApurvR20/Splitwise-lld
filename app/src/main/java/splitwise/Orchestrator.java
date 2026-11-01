package main.java.splitwise;

import java.util.List;
import java.util.Map;

import main.java.splitwise.User.StrategyEnum;

public class Orchestrator {
    
    StrategyEnum strategy;
    List<User> participants;
    private Map<String, Double> specificAmts;

    Orchestrator(){
        
    }

    void receiveExpense(Expense expense){
        strategy = expense.getStrategy();
        participants = expense.getParticipants();
        amount = expense.getAmt();
        specificAmts = expense.getSpecificAmts();
    }

    Map splitAmount(double amount){
        if(strategy == EQUAL){
            return new EqualSplit(amount,participants);
        }

        return new UnequalSplit(amount,participants,specificAmts);
    }

    void sendBillstoAll(double amount){

        Map shareMap = splitAmount(amount);

        for(User p : participants){
            p.receiveBill(createBill(p.getName(),p.getEmail(), shareMap.get(p.getName())));
        }
    }
}
