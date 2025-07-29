// 1. Stack-Based Approach
public String removeOuterParentheses(String s) {
    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();

    for (char c : s.toCharArray()) {
        if (c == '(') {
            if (!stack.isEmpty()) sb.append(c);
            stack.push(c);
        } else {
            stack.pop();
            if (!stack.isEmpty()) sb.append(c);
        }
    }

    return sb.toString();
}

// 2. Count of Open Parentheses
public String removeOuterParentheses(String s) {
    StringBuilder sb = new StringBuilder();
    int open = 0;

    for (char c : s.toCharArray()) {
        if (c == '(') {
            if (open > 0) sb.append(c);
            open++;
        } else {
            open--;
            if (open > 0) sb.append(c);
        }
    }

    return sb.toString();
}

// 3. Two-Pointer + Primitive Block Tracker
public String removeOuterParentheses(String s) {
    StringBuilder sb = new StringBuilder();
    int start = 0, count = 0;

    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') count++;
        else count--;

        if (count == 0) {
            sb.append(s.substring(start + 1, i));
            start = i + 1;
        }
    }

    return sb.toString();
}

// 4. Recursion
public String removeOuterParentheses(String s) {
    if (s.isEmpty()) return "";

    int count = 0;
    for (int i = 0; i < s.length(); i++) {
        count += s.charAt(i) == '(' ? 1 : -1;
        if (count == 0) {
            return s.substring(1, i) + removeOuterParentheses(s.substring(i + 1));
        }
    }

    return "";
}

// 5. Manual Stack with Index Tracking
public String removeOuterParentheses(String s) {
    StringBuilder res = new StringBuilder();
    int start = 0;
    int depth = 0;

    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') {
            if (depth++ == 0) start = i;
        } else {
            if (--depth == 0) {
                res.append(s.substring(start + 1, i));
            }
        }
    }

    return res.toString();
}
