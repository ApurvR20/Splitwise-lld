package main.java.splitwise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class EqualSplit extends SplitStrategy {

    @Override 
    Map split(double amount, List<String> participants){

        int countOfParticipants = participants.size();
        double share = amount / countOfParticipants;

        Map<String, Double> shareMap = new LinkedHashMap<String,Double>();

        for(String s : participants.keySet()){
            shareMap.put(s,share);
        }

        if(share * countOfParticipants < amount){
            Map.Entry<String,String> entry = map.entrySet().iterator().next();
            String firstKey= entry.getKey();
            first += (amount - (share*countOfParticipants));
        }

        return shareMap;
    }    
} 
