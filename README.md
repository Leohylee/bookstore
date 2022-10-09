# Book Store REST API Application

## API Calls (http://localhost:8080)

### Book (/book):

* GET (/all): to get all the books from table
* GET (/isbn/{isbn}): to get book by isbn
* GET (/title/{title}): to get book by title
* GET (/author): to get book by author (RequestParam: firstName=John&lastName=Doe)
* GET (/publisher/{publisher}): to get book by publisher
* PUT (/authorId/{authorId}/publlisherId/{publisherId}): to create book with book information + author + publisher (RequestBody: {"title": "ABC", "isbn": "1234567898765", "publishDate": "2000/01/23"})
* POST (/{id}): to update information of book (RequestBody: {"title": "ABC", "isbn": "1234567898765", "publishDate": "2000/01/23"})
* DELETE (/{id}): to delete a book record

### Author (/author):

* GET (/all): to get all the authors from table
* GET (/{id}): to get author by id
* GET (/name): to get author by firstName + lastName (RequestParam: firstName=John&lastName=Doe)
* PUT: to create new Author record: (RequestBody: {"firstName": "John", "lastName": "Doe"})
* POST (/{id}): to update Author information: (RequestBody: {"firstName": "John", "lastName": "Doe"})
* DELETE (/{id}): to delete an author record

### Publisher (/publisher):

* GET (/all): to get all publishers
* GET (/{id}): to get publisher by id
* PUT: to create a new publisher (RequestBody: {"name": "Penguin"})
* POST (/{id}): to update publisher information (RequestBody: {"name": "Penguin"})
* DELETE (/{id}): to delete a publisher record

### StockLevel (/stocklevel):

* GET (/all): to get all stock level status (RequestParam: qty=100)
* GET (/{bookId}): to get stock level status by book id
* POST (/{id}): to update stock level status by stock id

### Transaction (/transaction):

* GET: to get all transaction record
* PUT: to make a purchase action, it can be a book or a group of books 
  (RequestBody: [{"customerName": "John Doe", "bookId": 4, "qty": 10}, {"customerName": "John Doe", "bookId": 2, "qty": 5}])

## Test Demonstration

### Author

* PUT: ![img.png](demonstration/author_create.png) ![img_1.png](demonstration/author_all.png)
* GET (/all): ![img_1.png](demonstration/author_all.png)
* GET (/{id}): ![img.png](demonstration/author_id.png)
* GET (/name): ![img_1.png](demonstration/author_name.png)
* POST (/{id}): ![img.png](demonstration/author_update.png) ![img_1.png](demonstration/author_all2.png)
* DELETE (/{id}): ![img.png](demonstration/author_delete.png)

### Book

* GET (/all): ![img.png](demonstration/book_all.png)
* GET (/isbn/{isbn}): ![img.png](demonstration/book_isbn.png)
* GET (/title/{title}): ![img.png](demonstration/book_title.png)
* GET (/author): ![img.png](demonstration/book_author.png)
* GET (/publisher/{publisher}): ![img.png](demonstration/book_publisher.png)
* PUT (/authorId/{authorId}/publlisherId/{publisherId}):![img.png](demonstration/book_create.png) ![img.png](demonstration/book_all2.png)
* POST (/{id}): ![img.png](demonstration/book_update.png)
* DELETE (/{id}): ![img.png](demonstration/book_delete.png) ![img.png](demonstration/book_all3.png)

### Publisher:

* GET (/all): ![img.png](demonstration/publisher_all.png)
* GET (/{id}): ![img.png](demonstration/publisher_id.png)
* PUT: ![img.png](demonstration/publisher_create.png)
* POST (/{id}): ![img.png](demonstration/publisher_update.png) ![img.png](demonstration/publisher_all2.png)
* DELETE (/{id}): ![img.png](demonstration/publisher_delete.png)

### StockLevel:

* POST (/{id}): ![img.png](demonstration/stock_update.png)
* GET (/all): ![img.png](demonstration/stock_all.png)
* GET (/{bookId}): ![img.png](demonstration/stocklevel_bookid.png)

### Transaction (/transaction):

* PUT: ![img.png](demonstration/transaction.png)
* GET: ![img.png](demonstration/transaction_all.png)

* Stock level changed after transaction:
* ![img.png](demonstration/transaction_stock.png)

## Error Message

* Missing Request Body Property: ![img.png](demonstration/error_property.png)
* Missing Request Param: ![img.png](demonstration/error_param.png)
* Required Entity Cannot be Found: ![img.png](demonstration/error_entity.png)
* Calling Non-existent Methods: ![img.png](demonstration/error_method.png)