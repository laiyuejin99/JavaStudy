package part1;

import java.util.ArrayList;
import java.util.List;

public class FruitMatch {
    //    刚做了Amazon的OA，其中一题不知道是不是社招OA的新题，发帖来回馈地里，攒RP。
//
//    这个题说了一个情景，给定几个水果的组合，水果的组合和给组合的顺序都需要遵循的，然后客户的购物车里也有买商品的顺序，然后看客户买的物品清单是否能和给定的组合对上。其中，如果组合中出现了“anything"这个字符串，表示客户可以买任何东西match。
//            .本文原创自1point3acres论坛
//    例如组合为[[apple, apple], [banana, anything, banana]]，那么如果客户买了[orange, apple, apple, banana, orange, banana]，或者[apple, apple, orange, orange, banana, apple, banana, banana]都算match上了
//            默认的两个test case是
//1. 组合[[orange], [apple, apple], [banana, orange, apple], [banana]]，购物清单是[orange, apple, apple, banana, orange, apple, banana]，应该返回match.1point3acres网
//2. 组合[[apple, apricot], [banana, anything, guava], [papaya, anything]]，购物清单是[banana, orange, guava, apple, apricot,papaya, kiwi]就不match，因为第一组apple和apricot应该在最前面
    public boolean Match(List<List<String>> codeList, List<String> shoppingCart) {
        int index = -1;
        for (int i = 0; i < codeList.size(); i++) {
            List<String> list = codeList.get(i);
            for (int j = 0; j < list.size(); j++) {//get code string
                String currentStr = list.get(j);
                while (index < shoppingCart.size()) {
                    index++;
                    if (currentStr.equals("anything")) {
                        break;
                    } else if (index == shoppingCart.size()) {
                        break;
                    } else if (shoppingCart.get(index).equals(currentStr)) {
                        if (i == codeList.size() - 1 && j == list.size() - 1)
                            return true;
                        break;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        List<List<String>> codeList = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add("orange");
        codeList.add(temp);
        temp = new ArrayList<>();
        temp.add("apple");
        temp.add("apple");
        codeList.add(temp);
        temp = new ArrayList<>();
        temp.add("banana");
        temp.add("anything");
        temp.add("banana");
        codeList.add(temp);
        //[orange, apple, apple, banana, orange, banana]
        List<String> shopCart = new ArrayList<>();
        shopCart.add("orange");
        shopCart.add("apple");
        shopCart.add("apple");
        shopCart.add("banana");
        shopCart.add("orange");
        shopCart.add("banana");
        System.out.println(new FruitMatch().Match(codeList, shopCart));

    }

}
