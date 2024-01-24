#!/usr/bin/bash

base_url="http://localhost:8080/customer/api/v1/customer/"
echo "Please enter id:"
read id
resource_url="${base_url}${id}"

echo "service base url: $base_url"
echo "retrieving customer details with id: $id"
echo "calling service with url: $resource_url"

response=$(curl -s "$resource_url")

# Display the response
echo "Customer response: $response"

echo "press any key and hit enter to exit"
read data_input