package main.java.splitwise;

import java.util.List;
import java.util.Map;

class Expense {

    private double amt;
    private List<User> participants;
    private Map<String, Double> specificAmts;
    private SplitStrategy strategy;

    Expense(double amt, List<User> participants, Map<String,Double> specificAmts, SplitStrategy strategy){
        this.amt = amt;
        this.participants = participants;
        this.specificAmts = specificAmts;
        this.strategy = strategy;
    }

    double getAmt(){
        return amt;
    }

    List<User> getParticipants(){
        return participants;
    }

    Map<String, Double> getSpecificAmts(){
        return specificAmts;
    }

    SplitStrategy getStrategy(){
        return strategy;
    }

}