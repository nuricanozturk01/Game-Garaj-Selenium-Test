package Constants;

import java.util.ArrayList;
import java.util.Arrays;

public final class Utility
{
    public static boolean isSortedMinToMax(ArrayList<Double> prices)
    {
        for (int i = 0; i < prices.size() - 1; ++i)
            if (prices.get(i) > prices.get(i + 1))
                return false;
        return true;
    }

    public static boolean isSortedMaxToMin(ArrayList<Double> prices)
    {
        for (int i = 0; i < prices.size() - 1; ++i)
            if (prices.get(i) < prices.get(i + 1))
                return false;
        return true;
    }

}


