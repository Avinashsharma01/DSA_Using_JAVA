# ⚡ DSA Quick Reference Card

> **Quick lookup for time complexities, formulas, and patterns**

---

## ⏱️ Time Complexity Cheat Sheet

### Common Complexities (Best to Worst)
```
O(1)         - Constant        - Array access, Hash lookup
O(log n)     - Logarithmic     - Binary Search
O(n)         - Linear          - Linear Search, Single loop
O(n log n)   - Linearithmic    - Merge Sort, Quick Sort (avg)
O(n²)        - Quadratic       - Bubble Sort, Nested loops
O(n³)        - Cubic           - Triple nested loops
O(2^n)       - Exponential     - Recursive Fibonacci
O(n!)        - Factorial       - Permutations
```

### Quick Identification
- **Single loop** → O(n)
- **Nested loops** → O(n²)
- **Dividing problem in half** → O(log n)
- **Loop + divide** → O(n log n)
- **Recursive calls with 2 branches** → O(2^n)

---

## 📋 Data Structure Operations

| Structure | Access | Search | Insert | Delete | Space |
|-----------|--------|--------|--------|--------|-------|
| Array | O(1) | O(n) | O(n) | O(n) | O(n) |
| Linked List | O(n) | O(n) | O(1)* | O(1)* | O(n) |
| Stack | O(n) | O(n) | O(1) | O(1) | O(n) |
| Queue | O(n) | O(n) | O(1) | O(1) | O(n) |
| Binary Search Tree | O(log n) | O(log n) | O(log n) | O(log n) | O(n) |
| Hash Table | - | O(1) | O(1) | O(1) | O(n) |

*At given position

---

## 🔍 Algorithm Templates

### Binary Search Template
```java
int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2; // Avoid overflow
        
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    
    return -1; // Not found
}
```

### Two Pointer Template
```java
void twoPointer(int[] arr) {
    int left = 0, right = arr.length - 1;
    
    while (left < right) {
        // Process
        if (condition) {
            left++;
        } else {
            right--;
        }
    }
}
```

### Sliding Window Template
```java
int slidingWindow(int[] arr, int k) {
    int windowSum = 0, maxSum = 0;
    
    // Initial window
    for (int i = 0; i < k; i++) {
        windowSum += arr[i];
    }
    maxSum = windowSum;
    
    // Slide window
    for (int i = k; i < arr.length; i++) {
        windowSum += arr[i] - arr[i - k];
        maxSum = Math.max(maxSum, windowSum);
    }
    
    return maxSum;
}
```

### Recursion Template
```java
returnType recursiveFunction(parameters) {
    // Base case
    if (baseCondition) {
        return baseValue;
    }
    
    // Recursive case
    // 1. Do some work
    // 2. Make recursive call with smaller problem
    // 3. Combine results
    
    return recursiveFunction(smallerProblem);
}
```

### Merge Sort Template
```java
void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        
        mergeSort(arr, left, mid);      // Sort left half
        mergeSort(arr, mid + 1, right); // Sort right half
        merge(arr, left, mid, right);   // Merge sorted halves
    }
}
```

### Quick Sort Template
```java
void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        
        quickSort(arr, low, pi - 1);  // Before partition
        quickSort(arr, pi + 1, high); // After partition
    }
}
```

---

## 🧮 Important Formulas

### Mathematics
- **Sum of first n numbers**: `n * (n + 1) / 2`
- **Sum of squares**: `n * (n + 1) * (2n + 1) / 6`
- **Power of 2**: `2^n = 1 << n`
- **Check power of 2**: `n & (n-1) == 0`
- **XOR properties**: `a ^ a = 0`, `a ^ 0 = a`

### Array
- **Kadane's Algorithm** (Max Subarray Sum):
  ```java
  int maxSum = arr[0], currentSum = arr[0];
  for (int i = 1; i < arr.length; i++) {
      currentSum = Math.max(arr[i], currentSum + arr[i]);
      maxSum = Math.max(maxSum, currentSum);
  }
  ```

### String
- **Number of substrings**: `n * (n + 1) / 2`
- **Number of subsequences**: `2^n`
- **Palindrome check**: Compare with reverse

---

## 🎯 Common Patterns

