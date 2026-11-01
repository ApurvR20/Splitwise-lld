package main.java.splitwise;

import java.util.Map;

public class UnequalSplit extends SplitStrategy {

    @Override 
    Map split(double amount, List<User> participants, Map<String,Double> specificAmts){

        Map<String, Double> shareMap = new LinkedHashMap<String,Double>();

        double values = 0;
        double share;
        for(Double amt : specificAmts.values()){
            values += amt;
        }

        if(amt != amount){
            throw new Exception("Wrong shares entered");
        }

        for(String s : specificAmts.keySet()){
            shareMap.put(s,specificAmts.get(s));
            amount -= specificAmts.get(s);
        }

        if(amount > 0.0){

            share = amount / (participants.size() - specificAmts.size());
            for(String s : participants.keySet()){
                if(shareMap.containsKey(s)){
                    continue;
                }

                shareMap.put(participants,share);
            }
        }

        return shareMap;
    }
}
