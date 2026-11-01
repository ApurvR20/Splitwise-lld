package main.java.splitwise;

import java.util.List;
import java.util.Map;

/**
 * SplitStrategy
 */
public interface SplitStrategy {

    Map split(double amount, List<String> participants);
}