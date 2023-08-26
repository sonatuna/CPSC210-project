# CPSC 210 PROJECT

## Bubble Tea Ordering App

My project is a system that acts as an online bubble tea ordering app, which is used by both customers and store
managers. Customers can order one drink at a time, which they pick from a menu then customize it to their preferences
and add to order. Once they check out, an order with the customer's name and all wtih drinks and its specifications,
as well as total price.

I chose this idea because I think owning a small business is interesting.
I really enjoyed playing Papa's Freezeria growing up, which was a game about
managing a milkshake shop and the player has to meet the customers' custom orders.
While this application may not have the features to pay with actual money
yet and cannot be used in real life, it provides a crucial framework that allows
important features like this to be developed later on. If I were ever to own
my own bubble tea shop, I could use this application that I developed myself.

## User Stories

- As a user, I want to create a new order with a user input name associated with it
- As a user, I want to be able to add new drinks to my order, and have the price reflected as a total
- As a user, I want to be able to pick a drink from a menu which is added to my order, and able to customize its
  specifications such as sugar level, ice level, size and toppings through user input
- As a user, I want to be able to add as many toppings as I want
- As a user, I want to be able to add as many drinks as I want
- As a user, I want to checkout my order when I'm done, and see all drinks I have ordered, as well as total price

- As a user, I want to have an option to to save my order to file and quit
- As a use, I want to have an option to resume my order from file when I reload the program

citations:
code references JsonSerializationDemo - WorkroomApp.java

## Instructions for grader:

You can enter your name as prompted, click "new order" and a new order window will show up.

- You can generate the first required action related to adding Xs to a Y by clicking the button "new drink" and
  selecting one of the options. By doing so, you are adding "drinks" to ""order
- You can generate the second required action related to adding Xs to a Y by continuing with your drink order and
  choosing one of the customization options, such as "Add Toppings" or "Adjust Ice"
- You can locate my visual component when a new order window pops up, it displays an image of a bubble tea
- You can save the state of my application by clicking save in the new order window
- You can reload the state of my application by going to the default window and pressing "Open" on the menu bar,
  then entering the name of an existing order

## Phase 4: Task 2

Wed Aug 09 11:09:50 PDT 2023
New order created.
Wed Aug 09 11:09:53 PDT 2023
Drink added to order.
Wed Aug 09 11:09:55 PDT 2023
Sugar level changed.
Wed Aug 09 11:09:56 PDT 2023
Ice level changed.
Wed Aug 09 11:09:58 PDT 2023
Cup size changed.
Wed Aug 09 11:09:59 PDT 2023
Ice level changed.
Wed Aug 09 11:10:01 PDT 2023
Topping added.
Wed Aug 09 11:10:04 PDT 2023
Drink added to order.
Wed Aug 09 11:10:06 PDT 2023
Ice level changed.
Wed Aug 09 11:10:10 PDT 2023
Ice level changed.
Wed Aug 09 11:10:21 PDT 2023
Order saved to file.
Wed Aug 09 11:10:29 PDT 2023
Order loaded from file.

## Phase 4: Task 3

First of all, I would refactor my UI in a way so that there are distinct classes for each aspect of the GUI instead of
having two main classes that represent each window. I would also instantiate more java swing components locally, then
override the action listener within that method, so I don't have so many fields sitting at the top. This improves
readability and cohesion.

Additionally, I would also like to extract the functionality of many similar methods to reduce duplication and also
improve readability, like sugarActions, iceActions, and cupActions in my UI. Moreover, I should reduce coupling in my
ui by having a class that represents the state and orchestrates the JFrames so that they operate independently of each
other. Additionally, I can make order a singleton and only have once instance of it throughout the whole program to
control access and ensure there is a single point of coordination.
