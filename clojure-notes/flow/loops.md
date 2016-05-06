Clojure Loops
------------------

* [Loops](https://programming-pages.com/2012/01/23/loops-in-clojure/)

Recursion is the preferred approach, ``loop`` can be used to re-perform evaluation
Here ``index`` is assigned the value 10 and the second argument a ``statement`` is evaluated
The ``recur`` function causes the second argument to be evaluated again with ``index`` set to ``(- index 1)``
When ``(= index 0)`` the recursion stops and the value of ``index`` in this case ``0`` is returned

```clojure
(loop [index 10] ; initialize the recursion index == 10
  (if (= index 0) ; base case index == 0
    index ; base case return value
    (do ;perform in sequence
      (prn index)  ; we can perform a side effect
      (recur (- index 1))))) ; recurse into loop with new value for index
10
9
8
7
6
5
4
3
2
1
0
```
