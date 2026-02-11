 * Amazon web services stands as the leading cloud service provider globally offering a wide array of cloud computing services.
 * aws was started in 2006 with three core services: storage computing and messaging
 * aws is used by major companies like netflix
 * aws is known for its scalability, reliability, and extensive feature set.
 * aws continuously enhanced its network by providing a broad range of services, involving based on market trends.

## what is difference between an AWS Region and availability zone (AZ), and how do they work together?
an aws region is separate geographical area , isolated from others for reliability. an availability zone (AZ) is distinct data center within a region with independent power and networking.
AZs are connected via low latency, high throughput networks. deploying resources across multiple AZs in a region ensures high availability and fault tolerance in case one AZ fails.

## Explain the aws shared responsibility model.
* aws shared responsibility model devices security duties between aws and the customer. AWS secures the infrastructure hardware, software and data centers while customers manage data, access and application security.
* Responsibility vary by service type:
  * IaaS: customer manges OS and data.
  * PaaS: AWS manages the platform; customers handle data.
  * SaaS/Serverless : customer focus on code and permissions.

## What is an EC2 instance, and what are the factors you consider when chossing an instance tyhpe?
* ec2 instance is a virtual server in aws that provides scalable computing power with complete control over the operating system and software. pick instance types based on workload needs: compute memory and storage.