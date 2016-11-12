(ns google-maps.core
   (:require [clojure.walk :refer [keywordize-keys]])
   (:import [com.google.maps GeoApiContext
                             GeocodingApi
                             DistanceMatrixApi]
            [com.google.maps.model
                             LatLng]))

(defn make-context [api-key]
  (doto (GeoApiContext.)
    (.setApiKey api-key)))

(defn latlng [{:keys [lat lng]}]
  (LatLng. lat lng))

(defn address->coordinates [context p]
  (let [r (first (. (GeocodingApi/geocode context p) await ))
        n (->> (. r addressComponents)
               (map #(hash-map (.toString (first (.types %))) (.longName %)))
               (apply conj)
               keywordize-keys)]
    {:lat (-> r
              .geometry
              .location
              .lat)
     :lng (-> r
              .geometry
              .location
              .lng)
     :address (-> r .formattedAddress)
     :city (:locality n)
     :country (:country n)}))

(defn coordinates->address [context latlng]
  (let [r (first (. (GeocodingApi/reverseGeocode
                     context
                     latlng) await   ))
        n (->> (. r addressComponents)
               (map #(hash-map (.toString (first (.types %))) (.longName %)))
               (apply conj)
               keywordize-keys)]
     {:address (-> r
                   .formattedAddress)
      :city (:locality n)
      :country (:country n)}))

(defn distance [context {:keys [a1 a2]}]
  (let [r (. (DistanceMatrixApi/getDistanceMatrix
              context
              (into-array [a1])
              (into-array [a2])) await)]
    {:distance (-> r
                   .rows
                   first
                   .elements
                   first
                   .distance
                   .inMeters)
     :duration (-> r
                   .rows
                   first
                   .elements
                   first
                   .duration
                   .inSeconds)}))
