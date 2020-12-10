/**
* 题目：给定一段代码内容,判断() [] {} 三种括号是否配对。 
* 配对是当出现某一个类型的右括号时，上一个出现的括号是与之对应类型的左括号，配对可任意叠加，任意嵌套。比如({abc;})为配对，（{a)} 为不配对。
* 能配对打印Yes，不能配对打印No。
*/
public class BracketPair {
    public static void main(String[] args) {
        String content = "int main(String[] args) { abc(anything); }";

        System.out.println(judgeBracketPair(content) ? "Yes" : "No");
    }

    public static boolean judgeBracketPair(String str) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(map.containsValue(c)) {
                stack.push(c);
            }

            if(map.containsKey(c)) {
                if(stack.empty() || !map.get(c).equals(stack.pop())) {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
