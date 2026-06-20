# InventoryManagement

Ideal Architecture:
Main

Controller
-------
OrderController

Services
--------
OrderService
InventoryService

Repositories
------------
OrderRepository
ProductRepository
UserRepository

Models
------
Product
Cart
CartItem
Order
User

Enums
-----
OrderStatus



Order Flow:
User
 ↓

Cart
 ↓

OrderService.placeOrder()

 ↓

InventoryService.checkAvailability()

 ↓

InventoryService.reduceStock()

 ↓

OrderRepository.save()

 ↓

return Order
