
Java 8 needed to run this code.

Dropwizard is an open source Java framework for developing REST APIs.


Libraries using from Dropwizard:

1. * [Jetty](http://www.eclipse.org/jetty/) for serving an HTTP server inside this project'.
2. * [Jersey](http://jersey.java.net/) for developing RESTful Web Services in Java'.
3. * [Jackson](https://github.com/FasterXML/jackson) for objects to/from JSON conversion'.

Using Hibernate features for the database.

# Running The Application

To test the application run the following commands.

* To package the example run.

        mvn package

* To setup the h2 database run.

		java -jar target/CabServicePortal-1.0.5.jar db migrate example.yml

* To run the server run.

		java -jar target/CabServicePortal-1.0.5.jar server example.yml


 CURLS :


 CREATE:
1.

curl -X POST \
    http://localhost:9080/product/create \
    -H 'Accept: */*' \
    -H 'Accept-Encoding: gzip, deflate' \
    -H 'Cache-Control: no-cache' \
    -H 'Connection: keep-alive' \
    -H 'Content-Length: 534' \
    -H 'Content-Type: application/json' \
    -H 'Host: localhost:9080' \
    -H 'Postman-Token: dd16aa3a-fda8-47ed-b849-282fdf4594c4,1feaeadc-76a1-4201-96a2-e2ae2d59b6db' \
    -H 'User-Agent: PostmanRuntime/7.15.2' \
    -H 'cache-control: no-cache' \
    -d '{

    "department": "Home",
    "current_price": "50.63",
    "company": "Huels, Hartmann and Koelpin",
    "product_title": "PORTTITOR",
    "product_subtitle": "evolve clicks-and-mortar e-services",
    "product_description": "morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci",
    "attributes": "Cloned holistic Graphic Interface",
    "lifecycle_start": "6/9/2015",
    "lifecycle_end": "3/14/2029",
    "isbn": "848289027-1",
    "color": "Turquoise",
    "active": true,
    "like_products": [

    ]
  }
  '

2.

curl -X POST \
    http://localhost:9080/product/create \
    -H 'Accept: */*' \
    -H 'Accept-Encoding: gzip, deflate' \
    -H 'Cache-Control: no-cache' \
    -H 'Connection: keep-alive' \
    -H 'Content-Length: 534' \
    -H 'Content-Type: application/json' \
    -H 'Host: localhost:9080' \
    -H 'Postman-Token: dd16aa3a-fda8-47ed-b849-282fdf4594c4,1feaeadc-76a1-4201-96a2-e2ae2d59b6db' \
    -H 'User-Agent: PostmanRuntime/7.15.2' \
    -H 'cache-control: no-cache' \
    -d '{

    "department": "Home",
    "current_price": "50.63",
    "company": "Huels, Hartmann and Koelpin",
    "product_title": "PORTTITOR",
    "product_subtitle": "evolve clicks-and-mortar e-services",
    "product_description": "morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci",
    "attributes": "Cloned holistic Graphic Interface",
    "lifecycle_start": "6/9/2015",
    "lifecycle_end": "3/14/2029",
    "isbn": "848289027-1",
    "color": "Turquoise",
    "active": true,
    "like_products": [

    ]
  }
  '

  3.

  curl -X POST \
      http://localhost:9080/product/create \
      -H 'Accept: */*' \
      -H 'Cache-Control: no-cache' \
      -H 'Connection: keep-alive' \
      -H 'Content-Type: application/json' \
      -H 'Host: localhost:9080' \
      -H 'Postman-Token: 6c886bb4-90c2-4818-bb9e-663a7f552f31,e6f03628-1ec0-4017-864f-4cb48b1a708f,4aef89d8-b490-486a-a614-f70e635e1110' \
      -H 'User-Agent: PostmanRuntime/7.15.0' \
      -H 'accept-encoding: gzip, deflate' \
      -H 'cache-control: no-cache,no-cache' \
      -H 'content-length: 533' \
      -d '{

      "department": "Home1",
      "current_price": "35.63",
      "company": "Huels, Hartmann and Koelpin",
      "product_title": "PORTTITOR",
      "product_subtitle": "evolve clicks-and-mortar e-services",
      "product_description": "morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci",
      "attributes": "Cloned holistic Graphic Interface",
      "lifecycle_start": "6/9/2015",
      "lifecycle_end": "3/14/2029",
      "isbn": "848289027-1",
      "color": "Turquoise",
      "active": true,
      "like_products": [1

      ]
    }
    '

    4.

    curl -X POST \
        http://localhost:9080/product/create \
        -H 'Accept: */*' \
        -H 'Cache-Control: no-cache' \
        -H 'Connection: keep-alive' \
        -H 'Content-Type: application/json' \
        -H 'Host: localhost:9080' \
        -H 'Postman-Token: 6c886bb4-90c2-4818-bb9e-663a7f552f31,e6f03628-1ec0-4017-864f-4cb48b1a708f,4aef89d8-b490-486a-a614-f70e635e1110' \
        -H 'User-Agent: PostmanRuntime/7.15.0' \
        -H 'accept-encoding: gzip, deflate' \
        -H 'cache-control: no-cache,no-cache' \
        -H 'content-length: 533' \
        -d '{

        "department": "Home1",
        "current_price": "35.63",
        "company": "Huels, Hartmann and Koelpin",
        "product_title": "PORTTITOR",
        "product_subtitle": "evolve clicks-and-mortar e-services",
        "product_description": "morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci",
        "attributes": "Cloned holistic Graphic Interface",
        "lifecycle_start": "6/9/2015",
        "lifecycle_end": "3/14/2029",
        "isbn": "848289027-1",
        "color": "Turquoise",
        "active": true,
        "like_products": [1

        ]
      }
      '



      FETCH :

      curl -X GET \
        http://localhost:9080/product/fetch/2 \
        -H 'Accept: */*' \
        -H 'Accept-Encoding: gzip, deflate' \
        -H 'Cache-Control: no-cache' \
        -H 'Connection: keep-alive' \
        -H 'Host: localhost:9080' \
        -H 'Postman-Token: f978f5cd-1e44-459f-ab15-ff988901e6df,c43e50a2-219a-441e-a687-511d35c6b38e' \
        -H 'User-Agent: PostmanRuntime/7.15.2' \
        -H 'cache-control: no-cache'


      UPDATE:
      curl -X PUT \
        http://localhost:9080/product/update \
        -H 'Accept: */*' \
        -H 'Accept-Encoding: gzip, deflate' \
        -H 'Cache-Control: no-cache' \
        -H 'Connection: keep-alive' \
        -H 'Content-Length: 548' \
        -H 'Content-Type: application/json' \
        -H 'Host: localhost:9080' \
        -H 'Postman-Token: e3496bdc-2b1b-4639-984c-0690b22a9e3e,b53a7716-60ed-4767-90ca-f93e4a3423de' \
        -H 'User-Agent: PostmanRuntime/7.15.2' \
        -H 'authentification_header: nadbku4543wa343j4bjbj4343bb3=' \
        -H 'cache-control: no-cache' \
        -d '{
          "attributes": "Cloned holistic Graphic Interface",
          "department": "Home",
          "product_id": 1,
          "color": "Turq",
          "isbn": "848289027-1",
          "like_products": [],
          "active": true,
          "product_title": "PORTTITOR",
          "product_subtitle": "evolve clicks-and-mortar e-services",
          "lifecycle_start": "06/09/2015",
          "lifecycle_end": "03/14/2029",
          "company": "Huels, Hartmann and Koelpin",
          "current_price": 8.63,
          "product_description": "morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci"
      }'

      DELETE :

      curl -X DELETE \
        http://localhost:9080/product/delete/2 \
        -H 'Accept: */*' \
        -H 'Accept-Encoding: gzip, deflate' \
        -H 'Cache-Control: no-cache' \
        -H 'Connection: keep-alive' \
        -H 'Content-Length: ' \
        -H 'Host: localhost:9080' \
        -H 'Postman-Token: 899475ea-1386-43f8-b87b-efb004e1933f,e27e122c-369b-4788-b453-5ade8cbed931' \
        -H 'User-Agent: PostmanRuntime/7.15.2' \
        -H 'authentification_header: nadbku4543wa343j4bjbj4343bb3=' \
        -H 'cache-control: no-cache'


   SEARCH :

   1.department


   curl -X GET \
     http://localhost:9080/product/search/department/Home1 \
     -H 'Accept: */*' \
     -H 'Accept-Encoding: gzip, deflate' \
     -H 'Cache-Control: no-cache' \
     -H 'Connection: keep-alive' \
     -H 'Host: localhost:9080' \
     -H 'Postman-Token: 03218202-d73b-4857-8095-3e4fac192e86,2e9ffab0-6ac3-46f1-89e4-37652b55436f' \
     -H 'User-Agent: PostmanRuntime/7.15.2' \
     -H 'authentification_header: nadbku4543wa343j4bjbj4343bb3=' \
     -H 'cache-control: no-cache'

    2.product_title

    curl -X GET \
      http://localhost:9080/product/search/productTitle/PORTTITOR \
      -H 'Accept: */*' \
      -H 'Accept-Encoding: gzip, deflate' \
      -H 'Cache-Control: no-cache' \
      -H 'Connection: keep-alive' \
      -H 'Host: localhost:9080' \
      -H 'Postman-Token: e9c60110-ff39-4ad4-baf6-a29e78640bee,6cd3724a-d6c6-472d-a6cc-cb4f0b13df7b' \
      -H 'User-Agent: PostmanRuntime/7.15.2' \
      -H 'authentification_header: nadbku4543wa343j4bjbj4343bb3=' \
      -H 'cache-control: no-cache'



    3.company

    curl -X GET \
      'http://localhost:9080/product/search/company/Huels,%20Hartmann%20and%20Koelpin' \
      -H 'Accept: */*' \
      -H 'Accept-Encoding: gzip, deflate' \
      -H 'Cache-Control: no-cache' \
      -H 'Connection: keep-alive' \
      -H 'Host: localhost:9080' \
      -H 'Postman-Token: f5676695-16e5-4af6-91f6-5102dffc1fe5,b3486462-08dc-48da-af96-2a320ae52277' \
      -H 'User-Agent: PostmanRuntime/7.15.2' \
      -H 'authentification_header: nadbku4543wa343j4bjbj4343bb3=' \
      -H 'cache-control: no-cache'


   Cart API – (/carts)

   curl -X POST \
     http://localhost:9080/carts \
     -H 'Accept: */*' \
     -H 'Accept-Encoding: gzip, deflate' \
     -H 'Cache-Control: no-cache' \
     -H 'Connection: keep-alive' \
     -H 'Content-Length: 172' \
     -H 'Content-Type: application/json' \
     -H 'Host: localhost:9080' \
     -H 'Postman-Token: 15f11e31-ce6f-4a7a-a547-a1124b3ff76e,6d40eb70-7cca-4441-adf4-61d43cd6db88' \
     -H 'User-Agent: PostmanRuntime/7.15.2' \
     -H 'cache-control: no-cache' \
     -d '{
     "item_list": [
        {
            "product_id":1,
            "quantity":11
         } ,
         {
            "product_id":3,
            "quantity":4
         }
      ]
   }'