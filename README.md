# google-maps

A Clojure library designed to operate Google Maps API through official SDK

## Usage

```
    [lowl4tency/google-maps "0.1.0-SNAPSHOT"]

    => (require '[google-maps.core :as m])
    => (m/defkey "API-KEY")
    => (m/address->coordinates "New York, 5 avenue 15")
       Nov 11, 2016 2:07:29 AM com.google.maps.GeoApiContext setQueryRateLimit
       INFO: Configuring rate limit at QPS: 10, minimum delay 50ms between requests
       Nov 11, 2016 2:07:29 AM com.google.maps.GeoApiContext getWithPath

       {:lat 40.73256, :lng -73.99612929999999, :address "15 5th Ave, New York, NY 10011, USA", :city "New York", :country "United States"}

    => (m/coordinates->address 40.73256 -73.99612929999999)
       Nov 11, 2016 2:09:09 AM com.google.maps.GeoApiContext setQueryRateLimit
       INFO: Configuring rate limit at QPS: 10, minimum delay 50ms between requests
       Nov 11, 2016 2:09:09 AM com.google.maps.GeoApiContext getWithPath

       {:address "19 5th Ave, New York, NY 10003, USA", :city "New York", :country "United States"}

    => (m/distance "New York Wall Street 15" "Chickago 1 street 24")
       Nov 11, 2016 2:11:25 AM com.google.maps.GeoApiContext setQueryRateLimit
       INFO: Configuring rate limit at QPS: 10, minimum delay 50ms between requests
       Nov 11, 2016 2:11:25 AM com.google.maps.GeoApiContext getWithPath

       {:distance 1318640, :duration 44661}
```

## License

Copyright © 2016 8ll

Distributed under the MIT License either version 1.0 or (at
your option) any later version.
