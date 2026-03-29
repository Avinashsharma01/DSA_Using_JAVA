Good question — this is a **very common point of confusion** when learning linked lists 👍
Let’s go step-by-step and clear it properly.

---

## First, understand what `temp` really is

```java
Node temp = n1;
```

* `temp` is a **reference** to a `Node`
* It **never becomes a Node with `null` data**
* It either:

    * points to a valid `Node` object, or
    * becomes `null` (meaning it points to nothing)

---

## Structure of your linked list

Your list looks like this in memory:

```
temp → [1 | next] → [2 | next] → [3 | next] → [4 | next] → [5 | null]
```

Key point:

* **The last node (`5`) is NOT null**
* Only its `next` is `null`

---

## The `while (temp != null)` loop

```java
while (temp != null) {
    System.out.println(temp.data);
    temp = temp.next;
}
```

Let’s trace it **line by line**.

---

## Iteration-by-iteration explanation

### 🔹 Iteration 1

```
temp → Node(1)
```

* `temp != null` ✅
* Print `1`
* Move: `temp = temp.next` → Node(2)

---

### 🔹 Iteration 2

```
temp → Node(2)
```

* `temp != null` ✅
* Print `2`
* Move → Node(3)

---

### 🔹 Iteration 3

```
temp → Node(3)
```

* Print `3`
* Move → Node(4)

---

### 🔹 Iteration 4

```
temp → Node(4)
```

* Print `4`
* Move → Node(5)

---

### 🔹 Iteration 5 (IMPORTANT)

```
temp → Node(5)
```

* `temp != null` ✅
* Print `5`
* Move: `temp = temp.next`
* Since `Node(5).next == null`, now:

```
temp → null
```

---

### 🔹 Iteration 6 (Loop ends)

```
temp == null
```

* Condition fails ❌
* Loop stops

---

## 🔥 CRUCIAL CONCEPT (This is the answer to your doubt)

> **The last node is printed because `temp` is NOT null when it points to the last node.**

* The loop checks **`temp`**
* NOT `temp.next`

So:

* Last node: `temp → Node(5)` → printed ✔
* After that: `temp = null` → loop stops ✔

---

## Why not use `temp.next != null`?

If you wrote:

```java
while (temp.next != null) {
    System.out.println(temp.data);
    temp = temp.next;
}
```

Output would be:

```
1
2
3
4
```

❌ `5` would NOT print
Because when `temp` is Node(5), `temp.next == null`

---

## Final one-line explanation

> **The loop prints the last node because the last node itself is not null — only its `next` is null.**

---

If you want, I can also explain:

* Linked list diagram in memory
* Difference between `temp` and `temp.next`
* Why this pattern is used in interviews

Just tell me 👍
