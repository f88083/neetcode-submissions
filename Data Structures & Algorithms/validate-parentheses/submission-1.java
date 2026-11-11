class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty()){
                return false;
            } else {
                char top = stack.pop();
                switch (c){
                    case ')':
                        if (top != '(') return false;
                        break;
                    case '}':
                        if (top != '{') return false;
                        break;
                    case ']':
                        if (top != '[') return false;
                        break;
                }
            }

        }
        return stack.isEmpty();
    }
}
