Good — this is **exactly the right time** to learn `StringBuilder`.
If you’re doing DSA and *not* using it properly, your code will be slower **even if your logic is correct**. That’s not opinion, that’s fact.

I’ll be **precise, practical, and DSA-oriented**. No fluff.

---

# 🧱 StringBuilder in Java — DSA-Focused Mastery

## 1️⃣ Why `StringBuilder` exists (core reason)

### The problem with `String`

* `String` is **immutable**
* Every modification creates a **new object**
* Repeated changes → **O(n²)** time

### What `StringBuilder` fixes

* **Mutable**
* Same object is modified
* Operations are **amortized O(1)**

📌 **DSA rule (non-negotiable):**

> If a string changes inside a loop → use `StringBuilder`.

---

## 2️⃣ How StringBuilder works (mental model)

Think of `StringBuilder` as:

```
Resizable char array
```

* Initial capacity (default): 16
* Grows automatically when needed
* No new object per append

---

## 3️⃣ Creating a StringBuilder

```java
StringBuilder sb = new StringBuilder();
```

With initial string:

```java
StringBuilder sb = new StringBuilder("abc");
```

With capacity (performance optimisation):

```java
StringBuilder sb = new StringBuilder(100);
```

📌 DSA note:
Pre-allocating capacity avoids resizing → faster for large inputs.

---

## 4️⃣ MOST USED & NECESSARY METHODS (YOU MUST KNOW THESE)

I’m listing **only what matters in DSA**.

---

### 🔹 `append()`  ⭐⭐⭐ (MOST IMPORTANT)

```java
sb.append("abc");
sb.append('x');
sb.append(10);
```

✔️ Works with any datatype
✔️ Returns same `StringBuilder`

Time: **O(1) amortized**

---

### 🔹 `toString()`  ⭐⭐⭐

```java
String result = sb.toString();
```

📌 Final step in almost every problem.

---

### 🔹 `charAt(int index)`

```java
char c = sb.charAt(2);
```

Time: **O(1)**

Used when reading/modifying characters.

---

### 🔹 `setCharAt(int index, char ch)`

```java
sb.setCharAt(1, 'z');
```

📌 VERY useful in in-place modifications.

---

### 🔹 `length()`

```java
int len = sb.length();
```

Same as `String.length()`.

---

### 🔹 `deleteCharAt(int index)`

```java
sb.deleteCharAt(3);
```

Time: **O(n)**
(Shifts characters left)

Used in:

* Remove character
* Backtracking problems

---

### 🔹 `delete(int start, int end)`

```java
sb.delete(2, 5); // end is exclusive
```

Common in:

* Removing substrings
* Cleaning sequences

---

### 🔹 `insert(int index, char / String)`

```java
sb.insert(1, 'x');
sb.insert(2, "abc");
```

Time: **O(n)**
(Shifts right)

---

### 🔹 `reverse()` ⭐⭐⭐

```java
sb.reverse();
```

📌 Common interview trick:

* Reverse words
* Palindrome generation

---

## 5️⃣ Methods you should KNOW but use less

### 🔸 `capacity()`

```java
sb.capacity();
```

Mostly for performance tuning — not logic.

---

### 🔸 `ensureCapacity(int min)`

```java
sb.ensureCapacity(200);
```

Rare, but useful for large constraints.

---

### 🔸 `substring(int start, int end)`

```java
sb.substring(1, 4);
```

⚠️ Returns **String**, not `StringBuilder`

---

## 6️⃣ Methods you should AVOID / be careful with

❌ `equals()`

```java
sb1.equals(sb2); // compares reference, NOT content
```

✅ Correct:

```java
sb1.toString().equals(sb2.toString());
```

---

## 7️⃣ StringBuilder vs StringBuffer (DSA verdict)

| Feature     | StringBuilder | StringBuffer |
| ----------- | ------------- | ------------ |
| Thread-safe | ❌             | ✅            |
| Speed       | 🚀 Fast       | 🐢 Slow      |
| DSA use     | ✅ YES         | ❌ NO         |

📌 **Never use StringBuffer in DSA**

---

## 8️⃣ Common DSA Patterns Using StringBuilder

### 🔹 Build string in loop (CORRECT WAY)

```java
StringBuilder sb = new StringBuilder();
for(char c : arr){
    sb.append(c);
}
return sb.toString();
```

---

### 🔹 In-place removal

```java
for(int i = 0; i < sb.length(); i++){
    if(sb.charAt(i) == 'a'){
        sb.deleteCharAt(i);
        i--; // IMPORTANT
    }
}
```

---

### 🔹 Reverse words

```java
StringBuilder sb = new StringBuilder(word);
sb.reverse();
```

---

## 9️⃣ Time Complexity Truth Table

| Operation       | Time           |
| --------------- | -------------- |
| append          | O(1) amortized |
| charAt          | O(1)           |
| setCharAt       | O(1)           |
| delete / insert | O(n)           |
| reverse         | O(n)           |

---

## 🔥 Brutal Reality Check

If you:
❌ use `String` in loops
❌ concatenate with `+`
❌ ignore capacity

Then your:

* Logic may be correct
* **But solution will TLE**

That’s why good DSA coders **default to StringBuilder**.

---

## What should we do next?

Pick **ONE**:
1️⃣ Solve **5 StringBuilder-based LeetCode problems** (with code)
2️⃣ Sliding Window + StringBuilder combo
3️⃣ Backtracking problems using StringBuilder
4️⃣ Common StringBuilder mistakes in interviews

Say the number — we go deeper 👊
