##Database

CREATE TABLE `employees` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `age` varchar(11) DEFAULT NULL,
  `department` varchar(50) DEFAULT NULL,
  `salary` varchar(50) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

##Sample Spec Api

Method : POST 
URL : 0.0.0.0:8001/insert_employee

Req : 

{
    "name" : "budi",
    "age"  : "28",
    "department" : "HR",
    "salary" : "10000"
}

Resp : 

{
    "RC": "00",
    "RD": "SUCCESS"
}


Method : PUT 
URL : 0.0.0.0:8001/employee/4

Req : 

{
    "name" : "budi",
    "age"  : "28",
    "department" : "HR",
    "salary" : "10000"
}

Resp :

{
    "RC": "00",
    "RD": "SUCCESS"
}

Method : POST 
URL : 0.0.0.0:8001/list_employee

Req : 
{}

Resp :
{
    "RC": "00",
    "RD": "SUCCESS",
    "Data": [
        {
            "employee_id": 1,
            "name": "Andi",
            "age": "25",
            "department": "IT",
            "salary": "6000.00",
            "created_date": "2025-09-19T07:21:59.000+00:00",
            "update_date": null
        },
        {
            "employee_id": 2,
            "name": "Budi",
            "age": "32",
            "department": "HR",
            "salary": "4000.00",
            "created_date": "2025-09-19T07:22:03.000+00:00",
            "update_date": null
        },
        {
            "employee_id": 3,
            "name": "Citra",
            "age": "45",
            "department": "Finance",
            "salary": "8500.00",
            "created_date": "2025-09-19T07:22:05.000+00:00",
            "update_date": null
        },
        {
            "employee_id": 4,
            "name": "budi",
            "age": "28",
            "department": "HR",
            "salary": "10000",
            "created_date": "2025-09-19T07:22:08.000+00:00",
            "update_date": "2025-09-19T10:40:31.000+00:00"
        }
    ]
}

Method : DELETE 
URL : 0.0.0.0:8001/employee/6

Resp :

{
    "RC": "00",
    "RD": "SUCCESS"
}

Method : GET 
URL : 0.0.0.0:8001/employee/4

Resp :

{
    "RC": "00",
    "RD": "SUCCESS",
    "Data": {
        "employee_id": 4,
        "name": "budi",
        "age": "28",
        "department": "HR",
        "salary": "10000",
        "created_date": "2025-09-19T07:22:08.000+00:00",
        "update_date": "2025-09-19T10:40:31.000+00:00"
    }
}

Method : GET 
URL : 0.0.0.0:8001/employee/search?name=niki

Resp :

{
    "RC": "00",
    "RD": "SUCCESS",
    "Data": {
        "id": 7,
        "name": "niki",
        "age": "28",
        "department": "HR",
        "salary": "10000",
        "createdDate": "2025-09-20T18:09:45",
        "updateDate": "2025-09-20T18:09:45"
    }
}




