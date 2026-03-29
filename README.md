# 📚 Data Structures & Algorithms in Java - Complete Cheatsheet

## 📋 Table of Contents
1. [Arrays](#arrays)
2. [Searching Algorithms](#searching-algorithms)
3. [Sorting Algorithms](#sorting-algorithms)
4. [Recursion](#recursion)
5. [Linked Lists](#linked-lists)
6. [Stacks](#stacks)
7. [Queues](#queues)
8. [String Algorithms](#string-algorithms)
9. [Object-Oriented Programming](#object-oriented-programming)
10. [Exception Handling](#exception-handling)
11. [Pattern Printing](#pattern-printing)
12. [Time & Space Complexity](#time--space-complexity)

---

## 🔢 Arrays

### Basic Operations
| Operation | Time Complexity | Space Complexity | Implementation |
|-----------|----------------|------------------|----------------|
| Access | O(1) | O(1) | `arr[index]` |
| Search (Linear) | O(n) | O(1) | Loop through array |
| Search (Binary) | O(log n) | O(1) | Divide and conquer |
| Insert at end | O(1) | O(1) | `arr[size++] = value` |
| Insert at middle | O(n) | O(1) | Shift elements |
| Delete | O(n) | O(1) | Shift elements |

### Key Array Problems
- **Array Manipulation**: Basic insertion, deletion, traversal
- **Largest Element**: Find maximum element in array
- **Array Reversal**: Reverse array in-place
- **Subarray Sum**: Maximum subarray sum (Kadane's algorithm)
- **Pairs in Array**: Find pairs with given sum
- **Prefix Sum**: Precompute sums for range queries

### Important Patterns
```java
// Two Pointer Technique
int left = 0, right = arr.length - 1;
while (left < right) {
    // Process elements
    left++; right--;
}

// Sliding Window
int windowSum = 0;
for (int i = 0; i < windowSize; i++) {
    windowSum += arr[i];
}
```

---

## 🔍 Searching Algorithms

| Algorithm | Time Complexity | Space Complexity | Prerequisites |
|-----------|----------------|------------------|---------------|
| **Linear Search** | O(n) | O(1) | None |
| **Binary Search** | O(log n) | O(1) | Sorted array |
| **Order Agnostic BS** | O(log n) | O(1) | Sorted (asc/desc) |

### Binary Search Template
```java
public static int binarySearch(int[] arr, int target) {
    int start = 0, end = arr.length - 1;
    
    while (start <= end) {
        int mid = start + (end - start) / 2;
        
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) start = mid + 1;
        else end = mid - 1;
    }
    return -1;
}
```

---

## 🔄 Sorting Algorithms

| Algorithm | Best | Average | Worst | Space | Stable | In-Place |
|-----------|------|---------|-------|-------|--------|----------|
| **Bubble Sort** | O(n) | O(n²) | O(n²) | O(1) | ✅ | ✅ |
| **Selection Sort** | O(n²) | O(n²) | O(n²) | O(1) | ❌ | ✅ |
| **Insertion Sort** | O(n) | O(n²) | O(n²) | O(1) | ✅ | ✅ |
| **Merge Sort** | O(n log n) | O(n log n) | O(n log n) | O(n) | ✅ | ❌ |
| **Quick Sort** | O(n log n) | O(n log n) | O(n²) | O(log n) | ❌ | ✅ |

### Quick Sort Implementation
```java
public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}
```

---

## 🔄 Recursion

### Key Concepts
- **Base Case**: Condition to stop recursion
- **Recursive Case**: Function calls itself with modified parameters
- **Stack Space**: O(depth) space complexity due to call stack

### Common Recursive Problems
- **Factorial**: `n! = n × (n-1)!`
- **Fibonacci**: `fib(n) = fib(n-1) + fib(n-2)`
- **Array Operations**: Check sorted, find occurrences
- **Tree Traversals**: Inorder, preorder, postorder

### Recursion Template
```java
public returnType recursiveFunction(parameters) {
    // Base case
    if (baseCondition) {
        return baseValue;
    }
    
    // Recursive case
    return recursiveFunction(modifiedParameters);
}
```

---

## 🔗 Linked Lists

### Types & Operations
| Operation | Singly Linked | Doubly Linked | Circular |
|-----------|---------------|---------------|----------|
| Insert at head | O(1) | O(1) | O(1) |
| Insert at tail | O(n) / O(1)* | O(1) | O(1) |
| Delete by value | O(n) | O(n) | O(n) |
| Search | O(n) | O(n) | O(n) |

*O(1) if tail pointer maintained

### Basic Node Structure
```java
class ListNode {
    int data;
    ListNode next;
    
    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
```

---

## 📚 Stacks

### Operations & Complexity
| Operation | Time Complexity | Description |
|-----------|----------------|-------------|
| Push | O(1) | Add element to top |
| Pop | O(1) | Remove top element |
| Peek/Top | O(1) | View top element |
| isEmpty | O(1) | Check if empty |

### Implementation Types
- **Array-based Stack**: Fixed size, simple implementation
- **Dynamic Stack**: Resizable array, handles overflow
- **Linked List Stack**: Dynamic size, no memory waste

### Common Applications
- Function call management
- Expression evaluation
- Parentheses matching
- Undo operations
- Browser history

---

## 🚶‍♂️ Queues

### Types & Properties
| Type | Front Operation | Rear Operation | Use Case |
|------|----------------|----------------|----------|
| **Simple Queue** | Dequeue O(1) | Enqueue O(1) | FIFO operations |
| **Circular Queue** | Dequeue O(1) | Enqueue O(1) | Memory efficient |
| **Dynamic Queue** | Dequeue O(1) | Enqueue O(1) | Variable size |

### Queue Operations
```java
// Basic queue operations
enqueue(item)  // Add to rear
dequeue()      // Remove from front
front()        // Peek front element
isEmpty()      // Check if empty
```

---

## 🔤 String Algorithms

### Key String Problems
- **Palindrome Check**: Compare string with its reverse
- **String Compression**: Remove consecutive duplicates
- **Lexicographical Comparison**: Dictionary ordering
- **Substring Operations**: Extract parts of string
- **Path Finding**: Navigate using direction strings

### String Manipulation Techniques
```java
// StringBuilder for efficient string building
StringBuilder sb = new StringBuilder();
sb.append("text");
String result = sb.toString();

// Character array manipulation
char[] chars = str.toCharArray();
```

---

## 🏗️ Object-Oriented Programming

### Core Concepts
1. **Encapsulation**: Data hiding using private fields
2. **Inheritance**: Class hierarchy and code reuse
3. **Polymorphism**: Method overriding and overloading
4. **Abstraction**: Abstract classes and interfaces

### Best Practices
- Use proper access modifiers
- Follow naming conventions
- Implement proper constructors
- Override toString(), equals(), hashCode()

---

## ⚠️ Exception Handling

### Exception Hierarchy
```
Throwable
├── Error (System errors)
└── Exception
    ├── RuntimeException (Unchecked)
    └── Other Exceptions (Checked)
```

### Try-Catch-Finally Structure
```java
try {
    // Risky code
} catch (SpecificException e) {
    // Handle specific exception
} catch (Exception e) {
    // Handle general exception
} finally {
    // Cleanup code (always executes)
}
```

---

## 📐 Pattern Printing

### Common Patterns
- **Triangle Patterns**: Right triangle, inverted triangle
- **Star Patterns**: Pyramid, diamond, hollow shapes
- **Number Patterns**: Pascal's triangle, number pyramids
- **Character Patterns**: Alphabetical designs

### Pattern Template
```java
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print("* ");
    }
    System.out.println();
}
```

---

## ⏱️ Time & Space Complexity

### Big O Notation (Best to Worst)
| Complexity | Name | Example |
|------------|------|---------|
| O(1) | Constant | Array access |
| O(log n) | Logarithmic | Binary search |
| O(n) | Linear | Linear search |
| O(n log n) | Linearithmic | Merge sort |
| O(n²) | Quadratic | Bubble sort |
| O(2ⁿ) | Exponential | Recursive Fibonacci |

### Space Complexity Considerations
- **Input Space**: Space taken by input
- **Auxiliary Space**: Extra space used by algorithm
- **Total Space**: Input space + Auxiliary space

---

## 📝 Quick Reference

### Problem-Solving Strategy
1. **Understand** the problem completely
2. **Plan** your approach (brute force → optimize)
3. **Code** the solution step by step
4. **Test** with edge cases
5. **Optimize** time and space complexity

### Common Edge Cases
- Empty arrays/strings
- Single element collections
- Null inputs
- Integer overflow
- Duplicate elements
- Negative numbers

### Useful Java Collections
```java
// Dynamic arrays
ArrayList<Integer> list = new ArrayList<>();

// Hash-based structures
HashMap<String, Integer> map = new HashMap<>();
HashSet<Integer> set = new HashSet<>();

// Sorted structures
TreeMap<String, Integer> treeMap = new TreeMap<>();
TreeSet<Integer> treeSet = new TreeSet<>();
```

---

## 🎯 Practice Tips

1. **Start Simple**: Master basic operations before complex algorithms
2. **Draw Diagrams**: Visualize data structures and algorithm flow
3. **Trace Execution**: Step through code with sample inputs
4. **Practice Regularly**: Consistency is key to mastery
5. **Understand Patterns**: Recognize common algorithmic patterns
6. **Optimize Gradually**: First make it work, then make it efficient

---

*Happy Coding! 🚀*
