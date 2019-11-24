package 左程云;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 牛客网的输入工具类
 *
 * @author 张亚飞
 * @create 2019-11-19 10:40
 **/
public class InputUtil {
    public static List<Integer> readIntLine(Scanner input){
        String line = input.nextLine();
        String[] vals = line.split(" ");
        List<Integer> res = Arrays.stream(vals).map(Integer::valueOf).collect(Collectors.toList());
        return res;
    }

    public static List<List<Integer>> readIntLines(Scanner scanner){
        List<List<Integer>> res = new ArrayList<>();
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] vals = line.split(" ");
            List<Integer> intLine = Arrays.stream(vals).map(Integer::valueOf).collect(Collectors.toList());
            res.add(intLine);
        }
        return res;
    }

    public static Scanner  getScaner(){
        return new Scanner(System.in);
    }


    public static void main(String[] args) {
        Scanner scanner = InputUtil.getScaner();
        List<Integer> line1 = readIntLine(scanner);
        List<Integer> line2 = readIntLine(scanner);
        scanner.close();

        System.out.println(line1);
        System.out.println(line2);




    }

}
