(ns todo.core-test
  (:require [clojure.test :refer :all]
            [todo.core :refer :all]))

(deftest adder-test
  (testing "adder"
    (is (= (adder 4 5) 9))))

(deftest only-numbers-test
  (testing "only-numbers"
  	(is (= (only-numbers ["1" "c" "4"]) [1 4] ))
  	(is (= (only-numbers ["1" "c" "4"]) [1 4] ))
  	(is (= (only-numbers [1]) [1] ))
  	(is (= (only-numbers ["x" "y" "z"]) [] ))
	(is (= (only-numbers []) [] ))))

(deftest parse-string-test
  (testing "parse-string"
  	(is (= (parse-string 1) 1 ))
  	(is (= (parse-string "") 0 ))
	(is (= (parse-string "1") 1 ))))
