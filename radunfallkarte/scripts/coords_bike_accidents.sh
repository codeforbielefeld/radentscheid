#!/bin/bash

# coords_bike_accidents.sh
# Tries to fetch geo-coordinates of bike accidents based on the street information.  
#
# Requires the command line json processor 'jq' in the path.
#
# usage: ./coords_bike_accidents.sh <accidents.csv>

# VUDBielefeld2018_01bis12.csv
filename=$1
nominatim_url="https://nominatim.openstreetmap.org"
curl_options="-s"

accidents=$(cat $filename | grep -e ';71$' -e ';71;' -e ';72$' -e ';72;')

echo "["
while IFS= read -r accident; do
      vu_date=$(echo $accident | cut -f1 -d\;)
      vu_time=$(echo $accident | cut -f2 -d\;)
      street1=$(echo $accident | cut -f3 -d\;)
      street2=$(echo $accident | cut -f4 -d\;)
      streetNr=$(echo $accident | cut -f5 -d\;)

      param_q="q=$street1 $street2 $streetNr,Bielefeld,Germany"
      param_format="format=json"

      # TODO nominatim is unable to handle intersections of two streets 
      forward=$(curl $curl_options -G --data-urlencode "q=$street1 $street2 $streetNr,Bielefeld,Germany" --data-urlencode "format=json" $nominatim_url/search/)

      lat_str=$(echo $forward | jq '.[0].lat')
      lon_str=$(echo $forward | jq '.[0].lon')
      lat=${lat_str//\"}
      lon=${lon_str//\"}

      reverse=$(curl $curl_options -G --data-urlencode "lat=$lat" --data-urlencode "lon=$lon" --data-urlencode "format=json" --data-urlencode "zoom=17" --data-urlencode "addressdetails=1" $nominatim_url/reverse/)

      street_lat_str=$(echo $reverse | jq '.lat')
      street_lon_str=$(echo $reverse | jq '.lon')
      street_lat=${street_lat_str//\"}
      street_lon=${street_lon_str//\"}

      printf ' { "lat": %s, "lng": %s, "msg": "Unfall vom %s", "id": 42 },\n' $street_lat $street_lon $vu_date

      sleep 1

   done <<< "$accidents"
echo "]"


