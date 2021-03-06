(ns string-utils.core
  (:require [inflections.core :as i]))


; Pluralize ---------------------------------
; https://github.com/r0man/inflections-clj

(defn pluralize []
  ; "1 dog"
  (println (i/pluralize 1 "dog"))

  ; "3 dogs"
  (println (i/pluralize 3 "dog"))

  ; "1 box"
  (println (i/pluralize 1 "box" "boxen"))

  ; "4 boxen"
  (println (i/pluralize 4 "box" "boxen"))
)




; Tableify ---------------------------------
(defn tableify
  "Create a string formatted as a 3 column table from a sequence"
  [row]
  (apply format "%-20s | %-20s | %-20s" row))

(def header ["First name" "Last name" "Year of Birth"])
(def people [["Ada" "Lovelace" 1815]
              ["Haskell" "Curry" 1900]
              ["Fred" "Brooks" 1931]])


(defn output-table []
  (->> (concat [header] people)
       (map tableify)
       (mapv println)))

; First name           |            Last name |        Year of Birth
; Ada                  |             Lovelace |                 1815
; Haskell              |                Curry |                 1900
; Fred                 |               Brooks |                 1931
