(ns google-maps.core-test
  (:require [clojure.test :refer :all]
            [google-maps.core :refer :all]))

(deftest t-address->coordinates
  (testing "FIXME, address->coordinates fails: "
    (let [context (make-context (System/getenv "GOOGLE_MAPS_API_KEY"))
          address (address->coordinates context "15 Broad Street, New York, NY 10005, USA")]
      (is (= (:lat address ) 40.7064181) "lat")
      (is (= (:lng address) -74.01062480000002) "lng")
      (is (= (:address address) "15 Broad St, New York, NY 10005, USA") "address")
      (is (= (:city address) "New York") "city")
      (is (= (:country address) "United States") "country"))))

(deftest t-coordinates->address
  (testing "FIXME, coordinates->address fails: "
    (let [context (make-context (System/getenv "GOOGLE_MAPS_API_KEY"))
          address (coordinates->address context 40.706795 -74.0104803)]
      (is (= (:address address) "15 Broad Street, New York, NY 10005, USA") "address")
      (is (= (:city address) "New York") "city")
      (is (= (:country address) "United States") "country"))))

(deftest t-distance
  (testing "FIXME, coordinates->address fails: "
    (let [context (make-context (System/getenv "GOOGLE_MAPS_API_KEY"))
          distance (distance context
                             "15 Broad Street, New York, NY 10005, USA"
                             "23 Wall St, New York, NY 10005, USA")]

      (is (= 191 (:distance distance)) "distance")
      (is (= 72 (:duration distance)) "duration"))))




