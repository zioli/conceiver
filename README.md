**Introduction**</BR>
The price resource was created to help users place their products price according to the published products under that category

- GET Method

**Sintaxe** </BR>
```
/categories/:ID:/prices 
```
where</BR>
**:ID:** </BR> 
Category code, for example MLA5725. For more information [see here](https://api.mercadolibre.com/sites/MLA/categories).
</BR>
</BR>
**Call**   
```
   curl -X GET http://zioli.us-east-2.elasticbeanstalk.com/categories/MLA5726/prices
```
   
**Response in case of success**
```json
{
  "max": 1111111111,
  "min": 1,
  "suggested": 555555556
}
```
</BR> 

**Response fields**

| field  | description |
| ------------- | ------------- |
| min  | Lower price set for the products under that category  |
| max  | Higher price set for the products under that category  |
| suggested  | Suggested price  |

**Response in case of fail**

```json
{
  "status": 404,
  "code": 9103,
  "message": "It was not found any item for the category",
  "link": "https://github.com/zioli/conceiver/blob/master/README.md",
  "detail": "It was not found any item for the category[MLA4444]"
}
```

**Response fields** 

| field  | description |
| ------------- | ------------- |
| status  | HTTP Code - In case of application fail, it will return 404  |
| code  | Application error code  |
| message  | Short description of the error  |
| detail  | Detailes description of the problem. It may help the developer or ourselves |


</BR> 

- OPTION Method

Sintaxe
```    
    http://zioli.us-east-2.elasticbeanstalk.com/categories/:ID:/prices
```
where 
    **:ID:** </BR>
    Category code, for examplo MLA 5725. For more information [see here](https://api.mercadolibre.com/sites/MLA/categories)
</BR>
</BR>
**Call**  
```
   curl -X OPTION http://zioli.us-east-2.elasticbeanstalk.com/categories/MLA5726/prices
```

**Response in case of success**
```json
{
    "name": "/categories/:ID:/prices",
    "description": "It returns a price sugestion for the category (:ID:). It is based on its lower and higher price.",
    "methods": [
        {
            "method": "GET",
            "uri": "/categories/:ID:/prices",
            "description": "It gonna get the lower price, higher price and suggested price for a category.",
            "example": "/categories/MLA5726/prices",
            "answer": "{\"lower\" : 1, \"higher\" : 5, \"suggeste\" : 4 }"
        },
        {
            "method": "OPTION",
            "description": "A little help about the resource",
            "example": "/categories/MLA5726/prices",
            "answer": "json with a little help"
        }
    ],
    "references": [
        "https://api.mercadolibre.com/sites/MLA/categories",
        "https://developers.mercadolibre.com/en_us/items-and-searches",
        "https://developers.mercadolibre.com/en_us/api-docs"
    ],
    "answer_in_case_of_error": {
        "status": -1,
        "code": -1,
        "message": "Responde in case of error",
        "details": "For more information see the ling below",
        "link": "https://github.com/zioli/conceiver/blob/master/README.md"
    }
}
```


    