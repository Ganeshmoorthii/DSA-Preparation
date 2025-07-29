// 1. Using Built-in Methods (Trim + Split + Reverse)
public String reverseWords(String s) {
    String[] words = s.trim().split("\\s+");
    Collections.reverse(Arrays.asList(words));
    return String.join(" ", words);
}

// 2. Using Manual Reverse and Word Building
public String reverseWords(String s) {
    StringBuilder sb = new StringBuilder();
    int i = s.length() - 1;

    while (i >= 0) {
        while (i >= 0 && s.charAt(i) == ' ') i--;
        if (i < 0) break;
        int j = i;
        while (i >= 0 && s.charAt(i) != ' ') i--;
        sb.append(s.substring(i + 1, j + 1)).append(" ");
    }

    return sb.toString().trim();
}

// 3. Using Deque (Double-Ended Queue)
public String reverseWords(String s) {
    Deque<String> stack = new ArrayDeque<>();
    String[] words = s.trim().split("\\s+");

    for (String word : words) {
        stack.addFirst(word);
    }

    return String.join(" ", stack);
}

// 4. Using StringTokenizer
public String reverseWords(String s) {
    StringTokenizer st = new StringTokenizer(s);
    StringBuilder sb = new StringBuilder();

    while (st.hasMoreTokens()) {
        sb.insert(0, st.nextToken() + " ");
    }

    return sb.toString().trim();
}

// 5. Two-Pointer Approach (In-Place if Needed)
public String reverseWords(String s) {
    s = s.trim();
    List<String> list = new ArrayList<>();
    int i = 0, n = s.length();

    while (i < n) {
        if (s.charAt(i) == ' ') {
            i++;
            continue;
        }
        int j = i;
        while (j < n && s.charAt(j) != ' ') j++;
        list.add(s.substring(i, j));
        i = j;
    }

    Collections.reverse(list);
    return String.join(" ", list);
}
