package leetCode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/4/25  23:14
 */
public class PascalTriangle_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList();
        int len = rowIndex;
        ans.add(1);
        for(int i=1;i<=len;i++)
        {
            double num = ans.get(i-1) * ((double)(len - i + 1) / i);
            ans.add((int)(Math.round(num)));
        }
        return ans;
    }
}