### 1. Two Pointer Pattern
**When to use:** Sorted array, palindrome, pair finding
```java
// Find pair with sum
while (left < right) {
    int sum = arr[left] + arr[right];
    if (sum == target) return true;
    else if (sum < target) left++;
    else right--;
}
```

### 2. Fast & Slow Pointer
**When to use:** Linked list cycles, middle element
```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
// slow is at middle
```

### 3. Sliding Window
**When to use:** Subarray/substring problems, consecutive elements
- Fixed size window
- Variable size window

### 4. Prefix Sum
**When to use:** Range sum queries
```java
prefix[i] = prefix[i-1] + arr[i];
rangeSum(l, r) = prefix[r] - prefix[l-1];
```

### 5. Divide and Conquer
**When to use:** Problem can be split into independent subproblems
- Merge Sort
- Quick Sort
- Binary Search

---

## 🐛 Edge Cases Checklist

Always test with:
- ✅ Empty input: `[]`, `null`, `""`
- ✅ Single element: `[1]`, `"a"`
- ✅ Two elements: `[1, 2]`
- ✅ All same elements: `[5, 5, 5, 5]`
- ✅ Sorted array: `[1, 2, 3, 4, 5]`
- ✅ Reverse sorted: `[5, 4, 3, 2, 1]`
- ✅ Negative numbers: `[-5, -3, -1]`
- ✅ Mixed positive/negative: `[-2, 0, 3]`
- ✅ Duplicates: `[1, 2, 2, 3]`
- ✅ Maximum values: `Integer.MAX_VALUE`

---

## 🔄 Common Loop Patterns

### Forward Loop
```java
for (int i = 0; i < n; i++) { }
```

### Reverse Loop
```java
for (int i = n - 1; i >= 0; i--) { }
```

### Nested Loop (All Pairs)
```java
for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
        // Process pair (i, j)
    }
}
```

### Sliding Window Loop
```java
for (int i = 0; i < n - k + 1; i++) {
    // Window from i to i+k-1
}
```

---

## 💾 Java-Specific Tips

### Array Initialization
```java
int[] arr = new int[n];              // All zeros
Arrays.fill(arr, -1);                // Fill with -1
int[] arr = {1, 2, 3};              // Direct init
```

### Array Utilities
```java
Arrays.sort(arr);                    // Sort ascending
Arrays.toString(arr);                // Print array
Arrays.copyOf(arr, newLength);       // Copy array
```

### String Methods
```java
s.length()                           // Length
s.charAt(i)                          // Character at index
s.substring(start, end)              // Substring [start, end)
s.equals(other)                      // Compare strings
```

### StringBuilder (Efficient String Building)
```java
StringBuilder sb = new StringBuilder();
sb.append("text");
sb.reverse();
String result = sb.toString();
```

### Integer Methods
```java
Integer.parseInt(str)                // String to int
String.valueOf(num)                  // Int to string
Math.max(a, b), Math.min(a, b)      // Min/Max
Math.abs(num)                        // Absolute value
```

---

## 🚀 Interview Problem-Solving Framework

### Step 1: Understand (2-3 minutes)
- Clarify inputs and outputs
- Ask about constraints
- Discuss edge cases

### Step 2: Examples (2-3 minutes)
- Walk through 2-3 examples
- Include edge cases
- Verify understanding

### Step 3: Approach (3-5 minutes)
- Start with brute force
- Identify bottlenecks
- Optimize using patterns
- Discuss time/space complexity

### Step 4: Code (15-20 minutes)
- Write clean, modular code
- Use meaningful variable names
- Add comments for complex logic

### Step 5: Test (3-5 minutes)
- Test with examples
- Check edge cases
- Walk through code line by line

### Step 6: Optimize (If time remains)
- Discuss improvements
- Reduce space/time complexity

---

## 📝 Code Quality Checklist

- [ ] Handles null/empty inputs
- [ ] No array index out of bounds
- [ ] No integer overflow
- [ ] Correct loop boundaries (off-by-one)
- [ ] Variables initialized properly
- [ ] Meaningful variable names
- [ ] Time complexity mentioned
- [ ] Space complexity mentioned

---

**Print this and keep it handy during revision! 📌**

