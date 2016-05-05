(ns todo.core
  (:gen-class)
  (:require [clojure.string :refer [blank?]]))

(defn parse-string 
    "Parse strings to number"
    [x]
    (if (string? x) 
    	(if (blank? x) 
    	    0 
    	    (read-string x))
    	x))

(defn only-numbers
	"extract numbers from inputs"
	[inputs]
	(filter number? (keep parse-string inputs))
	)

(defn adder 
	"Add the numbers"
	[& numbers] 
	(apply + numbers))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Total of args = " (apply adder (only-numbers args))))
